package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.scalar.*;
import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This class implements a trapezoid integrator as a sample.

 * <p>A trapezoid integrator is a very simple one that assumes the
 * function is constant over the integration step. Since it is very
 * simple, this algorithm needs very small steps to achieve high
 * accuracy, and small steps lead to numerical errors and
 * instabilities.</p>

 * <p>This algorithm is almost never used and has been included in
 * this package only as a simple template for more useful
 * integrators.</p>

 * @see TrapezoidIntegrator

 * @version $Id: TrapezoidIntegratorSampler.java 1237 2002-03-20 21:01:57Z luc $
 * @author L. Maisonobe

 */

public class TrapezoidIntegratorSampler
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
  public TrapezoidIntegratorSampler(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    this.iter = iter;

    // get the first point
    current = iter.nextSamplePoint();

    // initialize the sum
    sum = 0.0;

  }

  public boolean hasNext() {
    return iter.hasNext ();
  }

  public ScalarValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {
    // performs one step of a trapezoid scheme
    ScalarValuedPair previous = current;
    current = iter.nextSamplePoint();
    sum    += 0.5
            * (current.getX() - previous.getX())
            * (previous.getY() + current.getY());

    return new ScalarValuedPair(current.getX(), sum);

  }

}
