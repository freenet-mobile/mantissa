package org.spaceroots.mantissa.random;

/** This class is a gaussian normalized random generator
 * for scalars.

 * <p>This class is a simple interface adaptor around the {@link
 * MersenneTwister MersenneTwister} generator, which calls its {@link
 * java.util.Random#nextGaussian nextGaussian} method.</p>

 * @see MersenneTwister
 * @version $Id: GaussianRandomGenerator.java 1709 2006-12-03 21:16:50Z luc $
 * @author L. Maisonobe

 */

public class GaussianRandomGenerator
  implements NormalizedRandomGenerator {

  /** Create a new generator.
   * The seed of the generator is related to the current time.
   */
  public GaussianRandomGenerator() {
    generator = new MersenneTwister();
  }

  /** Creates a new random number generator using a single int seed.
   * @param seed the initial seed (32 bits integer)
   */
  public GaussianRandomGenerator(int seed) {
    generator = new MersenneTwister(seed);
  }

  /** Creates a new random number generator using an int array seed.
   * @param seed the initial seed (32 bits integers array), if null
   * the seed of the generator will be related to the current time
   */
  public GaussianRandomGenerator(int[] seed) {
    generator = new MersenneTwister(seed);
  }

  /** Create a new generator initialized with a single long seed.
   * @param seed seed for the generator (64 bits integer)
   */
  public GaussianRandomGenerator(long seed) {
    generator = new MersenneTwister(seed);
  }

  /** Generate a random scalar with null mean and unit standard deviation.
   * @return a random scalar with null mean and unit standard deviation
   */
  public double nextDouble() {
    return generator.nextGaussian();
  }

  /** Underlying generator. */
  MersenneTwister generator;

  private static final long serialVersionUID = 5504568059866195697L;

}
