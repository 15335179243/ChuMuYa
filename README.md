# ChuMuYa

This is Chumu's code base. Welcome to this place. It's a great honor to serve you. What suggestions can you leave a message or add QQ: 1970874029 for communication.

#### 最近新开了一个团队，本项目以后就进行团队维护了，但每次发板的，还是由这边先发，需要抢先体验的就看这边，需要稳定版本的可以→[点击查看](https://github.com/ChuMuYa/ChuMuYa)

​                                                          [![](https://img.shields.io/badge/CSDN-%E6%A5%9A%E6%9C%A8-green)](https://blog.csdn.net/qq_44729989)        [![](https://img.shields.io/badge/jitpack-2.0.5--beta-orange)](https://github.com/15335179243/ChuMuYa/releases/tag/v11-2.0.6-beta)			[ ![Download](https://api.bintray.com/packages/1970874029/ChuMuMagicBox/ChuMuMagicBox/images/download.svg?version=v11-2.0.0) ](https://bintray.com/1970874029/ChuMuMagicBox/ChuMuMagicBox/v11-2.0.0/link)


### 最新更新[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/README.md#v11-203%E6%9B%B4%E6%96%B0)

### maven

```java
dependencies {

    implementation 'com.chumu.magic-box:ChuMuMagicBox:v11-2.0.0'
}
```

#### or say 

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

        implementation 'com.github.15335179243:ChuMuYa:v11-2.0.6-beta'
}
```



## 集成方式
```java
//在你的Application里面初始化函数
   ChuMuAppUtils.init(context);
```

## 动态权限  usag 这边给大家简单演示一下具体使用请看代码

```java
//初始化你的动态权限(Initialize your dynamic permissions)
        String[] str = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, INTERNET,ACCESS_WIFI_STATE,MOUNT_FORMAT_FILESYSTEMS};
        //调用本库方法(Call the library method)
        if (ChuMuDynamicPermissions.getInstance().setPermissions(this,str)) {
            //权限申请成功
        }else {
            //权限被拒绝
        }
```

### v11-1.0.4更新

**添加粘性头布局和流势布局还有随机颜色**  → [点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md)

# v11-2.0.0更新
## 可以替换EventBus的一款通信框架(基于LiveData实现事件总线)→[ChuMuLiveDataBus](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/livedatabus/LiveDataBus.md)

#####

## 工具百宝箱(找到你想要的) → [点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/AppBox.md)

#####
# v11-2.0.1更新


## ChuMuDialogFragment(对官方DialogFragment内存泄漏问题进行解决) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/basedialogframgent/BaseDialogFragment.md)


# v11-2.0.2更新


## ChuMuDynamicPermissions(对其进行修改维护，待测试实用性) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/ChuMuSharedPreferences.java)
1. 增加自定义权限弹窗样式
2. 增加支持设定弹窗内容以及确认取消文案


## ChuMuTextManager(对textView样式进行负责的编辑，如html的样式) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuTextManager.java)
### [使用查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/AppBox.md)



## ChuMuPhotoManager(相机相册裁剪工具类) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuPhotoManager.java)



## ChuMuTimeRefresher(时间刷新器，方便进行定时请求，或者定时做某些事情) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuTimeRefresher.java)


# v11-2.0.3更新

## ChuMuSwipeBack(增加侧滑返回) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/swipeback/SwipeBack.md)

## ChuMuPermission和ChuMuPermissionTools(动态权限获取框架) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/AppBox.md#获取动态权限工具类--ChuMuPermission)



# v11-2.0.4更新

## 修复混淆带来的bug，包括一些已知的bug

# v11-2.0.5更新

## 增加自定义控件 旋转木马ChuMuCarouseView →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md#ChuMuCarouseView-点击查看)
**（解决类似于公告滚动字体类活动）**

### 开源协议许可证
```css
 Copyright [ChuMuYa] [name of copyright owner]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```


