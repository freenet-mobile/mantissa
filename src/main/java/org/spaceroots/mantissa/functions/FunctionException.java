package org.spaceroots.mantissa.functions;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by scalar functions.

 * @version $Id: FunctionException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class FunctionException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public FunctionException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  /** Simple constructor.
   * Build an exception by translating the specified message
   * @param message message to translate
   */
  public FunctionException(String message) {
    super(message);
  }

  /** Simple constructor.
   * Build an exception from a cause
   * @param cause cause of this exception
   */
  public FunctionException(Throwable cause) {
    super(cause);
  }

  private static final long serialVersionUID = 1455885104381976115L;

}
