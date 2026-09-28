/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity.dataelement

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
@DiscriminatorValue("DECIMALEN")
class DecimalenDataElementEntity: AbstractDataElementEntity() {

    @ElementCollection
    @CollectionTable(
        name = "zkn_zaak_dataelement_nummerwaardes", schema = "zakenmagazijn",
        joinColumns = [JoinColumn(name = "id_dataelement", referencedColumnName = "id_dataelement")]
    )
    lateinit var waarde: MutableSet<BigDecimal>
}
