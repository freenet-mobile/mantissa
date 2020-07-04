package org.spaceroots.mantissa.utilities;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
  public static Test suite() { 

    TestSuite suite = new TestSuite("org.spaceroots.mantissa.utilities"); 

    suite.addTest(ArrayMapperTest.suite());
    suite.addTest(MappableArrayTest.suite());
    suite.addTest(MappableScalarTest.suite());
    suite.addTest(IntervalTest.suite());
    suite.addTest(IntervalsListTest.suite());

    return suite; 

  }
}
