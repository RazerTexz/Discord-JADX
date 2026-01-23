package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
import java.util.Objects;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2 */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8850xa5572e8e<T, R> implements Func1<Object, T> {
    public static final C8850xa5572e8e INSTANCE = new C8850xa5572e8e();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded");
        return (T) ((WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded) obj);
    }
}
