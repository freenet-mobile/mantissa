package org.spaceroots.mantissa.optimization;

/** This interface specifies how to check if a {@link
 * DirectSearchOptimizer direct search method} has converged.

 * <p>Deciding if convergence has been reached is a problem-dependent
 * issue. The user should provide a class implementing this interface
 * to allow the optimization algorithm to stop its search according to
 * the problem at hand.</p>

 * @version $Id: ConvergenceChecker.java 1580 2004-07-15 20:13:43Z luc $
 * @author L. Maisonobe

 */

public interface ConvergenceChecker {

  /** Check if the optimization algorithm has converged on the simplex.
   * @param simplex ordered simplex (all points in the simplex have
   * been eavluated and are sorted from lowest to largest cost)
   * @return true if the algorithm is considered to have converged
   */
  public boolean converged (PointCostPair[] simplex);

}
