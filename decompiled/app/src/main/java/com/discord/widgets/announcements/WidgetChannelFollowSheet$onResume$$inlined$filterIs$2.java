package com.discord.widgets.announcements;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel;
import java.util.Objects;
import p637j0.p641k.Func1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$onResume$$inlined$filterIs$2<T, R> implements Func1<Object, T> {
    public static final WidgetChannelFollowSheet$onResume$$inlined$filterIs$2 INSTANCE = new WidgetChannelFollowSheet$onResume$$inlined$filterIs$2();

    @Override // p637j0.p641k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.announcements.WidgetChannelFollowSheetViewModel.ViewState.Loaded");
        return (T) ((WidgetChannelFollowSheetViewModel.ViewState.Loaded) obj);
    }
}
