/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.basisgegevens.entity.PersoonEntity

@Singleton
class PersoonRepository : PanacheRepository<PersoonEntity> {

    fun findByBSN(bsn: String) =
        find("burgerServiceNummer", bsn).firstResult()
}
