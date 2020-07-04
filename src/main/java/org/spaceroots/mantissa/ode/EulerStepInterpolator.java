package org.spaceroots.mantissa.ode;

/**
 * This class implements a linear interpolator for step.

 * <p>This interpolator allow to compute dense output inside the last
 * step computed. The interpolation equation is consistent with the
 * integration scheme :

 * <pre>
 *   y(t_n + theta h) = y (t_n + h) - (1-theta) h y'
 * </pre>

 * where theta belongs to [0 ; 1] and where y' is the evaluation of
 * the derivatives already computed during the step.</p>

 * @see EulerIntegrator

 * @version $Id: EulerStepInterpolator.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */

class EulerStepInterpolator
  extends RungeKuttaStepInterpolator {

  /** Simple constructor.
   * This constructor builds an instance that is not usable yet, the
   * {@link AbstractStepInterpolator#reinitialize} method should be called
   * before using the instance in order to initialize the internal arrays. This
   * constructor is used only in order to delay the initialization in
   * some cases. The {@link RungeKuttaIntegrator} class uses the
   * prototyping design pattern to create the step interpolators by
   * cloning an uninitialized model and latter initializing the copy.
   */
  public EulerStepInterpolator() {
  }

  /** Copy constructor.
   * @param interpolator interpolator to copy from. The copy is a deep
   * copy: its arrays are separated from the original arrays of the
   * instance
   */
  public EulerStepInterpolator(EulerStepInterpolator interpolator) {
    super(interpolator);
  }

  /**
   * Clone the instance.
   * the copy is a deep copy: its arrays are separated from the
   * original arrays of the instance
   * @return a copy of the instance
   */
  public Object clone() {
    return new EulerStepInterpolator(this);
  }

  /** Compute the state at the interpolated time.
   * This is the main processing method that should be implemented by
   * the derived classes to perform the interpolation.
   * @param theta normalized interpolation abscissa within the step
   * (theta is zero at the previous time step and one at the current time step)
   * @param oneMinusThetaH time gap between the interpolated time and
   * the current time
   * @throws DerivativeException this exception is propagated to the caller if the
   * underlying user function triggers one
   */
  protected void computeInterpolatedState(double theta,
                                          double oneMinusThetaH)
    throws DerivativeException {

    for (int i = 0; i < interpolatedState.length; ++i) {
      interpolatedState[i] = currentState[i] - oneMinusThetaH * yDotK[0][i];
    }

  }

  private static final long serialVersionUID = -7179861704951334960L;

}