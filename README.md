# ChuMuYa
This is Chumu's code base. Welcome to this place. It's a great honor to serve you. What suggestions can you leave a message or add QQ: 1970874029 for communication.
## My CSDN
https://blog.csdn.net/qq_44729989

Add it in your root build.gradle at the end of repositories:

```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```java
dependencies {
	
        implementation 'com.github.15335179243:ChuMuYa:v11-2.0.0-beta'
}
```
## usag
## 

```java
//初始化你的动态权限(Initialize your dynamic permissions)
                String[] str = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, INTERNET};
                //调用本库方法(Call the library method)
                ChuMuDynamicPermissions dynamicPermissions = new  ChuMuDynamicPermissions(MainActivity.this, str);
               //判断有没有权限,没有的话让他获取(Determine whether there is access, if not let him get)
                if (!dynamicPermissions.isFlag()) {
                    Log.d(TAG, "onOptionsItemSelected: " + "1");
                    dynamicPermissions.init();
                } else {
                    Log.d(TAG, "onOptionsItemSelected: " + "1");
		    //你想要进行的操作
                }
```

### v11-1.0.4更新

**添加粘性头布局和流势布局还有随机颜色**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173728256.gif)
由于为了大家的开发效率着想,我把这个已经打包成了依赖,大家只需要导我第三方依赖

#### 集成方式:
注入依赖 Step 1. Add the JitPack repository to your build file Step 2. Add the dependency

```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency
```java


dependencies {
        implementation 'com.github.15335179243:ChuMuYa:v11-1.0.8'
}
```
## 粘性头布局:
#### Activity里面集成代码:

 - **分组头部**


```java
ChuMuNormalDecoration decoration = new ChuMuNormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return //返回每个分组头部名称;
            }
        };
```

 - **自定义头部/悬浮头部layout【自定义头部加载图片请用 loadImage() 方法】**


```java
    decoration.setOnDecorationHeadDraw(new ChuMuNormalDecoration.OnDecorationHeadDraw() {
           @Override
           public View getHeaderView(int pos) {
               return //返回自定义头部view;
           }
       });
```
 - **头部点击事件**

```java
decoration.setOnHeaderClickListener(new ChuMuNormalDecoration.OnHeaderClickListener() {
         @Override
         public void headerClick(int pos) {
         }
     });
```
**注:**
GridLayoutManager请配合GridDecoration使用。
###### 方法及属性介绍

------

| name                  | format                   | 中文解释                                                 |
| --------------------- | ------------------------ | -------------------------------------------------------- |
| setHeaderHeight       | integer                  | 分组头部高度                                             |
| setTextPaddingLeft    | integer                  | 普通分组头部【只含文字】文字左边距                       |
| setTextSize           | integer                  | 普通分组头部【只含文字】文字大小                         |
| setTextColor          | integer                  | 普通分组头部【只含文字】文字颜色                         |
| setHeaderContentColor | integer                  | 普通分组头部【只含文字】文字背景颜色                     |
| onDestory             |                          | 清空数据集合/监听等                                      |
| *loadImage            | String,integer,ImageView | 用来加载并刷新图片到分组头部【自定义头部很重要的方法！】 |
## 流势布局
效果上如图,如果内容过长,流式布局可以实现自动换行
1.使用

```java
<com.chumu.dt.v24.permissions.wiget.ChuMuFlowLayout
    android:id="@+id/flow"
    android:paddingTop="12dp"
    android:paddingBottom="12dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

```java
for (int i = 0; i < list.size(); i++) {
                //获取视图,视图可以自定义,可以添加自己想要的效果
                TextView label = (TextView) View.inflate(mContext, R.layout.item_label, null);
                //获取数据
                final String data = list.get(i);
                //绑定数据
                label.setText(data);
                label.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast(data);
                    }
                });
                //加到容器中,parent是FlowLayout
                parent.addView(label);
            }

```
为了方便大家的集成下面的代码我已经写到了源码里面,大家可以进去源码拷贝
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622181850718.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0NzI5OTg5,size_16,color_FFFFFF,t_70)

### 五彩斑斓的字体我打包在依赖里面了代码如下:

```java
//大家只需要调用依赖里面的一个随机颜色的方法就可以了
TextView tv;
tv.setsetTextColor(ChuMuRandomColor.onRandomCOlor());
```

详情这边有csdn博客:https://blog.csdn.net/qq_44729989/article/details/93343258



# v11-2.0.0更新



## ChuMuLiveDataBus

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



## ChuMuSharePreference缓存数据 → [ChuMuAppSharePreferenceManage](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/ChuMuFramgentManage.java)

```
put     : 保存数据的方法
get     : 获取数据的方法
putImage: 保存图片到SharedPreferences
getImage: 从SharedPreferences读取图片
remove  : 移除某个key值已经对应的值
clear   : 清除所有数据
contains: 查询某个key是否已经存在
getAll  : 返回所有的键值对
putObject : 保存继承Serializable对象方法
putObject2: 保存继承Parcelable对象方法
getObject : 获取继承Serializable对象方法
getObject2: 获取继承Parcelable对象方法
putStringList:保存String集合方法
getStringList:获取String集合方法
putMap:保存map集合(K和V都必须继承Serializable)
getMap:获取map集合
putSerializableList:保存继承Serializable集合方法
getSerializableList:获取继承Serializable集合方法
putParcelableList  :保存继承Parcelable集合方法
getParcelableList  :获取继承Parcelable集合方法

```



## 提供App数据清理工作的类 → [ChuMuAppCleanManage](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuAppCleanManage.java)

```
cleanInternalCache   ： 清除本应用内部缓存数据
cleanExternalCache   ： 清除本应用外部缓存数据
cleanDatabases       ： 清除本应用所有数据库
cleanSharedPreference： 清除本应用SharedPreference
cleanDatabaseByName  ： 根据名字清除本应用数据库
cleanFiles           ： 清除本应用files文件
cleanApplicationData ： 清除本应用所有的数据
getAppClearSize      ： 获取App应用缓存的大小
```



## 缓存工具类 → [ChuMuAppACache](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuAppACache.java)

```
put             : 保存String数据到缓存中
getAsString     : 读取String数据
getAsJSONObject : 读取JSONObject数据
getAsJSONArray  : 读取JSONArray数据
getAsBinary     : 获取byte数据
getAsObject     : 读取Serializable数据
getAsBitmap     : 读取bitmap数据
getAsDrawable   : 读取Drawable数据
file            : 获取缓存文件
remove          : 除某个key
clear           : 清除所有数据
```





## 获取App应用版本信息 → [ChuMuAppApplicationManage](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuAppApplicationManage.java)

```
getAppName             : 获取本地apk的名称
getVersionName         : 获取本地Apk版本名称
getVersionCode         : 获取本地Apk版本号
getMetaData            : 根据key获取xml中Meta的值
getAppIcon             : 获取应用图标
getAppFirstInstallTime : 获取应用第一次安装日期
getAppLastUpdateTime   : 获取应用更新日期
getAppSize             : 获取应用大小
getAppApk              : 获取应用apk文件
getAppInstaller        : 获取应用的安装市场
getAppSign             : 获取应用签名
getAppTargetSdkVersion : 获取应用兼容sdk
getAppUid              : 获取应用uid
getNumCores            : 获取Cpu内核数
getRootPermission      : 获得root权限
getAppPermissions      : 获取应用的所有权限
hasPermission          : 是否有权限
isInstalled            : 应用是否安装
installApk             : 安装应用
uninstallApk           : 卸载应用
isSystemApp            : 是否是系统应用
isServiceRunning       : 服务是否在运行
stopRunningService     : 停止服务
killProcesses          : 结束进程
runScript              : 运行脚本
runApp                 : 启动应用
getPackageName         : 获得包名
getApplicationMetaData : 获取application层级的metadata
```



## 压缩工具类 → [ChuMuZipUtil](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/ChuMuZipUtil.java)

```
zipFiles              : 批量压缩文件（夹）
upZipFile             : 解压缩一个文件
upZipSelectedFile     : 解压文件名包含传入文字的文件
getEntriesNames       : 获得压缩文件内文件列表
getEntriesEnumeration : 获得压缩文件内压缩文件对象以取得其属性
getEntryComment       : 取得压缩文件对象的注释
getEntryName          : 取得压缩文件对象的名称
zipFile               : 压缩文件
```



