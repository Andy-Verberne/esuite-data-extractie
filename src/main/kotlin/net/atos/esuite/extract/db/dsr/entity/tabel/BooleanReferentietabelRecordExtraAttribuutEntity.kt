/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("BOOLEAN")
class BooleanReferentietabelRecordExtraAttribuutEntity : AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "boolean_waarde")
    var waarde = false
}
