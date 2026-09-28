/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class BooleanDataElement(

    @field:Schema(description = "Boolean waarde data element", required = false)
    val waarde: Boolean?,

    naam: String,
    omschrijving: String?
) : DataElement(DataElementType.boolean, naam, omschrijving)
