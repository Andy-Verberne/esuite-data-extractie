/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.entity

import jakarta.persistence.*

@Entity
@Table(name = "gm_subject", schema = "basisgegevens")
@Inheritance(strategy = InheritanceType.JOINED)
class SubjectEntity {
    
    @Id
    @Column(name = "id_subject")
    var identifier: Long = 0

    @OneToMany(mappedBy = "subject")
    lateinit var notities: MutableList<NotitieEntity>
}
