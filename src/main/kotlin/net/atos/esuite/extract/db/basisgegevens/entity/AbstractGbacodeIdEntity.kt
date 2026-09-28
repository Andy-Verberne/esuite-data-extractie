/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@MappedSuperclass
abstract class AbstractGbacodeIdEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "gbacode")
    lateinit var gbacode: String
}
