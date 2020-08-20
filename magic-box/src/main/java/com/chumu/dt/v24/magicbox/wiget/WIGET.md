# 目录
## -----------------------------------------------[粘性头布局](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md#粘性头布局-点击查看)
## -----------------------------------------------[流势布局](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md#流势布局--点击查看)
## -----------------------------------------------[五彩斑斓的字体](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md#五彩斑斓的字体我打包在依赖里面了代码如下)
## -----------------------------------------------[旋转木马ChuMuCarouseView](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/WIGET.md#ChuMuCarouseView-点击查看)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173728256.gif)
由于为了大家的开发效率着想,我把这个已经打包成了依赖,大家只需要导我第三方依赖

## 粘性头布局: →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/ChuMuNormalDecoration.java)

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

## 流势布局  →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/ChuMuFlowLayout.java)


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

## 五彩斑斓的字体我打包在依赖里面了代码如下:

```java
//大家只需要调用依赖里面的一个随机颜色的方法就可以了
TextView tv;
tv.setsetTextColor(ChuMuRandomColor.onRandomCOlor());
```

详情这边有csdn博客:https://blog.csdn.net/qq_44729989/article/details/93343258



## ChuMuCarouseView →[点击查看](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/wiget/ChuMuCarouseView.java)
###                                                                                                                                                                         --------------------------------    (旋转木马)






#### XML

```
    <com.chumu.dt.v24.magicbox.wiget.ChuMuCarouseView
        android:id="@+id/carouseView"
        android:layout_width="match_parent"
        android:layout_height="30dp"
        app:chuMuAnimDuration="1000"
        app:chuMuDirection="bottom_to_top"
        app:chuMuInterval="1000"
        app:chuMuTextColor="#ff33333"
        app:chuMuTextSize="14sp"
        app:chuMuSingleLine="true"/>
```


#### 属性
| Attribute 属性    | format                                                     | 中文描述             |
| ----------------- | ---------------------------------------------------------- | -------------------- |
| chuMuAnimDuration | integer\|reference                                         | 一行文字动画执行时间 |
| chuMuInterval     | integer\|reference                                         | 两行文字翻页时间间隔 |
| chuMuTextSize     | dimension\|reference                                       | 文字大小             |
| chuMuTextColor    | color\|reference                                           | 文字颜色             |
| chuMuGravity      | start、center、end、top、bottom                            | 文字位置             |
| chuMuSingleLine   | boolean                                                    | 单行设置             |
| chuMuDirection    | bottom_to_top、top_to_bottom、right_to_left、left_to_right | 动画滚动方向         |

```
ChuMuCarouseView carouseView =  findViewById(R.id.carouseView);
List<String> messages = new ArrayList<>();
messages.add("旋转木马转呀转");
messages.add("转到左边一个木马");
messages.add("转到右边一个木马");
messages.add("跳起来的木马");
messages.add("转圈圈的木马");
messages.add("木马~~~木马~~");
marqueeView.startWithList(messages);
// 在代码里设置自己的动画
carouseView.startWithList(messages, R.anim.anim_bottom_in, R.anim.anim_top_out);
```
### 使用

在 Activity 或 Fragment 中

```
@Override
public void onStart() {
    super.onStart();
    marqueeView.startFlipping();
}

@Override
public void onStop() {
    super.onStop();
    marqueeView.stopFlipping();
}
```


#### 设置字符串数据

```
String message = "我爱你，你知道嘛？ 我爱你，就像老鼠爱大米！ 我爱你，我爱你胜过写代码！";
carouseView.startWithText(message);

// 在代码里设置自己的动画
carouseView.startWithText(message, R.anim.anim_bottom_in, R.anim.anim_top_out);
```

#### 设置事件监听

```
carouseView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
    @Override
    public void onItemClick(int position, TextView textView) {
                Log.d(TAG,String.valueOf(carouseView.getPosition()) + ". " + textView.getText());
    }
});
```



在 ListView 或 RecyclerView 的 Adapter 中

```
@Override
public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
    super.onViewDetachedFromWindow(holder);
    holder.carouseView.stopFlipping();
}
```
