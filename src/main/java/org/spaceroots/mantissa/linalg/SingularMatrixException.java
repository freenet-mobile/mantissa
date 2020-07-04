package org.spaceroots.mantissa.linalg;

import org.spaceroots.mantissa.MantissaException;

/** This class represent exceptions thrown by some matrix operations.

 * @version $Id: SingularMatrixException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class SingularMatrixException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception with a default message
   */
  public SingularMatrixException() {
    super("singular matrix");
  }

  private static final long serialVersionUID = 7531357987468317564L;

}
