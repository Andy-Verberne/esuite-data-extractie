/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.document

import net.atos.esuite.extract.api.model.shared.History
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDate

@Schema(allOf = [History::class])
class Documenthistorie(
    wijzigingDatum: LocalDate?,
    gewijzigdDoor: String?,
    oudeWaarde: String?,
    nieuweWaarde: String?,
    toelichting: String?,

    @field:Schema(description = "Type wijziging", maxLength = 64, required = false)
    val typeWijziging: String?,

    ) : History(
    wijzigingDatum = wijzigingDatum,
    gewijzigdDoor = gewijzigdDoor,
    oudeWaarde = oudeWaarde,
    nieuweWaarde = nieuweWaarde,
    toelichting = toelichting,
)
