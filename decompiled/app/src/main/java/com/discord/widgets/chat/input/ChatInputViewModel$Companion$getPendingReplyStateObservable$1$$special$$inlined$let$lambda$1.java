package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.Func1;
import java.util.Map;

/* compiled from: ChatInputViewModel.kt */
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ long $originalAuthorId$inlined;

    public ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1(long j) {
        this.$originalAuthorId$inlined = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, GuildMember> map) {
        return map.get(Long.valueOf(this.$originalAuthorId$inlined));
    }
}
