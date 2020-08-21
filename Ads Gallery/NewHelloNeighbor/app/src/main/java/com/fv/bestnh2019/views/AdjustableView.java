package com.fv.bestnh2019.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdjustableView extends AppCompatImageView {

    boolean mAdjustViewBounds;

    public AdjustableView(Context context) {
        super(context);
    }

    public AdjustableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AdjustableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
        super.setAdjustViewBounds(adjustViewBounds);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable mDrawable = getDrawable();
        if (mDrawable == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        if (mAdjustViewBounds) {
            int mDrawableWidth = mDrawable.getIntrinsicWidth();
            int mDrawableHeight = mDrawable.getIntrinsicHeight();
            int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
            int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);

            if (heightMode == View.MeasureSpec.EXACTLY && widthMode != View.MeasureSpec.EXACTLY) {
                // Fixed Height & Adjustable Width
                int width = heightSize * mDrawableWidth / mDrawableHeight;
                if (isInScrollingContainer())
                    setMeasuredDimension(width, heightSize);
                else
                    setMeasuredDimension(Math.min(width, widthSize), Math.min(heightSize, heightSize));
            } else if (widthMode == View.MeasureSpec.EXACTLY && heightMode != View.MeasureSpec.EXACTLY) {
                // Fixed Width & Adjustable Height
                int height = widthSize * mDrawableHeight / mDrawableWidth;
                if (isInScrollingContainer())
                    setMeasuredDimension(widthSize, height);
                else
                    setMeasuredDimension(Math.min(widthSize, widthSize), Math.min(height, heightSize));
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private boolean isInScrollingContainer() {
        ViewParent p = getParent();
        while (p != null && p instanceof ViewGroup) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = p.getParent();
        }
        return false;
    }
}
