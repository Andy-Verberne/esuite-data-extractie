/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class StringReferentietabelRecordAttribuut(

    @field:Schema(description = "String waarde")
    val waarde: String,

    naam: String,
    omschrijving: String?,
) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.string, naam, omschrijving)



