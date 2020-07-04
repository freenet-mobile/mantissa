package org.spaceroots.mantissa.functions.scalar;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.functions.scalar"); 

    suite.addTest(ScalarValuedPairTest.suite()); 
    suite.addTest(ComputableFunctionSamplerTest.suite()); 
    suite.addTest(BasicSampledFunctionIteratorTest.suite());

    return suite; 

  }
}
