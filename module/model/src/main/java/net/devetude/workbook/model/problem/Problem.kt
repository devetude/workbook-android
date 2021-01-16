package net.devetude.workbook.model.problem

import androidx.annotation.IntRange
import androidx.annotation.Size
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import net.devetude.workbook.model.problem.Problem.Companion.TABLE_NAME
import net.devetude.workbook.model.problem.Problem.Companion.WORKBOOK_ID_COL_NAME
import net.devetude.workbook.model.problem.ProblemValidator.MAX_NAME_LEN
import net.devetude.workbook.model.problem.ProblemValidator.MIN_ID
import net.devetude.workbook.model.problem.ProblemValidator.MIN_NAME_LEN
import net.devetude.workbook.model.problem.ProblemValidator.MIN_SORT_ORDER
import net.devetude.workbook.model.workbook.Workbook
import net.devetude.workbook.model.workbook.Workbook.Companion.ID_COL_NAME
import net.devetude.workbook.model.workbook.WorkbookValidator
import net.devetude.workbook.model.workbook.WorkbookValidator.isValidId
import java.util.Date

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Workbook::class,
            parentColumns = [ID_COL_NAME],
            childColumns = [WORKBOOK_ID_COL_NAME],
            onDelete = CASCADE
        )
    ]
)
data class Problem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COL_NAME)
    @IntRange(from = MIN_ID)
    val id: Long,

    @ColumnInfo(name = WORKBOOK_ID_COL_NAME, index = true)
    @IntRange(from = WorkbookValidator.MIN_ID)
    val workbookId: Long,

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
        ProblemValidator.requireValid(problem = this)
        workbookId.isValidId()
    }

    companion object {
        internal const val TABLE_NAME = "problem"

        private const val COL_PREFIX = "p_"
        private const val ID_COL_NAME = "${COL_PREFIX}id"
        internal const val WORKBOOK_ID_COL_NAME = "${COL_PREFIX}workbook_id"
        private const val NAME_COL_NAME = "${COL_PREFIX}name"
        private const val SORT_ORDER_COL_NAME = "${COL_PREFIX}sort_order"
        private const val CREATED_DATE_COL_NAME = "${COL_PREFIX}created_date"
    }
}
