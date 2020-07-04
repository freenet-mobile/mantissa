package org.spaceroots.mantissa.quadrature.scalar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.quadrature.scalar"); 

    suite.addTest(GaussLegendreIntegratorTest.suite());

    return suite; 

  }
}
