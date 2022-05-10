package com.shatokhin.lifecyclefragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class OneFragment : Fragment() {
    companion object{
        const val TAG = "OneFragment"
    }

    lateinit var btnCreateTwoFragment: Button
    //region CREATED
    override fun onAttach(context: Context) {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onAttach()")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle = if (savedInstanceState == null) "null" else "Bundle"
        Log.d(TAG_FOR_LOGCAT, "$TAG - onCreate($bundle)")
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = if (savedInstanceState == null) "null" else "Bundle"
        Log.d(TAG_FOR_LOGCAT, "$TAG - onCreateView($bundle)")
        return inflater.inflate(R.layout.fragment_one, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onViewCreated()")
        btnCreateTwoFragment = view.findViewById(R.id.btnCreateTwoFragment)

        val activity = activity
        activity?.let {
            btnCreateTwoFragment.setOnClickListener {
                if (activity is SwitchingFragments){
                    activity.showFragment(TwoFragment.TAG)
                }
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        val bundle = if (savedInstanceState == null) "null" else "Bundle"
        Log.d(TAG_FOR_LOGCAT, "$TAG - onViewStateRestored($bundle)")
        super.onViewStateRestored(savedInstanceState)

    }

    //endregion

    //region STARTED
    override fun onStart() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onStart()")
        super.onStart()
    }
    //endregion

    //region RESUMED
    override fun onResume() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onResume()")
        super.onResume()
    }
    //endregion

    //region STARTED
    override fun onPause() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onPause()")
        super.onPause()
    }
    //endregion

    //region CREATED
    override fun onStop() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onStop()")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onSaveInstanceState()")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onDestroyView()")
        super.onDestroyView()
    }
    //endregion

    //region DESTROYED
    override fun onDestroy() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onDestroy()")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG_FOR_LOGCAT, "$TAG - onDetach()")
        super.onDetach()
    }
}