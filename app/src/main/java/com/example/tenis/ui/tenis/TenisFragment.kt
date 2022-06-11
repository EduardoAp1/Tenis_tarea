package com.example.tenis.ui.tenis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenis.R
import com.example.tenis.adapter.TenisAdapter
import com.example.tenis.databinding.FragmentTenisBinding
import com.example.tenis.viewmodel.TenisViewModel

class TenisFragment : Fragment() {

    private var _binding: FragmentTenisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tenisViewModel =
            ViewModelProvider(this).get(TenisViewModel::class.java)

        _binding = FragmentTenisBinding.inflate(inflater, container, false)

        binding.addTenis.setOnClickListener{
            findNavController().navigate(R.id.action_nav_tenis_to_addTenisFragment)
        }

        //ACTIVAR EL RECICLADOR..
        val tenisAdapter = TenisAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter =  tenisAdapter
        reciclador.layoutManager =  LinearLayoutManager(requireContext())
        tenisViewModel.getAllData.observe(viewLifecycleOwner){
            tenisAdapter.setData(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}