package app.dalistor.rpgtableplayer.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
class SessionHistory {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0

    val playerName: String = ""
    val content: String = ""
}