# ChuMuSwipeBack侧滑返回
##  使用方式：
1. 继承[ChuMuBaseActivity](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/base/ChuMuBaseActivity.java)
                              ,然后在你需要侧滑返回的Activity中使用注解,如果你所有类里面都需要注解的话你可以直接继承 [ChuMuSwipeBackActivity](https://github.com/15335179243/ChuMuYa/blob/master/magic-box/src/main/java/com/chumu/dt/v24/magicbox/swipeback/ChuMuSwipeBackActivity.java)
        
```java
/**
*像这样写到你需要侧滑返回的Activity类上面
*/
@ChuMuSwipeBack(true)
public  class ChuMuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

```

此效果使用到的框架来源于开源的 @ikew0ng 的 SwipeBackLayout(<https://github.com/ikew0ng/SwipeBackLayout>) 开源协议为 Apache License2.0