package org.spaceroots.mantissa;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() { 

    TestSuite suite= new TestSuite("org.spaceroots.mantissa"); 

    suite.addTest(org.spaceroots.mantissa.linalg.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.estimation.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.functions.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.roots.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.fitting.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.ode.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.quadrature.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.utilities.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.geometry.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.algebra.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.random.AllTests.suite()); 
    suite.addTest(org.spaceroots.mantissa.optimization.AllTests.suite()); 

    return suite; 

  }

}
