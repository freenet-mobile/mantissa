package org.spaceroots.mantissa.quadrature.vectorial;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;
import org.spaceroots.mantissa.functions.vectorial.SampledFunctionIterator;

/** This class implements a trapezoid integrator.

 * <p>A trapezoid integrator is a very simple one that assumes the
 * function is linear over the integration step.</p>

 * @version $Id: TrapezoidIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class TrapezoidIntegrator
  implements SampledFunctionIntegrator {
  public double[] integrate(SampledFunctionIterator iter)
    throws ExhaustedSampleException, FunctionException {

    TrapezoidIntegratorSampler sampler =
      new TrapezoidIntegratorSampler(iter);
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
