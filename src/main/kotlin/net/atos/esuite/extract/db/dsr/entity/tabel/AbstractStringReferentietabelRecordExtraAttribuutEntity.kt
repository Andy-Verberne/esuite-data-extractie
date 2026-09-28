/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.Column
import jakarta.persistence.Entity

/**
 * Superclass voor AbstractReferentietabelRecordExtraAttribuutEntitys met een String als waarde.
 */

@Entity
abstract class AbstractStringReferentietabelRecordExtraAttribuutEntity :
    AbstractReferentietabelRecordExtraAttribuutEntity() {

    @Column(name = "tekst_waarde")
    lateinit var waarde: String
}
