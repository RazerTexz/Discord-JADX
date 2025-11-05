package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
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
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;
import rx.functions.Func8;

/* compiled from: WidgetHomeModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHomeModel$Companion$get$2<T, R> implements b<Pair<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>, Observable<? extends WidgetHomeModel>> {
    public static final WidgetHomeModel$Companion$get$2 INSTANCE = new WidgetHomeModel$Companion$get$2();

    /* compiled from: WidgetHomeModel.kt */
    /* renamed from: com.discord.widgets.home.WidgetHomeModel$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        public AnonymousClass1(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
            return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
            boolean z2;
            User userA;
            User userA2;
            Channel channel3 = this.$channel;
            if (channel3 != null && ChannelUtils.B(channel3)) {
                Long lValueOf = channel != null ? Long.valueOf(channel.getId()) : null;
                Channel channel4 = this.$channel;
                if (m.areEqual(lValueOf, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.$selectedChannel;
            m.checkNotNullExpressionValue(resolvedSelectedChannel, "selectedChannel");
            Channel channel5 = this.$channel;
            Presence presence = (channel5 == null || (userA2 = ChannelUtils.a(channel5)) == null) ? null : (Presence) a.f(userA2, map);
            m.checkNotNullExpressionValue(num, "unreadCount");
            int iIntValue = num.intValue();
            m.checkNotNullExpressionValue(map2, "userRelationships");
            Channel channel6 = this.$channel;
            boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userA = ChannelUtils.a(channel6)) == null) ? null : Long.valueOf(userA.getId())), 1);
            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
            int size = map3.size();
            m.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
            return new WidgetHomeModel(resolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
        }
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeModel> call(Pair<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> pair) {
        return call2((Pair<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>) pair);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeModel> call2(Pair<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> pair) {
        Long lValueOf;
        long id2;
        Long lComponent1 = pair.component1();
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannelComponent2 = pair.component2();
        Channel maybeChannel = resolvedSelectedChannelComponent2.getMaybeChannel();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        Observable<Map<Long, Presence>> observableObserveAllPresences = companion.getPresences().observeAllPresences();
        Observable<Channel> observableObserveSelectedChannel = companion.getVoiceChannelSelected().observeSelectedChannel();
        Observable<Integer> observableObserveTotalMentions = companion.getMentions().observeTotalMentions();
        Observable<Map<Long, Integer>> observableObserve = companion.getUserRelationships().observe();
        StoreThreadsActive threadsActive = companion.getThreadsActive();
        m.checkNotNullExpressionValue(lComponent1, "selectedGuildId");
        long jLongValue = lComponent1.longValue();
        if (maybeChannel != null && ChannelUtils.H(maybeChannel)) {
            id2 = maybeChannel.getParentId();
        } else {
            if (maybeChannel == null) {
                lValueOf = null;
                return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new AnonymousClass1(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
            }
            id2 = maybeChannel.getId();
        }
        lValueOf = Long.valueOf(id2);
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new AnonymousClass1(maybeChannel, resolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
    }
}
