package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.h.j.j */
/* loaded from: classes3.dex */
public interface InterfaceC3299j {
    /* renamed from: a */
    void mo4069a(@RecentlyNonNull String str, @RecentlyNonNull LifecycleCallback lifecycleCallback);

    @RecentlyNullable
    /* renamed from: d */
    <T extends LifecycleCallback> T mo4070d(@RecentlyNonNull String str, @RecentlyNonNull Class<T> cls);

    @RecentlyNonNull
    /* renamed from: e */
    Activity mo4071e();

    void startActivityForResult(@RecentlyNonNull Intent intent, int i);
}
