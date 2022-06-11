package com.example.tenis.ui.tenis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tenis.R
import com.example.tenis.databinding.FragmentAddTenisBinding
import com.example.tenis.model.Tenis
import com.example.tenis.viewmodel.TenisViewModel


class AddTenisFragment : Fragment() {
    private var _binding: FragmentAddTenisBinding? = null
    private val binding get() = _binding!!

    private lateinit var tenisViewModel: TenisViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tenisViewModel =
            ViewModelProvider(this).get(TenisViewModel::class.java)

        _binding = FragmentAddTenisBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener{
            addTenis()
        }

        return binding.root
    }

    private fun addTenis() {
        val marca = binding.etMarca.text.toString()
        val modelo = binding.etModelo.text.toString()
        val talla = binding.etTalla.text.toString()
        val precio = binding.etPrecio.text.toString()

        if(marca.isNotEmpty()){
            val tenis= Tenis(0,marca,modelo,talla,precio,"")
            tenisViewModel.addTenis(tenis)
            Toast.makeText(requireContext(),getString(R.string.msg_tenis_added), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTenisFragment_to_nav_tenis)
        }else{ //Mensaje de error...
            Toast.makeText(requireContext(),getString(R.string.msg_data), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}