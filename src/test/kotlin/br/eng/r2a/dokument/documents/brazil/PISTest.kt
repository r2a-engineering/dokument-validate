package br.eng.r2a.dokument.documents.brazil

import br.eng.r2a.dokument.DokumentValidator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PISTest {

    @Test
    fun `when a PIS value is valid must return true`() {
        val VALID_PIS = "87353909993"
        val dkvd = DokumentValidator(VALID_PIS, PIS)

        assert(dkvd.validate())
    }

    @Test
    fun `when a PIS value is invalid must return false`() {
        val INVALID_PIS = "87353909999"
        val dkvd = DokumentValidator(INVALID_PIS, PIS)

        assert(!dkvd.validate())
    }

    @Test
    fun `when a PIS value is invalid (only zeros) must return false`() {
        val INVALID_PIS = "00000000000"
        val dkvd = DokumentValidator(INVALID_PIS, PIS)

        assert(!dkvd.validate())
    }
}