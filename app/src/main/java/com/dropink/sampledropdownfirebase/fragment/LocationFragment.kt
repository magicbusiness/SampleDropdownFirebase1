package com.dropink.sampledropdownfirebase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dropink.sampledropdownfirebase.R
import com.dropink.sampledropdownfirebase.databinding.FragmentLocationBinding
import kotlinx.android.synthetic.main.fragment_location.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment()
{
    // Binding
    private lateinit var binding: FragmentLocationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Implement Binding
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        val view = binding.root

        // Implement Auto text
        val findId = view.location_auto

        val location = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(requireContext(), R.layout.string_layout, location)

        findId.setAdapter(adapter)

        // Inflate the layout for this fragment
        return view
    }
}