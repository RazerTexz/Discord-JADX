package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1<T, R> implements Func1<Object, Boolean> {
    public static final WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1 INSTANCE = new WidgetGuildInviteShare$onViewBoundOrOnResume$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
