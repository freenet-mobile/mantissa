package org.spaceroots.mantissa.random;

/** This interface represent a random generator for whole vectors.

 * @version $Id: RandomVectorGenerator.java 1485 2003-02-23 13:34:02Z luc $
 * @author L. Maisonobe

 */

public interface RandomVectorGenerator {

  /** Generate a random vector.
   * @return a random vector as an array of double. The generator
   * <em>will</em> reuse the same array for each call, in order to
   * save the allocation time, so the user should keep a copy by
   * himself if he needs so.
   */
  public double[] nextVector();

}
