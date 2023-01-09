package by.sitko.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.sitko.demo.databinding.ActivityMainBinding
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }

    fun showModal() {
        BottomModalFragment.newInstance().show(supportFragmentManager, "MODAL")
    }
}