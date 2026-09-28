/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.OffsetDateTime


@Entity
@DiscriminatorValue("CALENDAR")
class CalendarDataElementEntity: AbstractDataElementEntity() {

    @Column(name = "calendar_waarde")
    var waarde: OffsetDateTime? = null
}
