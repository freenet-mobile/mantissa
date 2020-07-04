package org.spaceroots.mantissa.ode;

/** This interface represents a second order differential equations set.

 * <p>This interface should be implemented by all real second order
 * differential equation problems before they can be handled by the
 * integrators {@link SecondOrderIntegrator#integrate} method.</p>

 * <p>A second order differential equations problem, as seen by an
 * integrator is the second time derivative <code>d2Y/dt^2</code> of a
 * state vector <code>Y</code>, both being one dimensional
 * arrays. From the integrator point of view, this derivative depends
 * only on the current time <code>t</code>, on the state vector
 * <code>Y</code> and on the first time derivative of the state
 * vector.</p>

 * <p>For real problems, the derivative depends also on parameters
 * that do not belong to the state vector (dynamical model constants
 * for example). These constants are completely outside of the scope
 * of this interface, the classes that implement it are allowed to
 * handle them as they want.</p>

 * @see SecondOrderIntegrator
 * @see FirstOrderConverter
 * @see FirstOrderDifferentialEquations
 * @see org.spaceroots.mantissa.utilities.ArraySliceMappable

 * @version $Id: SecondOrderDifferentialEquations.java 1255 2002-06-20 17:50:50Z luc $
 * @author L. Maisonobe

 */

public interface SecondOrderDifferentialEquations {

  /** Get the dimension of the problem.
   * @return dimension of the problem
   */
  public int getDimension();
    
  /** Get the current time derivative of the state vector.
   * @param t current value of the independant <I>time</I> variable
   * @param y array containing the current value of the state vector
   * @param yDot array containing the current value of the first derivative
   * of the state vector
   * @param yDDot placeholder array where to put the second time derivative
   * of the state vector
   * @throws DerivativeException this exception is propagated to the caller if the
   * underlying user function triggers one
   */
  public void computeSecondDerivatives(double t, double[] y, double[] yDot,
                                       double[] yDDot)
  throws DerivativeException;

}
