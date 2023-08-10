package pa.chan.testtasksport.features.splash.data

import android.content.SharedPreferences
import javax.inject.Inject

class PrefDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setCurrentPage(page: Int) {
        sharedPreferences.edit()
            .putInt("currentPage", page)
            .apply()
    }

    fun getCurrentPage(): Int {
        return sharedPreferences.getInt("currentPage", 1)
    }

    fun setHasMore(hasMore: Boolean) {
        sharedPreferences.edit()
            .putBoolean("hasMore", hasMore)
            .apply()
    }

    fun getHasMore(): Boolean {
        return sharedPreferences.getBoolean("hasMore", true)
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}