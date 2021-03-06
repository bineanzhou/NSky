package com.nsky.app.viewmodel

import android.app.Application
import com.qihoo.adwallet.common.viewmodel.CoreViewModel

/**
 * Created by zhoubin on 2019/1/28.
 **/
class MainViewModel(application: Application) : CoreViewModel(application),IMainViewModel {
    override fun doSomething(): String {
        return "This is MainViewModel"
    }
}
interface IMainViewModel{
    abstract fun doSomething(): String
}