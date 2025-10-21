package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import d0.t.CollectionsJVM;
import j0.k.Func1;
import java.util.Map;
import rx.Observable;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel2<T, R> implements Func1<MeUser, Observable<? extends GuildMember>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetGuildProfileSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ MeUser $me;

        public AnonymousClass1(MeUser meUser) {
            this.$me = meUser;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$me.getId()));
        }
    }

    public WidgetGuildProfileSheetViewModel2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GuildMember> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildMember> call2(MeUser meUser) {
        return StoreStream.INSTANCE.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).G(new AnonymousClass1(meUser));
    }
}
