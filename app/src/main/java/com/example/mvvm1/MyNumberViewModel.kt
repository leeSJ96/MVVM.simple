package com.example.mvvm1

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm1.utill.Constans


enum class  ActionType{
    PLUS, MINUS
}
//데이터의 변경
// 뮤모델의 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있고

class MyNumberViewModel : ViewModel() {

    //뮤터블 라이브 데이터 - 수정 가능한
    //라이브 데이터 - 값 변동 안됨

    //
    private val _currentValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
      get() = _currentValue

    init {
        Log.d(Constans.TAG, "MyNumberViewModel - 생성자 호출: ")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input: Int){
        when(actionType) {
            ActionType.PLUS->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }




}