package com.chumu.dt.v24.magicbox.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.AnimRes;
import androidx.annotation.FontRes;
import androidx.core.content.res.ResourcesCompat;

import com.chumu.dt.v24.magicbox.R;
import com.chumu.dt.v24.magicbox.appbox.ChuMuAppValidationManager;
import com.chumu.dt.v24.magicbox.appbox.ChuMuDisplayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:常用的公告样式，轮循Text，旋转木马
 * @Prject: magic-box
 * @date: 2020年07月28日 14:09
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.6-beta
 */
public class ChuMuCarouseView extends ViewFlipper {

    private int interval = 3000;
    private boolean hasSetAnimDuration = false;
    private int animDuration = 1000;
    private int textSize = 14;
    private int textColor = 0xff000000;
    private boolean singleLine = false;

    private int gravity = Gravity.START | Gravity.CENTER_VERTICAL;
    private static final int GRAVITY_START = 0;
    private static final int GRAVITY_CENTER = 1;
    private static final int GRAVITY_END = 2;
    private static final int GRAVITY_TOP = 3;
    private static final int GRAVITY_BOTTOM = 4;

    private int direction = DIRECTION_BOTTOM_TO_TOP;
    private static final int DIRECTION_BOTTOM_TO_TOP = 0;
    private static final int DIRECTION_TOP_TO_BOTTOM = 1;
    private static final int DIRECTION_RIGHT_TO_LEFT = 2;
    private static final int DIRECTION_LEFT_TO_RIGHT = 3;

    private Typeface typeface;

    @AnimRes
    private int inAnimResId = R.anim.anim_bottom_in;
    @AnimRes
    private int outAnimResId = R.anim.anim_top_out;

    private int position;
    private List<String> messages = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public ChuMuCarouseView(Context context) {
        this(context, null);
    }

    public ChuMuCarouseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChuMuMarqueeViewStyle, 0, 0);

        interval = typedArray.getInteger(R.styleable.ChuMuMarqueeViewStyle_chuMuInterval, interval);
        hasSetAnimDuration = typedArray.hasValue(R.styleable.ChuMuMarqueeViewStyle_chuMuAnimDuration);
        animDuration = typedArray.getInteger(R.styleable.ChuMuMarqueeViewStyle_chuMuAnimDuration, animDuration);
        singleLine = typedArray.getBoolean(R.styleable.ChuMuMarqueeViewStyle_chuMuSingleLine, false);
        if (typedArray.hasValue(R.styleable.ChuMuMarqueeViewStyle_chuMuTextSize)) {
            textSize = (int) typedArray.getDimension(R.styleable.ChuMuMarqueeViewStyle_chuMuTextSize, textSize);
            textSize = ChuMuDisplayUtils.px2sp(textSize);
        }
        textColor = typedArray.getColor(R.styleable.ChuMuMarqueeViewStyle_chuMuTextColor, textColor);
        @FontRes int fontRes = typedArray.getResourceId(R.styleable.ChuMuMarqueeViewStyle_chuMuFont, 0);
        if (fontRes != 0) {
            typeface = ResourcesCompat.getFont(context, fontRes);
        }
        int gravityType = typedArray.getInt(R.styleable.ChuMuMarqueeViewStyle_chuMuGravity, GRAVITY_START);
        switch (gravityType) {
            case GRAVITY_START:
                gravity = Gravity.START | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_CENTER:
                gravity = Gravity.CENTER;
                break;
            case GRAVITY_END:
                gravity = Gravity.END | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_TOP:
                gravity = Gravity.TOP | Gravity.CENTER_VERTICAL;
                break;
            case GRAVITY_BOTTOM:
                gravity = Gravity.BOTTOM | Gravity.CENTER_VERTICAL;
                break;
        }

        if (typedArray.hasValue(R.styleable.ChuMuMarqueeViewStyle_chuMuDirection)) {
            direction = typedArray.getInt(R.styleable.ChuMuMarqueeViewStyle_chuMuDirection, direction);
            switch (direction) {
                case DIRECTION_BOTTOM_TO_TOP:
                    inAnimResId = R.anim.anim_bottom_in;
                    outAnimResId = R.anim.anim_top_out;
                    break;
                case DIRECTION_TOP_TO_BOTTOM:
                    inAnimResId = R.anim.anim_top_in;
                    outAnimResId = R.anim.anim_bottom_out;
                    break;
                case DIRECTION_RIGHT_TO_LEFT:
                    inAnimResId = R.anim.anim_right_in;
                    outAnimResId = R.anim.anim_left_out;
                    break;
                case DIRECTION_LEFT_TO_RIGHT:
                    inAnimResId = R.anim.anim_left_in;
                    outAnimResId = R.anim.anim_right_out;
                    break;
            }
        } else {
            inAnimResId = R.anim.anim_bottom_in;
            outAnimResId = R.anim.anim_top_out;
        }

        typedArray.recycle();
        setFlipInterval(interval);
    }

    /**
     * 根据字符串，启动翻页公告
     *
     * @param message 字符串
     */
    public void startWithText(String message) {
        startWithText(message, inAnimResId, outAnimResId);
    }

    /**
     * 根据字符串，启动翻页公告
     *
     * @param message      字符串
     * @param inAnimResId  进入动画的resID
     * @param outAnimResID 离开动画的resID
     */
    public void startWithText(final String message, final @AnimRes int inAnimResId, final @AnimRes int outAnimResID) {
        if (TextUtils.isEmpty(message)) return;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                startWithFixedWidth(message, inAnimResId, outAnimResID);
            }
        });
    }

    /**
     * 根据字符串里面空格，启动翻页公告
     *
     * @param message 字符串
     */
    private void startWithFixedWidth(String message, @AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        int messageLength = message.length();
        int width = ChuMuDisplayUtils.px2dp(getWidth());
        if (width == 0) {
            throw new RuntimeException("Please set the width of MarqueeView !");
        }

        String[] sizes = message.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(sizes));

        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.clear();
        messages.addAll(list);
        postStart(inAnimResId, outAnimResID);
    }

    /**
     * 根据字符串列表，启动翻页公告
     *
     * @param messages 字符串列表
     */
    public void startWithList(List<String> messages) {
        startWithList(messages, inAnimResId, outAnimResId);
    }

    /**
     * 根据字符串列表，启动翻页公告
     *
     * @param messages     字符串列表
     * @param inAnimResId  进入动画的resID
     * @param outAnimResID 离开动画的resID
     */
    public void startWithList(List<String> messages, @AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        if (ChuMuAppValidationManager.isEmpty(messages)) return;
        setMessages(messages);
        postStart(inAnimResId, outAnimResID);
    }

    private void postStart(final @AnimRes int inAnimResId, final @AnimRes int outAnimResID) {
        post(new Runnable() {
            @Override
            public void run() {
                start(inAnimResId, outAnimResID);
            }
        });
    }

    private boolean isAnimStart = false;

    private void start(final @AnimRes int inAnimResId, final @AnimRes int outAnimResID) {
        removeAllViews();
        clearAnimation();
        // 检测数据源
        if (messages == null || messages.isEmpty()) {
            throw new RuntimeException("The messages cannot be empty!");
        }
        position = 0;
        addView(createTextView(messages.get(position)));

        if (messages.size() > 1) {
            setInAndOutAnimation(inAnimResId, outAnimResID);
            startFlipping();
        }

        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (isAnimStart) {
                        animation.cancel();
                    }
                    isAnimStart = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    position++;
                    if (position >= messages.size()) {
                        position = 0;
                    }
                    View view = createTextView(messages.get(position));
                    if (view.getParent() == null) {
                        addView(view);
                    }
                    isAnimStart = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private TextView createTextView(String marqueeItem) {
        TextView textView = (TextView) getChildAt((getDisplayedChild() + 1) % 3);
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setGravity(gravity | Gravity.CENTER_VERTICAL);
            textView.setTextColor(textColor);
            textView.setTextSize(textSize);
            textView.setIncludeFontPadding(true);
            textView.setSingleLine(singleLine);
            if (singleLine) {
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getPosition(), (TextView) v);
                    }
                }
            });
        }


        textView.setText(marqueeItem);
        textView.setTag(position);
        return textView;
    }

    public int getPosition() {
        return (int) getCurrentView().getTag();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, TextView textView);
    }

    /**
     * 设置进入动画和离开动画
     *
     * @param inAnimResId  进入动画的resID
     * @param outAnimResID 离开动画的resID
     */
    private void setInAndOutAnimation(@AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        Animation inAnim = AnimationUtils.loadAnimation(getContext(), inAnimResId);
        if (hasSetAnimDuration) inAnim.setDuration(animDuration);
        setInAnimation(inAnim);

        Animation outAnim = AnimationUtils.loadAnimation(getContext(), outAnimResID);
        if (hasSetAnimDuration) outAnim.setDuration(animDuration);
        setOutAnimation(outAnim);
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;

    }
}