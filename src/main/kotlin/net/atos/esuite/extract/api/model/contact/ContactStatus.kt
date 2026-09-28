/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.contact

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class ContactStatus(
    naam: String,
    omschrijving: String?,
    actief: Boolean,

    @field:Schema(description = "Type status", required = false)
    val type: ContactStatusType?,

    ) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)

