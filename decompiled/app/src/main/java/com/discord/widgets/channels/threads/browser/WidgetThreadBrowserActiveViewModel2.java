package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsActiveJoined;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel2<T, R> implements Func1<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>> {
    public static final WidgetThreadBrowserActiveViewModel2 INSTANCE = new WidgetThreadBrowserActiveViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map) {
        return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, Channel> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "threadMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((StoreThreadsActiveJoined.ActiveJoinedThread) entry.getValue()).getChannel());
        }
        return linkedHashMap;
    }
}
