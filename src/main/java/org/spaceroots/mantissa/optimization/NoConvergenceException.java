package org.spaceroots.mantissa.optimization;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by optimization algorithms.

 * @version $Id: NoConvergenceException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class NoConvergenceException
  extends MantissaException {

  /** Simple constructor.
   * Build an exception by translating and formating a message
   * @param specifier format specifier (to be translated)
   * @param parts to insert in the format (no translation)
   */
  public NoConvergenceException(String specifier, String[] parts) {
    super(specifier, parts);
  }

  private static final long serialVersionUID = 4854864422540042859L;

}
