package app.dalistor.rpgtableplayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.dalistor.rpgtableplayer.data.local.entity.SessionAttrsEntity

@Dao
@JvmSuppressWildcards
interface SessionAttrsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sessionAttrsEntity: SessionAttrsEntity): Long

    @Query("SELECT * FROM sessions_attributes")
    suspend fun getAll(): List<SessionAttrsEntity>

    @Query("SELECT * FROM sessions_attributes WHERE id = :id")
    suspend fun getById(id: Long): SessionAttrsEntity

    @Delete
    suspend fun delete(sessionAttr: SessionAttrsEntity): Int
}
