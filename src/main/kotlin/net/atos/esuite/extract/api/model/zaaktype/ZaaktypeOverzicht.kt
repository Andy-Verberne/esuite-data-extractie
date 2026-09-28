/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaaktype

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ZaaktypeOverzicht(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Functionele identificatie", maxLength = 128)
    val functioneleIdentificatie: String,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
