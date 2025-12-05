package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func7;

/* compiled from: WidgetChannelsListItemThreadActions.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelsListItemThreadActions.Model>> {
    public static final WidgetChannelsListItemThreadActions2 INSTANCE = new WidgetChannelsListItemThreadActions2();

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1$1 */
    public static final class C74611<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public final /* synthetic */ Channel $channel;

        public C74611(Channel channel) {
            this.$channel = channel;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            return Boolean.valueOf(outline.m845d(this.$channel, map) != null);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1$2 */
    public static final class C74622<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Guild, Long, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, Boolean, WidgetChannelsListItemThreadActions.Model> {
        public final /* synthetic */ Channel $channel;

        public C74622(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetChannelsListItemThreadActions.Model call(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
            return call2(meUser, channel, guild, l, map, joinedThread, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelsListItemThreadActions.Model call2(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
            NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
            boolean zIsGuildOrCategoryOrChannelMuted = notificationTextUtils.isGuildOrCategoryOrChannelMuted((ModelNotificationSettings) outline.m843c(this.$channel, map), channel);
            Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel((ModelNotificationSettings) outline.m843c(this.$channel, map), this.$channel, guild);
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            int iComputeThreadNotificationSetting = threadUtils.computeThreadNotificationSetting(joinedThread, zIsGuildOrCategoryOrChannelMuted, numChannelMessageNotificationLevel);
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            boolean zCanManageThread = threadUtils.canManageThread(meUser, this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
            boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
            boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
            boolean z2 = joinedThread != null && joinedThread.getMuted();
            Channel channel2 = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isActiveThread");
            return new WidgetChannelsListItemThreadActions.Model(meUser, channel2, guild, channel, iComputeThreadNotificationSetting, joinedThread, bool.booleanValue(), zIsThreadModerator, zCanManageThread, zCanUnarchiveThread, z2);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemThreadActions.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11069e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getPermissions().observePermissionsForChannel(channel.getParentId()), companion.getUserGuildSettings().observeGuildSettings(), companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getThreadsActive().observeActiveThreadsForGuild(channel.getGuildId()).m11083G(new C74611(channel)).m11112r(), new C74622(channel));
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemThreadActions.Model> call(Channel channel) {
        return call2(channel);
    }
}
