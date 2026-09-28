/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import net.atos.esuite.extract.db.shared.AbstractReferentieEntity

@Entity
@Table(name = "ztc_ref_documentvorm", schema = "zakenmagazijn")
class DocumentVormEntity : AbstractReferentieEntity() {

    @Id
    @Column(name = "id_documentvorm")
    var identifier: Long = 0
}
