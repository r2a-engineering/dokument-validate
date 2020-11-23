package io.github.arieldossantos.docs

import io.github.arieldossantos.docs.documents.brazil.CPF
import org.junit.jupiter.api.Test

internal class DocumentValidationTest {
    val validDocument = DocumentValidation("17652490073",
        CPF
    )
    val invalidDocument = DocumentValidation("00000000088",
        CPF
    )

    @Test
    fun `CPF validation must be invalid`() {
        assert(!invalidDocument.validate())
    }

    @Test
    fun `CPF validation must be valid`() {
        assert(validDocument.validate())
    }
}