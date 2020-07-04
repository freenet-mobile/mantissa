package org.spaceroots.mantissa.geometry;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown while building rotations
 * from matrices.

 * @version $Id: NotARotationMatrixException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class NotARotationMatrixException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public NotARotationMatrixException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  private static final long serialVersionUID = 5647178478658937642L;

}
