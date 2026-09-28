/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.identity.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.identity.entity.MedewerkerEntity

@Singleton
class MedewerkerRepository : PanacheRepository<MedewerkerEntity> {

    fun findByGebruikersnaam(gebruikersnaam: String) = find("gebruikersnaam", gebruikersnaam).firstResult()
}
