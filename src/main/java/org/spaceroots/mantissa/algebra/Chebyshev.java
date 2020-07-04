package org.spaceroots.mantissa.algebra;

/**
 * This class implements Chebyshev polynomials.

 * <p>Chebyshev polynomials can be defined by the following recurrence
 * relations:
 * <pre>
 *  T<sub>0</sub>(X)   = 1
 *  T<sub>1</sub>(X)   = X
 *  T<sub>k+1</sub>(X) = 2X T<sub>k</sub>(X) - T<sub>k-1</sub>(X)
 * </pre></p>

 * @version $Id: Chebyshev.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class Chebyshev
  extends OrthogonalPolynomial {

  /** Generator for the Chebyshev polynomials. */
  private static final CoefficientsGenerator generator =
    new CoefficientsGenerator(new RationalNumber(1l),
                              new RationalNumber(0l),
                              new RationalNumber(1l)) {
    public void setRecurrenceCoefficients(int k) {
      // the recurrence relation is
      // Tk+1(X) = 2X Tk(X) - Tk-1(X)
      setRecurrenceCoefficients(new RationalNumber(0l),
                                new RationalNumber(2l),
                                new RationalNumber(1l));
    }
  };

  /** Simple constructor.
   * Build a degree 0 Chebyshev polynomial
   */
  public Chebyshev() {
    super(0, generator);
  }

  /** Simple constructor.
   * Build a degree d Chebyshev polynomial
   * @param degree degree of the polynomial
   */
  public Chebyshev(int degree) {
    super(degree, generator);
  }

  private static final long serialVersionUID = -893367988717182601L;

}
