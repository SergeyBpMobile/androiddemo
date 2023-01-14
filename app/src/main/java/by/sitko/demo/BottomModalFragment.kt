package by.sitko.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isGone
import by.sitko.demo.adapter.RecyclerAdapter
import by.sitko.demo.databinding.FragmentBottomModalBinding
import by.sitko.demo.model.TextItem
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.random.Random


class BottomModalFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomModalBinding
    val adapter = RecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBottomModalBinding.inflate(inflater, container, false)

        dialog?.setOnShowListener {
            val dialog = it as BottomSheetDialog
            val bottomSheet =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

            val screenHeight = requireActivity().window.decorView.height
            val listHeight = 1000


            if (screenHeight / 2 > listHeight) {
                bottomSheetBehavior.peekHeight = listHeight
            } else {
                bottomSheetBehavior.peekHeight = screenHeight
            }

            bottomSheet.parent.requestLayout()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.submitList(
            List(20) {
                TextItem(text = Random.nextInt(0, 19).toString())
            }
        )
        binding.recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = BottomModalFragment()
    }
}