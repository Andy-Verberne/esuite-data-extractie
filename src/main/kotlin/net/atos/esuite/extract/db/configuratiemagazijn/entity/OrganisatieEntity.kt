/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.configuratiemagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "conf_ref_organisatie", schema = "configuratiemagazijn")
class OrganisatieEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_organisatie")
    var identifier: Long = 0
}
