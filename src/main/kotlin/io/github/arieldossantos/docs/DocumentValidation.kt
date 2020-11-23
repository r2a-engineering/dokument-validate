package io.github.arieldossantos.docs

import io.github.arieldossantos.docs.documents.Document

class DocumentValidation(
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