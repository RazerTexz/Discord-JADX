package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KProperty {

    /* compiled from: KProperty.kt */
    public interface Setter<V> extends KMutableProperty$Setter<V>, Function1<V, Unit> {
    }

    /* renamed from: getSetter */
    Setter<V> mo113getSetter();
}
