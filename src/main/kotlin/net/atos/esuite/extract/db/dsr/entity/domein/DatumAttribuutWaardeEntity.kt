/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.entity.domein

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.Instant

/**
 * Implementatie van AbstractAttribuutWaardeEntity voor een datum waarde.
*/

@Entity
@DiscriminatorValue("DATUM")
class DatumAttribuutWaardeEntity : AbstractAttribuutWaardeEntity() {

    @Column(name = "datumtijdwaarde")
    lateinit var waarde: Instant
}
