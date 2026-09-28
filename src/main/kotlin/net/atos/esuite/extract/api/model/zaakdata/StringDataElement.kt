/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class StringDataElement(

    @field:Schema(description = "String waarde data element", required = false)
    val waarde: String?,

    naam: String,
    omschrijving: String?
) : DataElement(DataElementType.string, naam, omschrijving)
