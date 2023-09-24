package coded.alchemy.qoutable.database

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object Converters {
    private val json = Json

    @JvmStatic
    @TypeConverter
    fun fromString(value: String): ArrayList<String> {
        return json.decodeFromString(value)
    }

    @JvmStatic
    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        return json.encodeToString(list)
    }
}
