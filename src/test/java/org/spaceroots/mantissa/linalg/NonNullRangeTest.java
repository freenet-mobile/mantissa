package org.spaceroots.mantissa.linalg;

import junit.framework.*;

public class NonNullRangeTest
  extends TestCase {

  public NonNullRangeTest(String name) {
    super(name);
  }

  public void testPublicAttributes() {
    NonNullRange r = new NonNullRange(2, 7);
    assertTrue(r.begin == 2);
    assertTrue(r.end   == 7);
  }

  public void testCopy() {
    NonNullRange r1 = new NonNullRange(2, 7);
    NonNullRange r2 = new NonNullRange(r1);
    assertTrue(r2.begin == r1.begin);
    assertTrue(r1.end   == r1.end);
  }

  public void testIntersection() {
    NonNullRange r1 = new NonNullRange(-4, 8);
    NonNullRange r2 = new NonNullRange(3, 12);
    NonNullRange r3 = NonNullRange.intersection(r1, r2);
    assertTrue(r3.begin == 3);
    assertTrue(r3.end   == 8);
  }

  public void testReunion() {
    NonNullRange r1 = new NonNullRange(-4, 8);
    NonNullRange r2 = new NonNullRange(3, 12);
    NonNullRange r3 = NonNullRange.reunion(r1, r2);
    assertTrue(r3.begin == -4);
    assertTrue(r3.end   == 12);
  }

  public static Test suite() {
    return new TestSuite(NonNullRangeTest.class);
  }

}
