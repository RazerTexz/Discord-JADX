package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Objects;
import p637j0.p641k.Func1;

/* compiled from: ObservableExtensions.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2 */
/* loaded from: classes2.dex */
public final class C9380x709831cd<T, R> implements Func1<Object, T> {
    public static final C9380x709831cd INSTANCE = new C9380x709831cd();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
        return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
    }
}
