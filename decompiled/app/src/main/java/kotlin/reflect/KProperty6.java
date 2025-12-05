package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* renamed from: kotlin.reflect.KProperty0, reason: use source file name */
/* loaded from: classes3.dex */
public interface KProperty6<V> extends KProperty<V>, Function0<V> {

    /* compiled from: KProperty.kt */
    /* renamed from: kotlin.reflect.KProperty0$Getter */
    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    V get();

    Object getDelegate();

    /* renamed from: getGetter */
    Getter<V> mo11489getGetter();
}
