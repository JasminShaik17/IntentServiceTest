package cubex.mahesh.intentservicetest

import android.app.IntentService
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import java.io.InputStream
import java.net.URL

class MyService : IntentService
{
    constructor() : super("myservice") {

    }
    override fun onHandleIntent(intent: Intent?) {

      var url = URL("https://www.gizmochina.com/wp-content/uploads/2018/05/android-things.jpg")
      var isr =  url.openStream()
      var bmp = BitmapFactory.decodeStream(isr)

    var bmp1 =    ThumbnailUtils.extractThumbnail(bmp,
                                300,300)

        var i = Intent( )
        i.setAction("image_loading_done")
        i.putExtra("image",bmp1)
        sendBroadcast(i)
    }
}