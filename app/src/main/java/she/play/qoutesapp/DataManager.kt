package she.play.qoutesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import she.play.qoutesapp.model.Quote
import java.nio.Buffer

object DataManager {

    var data= emptyArray<Quote>()
    var currentQuote:Quote?=null
    var currentPages = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if (currentPages.value==Pages.LISTING){
            currentQuote=quote
            currentPages.value=Pages.DETAIL
        }else{
            currentPages.value = Pages.LISTING
        }
    }
}