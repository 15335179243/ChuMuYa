# ChuMuYa
https://github.com/15335179243/Chumucode-v24.git
This is Chumu's code base. Welcome to this place. It's a great honor to serve you. What suggestions can you leave a message or add QQ: 1970874029 for communication.


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
        implementation 'com.github.15335179243:ChuMuYa:v11-1.0.0'
}
```
## usag
## 

```java
//初始化你的动态权限(Initialize your dynamic permissions)
                String[] str = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, INTERNET};
                //调用本库方法(Call the library method)
                DynamicPermissions dynamicPermissions = new DynamicPermissions(MainActivity.this, str);
               //判断有没有权限,没有的话让他获取(Determine whether there is access, if not let him get)
                if (!dynamicPermissions.isFlag()) {
                    Log.d(TAG, "onOptionsItemSelected: " + "1");
                    dynamicPermissions.init();
                } else {
                    Log.d(TAG, "onOptionsItemSelected: " + "1");
                }
```
