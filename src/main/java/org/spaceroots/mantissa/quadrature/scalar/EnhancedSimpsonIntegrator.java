package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.scalar.SampledFunctionIterator;

/** This class implements an enhanced Simpson-like integrator.

 * <p>A traditional Simpson integrator is based on a quadratic
 * approximation of the function on three equally spaced points. This
 * integrator does the same thing but can handle non-equally spaced
 * points. If it is used on a regular sample, it behaves exactly as a
 * traditional Simpson integrator.</p>

 * @version $Id: EnhancedSimpsonIntegrator.java 1237 2002-03-20 21:01:57Z luc $
 * @author L. Maisonobe

 */

public class EnhancedSimpsonIntegrator
  implements SampledFunctionIntegrator {
  public double integrate(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    EnhancedSimpsonIntegratorSampler sampler
      = new EnhancedSimpsonIntegratorSampler(iter);
    double sum = 0.0;

    try {
      while (true) {
        sum = sampler.nextSamplePoint().getY();
      }
    } catch(ExhaustedSampleException e) {
    }

    return sum;

  }

}
