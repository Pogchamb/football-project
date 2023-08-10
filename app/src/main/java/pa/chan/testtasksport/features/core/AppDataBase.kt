package pa.chan.testtasksport.features.core

import androidx.room.Database
import androidx.room.RoomDatabase
import pa.chan.testtasksport.features.splash.data.StatisticDao
import pa.chan.testtasksport.features.splash.data.entity.MatchEntity

@Database(
    entities = [MatchEntity::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun statisticDao(): StatisticDao
}