package com.example.merchandise.ui.diagram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.merchandise.MainActivity
import com.example.merchandise.databinding.FragmentDiagramBinding

class   DiagramFragment : Fragment() {

    private var _binding: FragmentDiagramBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val diagramViewModel =
            ViewModelProvider(this).get(DiagramViewModel::class.java)

        _binding = FragmentDiagramBinding.inflate(inflater, container, false)
        return DiagramChart(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun openNavView(){
        val activity = requireActivity()
        if (activity is MainActivity){
            activity.openNavigationView()
        }
    }
    private fun initButtons(){
        binding.apply {
            btnGamburger.setOnClickListener {
                openNavView()
            }
        }
    }
}