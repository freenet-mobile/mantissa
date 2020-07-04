package org.spaceroots.mantissa.fitting;

import org.spaceroots.mantissa.estimation.EstimatedParameter;

/** This class represents a polynomial coefficient.

 * <p>Each coefficient is uniquely defined by its degree.</p>

 * @see PolynomialFitter

 * @version $Id: PolynomialCoefficient.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */
public class PolynomialCoefficient
  extends EstimatedParameter {

  public PolynomialCoefficient(int degree) {
    super("a" + degree, 0.0);
    this.degree = degree;
  }

  public final int degree;

  private static final long serialVersionUID = 5775845068390259552L;

}
