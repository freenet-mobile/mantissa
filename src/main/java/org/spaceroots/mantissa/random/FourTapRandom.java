package org.spaceroots.mantissa.random;

import java.util.Random;

/** This class implements a powerful pseudo-random number generator
 * studied by Robert M Ziff.

 * <p>This generator belongs to the family of Generalized Feedback
 * Shift-Register (GFSR) generators, but uses four feedback taps
 * instead of two, thus greatly improving their quality for
 * Monte-Carlo simulations.</p>

 * <p>This generator is described in a paper by Robert M. Ziff in
 * 1997: <a href="http://arxiv.org/abs/cond-mat/9710104">Four-tap
 * shift-register-sequence random-number generators</a>, it is
 * generator 9f (defined as <code>R(471, 1586, 6988, 9689)</code>) of
 * the paper. It has been kindly contributed to mantissa by Bill
 * Maier.</p>

 * <p>The class is implemented as a specialization of the standard
 * <code>java.util.Random</code> class. This allows to use it in
 * algorithms expecting a standard random generator, and hence benefit
 * from a better generator without code change.</p>

 * @author Bill Maier (java.util.Random specialization by Luc Maisonobe)

 * @version $Id: FourTapRandom.java 1666 2005-12-15 16:37:55Z luc $

 */
public class FourTapRandom
  extends Random {

  /** Creates a new random number generator.
   * <p>The instance is initialized using the current time as the
   * seed.</p>
   */
  public FourTapRandom() {
    setSeed(System.currentTimeMillis());
  }

  /** Creates a new random number generator using a single long seed.
   * @param seed the initial seed
   */
  public FourTapRandom(long seed) {
    setSeed(seed);
  }

  /** Reinitialize the generator as if just built with the given seed.
   * <p>The state of the generator is exactly the same as a new
   * generator built with the same seed.</p>
   * @param seed the initial seed
   */
  public void setSeed(long seed) {
    super.setSeed(seed);
    fourTapBuffer = new int[TAP4M + 1];
    for (int j = 0; j <= TAP4M; j++) {
      fourTapBuffer[j] = super.next(32);
    }
    n4TapJ = 0;
  }

  /** Generate next pseudorandom number.
   * <p>This method is the core generation algorithm. As per
   * {@link java.util.Random Random} contract, it is used by all the
   * public generation methods for the various primitive types {@link
   * java.util.Random#nextBoolean nextBoolean}, {@link java.util.Random#nextBytes
   * nextBytes}, {@link java.util.Random#nextDouble nextDouble}, {@link
   * java.util.Random#nextFloat nextFloat}, {@link java.util.Random#nextGaussian
   * nextGaussian}, {@link java.util.Random#nextInt() nextInt} and {@link
   * java.util.Random#nextLong nextLong}.</p>
   * @param bits number of random bits to produce
   */
  protected int next(int bits) {
    ++n4TapJ;
    fourTapBuffer[n4TapJ & TAP4M] =
        fourTapBuffer[(n4TapJ - TAP4A) & TAP4M]
        ^ fourTapBuffer[(n4TapJ - TAP4B) & TAP4M]
        ^ fourTapBuffer[(n4TapJ - TAP4C) & TAP4M]
        ^ fourTapBuffer[(n4TapJ - TAP4D) & TAP4M];
    return fourTapBuffer[n4TapJ & TAP4M] >>> (32 - bits);
  }

  private static final int TAP4A = 471;
  private static final int TAP4B = 1586;
  private static final int TAP4C = 6988;
  private static final int TAP4D = 9689;
  private static final int TAP4M = 16383;

  private int[] fourTapBuffer;
  private int    n4TapJ;

  private static final long serialVersionUID = -4095251494398895580L;

}
