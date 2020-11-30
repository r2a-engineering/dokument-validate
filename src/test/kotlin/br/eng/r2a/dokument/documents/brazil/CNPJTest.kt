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


    @Test
    fun `when cnpj last digit is invalid, must return false`() {
        val dkmntVldtr = DokumentValidator("24626495000128", CNPJ)
        assert(!dkmntVldtr.validate())
    }

    @Test
    fun `when cnpj last but one digit is invalid, must return false`() {
        val dkmntVldtr = DokumentValidator("24626495000128", CNPJ)
        assert(!dkmntVldtr.validate())
    }

    @Test
    fun `when cnpj length is invalid, must return false`() {
        val dkmntVldtr = DokumentValidator("2462649500012", CNPJ)
        assert(!dkmntVldtr.validate())
    }

    @Test
    fun `when cnpj is one of defaults, must return false`() {
        val dkmntVldtr = DokumentValidator("00000000000000", CNPJ)
        assert(!dkmntVldtr.validate())
    }
}