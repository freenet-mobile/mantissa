package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.scalar.*;
import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This class implements an enhanced Simpson integrator as a sample.

 * <p>A traditional Simpson integrator is based on a quadratic
 * approximation of the function on three equally spaced points. This
 * integrator does the same thing but can handle non-equally spaced
 * points. If it is used on a regular sample, it behaves exactly as a
 * traditional Simpson integrator.</p>

 * @see EnhancedSimpsonIntegrator

 * @version $Id: EnhancedSimpsonIntegratorSampler.java 1237 2002-03-20 21:01:57Z luc $
 * @author L. Maisonobe

 */

public class EnhancedSimpsonIntegratorSampler
  implements SampledFunctionIterator {

  /** Underlying sampled function iterator. */
  private SampledFunctionIterator iter;

  /** Next point. */
  private ScalarValuedPair next;

  /** Current running sum. */
  private double sum;

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
    sum = 0.0;

  }

  public boolean hasNext() {
    return iter.hasNext();
  }

  public ScalarValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {
    // performs one step of an enhanced Simpson scheme
    ScalarValuedPair previous = next;
    ScalarValuedPair current  = iter.nextSamplePoint();

    try {
      next = iter.nextSamplePoint();

      double h1 = current.getX() - previous.getX();
      double h2 = next.getX()    - current.getX();
      double cP = (h1 + h2) * (2 * h1 - h2) / (6 * h1);
      double cC = (h1 + h2) * (h1 + h2) * (h1 + h2) / (6 * h1 * h2);
      double cN = (h1 + h2) * (2 * h2 - h1) / (6 * h2);

      sum += cP * previous.getY() + cC * current.getY() + cN * next.getY();

    } catch(ExhaustedSampleException e) {
      // we have an incomplete step at the end of the sample
      // we use a trapezoid scheme for this last step
      sum += 0.5 * (current.getX() - previous.getX()) * (previous.getY() + current.getY());
      return new ScalarValuedPair(current.getX(), sum);
    }

    return new ScalarValuedPair(next.getX(), sum);

  }

}
