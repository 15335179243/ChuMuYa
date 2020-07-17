
# 百宝箱(在这里找到您想要的)
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


## 正则表达式 → [ChuMuAppValidationManager](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuAppValidationManager.java)

```
isEmpty              : 验证是否为空串 (包括空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串,返回true)
isNotEmpty           : 是否不为空
isNotZero            : 验证非零正整数
isNumber             : 验证是数字
isUpChar             : 验证是大写字母
isLowChar            : 验证是小写字母
isLetter             : 验证是英文字母
isChinese            : 验证输入汉字
isRealName           : 验证真实姓名
isOneCode            : 验证是否是条形码
isEmail              : 验证邮箱是否正确
isPhone              : 验证手机号是否正确
isPlane              : 验证座机号码是否正确
isPostalCode         : 验证邮政编码是否正确
isIpAddress          : 验证IP地址是否正确
isURL                : 验证URL地址是否正确
isInteger            : 验证是否是正整数
isPoint              : 验证是否是小数
isBankNo             : 验证是否银行卡号
isIDCard             : 验证身份证号码是否正确
isPeculiarStr        : 判断是否有特殊字符
isUserName           : 判断是否为用户名账号(规则如下：用户名由下划线或字母开头，由数字、字母、下划线、点、减号组成的4-32位字符)
chineseLength        : 获取字符串中文字符的长度（每个中文算2个字符）
strLength            : 获取字符串的长度
subStringLength      : 获取指定长度的字符所在位置
isNumberLetter       : 是否只是字母和数字
isContainChinese     : 是否包含中文
convertStreamToString: 从输入流中获得String
cutString            : 截取字符串到指定字节长度
cutStringFromChar    : 截取字符串从第一个指定字符
strlen               : 获取字节长度
getSizeDesc          : 获取大小的描述
ip2int               : ip地址转换为10进制数
gainUUID             : 获取UUID
phoneNoHide          : 手机号码，中间4位星号替换
cardIdHide           : 银行卡号，保留最后4位，其他星号替换
idHide               : 身份证号，中间10位星号替换
checkVehicleNo       : 是否为车牌号（沪A88888）
isContinuousNum      : 判断字符串是否为连续数字 45678901等
isAlphaBetaString    : 是否是纯字母
isContinuousWord     : 判断字符串是否为连续字母 xyZaBcd等
isRealDate           : 是否是日期 20120506 共八位，前四位-年，中间两位-月，最后两位-日
```

## 

## 日期管理类 → [ChuMuAppDateMange](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuAppDateMange.java)

```
todayYyyyMmDd           : 当天的年月日
todayHhMmSs             : 当天的时分秒
todayYyyyMmDdHhMmSs     : 当天的年月日时分秒
parseYyyy               : 获取年
parseMm                 : 获取月
parseDd                 : 获取日
parseYyyyMmDd           : 获取年月日
parseHhMmSs             : 时分秒
getWeekNumber           : 获取星期几
getWeekOfMonth          : 日期中某个月份的第几周
getWeekOfYear           : 日期中某个年份的第几周
dateTimeToTimeStamp     : 将年月日时分秒转成Long类型
timeStampToDateTime     : 将Long类型转成年月日时分秒
string2Date             : 将年月日时分秒转成Date类型
date2String             : 将Date类型转成年月日时分秒
dateIsBefore            : 比较日期
minutesBetweenTwoDate   : 相差多少分钟
getChineseZodiac        : 获取日期中的生肖
getZodiac               : 获取日期中的星座
getNowDayOffset         : 获取日期
getTime                 : 获取日期
forward                 : 使日期倒一天
isLeapYear              : 判断平年闰年
getDaysOfMonth          : 计算某月的天数
secondsMorning          : 获取当天凌晨的秒数
secondsNight            : 获取第二天凌晨的秒数
isSameDay               : 判断某两天是不是同一天
formatFriendly          : 将日期格式化成友好的字符串：几分钟前、几小时前、几天前、几月前、几年前、刚刚
formatDateTime          : 将日期以yyyy-MM-dd HH:mm:ss格式化
formatDateTime          : 将日期以yyyy-MM-dd HH:mm:ss格式化
formatDateTime          : 将日期以yyyy-MM-dd HH:mm:ss格式化
parseDate               : 将日期字符串转成日期
gainCurrentDate         : 获取系统当前日期
compareDate             : 验证日期是否比当前日期早
addDateTime             : 对日期进行增加操作
subDateTime             : 对日期进行相减操作
formatDateForExcelDate  : 格式化excel中的时间
formatDateForFileName   : 将日期格式化作为文件名
formatDateSecond        : 格式化日期(精确到秒)
tempDateSecond          : 格式化日期(精确到秒)
tempDateSecond          : 格式化日期(精确到秒)
formatDateDay           : 格式化日期(精确到天)
formatDateDetailDay     : 式化日期(精确到天)
formatNumber            : double类型的数字保留两位小数（四舍五入）
formateDate             : 将字符串转换成日期
parseStringToDate       : 将字符日期转换成Date
formatDoubleNumber      : 将double日期转换成String
getTimeMillis           : 获得指定Date类型的毫秒数
getCurrentDayTimeMillis : 获得当前时间的毫秒数
convertMillisecond      : 将格式化过的时间串转换成毫秒
getDateInterval         : 得到两个日期的天数
compareTime             : 时间比较
```
## 屏幕显示相关 → [ChuMuDisplayUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/ChuMuDisplayUtils.java)

```
getStatusBarHeight    :  获取状态栏高度
isNavigationBarShow   :  虚拟操作拦（home等）是否显示
getNavigationBarHeight:  获取虚拟操作拦（home等）高度
getDpi				  :  获取屏幕密度相关dpi
getDensity			  :  获取屏幕密度
sp2px				  :  sp转px
px2sp				  :  px转sp
px2dp				  :  px转dp
dp2px				  :  dp转px
getScreenWidth        :  获取屏幕宽度
getScreenHeight       :  获取屏幕高度以
getScreenWidthDp      :  获取屏幕宽度以dp返回
getScreenHeightDp     :  获取屏幕高度以dp返回

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


## AES对称加密 → [ChuMuAESUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuAESUtils.java)

```
initKey ： 生成密钥
encrypt ： 加密
decrypt ： 解密
```

## DES对称加密 → [ChuMuDESUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuDESUtils.java)

```
initKey : 生成密钥
encrypt : DES 加密
decrypt : DES 解密
```

## MD5加密 → [ChuMuMD5Utils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuMD5Utils.java)

```
encryptMD5 : MD5加密
```

## SHA-1加密不可逆 → [ChuMuSHAUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuSHAUtils.java)

```
encryptSHA : SHA-512 加密
```

## 3DES对称加密 → [ChuMuTripleDESUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuTripleDESUtils.java)

```
initKey : 生成密钥
encrypt : 3DES 加密
decrypt : 3DES 解密
```

## 加密工具类 → [ChuMuCipherUtils](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/encryption/ChuMuCipherUtils.java)

```
md5 : 输入流转md5
XorEncode : 异或加密
XorDecode : 异或解密
sha1 : 字符串sha1值
```

