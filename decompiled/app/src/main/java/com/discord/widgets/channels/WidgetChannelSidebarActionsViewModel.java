package com.discord.widgets.channels;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$1 */
    public static final class C73471 extends Lambda implements Function1<StoreState, Unit> {
        public C73471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelSidebarActionsViewModel.access$handleStoreState(WidgetChannelSidebarActionsViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildNSFW, StoreUser storeUser) {
            Observable observableM11099Y = storeNavigation.observeRightPanelState().m11099Y(new WidgetChannelSidebarActionsViewModel2(storeChannelsSelected, storeUserGuildSettings, storeUser, storeChannels, storeGuildNSFW));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeNavigation\n        …          }\n            }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 4) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 8) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            StoreUserGuildSettings storeUserGuildSettings2 = storeUserGuildSettings;
            if ((i & 16) != 0) {
                storeGuildsNsfw = StoreStream.INSTANCE.getGuildsNsfw();
            }
            StoreGuildsNsfw storeGuildsNsfw2 = storeGuildsNsfw;
            if ((i & 32) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(storeNavigation, storeChannels2, storeChannelsSelected2, storeUserGuildSettings2, storeGuildsNsfw2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class ChannelFound extends StoreState {
            private final Channel channel;
            private final boolean disablePins;
            private final ModelNotificationSettings guildNotificationSettings;
            private final Channel parentChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChannelFound(Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.parentChannel = channel2;
                this.guildNotificationSettings = modelNotificationSettings;
                this.disablePins = z2;
            }

            public static /* synthetic */ ChannelFound copy$default(ChannelFound channelFound, Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = channelFound.channel;
                }
                if ((i & 2) != 0) {
                    channel2 = channelFound.parentChannel;
                }
                if ((i & 4) != 0) {
                    modelNotificationSettings = channelFound.guildNotificationSettings;
                }
                if ((i & 8) != 0) {
                    z2 = channelFound.disablePins;
                }
                return channelFound.copy(channel, channel2, modelNotificationSettings, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ChannelFound copy(Channel channel, Channel parentChannel, ModelNotificationSettings guildNotificationSettings, boolean disablePins) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new ChannelFound(channel, parentChannel, guildNotificationSettings, disablePins);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChannelFound)) {
                    return false;
                }
                ChannelFound channelFound = (ChannelFound) other;
                return Intrinsics3.areEqual(this.channel, channelFound.channel) && Intrinsics3.areEqual(this.parentChannel, channelFound.parentChannel) && Intrinsics3.areEqual(this.guildNotificationSettings, channelFound.guildNotificationSettings) && this.disablePins == channelFound.disablePins;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
                int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
                boolean z2 = this.disablePins;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode3 + i;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ChannelFound(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", parentChannel=");
                sbM833U.append(this.parentChannel);
                sbM833U.append(", guildNotificationSettings=");
                sbM833U.append(this.guildNotificationSettings);
                sbM833U.append(", disablePins=");
                return outline.m827O(sbM833U, this.disablePins, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final class ChannelNotFound extends StoreState {
            public static final ChannelNotFound INSTANCE = new ChannelNotFound();

            private ChannelNotFound() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class Guild extends ViewState {
            private final long channelId;
            private final boolean disablePins;
            private final long guildId;
            private final boolean hasUnreadPins;
            private final boolean isGuildForumChannel;
            private final boolean isGuildForumPost;
            private final boolean isMuted;
            private final boolean isThread;
            private final boolean shouldHideChannelSidebar;

            public Guild(long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
                super(null);
                this.channelId = j;
                this.guildId = j2;
                this.isMuted = z2;
                this.hasUnreadPins = z3;
                this.disablePins = z4;
                this.isThread = z5;
                this.isGuildForumPost = z6;
                this.isGuildForumChannel = z7;
                this.shouldHideChannelSidebar = z8;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
                return guild.copy((i & 1) != 0 ? guild.channelId : j, (i & 2) != 0 ? guild.guildId : j2, (i & 4) != 0 ? guild.isMuted : z2, (i & 8) != 0 ? guild.hasUnreadPins : z3, (i & 16) != 0 ? guild.disablePins : z4, (i & 32) != 0 ? guild.isThread : z5, (i & 64) != 0 ? guild.isGuildForumPost : z6, (i & 128) != 0 ? guild.isGuildForumChannel : z7, (i & 256) != 0 ? guild.shouldHideChannelSidebar : z8);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsThread() {
                return this.isThread;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsGuildForumPost() {
                return this.isGuildForumPost;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            public final Guild copy(long channelId, long guildId, boolean isMuted, boolean hasUnreadPins, boolean disablePins, boolean isThread, boolean isGuildForumPost, boolean isGuildForumChannel, boolean shouldHideChannelSidebar) {
                return new Guild(channelId, guildId, isMuted, hasUnreadPins, disablePins, isThread, isGuildForumPost, isGuildForumChannel, shouldHideChannelSidebar);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return this.channelId == guild.channelId && this.guildId == guild.guildId && this.isMuted == guild.isMuted && this.hasUnreadPins == guild.hasUnreadPins && this.disablePins == guild.disablePins && this.isThread == guild.isThread && this.isGuildForumPost == guild.isGuildForumPost && this.isGuildForumChannel == guild.isGuildForumChannel && this.shouldHideChannelSidebar == guild.shouldHideChannelSidebar;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iM3a = (C0002b.m3a(this.guildId) + (C0002b.m3a(this.channelId) * 31)) * 31;
                boolean z2 = this.isMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iM3a + i) * 31;
                boolean z3 = this.hasUnreadPins;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.disablePins;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isThread;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.isGuildForumPost;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                boolean z7 = this.isGuildForumChannel;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (i10 + i11) * 31;
                boolean z8 = this.shouldHideChannelSidebar;
                return i12 + (z8 ? 1 : z8 ? 1 : 0);
            }

            public final boolean isGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            public final boolean isGuildForumPost() {
                return this.isGuildForumPost;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public final boolean isThread() {
                return this.isThread;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Guild(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", isMuted=");
                sbM833U.append(this.isMuted);
                sbM833U.append(", hasUnreadPins=");
                sbM833U.append(this.hasUnreadPins);
                sbM833U.append(", disablePins=");
                sbM833U.append(this.disablePins);
                sbM833U.append(", isThread=");
                sbM833U.append(this.isThread);
                sbM833U.append(", isGuildForumPost=");
                sbM833U.append(this.isGuildForumPost);
                sbM833U.append(", isGuildForumChannel=");
                sbM833U.append(this.isGuildForumChannel);
                sbM833U.append(", shouldHideChannelSidebar=");
                return outline.m827O(sbM833U, this.shouldHideChannelSidebar, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class Private extends ViewState {
            private final long channelId;
            private final boolean isMuted;

            public Private(long j, boolean z2) {
                super(null);
                this.channelId = j;
                this.isMuted = z2;
            }

            public static /* synthetic */ Private copy$default(Private r0, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = r0.channelId;
                }
                if ((i & 2) != 0) {
                    z2 = r0.isMuted;
                }
                return r0.copy(j, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            public final Private copy(long channelId, boolean isMuted) {
                return new Private(channelId, isMuted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r6 = (Private) other;
                return this.channelId == r6.channelId && this.isMuted == r6.isMuted;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iM3a = C0002b.m3a(this.channelId) * 31;
                boolean z2 = this.isMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iM3a + i;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Private(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", isMuted=");
                return outline.m827O(sbM833U, this.isMuted, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChannelSidebarActionsViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetChannelSidebarActionsViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, null, null, null, null, 63, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSidebarActionsViewModel widgetChannelSidebarActionsViewModel, StoreState storeState) {
        widgetChannelSidebarActionsViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ModelNotificationSettings.ChannelOverride channelOverride;
        List<ModelNotificationSettings.ChannelOverride> channelOverrides;
        Object next;
        if (Intrinsics3.areEqual(storeState, StoreState.ChannelNotFound.INSTANCE)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        if (!(storeState instanceof StoreState.ChannelFound)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.ChannelFound channelFound = (StoreState.ChannelFound) storeState;
        boolean z2 = false;
        if (!ChannelUtils.m7667B(channelFound.getChannel())) {
            long id2 = channelFound.getChannel().getId();
            long guildId = channelFound.getChannel().getGuildId();
            ModelNotificationSettings guildNotificationSettings = channelFound.getGuildNotificationSettings();
            boolean z3 = (guildNotificationSettings == null || (channelOverride = guildNotificationSettings.getChannelOverride(id2)) == null || !channelOverride.isMuted()) ? false : true;
            boolean disablePins = channelFound.getDisablePins();
            boolean zM7673H = ChannelUtils.m7673H(channelFound.getChannel());
            Channel parentChannel = channelFound.getParentChannel();
            updateViewState(new ViewState.Guild(id2, guildId, z3, false, disablePins, zM7673H, parentChannel != null && ChannelUtils.m7693q(parentChannel), ChannelUtils.m7693q(channelFound.getChannel()), ChannelUtils.m7691o(channelFound.getChannel())));
            return;
        }
        ModelNotificationSettings guildNotificationSettings2 = channelFound.getGuildNotificationSettings();
        long id3 = channelFound.getChannel().getId();
        if (guildNotificationSettings2 != null && (channelOverrides = guildNotificationSettings2.getChannelOverrides()) != null) {
            Iterator<T> it = channelOverrides.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) next;
                Intrinsics3.checkNotNullExpressionValue(channelOverride2, "channelOverride");
                if (channelOverride2.getChannelId() == id3) {
                    break;
                }
            }
            ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) next;
            if (channelOverride3 != null && channelOverride3.isMuted()) {
                z2 = true;
            }
        }
        updateViewState(new ViewState.Private(channelFound.getChannel().getId(), z2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel(Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSidebarActionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C73471(), 62, (Object) null);
    }
}
