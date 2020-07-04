package org.spaceroots.mantissa.random;

import junit.framework.*;

public class GaussianRandomGeneratorTest
  extends TestCase {

  public GaussianRandomGeneratorTest(String name) {
    super(name);
  }

  public void testMeanAndStandardDeviation() {
    GaussianRandomGenerator generator = new GaussianRandomGenerator(17399225432l);
    ScalarSampleStatistics sample = new ScalarSampleStatistics();
    for (int i = 0; i < 10000; ++i) {
      sample.add(generator.nextDouble());
    }
    assertEquals(0.0, sample.getMean(), 0.012);
    assertEquals(1.0, sample.getStandardDeviation(), 0.01);
  }

  public static Test suite() {
    return new TestSuite(GaussianRandomGeneratorTest.class);
  }

}
