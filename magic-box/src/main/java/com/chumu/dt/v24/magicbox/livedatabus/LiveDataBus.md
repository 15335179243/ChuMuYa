# ChuMuLiveDataBus

##### 基于LiveData实现事件总线,



##### 具备生命周期感知，感知确保LiveData仅更新处于活动生命周期状态的应用程序组件观察者，

##### 支持粘性，消息发送后订阅也能收到发出的消息，但是只能收到订阅前发送的最后一条消息

### 阅普通事件消息

```
//仅更新处于活动生命周期状态的应用程序组件观察者
ChuMuLiveDataBus.with("tag")
                .observe(this, Observer {
                    toast("收到普通事件消息：${it.toString()}")
                })

//不受生命周期的影响，只要数据更新就会收到通知
ChuMuLiveDataBus.with("tag")
                .observeForever(this, Observer {
                    toast("收到普通事件消息：${it.toString()}")
                })
```

### 发送普通事件消息

```
 ChuMuLiveDataBus.send("tag", "发送一条消息")
```

## 订阅粘性事件消息

```
//仅更新处于活动生命周期状态的应用程序组件观察者
ChuMuLiveDataBus.withStickiness("tag")
                .observe(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })

//不受生命周期的影响，只要数据更新就会收到通知
ChuMuLiveDataBus.withStickiness("tag")
                .observeForever(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })
```

### 发送粘性事件消息

```
 ChuMuLiveDataBus.sendStickiness("tag", "发送一条消息")
```