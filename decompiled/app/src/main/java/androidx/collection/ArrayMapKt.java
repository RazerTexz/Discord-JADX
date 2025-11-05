package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import kotlin.Pair;

/* compiled from: ArrayMap.kt */
/* loaded from: classes.dex */
public final class ArrayMapKt {
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    public static final <K, V> ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairArr) {
        m.checkParameterIsNotNull(pairArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairArr.length);
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
