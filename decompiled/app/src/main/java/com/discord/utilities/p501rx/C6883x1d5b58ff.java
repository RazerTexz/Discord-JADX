package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppComponent;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6883x1d5b58ff<T, R> implements Func1<T, Boolean> {
    public final /* synthetic */ AppComponent $appComponent$inlined;

    public C6883x1d5b58ff(AppComponent appComponent) {
        this.$appComponent$inlined = appComponent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(T t) {
        FragmentActivity activity;
        return Boolean.valueOf((!((Fragment) this.$appComponent$inlined).isAdded() || ((Fragment) this.$appComponent$inlined).isRemoving() || (activity = ((Fragment) this.$appComponent$inlined).getActivity()) == null || activity.isFinishing()) ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
