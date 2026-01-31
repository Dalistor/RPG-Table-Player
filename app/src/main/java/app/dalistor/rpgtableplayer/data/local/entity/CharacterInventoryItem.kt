package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "character_inventory_item",
    foreignKeys = [
        ForeignKey(
            entity = CharacterInventory::class,
            parentColumns = ["id"],
            childColumns = ["characterInventoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CharacterInventoryItem (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterInventoryId: Long,

    val name: String,
    val description: String?,
)