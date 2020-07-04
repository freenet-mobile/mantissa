package org.spaceroots.mantissa.estimation;

import junit.framework.*;

public class EstimatedParameterTest
  extends TestCase {

  public EstimatedParameterTest(String name) {
    super(name);
  }

  public void testConstruction() {

    EstimatedParameter p1 = new EstimatedParameter("p1", 1.0);
    assertTrue(p1.getName().equals("p1"));
    checkValue(p1.getEstimate(), 1.0);
    assertTrue(! p1.isBound());

    EstimatedParameter p2 = new EstimatedParameter("p2", 2.0, true);
    assertTrue(p2.getName().equals("p2"));
    checkValue(p2.getEstimate(), 2.0);
    assertTrue(p2.isBound());

  }

  public void testBound() {

    EstimatedParameter p = new EstimatedParameter("p", 0.0);
    assertTrue(! p.isBound());
    p.setBound(true);
    assertTrue(p.isBound());
    p.setBound(false);
    assertTrue(! p.isBound());

  }

  public void testEstimate() {

    EstimatedParameter p = new EstimatedParameter("p", 0.0);
    checkValue(p.getEstimate(), 0.0);

    for (double e = 0.0; e < 10.0; e += 0.5) {
      p.setEstimate(e);
      checkValue(p.getEstimate(), e);
    }

  }

  public static Test suite() {
    return new TestSuite(EstimatedParameterTest.class);
  }

  private void checkValue(double value, double expected) {
    assertTrue(Math.abs(value - expected) < 1.0e-10);
  }

}
