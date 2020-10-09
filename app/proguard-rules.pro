# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-optimizationpasses 5
# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers
# 指定混淆是采用的算法
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
# 指定外部模糊字典 proguard-chinese.txt 改为混淆文件名，下同
-obfuscationdictionary proguard-socialism.txt
# 指定class模糊字典
-classobfuscationdictionary proguard-socialism.txt
# 指定package模糊字典
-packageobfuscationdictionary proguard-socialism.txt


-optimizationpasses 5   # 设置混淆的压缩比率 0 ~ 7
-dontusemixedcaseclassnames  # 混淆时不使用大小写混合，混淆后的类名为小写
-dontskipnonpubliclibraryclasses # 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclassmembers # 指定不去忽略非公共库的成员
-dontpreverify          # 混淆时不做预校验
-verbose                # 混淆时不记录日志
-ignorewarning          # 忽略警告
-dontshrink             # 代码优化
-dontoptimize           # 不优化输入的类文件
-keepattributes Signature       # 避免混淆泛型
-keepattributes SourceFile,LineNumberTable  # 保留

#Android 的注释不能混淆
 -keepattributes *Annotation*
-keep class com.chumu.dt.v24.magicbox.** { **; }
-keep class com.chumu.dt.v24.magicbox.** { *; }
-keep class com.chumu.dt.v24.magicbox.** {  public *;
 }
 -keep class androidx.fragment.app.FixDialogFragment { **; }
-keep class androidx.fragment.app.FixDialogFragment { *; }

 -keep class androidx.fragment.app.FixDialogFragment {  public *;
 }
-keepclassmembers class com.chumu.dt.v24.magicbox.** { *; }
-dontwarn com.chumu.dt.v24.magicbox.**
-keep public class * extends android.app.Activity
-keep class * implements Android.os.Parcelable { # 保持Parcelable不被混淆
    public static final Android.os.Parcelable$Creator *;
}