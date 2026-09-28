/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.inject.Singleton
import net.atos.esuite.extract.db.zakenmagazijn.entity.MetadataelementEntity

@Singleton
class MetadataelementRepository : PanacheRepository<MetadataelementEntity> {
}
