/**
 * Licensed to The Apereo Foundation under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 *
 * The Apereo Foundation licenses this file to you under the Educational
 * Community License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License
 * at:
 *
 *   http://opensource.org/licenses/ecl2.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.opencastproject.series.impl.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter
public class InstantConverter implements AttributeConverter<Instant, OffsetDateTime> {
  private static final Logger logger = LoggerFactory.getLogger(InstantConverter.class);

  @Override
  public OffsetDateTime convertToDatabaseColumn(Instant instant) {
    logger.error("from instant {} to odt {}", instant, instant == null ? null : instant.atOffset(ZoneOffset.MAX));
    return instant == null ? null : instant.atOffset(ZoneOffset.MAX);
  }

  @Override
  public Instant convertToEntityAttribute(OffsetDateTime timestamp) {
    logger.error("from odt {} to instant {}", timestamp, timestamp == null ? null : timestamp.toInstant());
    return timestamp == null ? null : timestamp.toInstant();
  }
}
