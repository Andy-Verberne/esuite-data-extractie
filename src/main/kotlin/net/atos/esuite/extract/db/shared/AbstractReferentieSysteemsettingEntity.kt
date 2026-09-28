/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.shared

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractReferentieSysteemsettingEntity : AbstractReferentieEntity() {

    @Column(name = "systeemsetting")
    var systeemsetting = false
}
