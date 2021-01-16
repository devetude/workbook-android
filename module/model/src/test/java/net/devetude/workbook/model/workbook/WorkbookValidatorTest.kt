package net.devetude.workbook.model.workbook

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import net.devetude.workbook.model.util.TextCreator
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness.STRICT_STUBS

class WorkbookValidatorTest {
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(STRICT_STUBS)

    @Mock
    private lateinit var workbook: Workbook

    @Test(expected = IllegalArgumentException::class)
    fun `Test invalid id workbook`() {
        whenever(workbook.id).doReturn(t = 0L)

        WorkbookValidator.requireValid(workbook)

        verify(workbook).id
        verify(workbook, never()).name
        verify(workbook, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test empty name workbook`() {
        whenever(workbook.id).doReturn(t = 1L)
        whenever(workbook.name).doReturn(t = "")

        WorkbookValidator.requireValid(workbook)

        verify(workbook).id
        verify(workbook).name
        verify(workbook, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test too long name workbook`() {
        whenever(workbook.id).doReturn(t = 1L)
        whenever(workbook.name).doReturn(TextCreator.create(len = 51))

        WorkbookValidator.requireValid(workbook)

        verify(workbook).id
        verify(workbook).name
        verify(workbook, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test invalid sort order workbook`() {
        val workbook = mock<Workbook> {
            on { id } doReturn 1L
            on { name } doReturn "name"
            on { sortOrder } doReturn -1L
        }

        WorkbookValidator.requireValid(workbook)

        verify(workbook).id
        verify(workbook).name
        verify(workbook).sortOrder
    }
}
