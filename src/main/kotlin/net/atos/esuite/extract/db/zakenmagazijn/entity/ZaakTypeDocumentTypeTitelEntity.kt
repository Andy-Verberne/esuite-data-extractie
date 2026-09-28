/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.*

@Entity
@Table(name = "ztc_zaaktype_documenttype_titel", schema = "zakenmagazijn")
class ZaakTypeDocumentTypeTitelEntity {

    @Id
    @Column(name = "id_zaaktype_documenttype_titel")
    var identifier: Long = 0

    @ManyToOne
    @JoinColumn(name = "id_zaaktype_documenttype", referencedColumnName = "id_zaaktype_documenttype")
    lateinit var zaakTypeDocumentType: ZaakTypeDocumentTypeEntity

    @ManyToOne
    @JoinColumn(name = "id_documenttitel", referencedColumnName = "id_documenttitel")
    lateinit var documentTitel: DocumentTitelEntity

}
