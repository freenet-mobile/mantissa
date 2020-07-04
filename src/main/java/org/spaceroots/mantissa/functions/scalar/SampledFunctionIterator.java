package org.spaceroots.mantissa.functions.scalar;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This interface provides iteration services over scalar functions
 * samples.

 * @see SampledFunction

 * @version $Id: SampledFunctionIterator.java 1666 2005-12-15 16:37:55Z luc $
 * @author L. Maisonobe

 */
public interface SampledFunctionIterator {

  /** Check if the iterator can provide another point.
   * @return true if the iterator can provide another point.
   */
  public boolean hasNext();

  /** Get the next point of a sampled function.
   * @return the next point of the sampled function
   * @exception ExhaustedSampleException if the sample has been exhausted
   * @exception FunctionException if the underlying function throws one
   */
  public ScalarValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException;

}
