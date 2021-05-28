package com.dropink.sampledropdownfirebase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dropink.sampledropdownfirebase.R
import com.dropink.sampledropdownfirebase.databinding.FragmentTimeBinding
import kotlinx.android.synthetic.main.fragment_time.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [TimeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TimeFragment : Fragment()
{
    // Binding
    private lateinit var binding: FragmentTimeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Implement Binding
        binding = FragmentTimeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Implement Auto Text
        val findId = view.time_auto

        val time = resources.getStringArray(R.array.time)
        val adapter = ArrayAdapter(requireContext(), R.layout.string_layout, time)

        findId.setAdapter(adapter)

        // Inflate the layout for this fragment
        return view
    }
}