/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaaktype

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaakStartParameter(

    @field:Schema(description = "Naam", maxLength = 255)
    val naam: String,

    @field:Schema(description = "Type", maxLength = 255)
    val type: String,
)
