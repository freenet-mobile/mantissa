package org.spaceroots.mantissa.algebra;

/**
 * This class implements Laguerre polynomials.

 * <p>Laguerre polynomials can be defined by the following recurrence
 * relations:
 * <pre>
 *        L<sub>0</sub>(X)   = 1
 *        L<sub>1</sub>(X)   = 1 - X
 *  (k+1) L<sub>k+1</sub>(X) = (2k + 1 - X) L<sub>k</sub>(X) - k L<sub>k-1</sub>(X)
 * </pre></p>

 * @version $Id: Laguerre.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */
public class Laguerre
  extends OrthogonalPolynomial {

  /** Generator for the Laguerre polynomials. */
  private static final CoefficientsGenerator generator =
    new CoefficientsGenerator(new RationalNumber(1l),
                              new RationalNumber(1l),
                              new RationalNumber(-1l)) {
    public void setRecurrenceCoefficients(int k) {
      // the recurrence relation is
      // (k+1) Lk+1(X) = (2k + 1 - X) Lk(X) - k Lk-1(X)
      long kP1 = k + 1;
      setRecurrenceCoefficients(new RationalNumber(2 * k + 1, kP1),
                                new RationalNumber(-1l, kP1),
                                new RationalNumber(k, kP1));
    }
  };

  /** Simple constructor.
   * Build a degree 0 Laguerre polynomial
   */
  public Laguerre() {
    super(0, generator);
  }

  /** Simple constructor.
   * Build a degree d Laguerre polynomial
   * @param degree degree of the polynomial
   */
  public Laguerre(int degree) {
    super(degree, generator);
  }

  private static final long serialVersionUID = 3213856667479179710L;

}
