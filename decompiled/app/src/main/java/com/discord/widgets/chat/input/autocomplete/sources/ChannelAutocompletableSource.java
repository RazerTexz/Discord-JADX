package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAutocompletableSource {
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource$observeChannelAutocompletables$1 */
    /* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
    public static final class C78031<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public static final C78031 INSTANCE = new C78031();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3) {
            return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, Long> map3) {
            TreeSet treeSet = new TreeSet(new AutocompletableComparator());
            Intrinsics3.checkNotNullExpressionValue(map2, "activeJoinedThreads");
            Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
            for (Channel channel : Maps6.plus(map2, map).values()) {
                if (ChannelUtils.m7698v(channel) || ChannelUtils.m7675J(channel) || ChannelUtils.m7687k(channel)) {
                    Intrinsics3.checkNotNullExpressionValue(map3, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                    if (PermissionUtils.hasAccess(channel, map3)) {
                        treeSet.add(new ChannelAutocompletable(channel));
                    }
                }
            }
            return MapsJVM.mapOf(Tuples.m10073to(LeadingIdentifier.CHANNELS, treeSet));
        }
    }

    public ChannelAutocompletableSource(StoreChannels storeChannels, StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        this.storeChannels = storeChannels;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storePermissions = storePermissions;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StorePermissions getStorePermissions() {
        return this.storePermissions;
    }

    public final StoreThreadsActiveJoined getStoreThreadsActiveJoined() {
        return this.storeThreadsActiveJoined;
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeChannelAutocompletables(long guildId) {
        Observable observableM11075i = Observable.m11075i(ObservableExtensionsKt.computationLatest(StoreChannels.observeChannelsForGuild$default(this.storeChannels, guildId, null, 2, null)), this.storeThreadsActiveJoined.observeActiveJoinedThreadsChannelsForGuild(guildId), ObservableExtensionsKt.computationLatest(this.storePermissions.observePermissionsForAllChannels()), C78031.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…ANNELS to channels)\n    }");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableM11112r, 500L, TimeUnit.MILLISECONDS);
    }
}
