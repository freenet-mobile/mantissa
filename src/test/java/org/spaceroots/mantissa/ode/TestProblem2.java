package org.spaceroots.mantissa.ode;

/**
 * This class is used in the junit tests for the ODE integrators.

 * <p>This specific problem is the following differential equation :
 * <pre>
 *    y' = t^3 - t y
 * </pre>
 * with the initial condition y (0) = 0. The solution of this equation
 * is the following function :
 * <pre>
 *   y (t) = t^2 + 2 (ext (- t^2 / 2) - 1)
 * </pre>
 * </p>

 */
class TestProblem2
  extends TestProblemAbstract {

  /** theoretical state */
  private double[] y;

  /**
   * Simple constructor.
   */
  public TestProblem2() {
    super();
    double[] y0 = { 0.0 };
    setInitialConditions(0.0, y0);
    setFinalConditions(1.0);
    double[] errorScale = { 1.0 };
    setErrorScale(errorScale);
    y = new double[y0.length];
  }
 
  /**
   * Copy constructor.
   * @param problem problem to copy
   */
  public TestProblem2(TestProblem2 problem) {
    super(problem);
    y = (double[]) problem.y.clone();
  }

  /**
   * Clone operation.
   * @return a copy of the instance
   */
  public Object clone() {
    return new TestProblem2(this);
  }

  public void doComputeDerivatives(double t, double[] y, double[] yDot) {

    // compute the derivatives
    for (int i = 0; i < n; ++i)
      yDot[i] = t * (t * t - y[i]);

  }

  public double[] computeTheoreticalState(double t) {
    double t2 = t * t;
    double c = t2 + 2 * (Math.exp (-0.5 * t2) - 1);
    for (int i = 0; i < n; ++i) {
      y[i] = c;
    }
    return y;
  }

}
