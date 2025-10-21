package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel;
import com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.functions.Func7;

/* compiled from: WidgetGuildsListViewModel.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel3 extends Lambda implements Function0<Observable<WidgetGuildsListViewModel.Companion.SecondChunk>> {
    public static final WidgetGuildsListViewModel3 INSTANCE = new WidgetGuildsListViewModel3();

    /* compiled from: WidgetGuildsListViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends GuildJoinRequest>, Map<Long, ? extends Guild>, Set<? extends Long>, Set<? extends Long>, Set<? extends Long>, Map<Long, ? extends Channel>, Boolean, WidgetGuildsListViewModel.Companion.SecondChunk> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.Companion.SecondChunk call(Map<Long, ? extends GuildJoinRequest> map, Map<Long, ? extends Guild> map2, Set<? extends Long> set, Set<? extends Long> set2, Set<? extends Long> set3, Map<Long, ? extends Channel> map3, Boolean bool) {
            return call2((Map<Long, GuildJoinRequest>) map, (Map<Long, Guild>) map2, (Set<Long>) set, (Set<Long>) set2, (Set<Long>) set3, (Map<Long, Channel>) map3, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
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
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Observable<WidgetGuildsListViewModel.Companion.SecondChunk> invoke2() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<WidgetGuildsListViewModel.Companion.SecondChunk> observableE = Observable.e(companion.getGuildJoinRequests().observeGuildJoinRequests(), companion.getGuildJoinRequests().observePendingGuilds(), companion.getGuilds().observeGuildIds(), GuildIdsWithVisibleStageInstanceModel.observe$default(GuildIdsWithVisibleStageInstanceModel.INSTANCE, null, null, null, 7, null), GuildIdsWithActiveEventsModel.observe$default(GuildIdsWithActiveEventsModel.INSTANCE, null, null, 3, null), companion.getChannels().observeGuildAndPrivateChannels(), companion.getDirectories().observeDiscordHubClicked(), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableE, "Observable.combineLatest…ked\n          )\n        }");
        return observableE;
    }
}
