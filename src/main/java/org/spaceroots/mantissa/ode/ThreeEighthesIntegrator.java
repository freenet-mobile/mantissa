package org.spaceroots.mantissa.ode;

/**
 * This class implements the 3/8 fourth order Runge-Kutta
 * integrator for Ordinary Differential Equations.

 * <p>This method is an explicit Runge-Kutta method, its Butcher-array
 * is the following one :
 * <pre>
 *    0  |  0    0    0    0
 *   1/3 | 1/3   0    0    0
 *   2/3 |-1/3   1    0    0
 *    1  |  1   -1    1    0
 *       |--------------------
 *       | 1/8  3/8  3/8  1/8
 * </pre>
 * </p>

 * @see EulerIntegrator
 * @see ClassicalRungeKuttaIntegrator
 * @see GillIntegrator
 * @see MidpointIntegrator

 * @version $Id: ThreeEighthesIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class ThreeEighthesIntegrator
  extends RungeKuttaIntegrator {

  private static final String methodName = "3/8";

  private static final double[] c = {
    1.0 / 3.0, 2.0 / 3.0, 1.0
  };

  private static final double[][] a = {
    {  1.0 / 3.0 },
    { -1.0 / 3.0, 1.0 },
    {  1.0, -1.0, 1.0 }
  };

  private static final double[] b = {
    1.0 / 8.0, 3.0 / 8.0, 3.0 / 8.0, 1.0 / 8.0
  };

  /** Simple constructor.
   * Build a 3/8 integrator with the given step.
   * @param step integration step
   */
  public ThreeEighthesIntegrator(double step) {
    super(false, c, a, b, new ThreeEighthesStepInterpolator(), step);
  }

  /** Get the name of the method.
   * @return name of the method
   */
  public String getName() {
    return methodName;
  }

}
