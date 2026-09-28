/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.*


@Entity
@DiscriminatorValue("SELECT_DOCUMENTS")
class SelectDocumentElementEntity: AbstractDataElementEntity() {

    @ElementCollection
    @CollectionTable(
        name = "zkn_zaak_dataelement_selectdocumentwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    @Column(name = "gemarshallde_selectdocument_waarde")
    lateinit var gemarshalldeOptieWaarde: List<String>
}
