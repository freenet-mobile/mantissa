package org.spaceroots.mantissa.fitting;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite= new TestSuite("org.spaceroots.mantissa.fitting"); 

    suite.addTest(AbstractCurveFitterTest.suite());
    suite.addTest(PolynomialFitterTest.suite());
    suite.addTest(HarmonicFitterTest.suite());

    return suite; 

  }
}
