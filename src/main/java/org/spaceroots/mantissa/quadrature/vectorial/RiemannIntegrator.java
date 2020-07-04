package org.spaceroots.mantissa.quadrature.vectorial;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.vectorial.SampledFunctionIterator;

/** This class implements a Riemann integrator.

 * <p>A Riemann integrator is a very simple one that assumes the
 * function is constant over the integration step. Since it is very
 * simple, this algorithm needs very small steps to achieve high
 * accuracy, and small steps lead to numerical errors and
 * instabilities.</p>

 * <p>This algorithm is almost never used and has been included in
 * this package only as a simple template for more useful
 * integrators.</p>

 * @see TrapezoidIntegrator

 * @version $Id: RiemannIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class RiemannIntegrator
  implements SampledFunctionIntegrator {

  public double[] integrate(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    RiemannIntegratorSampler sampler = new RiemannIntegratorSampler(iter);
    double[] sum = null;

    try {
      while (true) {
        sum = sampler.nextSamplePoint().y;
      }
    } catch(ExhaustedSampleException e) {
    }

    return sum;

  }

}
