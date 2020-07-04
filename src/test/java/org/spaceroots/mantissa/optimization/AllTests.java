package org.spaceroots.mantissa.optimization;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() { 

    TestSuite suite= new TestSuite("org.spaceroots.mantissa.optimization"); 

    suite.addTest(NelderMeadTest.suite()); 
    suite.addTest(MultiDirectionalTest.suite()); 

    return suite; 

  }

}
