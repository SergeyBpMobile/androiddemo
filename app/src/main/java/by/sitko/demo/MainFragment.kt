package by.sitko.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import by.sitko.demo.adapter.RecyclerAdapter
import by.sitko.demo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FrameLayout {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.showBottomModal.setOnClickListener {
            (requireActivity() as MainActivity).showModal()
        }
        return binding.root
    }
}