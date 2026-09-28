/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.*
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Table(name = "gm_ref_rechtsvorm", schema = "basisgegevens")
@Entity
class RechtsvormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_rechtsvorm", length = 2, columnDefinition = "bpchar")
    lateinit var code: String

    @Column(name = "naam_nhr", unique = true, length = 128)
    var naamNhr: String? = null

    @OneToMany(mappedBy = "rechtsvorm")
    lateinit var bedrijven: MutableList<BedrijfEntity>
}
