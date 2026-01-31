package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterAttrsDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterAttrsEntity

class CharacterAttrsRepository (
    private val characterAttrsDao: CharacterAttrsDao,
) {
    suspend fun insert(characterAttrsEntity: CharacterAttrsEntity): Long {
        return characterAttrsDao.insert(characterAttrsEntity)
    }

    suspend fun getAllByCharacterId(id: Long): List<CharacterAttrsEntity> {
        return characterAttrsDao.getAllByCharacterId(id)
    }

    suspend fun getById(id: Long): CharacterAttrsEntity {
        return characterAttrsDao.getById(id)
    }

    suspend fun delete(characterAttrsEntity: CharacterAttrsEntity): Int {
        return characterAttrsDao.delete(characterAttrsEntity)
    }
}