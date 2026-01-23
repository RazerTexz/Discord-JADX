package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel;
import com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Func7;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel3 extends Lambda implements Function0<Observable<WidgetGuildsListViewModel.Companion.SecondChunk>> {
    public static final WidgetGuildsListViewModel3 INSTANCE = new WidgetGuildsListViewModel3();

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$2$1 */
    /* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
    public static final class C87551<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends GuildJoinRequest>, Map<Long, ? extends Guild>, Set<? extends Long>, Set<? extends Long>, Set<? extends Long>, Map<Long, ? extends Channel>, Boolean, WidgetGuildsListViewModel.Companion.SecondChunk> {
        public static final C87551 INSTANCE = new C87551();

        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.Companion.SecondChunk call(Map<Long, ? extends GuildJoinRequest> map, Map<Long, ? extends Guild> map2, Set<? extends Long> set, Set<? extends Long> set2, Set<? extends Long> set3, Map<Long, ? extends Channel> map3, Boolean bool) {
            return call2((Map<Long, GuildJoinRequest>) map, (Map<Long, Guild>) map2, (Set<Long>) set, (Set<Long>) set2, (Set<Long>) set3, (Map<Long, Channel>) map3, bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetGuildsListViewModel.Companion.SecondChunk call2(Map<Long, GuildJoinRequest> map, Map<Long, Guild> map2, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map3, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(map, "guildJoinRequests");
            ArrayList arrayList = new ArrayList(map2.values());
            Intrinsics3.checkNotNullExpressionValue(set, "guildIds");
            Intrinsics3.checkNotNullExpressionValue(set2, "guildIdsWithActiveStageEvents");
            Intrinsics3.checkNotNullExpressionValue(set3, "guildIdsWithActiveScheduledEvents");
            Intrinsics3.checkNotNullExpressionValue(map3, "channels");
            return new WidgetGuildsListViewModel.Companion.SecondChunk(map, arrayList, set, set2, set3, map3, !bool.booleanValue());
        }
    }

    public WidgetGuildsListViewModel3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Observable<WidgetGuildsListViewModel.Companion.SecondChunk> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Observable<WidgetGuildsListViewModel.Companion.SecondChunk> invoke2() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<WidgetGuildsListViewModel.Companion.SecondChunk> observableM11069e = Observable.m11069e(companion.getGuildJoinRequests().observeGuildJoinRequests(), companion.getGuildJoinRequests().observePendingGuilds(), companion.getGuilds().observeGuildIds(), GuildIdsWithVisibleStageInstanceModel.observe$default(GuildIdsWithVisibleStageInstanceModel.INSTANCE, null, null, null, 7, null), GuildIdsWithActiveEventsModel.observe$default(GuildIdsWithActiveEventsModel.INSTANCE, null, null, 3, null), companion.getChannels().observeGuildAndPrivateChannels(), companion.getDirectories().observeDiscordHubClicked(), C87551.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11069e, "Observable.combineLatest…ked\n          )\n        }");
        return observableM11069e;
    }
}
