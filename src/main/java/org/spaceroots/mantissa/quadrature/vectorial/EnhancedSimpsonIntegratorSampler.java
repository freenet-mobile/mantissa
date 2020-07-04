package org.spaceroots.mantissa.quadrature.vectorial;

import org.spaceroots.mantissa.functions.vectorial.*;
import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This class implements an enhanced Simpson integrator as a sample.

 * <p>A traditional Simpson integrator is based on a quadratic
 * approximation of the function on three equally spaced points. This
 * integrator does the same thing but can handle non-equally spaced
 * points. If it is used on a regular sample, it behaves exactly as a
 * traditional Simpson integrator.</p>

 * @see EnhancedSimpsonIntegrator

 * @version $Id: EnhancedSimpsonIntegratorSampler.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class EnhancedSimpsonIntegratorSampler
  implements SampledFunctionIterator {

  /** Underlying sample iterator. */
  private SampledFunctionIterator iter;

  /** Next point. */
  private VectorialValuedPair next;

  /** Current running sum. */
  private double[] sum;

  /** Constructor.
   * Build an integrator from an underlying sample iterator.
   * @param iter iterator over the base function
   */
  public EnhancedSimpsonIntegratorSampler(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    this.iter = iter;

    // get the first point
    next = iter.nextSamplePoint();

    // initialize the sum
    sum = new double[iter.getDimension()];
    for (int i = 0; i < sum.length; ++i) {
      sum[i] = 0.0;
    }

  }

  public boolean hasNext() {
    return iter.hasNext();
  }

  public int getDimension() {
    return iter.getDimension();
  }

  public VectorialValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {
    // performs one step of an enhanced Simpson scheme
    VectorialValuedPair previous = next;
    VectorialValuedPair current  = iter.nextSamplePoint();

    try {
      next = iter.nextSamplePoint();

      double h1 = current.x - previous.x;
      double h2 = next.x    - current.x;
      double cP = (h1 + h2) * (2 * h1 - h2) / (6 * h1);
      double cC = (h1 + h2) * (h1 + h2) * (h1 + h2) / (6 * h1 * h2);
      double cN = (h1 + h2) * (2 * h2 - h1) / (6 * h2);

      double[] pY = previous.y;
      double[] cY = current.y;
      double[] nY = next.y;
      for (int i = 0; i < sum.length; ++i) {
        sum [i] += cP * pY[i] + cC * cY[i] + cN * nY[i];
      }

    } catch(ExhaustedSampleException e) {
      // we have an incomplete step at the end of the sample
      // we use a trapezoid scheme for this last step
      double halfDx = 0.5 * (current.x - previous.x);
      double[] pY = previous.y;
      double[] cY = current.y;
      for (int i = 0; i < sum.length; ++i) {
        sum [i] += halfDx * (pY[i] + cY[i]);
      }
      return new VectorialValuedPair(current.x, sum);
    }

    return new VectorialValuedPair(next.x, (double[]) sum.clone());

  }

}
