/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DatumReferentietabelRecordAttribuut(

    @field:Schema(description = "Datum waarde", implementation = LocalDate::class)
    val waarde: LocalDate,

    naam: String,
    omschrijving: String?,
) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.datum, naam, omschrijving)



