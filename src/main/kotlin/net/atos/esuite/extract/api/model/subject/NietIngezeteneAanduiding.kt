/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.subject

enum class NietIngezeteneAanduiding {

    // Persoon woont in Nederland ('I')
    ingezetene,

    // Persoon woont niet in Nederland ('N')
    niet_ingezetene,

    // Is er nog een derde mogelijkheid? ('A')
    ander_natuurlijk_persoon,
}
