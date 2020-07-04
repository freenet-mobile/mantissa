package org.spaceroots.mantissa.roots;

import org.spaceroots.mantissa.functions.scalar.ComputableFunction;
import org.spaceroots.mantissa.functions.FunctionException;

/** This interface specifies root-finding methods for scalar
 * functions.

 * @version $Id: RootsFinder.java 1499 2003-03-29 12:50:08Z luc $
 * @author L. Maisonobe

 */

public interface RootsFinder {

  /** Solve a function in a given interval known to contain a root.
   * @param function function for which a root should be found
   * @param checker checker for the convergence of the function
   * @param maxIter maximal number of iteration allowed
   * @param x0 abscissa of the lower bound of the interval
   * @param f0 value of the function the lower bound of the interval
   * @param x1 abscissa of the higher bound of the interval
   * @param f1 value of the function the higher bound of the interval
   * @return true if a root has been found in the given interval
   */
  public boolean findRoot(ComputableFunction function,
                          ConvergenceChecker checker,
                          int maxIter,
                          double x0, double f0, double x1, double f1)
    throws FunctionException;

  /** Get the abscissa of the root.
   * @return abscissa of the root
   */
  public double getRoot();

}
