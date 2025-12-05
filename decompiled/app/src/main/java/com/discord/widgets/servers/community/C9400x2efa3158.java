package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import p637j0.p641k.Func1;

/* compiled from: ObservableExtensions.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1 */
/* loaded from: classes2.dex */
public final class C9400x2efa3158<T, R> implements Func1<Object, Boolean> {
    public static final C9400x2efa3158 INSTANCE = new C9400x2efa3158();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
