package androidx.dynamicanimation.animation;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    public float mMaxValue;
    public float mMinValue;
    private float mMinVisibleChange;
    public final FloatPropertyCompat mProperty;
    public boolean mRunning;
    public boolean mStartValueIsSet;
    public final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    public float mValue;
    public float mVelocity;
    public static final ViewProperty TRANSLATION_X = new C03261(Key.TRANSLATION_X);
    public static final ViewProperty TRANSLATION_Y = new C03332(Key.TRANSLATION_Y);
    public static final ViewProperty TRANSLATION_Z = new C03343(Key.TRANSLATION_Z);
    public static final ViewProperty SCALE_X = new C03354(Key.SCALE_X);
    public static final ViewProperty SCALE_Y = new C03365(Key.SCALE_Y);
    public static final ViewProperty ROTATION = new C03376(Key.ROTATION);
    public static final ViewProperty ROTATION_X = new C03387(Key.ROTATION_X);
    public static final ViewProperty ROTATION_Y = new C03398(Key.ROTATION_Y);

    /* renamed from: X */
    public static final ViewProperty f139X = new C03409("x");

    /* renamed from: Y */
    public static final ViewProperty f140Y = new C032710("y");

    /* renamed from: Z */
    public static final ViewProperty f141Z = new C032811("z");
    public static final ViewProperty ALPHA = new C032912(Key.ALPHA);
    public static final ViewProperty SCROLL_X = new C033013("scrollX");
    public static final ViewProperty SCROLL_Y = new C033114("scrollY");

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1 */
    public static class C03261 extends ViewProperty {
        public C03261(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$10 */
    public static class C032710 extends ViewProperty {
        public C032710(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$11 */
    public static class C032811 extends ViewProperty {
        public C032811(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getZ(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$12 */
    public static class C032912 extends ViewProperty {
        public C032912(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getAlpha();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setAlpha(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$13 */
    public static class C033013 extends ViewProperty {
        public C033013(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$14 */
    public static class C033114 extends ViewProperty {
        public C033114(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15 */
    public class C033215 extends FloatPropertyCompat {
        public final /* synthetic */ FloatValueHolder val$floatValueHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C033215(String str, FloatValueHolder floatValueHolder) {
            super(str);
            this.val$floatValueHolder = floatValueHolder;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(Object obj) {
            return this.val$floatValueHolder.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(Object obj, float f) {
            this.val$floatValueHolder.setValue(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$2 */
    public static class C03332 extends ViewProperty {
        public C03332(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$3 */
    public static class C03343 extends ViewProperty {
        public C03343(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$4 */
    public static class C03354 extends ViewProperty {
        public C03354(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$5 */
    public static class C03365 extends ViewProperty {
        public C03365(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$6 */
    public static class C03376 extends ViewProperty {
        public C03376(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotation();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotation(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$7 */
    public static class C03387 extends ViewProperty {
        public C03387(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$8 */
    public static class C03398 extends ViewProperty {
        public C03398(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$9 */
    public static class C03409 extends ViewProperty {
        public C03409(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setX(f);
        }
    }

    public static class MassState {
        public float mValue;
        public float mVelocity;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public /* synthetic */ ViewProperty(String str, C03261 c03261) {
            this(str);
        }

        private ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new C033215("FloatValueHolder", floatValueHolder);
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z2) {
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z2, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int iIndexOf = arrayList.indexOf(t);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        if (!this.mStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        float f = this.mValue;
        if (f > this.mMaxValue || f < this.mMinValue) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    @MainThread
    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j) {
        long j2 = this.mLastFrameTime;
        if (j2 == 0) {
            this.mLastFrameTime = j;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j;
        boolean zUpdateValueAndVelocity = updateValueAndVelocity(j - j2);
        float fMin = Math.min(this.mValue, this.mMaxValue);
        this.mValue = fMin;
        float fMax = Math.max(fMin, this.mMinValue);
        this.mValue = fMax;
        setPropertyValue(fMax);
        if (zUpdateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return zUpdateValueAndVelocity;
    }

    public abstract float getAcceleration(float f, float f2);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f, float f2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(f * 0.75f);
        return this;
    }

    public void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    public abstract void setValueThreshold(float f);

    @MainThread
    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mRunning) {
            return;
        }
        startAnimationInternal();
    }

    public abstract boolean updateValueAndVelocity(long j);

    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.mMinVisibleChange = 0.00390625f;
                return;
            } else if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = 0.00390625f;
                return;
            }
        }
        this.mMinVisibleChange = 0.1f;
    }
}
