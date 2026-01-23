package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import p007b.p225i.p226a.p341g.p344c.MaterialCardViewHelper;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final String LOG_TAG = "MaterialCardView";

    @NonNull
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DRAGGED_STATE_SET = {C10817R.attr.state_dragged};
    private static final int DEF_STYLE_RES = C10817R.style.Widget_MaterialComponents_CardView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z2);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ float access$001(MaterialCardView materialCardView) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        MaterialCardViewHelper materialCardViewHelper;
        Drawable drawable;
        if (Build.VERSION.SDK_INT <= 26 || (drawable = (materialCardViewHelper = this.cardViewHelper).f11572p) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.bottom;
        materialCardViewHelper.f11572p.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        materialCardViewHelper.f11572p.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.cardViewHelper.f11561e.getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.f11561e.getFillColor();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.f11562f.getFillColor();
    }

    public float getCardViewRadius() {
        return access$001(this);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.cardViewHelper.f11567k;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.cardViewHelper.f11563g;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.cardViewHelper.f11564h;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.f11569m;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.cardViewHelper.f11560d.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.cardViewHelper.f11560d.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.cardViewHelper.f11560d.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.cardViewHelper.f11560d.top;
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    public float getProgress() {
        return this.cardViewHelper.f11561e.getInterpolation();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.cardViewHelper.f11561e.getTopLeftCornerResolvedSize();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.f11568l;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.f11570n;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.cardViewHelper.f11571o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.f11571o;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.f11565i;
    }

    public boolean isCheckable() {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        return materialCardViewHelper != null && materialCardViewHelper.f11577u;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.f11561e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (isCheckable()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        if (isDragged()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, DRAGGED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (materialCardViewHelper.f11573q != null) {
            int i5 = materialCardViewHelper.f11563g;
            int i6 = materialCardViewHelper.f11564h;
            int iCeil = (measuredWidth - i5) - i6;
            int iCeil2 = (measuredHeight - i5) - i6;
            if (materialCardViewHelper.f11559c.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(materialCardViewHelper.m6047d() * 2.0f);
                iCeil -= (int) Math.ceil(materialCardViewHelper.m6046c() * 2.0f);
            }
            int i7 = iCeil2;
            int i8 = materialCardViewHelper.f11563g;
            if (ViewCompat.getLayoutDirection(materialCardViewHelper.f11559c) == 1) {
                i4 = iCeil;
                i3 = i8;
            } else {
                i3 = iCeil;
                i4 = i8;
            }
            materialCardViewHelper.f11573q.setLayerInset(2, i3, materialCardViewHelper.f11563g, i4, i7);
        }
    }

    public void setAncestorContentPadding(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.f11576t) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.f11576t = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11561e.setFillColor(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11561e.setElevation(materialCardViewHelper.f11559c.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.cardViewHelper.f11562f;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.cardViewHelper.f11577u = z2;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.checked != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.cardViewHelper.m6050g(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i) {
        this.cardViewHelper.f11563g = i;
    }

    public void setCheckedIconMarginResource(@DimenRes int i) {
        if (i != -1) {
            this.cardViewHelper.f11563g = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        this.cardViewHelper.m6050g(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(@Dimension int i) {
        this.cardViewHelper.f11564h = i;
    }

    public void setCheckedIconSizeResource(@DimenRes int i) {
        if (i != 0) {
            this.cardViewHelper.f11564h = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11569m = colorStateList;
        Drawable drawable = materialCardViewHelper.f11567k;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper != null) {
            Drawable drawable = materialCardViewHelper.f11566j;
            Drawable drawableM6048e = materialCardViewHelper.f11559c.isClickable() ? materialCardViewHelper.m6048e() : materialCardViewHelper.f11562f;
            materialCardViewHelper.f11566j = drawableM6048e;
            if (drawable != drawableM6048e) {
                if (Build.VERSION.SDK_INT < 23 || !(materialCardViewHelper.f11559c.getForeground() instanceof InsetDrawable)) {
                    materialCardViewHelper.f11559c.setForeground(materialCardViewHelper.m6049f(drawableM6048e));
                } else {
                    ((InsetDrawable) materialCardViewHelper.f11559c.getForeground()).setDrawable(drawableM6048e);
                }
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11560d.set(i, i2, i3, i4);
        materialCardViewHelper.m6054k();
    }

    public void setDragged(boolean z2) {
        if (this.dragged != z2) {
            this.dragged = z2;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.cardViewHelper.m6055l();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.cardViewHelper.m6055l();
        this.cardViewHelper.m6054k();
    }

    public void setProgress(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11561e.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = materialCardViewHelper.f11562f;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = materialCardViewHelper.f11575s;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.m6051h(materialCardViewHelper.f11570n.withCornerSize(f));
        materialCardViewHelper.f11566j.invalidateSelf();
        if (materialCardViewHelper.m6053j() || materialCardViewHelper.m6052i()) {
            materialCardViewHelper.m6054k();
        }
        if (materialCardViewHelper.m6053j()) {
            materialCardViewHelper.m6055l();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11568l = colorStateList;
        materialCardViewHelper.m6056m();
    }

    public void setRippleColorResource(@ColorRes int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        materialCardViewHelper.f11568l = AppCompatResources.getColorStateList(getContext(), i);
        materialCardViewHelper.m6056m();
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
        this.cardViewHelper.m6051h(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (materialCardViewHelper.f11571o == colorStateListValueOf) {
            return;
        }
        materialCardViewHelper.f11571o = colorStateListValueOf;
        materialCardViewHelper.m6057n();
    }

    public void setStrokeWidth(@Dimension int i) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (i == materialCardViewHelper.f11565i) {
            return;
        }
        materialCardViewHelper.f11565i = i;
        materialCardViewHelper.m6057n();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        this.cardViewHelper.m6055l();
        this.cardViewHelper.m6054k();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.materialCardViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, C10817R.styleable.MaterialCardView, i, i2, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i, i2);
        this.cardViewHelper = materialCardViewHelper;
        materialCardViewHelper.f11561e.setFillColor(super.getCardBackgroundColor());
        materialCardViewHelper.f11560d.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        materialCardViewHelper.m6054k();
        ColorStateList colorStateList = MaterialResources.getColorStateList(materialCardViewHelper.f11559c.getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCardView_strokeColor);
        materialCardViewHelper.f11571o = colorStateList;
        if (colorStateList == null) {
            materialCardViewHelper.f11571o = ColorStateList.valueOf(-1);
        }
        materialCardViewHelper.f11565i = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.MaterialCardView_android_checkable, false);
        materialCardViewHelper.f11577u = z2;
        materialCardViewHelper.f11559c.setLongClickable(z2);
        materialCardViewHelper.f11569m = MaterialResources.getColorStateList(materialCardViewHelper.f11559c.getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCardView_checkedIconTint);
        materialCardViewHelper.m6050g(MaterialResources.getDrawable(materialCardViewHelper.f11559c.getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCardView_checkedIcon));
        materialCardViewHelper.f11564h = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialCardView_checkedIconSize, 0);
        materialCardViewHelper.f11563g = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.MaterialCardView_checkedIconMargin, 0);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(materialCardViewHelper.f11559c.getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCardView_rippleColor);
        materialCardViewHelper.f11568l = colorStateList2;
        if (colorStateList2 == null) {
            materialCardViewHelper.f11568l = ColorStateList.valueOf(MaterialColors.getColor(materialCardViewHelper.f11559c, C10817R.attr.colorControlHighlight));
        }
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(materialCardViewHelper.f11559c.getContext(), typedArrayObtainStyledAttributes, C10817R.styleable.MaterialCardView_cardForegroundColor);
        materialCardViewHelper.f11562f.setFillColor(colorStateList3 == null ? ColorStateList.valueOf(0) : colorStateList3);
        materialCardViewHelper.m6056m();
        materialCardViewHelper.f11561e.setElevation(materialCardViewHelper.f11559c.getCardElevation());
        materialCardViewHelper.m6057n();
        materialCardViewHelper.f11559c.setBackgroundInternal(materialCardViewHelper.m6049f(materialCardViewHelper.f11561e));
        Drawable drawableM6048e = materialCardViewHelper.f11559c.isClickable() ? materialCardViewHelper.m6048e() : materialCardViewHelper.f11562f;
        materialCardViewHelper.f11566j = drawableM6048e;
        materialCardViewHelper.f11559c.setForeground(materialCardViewHelper.m6049f(drawableM6048e));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.cardViewHelper.f11561e.setFillColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
        if (materialCardViewHelper.f11571o == colorStateList) {
            return;
        }
        materialCardViewHelper.f11571o = colorStateList;
        materialCardViewHelper.m6057n();
    }
}
