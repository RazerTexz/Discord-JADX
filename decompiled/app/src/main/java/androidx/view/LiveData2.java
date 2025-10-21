package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LiveData.kt */
/* renamed from: androidx.lifecycle.LiveDataKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LiveData2 {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, Function1<? super T, Unit> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$observe");
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics3.checkNotNullParameter(function1, "onChanged");
        LiveData3 liveData3 = new LiveData3(function1);
        liveData.observe(lifecycleOwner, liveData3);
        return liveData3;
    }
}
