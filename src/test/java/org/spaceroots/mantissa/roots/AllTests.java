package org.spaceroots.mantissa.roots;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.roots"); 

    suite.addTest(BrentSolverTest.suite());

    return suite; 

  }
}
