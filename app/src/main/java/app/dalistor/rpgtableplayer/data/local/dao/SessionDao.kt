package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.SessionEntity

@Dao
@JvmSuppressWildcards
interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sessionEntity: SessionEntity): Long

    @Query("SELECT * FROM sessions")
    suspend fun getAll(): List<SessionEntity>

    @Query("SELECT * FROM sessions WHERE id = :id")
    suspend fun getById(id: Long): SessionEntity

    @Delete
    suspend fun delete(sessionEntity: SessionEntity): Int
}
