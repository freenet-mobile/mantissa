package org.spaceroots.mantissa.utilities;

/**
 * Wrapper class around a scalar in order to have it implement the
 * {@link ArraySliceMappable} interface.

 * @version $Id: MappableScalar.java 1346 2002-09-05 19:03:58Z luc $
 * @author L. Maisonobe

 */

public class MappableScalar
  implements ArraySliceMappable {

  /** Simple constructor.
   * Build a mappable scalar
   */
  public MappableScalar() {
    value = 0;
  }

  /** Simple constructor.
   * Build a mappable scalar from its initial value
   * @param value initial value of the scalar
   */
  public MappableScalar(double value) {
    this.value = value;
  }

  /** Get the value stored in the instance.
   * @return value stored in the instance
   */
  public double getValue () {
    return value;
  }

  /** Set the value stored in the instance.
   * @param value value to store in the instance
   */
  public void setValue (double value) {
    this.value = value;
  }

  /** Get the dimension of the internal array.
   * @return dimension of the array (always 1 for this class)
   */
  public int getStateDimension() {
    return 1;
  }
    
  /** Reinitialize internal state from the specified array slice data.
   * @param start start index in the array
   * @param array array holding the data to extract
   */
  public void mapStateFromArray(int start, double[] array) {
    value = array[start];
  }
    
  /** Store internal state data into the specified array slice.
   * @param start start index in the array
   * @param array array where data should be stored
   */
  public void mapStateToArray(int start, double[] array) {
    array[start] = value;
  }

  /** Internal scalar.
   */
  double value;

}
