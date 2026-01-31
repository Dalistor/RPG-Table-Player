package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterInventoryItemDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryItemEntity

class CharacterInventoryItemRepository (
    private val characterInventoryItemDao: CharacterInventoryItemDao,
) {
    suspend fun insert(characterInventoryItemEntity: CharacterInventoryItemEntity): Long {
        return characterInventoryItemDao.insert(characterInventoryItemEntity)
    }

    suspend fun getAllByInventoryId(characterInventoryId: Long): List<CharacterInventoryItemEntity> {
        return characterInventoryItemDao.getAllByInventoryId(characterInventoryId)
    }

    suspend fun delete(characterInventoryItemEntity: CharacterInventoryItemEntity): Int {
        return characterInventoryItemDao.delete(characterInventoryItemEntity)
    }
}