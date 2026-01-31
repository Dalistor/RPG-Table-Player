package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.CharacterAttrsDao
import app.dalistor.rpgtableplayer.data.local.dao.SessionAttrsDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterAttrsEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionAttrsEntity

class SessionAttrsRepository (
    private val sessionAttrsDao: SessionAttrsDao,
    private val characterAttrsDao: CharacterAttrsDao,
) {
    suspend fun insert(sessionAttrsEntity: SessionAttrsEntity): Long {
        val sessionAttrId = sessionAttrsDao.insert(sessionAttrsEntity)

        // Atualizar os atributos do personagem de acordo com a campanha
        val sessionAttrs = sessionAttrsDao.getById(sessionAttrId)
        val allCharacterAttrToUpdate = characterAttrsDao.getAllBySessionId(sessionAttrId)
        for (attr in allCharacterAttrToUpdate) {
            val newAttr = CharacterAttrsEntity(
                id = attr.id,
                characterId = attr.characterId,
                sessionAttrId = attr.sessionAttrId,
                name = sessionAttrs.name,
                colorHash = sessionAttrs.colorHash,
                minValue = sessionAttrs.minValue,
                maxValue = sessionAttrs.maxValue,
                value = attr.value,
                createdAt = attr.createdAt
            )

            characterAttrsDao.insert(newAttr)
        }

        return sessionAttrId
    }

    suspend fun getAll(): List<SessionAttrsEntity> {
        return sessionAttrsDao.getAll()
    }

    suspend fun getById(id: Long): SessionAttrsEntity {
        return sessionAttrsDao.getById(id)
    }

    suspend fun delete(sessionAttrsEntity: SessionAttrsEntity): Int {
        return sessionAttrsDao.delete(sessionAttrsEntity)
    }
}