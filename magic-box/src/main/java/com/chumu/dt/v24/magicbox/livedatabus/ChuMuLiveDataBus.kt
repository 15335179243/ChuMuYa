
package com.chumu.dt.v24.magicbox.livedatabus

import androidx.lifecycle.MutableLiveData
import com.chumu.dt.v24.magicbox.livedatabus.event.ChuMuDefaultChuMuEvent
import com.chumu.dt.v24.magicbox.livedatabus.event.ChuMuEvent
import com.chumu.dt.v24.magicbox.livedatabus.event.ChuMuStickinessEvent


import java.util.*

/**
 * @Author: ChuMU
 * @CreateDate: 2019/10/12 17:26
 * @Description: 事件消息总线
 * liveDataBus替换EventBus使用
 */
object ChuMuLiveDataBus {

    private val liveDataMap = HashMap<String, MutableLiveData<Any?>>()

    /**
     * 关联一个普通事件消息，需要关联后才能收到发送的消息
     * @param tag 事件标识
     */
    fun with(tag: Int): ChuMuEvent {
        return with(tag.toString())
    }

    /**
     * 关联一个普通事件消息，需要关联后才能收到发送的消息
     * @param tag 事件标识
     */
    fun with(tag: String): ChuMuEvent {
        return ChuMuDefaultChuMuEvent(liveDataMap, tag)
    }

    /**
     * 关联一个粘性事件消息，可以收到关联之前发送的消息
     */
    fun withStickiness(tag: Int): ChuMuEvent {
        return withStickiness(tag.toString())
    }

    /**
     * 关联一个粘性事件消息，可以收到关联之前发送的消息
     */
    fun withStickiness(tag: String): ChuMuEvent {
        return ChuMuStickinessEvent(liveDataMap, tag)
    }

    /**
     * 发送一个普通事件消息
     * @param tag 事件标识
     * @param t 事件内容
     */
    fun send(tag: Int, t: Any? = null) {
        send(tag.toString(), t)
    }

    /**
     * 发送一个普通事件消息
     * @param tag 事件标识
     * @param t 事件内容
     */
    fun send(tag: String, t: Any? = null) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) return
        liveDataMap[tag]?.postValue(t)
    }


    /**
     * 发送多个普通事件消息
     * @param tags 事件标识集合
     * @param datas 事件内容
     */
    fun send1(tags: List<Int>, datas: List<Any>) {
        for (i in 0..tags.size) {
            send(tags[i], datas[i])
        }
    }

    /**
     * 发送一个粘性事件消息
     *  @param tag 事件标识
     *  @param t 事件内容
     */
    fun sendStickiness(tag: Int, t: Any? = null) {
        return sendStickiness(tag.toString(), t)
    }

    /**
     * 发送一个粘性事件消息
     */
    fun sendStickiness(tag: String, t: Any? = null) {
        if (!liveDataMap.containsKey(tag) || liveDataMap[tag] == null) {
            liveDataMap.put(tag, MutableLiveData())
        }
        liveDataMap[tag]?.postValue(t)
    }

}