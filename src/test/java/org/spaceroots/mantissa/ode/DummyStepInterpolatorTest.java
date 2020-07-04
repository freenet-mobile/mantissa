package org.spaceroots.mantissa.ode;

import junit.framework.*;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class DummyStepInterpolatorTest
  extends TestCase {

  public DummyStepInterpolatorTest(String name) {
    super(name);
  }

  public void testNoReset() {

    double[]   y    =   { 0.0, 1.0, -2.0 };
    DummyStepInterpolator interpolator = new DummyStepInterpolator(y, true);
    interpolator.storeTime(0);
    interpolator.shift();
    interpolator.storeTime(1);

    double[] result = interpolator.getInterpolatedState();
    for (int i = 0; i < result.length; ++i) {
      assertTrue(Math.abs(result[i] - y[i]) < 1.0e-10);
    }

  }

  public void testFixedState()
    throws DerivativeException {

    double[]   y    =   { 1.0, 3.0, -4.0 };
    DummyStepInterpolator interpolator = new DummyStepInterpolator(y, true);
    interpolator.storeTime(0);
    interpolator.shift();
    interpolator.storeTime(1);

    interpolator.setInterpolatedTime(0.1);
    double[] result = interpolator.getInterpolatedState();
    for (int i = 0; i < result.length; ++i) {
        assertTrue(Math.abs(result[i] - y[i]) < 1.0e-10);
    }

    interpolator.setInterpolatedTime(0.5);
    result = interpolator.getInterpolatedState();
    for (int i = 0; i < result.length; ++i) {
        assertTrue(Math.abs(result[i] - y[i]) < 1.0e-10);
    }

  }

  public void testSerialization()
    throws DerivativeException, IntegratorException,
           IOException, ClassNotFoundException {

      double[]   y    =   { 0.0, 1.0, -2.0 };
      DummyStepInterpolator interpolator = new DummyStepInterpolator(y, true);
      interpolator.storeTime(0);
      interpolator.shift();
      interpolator.storeTime(1);

      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream    oos = new ObjectOutputStream(bos);
      oos.writeObject(interpolator);

      assertTrue(bos.size () > 150);
      assertTrue(bos.size () < 250);

      ByteArrayInputStream  bis = new ByteArrayInputStream(bos.toByteArray());
      ObjectInputStream     ois = new ObjectInputStream(bis);
      DummyStepInterpolator dsi = (DummyStepInterpolator) ois.readObject();

      dsi.setInterpolatedTime(0.5);
      double[] result = dsi.getInterpolatedState();
      for (int i = 0; i < result.length; ++i) {
          assertTrue(Math.abs(result[i] - y[i]) < 1.0e-10);
      }

  }

  public static Test suite() {
    return new TestSuite(DummyStepInterpolatorTest.class);
  }

}
