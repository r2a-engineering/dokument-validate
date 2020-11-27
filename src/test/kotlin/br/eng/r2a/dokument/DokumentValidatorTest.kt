package br.eng.r2a.dokument

import br.eng.r2a.dokument.documents.brazil.CPF
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DokumentValidatorTest {

    private val validDocument = DokumentValidator(
        "17652490073",
        CPF
    )
    private val invalidDocument = DokumentValidator(
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


    @Test
    fun `when document value is null and define in param must be valid`() {
        assert(validDocument.validate("17652490073"))
    }

    @Test
    fun `when document value is not null and define in param must be invalid`() {
        val dkt = DokumentValidator(CPF)
        assert(!dkt.validate("17652490074"))
    }
}