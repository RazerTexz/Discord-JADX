package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func8;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel3<T, R> implements Func1<Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>, Observable<? extends WidgetHomeModel>> {
    public static final WidgetHomeModel3 INSTANCE = new WidgetHomeModel3();

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$2$1 */
    /* JADX INFO: compiled from: WidgetHomeModel.kt */
    public static final class C89731<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        public C89731(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // p658rx.functions.Func8
        public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
            return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
            boolean z2;
            User userM7677a;
            User userM7677a2;
            Channel channel3 = this.$channel;
            if (channel3 != null && ChannelUtils.m7667B(channel3)) {
                Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
                Channel channel4 = this.$channel;
                if (Intrinsics3.areEqual(lValueOf, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selectedChannel");
            Channel channel5 = this.$channel;
            Presence presence = (channel5 == null || (userM7677a2 = ChannelUtils.m7677a(channel5)) == null) ? null : (Presence) outline.m849f(userM7677a2, map);
            Intrinsics3.checkNotNullExpressionValue(num, "unreadCount");
            int iIntValue = num.intValue();
            Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
            Channel channel6 = this.$channel;
            boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userM7677a = ChannelUtils.m7677a(channel6)) == null) ? null : Long.valueOf(userM7677a.getId())), 1);
            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
            int size = map3.size();
            Intrinsics3.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
            return new WidgetHomeModel(resolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeModel> call(Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
        return call2((Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>) tuples2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeModel> call2(Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
        Long lValueOf;
        long id2;
        Long lComponent1 = tuples2.component1();
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannelComponent2 = tuples2.component2();
        Channel maybeChannel = resolvedSelectedChannelComponent2.getMaybeChannel();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        Observable<Map<Long, Presence>> observableObserveAllPresences = companion.getPresences().observeAllPresences();
        Observable<Channel> observableObserveSelectedChannel = companion.getVoiceChannelSelected().observeSelectedChannel();
        Observable<Integer> observableObserveTotalMentions = companion.getMentions().observeTotalMentions();
        Observable<Map<Long, Integer>> observableObserve = companion.getUserRelationships().observe();
        StoreThreadsActive threadsActive = companion.getThreadsActive();
        Intrinsics3.checkNotNullExpressionValue(lComponent1, "selectedGuildId");
        long jLongValue = lComponent1.longValue();
        if (maybeChannel != null && ChannelUtils.m7673H(maybeChannel)) {
            id2 = maybeChannel.getParentId();
        } else {
            if (maybeChannel == null) {
                lValueOf = null;
                return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new C89731(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
            }
            id2 = maybeChannel.getId();
        }
        lValueOf = Long.valueOf(id2);
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new C89731(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
    }
}
