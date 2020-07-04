package org.spaceroots.mantissa.fitting;

import java.io.Serializable;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.vectorial.SampledFunctionIterator;
import org.spaceroots.mantissa.functions.vectorial.VectorialValuedPair;

/** This class provides sampled values of the function t -> [f(t), f'(t)].

 * This class is a helper class used to compute a first guess of the
 * harmonic coefficients of a function <code>f (t) = a cos (omega t +
 * phi)</code>.

 * @see F2FP2Iterator
 * @see HarmonicCoefficientsGuesser

 * @version $Id: FFPIterator.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

class FFPIterator
  implements SampledFunctionIterator, Serializable {

  public FFPIterator(AbstractCurveFitter.FitMeasurement[] measurements) {
    this.measurements = measurements;

    // initialize the points of the raw sample
    current   = measurements[0];
    currentY  = current.getMeasuredValue();
    next      = measurements[1];
    nextY     = next.getMeasuredValue();
    nextIndex = 2;

  }

  public int getDimension() {
    return 2;
  }

  public boolean hasNext() {
    return nextIndex < measurements.length;
  }

  public VectorialValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {
    if (nextIndex >= measurements.length) {
      throw new ExhaustedSampleException(measurements.length);
    }

    // shift the points
    previous  = current;
    previousY = currentY;
    current   = next;
    currentY  = nextY;
    next      = measurements[nextIndex++];
    nextY     = next.getMeasuredValue();

    // return the two dimensions vector [f(x), f'(x)]
    double[] table = new double[2];
    table[0] = currentY;
    table[1] = (nextY - previousY) / (next.x - previous.x);
    return new VectorialValuedPair(current.x, table);

  }

  private AbstractCurveFitter.FitMeasurement[] measurements;
  private int nextIndex;

  private AbstractCurveFitter.FitMeasurement previous;
  private double previousY;

  private AbstractCurveFitter.FitMeasurement current;
  private double nextY;

  private AbstractCurveFitter.FitMeasurement next;
  private double currentY;

  private static final long serialVersionUID = -3187229691615380125L;

}
