package org.spaceroots.mantissa.quadrature;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{
  public static Test suite ()
  { 
    TestSuite suite= new TestSuite ("org.spaceroots.mantissa.quadrature"); 
    suite.addTest (org.spaceroots.mantissa.quadrature.scalar.AllTests.suite ());
    suite.addTest (org.spaceroots.mantissa.quadrature.vectorial.AllTests.suite ());
    return suite; 
  }
}
