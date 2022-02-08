package com.example.teht9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teht9.MemberOfParliament.ParliamentMembersData.members

class ViewModelMain : ViewModel() {
    var currentName: MutableLiveData<String> = MutableLiveData()
    private set


    var oneMember = members.map {
        it.first + " " + it.last + " - " + it.party + "\n" +
                it.constituency + "\n" + if (it.twitter != "") "Twitter account: ${it.twitter}" else "no twitter account"
    }.toMutableList()


    var i = 0
    fun currentPolitician(): String {
       currentName.value = oneMember[i]
        return currentName.value.toString()
    }
    fun updatedPolitician(): String {
        i++
       currentName.value = oneMember[i]
        return currentName.value.toString()
    }

}