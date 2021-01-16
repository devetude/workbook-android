package net.devetude.workbook.model.workbook

internal object WorkbookValidator {
    const val MIN_ID = 1L
    const val MIN_NAME_LEN = 1L
    const val MAX_NAME_LEN = 50L
    const val MIN_SORT_ORDER = 0L

    fun requireValid(workbook: Workbook) = with(workbook) {
        id.isValidId()
        name.isValidName()
        sortOrder.isValidSortOrder()
    }

    private fun Long.isValidId() = require(MIN_ID <= this)

    private fun String.isValidName() = require(length in MIN_NAME_LEN..MAX_NAME_LEN)

    private fun Long.isValidSortOrder() = require(MIN_SORT_ORDER <= this)
}
