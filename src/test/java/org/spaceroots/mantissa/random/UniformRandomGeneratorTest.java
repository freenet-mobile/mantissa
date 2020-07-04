package org.spaceroots.mantissa.random;

import junit.framework.*;

public class UniformRandomGeneratorTest
  extends TestCase {

  public UniformRandomGeneratorTest(String name) {
    super(name);
  }

  public void testMeanAndStandardDeviation() {
    UniformRandomGenerator generator = new UniformRandomGenerator(17399225432l);
    ScalarSampleStatistics sample = new ScalarSampleStatistics();
    for (int i = 0; i < 1000; ++i) {
      sample.add(generator.nextDouble());
    }
    assertEquals(0.0, sample.getMean(), 0.07);
    assertEquals(1.0, sample.getStandardDeviation(), 0.02);
  }

  public static Test suite() {
    return new TestSuite(UniformRandomGeneratorTest.class);
  }

}
