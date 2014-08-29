package com.jaspersoft.sample.dark.theme.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.jaspersoft.sample.dark.theme.R;

/**
 * @author Tom Koptel
 * @since 1.9
 */
public class AutoLayerLinearLayout extends LinearLayout {

    private Drawable mForegroundSelector;

    //---------------------------------------------------------------------
    // Constructors
    //---------------------------------------------------------------------

    public AutoLayerLinearLayout(Context context) {
        this(context, null);
    }

    public AutoLayerLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoLayerLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            mForegroundSelector = getResources().getDrawable(android.R.drawable.list_selector_background);
        } else {
            TypedArray typedAttributes = context.obtainStyledAttributes(attrs, R.styleable.AutoLayerLayout, 0, 0);
            mForegroundSelector = typedAttributes.getDrawable(R.styleable.AutoLayerLayout_foregroundSelector);
            setForegroundSelector(mForegroundSelector);
            typedAttributes.recycle();
        }
    }

    //---------------------------------------------------------------------
    // Public methods
    //---------------------------------------------------------------------

    public Drawable getForegroundSelector() {
        return mForegroundSelector;
    }

    public void setForegroundSelector(int resId) {
        mForegroundSelector = getContext().getResources().getDrawable(resId);
        setForegroundSelector(mForegroundSelector);
    }

    public void setForegroundSelector(Drawable drawable) {
        mForegroundSelector = drawable;
        if (mForegroundSelector != null) {
            mForegroundSelector.setCallback(this);
        }
    }

    @TargetApi(11)
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mForegroundSelector != null) {
            mForegroundSelector.jumpToCurrentState();
        }
    }

    //---------------------------------------------------------------------
    // Protected methods
    //---------------------------------------------------------------------

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mForegroundSelector != null) {
            mForegroundSelector.setState(getDrawableState());
            invalidate();
        }
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        if (mForegroundSelector != null) {
            mForegroundSelector.setBounds(0, 0, width, height);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mForegroundSelector != null) {
            mForegroundSelector.draw(canvas);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mForegroundSelector != null) {
            mForegroundSelector.draw(canvas);
        }
    }

    @Override
    protected boolean verifyDrawable(Drawable who) {
        if (mForegroundSelector == null) {
            return super.verifyDrawable(who);
        } else {
            return super.verifyDrawable(who) || (who == mForegroundSelector);
        }
    }

}