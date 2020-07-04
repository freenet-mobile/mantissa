package org.spaceroots.mantissa.ode;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.ode"); 

    suite.addTest(DummyStepInterpolatorTest.suite());
    suite.addTest(EulerStepInterpolatorTest.suite());
    suite.addTest(EulerIntegratorTest.suite());
    suite.addTest(MidpointIntegratorTest.suite());
    suite.addTest(ClassicalRungeKuttaIntegratorTest.suite());
    suite.addTest(GillIntegratorTest.suite());
    suite.addTest(ThreeEighthesIntegratorTest.suite());
    suite.addTest(HighamHall54IntegratorTest.suite());
    suite.addTest(DormandPrince54IntegratorTest.suite());
    suite.addTest(DormandPrince853IntegratorTest.suite());
    suite.addTest(GraggBulirschStoerIntegratorTest.suite());
    suite.addTest(FirstOrderConverterTest.suite());
    suite.addTest(StepNormalizerTest.suite());
    suite.addTest(ContinuousOutputModelTest.suite());
    suite.addTest(ClassicalRungeKuttaStepInterpolatorTest.suite());
    suite.addTest(GillStepInterpolatorTest.suite());
    suite.addTest(ThreeEighthesStepInterpolatorTest.suite());
    suite.addTest(DormandPrince853StepInterpolatorTest.suite());
    suite.addTest(DormandPrince54StepInterpolatorTest.suite());
    suite.addTest(HighamHall54StepInterpolatorTest.suite());
    suite.addTest(MidpointStepInterpolatorTest.suite());
    suite.addTest(GraggBulirschStoerStepInterpolatorTest.suite());

    return suite; 

  }
}
