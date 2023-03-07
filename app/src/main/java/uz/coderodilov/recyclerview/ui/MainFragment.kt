package uz.coderodilov.recyclerview.ui

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import uz.coderodilov.recyclerview.model.Model
import uz.coderodilov.recyclerview.R
import uz.coderodilov.recyclerview.adapter.Adapter
import uz.coderodilov.recyclerview.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var list: MutableList<Model>
    private lateinit var adapter: Adapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        loadList()
        getAdapter(2)
        binding.rview.layoutManager = setLayoutManager(2)
        binding.rview.adapter = adapter

        binding.btnGrid.setOnClickListener{
            binding.rview.layoutManager = setLayoutManager(1)
            getAdapter(1)
            binding.rview.adapter = adapter
        }

        binding.btnList.setOnClickListener{
            binding.rview.layoutManager = setLayoutManager(2)
            getAdapter(2)
            binding.rview.adapter = adapter
        }

    }

    private fun getAdapter(index: Int) {
       adapter = Adapter(list, index)
    }

    private fun setLayoutManager(index:Int) : LayoutManager {
       return  when(index){
           1-> GridLayoutManager(requireContext(),2)
           2-> LinearLayoutManager(requireContext())
           else -> GridLayoutManager(requireContext(),2)
       }
    }

    private fun loadList() {
        list = ArrayList()
        list.add(Model(R.drawable.telegram, "Telegram"))
        list.add(Model(R.drawable.instagram, "Instagram"))
        list.add(Model(R.drawable.workout, "Workout"))
        list.add(Model(R.drawable.discord, "Discord"))
        list.add(Model(R.drawable.fitness, "Fitness"))
        list.add(Model(R.drawable.gym, "GYM"))
        list.add(Model(R.drawable.snapchat, "Snapchat"))
        list.add(Model(R.drawable.twitter, "Twitter"))
        list.add(Model(R.drawable.yoga, "YOGA"))
        list.add(Model(R.drawable.whatsapp, "Whatsapp"))
        list.add(Model(R.drawable.facebook, "Facebook"))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}