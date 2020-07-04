package org.spaceroots.mantissa.linalg;

/** This class is a factory for the linear algebra package.

 * <p>This class is devoted to building the right type of matrix
 * according to the structure of the non null elements.</p>

 * <p>This is a utility class, no instance of this class should be
 * built, so the constructor is explicitly made private.</p>

 * @version $Id: MatrixFactory.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */

public class MatrixFactory {
  /** Simple constructor.
   * Since the class is a utility class with only static methods, the
   * constructor is made private to prevent creating instances of this
   * class.
   */
  private MatrixFactory() {
  }

  /** Build a matrix of the right subtype.
   * Build the right subtype of matrix according to the structure of
   * the non null elements of the instance. Note that the information
   * provided does not allow to build instances of the {@link
   * SymetricalMatrix} class. When the data corresponding to a
   * symetrical matrix is given, this method can only build an
   * instance of the {@link GeneralSquareMatrix} class.
   * @param rows number of row of the matrix
   * @param columns number of columns of the matrix
   * @param data table of the matrix elements (stored row after row)
   * @param lowerElements number of non null elements in the lower triangle
   * @param upperElements number of non null elements in the upper triangle
   * @return a matrix containing the instance
   */
  public static Matrix buildMatrix(int rows, int columns, double[] data,
                                   int lowerElements, int upperElements) {
    if (rows == columns) {
      if (lowerElements == 0 && upperElements == 0) {
        return new DiagonalMatrix(rows, data);
      } else if (lowerElements == 0) {
        return new UpperTriangularMatrix(rows, data);
      } else if (upperElements == 0) {
        return new LowerTriangularMatrix(rows, data);
      } else {
        return new GeneralSquareMatrix(rows, data);
      }
    }
    return new GeneralMatrix(rows, columns, data);
  }

  /** Build a matrix of the right subtype.
   * Build the right subtype of matrix according to the dimensions.
   * @param rows number of row of the matrix
   * @param columns number of columns of the matrix
   * @param data table of the matrix elements (stored row after row)
   * @return a matrix containing the instance
   */
  public static Matrix buildMatrix(int rows, int columns, double[] data) {
    if (rows == columns) {
      return new GeneralSquareMatrix(rows, data);
    }
    return new GeneralMatrix(rows, columns, data);
  }

}
