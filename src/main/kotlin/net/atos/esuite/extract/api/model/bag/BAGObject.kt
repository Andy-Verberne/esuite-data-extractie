/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.bag

import org.eclipse.microprofile.openapi.annotations.media.Schema

class BAGObject(
    @field:Schema(description = "Identificatie van BAG object", maxLength = 128)
    val bagObjectId: String,
)
