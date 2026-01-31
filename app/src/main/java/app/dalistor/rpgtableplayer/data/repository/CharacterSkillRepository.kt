package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterSkillDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterSkillEntity

class CharacterSkillRepository (
    private val characterSkillDao: CharacterSkillDao,
) {
    suspend fun insert(characterSkillEntity: CharacterSkillEntity): Long {
        return characterSkillDao.insert(characterSkillEntity)
    }

    suspend fun getAllByCharacterId(characterId: Long): List<CharacterSkillEntity> {
        return characterSkillDao.getAllByCharacterId(characterId)
    }

    suspend fun delete(characterSkillEntity: CharacterSkillEntity): Int {
        return characterSkillDao.delete(characterSkillEntity)
    }
}