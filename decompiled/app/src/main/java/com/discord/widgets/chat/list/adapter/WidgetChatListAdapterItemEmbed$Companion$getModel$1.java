package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Companion$getModel$1<T1, T2, R> implements Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>> {
    public static final WidgetChatListAdapterItemEmbed$Companion$getModel$1 INSTANCE = new WidgetChatListAdapterItemEmbed$Companion$getModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
        return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
        m.checkNotNullExpressionValue(map, "members");
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
            m.checkNotNull(nick);
            map3.put(key, nick);
        }
        return map3;
    }
}
