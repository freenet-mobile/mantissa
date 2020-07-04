package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.scalar.*;
import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This class implements a Riemann integrator as a sample.

 * <p>A Riemann integrator is a very simple one that assumes the
 * function is constant over the integration step. Since it is very
 * simple, this algorithm needs very small steps to achieve high
 * accuracy, and small steps lead to numerical errors and
 * instabilities.</p>

 * <p>This algorithm is almost never used and has been included in
 * this package only as a simple template for more useful
 * integrators.</p>

 * @see RiemannIntegrator

 * @version $Id: RiemannIntegratorSampler.java 1237 2002-03-20 21:01:57Z luc $
 * @author L. Maisonobe

 */

public class RiemannIntegratorSampler
  implements SampledFunctionIterator {

  /** Underlying sample iterator. */
  private SampledFunctionIterator iter;

  /** Current point. */
  private ScalarValuedPair current;

  /** Current running sum. */
  private double sum;

  /** Constructor.
   * Build an integrator from an underlying sample iterator.
   * @param iter iterator over the base function
   */
  public RiemannIntegratorSampler(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    this.iter = iter;

    // get the first point
    current = iter.nextSamplePoint();

    // initialize the sum
    sum = 0.0;

  }

  public boolean hasNext() {
    return iter.hasNext();
  }

  public ScalarValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {
    // performs one step of a Riemann scheme
    ScalarValuedPair previous = current;
    current = iter.nextSamplePoint();
    sum    += (current.getX() - previous.getX()) * previous.getY();

    return new ScalarValuedPair(current.getX(), sum);

  }

}
