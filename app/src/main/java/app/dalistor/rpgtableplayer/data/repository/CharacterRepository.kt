package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterAttrsEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterSkillEntity

class CharacterRepository (
    private val characterDao: CharacterDao,
    private val characterAttrsRepository: CharacterAttrsRepository,
    private val characterInventoryRepository: CharacterInventoryRepository,
    private val characterSkillRepository: CharacterSkillRepository,
    private val sessionAttrsRepository: SessionAttrsRepository
) {
    suspend fun insert(characterEntity: CharacterEntity): Long {
        val characterId = characterDao.insert(characterEntity)

        val character = characterDao.getById(characterId)

        // Criar atributos básicos do personagem de acordo com a campanha
        val sessionAttrsEntity = sessionAttrsRepository.getById(character.sessionId)
        val characterAttrsEntity = CharacterAttrsEntity(
            characterId = characterId,
            sessionAttrId = character.sessionId,
            name = sessionAttrsEntity.name,
            colorHash = sessionAttrsEntity.colorHash,
            maxValue = sessionAttrsEntity.maxValue,
            minValue = sessionAttrsEntity.minValue,
            value = if (sessionAttrsEntity.maxValue != null) sessionAttrsEntity.maxValue else 100,
        )
        characterAttrsRepository.insert(characterAttrsEntity)

        // Criar inventário do personagem
        val characterInventoryEntity = CharacterInventoryEntity(
            characterId = characterId
        )
        characterInventoryRepository.insert(characterInventoryEntity)

        // Criar habilidades do personagem
        val characterSkillEntity = CharacterSkillEntity(
            characterId = characterId,
            formula = "1D4+5"
        )
        characterSkillRepository.insert(characterSkillEntity)


        return characterId
    }

    suspend fun getAllBySessionId(sessionId: Long): List<CharacterEntity> {
        return characterDao.getAllBySessionId(sessionId)
    }

    suspend fun getById(id: Long): CharacterEntity {
        return characterDao.getById(id)
    }

    suspend fun delete(characterEntity: CharacterEntity): Int {
        return characterDao.delete(characterEntity)
    }
}