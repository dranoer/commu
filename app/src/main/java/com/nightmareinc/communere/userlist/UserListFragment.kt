package com.nightmareinc.communere.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.nightmareinc.communere.R
import com.nightmareinc.communere.database.UserDatabase
import com.nightmareinc.communere.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentUserListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_user_list, container, false)

        val application = requireNotNull(this.activity).application

        val arguments = UserListFragmentArgs.fromBundle(arguments!!)

        val dataSource = UserDatabase.getInstance(application).userDatabaseDao

        val viewModelFactory = UserListViewModelFactory(arguments.userEvent, dataSource)

        val userListViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserListViewModel::class.java)

        binding.userListViewModel = userListViewModel
        binding.lifecycleOwner = this


        return binding.root
    }

}