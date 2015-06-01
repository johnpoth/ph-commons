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
package com.helger.commons.changelog;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.helger.commons.collections.CollectionHelper;

/**
 * Test class for class {@link ComparatorChangeLogEntryDateAndComponent}.
 *
 * @author Philip Helger
 */
public final class ComparatorChangeLogEntryDateAndComponentTest
{
  @Test
  public void testAll ()
  {
    final List <ChangeLogEntry> aEntries = new ArrayList <ChangeLogEntry> ();
    for (final ChangeLog aCL : ChangeLogSerializer.readAllChangeLogs ().values ())
      aEntries.addAll (aCL.getAllEntries ());
    assertSame (aEntries, CollectionHelper.getSortedInline (aEntries, new ComparatorChangeLogEntryDateAndComponent ()));
    assertTrue (CollectionHelper.getFirstElement (aEntries).getDate ().getTime () < CollectionHelper.getLastElement (aEntries)
                                                                                                    .getDate ()
                                                                                                    .getTime ());
  }
}