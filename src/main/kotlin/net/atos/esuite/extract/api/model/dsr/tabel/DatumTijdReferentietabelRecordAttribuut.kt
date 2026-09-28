/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.dsr.tabel

import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(allOf = [ReferentietabelRecordAttribuut::class])
class DatumTijdReferentietabelRecordAttribuut(

    @field:Schema(description = "Datum/Tijd waarde", implementation = ZonedDateTime::class)
    val waarde: ZonedDateTime,

    naam: String,
    omschrijving: String?,
) : ReferentietabelRecordAttribuut(ReferentietabelRecordAttribuutType.datum_tijd, naam, omschrijving)



