package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "characters",
    foreignKeys = [
        ForeignKey(
            entity = SessionEntity::class,
            parentColumns = ["id"],
            childColumns = ["sessionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Character (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sessionId: Long,

    val name: String,
    val description: String,

    val atributes: List<SessionAttrs>,

    val createdAt: Long = System.currentTimeMillis()
)