package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import java.util.Objects;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$2 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8690x831ee7f7<T, R> implements Func1<Object, T> {
    public static final C8690x831ee7f7 INSTANCE = new C8690x831ee7f7();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.ViewState.Loaded");
        return (T) ((WidgetGuildInviteShareViewModel.ViewState.Loaded) obj);
    }
}
