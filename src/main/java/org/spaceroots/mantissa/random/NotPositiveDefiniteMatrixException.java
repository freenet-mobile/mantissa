package org.spaceroots.mantissa.random;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by the correlated random
 * vector generator.

 * @version $Id: NotPositiveDefiniteMatrixException.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */

public class NotPositiveDefiniteMatrixException
  extends MantissaException {

  /** Simple constructor.
   * build an exception with a default message.
   */
  public NotPositiveDefiniteMatrixException() {
    super("not positive definite matrix");
  }

  /** Simple constructor.
   * build an exception with the specified message.
   * @param message message to use to build the exception
   */
  public NotPositiveDefiniteMatrixException(String message) {
    super(message);
  }

  private static final long serialVersionUID = -6801349873804445905L;

}
