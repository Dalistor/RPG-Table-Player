package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "sessions_attributes",
    foreignKeys = [
        ForeignKey(
            entity = Character::class,
            parentColumns = ["id"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SessionAttrs::class,
            parentColumns = ["id"],
            childColumns = ["sessionAttrId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CharacterAttrs(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val sessionAttrId: Long,

    val name: String,
    val colorHash: String,

    val minValue: Int,
    val maxValue: Int?,

    val createdAt: Long = System.currentTimeMillis()
)

