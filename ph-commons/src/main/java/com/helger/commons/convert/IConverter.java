/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.commons.convert;

import java.util.function.Function;

/**
 * This is a very simple type conversion interface for compile type conversions.
 *
 * @param <SRCTYPE>
 *        source type
 * @param <DSTTYPE>
 *        destination type
 * @author Philip Helger
 */
@FunctionalInterface
public interface IConverter <SRCTYPE, DSTTYPE> extends Function <SRCTYPE, DSTTYPE>
{
  /**
   * Convert the passed source object to the destination type.
   *
   * @param aSource
   *        The source object to be converted. No <code>null</code> or non-
   *        <code>null</code> constraint possible.
   * @return The converted value. No <code>null</code> or non- <code>null</code>
   *         constraint possible.
   */
  DSTTYPE convert (final SRCTYPE aSource);

  default DSTTYPE apply (final SRCTYPE aSource)
  {
    return convert (aSource);
  }
}
