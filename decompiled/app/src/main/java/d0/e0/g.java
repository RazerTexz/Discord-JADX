package d0.e0;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface g<T, V> extends KProperty<V>, Function1<T, V> {

    /* compiled from: KProperty.kt */
    public interface a<T, V> extends KProperty.Getter<V>, Function1<T, V> {
    }

    V get(T t);

    a<T, V> getGetter();
}
