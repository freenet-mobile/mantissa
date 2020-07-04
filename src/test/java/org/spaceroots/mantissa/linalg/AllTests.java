package org.spaceroots.mantissa.linalg;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() {

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.linalg"); 

    suite.addTest(NonNullRangeTest.suite()); 
    suite.addTest(GeneralMatrixTest.suite()); 
    suite.addTest(DiagonalMatrixTest.suite()); 
    suite.addTest(LowerTriangularMatrixTest.suite()); 
    suite.addTest(UpperTriangularMatrixTest.suite()); 
    suite.addTest(GeneralSquareMatrixTest.suite()); 
    suite.addTest(SymetricalMatrixTest.suite()); 
    suite.addTest(MatrixFactoryTest.suite());

    return suite; 

  }
}
