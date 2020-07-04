package org.spaceroots.mantissa.functions.vectorial;

import java.io.Serializable;

/** This class represents an (x, f(x)) pair for vectorial functions.

 * <p>A vectorial function is a function of one vectorial parameter x whose
 * value is a vector. This class is used has a simple immutable placeholder to
 * contain both an abscissa and the value of the function at this
 * abscissa.</p>

 * @see SampledFunction
 * @see org.spaceroots.mantissa.functions.vectorial.VectorialValuedPair

 * @version $Id: VectorialValuedPair.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */
public class VectorialValuedPair
  implements Serializable {

  /**
   * Simple constructor.
   * Build an instance from its coordinates
   * @param x abscissa
   * @param y ordinate (value of the function)
   */
  public VectorialValuedPair(double x, double[] y) {
    this.x = x;
    this.y = (double[]) y.clone();
  }

  /** Abscissa of the point. */
  public final double x;

  /** Vectorial ordinate of the point, y = f (x). */
  public final double[] y;

  private static final long serialVersionUID = -7397116933564410103L;

}
