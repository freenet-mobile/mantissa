package org.spaceroots.mantissa.utilities;

/**
 * This class is a simple container for an offset and an
 * {@link ArraySliceMappable} object.

 * @version $Id: ArrayMapperEntry.java 1257 2002-06-20 17:53:26Z luc $
 * @author L. Maisonobe

 */

class ArrayMapperEntry {

  /** Mappable object. */
  public final ArraySliceMappable object;

  /** Offset from start of array. */
  public final int offset;

  /** Simple constructor.
   * @param object mappable object
   * @param offset offset from start of array
   */
  public ArrayMapperEntry(ArraySliceMappable object, int offset) {
    this.object = object;
    this.offset = offset;
  }

}
