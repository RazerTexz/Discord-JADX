package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import java.util.Map;
import p507d0.p580t.CollectionsJVM;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel2<T, R> implements Func1<MeUser, Observable<? extends GuildMember>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetChangeGuildIdentityViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1$1 */
    public static final class C87741<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ MeUser $me;

        public C87741(MeUser meUser) {
            this.$me = meUser;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$me.getId()));
        }
    }

    public WidgetChangeGuildIdentityViewModel2(long j) {
        this.$guildId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GuildMember> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildMember> call2(MeUser meUser) {
        return StoreStream.INSTANCE.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).m11083G(new C87741(meUser));
    }
}
