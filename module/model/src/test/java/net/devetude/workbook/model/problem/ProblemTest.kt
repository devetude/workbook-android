package net.devetude.workbook.model.problem

import org.junit.Test
import java.util.Date
import kotlin.test.assertEquals

class ProblemTest {
    @Test
    fun `Test Problem`() {
        val createdDate = Date()
        val problem = Problem(
            id = 1L,
            workbookId = 1L,
            name = "name",
            sortOrder = 0L,
            createdDate = createdDate
        )

        with(problem) {
            assertEquals(expected = 1L, actual = id)
            assertEquals(expected = 1L, actual = workbookId)
            assertEquals(expected = "name", actual = name)
            assertEquals(expected = 0L, actual = sortOrder)
            assertEquals(expected = createdDate, actual = this.createdDate)
        }
    }
}
