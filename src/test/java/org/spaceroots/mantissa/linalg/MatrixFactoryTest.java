package org.spaceroots.mantissa.linalg;

import junit.framework.*;

public class MatrixFactoryTest
  extends TestCase {

  public MatrixFactoryTest(String name) {
    super(name);
  }

  public void testInvalidDimensions() {
    boolean gotIt;

    gotIt = false;
    try {
      MatrixFactory.buildMatrix(0, 2, null, 1, 1);
    } catch (IllegalArgumentException e) {
      gotIt = true;
    }
    assertTrue(gotIt);

  }

  public void testDiagonal() {
    Matrix m = MatrixFactory.buildMatrix(3, 3, null, 0, 0);
    assertTrue(m instanceof DiagonalMatrix);
  }

  public void testLowerTriangular() {
    Matrix m = MatrixFactory.buildMatrix(3, 3, null, 1, 0);
    assertTrue(m instanceof LowerTriangularMatrix);
  }

  public void testUpperTriangular() {
    Matrix m = MatrixFactory.buildMatrix(3, 3, null, 0, 1);
    assertTrue(m instanceof UpperTriangularMatrix);
  }

  public void testSquare() {
    Matrix m = MatrixFactory.buildMatrix(3, 3, null, 1, 1);
    assertTrue(m instanceof GeneralSquareMatrix);
  }

  public void testGeneral() {
    Matrix m = MatrixFactory.buildMatrix(3, 4, null, 0, 0);
    assertTrue(m instanceof GeneralMatrix);
  }

  public static Test suite() {
    return new TestSuite(MatrixFactoryTest.class);
  }

}
