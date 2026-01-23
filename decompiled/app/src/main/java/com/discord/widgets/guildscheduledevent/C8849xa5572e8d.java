package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8849xa5572e8d<T, R> implements Func1<Object, Boolean> {
    public static final C8849xa5572e8d INSTANCE = new C8849xa5572e8d();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
