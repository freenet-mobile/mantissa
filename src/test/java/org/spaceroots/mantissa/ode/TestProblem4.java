package org.spaceroots.mantissa.ode;

/**
 * This class is used in the junit tests for the ODE integrators.

 * <p>This specific problem is the following differential equation :
 * <pre>
 *    x'' = -x
 * </pre>
 * And when x decreases down to 0, the state should be changed as follows :
 * <pre>
 *   x' -> -x'
 * </pre>
 * The theoretical solution of this problem is x = |sin(t+a)|
 * </p>

 */
class TestProblem4
  extends TestProblemAbstract {

  /** Time offset. */
  private double a;

  /** theoretical state */
  private double[] y;

  /** Simple constructor. */
  public TestProblem4() {
    super();
    a = 1.2;
    double[] y0 = { Math.sin(a), Math.cos(a) };
    setInitialConditions(0.0, y0);
    setFinalConditions(15);
    double[] errorScale = { 1.0, 0.0 };
    setErrorScale(errorScale);
    y = new double[y0.length];
  }
 
  /**
   * Copy constructor.
   * @param problem problem to copy
   */
  public TestProblem4(TestProblem4 problem) {
    super(problem);
    a = problem.a;
    y = (double[]) problem.y.clone();
  }

  /**
   * Clone operation.
   * @return a copy of the instance
   */
  public Object clone() {
    return new TestProblem4(this);
  }

  public SwitchingFunction[] getSwitchingFunctions() {
    return new SwitchingFunction[] { new Bounce(), new Stop() };
  }

  public void doComputeDerivatives(double t, double[] y, double[] yDot) {
    yDot[0] =  y[1];
    yDot[1] = -y[0];
  }

  public double[] computeTheoreticalState(double t) {
    double sin = Math.sin(t + a);
    double cos = Math.cos(t + a);
    y[0] = Math.abs(sin);
    y[1] = (sin >= 0) ? cos : -cos;
    return y;
  }

  private static class Bounce implements SwitchingFunction {

    private static final long serialVersionUID = 1356097180027801200L;
    private int sign;

    public Bounce() {
      sign = +1;
    }

    public double g(double t, double[] y) {
      return sign * y[0];
    }

    public int eventOccurred(double t, double[] y) {
      // this sign change is needed because the state will be reset soon
      sign = -sign;
      return SwitchingFunction.RESET_STATE;
    }
  
    public void resetState(double t, double[] y) {
      y[1] = -y[1];
    }

  }

  private static class Stop implements SwitchingFunction {

    private static final long serialVersionUID = 6975050568227951931L;

    public Stop() {
    }

    public double g(double t, double[] y) {
      return t - 12.0;
    }

    public int eventOccurred(double t, double[] y) {
      return SwitchingFunction.STOP;
    }
  
    public void resetState(double t, double[] y) {
    }

  }

}
