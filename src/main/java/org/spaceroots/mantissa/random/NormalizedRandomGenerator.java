package org.spaceroots.mantissa.random;

import java.io.Serializable;

/** This interface represent a normalized random generator for
 * scalars.
 * Normalized generator should provide null mean and unit standard
 * deviation scalars.
 * @version $Id: NormalizedRandomGenerator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe
 */
public interface NormalizedRandomGenerator extends Serializable {

  /** Generate a random scalar with null mean and unit standard deviation.
   * <p>This method does <strong>not</strong> specify the shape of the
   * distribution, it is the implementing class that provides it. The
   * only contract here is to generate numbers with null mean and unit
   * standard deviation.</p>
   * @return a random scalar
   */
  public double nextDouble();

}
