package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$1 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8681xef41c609<T, R> implements Func1<Object, Boolean> {
    public static final C8681xef41c609 INSTANCE = new C8681xef41c609();

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
