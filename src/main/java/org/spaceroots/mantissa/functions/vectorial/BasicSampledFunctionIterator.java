package org.spaceroots.mantissa.functions.vectorial;

import java.io.Serializable;

import org.spaceroots.mantissa.functions.FunctionException;
import org.spaceroots.mantissa.functions.ExhaustedSampleException;

/** This class is a wrapper allowing to iterate over a
 * SampledFunction.

 * <p>The basic implementation of the iteration interface does not
 * perform any transformation on the sample, it only handles a loop
 * over the underlying sampled function.</p>

 * @see SampledFunction

 * @version $Id: BasicSampledFunctionIterator.java 1686 2005-12-16 12:59:51Z luc $
 * @author L. Maisonobe

 */
public class BasicSampledFunctionIterator
  implements SampledFunctionIterator, Serializable {

  /** Simple constructor.
   * Build an instance from a SampledFunction
   * @param function smapled function over which we want to iterate
   */
  public BasicSampledFunctionIterator(SampledFunction function) {
    this.function = function;
    next          = 0;
  }

  public int getDimension() {
    return function.getDimension();
  }

  public boolean hasNext() {
    return next < function.size();
  }

  public VectorialValuedPair nextSamplePoint()
    throws ExhaustedSampleException, FunctionException {

    if (next >= function.size()) {
      throw new ExhaustedSampleException(function.size());
    }

    int current = next++;
    return function.samplePointAt(current);

  }

  /** Underlying sampled function. */
  private final SampledFunction function;

  /** Next sample element. */
  private int next;

  private static final long serialVersionUID = -4386278658288500627L;

}
