/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Specifiek dataelement voor een ADRESGEGEVENS
 */
@Entity
@DiscriminatorValue("ADRESGEGEVENS")
class AdresgegevensDataElementEntity: AbstractComplexDataElementEntity() {
}
