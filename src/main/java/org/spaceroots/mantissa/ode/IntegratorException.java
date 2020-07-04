package org.spaceroots.mantissa.ode;

import org.spaceroots.mantissa.MantissaException;

/**
 * This exception is made available to users to report
 * the error conditions that are triggered during integration
 * @author Luc Maisonobe
 * @version $Id: IntegratorException.java 1686 2005-12-16 12:59:51Z luc $
 */
public class IntegratorException
  extends MantissaException {
    
  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public IntegratorException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  private static final long serialVersionUID = -1390328069787882608L;

}
