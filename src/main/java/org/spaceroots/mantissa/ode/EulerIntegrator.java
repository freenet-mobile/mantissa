package org.spaceroots.mantissa.ode;

/**
 * This class implements a simple Euler integrator for Ordinary
 * Differential Equations.

 * <p>The Euler algorithm is the simplest one that can be used to
 * integrate ordinary differential equations. It is a simple inversion
 * of the forward difference expression :
 * <code>f'=(f(t+h)-f(t))/h</code> which leads to
 * <code>f(t+h)=f(t)+hf'</code>. The interpolation scheme used for
 * dense output is the linear scheme already used for integration.</p>

 * <p>This algorithm looks cheap because it needs only one function
 * evaluation per step. However, as it uses linear estimates, it needs
 * very small steps to achieve high accuracy, and small steps lead to
 * numerical errors and instabilities.</p>

 * <p>This algorithm is almost never used and has been included in
 * this package only as a comparison reference for more useful
 * integrators.</p>

 * @see MidpointIntegrator
 * @see ClassicalRungeKuttaIntegrator
 * @see GillIntegrator
 * @see ThreeEighthesIntegrator

 * @version $Id: EulerIntegrator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class EulerIntegrator
  extends RungeKuttaIntegrator {

  private static final String methodName = "Euler";

  private static final double[] c = {
  };

  private static final double[][] a = {
  };

  private static final double[] b = {
    1.0
  };

  /** Simple constructor.
   * Build an Euler integrator with the given step.
   * @param step integration step
   */
  public EulerIntegrator(double step) {
    super(false, c, a, b, new EulerStepInterpolator(), step);
  }

  /** Get the name of the method.
   * @return name of the method
   */
  public String getName() {
    return methodName;
  }

}