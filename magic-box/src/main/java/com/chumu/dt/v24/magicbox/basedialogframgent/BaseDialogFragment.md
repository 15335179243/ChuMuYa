# DialogFragment内存泄漏解决方案

![](C:\Users\ASUS\Desktop\ssw\172542-bf69455807784805.webp)

​									**内存泄漏引用链**

上图是DialogFragment泄露的典型路径，引用链根部的HandlerThread可能是app中任何一个HandlerThread。DialogFragment内存泄漏问题覆盖Android全部版本（目前最高版本Q），其泄漏的根源与Dialog有关，也就是说，Dialog导致的内存泄漏同样覆盖了Android全部版本。

（源码参考AOSP android-9.0.0_r34分支）

这边进行源码的修改 [FixDialogFragment](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/androidx/fragment/app/FixDialogFragment.java)

使用可以直接继承[ChuMuBaseDialogFragment](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/basedialogframgent/androidx/ChuMuBaseDialogFragment.java)

也可以继承[ChuMuDialogFragment](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/basedialogframgent/aosp/ChuMuDialogFragment.java)

前者是已经封装好的写布局就可以,后者需要自己写.