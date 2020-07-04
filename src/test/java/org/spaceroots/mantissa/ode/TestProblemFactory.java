package org.spaceroots.mantissa.ode;

/**
 * This class is used in the junit tests for the ODE integrators.
 */
class TestProblemFactory {

  /** Problems pool. */
  private static TestProblemAbstract[] pool = {
    new TestProblem1(),
    new TestProblem2(),
    new TestProblem3(),
    new TestProblem4(),
    new TestProblem5()
  };

  /**
   * Private constructor.
   * This is a utility class, so there are no instance at all.
   */
  private TestProblemFactory() {
  }

  /**
   * Get the problems.
   * @return array of problems to solve
   */
  public static TestProblemAbstract[] getProblems() {
    return pool;
  }

}
