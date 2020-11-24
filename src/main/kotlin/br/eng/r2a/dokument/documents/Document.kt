package br.eng.r2a.dokument.documents

interface Document {
    fun isValid(documentValue: String): Boolean
}