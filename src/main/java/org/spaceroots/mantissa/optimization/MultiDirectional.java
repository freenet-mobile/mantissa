package org.spaceroots.mantissa.optimization;

/** This class implements the multi-directional direct search method.

 * @author Luc Maisonobe
 * @version $Id: MultiDirectional.java 1709 2006-12-03 21:16:50Z luc $
 * @see NelderMead
 */
public class MultiDirectional
  extends DirectSearchOptimizer {

  /** Build a multi-directional optimizer with default coefficients.
   * <p>The default values are 2.0 for khi and 0.5 for gamma.</p>
   */
  public MultiDirectional() {
    super();
    this.khi   = 2.0;
    this.gamma = 0.5;
  }

  /** Build a multi-directional optimizer with specified coefficients.
   * @param khi expansion coefficient
   * @param gamma contraction coefficient
   */
  public MultiDirectional(double khi, double gamma) {
    super();
    this.khi   = khi;
    this.gamma = gamma;
  }

  /** Compute the next simplex of the algorithm.
   */
  protected void iterateSimplex()
    throws CostException {

    while (true) {

      // save the original vertex
      PointCostPair[] original = simplex;
      double originalCost = original[0].cost;

      // perform a reflection step
      double reflectedCost = evaluateNewSimplex(original, 1.0);
      if (reflectedCost < originalCost) {

        // compute the expanded simplex
        PointCostPair[] reflected = simplex;
        double expandedCost = evaluateNewSimplex(original, khi);
        if (reflectedCost <= expandedCost) {
          // accept the reflected simplex
          simplex = reflected;
        }

        return;

      }

      // compute the contracted simplex
      double contractedCost = evaluateNewSimplex(original, gamma);
      if (contractedCost < originalCost) {
        // accept the contracted simplex
        return;
      }

    }

  }

  /** Compute and evaluate a new simplex.
   * @param original original simplex (to be preserved)
   * @param coeff linear coefficient
   * @return smallest cost in the transformed simplex
   * @exception CostException if the function cannot be evaluated at
   * some point
   */
  private double evaluateNewSimplex(PointCostPair[] original, double coeff)
    throws CostException {

    double[] xSmallest = original[0].point;
    int n = xSmallest.length;

    // create the linearly transformed simplex
    simplex = new PointCostPair[n + 1];
    simplex[0] = original[0];
    for (int i = 1; i <= n; ++i) {
      double[] xOriginal    = original[i].point;
      double[] xTransformed = new double[n];
      for (int j = 0; j < n; ++j) {
        xTransformed[j] = xSmallest[j] + coeff * (xSmallest[j] - xOriginal[j]);
      }
      simplex[i] = new PointCostPair(xTransformed, Double.NaN);
    }

    // evaluate it
    evaluateSimplex();
    return simplex[0].cost;

  }

  /** Expansion coefficient. */
  private double khi;

  /** Contraction coefficient. */
  private double gamma;

}
