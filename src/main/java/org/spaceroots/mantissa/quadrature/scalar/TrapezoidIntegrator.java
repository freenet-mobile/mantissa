package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.scalar.SampledFunctionIterator;

/** This class implements a trapezoid integrator.

 * <p>A trapezoid integrator is a very simple one that assumes the
 * function is linear over the integration step.</p>

 * @version $Id: TrapezoidIntegrator.java 1237 2002-03-20 21:01:57Z luc $
 * @author L. Maisonobe

 */

public class TrapezoidIntegrator
  implements SampledFunctionIntegrator {
  public double integrate(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    TrapezoidIntegratorSampler sampler = new TrapezoidIntegratorSampler(iter);
    double sum = 0.0;

    try {
      while (true) {
        sum = sampler.nextSamplePoint().getY();
      }
    } catch (ExhaustedSampleException e) {
    }

    return sum;

  }

}
