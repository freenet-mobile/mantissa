package org.spaceroots.mantissa.quadrature.scalar;

import org.spaceroots.mantissa.functions.scalar.ComputableFunction;
import org.spaceroots.mantissa.functions.FunctionException;

/** This interface represents an integrator for scalar functions.

 * <p>The classes which are devoted to integrate scalar functions
 * should implement this interface. The functions which can be handled
 * should implement the {@link
 * org.spaceroots.mantissa.functions.scalar.ComputableFunction
 * ComputableFunction} interface.</p>

 * @see org.spaceroots.mantissa.functions.scalar.ComputableFunction

 * @version $Id: ComputableFunctionIntegrator.java 1231 2002-03-12 20:07:04Z luc $
 * @author L. Maisonobe

 */

public interface ComputableFunctionIntegrator {
  /** Integrate a function over a defined range.
   * @param f function to integrate
   * @param a first bound of the range (can be lesser or greater than b)
   * @param b second bound of the range (can be lesser or greater than a)
   * @return value of the integral over the range
   * @exception FunctionException if the underlying function throws one
   */
  public double integrate(ComputableFunction f, double a, double b)
    throws FunctionException;

}
