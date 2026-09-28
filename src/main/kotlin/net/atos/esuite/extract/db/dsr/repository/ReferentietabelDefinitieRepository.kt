/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.dsr.entity.definitie.ReferentietabelDefinitieEntity

@Singleton
class ReferentietabelDefinitieRepository : PanacheRepository<ReferentietabelDefinitieEntity> {

    fun findByNaam(naam: String) = find("naam", naam).firstResult()
}
