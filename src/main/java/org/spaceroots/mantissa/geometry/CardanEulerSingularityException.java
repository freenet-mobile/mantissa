package org.spaceroots.mantissa.geometry;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown while extractiong Cardan
 * or Euler angles from a rotation.

 * @version $Id: CardanEulerSingularityException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class CardanEulerSingularityException
  extends MantissaException {

  /** Simple constructor.
   * build an exception with a default message.
   * @param isCardan if true, the rotation is related to Cardan angles,
   * if false it is related to EulerAngles
   */
  public CardanEulerSingularityException(boolean isCardan) {
    super(isCardan ? "Cardan angles singularity" : "Euler angles singularity");
  }

  private static final long serialVersionUID = -1360952845582206770L;

}
