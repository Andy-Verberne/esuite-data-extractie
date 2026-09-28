/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_tag", schema = "zakenmagazijn")
class ZaakTypeTagEntity {

    @Id
    @Column(name = "id_zaaktype_tag")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype", referencedColumnName = "id_zaaktype")
    lateinit var zaakType: ZaakTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id_document_tag")
    lateinit var tag: TagEntity
}
