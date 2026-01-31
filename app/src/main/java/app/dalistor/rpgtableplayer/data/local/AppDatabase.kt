package app.dalistor.rpgtableplayer.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.dalistor.rpgtableplayer.data.local.dao.CharacterAttrsDao
import app.dalistor.rpgtableplayer.data.local.dao.CharacterDao
import app.dalistor.rpgtableplayer.data.local.dao.CharacterInventoryDao
import app.dalistor.rpgtableplayer.data.local.dao.CharacterInventoryItemDao
import app.dalistor.rpgtableplayer.data.local.dao.CharacterSkillDao
import app.dalistor.rpgtableplayer.data.local.dao.SessionAttrsDao
import app.dalistor.rpgtableplayer.data.local.dao.SessionDao
import app.dalistor.rpgtableplayer.data.local.dao.SessionHistoryDao
import app.dalistor.rpgtableplayer.data.local.entity.CharacterEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterAttrsEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterInventoryItemEntity
import app.dalistor.rpgtableplayer.data.local.entity.CharacterSkillEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionAttrsEntity
import app.dalistor.rpgtableplayer.data.local.entity.SessionHistoryEntity

@Database(
    entities = [
        SessionEntity::class,
        SessionAttrsEntity::class,
        SessionHistoryEntity::class,
        CharacterEntity::class,
        CharacterAttrsEntity::class,
        CharacterSkillEntity::class,
        CharacterInventoryEntity::class,
        CharacterInventoryItemEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sessionDao(): SessionDao
    abstract fun sessionAttrsDao(): SessionAttrsDao
    abstract fun sessionHistoryDao(): SessionHistoryDao
    abstract fun characterDao(): CharacterDao
    abstract fun characterAttrsDao(): CharacterAttrsDao
    abstract fun characterSkillDao(): CharacterSkillDao
    abstract fun characterInventoryDao(): CharacterInventoryDao
    abstract fun characterInventoryItemDao(): CharacterInventoryItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "rpg_table_player_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
