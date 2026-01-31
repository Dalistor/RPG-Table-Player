package app.dalistor.rpgtableplayer.data.repository

import app.dalistor.rpgtableplayer.data.local.dao.SessionHistoryDao
import app.dalistor.rpgtableplayer.data.local.entity.SessionHistoryEntity

class SessionHistoryRepository (
    private val sessionHistoryDao: SessionHistoryDao,
) {
    suspend fun insert(sessionHistoryEntity: SessionHistoryEntity): Long {
        return sessionHistoryDao.insert(sessionHistoryEntity)
    }

    suspend fun getAllBySessionId(sessionId: Long): List<SessionHistoryEntity> {
        return sessionHistoryDao.getAllBySessionId(sessionId)
    }

    suspend fun getById(id: Long): SessionHistoryEntity {
        return sessionHistoryDao.getById(id)
    }

    suspend fun delete(sessionHistoryEntity: SessionHistoryEntity): Int {
        return sessionHistoryDao.delete(sessionHistoryEntity)
    }
}