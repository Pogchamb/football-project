package pa.chan.testtasksport.features.splash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.testtasksport.features.splash.data.entity.MatchEntity

@Dao
interface StatisticDao {
    @Query("SELECT * FROM matchEntity")
    suspend fun getStatistic(): List<MatchEntity>

    @Insert
    suspend fun insertStatistic(matchEntity: MatchEntity)

    @Query("DELETE FROM matchEntity")
    suspend fun deleteStatistic()
}