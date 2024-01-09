package kh.edu.rupp.ite.perfume_shop.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kh.edu.rupp.ite.perfume_shop.databinding.FragementProfileBinding
import kh.edu.rupp.ite.perfume_shop.view.activity.MainActivity
import kh.edu.rupp.ite.perfume_shop.viewmodel.ProfileViewModel


class ProfileFragment : Fragment() {

    private lateinit var binding: FragementProfileBinding
    private var viewModel = ProfileViewModel()
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragementProfileBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetchProfileData()

        viewModel.profileData.observe(viewLifecycleOwner, Observer { profile ->
            if (profile != null) {
                binding.txtUsername.text = profile.username
                binding.txtEmail.text = profile.email

            } else {
                //
            }
        })
    }
}