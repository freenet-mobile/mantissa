package org.spaceroots.mantissa.functions;

import org.spaceroots.mantissa.MantissaException;

/** This class represents exceptions thrown by sample iterators.

 * @version $Id: ExhaustedSampleException.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */

public class ExhaustedSampleException
  extends MantissaException {

  /** Simple constructor.
   * @param size size of the sample
   */
  public ExhaustedSampleException(int size) {
    super("sample contains only {0} elements",
          new String[] { Integer.toString(size) });
  }

  private static final long serialVersionUID = -1490493298938282440L;

}
