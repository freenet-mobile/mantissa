package org.spaceroots.mantissa.optimization;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by cost functions.

 * @version $Id: CostException.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */

public class CostException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception with a default message
   */
  public CostException() {
    super("cost exception");
  }

  /** Simple constructor.
   * Build an exception with the specified message
   * @param message exception message
   */
  public CostException(String message) {
    super(message);
  }

  /** Simple constructor.
   * Build an exception from a cause
   * @param cause cause of this exception
   */
  public CostException(Throwable cause) {
    super(cause);
  }

  /** Simple constructor.
   * Build an exception from a message and a cause
   * @param message exception message
   * @param cause cause of this exception
   */
  public CostException(String message, Throwable cause) {
    super(message, cause);
  }

  private static final long serialVersionUID = -6099968585593678071L;

}
