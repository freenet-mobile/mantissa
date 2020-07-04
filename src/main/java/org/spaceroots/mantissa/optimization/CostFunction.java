package org.spaceroots.mantissa.optimization;

/** This interface represents a cost function to be minimized.
 * @author Luc Maisonobe
 * @version $Id: CostFunction.java 1580 2004-07-15 20:13:43Z luc $
 */
public interface CostFunction {


  /** Compute the cost associated to the given parameters array.
   * @param x parameters array
   * @return cost associated to the parameters array
   * @exception CostException if no cost can be computed for the parameters
   * @see PointCostPair
   */
  public double cost(double[] x) throws CostException;

}
