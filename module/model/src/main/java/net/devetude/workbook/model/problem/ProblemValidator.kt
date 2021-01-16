package net.devetude.workbook.model.problem

internal object ProblemValidator {
    const val MIN_ID = 1L
    const val MIN_NAME_LEN = 1L
    const val MAX_NAME_LEN = 200L
    const val MIN_SORT_ORDER = 0L
    fun requireValid(problem: Problem) = with(problem) {
        id.isValidId()
        name.isValidName()
        sortOrder.isValidSortOrder()
    }

    private fun Long.isValidId() = require(MIN_ID <= this)

    private fun String.isValidName() = require(length in MIN_NAME_LEN..MAX_NAME_LEN)

    private fun Long.isValidSortOrder() = require(MIN_SORT_ORDER <= this)
}
