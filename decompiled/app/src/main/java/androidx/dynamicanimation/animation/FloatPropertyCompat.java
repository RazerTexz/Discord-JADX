package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    public final String mPropertyName;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1 */
    public static class C03411 extends FloatPropertyCompat<T> {
        public final /* synthetic */ FloatProperty val$property;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03411(String str, FloatProperty floatProperty) {
            super(str);
            this.val$property = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(T t) {
            return ((Float) this.val$property.get(t)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(T t, float f) {
            this.val$property.setValue(t, f);
        }
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new C03411(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
