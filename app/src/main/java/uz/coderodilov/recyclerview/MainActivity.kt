package uz.coderodilov.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.coderodilov.recyclerview.databinding.ActivityMainBinding
import uz.coderodilov.recyclerview.model.Model
import uz.coderodilov.recyclerview.ui.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment()).commit()
    }

}