package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetThreadStatusViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadsActiveJoined $storeThreadsActiveJoined;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1$1 */
    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
    public static final class C101161<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>>, Long, Channel, Boolean, WidgetThreadStatusViewModel.StoreState> {
        public final /* synthetic */ Channel $selectedChannel;

        public C101161(Channel channel) {
            this.$selectedChannel = channel;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetThreadStatusViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
            return call2((Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>) map, l, channel, bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetThreadStatusViewModel.StoreState call2(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Channel channel2 = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(channel2, "selectedChannel");
            boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel2, l);
            boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
            Intrinsics3.checkNotNullExpressionValue(map, "activeJoinedThreads");
            Channel channel3 = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
            return new WidgetThreadStatusViewModel.StoreState(map, channel3, channel, zCanUnarchiveThread, zIsThreadModerator, bool.booleanValue());
        }
    }

    public WidgetThreadStatusViewModel2(StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions, StoreChannels storeChannels, StoreExperiments storeExperiments) {
        this.$storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.$storePermissions = storePermissions;
        this.$storeChannels = storeChannels;
        this.$storeExperiments = storeExperiments;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadStatusViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadStatusViewModel.StoreState> call2(Channel channel) {
        return Observable.m11073h(this.$storeThreadsActiveJoined.observeActiveJoinedThreadsForGuild(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannels.observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), this.$storeExperiments, null, 4, null), new C101161(channel)).m11112r();
    }
}
