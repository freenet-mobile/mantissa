package org.spaceroots.mantissa.functions.vectorial;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This interface provides iteration services over vectorial functions
 * samples.

 * @see SampledFunction

 * @version $Id: SampledFunctionIterator.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */
public interface SampledFunctionIterator {

  /** Get the dimension of the vectorial values of the function.
   * @return dimension
   */
  public int getDimension();

  /** Check if the iterator can provide another point.
   * @return true if the iterator can provide another point.
   */
  public boolean hasNext();

  /** Get the next point of a sampled function.
   * @return the next point of the sampled function
   * @exception ExhaustedSampleException if the sample has been exhausted
   * @exception FunctionException if the underlying function throws one
   */
  public VectorialValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException;

}
