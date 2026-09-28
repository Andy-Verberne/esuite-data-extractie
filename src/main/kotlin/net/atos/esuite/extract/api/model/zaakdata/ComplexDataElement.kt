/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class ComplexDataElement(
    type: DataElementType,

    @field:Schema(description = "Complexe waarde data element", required = false)
    val waarde: String?,

    naam: String,
    omschrijving: String?
) : DataElement(type, naam, omschrijving)
