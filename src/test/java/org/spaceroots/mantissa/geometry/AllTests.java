package org.spaceroots.mantissa.geometry;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.geometry"); 

    suite.addTest(Vector3DTest.suite());
    suite.addTest(RotationTest.suite());

    return suite; 

  }
}
