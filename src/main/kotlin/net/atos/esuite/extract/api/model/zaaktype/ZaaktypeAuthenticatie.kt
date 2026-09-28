/*
 * SPDX-FileCopyrightText: 2025 Dimpact
 * SPDX-License-Identifier: EUPL-1.2+
 */

package net.atos.esuite.extract.api.model.zaaktype

import org.eclipse.microprofile.openapi.annotations.media.Schema

class ZaaktypeAuthenticatie(

    @field:Schema(description = "Doelgroep van authenticatie")
    val doelgroep: AuthenticatieDoelgroep,

    @field:Schema(description = "Niveau van authenticatie")
    val niveau: AuthenticatieNiveau,
)
