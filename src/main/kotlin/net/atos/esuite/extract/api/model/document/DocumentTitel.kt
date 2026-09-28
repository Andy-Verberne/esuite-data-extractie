/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.shared.Referentie
import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [Referentie::class])
class DocumentTitel(
    naam: String,
    omschrijving: String?,
    actief: Boolean,
) : Referentie(
    naam = naam,
    omschrijving = omschrijving,
    actief = actief,
)
