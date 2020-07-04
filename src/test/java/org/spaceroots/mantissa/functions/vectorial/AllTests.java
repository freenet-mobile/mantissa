package org.spaceroots.mantissa.functions.vectorial;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.functions.vectorial"); 

    suite.addTest(VectorialValuedPairTest.suite()); 
    suite.addTest(ComputableFunctionSamplerTest.suite()); 
    suite.addTest(BasicSampledFunctionIteratorTest.suite());

    return suite; 

  }
}
