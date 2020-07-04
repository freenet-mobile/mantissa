package org.spaceroots.mantissa.ode;

import junit.framework.*;

public class FirstOrderConverterTest
  extends TestCase {

  public FirstOrderConverterTest(String name) {
    super(name);
  }

  public void testDoubleDimension() {
    for (int i = 1; i < 10; ++i) {
      SecondOrderDifferentialEquations eqn2 = new Equations(i, 0.2);
      FirstOrderConverter eqn1 = new FirstOrderConverter(eqn2);
      assertTrue(eqn1.getDimension() == (2 * eqn2.getDimension()));
    }
  }
  
  public void testDecreasingSteps()
    throws DerivativeException, IntegratorException {
      
    double previousError = Double.NaN;
    for (int i = 0; i < 10; ++i) {

      double step  = Math.pow(2.0, -(i + 1));
      double error = integrateWithSpecifiedStep(4.0, 0.0, 1.0, step)
                   - Math.sin(4.0);
      if (i > 0) {
        assertTrue(Math.abs(error) < Math.abs(previousError));
      }
      previousError = error;
      
    }
  }

  public void testSmallStep()
    throws DerivativeException, IntegratorException {
    double error = integrateWithSpecifiedStep(4.0, 0.0, 1.0, 1.0e-4)
                   - Math.sin(4.0);
    assertTrue(Math.abs(error) < 1.0e-10);
  }

  public void testBigStep()
    throws DerivativeException, IntegratorException {
    double error = integrateWithSpecifiedStep(4.0, 0.0, 1.0, 0.5)
                   - Math.sin(4.0);
    assertTrue(Math.abs(error) > 0.1);
  }
  
  public static Test suite() {
    return new TestSuite(FirstOrderConverterTest.class);
  }

  private static class Equations
    implements SecondOrderDifferentialEquations {
      
      private int n;

      private double omega2;
      
      public Equations(int n, double omega) {
        this.n = n;
        omega2 = omega * omega;
      }
      
      public int getDimension() {
        return n;
      }
      
      public void computeSecondDerivatives(double t, double[] y, double[] yDot,
                                           double[] yDDot) {
        for (int i = 0; i < n; ++i) {
          yDDot[i] = -omega2 * y[i];
        }
    }
      
  }

  private double integrateWithSpecifiedStep(double omega,
                                            double t0, double t,
                                            double step)
  throws DerivativeException, IntegratorException {
    double[] y0 = new double[2];
    y0[0] = Math.sin(omega * t0);
    y0[1] = omega * Math.cos(omega * t0);
    ClassicalRungeKuttaIntegrator i = new ClassicalRungeKuttaIntegrator(step);
    double[] y = new double[2];
    i.integrate(new FirstOrderConverter(new Equations(1, omega)), t0, y0, t, y);
    return y[0];
  }

}
