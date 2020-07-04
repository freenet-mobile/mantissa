package org.spaceroots.mantissa.estimation;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.estimation"); 

    suite.addTest(EstimatedParameterTest.suite());
    suite.addTest(WeightedMeasurementTest.suite());
    suite.addTest(GaussNewtonEstimatorTest.suite());
    suite.addTest(LevenbergMarquardtEstimatorTest.suite());
    suite.addTest(MinpackTest.suite());

    return suite; 

  }

}
