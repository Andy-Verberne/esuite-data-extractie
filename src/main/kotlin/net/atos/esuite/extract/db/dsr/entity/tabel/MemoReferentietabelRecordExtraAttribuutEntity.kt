/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.dsr.entity.tabel

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

/**
 * Implementatie van AbstractStringReferentietabelRecordExtraAttribuutEntity voor een lange String.
*/

@Entity
@DiscriminatorValue("MEMO")
class MemoReferentietabelRecordExtraAttribuutEntity : AbstractStringReferentietabelRecordExtraAttribuutEntity() {
}
