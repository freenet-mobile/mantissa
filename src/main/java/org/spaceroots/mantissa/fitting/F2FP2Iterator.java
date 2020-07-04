package org.spaceroots.mantissa.fitting;

import java.io.Serializable;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.vectorial.SampledFunctionIterator;
import org.spaceroots.mantissa.functions.vectorial.VectorialValuedPair;

/** This class provides sampled values of the function t -> [f(t)^2, f'(t)^2].

 * This class is a helper class used to compute a first guess of the
 * harmonic coefficients of a function <code>f (t) = a cos (omega t +
 * phi)</code>.

 * @see FFPIterator
 * @see HarmonicCoefficientsGuesser

 * @version $Id: F2FP2Iterator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

class F2FP2Iterator
  implements SampledFunctionIterator, Serializable {

  public F2FP2Iterator(AbstractCurveFitter.FitMeasurement[] measurements) {
    ffpIterator = new FFPIterator(measurements);
  }

  public int getDimension() {
    return 2;
  }

  public boolean hasNext() {
    return ffpIterator.hasNext();
  }

  public VectorialValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {

    // get the raw values from the underlying FFPIterator
    VectorialValuedPair point = ffpIterator.nextSamplePoint();
    double[] y = point.y;

    // square the values
    return new VectorialValuedPair(point.x,
                                   new double[] {
                                     y[0] * y[0], y[1] * y[1]             
                                   });

  }

  private FFPIterator ffpIterator;

  private static final long serialVersionUID = -8113110433795298072L;

}
