package org.spaceroots.mantissa.functions.vectorial;

import junit.framework.*;

public class VectorialValuedPairTest
  extends TestCase {

  public VectorialValuedPairTest(String name) {
    super(name);
  }

  public void testConstructor() {
    double[] tab = new double[2];
    tab[0] = -8.4;
    tab[1] = -3.2;
    VectorialValuedPair pair = new VectorialValuedPair(1.2, tab);
    assertTrue(Math.abs(pair.x    - 1.2) < 1.0e-10);
    assertTrue(Math.abs(pair.y[0] + 8.4) < 1.0e-10);
    assertTrue(Math.abs(pair.y[1] + 3.2) < 1.0e-10);
  }

  public void testCopyConstructor() {
    double[] tab = new double[2];
    tab[0] = -8.4;
    tab[1] = -3.2;
    VectorialValuedPair pair1 = new VectorialValuedPair(1.2, tab);
    VectorialValuedPair pair2 = new VectorialValuedPair(pair1.x,
                                                        pair1.y);
    assertTrue(Math.abs(pair2.x    - pair1.x)    < 1.0e-10);
    assertTrue(Math.abs(pair2.y[0] - pair1.y[0]) < 1.0e-10);
    assertTrue(Math.abs(pair2.y[1] - pair1.y[1]) < 1.0e-10);
    assertTrue(Math.abs(pair2.x    - 1.2)        < 1.0e-10);
    assertTrue(Math.abs(pair2.y[0] + 8.4)        < 1.0e-10);
    assertTrue(Math.abs(pair2.y[1] + 3.2)        < 1.0e-10);
  }

  public static Test suite() {
    return new TestSuite(VectorialValuedPairTest.class);
  }

}
