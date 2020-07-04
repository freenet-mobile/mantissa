package org.spaceroots.mantissa.utilities;

import junit.framework.*;

public class MappableScalarTest
  extends TestCase {

  public MappableScalarTest(String name) {
    super(name);
    mapper  = null;
    scalar1 = null;
    scalar2 = null;
    scalar3 = null;
  }

  public void testDimensionCheck() {
    assertTrue(mapper.getDataArray().length == 3);
  }

  public void testUpdateObjects() {

    double[] data = new double [mapper.getDataArray().length];
    for (int i = 0; i < data.length; ++i) {
      data [i] = i * 0.1;
    }

    mapper.updateObjects(data);

    assertTrue(Math.abs(scalar1.getValue() - 0.0) < 1.0e-10);
    assertTrue(Math.abs(scalar2.getValue() - 0.1) < 1.0e-10);
    assertTrue(Math.abs(scalar3.getValue() - 0.2) < 1.0e-10);

  }
  
  public void testUpdateArray() {

    scalar1.setValue(00.0);
    scalar2.setValue(10.0);
    scalar3.setValue(20.0);

    mapper.updateArray();

    double[] data = mapper.getDataArray();
    for (int i = 0; i < data.length; ++i) {
      assertTrue(Math.abs(data [i] - i * 10.0) < 1.0e-10);
    }

  }
  
  public static Test suite() {
    return new TestSuite(MappableScalarTest.class);
  }

  public void setUp() {

    scalar1 = new MappableScalar();
    scalar2 = new MappableScalar(2);
    scalar3 = new MappableScalar(-3);

    mapper = new ArrayMapper();
    mapper.manageMappable(scalar1);
    mapper.manageMappable(scalar2);
    mapper.manageMappable(scalar3);

  }

  public void tearDown() {

    scalar1 = null;
    scalar2 = null;
    scalar3 = null;

    mapper = null;

  }

  private MappableScalar scalar1;
  private MappableScalar scalar2;
  private MappableScalar scalar3;

  private ArrayMapper mapper;

}
