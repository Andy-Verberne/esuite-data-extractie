/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class VestigingsnummerValidator : ConstraintValidator<ValidVestigingsnummer, String> {

    private val VESTIGINGSNUMMER_PATTERN = Regex("^\\d{12}$")

    override fun isValid(vestigingsnummer: String?, context: ConstraintValidatorContext?) =
        vestigingsnummer?.matches(VESTIGINGSNUMMER_PATTERN) ?: true
}
