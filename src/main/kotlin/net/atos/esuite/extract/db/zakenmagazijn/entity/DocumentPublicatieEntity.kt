/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDate


@Embeddable
class DocumentPublicatieEntity {

    enum class Bestemming {
        BERICHTENBOX
    }

    @Column(name = "bestemming", length = 20)
    @Enumerated(EnumType.STRING)
    var bestemming: Bestemming? = null

    @Column(name = "publicatiedatum")
    lateinit var publicatiedatum: LocalDate
}
