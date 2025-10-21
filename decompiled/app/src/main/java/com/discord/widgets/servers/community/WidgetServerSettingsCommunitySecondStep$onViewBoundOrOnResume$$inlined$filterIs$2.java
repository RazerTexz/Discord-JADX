package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import j0.k.Func1;
import java.util.Objects;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2<T, R> implements Func1<Object, T> {
    public static final WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2 INSTANCE = new WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2();

    @Override // j0.k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
        return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
    }
}
