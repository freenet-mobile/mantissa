package org.spaceroots.mantissa.random;

import junit.framework.*;

public class FourTapRandomTest
  extends TestCase {

  public FourTapRandomTest(String name) {
    super(name);
  }

  public void testDouble() {
    FourTapRandom ftr = new FourTapRandom(195357343514l);
    ScalarSampleStatistics sample = new ScalarSampleStatistics();
    for (int i = 0; i < 1000; ++i) {
      sample.add(ftr.nextDouble());
    }
    assertEquals(0.5, sample.getMean(), 0.02);
    assertEquals(1.0 / (2.0 * Math.sqrt(3.0)),
                 sample.getStandardDeviation(),
                 0.002);
  }

  public void testNextInt() {
    FourTapRandom ftr = new FourTapRandom(0x12b8a7412bb25el);
    for (int n = 1; n < 20; ++n) {
      int[] count = new int[n];
      for (int k = 0; k < 10000; ++k) {
        int l = ftr.nextInt(n);
        ++count[l];
        assertTrue(l >= 0);
        assertTrue(l <  n);
      }
      for (int i = 0; i < n; ++i) {
        assertTrue(n * count[i] >  8800);
        assertTrue(n * count[i] < 11200);
      }
    }
  }

  public static Test suite() {
    return new TestSuite(FourTapRandomTest.class);
  }

}
