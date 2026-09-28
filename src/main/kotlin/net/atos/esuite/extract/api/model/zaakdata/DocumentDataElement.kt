/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class DocumentDataElement(

    @field:Schema(description = "Lijst van zaak document bestandsnamen")
    val waarden: List<String>,

    naam: String,
    omschrijving: String?
) : DataElement(DataElementType.zaak_documenten, naam, omschrijving)
