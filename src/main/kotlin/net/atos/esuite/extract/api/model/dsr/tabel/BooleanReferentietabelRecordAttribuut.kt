/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class BooleanReferentietabelRecordAttribuut(

    @field:Schema(description = "Boolean waarde")
    val waarde: Boolean,

    naam: String,
    omschrijving: String?,
) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.boolean, naam, omschrijving)



