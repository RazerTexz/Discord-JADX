package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$getModel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed3<T1, T2, R> implements Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>> {
    public static final WidgetChatListAdapterItemEmbed3 INSTANCE = new WidgetChatListAdapterItemEmbed3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
        return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
        Intrinsics3.checkNotNullExpressionValue(map, "members");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, GuildMember> entry : map.entrySet()) {
            if (entry.getValue().getNick() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        HashMap<Long, String> map3 = new HashMap<>(map2);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            String nick = ((GuildMember) entry2.getValue()).getNick();
            Intrinsics3.checkNotNull(nick);
            map3.put(key, nick);
        }
        return map3;
    }
}
