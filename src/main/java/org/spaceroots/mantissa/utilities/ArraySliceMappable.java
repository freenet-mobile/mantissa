package org.spaceroots.mantissa.utilities;

/** This interface is used to map objects to and from simple arrays.
 *
 * <p> Lots of mathematical algorithms are generic ones which can
 * process the data from domain objects despite they ignore what
 * this data represent. As an example, the same algorithm can
 * integrate either the orbit evolution of a spacecraft under a
 * specified force model or the electrical characteristics of a
 * circuit after a switch is opened.  </p>

 * <p> The approach of the Mantissa library is to define an interface
 * for each such algorithm to represent the type of problem they can
 * handle ({@link
 * org.spaceroots.mantissa.ode.FirstOrderDifferentialEquations
 * FirstOrderDifferentialEquations} for an ODE integrators, {@link
 * org.spaceroots.mantissa.estimation.EstimationProblem
 * EstimationProblem} for least squares estimators, ...). Furthermore,
 * the state data that is handled by these algorithms is often a
 * mixture of data coming from several domain objects (the orbit,
 * plus the aerodynamical coefficients of the spacecraft, plus the
 * characteristics of the thrusters, plus ...). Therefore, the user
 * needs to gather and dispatch data between different objects
 * representing different levels of abstraction.  </p>

 * <p> This interface is designed to copy data back and forth between
 * existing objects during the iterative processing of these
 * algorithms and avoid the cost of recreating the objects.  </p>

 * <p> The nominal way to use this interface is to have the domain
 * objects implement it (either directly or using inheritance to add
 * this feature to already existing objects) and to create one class
 * that implements the problem interface (for example {@link
 * org.spaceroots.mantissa.ode.FirstOrderDifferentialEquations}) and
 * uses the {@link ArrayMapper} class to dispatch the data to and from
 * the domain objects.</p>

 * @see ArrayMapper
 *
 * @version $Id: ArraySliceMappable.java 1454 2003-01-15 19:28:40Z luc $
 * @author L. Maisonobe
 *
 */

public interface ArraySliceMappable {
    
    /** Get the dimension of the object.
     * @return dimension of the object
     */
    public int getStateDimension();
    
    /** Reinitialize internal state from the specified array slice data.
     * @param start start index in the array
     * @param array array holding the data to extract
     */
    public void mapStateFromArray(int start, double[] array);
    
    /** Store internal state data into the specified array slice.
     * @param start start index in the array
     * @param array array where data should be stored
     */
    public void mapStateToArray(int start, double[] array);
    
}
