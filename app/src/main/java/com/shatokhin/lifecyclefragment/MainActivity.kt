package com.shatokhin.lifecyclefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity(), SwitchingFragments {
    companion object{
        const val NAME_ACTIVITY = "MainActivity"
    }

    private lateinit var btnCreateOneFragment: Button

    override fun showFragment(tagFragment: String) {

        when(tagFragment){
            OneFragment.TAG -> showOneFragment()
            TwoFragment.TAG -> showTwoFragment()
        }

    }

    private fun showOneFragment(){
        if (supportFragmentManager.fragments.size == 0){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.containerFragment, OneFragment(), OneFragment.TAG)
                .addToBackStack(OneFragment.TAG)
                .commit()
        }
    }

    private fun showTwoFragment(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.containerFragment, TwoFragment(), TwoFragment.TAG)
            .addToBackStack(TwoFragment.TAG)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle = if (savedInstanceState == null) "null" else "Bundle"
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onCreate($bundle)")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateOneFragment = findViewById(R.id.btnCreateOneFragment)
        btnCreateOneFragment.setOnClickListener {
            showFragment(OneFragment.TAG)
        }

    }

    override fun onRestart() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onRestart()")
        super.onRestart()
    }

    override fun onStart() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onStart()")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onRestoreInstanceState(Bundle)")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onResume()")
        super.onResume()
    }
    //====================================================================================
    override fun onPause() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onStop()")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onSaveInstanceState()")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        Log.d(TAG_FOR_LOGCAT, "$NAME_ACTIVITY - onDestroy()")
        super.onDestroy()
    }


}