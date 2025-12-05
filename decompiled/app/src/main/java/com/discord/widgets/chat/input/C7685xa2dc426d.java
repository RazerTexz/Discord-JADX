package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import java.util.Map;
import p637j0.p641k.Func1;

/* compiled from: ChatInputViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1 */
/* loaded from: classes2.dex */
public final class C7685xa2dc426d<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ long $originalAuthorId$inlined;

    public C7685xa2dc426d(long j) {
        this.$originalAuthorId$inlined = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, GuildMember> map) {
        return map.get(Long.valueOf(this.$originalAuthorId$inlined));
    }
}
