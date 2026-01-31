package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryItemEntity

@Dao
@JvmSuppressWildcards
interface CharacterInventoryItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterInventoryItemEntity: CharacterInventoryItemEntity): Long

    @Query("SELECT * FROM character_inventory_item WHERE characterInventoryId = :characterInventoryId")
    suspend fun getAllByInventoryId(characterInventoryId: Long): List<CharacterInventoryItemEntity>

    @Delete
    suspend fun delete(characterInventoryItemEntity: CharacterInventoryItemEntity): Int
}
