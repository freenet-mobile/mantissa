package org.spaceroots.mantissa.ode;

import junit.framework.*;

public class StepNormalizerTest
  extends TestCase {

  public StepNormalizerTest(String name) {
    super(name);
    pb    = null;
    integ = null;
  }

  public void testBoundaries()
    throws DerivativeException, IntegratorException {
    double range = pb.getFinalTime() - pb.getInitialTime();
    setLastSeen(false);
    integ.setStepHandler(new StepNormalizer(range / 10.0,
                                       new FixedStepHandler() {
                                         private boolean firstCall = true;
                                         public void handleStep(double t,
                                                                double[] y,
                                                                boolean isLast) {
                                           if (firstCall) {
                                             checkValue(t, pb.getInitialTime());
                                             firstCall = false;
                                           }
                                           if (isLast) {
                                             setLastSeen(true);
                                             checkValue(t, pb.getFinalTime());
                                           }
                                         }
                                       }));
    integ.integrate(pb,
                    pb.getInitialTime(), pb.getInitialState(),
                    pb.getFinalTime(), new double[pb.getDimension()]);
    assertTrue(lastSeen);
  }

  public void testBeforeEnd()
    throws DerivativeException, IntegratorException {
    final double range = pb.getFinalTime() - pb.getInitialTime();
    setLastSeen(false);
    integ.setStepHandler(new StepNormalizer(range / 10.5,
                                       new FixedStepHandler() {
                                         public void handleStep(double t,
                                                                double[] y,
                                                                boolean isLast) {
                                           if (isLast) {
                                             setLastSeen(true);
                                             checkValue(t,
                                                        pb.getFinalTime() - range / 21.0);
                                           }
                                         }
                                       }));
    integ.integrate(pb,
                    pb.getInitialTime(), pb.getInitialState(),
                    pb.getFinalTime(), new double[pb.getDimension()]);
    assertTrue(lastSeen);
  }

  public void checkValue(double value, double reference) {
    assertTrue(Math.abs(value - reference) < 1.0e-10);
  }

  public void setLastSeen(boolean lastSeen) {
    this.lastSeen = lastSeen;
  }

  public static Test suite() {
    return new TestSuite(StepNormalizerTest.class);
  }

  public void setUp() {
    pb = new TestProblem3(0.9);
    double minStep = 0;
    double maxStep = pb.getFinalTime() - pb.getInitialTime();
    integ = new DormandPrince54Integrator(minStep, maxStep, 10.e-8, 1.0e-8);
    lastSeen = false;
  }

  public void tearDown() {
    pb    = null;
    integ = null;
  }

  TestProblem3 pb;
  FirstOrderIntegrator integ;
  boolean lastSeen;

}
