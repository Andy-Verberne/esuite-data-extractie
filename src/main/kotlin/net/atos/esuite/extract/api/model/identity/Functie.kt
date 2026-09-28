/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.identity

import org.eclipse.microprofile.openapi.annotations.media.Schema

class Functie(

    @field:Schema(description = "Naam van functie", maxLength = 128)
    val naam: String,

    @field:Schema(description = "Omschrijving van functie")
    val omschrijving: String,

    @field:Schema(description = "Is functie actief")
    val actief: Boolean,
)
