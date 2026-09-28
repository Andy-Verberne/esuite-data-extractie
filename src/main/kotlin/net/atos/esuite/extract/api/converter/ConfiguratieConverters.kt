/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.converter

import net.atos.esuite.extract.api.model.shared.Kanaal
import net.atos.esuite.extract.db.configuratiemagazijn.entity.KanaalEntity

fun KanaalEntity.toKanaal() =
    Kanaal(
        naam = naam,
        omschrijving = omschrijving,
        actief = actief,
    )
