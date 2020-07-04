package org.spaceroots.mantissa.random;

/** This class implements a normalized uniform random generator.

 * <p>Since this is a normalized random generator, it has a null mean
 * and a unit standard deviation. Beeing also a uniform
 * generator, it produces numbers in the range [-sqrt(3) ;
 * sqrt(3)]. It uses the {@link MersenneTwister MersenneTwister}
 * generator as the underlying generator.</p>

 * @see MersenneTwister
 * @version $Id: UniformRandomGenerator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class UniformRandomGenerator
  implements NormalizedRandomGenerator {

  /** Create a new generator.
   * The seed of the generator is related to the current time.
   */
  public UniformRandomGenerator() {
    generator = new MersenneTwister();
  }

  /** Creates a new random number generator using a single int seed.
   * @param seed the initial seed (32 bits integer)
   */
  public UniformRandomGenerator(int seed) {
    generator = new MersenneTwister(seed);
  }

  /** Creates a new random number generator using an int array seed.
   * @param seed the initial seed (32 bits integers array), if null
   * the seed of the generator will be related to the current time
   */
  public UniformRandomGenerator(int[] seed) {
    generator = new MersenneTwister(seed);
  }

  /** Create a new generator initialized with a single long seed.
   * @param seed seed for the generator (64 bits integer)
   */
  public UniformRandomGenerator(long seed) {
    generator = new MersenneTwister(seed);
  }

  /** Generate a random scalar with null mean and unit standard deviation.
   * <p>The number generated is uniformly distributed between -sqrt(3)
   * and sqrt(3).</p>
   * @return a random scalar with null mean and unit standard deviation
   */
  public double nextDouble() {
    return TWOSQRT3 * generator.nextDouble() - SQRT3;
  }

  /** Underlying generator. */
  MersenneTwister generator;

  private static final double SQRT3 = Math.sqrt(3.0);

  private static final double TWOSQRT3 = 2.0 * Math.sqrt(3.0);

  private static final long serialVersionUID = -6913329325753217654L;

}
