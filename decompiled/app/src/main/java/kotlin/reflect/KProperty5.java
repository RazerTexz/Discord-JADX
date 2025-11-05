package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: KProperty.kt */
/* renamed from: kotlin.reflect.KMutableProperty0, reason: use source file name */
/* loaded from: classes3.dex */
public interface KProperty5<V> extends KProperty6<V>, KProperty {

    /* compiled from: KProperty.kt */
    /* renamed from: kotlin.reflect.KMutableProperty0$Setter */
    public interface Setter<V> extends KProperty4<V>, Function1<V, Unit> {
    }

    /* renamed from: getSetter */
    Setter<V> mo113getSetter();
}
