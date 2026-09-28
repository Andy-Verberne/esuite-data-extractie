/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("GENERIEKE_AFSPRAAK")
class GeneriekeAfspraakItemDataElementEntity: AbstractComplexDataElementEntity() {
}
