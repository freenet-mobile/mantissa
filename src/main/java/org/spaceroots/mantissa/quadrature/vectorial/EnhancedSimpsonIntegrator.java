package org.spaceroots.mantissa.quadrature.vectorial;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.vectorial.SampledFunctionIterator;

/** This class implements an enhanced Simpson-like integrator.

 * <p>A traditional Simpson integrator is based on a quadratic
 * approximation of the function on three equally spaced points. This
 * integrator does the same thing but can handle non-equally spaced
 * points. If it is used on a regular sample, it behaves exactly as a
 * traditional Simpson integrator.</p>

 * @version $Id: EnhancedSimpsonIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class EnhancedSimpsonIntegrator
  implements SampledFunctionIntegrator {
  public double[] integrate(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    EnhancedSimpsonIntegratorSampler sampler =
      new EnhancedSimpsonIntegratorSampler(iter);
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
