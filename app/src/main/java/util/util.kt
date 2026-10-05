package util

import android.content.Context
import android.content.Intent
import com.example.taskmanager.MainActivity

//Esta clase tendra un metodo estatico para muchas clases
class util {
    companion object{
        fun OpenActivity(context: Context, classActivity: Class<*>){
        val objIntent = Intent(context, classActivity)
        context.startActivity(objIntent)
        }
    }
}