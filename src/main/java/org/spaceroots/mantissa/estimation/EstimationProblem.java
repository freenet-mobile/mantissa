package org.spaceroots.mantissa.estimation;

/** This interface represents an estimation problem.

 * <p>This interface should be implemented by all real estimation
 * problems before they can be handled by the estimators through the
 * {@link Estimator#estimate Estimator.estimate} method.</p>

 * <p>An estimation problem, as seen by a solver is a set of
 * parameters and a set of measurements. The parameters are adjusted
 * during the estimation through the {@link #getUnboundParameters
 * getUnboundParameters} and {@link EstimatedParameter#setEstimate
 * EstimatedParameter.setEstimate} methods. The measurements both have
 * a measured value which is generally fixed at construction and a
 * theoretical value which depends on the model and hence varies as
 * the parameters are adjusted. The purpose of the solver is to reduce
 * the residual between these values, it can retrieve the measurements
 * through the {@link #getMeasurements getMeasurements} method.</p>

 * @see Estimator
 * @see WeightedMeasurement

 * @version $Id: EstimationProblem.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */

public interface EstimationProblem {
  /** Get the measurements of an estimation problem.
   * @return measurements
   */
  public WeightedMeasurement[] getMeasurements();

  /** Get the unbound parameters of the problem.
   * @return unbound parameters
   */
  public EstimatedParameter[] getUnboundParameters();

  /** Get all the parameters of the problem.
   * @return parameters
   */
  public EstimatedParameter[] getAllParameters();

}
