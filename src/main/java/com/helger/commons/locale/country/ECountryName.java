/**
 * Copyright (C) 2014 Philip Helger (www.helger.com)
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
package com.helger.commons.locale.country;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotations.Translatable;
import com.helger.commons.name.IHasDisplayText;
import com.helger.commons.text.impl.TextProvider;
import com.helger.commons.text.resolve.DefaultTextResolver;

/**
 * Country enum name.
 *
 * @author Philip Helger
 */
@Translatable
public enum ECountryName implements IHasDisplayText
{
  AD ("Andorra", "Andorra"),
  AE ("Vereinigte Arabische Emirate", "United Arab Emirates"),
  AF ("Afghanistan", "Afghanistan"),
  AG ("Antigua und Barbuda", "Antigua And Barbuda"),
  AI ("Anguilla", "Anguilla"),
  AL ("Albanien", "Albania"),
  AM ("Armenien", "Armenia"),
  AN ("Niederländische Antillen", "Netherlands Antilles"),
  AO ("Angola", "Angola"),
  AQ ("Antarktis", "Antarctica"),
  AR ("Argentinien", "Argentina"),
  AS ("Amerikanisch Samoa", "American Samoa"),
  AT ("Österreich", "Austria"),
  AU ("Australien", "Australia"),
  AW ("Aruba", "Aruba"),
  AX ("Åland Inseln", "Aaland Islands"),
  AZ ("Aserbaidschan", "Azerbaijan"),
  BA ("Bosnien und Herzegowina", "Bosnia and Herzegovina"),
  BB ("Barbados", "Barbados"),
  BD ("Bangladesch", "Bangladesh"),
  BE ("Belgien", "Belgium"),
  BF ("Burkina Faso", "Burkina Faso"),
  BG ("Bulgarien", "Bulgaria"),
  BH ("Bahrain", "Bahrain"),
  BI ("Burundi", "Burundi"),
  BJ ("Benin", "Benin"),
  BM ("Bermuda", "Bermuda"),
  BN ("Brunei Darussalam", "Brunei Darussalam"),
  BO ("Bolivien", "Bolivia"),
  BR ("Brasilien", "Brazil"),
  BS ("Bahamas", "Bahamas"),
  BT ("Bhutan", "Bhutan"),
  BV ("Bouvetinsel", "Bouvet Island"),
  BW ("Botsuana", "Botswana"),
  BY ("Weißrussland", "Belarus"),
  BZ ("Belize", "Belize"),
  CA ("Kanada", "Canada"),
  CC ("Kokosinseln", "Cocos (Keeling) Islands"),
  CD ("Kongo, Dem. Rep.", "Congo, Democratic Republic Of (Was Zaire)"),
  CF ("Zentralafrikanische Republik", "Central African Republic"),
  CG ("Kongo", "Congo, Republic Of"),
  CH ("Schweiz", "Switzerland"),
  CI ("Côte d´Ivoire", "Cote d'Ivoire"),
  CK ("Cookinseln", "Cook Islands"),
  CL ("Chile", "Chile"),
  CM ("Kamerun", "Cameroon"),
  CN ("China", "China"),
  CO ("Kolumbien", "Colombia"),
  CR ("Costa Rica", "Costa Rica"),
  CU ("Kuba", "Cuba"),
  CV ("Kap Verde", "Cape Verde"),
  CX ("Weihnachtsinsel", "Christmas Island"),
  CY ("Zypern", "Cyprus"),
  CZ ("Tschechische Republik", "Czech Republic"),
  DE ("Deutschland", "Germany"),
  DJ ("Republik Dschibuti", "Djibouti"),
  DK ("Dänemark", "Denmark"),
  DM ("Dominica", "Dominica"),
  DO ("Dominikanische Republik", "Dominican Republic"),
  DZ ("Algerien", "Algeria"),
  EC ("Ecuador", "Ecuador"),
  EE ("Estland", "Estonia"),
  EG ("Ägypten", "Egypt"),
  EH ("Westsahara", "Western Sahara"),
  ER ("Eritrea", "Eritrea"),
  ES ("Spanien", "Spain"),
  ET ("Äthiopien", "Ethiopia"),
  FI ("Finnland", "Finland"),
  FJ ("Fidschi", "Fiji"),
  FK ("Falklandinseln", "Falkland Islands (Malvinas)"),
  FM ("Mikronesien, Föderierte Staaten von", "Micronesia, Federated States Of"),
  FO ("Färöer", "Faroe Islands"),
  FR ("Frankreich", "France"),
  GA ("Gabun", "Gabon"),
  GB ("Vereinigtes Königreich", "United Kingdom"),
  GD ("Grenada", "Grenada"),
  GE ("Georgien", "Georgia"),
  GF ("Französisch Guayana", "French Guiana"),
  GG ("Guernsey", "Guernsey"),
  GH ("Ghana", "Ghana"),
  GI ("Gibraltar", "Gibraltar"),
  GL ("Grönland", "Greenland"),
  GM ("Gambia", "Gambia"),
  GN ("Guinea", "Guinea"),
  GP ("Guadeloupe", "Guadeloupe"),
  GQ ("Äquatorialguinea", "Equatorial Guinea"),
  GR ("Griechenland", "Greece"),
  GS ("Südgeorgien und die Südlichen Sandwichinseln", "South Georgia And The South Sandwich Islands"),
  GT ("Guatemala", "Guatemala"),
  GU ("Guam", "Guam"),
  GW ("Guinea-Bissau", "Guinea-Bissau"),
  GY ("Guyana", "Guyana"),
  HK ("Hong Kong", "Hong Kong"),
  HM ("Heard Insel und McDonald Inseln", "Heard And Mc Donald Islands"),
  HN ("Honduras", "Honduras"),
  HR ("Kroatien", "Croatia (Local Name: Hrvatska)"),
  HT ("Haiti", "Haiti"),
  HU ("Ungarn", "Hungary"),
  ID ("Indonesien", "Indonesia"),
  IE ("Irland", "Ireland"),
  IL ("Israel", "Israel"),
  IM ("Isle of Man", "Isle of Man"),
  IN ("Indien", "India"),
  IO ("Britische Territorien im Indischen Ozean", "British Indian Ocean Territory"),
  IQ ("Irak", "Iraq"),
  IR ("Iran, Islam. Rep.", "Iran (Islamic Republic Of)"),
  IS ("Island", "Iceland"),
  IT ("Italien", "Italy"),
  JE ("Jersey", "Jersey"),
  JM ("Jamaika", "Jamaica"),
  JO ("Jordanien", "Jordan"),
  JP ("Japan", "Japan"),
  KE ("Kenia", "Kenya"),
  KG ("Kirgisistan", "Kyrgyzstan"),
  KH ("Kambodscha", "Cambodia"),
  KI ("Kiribati", "Kiribati"),
  KM ("Komoren", "Comoros"),
  KN ("St. Kitts und Nevis", "Saint Kitts And Nevis"),
  KP ("Korea, Dem. Volksrep.", "Korea, Democratic People's Republic Of"),
  KR ("Korea, Rep.", "Korea, Republic Of"),
  KW ("Kuwait", "Kuwait"),
  KY ("Kaimaninseln", "Cayman Islands"),
  KZ ("Kasachstan", "Kazakhstan"),
  LA ("Laos, Dem. Volksrep.", "Lao People's Democratic Republic"),
  LB ("Libanon", "Lebanon"),
  LC ("St. Lucia", "Saint Lucia"),
  LI ("Liechtenstein", "Liechtenstein"),
  LK ("Sri Lanka", "Sri Lanka"),
  LR ("Liberia", "Liberia"),
  LS ("Lesotho", "Lesotho"),
  LT ("Litauen", "Lithuania"),
  LU ("Luxemburg", "Luxembourg"),
  LV ("Lettland", "Latvia"),
  LY ("Libysch-Arabische Dschamahirija", "Libyan Arab Jamahiriya"),
  MA ("Marokko", "Morocco"),
  MC ("Monaco", "Monaco"),
  MD ("Moldau, Rep.", "Moldova, Republic Of"),
  ME ("Montenegro", "Montenegro"),
  MG ("Madagaskar", "Madagascar"),
  MH ("Marshallinseln", "Marshall Islands"),
  MK ("Mazedonien, ehemalige jugoslawische Republik", "Macedonia, The Former Yugoslav Republic Of"),
  ML ("Mali", "Mali"),
  MM ("Myanmar", "Myanmar"),
  MN ("Mongolei", "Mongolia"),
  MO ("Macao", "Macau"),
  MP ("Nördliche Marianen", "Northern Mariana Islands"),
  MQ ("Martinique", "Martinique"),
  MR ("Mauretanien", "Mauritania"),
  MS ("Montserrat", "Montserrat"),
  MT ("Malta", "Malta"),
  MU ("Mauritius", "Mauritius"),
  MV ("Malediven", "Maldives"),
  MW ("Malawi", "Malawi"),
  MX ("Mexiko", "Mexico"),
  MY ("Malaysia", "Malaysia"),
  MZ ("Mosambik", "Mozambique"),
  NA ("Namibia", "Namibia"),
  NC ("Neukaledonien", "New Caledonia"),
  NE ("Niger", "Niger"),
  NF ("Norfolk Insel", "Norfolk Island"),
  NG ("Nigeria", "Nigeria"),
  NI ("Nicaragua", "Nicaragua"),
  NL ("Niederlande", "Netherlands"),
  NO ("Norwegen", "Norway"),
  NP ("Nepal", "Nepal"),
  NR ("Nauru", "Nauru"),
  NU ("Niue", "Niue"),
  NZ ("Neuseeland", "New Zealand"),
  OM ("Oman", "Oman"),
  PA ("Panama", "Panama"),
  PE ("Peru", "Peru"),
  PF ("Französisch Polynesien", "French Polynesia"),
  PG ("Papua-Neuguinea", "Papua New Guinea"),
  PH ("Philippinen", "Philippines"),
  PK ("Pakistan", "Pakistan"),
  PL ("Polen", "Poland"),
  PM ("Saint Pierre und Miquelon", "Saint Pierre And Miquelon"),
  PN ("Pitcairn", "Pitcairn"),
  PR ("Puerto Rico", "Puerto Rico"),
  PS ("Palästinische Gebiete", "Palestinian Territory, Occupied"),
  PT ("Portugal", "Portugal"),
  PW ("Palau", "Palau"),
  PY ("Paraguay", "Paraguay"),
  QA ("Katar", "Qatar"),
  RE ("Réunion", "Reunion"),
  RO ("Rumänien", "Romania"),
  RS ("Serbien", "Serbia"),
  RU ("Russische Föderation", "Russian Federation"),
  RW ("Ruanda", "Rwanda"),
  SA ("Saudi-Arabien", "Saudi Arabia"),
  SB ("Salomonen", "Solomon Islands"),
  SC ("Seychellen", "Seychelles"),
  SD ("Sudan", "Sudan"),
  SE ("Schweden", "Sweden"),
  SG ("Singapur", "Singapore"),
  SH ("Saint Helena", "Saint Helena"),
  SI ("Slowenien", "Slovenia"),
  SJ ("Svalbard und Jan Mayen", "Svalbard And Jan Mayen Islands"),
  SK ("Slowakei", "Slovakia"),
  SL ("Sierra Leone", "Sierra Leone"),
  SM ("San Marino", "San Marino"),
  SN ("Senegal", "Senegal"),
  SO ("Somalia", "Somalia"),
  SR ("Suriname", "Suriname"),
  ST ("São Tomé und Príncipe", "Sao Tome And Principe"),
  SV ("El Salvador", "El Salvador"),
  SY ("Syrien, Arab. Rep.", "Syrian Arab Republic"),
  SZ ("Swasiland", "Swaziland"),
  TC ("Turks- und Caicosinseln", "Turks And Caicos Islands"),
  TD ("Tschad", "Chad"),
  TF ("Französische Südgebiete", "French Southern Territories"),
  TG ("Togo", "Togo"),
  TH ("Thailand", "Thailand"),
  TJ ("Tadschikistan", "Tajikistan"),
  TK ("Tokelau", "Tokelau"),
  TL ("Timor-Leste", "Timor-Leste"),
  TM ("Turkmenistan", "Turkmenistan"),
  TN ("Tunesien", "Tunisia"),
  TO ("Tonga", "Tonga"),
  TR ("Türkei", "Turkey"),
  TT ("Trinidad und Tobago", "Trinidad And Tobago"),
  TV ("Tuvalu", "Tuvalu"),
  TW ("Taiwan", "Taiwan"),
  TZ ("Tansania, Vereinigte Rep.", "Tanzania, United Republic Of"),
  UA ("Ukraine", "Ukraine"),
  UG ("Uganda", "Uganda"),
  UK ("Vereinigtes Königreich Großbritannien", "United Kingdom of Great Britain"),
  UM ("United States Minor Outlying Islands", "United States Minor Outlying Islands"),
  US ("Vereinigte Staaten von Amerika", "United States of America"),
  UY ("Uruguay", "Uruguay"),
  UZ ("Usbekistan", "Uzbekistan"),
  VA ("Heiliger Stuhl", "Vatican City State (Holy See)"),
  VC ("St. Vincent und die Grenadinen", "Saint Vincent And The Grenadines"),
  VE ("Venezuela", "Venezuela"),
  VG ("Britische Jungferninseln", "Virgin Islands (British)"),
  VI ("Amerikanische Jungferninseln", "Virgin Islands (U.S.)"),
  VN ("Vietnam", "Viet Nam"),
  VU ("Vanuatu", "Vanuatu"),
  WF ("Wallis und Futuna", "Wallis And Futuna Islands"),
  WS ("Samoa", "Samoa"),
  YE ("Jemen", "Yemen"),
  YT ("Mayotte", "Mayotte"),
  ZA ("Südafrika", "South Africa"),
  ZM ("Sambia", "Zambia"),
  ZW ("Simbabwe", "Zimbabwe");

  private final TextProvider m_aTP;

  private ECountryName (@Nonnull final String sDE, @Nonnull final String sEN)
  {
    m_aTP = TextProvider.create_DE_EN (sDE, sEN);
  }

  @Nullable
  public String getDisplayText (@Nonnull final Locale aContentLocale)
  {
    return DefaultTextResolver.getText (this, m_aTP, aContentLocale);
  }
}
