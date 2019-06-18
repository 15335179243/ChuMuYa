package com.chumu.dt.v24.permissions.wiget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.HashMap;
import java.util.Map;

public abstract class ChuMuNormalDecoration extends ItemDecoration {
    protected String TAG = "ChuMu";
    private Paint mHeaderTxtPaint = new Paint(1);
    private Paint mHeaderContentPaint;
    protected int headerHeight = 136;
    private int textPaddingLeft = 50;
    private int textSize = 50;
    private int textColor = -16777216;
    private int headerContentColor = -1118482;
    private final float txtYAxis;
    private RecyclerView mRecyclerView;
    private boolean isInitHeight = false;
    private SparseArray<Integer> stickyHeaderPosArray = new SparseArray();
    private GestureDetector gestureDetector;
    private Map<Integer, View> headViewMap = new HashMap();
    private ChuMuNormalDecoration.OnHeaderClickListener headerClickEvent;
    private OnGestureListener gestureListener = new OnGestureListener() {
        public boolean onDown(MotionEvent e) {
            return false;
        }

        public void onShowPress(MotionEvent e) {
        }

        public boolean onSingleTapUp(MotionEvent e) {
            for (int i = 0; i < ChuMuNormalDecoration.this.stickyHeaderPosArray.size(); ++i) {
                int value = (Integer) ChuMuNormalDecoration.this.stickyHeaderPosArray.valueAt(i);
                float y = e.getY();
                if ((float) (value - ChuMuNormalDecoration.this.headerHeight) <= y && y <= (float) value) {
                    if (ChuMuNormalDecoration.this.headerClickEvent != null) {
                        ChuMuNormalDecoration.this.headerClickEvent.headerClick(ChuMuNormalDecoration.this.stickyHeaderPosArray.keyAt(i));
                    }

                    return true;
                }
            }

            return false;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        public void onLongPress(MotionEvent e) {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };
    private ChuMuNormalDecoration.OnDecorationHeadDraw headerDrawEvent;
    private Map<String, Drawable> imgDrawableMap = new HashMap();

    public ChuMuNormalDecoration() {
        this.mHeaderTxtPaint.setColor(this.textColor);
        this.mHeaderTxtPaint.setTextSize((float) this.textSize);
        this.mHeaderTxtPaint.setTextAlign(Align.LEFT);
        this.mHeaderContentPaint = new Paint(1);
        this.mHeaderContentPaint.setColor(this.headerContentColor);
        FontMetrics fontMetrics = this.mHeaderTxtPaint.getFontMetrics();
        float total = -fontMetrics.ascent + fontMetrics.descent;
        this.txtYAxis = total / 2.0F - fontMetrics.descent;
    }

    @SuppressLint("WrongConstant")
    public void getItemOffsets(Rect outRect, View itemView, RecyclerView parent, State state) {
        super.getItemOffsets(outRect, itemView, parent, state);
        if (this.mRecyclerView == null) {
            this.mRecyclerView = parent;
        }

        if (this.headerDrawEvent != null && !this.isInitHeight) {
            View headerView = this.headerDrawEvent.getHeaderView(0);
            headerView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.headerHeight = headerView.getMeasuredHeight();
            this.isInitHeight = true;
        }

        int pos = parent.getChildAdapterPosition(itemView);
        String curHeaderName = this.getHeaderName(pos);
        if (curHeaderName != null) {
            if (pos == 0 || !curHeaderName.equals(this.getHeaderName(pos - 1))) {
                outRect.top = this.headerHeight;
            }

        }
    }

    public abstract String getHeaderName(int var1);

    @SuppressLint("WrongConstant")
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        super.onDrawOver(canvas, recyclerView, state);
        if (this.mRecyclerView == null) {
            this.mRecyclerView = recyclerView;
        }

        if (this.gestureDetector == null) {
            this.gestureDetector = new GestureDetector(recyclerView.getContext(), this.gestureListener);
            recyclerView.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return ChuMuNormalDecoration.this.gestureDetector.onTouchEvent(event);
                }
            });
        }

        this.stickyHeaderPosArray.clear();
        int childCount = recyclerView.getChildCount();
        int left = recyclerView.getLeft() + recyclerView.getPaddingLeft();
        int right = recyclerView.getRight() - recyclerView.getPaddingRight();
        String firstHeaderName = null;
        int firstPos = 0;
        int translateTop = 0;

        for (int i = 0; i < childCount; ++i) {
            View childView = recyclerView.getChildAt(i);
            int pos = recyclerView.getChildAdapterPosition(childView);
            String curHeaderName = this.getHeaderName(pos);
            if (i == 0) {
                firstHeaderName = curHeaderName;
                firstPos = pos;
            }

            if (curHeaderName != null) {
                int viewTop = childView.getTop() + recyclerView.getPaddingTop();
                if (pos == 0 || !curHeaderName.equals(this.getHeaderName(pos - 1))) {
                    if (this.headerDrawEvent != null) {
                        View headerView;
                        if (this.headViewMap.get(pos) == null) {
                            headerView = this.headerDrawEvent.getHeaderView(pos);
                            headerView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                            headerView.setDrawingCacheEnabled(true);
                            headerView.layout(0, 0, right, this.headerHeight);
                            this.headViewMap.put(pos, headerView);
                            canvas.drawBitmap(headerView.getDrawingCache(), (float) left, (float) (viewTop - this.headerHeight), (Paint) null);
                        } else {
                            headerView = (View) this.headViewMap.get(pos);
                            canvas.drawBitmap(headerView.getDrawingCache(), (float) left, (float) (viewTop - this.headerHeight), (Paint) null);
                        }
                    } else {
                        canvas.drawRect((float) left, (float) (viewTop - this.headerHeight), (float) right, (float) viewTop, this.mHeaderContentPaint);
                        canvas.drawText(curHeaderName, (float) (left + this.textPaddingLeft), (float) (viewTop - this.headerHeight / 2) + this.txtYAxis, this.mHeaderTxtPaint);
                    }

                    if (this.headerHeight < viewTop && viewTop <= 2 * this.headerHeight) {
                        translateTop = viewTop - 2 * this.headerHeight;
                    }

                    this.stickyHeaderPosArray.put(pos, viewTop);
                    Log.i(this.TAG, "绘制各个头部" + pos);
                }
            }
        }

        if (firstHeaderName != null) {
            canvas.save();
            canvas.translate(0.0F, (float) translateTop);
            if (this.headerDrawEvent != null) {
                View headerView;
                if (this.headViewMap.get(firstPos) == null) {
                    headerView = this.headerDrawEvent.getHeaderView(firstPos);
                    headerView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    headerView.setDrawingCacheEnabled(true);
                    headerView.layout(0, 0, right, this.headerHeight);
                    this.headViewMap.put(firstPos, headerView);
                    canvas.drawBitmap(headerView.getDrawingCache(), (float) left, 0.0F, (Paint) null);
                } else {
                    headerView = (View) this.headViewMap.get(firstPos);
                    canvas.drawBitmap(headerView.getDrawingCache(), (float) left, 0.0F, (Paint) null);
                }
            } else {
                canvas.drawRect((float) left, 0.0F, (float) right, (float) this.headerHeight, this.mHeaderContentPaint);
                canvas.drawText(firstHeaderName, (float) (left + this.textPaddingLeft), (float) (this.headerHeight / 2) + this.txtYAxis, this.mHeaderTxtPaint);
            }

            canvas.restore();
            Log.i(this.TAG, "绘制悬浮头部");
        }
    }

    public void setOnHeaderClickListener(ChuMuNormalDecoration.OnHeaderClickListener headerClickListener) {
        this.headerClickEvent = headerClickListener;
    }

    public void setOnDecorationHeadDraw(ChuMuNormalDecoration.OnDecorationHeadDraw decorationHeadDraw) {
        this.headerDrawEvent = decorationHeadDraw;
    }

    public void loadImage(final String url, final int pos, ImageView imageView) {
        if (this.getImg(url) != null) {
            Log.i("qdx", "Glide 加载完图片" + pos);
            imageView.setImageDrawable(this.getImg(url));
        } else {
            Glide.with(this.mRecyclerView.getContext()).load(url).into(new SimpleTarget<Drawable>() {
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    Log.i("qdx", "Glide回调" + pos);
                    ChuMuNormalDecoration.this.headViewMap.remove(pos);
                    ChuMuNormalDecoration.this.imgDrawableMap.put(url, resource);
                    ChuMuNormalDecoration.this.mRecyclerView.postInvalidate();
                }
            });
        }

    }

    private Drawable getImg(String url) {
        return (Drawable) this.imgDrawableMap.get(url);
    }

    public void onDestory() {
        this.headViewMap.clear();
        this.imgDrawableMap.clear();
        this.stickyHeaderPosArray.clear();
        this.mRecyclerView = null;
        this.setOnHeaderClickListener((ChuMuNormalDecoration.OnHeaderClickListener) null);
        this.setOnDecorationHeadDraw((ChuMuNormalDecoration.OnDecorationHeadDraw) null);
    }

    public void setHeaderHeight(int headerHeight) {
        this.headerHeight = headerHeight;
    }

    public void setTextPaddingLeft(int textPaddingLeft) {
        this.textPaddingLeft = textPaddingLeft;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        this.mHeaderTxtPaint.setTextSize((float) textSize);
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        this.mHeaderTxtPaint.setColor(textColor);
    }

    public void setHeaderContentColor(int headerContentColor) {
        this.headerContentColor = headerContentColor;
        this.mHeaderContentPaint.setColor(headerContentColor);
    }

    public interface OnDecorationHeadDraw {
        View getHeaderView(int var1);
    }

    public interface OnHeaderClickListener {
        void headerClick(int var1);
    }
}