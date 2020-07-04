package org.spaceroots.mantissa.utilities;

/** This class represents an interval on the real line.

 * <p>This class allows to perform simple interval operations like
 * point inclusion tests and intersection operations.</p>

 * <p>There is no distinction between open and closed intervals
 * because real numbers cannot be represented exactly.</p>

 * @see IntervalsList
 * @author Luc Maisonobe
 * @version $Id: Interval.java 1539 2003-12-13 19:31:14Z luc $
 */
public class Interval {

  /** Build the [0, 0] interval.
   */
  public Interval() {
    inf = 0;
    sup = 0;
  }

  /** Build an interval with the given bounds.
   * <p>The given bounds do not need to be ordered, they will be
   * reordered by the constructor.</p>
   * @param a first bound
   * @param b second bound
   */
  public Interval(double a, double b) {
    if (a <= b) {
      inf = a;
      sup = b;
    } else {
      inf = b;
      sup = a;
    }
  }

  /** Copy-constructor.
   * @param i interval to copy
   */
  public Interval(Interval i) {
    inf = i.inf;
    sup = i.sup;
  }

  /** Get the lower bound of the interval.
   * @return lower bound of the interval
   */
  public double getInf() {
    return inf;
  }

  /** Get the upper bound of the interval.
   * @return upper bound of the interval
   */
  public double getSup() {
    return sup;
  }

  /** Get the length of the interval.
   * @return length of the interval
   */
  public double getLength() {
    return sup - inf;
  }

  /** Check if the interval contains a point.
   * @param x point to check
   * @return true if the interval contains x
   */
  public boolean contains(double x) {
    return (inf <= x) && (x <= sup);
  }

  /** Check if the interval contains another interval.
   * @param i interval to check
   * @return true if i is completely included in the instance
   */
  public boolean contains(Interval i) {
    return (inf <= i.inf) && (i.sup <= sup);
  }

  /** Check if an interval intersects the instance.
   * @param i interval to check
   * @return true if i intersects the instance
   */
  public boolean intersects(Interval i) {
    return (inf <= i.sup) && (i.inf <= sup);
  }

  /** Add an interval to the instance.
   * <p>This method expands the instance.</p>
   * <p>This operation is <strong>not</strong> a union operation. If
   * the instance and the interval are disjoints (i.e. if {@link
   * #intersects intersects(i)} would return <code>false</code>), then
   * the hole between the intervals is filled in.</p>
   * @param i interval to add to the instance
   */
  public void addToSelf(Interval i) {
    inf = Math.min(inf, i.inf);
    sup = Math.max(sup, i.sup);
  }

  /** Add two intervals.
   * <p>This operation is <strong>not</strong> a union operation. If
   * the intervals are disjoints (i.e. if {@link
   * #intersects i1.intersects(i2)} would return <code>false</code>), then
   * the hole between the intervals is filled in.</p>
   * @param i1 first interval
   * @param i2 second interval
   * @return a new interval
   */
  public static Interval add(Interval i1, Interval i2) {
    Interval copy = new Interval(i1);
    copy.addToSelf(i2);
    return copy;
  }

  /** Intersects the instance with an interval.
   * <p>This method reduces the instance, it could even become empty
   * if the interval does not intersects the instance.</p>
   * @param i interval with which the instance should be intersected
   */
  public void intersectSelf(Interval i) {
    inf = Math.max(inf, i.inf);
    sup = Math.max(Math.min(sup, i.sup), inf);
  }

  /** Intersect two intervals.
   * @param i1 first interval
   * @param i2 second interval
   * @return a new interval which is the intersection of i1 with i2
   */
  public static Interval intersection(Interval i1, Interval i2) {
    Interval copy = new Interval(i1);
    copy.intersectSelf(i2);
    return copy;
  }

  /** Lower bound of the interval. */
  private double inf;

  /** Upper bound of the interval. */
  private double sup;

}

