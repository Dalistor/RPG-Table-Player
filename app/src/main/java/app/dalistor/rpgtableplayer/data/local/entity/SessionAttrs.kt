package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "sessions_attributes",
    foreignKeys = [
        ForeignKey(
            entity = SessionEntity::class,
            parentColumns = ["id"],
            childColumns = ["sessionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SessionAttrs(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sessionId: Long,

    val name: String,
    val colorHash: String,

    val minValue: Int,
    val maxValue: Int?,

    val createdAt: Long = System.currentTimeMillis()
)

