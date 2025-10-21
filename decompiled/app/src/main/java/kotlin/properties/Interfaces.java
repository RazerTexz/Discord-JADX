package kotlin.properties;

import androidx.exifinterface.media.ExifInterface;
import kotlin.reflect.KProperty;

/* compiled from: Interfaces.kt */
/* renamed from: kotlin.properties.ReadWriteProperty, reason: use source file name */
/* loaded from: classes3.dex */
public interface Interfaces<T, V> {
    V getValue(T thisRef, KProperty<?> property);

    void setValue(T thisRef, KProperty<?> property, V value);
}
