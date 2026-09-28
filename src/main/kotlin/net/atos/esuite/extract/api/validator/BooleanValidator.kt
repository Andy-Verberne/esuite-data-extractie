/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

const val TRUE: String = "true"
const val FALSE: String = "false"

class BooleanValidator : ConstraintValidator<ValidBoolean, String> {

    private val BOOLEAN_PATTERN = Regex("^(${TRUE}|${FALSE})$")

    override fun isValid(boolean: String?, context: ConstraintValidatorContext?) =
        boolean?.matches(BOOLEAN_PATTERN) ?: true
}
