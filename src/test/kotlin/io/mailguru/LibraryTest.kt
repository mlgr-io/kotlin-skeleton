package io.mailguru

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LibraryTest {

    @Test
    fun `do a dummy test as a proof of concept`() {
        Library().returnOne() shouldBe 1
    }
}
