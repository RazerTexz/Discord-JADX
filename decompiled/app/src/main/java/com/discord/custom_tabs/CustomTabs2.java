package com.discord.custom_tabs;

import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import java.util.List;
import p007b.p008a.p024h.CustomTabsPackages;
import p007b.p008a.p024h.CustomTabsPackages2;
import p007b.p008a.p024h.CustomTabsService2;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p677y.p685c.DefaultLifecycleObserver2;

/* JADX INFO: renamed from: com.discord.custom_tabs.CustomTabs$warmUp$1, reason: use source file name */
/* JADX INFO: compiled from: CustomTabs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabs2 implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public CustomTabsServiceConnection connection;

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.m11359a(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.m11360b(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.m11361c(this, owner);
        if (this.connection != null) {
            throw null;
        }
        this.connection = null;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        Intrinsics3.checkNotNullParameter(owner, "owner");
        DefaultLifecycleObserver2.m11362d(this, owner);
        CustomTabsService2 customTabsService2 = null;
        List list = _Arrays.toList((Object[]) null);
        Intrinsics3.checkNotNullParameter(null, "context");
        Intrinsics3.checkNotNullParameter(list, "uris");
        String strM194a = CustomTabsPackages2.f652a.m194a(null, CustomTabsPackages.f651j);
        if (strM194a != null) {
            CustomTabsService2 customTabsService22 = new CustomTabsService2(list);
            if (CustomTabsClient.bindCustomTabsService(null, strM194a, customTabsService22)) {
                customTabsService2 = customTabsService22;
            }
        }
        this.connection = customTabsService2;
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.m11363e(this, lifecycleOwner);
    }

    @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver2.m11364f(this, lifecycleOwner);
    }
}
