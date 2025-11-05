package com.discord.widgets.home;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHomeModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHomeModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final long channelId;
    private final Presence dmPresence;
    private final boolean isCallConnected;
    private final boolean isFriend;
    private final NsfwAllowance nsfwAllowed;
    private final Channel parentChannel;
    private final StoreChannelsSelected.ResolvedSelectedChannel selectedChannel;
    private final Channel selectedVoiceChannel;
    private final int threadCount;
    private final boolean threadExperimentEnabled;
    private final int unreadCount;

    /* compiled from: WidgetHomeModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<WidgetHomeModel> get() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableY = Observable.j(companion.getGuildSelected().observeSelectedGuildId(), companion.getChannelsSelected().observeResolvedSelectedChannel(), WidgetHomeModel$Companion$get$1.INSTANCE).Y(WidgetHomeModel$Companion$get$2.INSTANCE);
            m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            )\n          }");
            Observable<WidgetHomeModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
            m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<Boolean> getInitialized() {
            Observable<Boolean> observableQ = StoreStream.INSTANCE.isInitializedObservable().q(150L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableQ, "StoreStream\n          .i…0, TimeUnit.MILLISECONDS)");
            return observableQ;
        }

        public final Observable<Channel> getParentChannelObservable(Channel channel) {
            if (channel == null || ChannelUtils.H(channel)) {
                if ((channel != null ? Long.valueOf(channel.getParentId()) : null) != null) {
                    return StoreStream.INSTANCE.getChannels().observeChannel(channel.getParentId());
                }
            }
            k kVar = new k(null);
            m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
            return kVar;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHomeModel(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4) {
        m.checkNotNullParameter(resolvedSelectedChannel, "selectedChannel");
        this.selectedChannel = resolvedSelectedChannel;
        this.selectedVoiceChannel = channel;
        this.parentChannel = channel2;
        this.dmPresence = presence;
        this.unreadCount = i;
        this.isFriend = z2;
        this.isCallConnected = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.threadCount = i2;
        this.threadExperimentEnabled = z4;
        this.channel = resolvedSelectedChannel.getMaybeChannel();
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        this.channelId = maybeChannel != null ? maybeChannel.getId() : 0L;
    }

    public static /* synthetic */ WidgetHomeModel copy$default(WidgetHomeModel widgetHomeModel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4, int i3, Object obj) {
        return widgetHomeModel.copy((i3 & 1) != 0 ? widgetHomeModel.selectedChannel : resolvedSelectedChannel, (i3 & 2) != 0 ? widgetHomeModel.selectedVoiceChannel : channel, (i3 & 4) != 0 ? widgetHomeModel.parentChannel : channel2, (i3 & 8) != 0 ? widgetHomeModel.dmPresence : presence, (i3 & 16) != 0 ? widgetHomeModel.unreadCount : i, (i3 & 32) != 0 ? widgetHomeModel.isFriend : z2, (i3 & 64) != 0 ? widgetHomeModel.isCallConnected : z3, (i3 & 128) != 0 ? widgetHomeModel.nsfwAllowed : nsfwAllowance, (i3 & 256) != 0 ? widgetHomeModel.threadCount : i2, (i3 & 512) != 0 ? widgetHomeModel.threadExperimentEnabled : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* renamed from: component4, reason: from getter */
    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCallConnected() {
        return this.isCallConnected;
    }

    /* renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* renamed from: component9, reason: from getter */
    public final int getThreadCount() {
        return this.threadCount;
    }

    public final WidgetHomeModel copy(StoreChannelsSelected.ResolvedSelectedChannel selectedChannel, Channel selectedVoiceChannel, Channel parentChannel, Presence dmPresence, int unreadCount, boolean isFriend, boolean isCallConnected, NsfwAllowance nsfwAllowed, int threadCount, boolean threadExperimentEnabled) {
        m.checkNotNullParameter(selectedChannel, "selectedChannel");
        return new WidgetHomeModel(selectedChannel, selectedVoiceChannel, parentChannel, dmPresence, unreadCount, isFriend, isCallConnected, nsfwAllowed, threadCount, threadExperimentEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeModel)) {
            return false;
        }
        WidgetHomeModel widgetHomeModel = (WidgetHomeModel) other;
        return m.areEqual(this.selectedChannel, widgetHomeModel.selectedChannel) && m.areEqual(this.selectedVoiceChannel, widgetHomeModel.selectedVoiceChannel) && m.areEqual(this.parentChannel, widgetHomeModel.parentChannel) && m.areEqual(this.dmPresence, widgetHomeModel.dmPresence) && this.unreadCount == widgetHomeModel.unreadCount && this.isFriend == widgetHomeModel.isFriend && this.isCallConnected == widgetHomeModel.isCallConnected && m.areEqual(this.nsfwAllowed, widgetHomeModel.nsfwAllowed) && this.threadCount == widgetHomeModel.threadCount && this.threadExperimentEnabled == widgetHomeModel.threadExperimentEnabled;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        int iHashCode = (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0) * 31;
        Channel channel = this.selectedVoiceChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Presence presence = this.dmPresence;
        int iHashCode4 = (((iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31) + this.unreadCount) * 31;
        boolean z2 = this.isFriend;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.isCallConnected;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode5 = (((i4 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31) + this.threadCount) * 31;
        boolean z4 = this.threadExperimentEnabled;
        return iHashCode5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isCallConnected() {
        return this.isCallConnected;
    }

    public final boolean isChannelNsfw() {
        Channel channel = this.channel;
        return channel != null && channel.getNsfw();
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isNsfwUnConsented() {
        return (this.channel == null || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.channel.getGuildId())) ? false : true;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetHomeModel(selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", dmPresence=");
        sbU.append(this.dmPresence);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", isCallConnected=");
        sbU.append(this.isCallConnected);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", threadCount=");
        sbU.append(this.threadCount);
        sbU.append(", threadExperimentEnabled=");
        return a.O(sbU, this.threadExperimentEnabled, ")");
    }
}
