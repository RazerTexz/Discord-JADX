package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import java.util.Map;
import kotlin.Tuples2;
import p658rx.functions.Func2;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel3<T1, T2, R> implements Func2<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>> {
    public static final WidgetThreadBrowserActiveViewModel3 INSTANCE = new WidgetThreadBrowserActiveViewModel3();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2) {
        return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Map<Long, Channel>, Map<Long, Channel>> call2(Map<Long, Channel> map, Map<Long, Channel> map2) {
        return new Tuples2<>(map, map2);
    }
}
