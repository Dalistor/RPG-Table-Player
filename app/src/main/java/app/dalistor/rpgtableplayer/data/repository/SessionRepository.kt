package app.dalistor.rpgtableplayer.data.repository

import androidx.compose.ui.graphics.Color
import app.dalistor.rpgtableplayer.data.local.dao.SessionDao
import app.dalistor.rpgtableplayer.data.local.entity.SessionAttrsEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionHistoryEntity


class SessionRepository (
    private val sessionDao: SessionDao,
    private val sessionAttrsRepository: SessionAttrsRepository,
    private val sessionHistoryRepository: SessionHistoryRepository
) {
    suspend fun insert(sessionEntity: SessionEntity): Long {
        val sessionId = sessionDao.insert(sessionEntity)

        val session = sessionDao.getById(sessionId)

        // Se sessão tiver histórico de mensagem mandar esta mensagem:
        if (session.setHistory) {
            val sessionHistoryEntity = SessionHistoryEntity(
                sessionId = sessionId,
                entityName = "Sistema",
                content = "Chat criado!"
            )
            sessionHistoryRepository.insert(sessionHistoryEntity)
        }

        // Criar atributos básicos da sessão
        val sessionAttrsEntity = SessionAttrsEntity(
            sessionId = sessionId,
            name = "HP",
            colorHash = "0xD61C1C",
            maxValue = 100,
            minValue = 0
        )
        sessionAttrsRepository.insert(sessionAttrsEntity)

        return sessionId
    }

    suspend fun getAll(): List<SessionEntity> {
        return sessionDao.getAll()
    }

    suspend fun getById(id: Long): SessionEntity {
        return sessionDao.getById(id)
    }

    suspend fun delete(sessionEntity: SessionEntity): Int {
        return sessionDao.delete(sessionEntity)
    }
}