package org.spaceroots.mantissa.algebra;

/**
 * This class is the base class for orthogonal polynomials.

 * <p>Orthogonal polynomials can be defined by recurrence relations like:
 * <pre>
 *      O<sub>0</sub>(X)   = some 0 degree polynomial
 *      O<sub>1</sub>(X)   = some first degree polynomial
 *  a<sub>1,k</sub> O<sub>k+1</sub>(X) = (a<sub>2,k</sub> + a<sub>3,k</sub> X) O<sub>k</sub>(X) - a<sub>4,k</sub> O<sub>k-1</sub>(X)
 * </pre>
 * where a<sub>1,k</sub>, a<sub>2,k</sub>, a<sub>3,k</sub> and
 * a<sub>4,k</sub> are simple expressions which either are
 * constants or depend on k.</p>

 * @version $Id: OrthogonalPolynomial.java 1711 2006-12-13 21:27:51Z luc $
 * @author L. Maisonobe

 */
public abstract class OrthogonalPolynomial
  extends Polynomial.Rational {

  /** Simple constructor.
   * Build a degree d orthogonal polynomial
   * @param degree degree of the polynomial
   * @param generator coefficients generator for the current type of polynomials
   */
  protected OrthogonalPolynomial(int degree, CoefficientsGenerator generator) {
    a       = generator.getCoefficients(degree);
  }

}
