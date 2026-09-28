/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "gm_ref_nevenactiviteit", schema = "basisgegevens")
class NevenactiviteitEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_nevenactiviteit")
    var identifier: Long = 0

    @Column(name = "code", length = 7)
    var code: String? = null
}
