package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppComponent;
import j0.k.Func1;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1<T, R> implements Func1<T, Boolean> {
    public final /* synthetic */ AppComponent $appComponent$inlined;

    public ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1(AppComponent appComponent) {
        this.$appComponent$inlined = appComponent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.Func1
    public final Boolean call(T t) {
        FragmentActivity activity;
        return Boolean.valueOf((!((Fragment) this.$appComponent$inlined).isAdded() || ((Fragment) this.$appComponent$inlined).isRemoving() || (activity = ((Fragment) this.$appComponent$inlined).getActivity()) == null || activity.isFinishing()) ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call((ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1<T, R>) obj);
    }
}
