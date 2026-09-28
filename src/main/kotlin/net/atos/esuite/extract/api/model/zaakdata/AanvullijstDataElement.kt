/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaakdata

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [DataElement::class])
class AanvullijstDataElement(

    @field:Schema(description = "Aanvullijst records")
    val waarden: List<AanvullijstRecord>,

    naam: String,
    omschrijving: String?
) : DataElement(DataElementType.aanvullijst, naam, omschrijving)
