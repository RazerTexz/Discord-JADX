package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreGuildMemberCounts.kt */
/* loaded from: classes2.dex */
public final class StoreGuildMemberCounts extends StoreV2 {
    private final HashMap<Long, Integer> guildMemberCounts = new HashMap<>();
    private Map<Long, Integer> guildMemberCountsSnapshot = Maps6.emptyMap();

    /* compiled from: StoreGuildMemberCounts.kt */
    /* renamed from: com.discord.stores.StoreGuildMemberCounts$observeApproximateMemberCount$1 */
    public static final class C60321 extends Lambda implements Function0<Integer> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60321(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Integer num = (Integer) StoreGuildMemberCounts.access$getGuildMemberCountsSnapshot$p(StoreGuildMemberCounts.this).get(Long.valueOf(this.$guildId));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public static final /* synthetic */ Map access$getGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts) {
        return storeGuildMemberCounts.guildMemberCountsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts, Map map) {
        storeGuildMemberCounts.guildMemberCountsSnapshot = map;
    }

    public final int getApproximateMemberCount(long guildId) {
        Integer num = this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        if (guilds != null) {
            for (Guild guild : guilds) {
                this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
        markChanged();
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        this.guildMemberCounts.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        Integer num = this.guildMemberCounts.get(Long.valueOf(member.getGuildId()));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(member.getGuildId()), Integer.valueOf(num.intValue() + 1));
            markChanged();
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId) {
        if (this.guildMemberCounts.get(Long.valueOf(guildId)) != null) {
            this.guildMemberCounts.put(Long.valueOf(guildId), Integer.valueOf(r0.intValue() - 1));
            markChanged();
        }
    }

    public final Observable<Integer> observeApproximateMemberCount(long guildId) {
        Observable<Integer> observableM11112r = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60321(guildId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        try {
            this.guildMemberCountsSnapshot = new HashMap(this.guildMemberCounts);
        } catch (OutOfMemoryError e) {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("OOM in StoreGuildMemberCounts. size: ");
            sbM833U.append(this.guildMemberCounts.size());
            appLog.recordBreadcrumb(sbM833U.toString(), "StoreGuildMemberCounts");
            throw e;
        }
    }
}
