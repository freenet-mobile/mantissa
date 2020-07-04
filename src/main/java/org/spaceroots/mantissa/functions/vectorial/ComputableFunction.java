package org.spaceroots.mantissa.functions.vectorial;

import java.io.Serializable;

import org.spaceroots.mantissa.functions.FunctionException;

/** This interface represents vectorial functions of one real variable.

 * <p>This interface should be implemented by all vectorial functions
 * that can be evaluated at any point. This does not imply that an
 * explicit definition is available, a function given by an implicit
 * function that should be numerically solved for each point for
 * example is considered a computable function.</p>

 * <p>The {@link ComputableFunctionSampler} class can be used to
 * transform classes implementing this interface into classes
 * implementing the {@link SampledFunction} interface.</p>

 * <p>Several numerical algorithms (Gauss-Legendre integrators for
 * example) need to choose themselves the evaluation points, so they
 * can handle only objects that implement this interface.</p>

 * @see org.spaceroots.mantissa.quadrature.vectorial.ComputableFunctionIntegrator
 * @see SampledFunction

 * @version $Id: ComputableFunction.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */
public interface ComputableFunction extends Serializable {
  /** Get the dimension of the vectorial values of the function.
   * @return dimension
   */
  public int getDimension();

  /** Get the value of the function at the specified abscissa.
   * @param x current abscissa
   * @return function value
   * @exception FunctionException if something goes wrong
   */
  public double[] valueAt(double x)
    throws FunctionException;

}
