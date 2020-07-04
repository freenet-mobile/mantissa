package org.spaceroots.mantissa.optimization;

/** This class holds a point and its associated cost.
 * <p>This is a simple immutable container.</p>
 * @author Luc Maisonobe
 * @version $Id: PointCostPair.java 1709 2006-12-03 21:16:50Z luc $
 * @see CostFunction
 */
public class PointCostPair {

  /** Build a point/cost pair.
   * @param point point coordinates
   * @param cost point cost
   */
  public PointCostPair(double[] point, double cost) {
    this.point = (double[]) point.clone();
    this.cost = cost;
  }

  /** Point coordinates. */
  public final double[] point;

  /** Cost associated to the point. */
  public final double cost;

}
