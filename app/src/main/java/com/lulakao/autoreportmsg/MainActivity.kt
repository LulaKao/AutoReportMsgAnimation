package com.lulakao.autoreportmsg

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.lulakao.autoreportmsg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        context = this

        binding.btnStart.setOnClickListener { showMsgLayout() }
    }

    private fun showMsgLayout() {
        /** method 1 */
//        // set Animation
//        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim)
//        animation.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationRepeat(p0: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(p0: Animation?) {
//                binding.msgLayout.visibility = View.GONE
//            }
//
//            override fun onAnimationStart(p0: Animation?) {
//                binding.msgLayout.visibility = View.VISIBLE
//            }
//        })
//        // start Animation
//        binding.msgLayout.startAnimation(animation)

        /** method 2 */
        // set Animation
        val animStart = AnimationUtils.loadAnimation(context, R.anim.alpha_show)
        animStart.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                hideMsgLayout()
            }

            override fun onAnimationStart(p0: Animation?) {
                binding.msgLayout.visibility = View.VISIBLE
            }
        })
        // start Animation
        binding.msgLayout.startAnimation(animStart)
    }

    private fun hideMsgLayout() {
        // set Animation
        val animEnd = AnimationUtils.loadAnimation(context, R.anim.alpha_hide)
        animEnd.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.msgLayout.visibility = View.GONE
            }

            override fun onAnimationStart(p0: Animation?) {

            }
        })
        // start Animation
        binding.msgLayout.startAnimation(animEnd)
    }
}