package by.sitko.demo

import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isGone
import com.google.android.material.bottomsheet.BottomSheetBehavior

fun BottomSheetBehavior<FrameLayout>.addSheetCallback(topView: View) {
    addBottomSheetCallback(object :
        BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            if (BottomSheetBehavior.STATE_DRAGGING == newState) {
                topView.isGone = false
            } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                topView.isGone = true
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }
    })
}