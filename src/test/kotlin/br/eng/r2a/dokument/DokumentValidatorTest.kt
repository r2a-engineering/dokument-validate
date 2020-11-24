package br.eng.r2a.dokument

import br.eng.r2a.dokument.documents.brazil.CPF
import org.junit.jupiter.api.Test

internal class DokumentValidatorTest {
    val validDocument = DokumentValidator(
        "17652490073",
        CPF
    )
    val invalidDocument = DokumentValidator(
        "00000000088",
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