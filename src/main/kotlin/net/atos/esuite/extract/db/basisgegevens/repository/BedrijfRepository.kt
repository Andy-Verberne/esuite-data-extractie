/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.basisgegevens.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.basisgegevens.entity.BedrijfEntity

@Singleton
class BedrijfRepository : PanacheRepository<BedrijfEntity> {

    fun listByKvkNummer(kvkNummer: String) =
        find("kvknummer", kvkNummer)

    fun listByVestigingsnummer(vestigingsnummer: String) =
        find("vestigingsnummer", vestigingsnummer)

    fun listByKvkNummerAndVestigingsnummer(kvkNummer: String, vestigingsnummer: String) =
        find("kvknummer = ?1 and vestigingsnummer = ?2", kvkNummer, vestigingsnummer)
}

