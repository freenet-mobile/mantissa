package org.spaceroots.mantissa.estimation;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by the estimation solvers.

 * @version $Id: EstimationException.java 1681 2005-12-16 11:13:28Z luc $
 * @author L. Maisonobe

 */

public class EstimationException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception by translating the specified message
   * @param message message to translate
   */
  public EstimationException(String message) {
    super(message);
  }

  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public EstimationException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  /** Simple constructor.
   * Build an exception from a cause
   * @param cause cause of this exception
   */
  public EstimationException(Throwable cause) {
    super(cause);
  }

  private static final long serialVersionUID = 1613719630569355278L;

}
