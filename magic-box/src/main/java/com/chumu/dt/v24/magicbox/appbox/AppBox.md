
#百宝箱(在这里找到您想要的)
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