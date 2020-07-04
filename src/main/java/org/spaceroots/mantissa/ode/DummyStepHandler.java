package org.spaceroots.mantissa.ode;

import java.io.Serializable;

/**
 * This class is a step handler that do nothing.

 * <p>This class is provided as a convenience for users who are only
 * interested in the final state of an integration and not in the
 * intermediate steps. Its handleStep method does nothing.</p>

 * <p>Since this class has no internal state, it is implemented using
 * the Singleton design pattern. This means that only one instance is
 * ever created, which can be retrieved using the getInstance
 * method. This explains why there is no public constructor.</p>

 * @see StepHandler

 * @version $Id: DummyStepHandler.java 1721 2007-10-07 20:21:25Z luc $
 * @author L. Maisonobe

 */

public class DummyStepHandler
  implements StepHandler, Serializable {

  /** Private constructor.
   * The constructor is private to prevent users from creating
   * instances (Singleton design-pattern).
   */
  private DummyStepHandler() {
  }

  /** Get the only instance.
   * @return the only instance
   */
  public static DummyStepHandler getInstance() {
    if (instance == null) {
      instance = new DummyStepHandler();
    }
    return instance;
  }

  /** Determines whether this handler needs dense output.
   * Since this handler does nothing, it does not require dense output.
   * @return always false
   */
  public boolean requiresDenseOutput() {
    return false;
  }

  /** Reset the step handler.
   * Initialize the internal data as required before the first step is
   * handled.
   */
  public void reset() {
  }

  /**
   * Handle the last accepted step.
   * This method does nothing in this class.
   * @param interpolator interpolator for the last accepted step. For
   * efficiency purposes, the various integrators reuse the same
   * object on each call, so if the instance wants to keep it across
   * all calls (for example to provide at the end of the integration a
   * continuous model valid throughout the integration range), it
   * should build a local copy using the clone method and store this
   * copy.
   * @param isLast true if the step is the last one
   */
  public void handleStep(StepInterpolator interpolator, boolean isLast) {
  }

  /** The only instance. */
  private static DummyStepHandler instance = null;

  private static final long serialVersionUID = 1804704906852043886L;

}
