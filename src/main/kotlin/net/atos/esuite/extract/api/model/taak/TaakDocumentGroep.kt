/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.taak

import org.eclipse.microprofile.openapi.annotations.media.Schema

class TaakDocumentGroep(

    @field:Schema(description = "Naam", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Taak documenten", required = false)
    val taakDocumenten: List<TaakDocument>?,
)
