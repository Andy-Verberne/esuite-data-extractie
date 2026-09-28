/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.db.zakenmagazijn.entity

enum class BetaalstatusEnum {

    /**
     * Betaling is geslaagd
     */
    GESLAAGD,

    /**
     * Betaling is niet geslaagd
     */
    NIET_GESLAAGD,

    /**
     * Betaling is in behandeling
     */
    IN_BEHANDELING,

    /**
     * Betaling is geannuleerd door gemeente
     */
    GEANNULEERD,
}
