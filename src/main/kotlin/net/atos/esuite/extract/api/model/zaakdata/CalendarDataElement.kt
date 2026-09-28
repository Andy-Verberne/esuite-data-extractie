/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [DataElement::class])
class CalendarDataElement(
    type: DataElementType,

    @field:Schema(description = "Calendar waarde data element", implementation = ZonedDateTime::class, required = false)
    val waarde: ZonedDateTime?,

    naam: String,
    omschrijving: String?
) : DataElement(type, naam, omschrijving)
