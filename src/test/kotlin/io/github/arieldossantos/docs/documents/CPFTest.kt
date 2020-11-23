package io.github.arieldossantos.docs.documents

import io.github.arieldossantos.docs.documents.brazil.CPF
import io.mockk.spyk
import org.junit.jupiter.api.Test


internal class CPFTest {
    private val cpf = spyk<CPF>();

    @Test
    fun `CPF must be invalid`() {
        assert(!cpf.isValid("00000000088"))
    }

    @Test
    fun `CPF must be valid`() {
        assert(cpf.isValid("17652490073"))
    }


}