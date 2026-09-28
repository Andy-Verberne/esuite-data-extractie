/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.contactenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "con_ref_contacttype", schema = "contactenmagazijn")
class ContactTypeEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_contacttype")
    var identifier: Long = 0

}
