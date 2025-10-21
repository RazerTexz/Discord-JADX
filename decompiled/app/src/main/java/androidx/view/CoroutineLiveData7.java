package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.Job2;

/* compiled from: CoroutineLiveData.kt */
/* renamed from: androidx.lifecycle.LiveDataScope, reason: use source file name */
/* loaded from: classes.dex */
public interface CoroutineLiveData7<T> {
    Object emit(T t, Continuation<? super Unit> continuation);

    Object emitSource(LiveData<T> liveData, Continuation<? super Job2> continuation);

    T getLatestValue();
}
