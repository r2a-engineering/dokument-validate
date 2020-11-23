package io.github.arieldossantos.docs.documents

interface Document {
    fun isValid(documentValue: String): Boolean
}