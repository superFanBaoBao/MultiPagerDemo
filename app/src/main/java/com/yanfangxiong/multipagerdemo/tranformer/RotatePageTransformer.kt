package com.yanfangxiong.multipagerdemo.tranformer

import android.support.v4.view.ViewPager
import android.view.View

/**
 * @author fxYan
 */
class RotatePageTransformer(
        private var rotateDegree: Float
) : ViewPager.PageTransformer {

    override fun transformPage(page: View?, position: Float) {
        if (page == null) return

        val tPivotX: Float
        val degree: Float
        when {
            position < -1 -> {
                tPivotX = page.width.toFloat()
                degree = -rotateDegree
            }
            position >= -1 && position < 0 -> {
                tPivotX = page.width.toFloat()
                degree = rotateDegree * position
            }
            position >= 0 && position < 1 -> {
                tPivotX = 0f
                degree = rotateDegree * position
            }
            else -> {
                tPivotX = 0f
                degree = rotateDegree
            }
        }
        page.apply {
            pivotX = tPivotX
            pivotY = if (rotateDegree < 0) 0f else page.height.toFloat()
            rotation = degree
        }
    }

}