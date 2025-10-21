package com.discord.custom_tabs;

import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import b.a.h.CustomTabsPackages;
import b.a.h.CustomTabsPackages2;
import b.a.h.CustomTabsService2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.List;
import y.c.DefaultLifecycleObserver2;

/* compiled from: CustomTabs.kt */
/* renamed from: com.discord.custom_tabs.CustomTabs$warmUp$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CustomTabs2 implements DefaultLifecycleObserver {

    /* renamed from: j, reason: from kotlin metadata */
    public CustomTabsServiceConnection connection;

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.a(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.b(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.c(this, owner);
        if (this.connection != null) {
            throw null;
        }
        this.connection = null;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.d(this, owner);
        CustomTabsService2 customTabsService2 = null;
        List list = _Arrays.toList((Object[]) null);
        Intrinsics3.checkNotNullParameter(null, "context");
        Intrinsics3.checkNotNullParameter(list, "uris");
        String strA = CustomTabsPackages2.a.a(null, CustomTabsPackages.j);
        if (strA != null) {
            CustomTabsService2 customTabsService22 = new CustomTabsService2(list);
            if (CustomTabsClient.bindCustomTabsService(null, strA, customTabsService22)) {
                customTabsService2 = customTabsService22;
            }
        }
        this.connection = customTabsService2;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.e(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.f(this, lifecycleOwner);
    }
}
