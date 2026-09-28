/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.document

import org.eclipse.microprofile.openapi.annotations.media.Schema

class DocumentMetadata(
    @field:Schema(description = "ID van metadata element", required = false)
    val metadataElement: MetadataElement?,

    @field:Schema(description = "Waarde van metadata element", required = false)
    val waarde: String?,
)
