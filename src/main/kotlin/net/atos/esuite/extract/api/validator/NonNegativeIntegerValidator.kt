/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NonNegativeIntegerValidator : ConstraintValidator<ValidNonNegativeInteger, String> {

    override fun isValid(integer: String?, context: ConstraintValidatorContext?) =
        integer?.let { it.toIntOrNull()?.let { i -> i >= 0 } ?: false } ?: true
}
