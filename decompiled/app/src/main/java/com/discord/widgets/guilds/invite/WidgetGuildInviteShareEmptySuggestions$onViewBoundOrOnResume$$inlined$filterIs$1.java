package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import j0.k.Func1;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1<T, R> implements Func1<Object, Boolean> {
    public static final WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1 INSTANCE = new WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
