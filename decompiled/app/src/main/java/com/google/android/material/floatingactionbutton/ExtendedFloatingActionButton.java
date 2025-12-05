package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;
import p007b.p225i.p226a.p341g.p346e.AnimatorTracker;
import p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy;
import p007b.p225i.p226a.p341g.p346e.MotionStrategy;

/* loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @NonNull
    public ColorStateList originalTextCsl;
    private final MotionStrategy showStrategy;

    @NonNull
    private final MotionStrategy shrinkStrategy;
    private static final int DEF_STYLE_RES = C10817R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> WIDTH = new C10911d(Float.class, "width");
    public static final Property<View, Float> HEIGHT = new C10912e(Float.class, "height");
    public static final Property<View, Float> PADDING_START = new C10913f(Float.class, "paddingStart");
    public static final Property<View, Float> PADDING_END = new C10914g(Float.class, "paddingEnd");

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @Nullable
        private OnChangedCallback internalAutoHideCallback;

        @Nullable
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        private static boolean isBottomSheet(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean shouldUpdateVisibility(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.autoHideEnabled || this.autoShrinkEnabled) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        public void extendOrShow(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.autoShrinkEnabled;
            ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, z2 ? ExtendedFloatingActionButton.access$500(extendedFloatingActionButton) : ExtendedFloatingActionButton.access$600(extendedFloatingActionButton), z2 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            return getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
            return onDependentViewChanged(coordinatorLayout, (ExtendedFloatingActionButton) view, view2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            return onLayoutChild(coordinatorLayout, (ExtendedFloatingActionButton) view, i);
        }

        public void setAutoHideEnabled(boolean z2) {
            this.autoHideEnabled = z2;
        }

        public void setAutoShrinkEnabled(boolean z2) {
            this.autoShrinkEnabled = z2;
        }

        @VisibleForTesting
        public void setInternalAutoHideCallback(@Nullable OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        @VisibleForTesting
        public void setInternalAutoShrinkCallback(@Nullable OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.autoShrinkEnabled;
            ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, z2 ? ExtendedFloatingActionButton.access$200(extendedFloatingActionButton) : ExtendedFloatingActionButton.access$300(extendedFloatingActionButton), z2 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
            return false;
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10817R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = typedArrayObtainStyledAttributes.getBoolean(C10817R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a */
    public class C10908a implements InterfaceC10918k {
        public C10908a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        /* renamed from: a */
        public ViewGroup.LayoutParams mo9143a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getWidth() {
            return ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this) + ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this) + (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2));
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b */
    public class C10909b implements InterfaceC10918k {
        public C10909b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        /* renamed from: a */
        public ViewGroup.LayoutParams mo9143a() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.getCollapsedSize(), ExtendedFloatingActionButton.this.getCollapsedSize());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC10918k
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$c */
    public class C10910c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f21009a;

        /* renamed from: b */
        public final /* synthetic */ MotionStrategy f21010b;

        /* renamed from: c */
        public final /* synthetic */ OnChangedCallback f21011c;

        public C10910c(ExtendedFloatingActionButton extendedFloatingActionButton, MotionStrategy motionStrategy, OnChangedCallback onChangedCallback) {
            this.f21010b = motionStrategy;
            this.f21011c = onChangedCallback;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f21009a = true;
            this.f21010b.mo6078a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21010b.mo6079e();
            if (this.f21009a) {
                return;
            }
            this.f21010b.mo6115g(this.f21011c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f21010b.onAnimationStart(animator);
            this.f21009a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$d */
    public static class C10911d extends Property<View, Float> {
        public C10911d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().width = f.intValue();
            view2.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$e */
    public static class C10912e extends Property<View, Float> {
        public C10912e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().height = f.intValue();
            view2.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f */
    public static class C10913f extends Property<View, Float> {
        public C10913f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, f.intValue(), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$g */
    public static class C10914g extends Property<View, Float> {
        public C10914g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h */
    public class C10915h extends BaseMotionStrategy {

        /* renamed from: g */
        public final InterfaceC10918k f21012g;

        /* renamed from: h */
        public final boolean f21013h;

        public C10915h(AnimatorTracker animatorTracker, InterfaceC10918k interfaceC10918k, boolean z2) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.f21012g = interfaceC10918k;
            this.f21013h = z2;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: b */
        public int mo6112b() {
            return this.f21013h ? C10817R.animator.mtrl_extended_fab_change_size_expand_motion_spec : C10817R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: c */
        public void mo6113c() {
            ExtendedFloatingActionButton.access$702(ExtendedFloatingActionButton.this, this.f21013h);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f21012g.mo9143a().width;
            layoutParams.height = this.f21012g.mo9143a().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f21012g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f21012g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: d */
        public boolean mo6114d() {
            return this.f21013h == ExtendedFloatingActionButton.access$700(ExtendedFloatingActionButton.this) || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: e */
        public void mo6079e() {
            super.mo6079e();
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, false);
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f21012g.mo9143a().width;
            layoutParams.height = this.f21012g.mo9143a().height;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        @NonNull
        /* renamed from: f */
        public AnimatorSet mo6080f() {
            MotionSpec motionSpecM6082i = m6082i();
            if (motionSpecM6082i.hasPropertyValues("width")) {
                PropertyValuesHolder[] propertyValues = motionSpecM6082i.getPropertyValues("width");
                propertyValues[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f21012g.getWidth());
                motionSpecM6082i.setPropertyValues("width", propertyValues);
            }
            if (motionSpecM6082i.hasPropertyValues("height")) {
                PropertyValuesHolder[] propertyValues2 = motionSpecM6082i.getPropertyValues("height");
                propertyValues2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f21012g.getHeight());
                motionSpecM6082i.setPropertyValues("height", propertyValues2);
            }
            if (motionSpecM6082i.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = motionSpecM6082i.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f21012g.getPaddingStart());
                motionSpecM6082i.setPropertyValues("paddingStart", propertyValues3);
            }
            if (motionSpecM6082i.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = motionSpecM6082i.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f21012g.getPaddingEnd());
                motionSpecM6082i.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (motionSpecM6082i.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = motionSpecM6082i.getPropertyValues("labelOpacity");
                boolean z2 = this.f21013h;
                propertyValues5[0].setFloatValues(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
                motionSpecM6082i.setPropertyValues("labelOpacity", propertyValues5);
            }
            return m6081h(motionSpecM6082i);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: g */
        public void mo6115g(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.f21013h) {
                onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
            }
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.f11624d;
            Animator animator2 = animatorTracker.f11620a;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.f11620a = animator;
            ExtendedFloatingActionButton.access$702(ExtendedFloatingActionButton.this, this.f21013h);
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, true);
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i */
    public class C10916i extends BaseMotionStrategy {

        /* renamed from: g */
        public boolean f21015g;

        public C10916i(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: a */
        public void mo6078a() {
            this.f11624d.f11620a = null;
            this.f21015g = true;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: b */
        public int mo6112b() {
            return C10817R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: c */
        public void mo6113c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: d */
        public boolean mo6114d() {
            return ExtendedFloatingActionButton.access$1100(ExtendedFloatingActionButton.this);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: e */
        public void mo6079e() {
            super.mo6079e();
            ExtendedFloatingActionButton.access$902(ExtendedFloatingActionButton.this, 0);
            if (this.f21015g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: g */
        public void mo6115g(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.f11624d;
            Animator animator2 = animatorTracker.f11620a;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.f11620a = animator;
            this.f21015g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.access$902(ExtendedFloatingActionButton.this, 1);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j */
    public class C10917j extends BaseMotionStrategy {
        public C10917j(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: b */
        public int mo6112b() {
            return C10817R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: c */
        public void mo6113c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: d */
        public boolean mo6114d() {
            return ExtendedFloatingActionButton.access$1000(ExtendedFloatingActionButton.this);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: e */
        public void mo6079e() {
            super.mo6079e();
            ExtendedFloatingActionButton.access$902(ExtendedFloatingActionButton.this, 0);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.MotionStrategy
        /* renamed from: g */
        public void mo6115g(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        @Override // p007b.p225i.p226a.p341g.p346e.BaseMotionStrategy, p007b.p225i.p226a.p341g.p346e.MotionStrategy
        public void onAnimationStart(Animator animator) {
            AnimatorTracker animatorTracker = this.f11624d;
            Animator animator2 = animatorTracker.f11620a;
            if (animator2 != null) {
                animator2.cancel();
            }
            animatorTracker.f11620a = animator;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.access$902(ExtendedFloatingActionButton.this, 2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k */
    public interface InterfaceC10918k {
        /* renamed from: a */
        ViewGroup.LayoutParams mo9143a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingStart;
    }

    public static /* synthetic */ int access$100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingEnd;
    }

    public static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeShown();
    }

    public static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeHidden();
    }

    public static /* synthetic */ MotionStrategy access$200(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.shrinkStrategy;
    }

    public static /* synthetic */ MotionStrategy access$300(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.hideStrategy;
    }

    public static /* synthetic */ void access$400(ExtendedFloatingActionButton extendedFloatingActionButton, MotionStrategy motionStrategy, OnChangedCallback onChangedCallback) {
        extendedFloatingActionButton.performMotion(motionStrategy, onChangedCallback);
    }

    public static /* synthetic */ MotionStrategy access$500(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendStrategy;
    }

    public static /* synthetic */ MotionStrategy access$600(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.showStrategy;
    }

    public static /* synthetic */ boolean access$700(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isExtended;
    }

    public static /* synthetic */ boolean access$702(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z2) {
        extendedFloatingActionButton.isExtended = z2;
        return z2;
    }

    public static /* synthetic */ boolean access$802(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z2) {
        extendedFloatingActionButton.isTransforming = z2;
        return z2;
    }

    public static /* synthetic */ int access$902(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        extendedFloatingActionButton.animState = i;
        return i;
    }

    private boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    private boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    private void performMotion(@NonNull MotionStrategy motionStrategy, @Nullable OnChangedCallback onChangedCallback) {
        if (motionStrategy.mo6114d()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.mo6113c();
            motionStrategy.mo6115g(onChangedCallback);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetMo6080f = motionStrategy.mo6080f();
        animatorSetMo6080f.addListener(new C10910c(this, motionStrategy, onChangedCallback));
        Iterator<Animator.AnimatorListener> it = ((BaseMotionStrategy) motionStrategy).f11623c.iterator();
        while (it.hasNext()) {
            animatorSetMo6080f.addListener(it.next());
        }
        animatorSetMo6080f.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        return (ViewCompat.isLaidOut(this) || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode();
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.extendStrategy).f11623c.add(animatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.hideStrategy).f11623c.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.showStrategy).f11623c.add(animatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.shrinkStrategy).f11623c.add(animatorListener);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i = this.collapsedSize;
        return i < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return ((BaseMotionStrategy) this.extendStrategy).f11626f;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return ((BaseMotionStrategy) this.hideStrategy).f11626f;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return ((BaseMotionStrategy) this.showStrategy).f11626f;
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return ((BaseMotionStrategy) this.shrinkStrategy).f11626f;
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.mo6113c();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.extendStrategy).f11623c.remove(animatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.hideStrategy).f11623c.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.showStrategy).f11623c.remove(animatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ((BaseMotionStrategy) this.shrinkStrategy).f11623c.remove(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.animateShowBeforeLayout = z2;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.extendStrategy).f11626f = motionSpec;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z2) {
        if (this.isExtended == z2) {
            return;
        }
        MotionStrategy motionStrategy = z2 ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.mo6114d()) {
            return;
        }
        motionStrategy.mo6113c();
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.hideStrategy).f11626f = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = i;
        this.extendedPaddingEnd = i3;
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.showStrategy).f11626f = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        ((BaseMotionStrategy) this.shrinkStrategy).f11626f = motionSpec;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void silentlyUpdateTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.extendStrategy, onChangedCallback);
    }

    public void hide(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.hideStrategy, onChangedCallback);
    }

    public void show(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.showStrategy, onChangedCallback);
    }

    public void shrink(@NonNull OnChangedCallback onChangedCallback) {
        performMotion(this.shrinkStrategy, onChangedCallback);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.animState = 0;
        AnimatorTracker animatorTracker = new AnimatorTracker();
        this.changeVisibilityTracker = animatorTracker;
        C10917j c10917j = new C10917j(animatorTracker);
        this.showStrategy = c10917j;
        C10916i c10916i = new C10916i(animatorTracker);
        this.hideStrategy = c10916i;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context context2 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C10817R.styleable.ExtendedFloatingActionButton, i, i2, new int[0]);
        MotionSpec motionSpecCreateFromAttribute = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec motionSpecCreateFromAttribute2 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec motionSpecCreateFromAttribute3 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec motionSpecCreateFromAttribute4 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, C10817R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10817R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        AnimatorTracker animatorTracker2 = new AnimatorTracker();
        C10915h c10915h = new C10915h(animatorTracker2, new C10908a(), true);
        this.extendStrategy = c10915h;
        C10915h c10915h2 = new C10915h(animatorTracker2, new C10909b(), false);
        this.shrinkStrategy = c10915h2;
        c10917j.f11626f = motionSpecCreateFromAttribute;
        c10916i.f11626f = motionSpecCreateFromAttribute2;
        c10915h.f11626f = motionSpecCreateFromAttribute3;
        c10915h2.f11626f = motionSpecCreateFromAttribute4;
        typedArrayObtainStyledAttributes.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, i, i2, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }
}
