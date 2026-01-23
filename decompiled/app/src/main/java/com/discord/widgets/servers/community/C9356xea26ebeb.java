package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Objects;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$$inlined$filterIs$2 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9356xea26ebeb<T, R> implements Func1<Object, T> {
    public static final C9356xea26ebeb INSTANCE = new C9356xea26ebeb();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
        return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
    }
}
