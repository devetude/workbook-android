package net.devetude.workbook.model.workbook

import org.junit.Test
import java.util.Date
import kotlin.test.assertEquals

class WorkbookTest {
    @Test
    fun `Test Workbook`() {
        val createdDate = Date()
        val workbook = Workbook(
            id = 1L,
            name = "name",
            sortOrder = 0L,
            createdDate = createdDate
        )

        with(workbook) {
            assertEquals(expected = 1L, actual = id)
            assertEquals(expected = "name", actual = name)
            assertEquals(expected = 0L, actual = sortOrder)
            assertEquals(expected = createdDate, actual = this.createdDate)
        }
    }
}
