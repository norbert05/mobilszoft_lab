package com.example.mobsofthw.scenes.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getContentView(): Int

    abstract fun initUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initUi()
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    protected open fun refreshData() {
        //override if needed
    }

    fun showSnack(title: String?) {
        title?.let {
            Snackbar.make(
                findViewById(android.R.id.content),
                title,
                BaseTransientBottomBar.LENGTH_SHORT
            ).show()
        }
    }
}