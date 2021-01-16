package net.devetude.workbook.model.workbook

import androidx.annotation.IntRange
import androidx.annotation.Size
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.devetude.workbook.model.workbook.Workbook.Companion.TABLE_NAME
import net.devetude.workbook.model.workbook.WorkbookValidator.MAX_NAME_LEN
import net.devetude.workbook.model.workbook.WorkbookValidator.MIN_ID
import net.devetude.workbook.model.workbook.WorkbookValidator.MIN_NAME_LEN
import net.devetude.workbook.model.workbook.WorkbookValidator.MIN_SORT_ORDER
import java.util.Date

@Entity(tableName = TABLE_NAME)
data class Workbook(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COL_NAME)
    @IntRange(from = MIN_ID)
    val id: Long,

    @ColumnInfo(name = NAME_COL_NAME, index = true)
    @Size(min = MIN_NAME_LEN, max = MAX_NAME_LEN)
    val name: String,

    @ColumnInfo(name = SORT_ORDER_COL_NAME, index = true)
    @IntRange(from = MIN_SORT_ORDER)
    val sortOrder: Long,

    @ColumnInfo(name = CREATED_DATE_COL_NAME, index = true)
    val createdDate: Date,
) {
    init {
        WorkbookValidator.requireValid(workbook = this)
    }

    companion object {
        internal const val TABLE_NAME = "workbook"

        private const val COL_PREFIX = "w_"
        internal const val ID_COL_NAME = "${COL_PREFIX}id"
        private const val NAME_COL_NAME = "${COL_PREFIX}name"
        private const val SORT_ORDER_COL_NAME = "${COL_PREFIX}sort_order"
        private const val CREATED_DATE_COL_NAME = "${COL_PREFIX}created_date"
    }
}
