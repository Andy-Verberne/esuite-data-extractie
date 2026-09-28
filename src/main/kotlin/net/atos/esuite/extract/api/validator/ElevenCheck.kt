/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.validator

/**
 * Checks if the input string is a number that conforms to the eleven-check.
 *
 * @param value Input string to check
 * @return true if input commits to eleven-check
 */
fun commitsToElevenCheck(value: String): Boolean {
    val length = value.length
    var check = 0
    (length downTo 2).forEach { i ->
        check += i * value[length - i].digitToInt()
    }
    check += -1 * value[length - 1].digitToInt()
    return check % 11 == 0
}
