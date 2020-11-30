package br.eng.r2a.dokument.documents.brazil

import br.eng.r2a.dokument.documents.Document

object CNPJ: Document {
    override fun isValid(documentValue: String): Boolean {
        if (documentValue.length != 14)
            return false

        return if (isInvalidDocument(documentValue)) {
            false
        } else {
            var cnpjSizeWithoutDV = documentValue.length - 2
            var numbers = documentValue.substring(0, cnpjSizeWithoutDV)
            var digits  = documentValue.substring(cnpjSizeWithoutDV)

            var sum = 0;
            var position = cnpjSizeWithoutDV - 7

            for(i in cnpjSizeWithoutDV downTo 1) {
                sum += Integer.parseInt(numbers[cnpjSizeWithoutDV - i].toString()) * position--
                if (position < 2) {
                    position = 9
                }
            }

            var result = if (sum % 11 < 2) 0 else 11 - sum % 11
            if (result != Integer.parseInt(digits[0].toString())) {
                false
            } else {
                cnpjSizeWithoutDV += 1
                numbers = documentValue.substring(0, cnpjSizeWithoutDV)
                sum = 0
                position = cnpjSizeWithoutDV - 7

                for(i in cnpjSizeWithoutDV downTo 1) {
                    sum += Integer.parseInt(numbers[cnpjSizeWithoutDV - i].toString()) * position--
                    if (position < 2) {
                        position = 9
                    }
                }

                result = if (sum % 11 < 2) 0 else 11 - sum % 11
                result == Integer.parseInt(digits[1].toString())
            }

        }
    }


    private fun isInvalidDocument(documentValue: String): Boolean {
        return (documentValue == "00000000000000" ||
                documentValue == "11111111111111" ||
                documentValue == "22222222222222" ||
                documentValue == "33333333333333" ||
                documentValue == "44444444444444" ||
                documentValue == "55555555555555" ||
                documentValue == "66666666666666" ||
                documentValue == "77777777777777" ||
                documentValue == "88888888888888" ||
                documentValue == "99999999999999")
    }
}