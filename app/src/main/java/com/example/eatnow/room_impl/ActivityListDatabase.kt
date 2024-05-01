package com.example.eatnow.room_impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eatnow.room_impl.entity.Orders

@Database(
    entities = [Orders::class],
    version = 1,
    exportSchema = false
)
abstract class ActivityListDatabase:RoomDatabase() {
    public abstract fun recordsDao(): OrdersDao

    companion object {
        @Volatile
        var INSTANCE: ActivityListDatabase? = null
        fun getDatabase(context: Context): ActivityListDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActivityListDatabase::class.java,
                    "food_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
