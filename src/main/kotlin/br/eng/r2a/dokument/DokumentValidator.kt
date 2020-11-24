package br.eng.r2a.dokument

import br.eng.r2a.dokument.documents.Document

class DokumentValidator(
    val documentValue: String,
    val documentInstance: Document
) {
    /**
     * Validate a document from a instance
     */
    fun validate(): Boolean {
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