package org.spaceroots.mantissa.quadrature.vectorial;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.quadrature.vectorial"); 

    suite.addTest(GaussLegendreIntegratorTest.suite());

    return suite; 

  }
}
