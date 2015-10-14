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
package com.helger.commons.typeconvert;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.IsSPIImplementation;
import com.helger.commons.string.StringParser;
import com.helger.commons.typeconvert.rule.AbstractTypeConverterRuleAssignableSourceFixedDestination;

/**
 * Register the date and time specific type converter
 *
 * @author Philip Helger
 */
@Immutable
@IsSPIImplementation
public final class DateTimeTypeConverterRegistrar implements ITypeConverterRegistrarSPI
{
  public void registerTypeConverter (@Nonnull final ITypeConverterRegistry aRegistry)
  {
    // Calendar
    aRegistry.registerTypeConverter (Calendar.class,
                                     String.class,
                                     (ITypeConverter) aSource -> Long.toString (((Calendar) aSource).getTimeInMillis ()));
    aRegistry.registerTypeConverter (Calendar.class,
                                     Long.class,
                                     (ITypeConverter) aSource -> Long.valueOf (((Calendar) aSource).getTimeInMillis ()));
    aRegistry.registerTypeConverter (Calendar.class,
                                     Date.class,
                                     (ITypeConverter) aSource -> ((Calendar) aSource).getTime ());
    aRegistry.registerTypeConverter (String.class, Calendar.class, (ITypeConverter) aSource -> {
      final Calendar aCal = Calendar.getInstance ();
      aCal.setTimeInMillis (StringParser.parseLong ((String) aSource, 0));
      return aCal;
    });
    aRegistry.registerTypeConverterRule (new AbstractTypeConverterRuleAssignableSourceFixedDestination (Number.class,
                                                                                                        Calendar.class)
    {
      @Nonnull
      public Calendar convert (@Nonnull final Object aSource)
      {
        final Calendar aCal = Calendar.getInstance ();
        aCal.setTimeInMillis (((Number) aSource).longValue ());
        return aCal;
      }
    });

    // Date
    aRegistry.registerTypeConverter (Date.class, Calendar.class, (ITypeConverter) aSource -> {
      final Calendar aCal = Calendar.getInstance ();
      aCal.setTime ((Date) aSource);
      return aCal;
    });
    aRegistry.registerTypeConverter (Date.class,
                                     String.class,
                                     (ITypeConverter) aSource -> Long.toString (((Date) aSource).getTime ()));
    aRegistry.registerTypeConverter (Date.class,
                                     Long.class,
                                     (ITypeConverter) aSource -> Long.valueOf (((Date) aSource).getTime ()));
    aRegistry.registerTypeConverter (String.class,
                                     Date.class,
                                     (ITypeConverter) aSource -> new Date (StringParser.parseLong ((String) aSource,
                                                                                                   0)));
    aRegistry.registerTypeConverterRule (new AbstractTypeConverterRuleAssignableSourceFixedDestination (Number.class,
                                                                                                        Date.class)
    {
      @Nonnull
      public Date convert (@Nonnull final Object aSource)
      {
        return new Date (((Number) aSource).longValue ());
      }
    });
  }
}
