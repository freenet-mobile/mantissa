package org.spaceroots.mantissa.functions;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.functions"); 

    suite.addTest(org.spaceroots.mantissa.functions.scalar.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.functions.vectorial.AllTests.suite()); 

    return suite;
 
  }
}
