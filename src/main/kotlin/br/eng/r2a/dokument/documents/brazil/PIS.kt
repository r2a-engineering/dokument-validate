package br.eng.r2a.dokument.documents.brazil

import br.eng.r2a.dokument.documents.Document
import java.lang.Integer.parseInt

object PIS: Document {
    val baseMultiplier = "3298765432"

    /**
     * Resolve PIS document validation
     *
     * @param documentValue document value for validating
     */
    override fun isValid(documentValue: String): Boolean {
        var totalValue      = 0

        return if(checkDefaults(documentValue)) {
            false
        } else {
            for (i in 0 until 10) {
                var multiplying     = parseInt(documentValue.substring(i, i + 1))
                var multiplier      = parseInt(baseMultiplier.substring(i, i + 1))

                totalValue += multiplying * multiplier
            }

            var resto = 11 - totalValue % 11
            resto = if(resto == 10 || resto == 11) 0 else resto

            var digito = parseInt(documentValue[10].toString())

            resto == digito
        }
    }


    /**
     * Check defaults documents
     *
     * @param documentValue
     */
    private fun checkDefaults(documentValue: String): Boolean {
        return documentValue.length !== 11 ||
                documentValue == "00000000000" ||
                documentValue == "11111111111" ||
                documentValue == "22222222222" ||
                documentValue == "33333333333" ||
                documentValue == "44444444444" ||
                documentValue == "55555555555" ||
                documentValue == "66666666666" ||
                documentValue == "77777777777" ||
                documentValue == "88888888888" ||
                documentValue == "99999999999"
    }
}