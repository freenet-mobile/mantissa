package org.spaceroots.mantissa.functions.scalar;

import junit.framework.*;

public class ScalarValuedPairTest
  extends TestCase {

  public ScalarValuedPairTest(String name) {
    super(name);
  }

  public void testConstructor() {
    ScalarValuedPair pair = new ScalarValuedPair(1.2, -8.4);
    assertTrue(Math.abs(pair.getX() - 1.2) < 1.0e-10);
    assertTrue(Math.abs(pair.getY() + 8.4) < 1.0e-10);
  }

  public void testCopyConstructor() {

    ScalarValuedPair pair1 = new ScalarValuedPair(1.2, -8.4);
    ScalarValuedPair pair2 = new ScalarValuedPair(pair1);

    assertTrue(Math.abs(pair2.getX() - pair1.getX()) < 1.0e-10);
    assertTrue(Math.abs(pair2.getY() - pair1.getY()) < 1.0e-10);
    assertTrue(Math.abs(pair2.getX() - 1.2) < 1.0e-10);
    assertTrue(Math.abs(pair2.getY() + 8.4) < 1.0e-10);

  }

  public static Test suite() {
    return new TestSuite(ScalarValuedPairTest.class);
  }

}
