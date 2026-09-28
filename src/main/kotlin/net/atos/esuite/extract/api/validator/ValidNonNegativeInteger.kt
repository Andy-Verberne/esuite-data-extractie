/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.validator

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Constraint(validatedBy = [NonNegativeIntegerValidator::class])
annotation class ValidNonNegativeInteger(
    val message: String = "Invalide niet negatieve integer",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
