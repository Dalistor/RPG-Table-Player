package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterInventoryDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryEntity

class CharacterInventoryRepository (
    private val characterInventoryDao: CharacterInventoryDao,
) {
    suspend fun insert(characterInventoryEntity: CharacterInventoryEntity): Long {
        return characterInventoryDao.insert(characterInventoryEntity)
    }

    suspend fun getByCharacterId(characterId: Long): CharacterInventoryEntity? {
        return characterInventoryDao.getByCharacterId(characterId)
    }

    suspend fun delete(characterInventoryEntity: CharacterInventoryEntity): Int {
        return characterInventoryDao.delete(characterInventoryEntity)
    }
}