package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,
    val description: String,
    val setHistory: Boolean,

    val createdAt: Long = System.currentTimeMillis()
)
