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
data class CharacterEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sessionId: Long,

    val name: String,
    val description: String,

    val createdAt: Long = System.currentTimeMillis()
)
