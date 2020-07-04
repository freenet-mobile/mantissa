package org.spaceroots.mantissa.random;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() {

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.random"); 

    suite.addTest(ScalarSampleStatisticsTest.suite());
    suite.addTest(VectorialSampleStatisticsTest.suite());
    suite.addTest(UniformRandomGeneratorTest.suite()); 
    suite.addTest(GaussianRandomGeneratorTest.suite()); 
    suite.addTest(UncorrelatedRandomVectorGeneratorTest.suite()); 
    suite.addTest(CorrelatedRandomVectorGeneratorTest.suite()); 
    suite.addTest(FourTapRandomTest.suite());
    suite.addTest(MersenneTwisterTest.suite());
    return suite; 

  }
}
