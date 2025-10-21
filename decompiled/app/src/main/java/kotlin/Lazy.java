package kotlin;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
