package br.eng.r2a.dokument

import br.eng.r2a.dokument.documents.Document

/**
 * Dokument Validator
 *
 * A document for documents validations abstractions
 *
 * @author Ariel Reis
 */
class DokumentValidator(
    val documentValue: String,
    var documentInstance: Document
) {
    /**
     * Document Instance validator
     */
    constructor(documentInstance: Document): this("", documentInstance)

    /**
     * Validate a document from a instance
     */
    fun validate(): Boolean {
        return documentInstance.isValid(removeInvalidChars(documentValue))
    }

    /**
     * Validate a document value from instance, defining a document as a param
     *
     * @param documentValue document value in string
     */
    fun validate(documentValue: String): Boolean {
        return documentInstance.isValid(removeInvalidChars(documentValue))
    }

    /**
     * Remove all invalid chars of any document
     *
     * @param value to be replaced
     */
    private fun removeInvalidChars(value: String): String {
        return value.replace(".", "").replace("-", "")
    }
}