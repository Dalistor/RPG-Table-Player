package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.SessionHistoryEntity

@Dao
@JvmSuppressWildcards
interface SessionHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sessionHistoryEntity: SessionHistoryEntity): Long

    @Query("SELECT * FROM session_history WHERE sessionId = :sessionId")
    suspend fun getAllBySessionId(sessionId: Long): List<SessionHistoryEntity>

    @Query("SELECT * FROM session_history WHERE id = :id")
    suspend fun getById(id: Long): SessionHistoryEntity

    @Delete
    suspend fun delete(sessionHistoryEntity: SessionHistoryEntity): Int
}
