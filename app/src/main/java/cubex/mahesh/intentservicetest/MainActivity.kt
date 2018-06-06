package cubex.mahesh.intentservicetest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var filter = IntentFilter( )
        filter.addAction("image_loading_done")
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
      Toast.makeText(this@MainActivity,
              "Image Loading is completed...",
              Toast.LENGTH_LONG).show()
    var bmp =    intent?.getParcelableExtra<Bitmap>("image")
     var iview:ImageView = findViewById(R.id.iview)
     iview.setImageBitmap(bmp)

            }
        },filter)
    }
    fun getImage(v:View)
    {
var i = Intent(this,MyService::class.java)
 startService(i)
    }
}
