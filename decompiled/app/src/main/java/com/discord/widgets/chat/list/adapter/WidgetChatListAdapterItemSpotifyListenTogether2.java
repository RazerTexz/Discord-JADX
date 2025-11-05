package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether2<T1, T2, T3, R> implements Func3<Presence, Map<Long, ? extends User>, Long, WidgetChatListAdapterItemSpotifyListenTogether.Model> {
    public final /* synthetic */ SpotifyListenTogetherEntry $item;

    public WidgetChatListAdapterItemSpotifyListenTogether2(SpotifyListenTogetherEntry spotifyListenTogetherEntry) {
        this.$item = spotifyListenTogetherEntry;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether.Model call(Presence presence, Map<Long, ? extends User> map, Long l) {
        return call2(presence, map, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemSpotifyListenTogether.Model call2(Presence presence, Map<Long, ? extends User> map, Long l) {
        WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion companion = WidgetChatListAdapterItemSpotifyListenTogether.Model.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(map, "userMap");
        SpotifyListenTogetherEntry spotifyListenTogetherEntry = this.$item;
        return WidgetChatListAdapterItemSpotifyListenTogether.Model.Companion.access$create(companion, presence, map, spotifyListenTogetherEntry, l != null && l.longValue() == spotifyListenTogetherEntry.getUserId());
    }
}
