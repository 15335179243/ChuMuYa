package com.chumu.dt.v24.magicbox.livedatabus.event
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import java.util.*

/**
 * 普通事件
 */
class ChuMuDefaultChuMuEvent(
        private val liveDataMap: HashMap<String, MutableLiveData<Any?>>,
        private val tag: String
) : ChuMuEvent {


    override fun observe(activity: ComponentActivity, observer: Observer<Any?>) {
        subscribe(activity, observer)
    }

    override fun observe(fragment: Fragment, observer: Observer<Any?>) {
        subscribe(fragment, observer)
    }

    override fun observeForever(activity: ComponentActivity, observer: Observer<Any?>) {
        subscribeForever(activity, observer)
    }

    override fun observeForever(fragment: Fragment, observer: Observer<Any?>) {
        subscribeForever(fragment, observer)
    }

    private fun subscribe(owner: LifecycleOwner, observer: Observer<Any?>) {
        liveDataMap[tag] = MutableLiveData()
        liveDataMap[tag]?.observe(owner, Observer { o ->
            observer.onChanged(o)
        })
    }

    private fun subscribeForever(owner: LifecycleOwner, observer: Observer<Any?>) {
        liveDataMap[tag] = MutableLiveData()

        val mObserver= Observer<Any?> {o ->
            observer.onChanged(o)
        }

        liveDataMap[tag]?.observeForever(mObserver)

        //onDestroy时解绑
        owner.lifecycle.addObserver(object : LifecycleObserver{
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                liveDataMap[tag]?.removeObserver(mObserver)
            }
        })
    }

}