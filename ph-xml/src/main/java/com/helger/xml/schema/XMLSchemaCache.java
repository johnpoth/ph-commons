/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
package com.helger.xml.schema;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;

import com.helger.commons.annotation.Singleton;
import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.concurrent.SimpleReadWriteLock;
import com.helger.commons.lang.IHasClassLoader;
import com.helger.commons.state.EChange;
import com.helger.xml.EXMLParserProperty;
import com.helger.xml.ls.SimpleLSResourceResolver;
import com.helger.xml.sax.LoggingSAXErrorHandler;

/**
 * This class is used to cache XML schema objects.
 *
 * @author Philip Helger
 */
@ThreadSafe
@Singleton ("can be instantiated directly as well")
public class XMLSchemaCache extends SchemaCache
{
  private static final class SingletonHolder
  {
    private static final XMLSchemaCache s_aInstance = new XMLSchemaCache ();
  }

  private static boolean s_bDefaultInstantiated = false;

  @Nonnull
  public static SchemaFactory createXSDSchemaFactory ()
  {
    // By default return English error messages (otherwise the Locale of the
    // system is used)
    return createXSDSchemaFactory (Locale.US);
  }

  /**
   * Create a new XSD {@link SchemaFactory} using a special locale used to
   * create error messages.
   *
   * @param aLocale
   *        The locale to be used. May be <code>null</code> to indicate the
   *        usage of the system default locale.
   * @return A new {@link SchemaFactory} and never <code>null</code>.
   */
  @Nonnull
  public static SchemaFactory createXSDSchemaFactory (@Nullable final Locale aLocale)
  {
    final SchemaFactory ret = SchemaFactory.newInstance (XMLConstants.W3C_XML_SCHEMA_NS_URI);
    if (aLocale != null)
      EXMLParserProperty.GENERAL_LOCALE.applyTo (ret, aLocale);
    return ret;
  }

  public XMLSchemaCache ()
  {
    this (new LoggingSAXErrorHandler (), new SimpleLSResourceResolver ());
  }

  public XMLSchemaCache (@Nullable final ErrorHandler aErrorHandler)
  {
    this (aErrorHandler, (LSResourceResolver) null);
  }

  public XMLSchemaCache (@Nullable final LSResourceResolver aResourceResolver)
  {
    this ((ErrorHandler) null, aResourceResolver);
  }

  public XMLSchemaCache (@Nullable final ErrorHandler aErrorHandler,
                         @Nullable final LSResourceResolver aResourceResolver)
  {
    this (createXSDSchemaFactory (), aErrorHandler, aResourceResolver);
  }

  public XMLSchemaCache (@Nonnull final SchemaFactory aSchemaFactory,
                         @Nullable final ErrorHandler aErrorHandler,
                         @Nullable final LSResourceResolver aResourceResolver)
  {
    super ("XSD", aSchemaFactory, aErrorHandler, aResourceResolver);
  }

  public static boolean isInstantiated ()
  {
    return s_bDefaultInstantiated;
  }

  @Nonnull
  public static XMLSchemaCache getInstance ()
  {
    final XMLSchemaCache ret = SingletonHolder.s_aInstance;
    s_bDefaultInstantiated = true;
    return ret;
  }

  private static final SimpleReadWriteLock s_aRWLock = new SimpleReadWriteLock ();
  @GuardedBy ("s_aRWLock")
  private static final ICommonsMap <String, XMLSchemaCache> s_aPerClassLoaderCache = new CommonsHashMap <> ();

  @Nonnull
  public static XMLSchemaCache getInstanceOfClassLoader (@Nullable final IHasClassLoader aClassLoaderProvider)
  {
    return getInstanceOfClassLoader (aClassLoaderProvider == null ? null : aClassLoaderProvider.getClassLoader ());
  }

  @Nonnull
  public static XMLSchemaCache getInstanceOfClassLoader (@Nullable final ClassLoader aClassLoader)
  {
    return getInstanceOf (aClassLoader, (Locale) null);
  }

  @Nonnull
  public static XMLSchemaCache getInstanceOf (@Nullable final ClassLoader aClassLoader, @Nullable final Locale aLocale)
  {
    if (aClassLoader == null && aLocale == null)
    {
      // Use default instance
      return getInstance ();
    }

    final String sKey = String.valueOf (aClassLoader) + "-" + String.valueOf (aLocale);

    XMLSchemaCache aCache = s_aRWLock.readLocked ( () -> s_aPerClassLoaderCache.get (sKey));
    if (aCache == null)
    {
      // Not found in read-lock
      // Try again in write lock
      aCache = s_aRWLock.writeLocked ( () -> s_aPerClassLoaderCache.computeIfAbsent (sKey,
                                                                                     x -> new XMLSchemaCache (createXSDSchemaFactory (aLocale),
                                                                                                              (ErrorHandler) null,
                                                                                                              aClassLoader == null ? null
                                                                                                                                   : new SimpleLSResourceResolver (aClassLoader))));
    }
    return aCache;
  }

  @Nonnull
  public static EChange clearPerClassLoaderCache ()
  {
    return s_aRWLock.writeLocked ( () -> s_aPerClassLoaderCache.removeAll ());
  }
}
