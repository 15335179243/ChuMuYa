# ChuMuYa

This is Chumu's code base. Welcome to this place. It's a great honor to serve you. What suggestions can you leave a message or add QQ: 1970874029 for communication.



​                                                          [![](https://img.shields.io/badge/CSDN-%E6%A5%9A%E6%9C%A8-green)](https://blog.csdn.net/qq_44729989)        [![](https://img.shields.io/badge/jitpack-2.0.4--beta-orange)](https://github.com/15335179243/ChuMuYa/releases/tag/v11-2.0.4-beta)			[ ![Download](https://api.bintray.com/packages/1970874029/ChuMuMagicBox/ChuMuMagicBox/images/download.svg?version=v11-2.0.0) ](https://bintray.com/1970874029/ChuMuMagicBox/ChuMuMagicBox/v11-2.0.0/link)
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

        implementation 'com.github.15335179243:ChuMuYa:v11-2.0.4-beta'
}
```

## usag


##

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

**添加粘性头布局和流势布局还有随机颜色**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173728256.gif)
由于为了大家的开发效率着想,我把这个已经打包成了依赖,大家只需要导我第三方依赖

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



## 可以替换EventBus的一款通信框架(基于LiveData实现事件总线)→[ChuMuLiveDataBus](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/livedatabus/LiveDataBus.md)

#####

## 工具百宝箱(找到你想要的) → [点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/appbox/AppBox.md)

#####
# v11-2.0.1更新


## ChuMuDialogFragment(对官方DialogFragment内存泄漏问题进行解决) →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/basedialogframgent/BaseDialogFragment.md)
