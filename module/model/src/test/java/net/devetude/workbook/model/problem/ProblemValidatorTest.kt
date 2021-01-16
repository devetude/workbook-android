package net.devetude.workbook.model.problem

import com.nhaarman.mockitokotlin2.doReturn
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

class ProblemValidatorTest {
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(STRICT_STUBS)

    @Mock
    private lateinit var problem: Problem

    @Test(expected = IllegalArgumentException::class)
    fun `Test invalid id problem`() {
        whenever(problem.id).doReturn(t = 0L)

        ProblemValidator.requireValid(problem)

        verify(problem).id
        verify(problem, never()).name
        verify(problem, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test empty name problem`() {
        whenever(problem.id).doReturn(t = 1L)
        whenever(problem.name).doReturn(t = "")

        ProblemValidator.requireValid(problem)

        verify(problem).id
        verify(problem).name
        verify(problem, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test too long name problem`() {
        whenever(problem.id).doReturn(t = 1L)
        whenever(problem.name).doReturn(TextCreator.create(len = 201))

        ProblemValidator.requireValid(problem)

        verify(problem).id
        verify(problem).name
        verify(problem, never()).sortOrder
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Test invalid sort order problem`() {
        whenever(problem.id).doReturn(t = 1L)
        whenever(problem.name).doReturn(t = "name")
        whenever(problem.sortOrder).doReturn(t = -1L)

        ProblemValidator.requireValid(problem)

        verify(problem).id
        verify(problem).name
        verify(problem).sortOrder
    }
}
