/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.shared

import org.eclipse.microprofile.openapi.annotations.media.Schema

open class Fout(
    @field:Schema(description = "Foutmelding")
    val melding: String,
)
