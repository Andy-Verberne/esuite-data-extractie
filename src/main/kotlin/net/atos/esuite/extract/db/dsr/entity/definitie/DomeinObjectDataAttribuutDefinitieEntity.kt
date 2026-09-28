/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.entity.definitie

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Entity class voor de definitie van een eenvoudig data-attribuut.
*/

@Entity
@DiscriminatorValue("DATA")
class DomeinObjectDataAttribuutDefinitieEntity : AbstractAttribuutDefinitieEntity() {

    // (STRING, NUMMER, DECIMAAL, BOOLEAN, DATUM, DATUM_MET_TIJDSTIP, COORDINATEN, MEMO, GEO_INFORMATIE)
    @Column(name = "datatype", length = 64)
    lateinit var datatype: String
}
