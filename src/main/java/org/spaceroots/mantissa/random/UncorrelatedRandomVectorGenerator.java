package org.spaceroots.mantissa.random;

import java.io.Serializable;

/** This class allows to generate random vectors with uncorrelated components.

 * @version $Id: UncorrelatedRandomVectorGenerator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class UncorrelatedRandomVectorGenerator
  implements Serializable, RandomVectorGenerator {

  /** Simple constructor.
   * <p>Build an uncorrelated random vector generator from its mean
   * and standard deviation vectors.</p>
   * @param mean expected mean values for all components
   * @param standardDeviation standard deviation for all components
   * @param generator underlying generator for uncorrelated normalized
   * components
   * @exception IllegalArgumentException if there is a dimension
   * mismatch between the mean and standard deviation vectors
   */
  public UncorrelatedRandomVectorGenerator(double[] mean,
                                           double[] standardDeviation,
                                           NormalizedRandomGenerator generator) {

    if (mean.length != standardDeviation.length) {
      throw new IllegalArgumentException("dimension mismatch");
    }
    this.mean              = (double[]) mean.clone();
    this.standardDeviation = (double[]) standardDeviation.clone();

    this.generator = generator;

  }

  /** Simple constructor.
   * <p>Build a null mean random and unit standard deviation
   * uncorrelated vector generator</p>
   * @param dimension dimension of the vectors to generate
   * @param generator underlying generator for uncorrelated normalized
   * components
   */
  public UncorrelatedRandomVectorGenerator(int dimension,
                                           NormalizedRandomGenerator generator) {

    mean              = new double[dimension];
    standardDeviation = new double[dimension];
    for (int i = 0; i < dimension; ++i) {
      mean[i]              = 0;
      standardDeviation[i] = 1;
    }

    this.generator = generator;

  }

  /** Get the underlying normalized components generator.
   * @return underlying uncorrelated components generator
   */
  public NormalizedRandomGenerator getGenerator() {
    return generator;
  }

  /** Generate a correlated random vector.
   * @return a random vector as an array of double. The returned array
   * is created at each call, the caller can do what it wants with it.
   */
  public double[] nextVector() {

    double[] random = new double[mean.length]; 
    for (int i = 0; i < random.length; ++i) {
      random[i] = mean[i] + standardDeviation[i] * generator.nextDouble();
    }

    return random;

  }

  /** Mean vector. */
  private double[] mean;

  /** Standard deviation vector. */
  private double[] standardDeviation;

  /** Underlying scalar generator. */
  NormalizedRandomGenerator generator;

  private static final long serialVersionUID = -9094322067568302961L;

}
