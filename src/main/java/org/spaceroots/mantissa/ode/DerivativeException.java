package org.spaceroots.mantissa.ode;

import org.spaceroots.mantissa.MantissaException;

/**
 * This exception is made available to users to report
 * the error conditions that are trigegred while computing
 * the differential equations.
 * @author Luc Maisonobe
 * @version $Id: DerivativeException.java 1695 2006-09-03 19:59:05Z luc $
 */
public class DerivativeException
  extends MantissaException {
    
  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public DerivativeException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  /** Build an instance from an underlying cause.
   * @param cause cause for the exception
   */
  public DerivativeException(Throwable cause) {
    super(cause);
  }

  private static final long serialVersionUID = -4100440615830558122L;

}
