/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.dsr.domein

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class Domein(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Aantal objecten in domein")
    val aantalObjecten: Long,
    
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
