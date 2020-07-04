package org.spaceroots.mantissa.ode;

/**
 * This class implements the classical fourth order Runge-Kutta
 * integrator for Ordinary Differential Equations (it is the most
 * often used Runge-Kutta method).

 * <p>This method is an explicit Runge-Kutta method, its Butcher-array
 * is the following one :
 * <pre>
 *    0  |  0    0    0    0
 *   1/2 | 1/2   0    0    0
 *   1/2 |  0   1/2   0    0
 *    1  |  0    0    1    0
 *       |--------------------
 *       | 1/6  1/3  1/3  1/6
 * </pre>
 * </p>

 * @see EulerIntegrator
 * @see GillIntegrator
 * @see MidpointIntegrator
 * @see ThreeEighthesIntegrator

 * @version $Id: ClassicalRungeKuttaIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class ClassicalRungeKuttaIntegrator
  extends RungeKuttaIntegrator {

  private static final String methodName = "classical Runge-Kutta";

  private static final double[] c = {
    1.0 / 2.0, 1.0 / 2.0, 1.0
  };

  private static final double[][] a = {
    { 1.0 / 2.0 },
    { 0.0, 1.0 / 2.0 },
    { 0.0, 0.0, 1.0 }
  };

  private static final double[] b = {
    1.0 / 6.0, 1.0 / 3.0, 1.0 / 3.0, 1.0 / 6.0
  };

  /** Simple constructor.
   * Build a fourth-order Runge-Kutta integrator with the given
   * step.
   * @param step integration step
   */
  public ClassicalRungeKuttaIntegrator(double step) {
    super(false, c, a, b, new ClassicalRungeKuttaStepInterpolator(), step);
  }

  /** Get the name of the method.
   * @return name of the method
   */
  public String getName() {
    return methodName;
  }

}
