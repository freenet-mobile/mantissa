package org.spaceroots.mantissa.ode;

import junit.framework.*;
import java.util.Random;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ClassicalRungeKuttaStepInterpolatorTest
  extends TestCase {

  public ClassicalRungeKuttaStepInterpolatorTest(String name) {
    super(name);
  }

  public void testSerialization()
    throws DerivativeException, IntegratorException,
           IOException, ClassNotFoundException {

    TestProblem3 pb = new TestProblem3(0.9);
    double step = (pb.getFinalTime() - pb.getInitialTime()) * 0.0003;
    ClassicalRungeKuttaIntegrator integ = new ClassicalRungeKuttaIntegrator(step);
    integ.setStepHandler(new ContinuousOutputModel());
    integ.integrate(pb,
                    pb.getInitialTime(), pb.getInitialState(),
                    pb.getFinalTime(), new double[pb.getDimension()]);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream    oos = new ObjectOutputStream(bos);
    oos.writeObject(integ.getStepHandler());

    assertTrue(bos.size () > 700000);
    assertTrue(bos.size () < 701000);

    ByteArrayInputStream  bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream     ois = new ObjectInputStream(bis);
    ContinuousOutputModel cm  = (ContinuousOutputModel) ois.readObject();

    Random random = new Random(347588535632l);
    double maxError = 0.0;
    for (int i = 0; i < 1000; ++i) {
      double r = random.nextDouble();
      double time = r * pb.getInitialTime() + (1.0 - r) * pb.getFinalTime();
      cm.setInterpolatedTime(time);
      double[] interpolatedY = cm.getInterpolatedState ();
      double[] theoreticalY  = pb.computeTheoreticalState(time);
      double dx = interpolatedY[0] - theoreticalY[0];
      double dy = interpolatedY[1] - theoreticalY[1];
      double error = dx * dx + dy * dy;
      if (error > maxError) {
        maxError = error;
      }
    }

    assertTrue(maxError > 0.005);

  }

  public static Test suite() {
    return new TestSuite(ClassicalRungeKuttaStepInterpolatorTest.class);
  }

}
