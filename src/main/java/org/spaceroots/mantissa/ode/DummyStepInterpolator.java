package org.spaceroots.mantissa.ode;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;

/** This class is a step interpolator that does nothing.
 *
 * <p>This class is used when the {@link StepHandler "step handler"}
 * set up by the user does not need step interpolation. It does not
 * recompute the state when {@link AbstractStepInterpolator#setInterpolatedTime
 * setInterpolatedTime} is called. This implies the interpolated state
 * is always the state at the end of the current step.</p>
 *
 * @see StepHandler
 *
 * @version $Id: DummyStepInterpolator.java 1721 2007-10-07 20:21:25Z luc $
 * @author L. Maisonobe
 *
 */

public class DummyStepInterpolator
  extends AbstractStepInterpolator {

  /** Simple constructor.
   * This constructor builds an instance that is not usable yet, the
   * {@link AbstractStepInterpolator#reinitialize} method should be called
   * before using the instance in order to initialize the internal arrays. This
   * constructor is used only in order to delay the initialization in
   * some cases. As an example, the {@link
   * RungeKuttaFehlbergIntegrator} uses the prototyping design pattern
   * to create the step interpolators by cloning an uninitialized
   * model and latter initializing the copy.
   */
  public DummyStepInterpolator() {
    super();
  }

  /** Simple constructor.
   * @param y reference to the integrator array holding the state at
   * the end of the step
   * @param forward integration direction indicator
   */
  protected DummyStepInterpolator(double[] y, boolean forward) {
    super(y, forward);
  }

  /** Compute the state at the interpolated time.
   * In this class, this method does nothing: the interpolated state
   * is always the state at the end of the current step.
   * @param theta normalized interpolation abscissa within the step
   * (theta is zero at the previous time step and one at the current time step)
   * @param oneMinusThetaH time gap between the interpolated time and
   * the current time
   * @throws DerivativeException this exception is propagated to the caller if the
   * underlying user function triggers one
   */
  protected void computeInterpolatedState(double theta, double oneMinusThetaH)
    throws DerivativeException {
    System.arraycopy(currentState, 0, interpolatedState, 0, currentState.length);
  }
    
  public void writeExternal(ObjectOutput out)
    throws IOException {
    // save the state of the base class
    writeBaseExternal(out);
  }

  public void readExternal(ObjectInput in)
    throws IOException {

    // read the base class 
    double t = readBaseExternal(in);

    try {
      // we can now set the interpolated time and state
      setInterpolatedTime(t);
    } catch (DerivativeException e) {
      IOException ioe = new IOException();
      ioe.initCause(e);
      throw ioe;
    }

  }

  private static final long serialVersionUID = 1708010296707839488L;

}
