package org.spaceroots.mantissa.algebra;

/**
 * This class implements Legendre polynomials.

 * <p>Legendre polynomials can be defined by the following recurrence
 * relations:
 * <pre>
 *        P<sub>0</sub>(X)   = 1
 *        P<sub>1</sub>(X)   = X
 *  (k+1) P<sub>k+1</sub>(X) = (2k+1) X P<sub>k</sub>(X) - k P<sub>k-1</sub>(X)
 * </pre></p>

 * @version $Id: Legendre.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class Legendre
  extends OrthogonalPolynomial {

  /** Generator for the Legendre polynomials. */
  private static final CoefficientsGenerator generator =
    new CoefficientsGenerator(new RationalNumber(1l),
                              new RationalNumber(0l),
                              new RationalNumber(1l)) {
    public void setRecurrenceCoefficients(int k) {
      // the recurrence relation is
      // (k+1) Pk+1(X) = (2k+1) X Pk(X) - k Pk-1(X)
      long kP1 = k + 1;
      setRecurrenceCoefficients(new RationalNumber(0l),
                                new RationalNumber(2 * k + 1, kP1),
                                new RationalNumber(k, kP1));
    }
  };

  /** Simple constructor.
   * Build a degree 0 Legendre polynomial
   */
  public Legendre() {
    super(0, generator);
  }

  /** Simple constructor.
   * Build a degree d Legendre polynomial
   * @param degree degree of the polynomial
   */
  public Legendre(int degree) {
    super(degree, generator);
  }

  private static final long serialVersionUID = 4014485393845978429L;

}
