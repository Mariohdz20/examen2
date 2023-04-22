package edu.iest.examenparcial2

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examenparcial2.adapter.MenuAdapter
import edu.iest.examenparcial2.models.Opciones

class MainActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null
    private var imagen: ImageView? = null
    private var isConnected: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun connectToInternet(): Boolean {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            isConnected = activeNetwork?.isConnectedOrConnecting == true
            return isConnected as Boolean
        }


        connectToInternet()

        recycler = findViewById(R.id.rcOpciones)
        val opciones = Opciones().getOpciones()

        recycler?.layoutManager = GridLayoutManager(this, 2)
        recycler?.adapter = MenuAdapter(opciones, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isConnected == true){
            if (item.itemId == R.id.opcionInternet) {
                Toast.makeText(this, "Estas conectado a internet", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "No estas conectado a internet", Toast.LENGTH_LONG).show()
        }
        return false
    }
}