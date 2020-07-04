package org.spaceroots.mantissa.ode;

/**
 * This class is used in the junit tests for the ODE integrators.
 * <p>This is the same as problem 1 except integration is done
 * backward in time</p>
 */
class TestProblem5
  extends TestProblem1 {

  /**
   * Simple constructor.
   */
  public TestProblem5() {
    super();
    setFinalConditions(2 * t0 - t1);
  }
 
}
