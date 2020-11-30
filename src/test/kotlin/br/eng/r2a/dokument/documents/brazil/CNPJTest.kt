package br.eng.r2a.dokument.documents.brazil

import br.eng.r2a.dokument.DokumentValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CNPJTest {
    @Test
    fun `when cnpj is invalid, must return false`() {
        val dkmntVldtr = DokumentValidator("77371258000127", CNPJ)
        assert(!dkmntVldtr.validate())
    }

    @Test
    fun `when cnpj is valid, must return true`() {
        val dkmntVldtr = DokumentValidator("24626495000127", CNPJ)
        assert(dkmntVldtr.validate())
    }
}