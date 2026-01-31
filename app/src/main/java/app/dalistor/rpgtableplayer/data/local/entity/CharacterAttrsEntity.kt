package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_attributes",
    foreignKeys = [
        ForeignKey(
            entity = CharacterEntity::class,
            parentColumns = ["id"],
            childColumns = ["characterId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SessionAttrsEntity::class,
            parentColumns = ["id"],
            childColumns = ["sessionAttrId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CharacterAttrsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val sessionAttrId: Long,

    val name: String,
    val colorHash: String,

    val minValue: Int,
    val maxValue: Int?,

    val value: Int,

    val createdAt: Long = System.currentTimeMillis()
)

