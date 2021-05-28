package com.dropink.sampledropdownfirebase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dropink.sampledropdownfirebase.R
import com.dropink.sampledropdownfirebase.databinding.FragmentDateBinding
import kotlinx.android.synthetic.main.fragment_date.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [DateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DateFragment : Fragment()
{
    // Binding
    private lateinit var binding: FragmentDateBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Implement Binding
        binding = FragmentDateBinding.inflate(inflater, container, false)
        val view = binding.root

        // Implement Auto Text
        val findId = view.date_auto

        val date = resources.getStringArray(R.array.date)
        val adapter = ArrayAdapter(requireContext(), R.layout.string_layout, date)

        findId.setAdapter(adapter)

        // Inflate the layout for this fragment
        return view
    }
}