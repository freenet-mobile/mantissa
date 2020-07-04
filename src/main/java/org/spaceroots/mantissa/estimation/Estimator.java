package org.spaceroots.mantissa.estimation;

/** This interface represents solvers for estimation problems.

 * <p>The classes which are devoted to solve estimation problems
 * should implement this interface. The problems which can be handled
 * should implement the {@link EstimationProblem} interface which
 * gather all the information needed by the solver.</p>

 * <p>The interface is composed only of the {@link #estimate estimate}
 * method.</p>

 * @see EstimationProblem

 * @version $Id: Estimator.java 1677 2005-12-16 11:10:48Z luc $
 * @author L. Maisonobe

 */

public interface Estimator {

  /** Solve an estimation problem.

   * <p>The method should set the parameters of the problem to several
   * trial values until it reaches convergence. If this method returns
   * normally (i.e. without throwing an exception), then the best
   * estimate of the parameters can be retrieved from the problem
   * itself, through the {@link EstimationProblem#getAllParameters
   * EstimationProblem.getAllParameters} method.</p>

   * @param problem estimation problem to solve
   * @exception EstimationException if the problem cannot be solved

   */
  public void estimate(EstimationProblem problem)
    throws EstimationException;

  /** Get the Root Mean Square value.
   * Get the Root Mean Square value, i.e. the root of the arithmetic
   * mean of the square of all weighted residuals. This is related to the
   * criterion that is minimized by the estimator as follows: if
   * <em>c</em> if the criterion, and <em>n</em> is the number of
   * measurements, the the RMS is <em>sqrt (c/n)</em>.
   * @param problem estimation problem
   * @return RMS value
   */
  public double getRMS(EstimationProblem problem);
 
}
