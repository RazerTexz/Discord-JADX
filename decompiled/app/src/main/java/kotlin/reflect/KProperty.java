package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface KProperty<V> extends KCallable<V> {

    /* compiled from: KProperty.kt */
    public interface Getter<V> extends KFunction<V> {
    }

    boolean isConst();

    boolean isLateinit();
}
