package org.spaceroots.mantissa.algebra;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.algebra"); 

    suite.addTest(RationalNumberTest.suite());
    suite.addTest(PolynomialRationalTest.suite());
    suite.addTest(PolynomialDoubleTest.suite());
    suite.addTest(ChebyshevTest.suite());
    suite.addTest(HermiteTest.suite());
    suite.addTest(LegendreTest.suite());
    suite.addTest(LaguerreTest.suite());
    suite.addTest(PolynomialFractionTest.suite());

    return suite; 

  }
}
