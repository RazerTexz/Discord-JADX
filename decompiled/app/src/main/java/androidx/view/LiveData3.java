package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;

/* compiled from: LiveData.kt */
/* renamed from: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1, reason: use source file name */
/* loaded from: classes.dex */
public final class LiveData3<T> implements Observer<T> {
    public final /* synthetic */ Function1 $onChanged;

    public LiveData3(Function1 function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
