package org.spaceroots.mantissa.ode;

/**
 * This class implements the Gill fourth order Runge-Kutta
 * integrator for Ordinary Differential Equations .

 * <p>This method is an explicit Runge-Kutta method, its Butcher-array
 * is the following one :
 * <pre>
 *    0  |    0        0       0      0
 *   1/2 |   1/2       0       0      0
 *   1/2 | (q-1)/2  (2-q)/2    0      0
 *    1  |    0       -q/2  (2+q)/2   0
 *       |-------------------------------
 *       |   1/6    (2-q)/6 (2+q)/6  1/6
 * </pre>
 * where q = sqrt(2)</p>

 * @see EulerIntegrator
 * @see ClassicalRungeKuttaIntegrator
 * @see MidpointIntegrator
 * @see ThreeEighthesIntegrator

 * @version $Id: GillIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class GillIntegrator
  extends RungeKuttaIntegrator {

  private static final String methodName = "Gill";

  private static final double sqrt2 = Math.sqrt(2.0);

  private static final double[] c = {
    1.0 / 2.0, 1.0 / 2.0, 1.0
  };

  private static final double[][] a = {
    { 1.0 / 2.0 },
    { (sqrt2 - 1.0) / 2.0, (2.0 - sqrt2) / 2.0 },
    { 0.0, -sqrt2 / 2.0, (2.0 + sqrt2) / 2.0 }
  };

  private static final double[] b = {
    1.0 / 6.0, (2.0 - sqrt2) / 6.0, (2.0 + sqrt2) / 6.0, 1.0 / 6.0
  };

  /** Simple constructor.
   * Build a fourth-order Gill integrator with the given step.
   * @param step integration step
   */
  public GillIntegrator(double step) {
    super(false, c, a, b, new GillStepInterpolator(), step);
  }

  /** Get the name of the method.
   * @return name of the method
   */
  public String getName() {
    return methodName;
  }

}
