package com.discord.utilities.view.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleableRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions3;
import com.discord.utilities.view.text.TextWatcher4;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.SpreadBuilder;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes2.dex */
public final class ViewExtensions {
    private static final long DEFAULT_FADE_MILLIS_RES = 350;
    private static final long HINT_DELAY_MILLIS = 250;
    private static final HashMap<View, ViewExtensions3> fadeAnimations = new HashMap<>();

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnHeightChangedListener$1 */
    public static final class ViewOnLayoutChangeListenerC69891 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function2 $onHeightChanged;

        public ViewOnLayoutChangeListenerC69891(Function2 function2) {
            this.$onHeightChanged = function2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i4 - i2;
            int i10 = i8 - i6;
            if (i9 != i10) {
                this.$onHeightChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnSizeChangedListener$1 */
    public static final class ViewOnLayoutChangeListenerC69901 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function4 $onSizeChanged;

        public ViewOnLayoutChangeListenerC69901(Function4 function4) {
            this.$onSizeChanged = function4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            int i11 = i7 - i5;
            int i12 = i8 - i6;
            if (i9 == i11 && i10 == i12) {
                return;
            }
            this.$onSizeChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(i12));
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnWidthChangedListener$1 */
    public static final class ViewOnLayoutChangeListenerC69911 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function2 $onWidthChanged;

        public ViewOnLayoutChangeListenerC69911(Function2 function2) {
            this.$onWidthChanged = function2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i7 - i5;
            if (i9 != i10) {
                this.$onWidthChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$1 */
    public static final class C69921 extends Lambda implements Function1<View, Unit> {
        public static final C69921 INSTANCE = new C69921();

        public C69921() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$2 */
    public static final class C69932 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final C69932 INSTANCE = new C69932();

        public C69932() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$3 */
    public static final class C69943 extends Lambda implements Function0<Unit> {
        public static final C69943 INSTANCE = new C69943();

        public C69943() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeOut$1 */
    public static final class C69951 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final C69951 INSTANCE = new C69951();

        public C69951() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeOut$2 */
    public static final class C69962 extends Lambda implements Function0<Unit> {
        public static final C69962 INSTANCE = new C69962();

        public C69962() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$hintWithRipple$1 */
    public static final class RunnableC69971 implements Runnable {
        public final /* synthetic */ View $this_hintWithRipple;

        public RunnableC69971(View view) {
            this.$this_hintWithRipple = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$this_hintWithRipple.setPressed(true);
            this.$this_hintWithRipple.setPressed(false);
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$i18nSetText$1 */
    public static final class C69981 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C69981 INSTANCE = new C69981();

        public C69981() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$interceptScrollWhenInsideScrollable$1 */
    public static final class ViewOnTouchListenerC69991 implements View.OnTouchListener {
        public static final ViewOnTouchListenerC69991 INSTANCE = new ViewOnTouchListenerC69991();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            if (!view.isFocused()) {
                return false;
            }
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setForwardingWindowInsetsListener$1 */
    public static final class C70011 implements OnApplyWindowInsetsListener {
        public static final C70011 INSTANCE = new C70011();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (view instanceof ViewGroup) {
                Iterator<View> it = androidx.core.view.ViewGroup.getChildren((ViewGroup) view).iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
                }
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setOnImeActionDone$1 */
    public static final class C70021 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ boolean $isEventConsumed;
        public final /* synthetic */ Function1 $onImeActionDone;
        public final /* synthetic */ TextInputLayout $this_setOnImeActionDone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70021(TextInputLayout textInputLayout, Function1 function1, boolean z2) {
            super(3);
            this.$this_setOnImeActionDone = textInputLayout;
            this.$onImeActionDone = function1;
            this.$isEventConsumed = z2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (i == 6) {
                if (ViewExtensions.getTextOrEmpty(this.$this_setOnImeActionDone).length() > 0) {
                    this.$onImeActionDone.invoke(textView);
                }
            }
            return this.$isEventConsumed;
        }
    }

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setOnLongClickListenerConsumeClick$1 */
    public static final class ViewOnLongClickListenerC70031 implements View.OnLongClickListener {
        public final /* synthetic */ Function1 $onLongClick;

        public ViewOnLongClickListenerC70031(Function1 function1) {
            this.$onLongClick = function1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Function1 function1 = this.$onLongClick;
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            function1.invoke(view);
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    parent = null;
                    break;
                }
                if (parent instanceof RecyclerView) {
                    break;
                }
                parent = parent.getParent();
            }
            RecyclerView recyclerView = (RecyclerView) parent;
            if (recyclerView == null) {
                return true;
            }
            RecyclerViewExtensions.ignoreCurrentTouch(recyclerView);
            return true;
        }
    }

    public static final /* synthetic */ HashMap access$getFadeAnimations$p() {
        return fadeAnimations;
    }

    public static final Unit addBindedTextWatcher(TextInputLayout textInputLayout, Fragment fragment, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "onAfterTextChanged");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        TextWatcher4.addBindedTextWatcher(editText, fragment, function1);
        return Unit.f27425a;
    }

    public static final void addOnHeightChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnHeightChangedListener");
        Intrinsics3.checkNotNullParameter(function2, "onHeightChanged");
        view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC69891(function2));
    }

    public static final void addOnSizeChangedListener(View view, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnSizeChangedListener");
        Intrinsics3.checkNotNullParameter(function4, "onSizeChanged");
        view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC69901(function4));
    }

    public static final void addOnWidthChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnWidthChangedListener");
        Intrinsics3.checkNotNullParameter(function2, "onWidthChanged");
        view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC69911(function2));
    }

    public static final void cancelFadeAnimations(View view) {
        ViewPropertyAnimator viewPropertyAnimator;
        Intrinsics3.checkNotNullParameter(view, "$this$cancelFadeAnimations");
        ViewExtensions3 viewExtensions3Remove = fadeAnimations.remove(view);
        if (viewExtensions3Remove == null || (viewPropertyAnimator = viewExtensions3Remove.getViewPropertyAnimator()) == null) {
            return;
        }
        viewPropertyAnimator.cancel();
    }

    public static final Unit clear(TextInputLayout textInputLayout) {
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$clear");
        EditText editText = textInputLayout.getEditText();
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        text.clear();
        return Unit.f27425a;
    }

    public static final void disable(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$disable");
        view.setEnabled(false);
    }

    public static final void enable(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$enable");
        view.setEnabled(true);
    }

    public static final void fadeBy(View view, boolean z2) {
        fadeBy$default(view, z2, 0L, 2, null);
    }

    public static final void fadeBy(View view, boolean z2, long j) {
        if (z2) {
            fadeIn$default(view, j, null, null, null, 14, null);
        } else {
            fadeOut$default(view, j, null, null, 6, null);
        }
    }

    public static /* synthetic */ void fadeBy$default(View view, boolean z2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        fadeBy(view, z2, j);
    }

    @MainThread
    public static final void fadeIn(View view) {
        fadeIn$default(view, 0L, null, null, null, 15, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j) {
        fadeIn$default(view, j, null, null, null, 14, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1) {
        fadeIn$default(view, j, function1, null, null, 12, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function12) {
        fadeIn$default(view, j, function1, function12, null, 8, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function12, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function1, "setup");
        Intrinsics3.checkNotNullParameter(function12, "additionalAnimation");
        Intrinsics3.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, ViewExtensions3> map = fadeAnimations;
            ViewExtensions3 viewExtensions3 = map.get(view);
            ViewExtensions3.Type type = viewExtensions3 != null ? viewExtensions3.getType() : null;
            ViewExtensions3.Type type2 = ViewExtensions3.Type.FADE_IN;
            if (type == type2) {
                return;
            }
            if (viewExtensions3 != null) {
                map.remove(view);
                viewExtensions3.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                view.setAlpha(1.0f);
                return;
            }
            view.setAlpha(0.0f);
            function1.invoke(view);
            view.setVisibility(0);
            ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(1.0f);
            function12.invoke(viewPropertyAnimatorAlpha);
            ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions4(function0)).setListener(new ViewExtensions2(view));
            Intrinsics3.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
            map.put(view, new ViewExtensions3(listener, type2));
            listener.start();
        }
    }

    public static /* synthetic */ void fadeIn$default(View view, long j, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            function1 = C69921.INSTANCE;
        }
        Function1 function13 = function1;
        if ((i & 4) != 0) {
            function12 = C69932.INSTANCE;
        }
        Function1 function14 = function12;
        if ((i & 8) != 0) {
            function0 = C69943.INSTANCE;
        }
        fadeIn(view, j2, function13, function14, function0);
    }

    @MainThread
    public static final void fadeOut(View view) {
        fadeOut$default(view, 0L, null, null, 7, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j) {
        fadeOut$default(view, j, null, null, 6, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1) {
        fadeOut$default(view, j, function1, null, 4, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function1, "additionalAnimation");
        Intrinsics3.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, ViewExtensions3> map = fadeAnimations;
            ViewExtensions3 viewExtensions3 = map.get(view);
            ViewExtensions3.Type type = viewExtensions3 != null ? viewExtensions3.getType() : null;
            ViewExtensions3.Type type2 = ViewExtensions3.Type.FADE_OUT;
            if (type == type2) {
                return;
            }
            if (viewExtensions3 != null) {
                map.remove(view);
                viewExtensions3.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(0.0f);
                function1.invoke(viewPropertyAnimatorAlpha);
                ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions5(view, function0)).setListener(new ViewExtensions2(view));
                Intrinsics3.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
                map.put(view, new ViewExtensions3(listener, type2));
                listener.start();
            }
        }
    }

    public static /* synthetic */ void fadeOut$default(View view, long j, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        if ((i & 2) != 0) {
            function1 = C69951.INSTANCE;
        }
        if ((i & 4) != 0) {
            function0 = C69962.INSTANCE;
        }
        fadeOut(view, j, function1, function0);
    }

    public static final /* synthetic */ <T extends ViewParent> T findParent(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findParent");
        T t = (T) view.getParent();
        if (t == null) {
            return null;
        }
        Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final View getContentView(NestedScrollView nestedScrollView) {
        Intrinsics3.checkNotNullParameter(nestedScrollView, "$this$getContentView");
        View childAt = nestedScrollView.getChildAt(0);
        Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        return childAt;
    }

    public static final String getTextOrEmpty(TextInputLayout textInputLayout) {
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$getTextOrEmpty");
        EditText editText = textInputLayout.getEditText();
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        return string != null ? string : "";
    }

    public static final void hintWithRipple(View view, long j) {
        Intrinsics3.checkNotNullParameter(view, "$this$hintWithRipple");
        view.setPressed(true);
        view.setPressed(false);
        view.postDelayed(new RunnableC69971(view), j);
    }

    public static /* synthetic */ void hintWithRipple$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = HINT_DELAY_MILLIS;
        }
        hintWithRipple(view, j);
    }

    public static final void i18nSetText(TextInputLayout textInputLayout, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            FormatUtils.m221m(editText, i, Arrays.copyOf(objArr, objArr.length), function1);
        }
    }

    public static /* synthetic */ void i18nSetText$default(TextInputLayout textInputLayout, int i, Object[] objArr, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = C69981.INSTANCE;
        }
        i18nSetText(textInputLayout, i, objArr, function1);
    }

    public static final void interceptScrollWhenInsideScrollable(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$interceptScrollWhenInsideScrollable");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnTouchListener(ViewOnTouchListenerC69991.INSTANCE);
        }
    }

    public static final void moveCursorToEnd(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$moveCursorToEnd");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setSelection(editText.getText().toString().length());
        }
    }

    public static final void setBackgroundAndKeepPadding(View view, Drawable drawable) {
        Intrinsics3.checkNotNullParameter(view, "$this$setBackgroundAndKeepPadding");
        view.setBackground(drawable);
    }

    public static final void setCompoundDrawableWithIntrinsicBounds(TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawableWithIntrinsicBounds");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void setCompoundDrawableWithIntrinsicBounds$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawableWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    public static final void setEnabledAlpha(View view, boolean z2, float f) {
        Intrinsics3.checkNotNullParameter(view, "$this$setEnabledAlpha");
        if (z2) {
            f = 1.0f;
        }
        view.setAlpha(f);
    }

    public static /* synthetic */ void setEnabledAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAlpha(view, z2, f);
    }

    public static final void setEnabledAndAlpha(View view, boolean z2, float f) {
        Intrinsics3.checkNotNullParameter(view, "$this$setEnabledAndAlpha");
        view.setEnabled(z2);
        setEnabledAlpha(view, z2, f);
    }

    public static /* synthetic */ void setEnabledAndAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAndAlpha(view, z2, f);
    }

    public static final void setForwardingWindowInsetsListener(ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "$this$setForwardingWindowInsetsListener");
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, C70011.INSTANCE);
    }

    public static final void setHint(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setHint");
        textInputLayout.setHint(textInputLayout.getContext().getString(i));
    }

    public static final Unit setOnEditTextClickListener(TextInputLayout textInputLayout, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditTextClickListener");
        Intrinsics3.checkNotNullParameter(function1, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnClickListener(new ViewExtensions6(function1));
        return Unit.f27425a;
    }

    public static final void setOnEditTextFocusChangeListener(TextInputLayout textInputLayout, View.OnFocusChangeListener onFocusChangeListener) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditTextFocusChangeListener");
        Intrinsics3.checkNotNullParameter(onFocusChangeListener, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public static final Unit setOnEditorActionListener(TextInputLayout textInputLayout, Function3<? super TextView, ? super Integer, ? super KeyEvent, Boolean> function3) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditorActionListener");
        Intrinsics3.checkNotNullParameter(function3, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnEditorActionListener(new ViewExtensions7(function3));
        return Unit.f27425a;
    }

    public static final Unit setOnImeActionDone(TextInputLayout textInputLayout, boolean z2, Function1<? super TextView, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnImeActionDone");
        Intrinsics3.checkNotNullParameter(function1, "onImeActionDone");
        return setOnEditorActionListener(textInputLayout, new C70021(textInputLayout, function1, z2));
    }

    public static /* synthetic */ Unit setOnImeActionDone$default(TextInputLayout textInputLayout, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return setOnImeActionDone(textInputLayout, z2, function1);
    }

    public static final void setOnLongClickListenerConsumeClick(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$setOnLongClickListenerConsumeClick");
        Intrinsics3.checkNotNullParameter(function1, "onLongClick");
        view.setOnLongClickListener(new ViewOnLongClickListenerC70031(function1));
    }

    public static final void setPluralText(TextView textView, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setPluralText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Resources resources = textView.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(Integer.valueOf(i2));
        spreadBuilder.addSpread(objArr);
        textView.setText(StringResourceUtils.getQuantityString(resources, context, i, i2, spreadBuilder.toArray(new Object[spreadBuilder.size()])));
    }

    public static final void setProgrammaticChecked(CompoundButton compoundButton, boolean z2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics3.checkNotNullParameter(compoundButton, "$this$setProgrammaticChecked");
        Intrinsics3.checkNotNullParameter(onCheckedChangeListener, "listener");
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z2);
        compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public static final Unit setSelection(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSelection");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setSelection(i);
        return Unit.f27425a;
    }

    public static final Unit setSelectionEnd(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSelectionEnd");
        EditText editText = textInputLayout.getEditText();
        return setSelection(textInputLayout, editText != null ? editText.length() : 0);
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        String string = textInputLayout.getContext().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(resId)");
        setSingleLineHint(textInputLayout, string);
    }

    public static final Unit setText(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(i);
        return Unit.f27425a;
    }

    public static final void setTextAndVisibilityBy(TextView textView, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setTextAndVisibilityBy");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || StringsJVM.isBlank(charSequence)) ^ true ? 0 : 8);
    }

    public static final void setTextIfDifferent(TextInputLayout textInputLayout, CharSequence charSequence) {
        EditText editText;
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setTextIfDifferent");
        EditText editText2 = textInputLayout.getEditText();
        if (!(!Intrinsics3.areEqual((editText2 == null || (text = editText2.getText()) == null) ? null : text.toString(), charSequence)) || (editText = textInputLayout.getEditText()) == null) {
            return;
        }
        editText.setText(charSequence);
    }

    public static final void useAttrs(View view, AttributeSet attributeSet, @StyleableRes int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$useAttrs");
        Intrinsics3.checkNotNullParameter(iArr, "styleable");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        Intrinsics3.checkNotNullParameter(charSequence, "charSequence");
        textInputLayout.setHintEnabled(false);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }

    public static final Unit setText(TextInputLayout textInputLayout, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(charSequence);
        return Unit.f27425a;
    }
}
