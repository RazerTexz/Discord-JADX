package com.discord.widgets.channels;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelIconType;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.t.g0;
import d0.t.n0;
import d0.t.o0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChannelTopicViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Long previousChannelId;
    private Set<Integer> revealedIndices;
    private Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> topicParser;
    private boolean wasOnHomeTab;
    private boolean wasRightPanelOpened;

    /* compiled from: WidgetChannelTopicViewModel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Companion.NavState, Observable<? extends StoreState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends StoreState> call(Companion.NavState navState) {
            return call2(navState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StoreState> call2(Companion.NavState navState) {
            if (navState.isRightPanelOpened()) {
                Companion companion = WidgetChannelTopicViewModel.INSTANCE;
                m.checkNotNullExpressionValue(navState, "navState");
                return Companion.observeStoreState$default(companion, navState, null, null, null, null, null, 62, null);
            }
            Companion companion2 = WidgetChannelTopicViewModel.INSTANCE;
            m.checkNotNullExpressionValue(navState, "navState");
            return Companion.observeStoreState$default(companion2, navState, null, null, null, null, null, 62, null).Z(1);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "storeState");
            WidgetChannelTopicViewModel.access$handleStoreState(WidgetChannelTopicViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    public static final class Companion {

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NavState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NavState(boolean z2, boolean z3) {
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NavState copy$default(NavState navState, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = navState.isRightPanelOpened;
                }
                if ((i & 2) != 0) {
                    z3 = navState.isOnHomeTab;
                }
                return navState.copy(z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final NavState copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NavState(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavState)) {
                    return false;
                }
                NavState navState = (NavState) other;
                return this.isRightPanelOpened == navState.isRightPanelOpened && this.isOnHomeTab == navState.isOnHomeTab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.isRightPanelOpened;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isOnHomeTab;
                return i + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isOnHomeTab() {
                return this.isOnHomeTab;
            }

            public final boolean isRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("NavState(isRightPanelOpened=");
                sbU.append(this.isRightPanelOpened);
                sbU.append(", isOnHomeTab=");
                return a.O(sbU, this.isOnHomeTab, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$mapChannelToGuildStoreState(Companion companion, Channel channel, NavState navState, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            return companion.mapChannelToGuildStoreState(channel, navState, storeChannels, storeUser, storeGuilds, storeUserSettings);
        }

        public static final /* synthetic */ Observable access$mapChannelToPrivateStoreState(Companion companion, Channel channel, NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            return companion.mapChannelToPrivateStoreState(channel, navState, storeGuilds, storeUserSettings);
        }

        private final Observable<StoreState.Guild> mapChannelToGuildStoreState(Channel channel, NavState navState, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            long guildId = channel.getGuildId();
            Observable<StoreState.Guild> observableG = Observable.g(StoreChannels.observeChannelsForGuild$default(storeChannels, guildId, null, 2, null), storeUsers.observeAllUsers(), storeGuilds.observeComputed(guildId), storeGuilds.observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), new WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1(channel, navState));
            m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…HomeTab\n        )\n      }");
            return observableG;
        }

        private final Observable<StoreState> mapChannelToPrivateStoreState(Channel channel, NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            if (ChannelUtils.p(channel)) {
                k kVar = new k(new StoreState.GDM(channel, storeUserSettings.getIsDeveloperMode(), navState.isRightPanelOpened(), navState.isOnHomeTab()));
                m.checkNotNullExpressionValue(kVar, "Observable.just(\n       …            )\n          )");
                return kVar;
            }
            Observable observableG = storeGuilds.observeComputed().G(new WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1(channel, storeUserSettings, navState));
            m.checkNotNullExpressionValue(observableG, "storeGuilds.observeCompu…            )\n          }");
            return observableG;
        }

        private final Observable<NavState> observeNavState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation) {
            Observable<NavState> observableJ = Observable.j(storeNavigation.observeRightPanelState().G(WidgetChannelTopicViewModel$Companion$observeNavState$1.INSTANCE), storeTabsNavigation.observeSelectedTab().G(WidgetChannelTopicViewModel$Companion$observeNavState$2.INSTANCE), WidgetChannelTopicViewModel$Companion$observeNavState$3.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…sOpen, isOnHomeTab)\n    }");
            return observableJ;
        }

        public static /* synthetic */ Observable observeNavState$default(Companion companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
            }
            return companion.observeNavState(storeNavigation, storeTabsNavigation);
        }

        private final Observable<StoreState> observeStoreState(NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
            Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelTopicViewModel$Companion$observeStoreState$1(navState, storeGuilds, storeUserSettings, storeChannels, storeUsers));
            m.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            StoreUser storeUser2 = storeUser;
            if ((i & 16) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 32) != 0) {
                storeUserSettings = StoreStream.INSTANCE.getUserSettings();
            }
            return companion.observeStoreState(navState, storeChannelsSelected2, storeChannels2, storeUser2, storeGuilds2, storeUserSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final class FocusFirstElement extends Event {
            public static final FocusFirstElement INSTANCE = new FocusFirstElement();

            private FocusFirstElement() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class StoreState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class DM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final Collection<Map<Long, GuildMember>> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ DM(Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, collection, (i & 4) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ DM copy$default(DM dm, Channel channel, Collection collection, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = dm.channel;
                }
                if ((i & 2) != 0) {
                    collection = dm.guildMembers;
                }
                Collection collection2 = collection;
                if ((i & 4) != 0) {
                    z2 = dm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = dm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = dm.getIsOnHomeTab();
                }
                return dm.copy(channel, collection2, z5, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Collection<Map<Long, GuildMember>> component2() {
                return this.guildMembers;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final DM copy(Channel channel, Collection<? extends Map<Long, GuildMember>> guildMembers, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(channel, guildMembers, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return m.areEqual(this.channel, dm.channel) && m.areEqual(this.guildMembers, dm.guildMembers) && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final Collection<Map<Long, GuildMember>> getGuildMembers() {
                return this.guildMembers;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Collection<Map<Long, GuildMember>> collection = this.guildMembers;
                int iHashCode2 = (iHashCode + (collection != null ? collection.hashCode() : 0)) * 31;
                ?? r1 = this.developerModeEnabled;
                int i = r1;
                if (r1 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r12 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r12 = 1;
                }
                int i3 = (i2 + r12) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("DM(channel=");
                sbU.append(this.channel);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public DM(Channel channel, Collection<? extends Map<Long, GuildMember>> collection, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(collection, "guildMembers");
                this.channel = channel;
                this.guildMembers = collection;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class GDM extends StoreState {
            private final Channel channel;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, (i & 2) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                if ((i & 4) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                if ((i & 8) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component3() {
                return getIsRightPanelOpened();
            }

            public final boolean component4() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                m.checkNotNullParameter(channel, "channel");
                return new GDM(channel, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return m.areEqual(this.channel, gdm.channel) && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                ?? r1 = this.developerModeEnabled;
                int i = r1;
                if (r1 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r12 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r12 = 1;
                }
                int i3 = (i2 + r12) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static abstract class Guild extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconType channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(Channel channel, GuildChannelIconType guildChannelIconType, boolean z2, boolean z3) {
                    super(z2, z3, null);
                    m.checkNotNullParameter(channel, "channel");
                    m.checkNotNullParameter(guildChannelIconType, "channelIconType");
                    this.channel = channel;
                    this.channelIconType = guildChannelIconType;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, Channel channel, GuildChannelIconType guildChannelIconType, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 2) != 0) {
                        guildChannelIconType = defaultTopic.channelIconType;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(channel, guildChannelIconType, z2, z3);
                }

                /* renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                /* renamed from: component2, reason: from getter */
                public final GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(Channel channel, GuildChannelIconType channelIconType, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    m.checkNotNullParameter(channel, "channel");
                    m.checkNotNullParameter(channelIconType, "channelIconType");
                    return new DefaultTopic(channel, channelIconType, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return m.areEqual(this.channel, defaultTopic.channel) && m.areEqual(this.channelIconType, defaultTopic.channelIconType) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v5 */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v1 */
                /* JADX WARN: Type inference failed for: r2v2, types: [int] */
                /* JADX WARN: Type inference failed for: r2v3 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    GuildChannelIconType guildChannelIconType = this.channelIconType;
                    int iHashCode2 = (iHashCode + (guildChannelIconType != null ? guildChannelIconType.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r1 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r1 = 1;
                    }
                    int i = (iHashCode2 + r1) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = a.U("DefaultTopic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final Channel channel;
                private final GuildChannelIconType channelIconType;
                private final Map<Long, Channel> channels;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final Map<Long, GuildMember> members;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, User> users;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public Topic(Channel channel, Map<Long, Channel> map, GuildChannelIconType guildChannelIconType, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, boolean z2, boolean z3, boolean z4) {
                    super(z3, z4, null);
                    m.checkNotNullParameter(channel, "channel");
                    m.checkNotNullParameter(map, "channels");
                    m.checkNotNullParameter(guildChannelIconType, "channelIconType");
                    m.checkNotNullParameter(map2, "users");
                    m.checkNotNullParameter(map3, "members");
                    m.checkNotNullParameter(map4, "roles");
                    this.channel = channel;
                    this.channels = map;
                    this.channelIconType = guildChannelIconType;
                    this.users = map2;
                    this.members = map3;
                    this.roles = map4;
                    this.allowAnimatedEmojis = z2;
                    this.isRightPanelOpened = z3;
                    this.isOnHomeTab = z4;
                }

                public static /* synthetic */ Topic copy$default(Topic topic, Channel channel, Map map, GuildChannelIconType guildChannelIconType, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                    return topic.copy((i & 1) != 0 ? topic.channel : channel, (i & 2) != 0 ? topic.channels : map, (i & 4) != 0 ? topic.channelIconType : guildChannelIconType, (i & 8) != 0 ? topic.users : map2, (i & 16) != 0 ? topic.members : map3, (i & 32) != 0 ? topic.roles : map4, (i & 64) != 0 ? topic.allowAnimatedEmojis : z2, (i & 128) != 0 ? topic.getIsRightPanelOpened() : z3, (i & 256) != 0 ? topic.getIsOnHomeTab() : z4);
                }

                /* renamed from: component1, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Map<Long, Channel> component2() {
                    return this.channels;
                }

                /* renamed from: component3, reason: from getter */
                public final GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, User> component4() {
                    return this.users;
                }

                public final Map<Long, GuildMember> component5() {
                    return this.members;
                }

                public final Map<Long, GuildRole> component6() {
                    return this.roles;
                }

                /* renamed from: component7, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final boolean component8() {
                    return getIsRightPanelOpened();
                }

                public final boolean component9() {
                    return getIsOnHomeTab();
                }

                public final Topic copy(Channel channel, Map<Long, Channel> channels, GuildChannelIconType channelIconType, Map<Long, ? extends User> users, Map<Long, GuildMember> members, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    m.checkNotNullParameter(channel, "channel");
                    m.checkNotNullParameter(channels, "channels");
                    m.checkNotNullParameter(channelIconType, "channelIconType");
                    m.checkNotNullParameter(users, "users");
                    m.checkNotNullParameter(members, "members");
                    m.checkNotNullParameter(roles, "roles");
                    return new Topic(channel, channels, channelIconType, users, members, roles, allowAnimatedEmojis, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return m.areEqual(this.channel, topic.channel) && m.areEqual(this.channels, topic.channels) && m.areEqual(this.channelIconType, topic.channelIconType) && m.areEqual(this.users, topic.users) && m.areEqual(this.members, topic.members) && m.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                public final GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, Channel> getChannels() {
                    return this.channels;
                }

                public final Map<Long, GuildMember> getMembers() {
                    return this.members;
                }

                public final Map<Long, GuildRole> getRoles() {
                    return this.roles;
                }

                public final Map<Long, User> getUsers() {
                    return this.users;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v11 */
                /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
                /* JADX WARN: Type inference failed for: r1v5, types: [int] */
                /* JADX WARN: Type inference failed for: r1v7 */
                /* JADX WARN: Type inference failed for: r2v13 */
                /* JADX WARN: Type inference failed for: r2v14, types: [int] */
                /* JADX WARN: Type inference failed for: r2v15 */
                public int hashCode() {
                    Channel channel = this.channel;
                    int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                    Map<Long, Channel> map = this.channels;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    GuildChannelIconType guildChannelIconType = this.channelIconType;
                    int iHashCode3 = (iHashCode2 + (guildChannelIconType != null ? guildChannelIconType.hashCode() : 0)) * 31;
                    Map<Long, User> map2 = this.users;
                    int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildMember> map3 = this.members;
                    int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map4 = this.roles;
                    int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                    ?? r1 = this.allowAnimatedEmojis;
                    int i = r1;
                    if (r1 != 0) {
                        i = 1;
                    }
                    int i2 = (iHashCode6 + i) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    ?? r12 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        r12 = 1;
                    }
                    int i3 = (i2 + r12) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = a.U("Topic(channel=");
                    sbU.append(this.channel);
                    sbU.append(", channels=");
                    sbU.append(this.channels);
                    sbU.append(", channelIconType=");
                    sbU.append(this.channelIconType);
                    sbU.append(", users=");
                    sbU.append(this.users);
                    sbU.append(", members=");
                    sbU.append(this.members);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(z2, z3);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NoChannel extends StoreState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.StoreState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ StoreState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    /* compiled from: WidgetChannelTopicViewModel.kt */
    public static abstract class ViewState {
        private final boolean isOnHomeTab;
        private final boolean isRightPanelOpened;

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class DM extends ViewState {
            private final long channelId;
            private final boolean developerModeEnabled;
            private final List<GuildMember> guildMembers;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;
            private final String recipientName;
            private final Set<String> recipientNicknames;
            private final Long recipientUserId;

            public /* synthetic */ DM(String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, l, set, list, j, (i & 32) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ DM copy$default(DM dm, String str, Long l, Set set, List list, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                return dm.copy((i & 1) != 0 ? dm.recipientName : str, (i & 2) != 0 ? dm.recipientUserId : l, (i & 4) != 0 ? dm.recipientNicknames : set, (i & 8) != 0 ? dm.guildMembers : list, (i & 16) != 0 ? dm.channelId : j, (i & 32) != 0 ? dm.developerModeEnabled : z2, (i & 64) != 0 ? dm.getIsRightPanelOpened() : z3, (i & 128) != 0 ? dm.getIsOnHomeTab() : z4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getRecipientName() {
                return this.recipientName;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            public final Set<String> component3() {
                return this.recipientNicknames;
            }

            public final List<GuildMember> component4() {
                return this.guildMembers;
            }

            /* renamed from: component5, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component7() {
                return getIsRightPanelOpened();
            }

            public final boolean component8() {
                return getIsOnHomeTab();
            }

            public final DM copy(String recipientName, Long recipientUserId, Set<String> recipientNicknames, List<GuildMember> guildMembers, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                m.checkNotNullParameter(recipientNicknames, "recipientNicknames");
                m.checkNotNullParameter(guildMembers, "guildMembers");
                return new DM(recipientName, recipientUserId, recipientNicknames, guildMembers, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DM)) {
                    return false;
                }
                DM dm = (DM) other;
                return m.areEqual(this.recipientName, dm.recipientName) && m.areEqual(this.recipientUserId, dm.recipientUserId) && m.areEqual(this.recipientNicknames, dm.recipientNicknames) && m.areEqual(this.guildMembers, dm.guildMembers) && this.channelId == dm.channelId && this.developerModeEnabled == dm.developerModeEnabled && getIsRightPanelOpened() == dm.getIsRightPanelOpened() && getIsOnHomeTab() == dm.getIsOnHomeTab();
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final List<GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final String getRecipientName() {
                return this.recipientName;
            }

            public final Set<String> getRecipientNicknames() {
                return this.recipientNicknames;
            }

            public final Long getRecipientUserId() {
                return this.recipientUserId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v13, types: [int] */
            /* JADX WARN: Type inference failed for: r0v15 */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v9 */
            public int hashCode() {
                String str = this.recipientName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.recipientUserId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Set<String> set = this.recipientNicknames;
                int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembers;
                int iA = (a0.a.a.b.a(this.channelId) + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31)) * 31;
                ?? r0 = this.developerModeEnabled;
                int i = r0;
                if (r0 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r02 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r02 = 1;
                }
                int i3 = (i2 + r02) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("DM(recipientName=");
                sbU.append(this.recipientName);
                sbU.append(", recipientUserId=");
                sbU.append(this.recipientUserId);
                sbU.append(", recipientNicknames=");
                sbU.append(this.recipientNicknames);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DM(String str, Long l, Set<String> set, List<GuildMember> list, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                m.checkNotNullParameter(set, "recipientNicknames");
                m.checkNotNullParameter(list, "guildMembers");
                this.recipientName = str;
                this.recipientUserId = l;
                this.recipientNicknames = set;
                this.guildMembers = list;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class GDM extends ViewState {
            private final Channel channel;
            private final long channelId;
            private final boolean developerModeEnabled;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public /* synthetic */ GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, j, (i & 4) != 0 ? false : z2, z3, z4);
            }

            public static /* synthetic */ GDM copy$default(GDM gdm, Channel channel, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = gdm.channel;
                }
                if ((i & 2) != 0) {
                    j = gdm.channelId;
                }
                long j2 = j;
                if ((i & 4) != 0) {
                    z2 = gdm.developerModeEnabled;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    z3 = gdm.getIsRightPanelOpened();
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = gdm.getIsOnHomeTab();
                }
                return gdm.copy(channel, j2, z5, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            public final boolean component4() {
                return getIsRightPanelOpened();
            }

            public final boolean component5() {
                return getIsOnHomeTab();
            }

            public final GDM copy(Channel channel, long channelId, boolean developerModeEnabled, boolean isRightPanelOpened, boolean isOnHomeTab) {
                m.checkNotNullParameter(channel, "channel");
                return new GDM(channel, channelId, developerModeEnabled, isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GDM)) {
                    return false;
                }
                GDM gdm = (GDM) other;
                return m.areEqual(this.channel, gdm.channel) && this.channelId == gdm.channelId && this.developerModeEnabled == gdm.developerModeEnabled && getIsRightPanelOpened() == gdm.getIsRightPanelOpened() && getIsOnHomeTab() == gdm.getIsOnHomeTab();
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDeveloperModeEnabled() {
                return this.developerModeEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Channel channel = this.channel;
                int iA = (a0.a.a.b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                ?? r0 = this.developerModeEnabled;
                int i = r0;
                if (r0 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r02 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r02 = 1;
                }
                int i3 = (i2 + r02) * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i3 + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("GDM(channel=");
                sbU.append(this.channel);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", developerModeEnabled=");
                sbU.append(this.developerModeEnabled);
                sbU.append(", isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GDM(Channel channel, long j, boolean z2, boolean z3, boolean z4) {
                super(z3, z4, null);
                m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.channelId = j;
                this.developerModeEnabled = z2;
                this.isRightPanelOpened = z3;
                this.isOnHomeTab = z4;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static abstract class Guild extends ViewState {
            private final GuildChannelIconType channelIconType;
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            /* compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class DefaultTopic extends Guild {
                private final Channel channel;
                private final GuildChannelIconType channelIconType;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public DefaultTopic(GuildChannelIconType guildChannelIconType, Channel channel, boolean z2, boolean z3) {
                    super(guildChannelIconType, z2, z3, null);
                    m.checkNotNullParameter(guildChannelIconType, "channelIconType");
                    m.checkNotNullParameter(channel, "channel");
                    this.channelIconType = guildChannelIconType;
                    this.channel = channel;
                    this.isRightPanelOpened = z2;
                    this.isOnHomeTab = z3;
                }

                public static /* synthetic */ DefaultTopic copy$default(DefaultTopic defaultTopic, GuildChannelIconType guildChannelIconType, Channel channel, boolean z2, boolean z3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guildChannelIconType = defaultTopic.getChannelIconType();
                    }
                    if ((i & 2) != 0) {
                        channel = defaultTopic.channel;
                    }
                    if ((i & 4) != 0) {
                        z2 = defaultTopic.getIsRightPanelOpened();
                    }
                    if ((i & 8) != 0) {
                        z3 = defaultTopic.getIsOnHomeTab();
                    }
                    return defaultTopic.copy(guildChannelIconType, channel, z2, z3);
                }

                public final GuildChannelIconType component1() {
                    return getChannelIconType();
                }

                /* renamed from: component2, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final boolean component3() {
                    return getIsRightPanelOpened();
                }

                public final boolean component4() {
                    return getIsOnHomeTab();
                }

                public final DefaultTopic copy(GuildChannelIconType channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    m.checkNotNullParameter(channelIconType, "channelIconType");
                    m.checkNotNullParameter(channel, "channel");
                    return new DefaultTopic(channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof DefaultTopic)) {
                        return false;
                    }
                    DefaultTopic defaultTopic = (DefaultTopic) other;
                    return m.areEqual(getChannelIconType(), defaultTopic.getChannelIconType()) && m.areEqual(this.channel, defaultTopic.channel) && getIsRightPanelOpened() == defaultTopic.getIsRightPanelOpened() && getIsOnHomeTab() == defaultTopic.getIsOnHomeTab();
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                public int hashCode() {
                    GuildChannelIconType channelIconType = getChannelIconType();
                    int iHashCode = (channelIconType != null ? channelIconType.hashCode() : 0) * 31;
                    Channel channel = this.channel;
                    int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    int i = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        i = 1;
                    }
                    int i2 = (iHashCode2 + i) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i2 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = a.U("DefaultTopic(channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            /* compiled from: WidgetChannelTopicViewModel.kt */
            public static final /* data */ class Topic extends Guild {
                private final boolean allowAnimatedEmojis;
                private final List<Node<MessageRenderContext>> ast;
                private final Channel channel;
                private final GuildChannelIconType channelIconType;
                private final Map<Long, String> channelNames;
                private final boolean isLinkifyConflicting;
                private final boolean isOnHomeTab;
                private final boolean isRightPanelOpened;
                private final String rawTopicString;
                private final Map<Long, GuildRole> roles;
                private final Map<Long, String> userNames;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Topic(String str, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, boolean z2, List<Node<MessageRenderContext>> list, boolean z3, GuildChannelIconType guildChannelIconType, Channel channel, boolean z4, boolean z5) {
                    super(guildChannelIconType, z4, z5, null);
                    m.checkNotNullParameter(str, "rawTopicString");
                    m.checkNotNullParameter(map, "channelNames");
                    m.checkNotNullParameter(map2, "userNames");
                    m.checkNotNullParameter(map3, "roles");
                    m.checkNotNullParameter(list, "ast");
                    m.checkNotNullParameter(guildChannelIconType, "channelIconType");
                    m.checkNotNullParameter(channel, "channel");
                    this.rawTopicString = str;
                    this.channelNames = map;
                    this.userNames = map2;
                    this.roles = map3;
                    this.allowAnimatedEmojis = z2;
                    this.ast = list;
                    this.isLinkifyConflicting = z3;
                    this.channelIconType = guildChannelIconType;
                    this.channel = channel;
                    this.isRightPanelOpened = z4;
                    this.isOnHomeTab = z5;
                }

                public static /* synthetic */ Topic copy$default(Topic topic, String str, Map map, Map map2, Map map3, boolean z2, List list, boolean z3, GuildChannelIconType guildChannelIconType, Channel channel, boolean z4, boolean z5, int i, Object obj) {
                    return topic.copy((i & 1) != 0 ? topic.rawTopicString : str, (i & 2) != 0 ? topic.channelNames : map, (i & 4) != 0 ? topic.userNames : map2, (i & 8) != 0 ? topic.roles : map3, (i & 16) != 0 ? topic.allowAnimatedEmojis : z2, (i & 32) != 0 ? topic.ast : list, (i & 64) != 0 ? topic.isLinkifyConflicting : z3, (i & 128) != 0 ? topic.getChannelIconType() : guildChannelIconType, (i & 256) != 0 ? topic.channel : channel, (i & 512) != 0 ? topic.getIsRightPanelOpened() : z4, (i & 1024) != 0 ? topic.getIsOnHomeTab() : z5);
                }

                /* renamed from: component1, reason: from getter */
                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final boolean component10() {
                    return getIsRightPanelOpened();
                }

                public final boolean component11() {
                    return getIsOnHomeTab();
                }

                public final Map<Long, String> component2() {
                    return this.channelNames;
                }

                public final Map<Long, String> component3() {
                    return this.userNames;
                }

                public final Map<Long, GuildRole> component4() {
                    return this.roles;
                }

                /* renamed from: component5, reason: from getter */
                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> component6() {
                    return this.ast;
                }

                /* renamed from: component7, reason: from getter */
                public final boolean getIsLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                public final GuildChannelIconType component8() {
                    return getChannelIconType();
                }

                /* renamed from: component9, reason: from getter */
                public final Channel getChannel() {
                    return this.channel;
                }

                public final Topic copy(String rawTopicString, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, List<Node<MessageRenderContext>> ast, boolean isLinkifyConflicting, GuildChannelIconType channelIconType, Channel channel, boolean isRightPanelOpened, boolean isOnHomeTab) {
                    m.checkNotNullParameter(rawTopicString, "rawTopicString");
                    m.checkNotNullParameter(channelNames, "channelNames");
                    m.checkNotNullParameter(userNames, "userNames");
                    m.checkNotNullParameter(roles, "roles");
                    m.checkNotNullParameter(ast, "ast");
                    m.checkNotNullParameter(channelIconType, "channelIconType");
                    m.checkNotNullParameter(channel, "channel");
                    return new Topic(rawTopicString, channelNames, userNames, roles, allowAnimatedEmojis, ast, isLinkifyConflicting, channelIconType, channel, isRightPanelOpened, isOnHomeTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Topic)) {
                        return false;
                    }
                    Topic topic = (Topic) other;
                    return m.areEqual(this.rawTopicString, topic.rawTopicString) && m.areEqual(this.channelNames, topic.channelNames) && m.areEqual(this.userNames, topic.userNames) && m.areEqual(this.roles, topic.roles) && this.allowAnimatedEmojis == topic.allowAnimatedEmojis && m.areEqual(this.ast, topic.ast) && this.isLinkifyConflicting == topic.isLinkifyConflicting && m.areEqual(getChannelIconType(), topic.getChannelIconType()) && m.areEqual(this.channel, topic.channel) && getIsRightPanelOpened() == topic.getIsRightPanelOpened() && getIsOnHomeTab() == topic.getIsOnHomeTab();
                }

                public final boolean getAllowAnimatedEmojis() {
                    return this.allowAnimatedEmojis;
                }

                public final List<Node<MessageRenderContext>> getAst() {
                    return this.ast;
                }

                public final Channel getChannel() {
                    return this.channel;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild
                public GuildChannelIconType getChannelIconType() {
                    return this.channelIconType;
                }

                public final Map<Long, String> getChannelNames() {
                    return this.channelNames;
                }

                public final String getRawTopicString() {
                    return this.rawTopicString;
                }

                public final Map<Long, GuildRole> getRoles() {
                    return this.roles;
                }

                public final Map<Long, String> getUserNames() {
                    return this.userNames;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public int hashCode() {
                    String str = this.rawTopicString;
                    int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                    Map<Long, String> map = this.channelNames;
                    int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                    Map<Long, String> map2 = this.userNames;
                    int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                    Map<Long, GuildRole> map3 = this.roles;
                    int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                    boolean z2 = this.allowAnimatedEmojis;
                    int i = z2;
                    if (z2 != 0) {
                        i = 1;
                    }
                    int i2 = (iHashCode4 + i) * 31;
                    List<Node<MessageRenderContext>> list = this.ast;
                    int iHashCode5 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
                    boolean z3 = this.isLinkifyConflicting;
                    int i3 = z3;
                    if (z3 != 0) {
                        i3 = 1;
                    }
                    int i4 = (iHashCode5 + i3) * 31;
                    GuildChannelIconType channelIconType = getChannelIconType();
                    int iHashCode6 = (i4 + (channelIconType != null ? channelIconType.hashCode() : 0)) * 31;
                    Channel channel = this.channel;
                    int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
                    boolean isRightPanelOpened = getIsRightPanelOpened();
                    int i5 = isRightPanelOpened;
                    if (isRightPanelOpened) {
                        i5 = 1;
                    }
                    int i6 = (iHashCode7 + i5) * 31;
                    boolean isOnHomeTab = getIsOnHomeTab();
                    return i6 + (isOnHomeTab ? 1 : isOnHomeTab);
                }

                public final boolean isLinkifyConflicting() {
                    return this.isLinkifyConflicting;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isOnHomeTab, reason: from getter */
                public boolean getIsOnHomeTab() {
                    return this.isOnHomeTab;
                }

                @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState.Guild, com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
                /* renamed from: isRightPanelOpened, reason: from getter */
                public boolean getIsRightPanelOpened() {
                    return this.isRightPanelOpened;
                }

                public String toString() {
                    StringBuilder sbU = a.U("Topic(rawTopicString=");
                    sbU.append(this.rawTopicString);
                    sbU.append(", channelNames=");
                    sbU.append(this.channelNames);
                    sbU.append(", userNames=");
                    sbU.append(this.userNames);
                    sbU.append(", roles=");
                    sbU.append(this.roles);
                    sbU.append(", allowAnimatedEmojis=");
                    sbU.append(this.allowAnimatedEmojis);
                    sbU.append(", ast=");
                    sbU.append(this.ast);
                    sbU.append(", isLinkifyConflicting=");
                    sbU.append(this.isLinkifyConflicting);
                    sbU.append(", channelIconType=");
                    sbU.append(getChannelIconType());
                    sbU.append(", channel=");
                    sbU.append(this.channel);
                    sbU.append(", isRightPanelOpened=");
                    sbU.append(getIsRightPanelOpened());
                    sbU.append(", isOnHomeTab=");
                    sbU.append(getIsOnHomeTab());
                    sbU.append(")");
                    return sbU.toString();
                }
            }

            public /* synthetic */ Guild(GuildChannelIconType guildChannelIconType, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildChannelIconType, z2, z3);
            }

            public GuildChannelIconType getChannelIconType() {
                return this.channelIconType;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            private Guild(GuildChannelIconType guildChannelIconType, boolean z2, boolean z3) {
                super(z2, z3, null);
                this.channelIconType = guildChannelIconType;
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }
        }

        /* compiled from: WidgetChannelTopicViewModel.kt */
        public static final /* data */ class NoChannel extends ViewState {
            private final boolean isOnHomeTab;
            private final boolean isRightPanelOpened;

            public NoChannel(boolean z2, boolean z3) {
                super(z2, z3, null);
                this.isRightPanelOpened = z2;
                this.isOnHomeTab = z3;
            }

            public static /* synthetic */ NoChannel copy$default(NoChannel noChannel, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = noChannel.getIsRightPanelOpened();
                }
                if ((i & 2) != 0) {
                    z3 = noChannel.getIsOnHomeTab();
                }
                return noChannel.copy(z2, z3);
            }

            public final boolean component1() {
                return getIsRightPanelOpened();
            }

            public final boolean component2() {
                return getIsOnHomeTab();
            }

            public final NoChannel copy(boolean isRightPanelOpened, boolean isOnHomeTab) {
                return new NoChannel(isRightPanelOpened, isOnHomeTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoChannel)) {
                    return false;
                }
                NoChannel noChannel = (NoChannel) other;
                return getIsRightPanelOpened() == noChannel.getIsRightPanelOpened() && getIsOnHomeTab() == noChannel.getIsOnHomeTab();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean isRightPanelOpened = getIsRightPanelOpened();
                ?? r0 = isRightPanelOpened;
                if (isRightPanelOpened) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean isOnHomeTab = getIsOnHomeTab();
                return i + (isOnHomeTab ? 1 : isOnHomeTab);
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isOnHomeTab, reason: from getter */
            public boolean getIsOnHomeTab() {
                return this.isOnHomeTab;
            }

            @Override // com.discord.widgets.channels.WidgetChannelTopicViewModel.ViewState
            /* renamed from: isRightPanelOpened, reason: from getter */
            public boolean getIsRightPanelOpened() {
                return this.isRightPanelOpened;
            }

            public String toString() {
                StringBuilder sbU = a.U("NoChannel(isRightPanelOpened=");
                sbU.append(getIsRightPanelOpened());
                sbU.append(", isOnHomeTab=");
                sbU.append(getIsOnHomeTab());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(boolean z2, boolean z3) {
            this.isRightPanelOpened = z2;
            this.isOnHomeTab = z3;
        }

        /* renamed from: isOnHomeTab, reason: from getter */
        public boolean getIsOnHomeTab() {
            return this.isOnHomeTab;
        }

        /* renamed from: isRightPanelOpened, reason: from getter */
        public boolean getIsRightPanelOpened() {
            return this.isRightPanelOpened;
        }

        public /* synthetic */ ViewState(boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3);
        }
    }

    public WidgetChannelTopicViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelTopicViewModel(Observable observable, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            observable = Companion.observeNavState$default(INSTANCE, null, null, 3, null).Y(AnonymousClass1.INSTANCE);
            m.checkNotNullExpressionValue(observable, "observeNavState().switch…avState\n    ).take(1)\n  }");
        }
        this(observable, (i & 2) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelTopicViewModel widgetChannelTopicViewModel, StoreState storeState) {
        widgetChannelTopicViewModel.handleStoreState(storeState);
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawTopicString) {
        return Parser.parse$default(this.topicParser, rawTopicString, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    private final void handleGuildStoreState(StoreState.Guild storeState) {
        String username;
        if (storeState instanceof StoreState.Guild.DefaultTopic) {
            StoreState.Guild.DefaultTopic defaultTopic = (StoreState.Guild.DefaultTopic) storeState;
            updateViewState(new ViewState.Guild.DefaultTopic(defaultTopic.getChannelIconType(), defaultTopic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
            return;
        }
        if (!(storeState instanceof StoreState.Guild.Topic)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.Guild.Topic topic = (StoreState.Guild.Topic) storeState;
        String topic2 = topic.getChannel().getTopic();
        List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic2 != null ? topic2 : "");
        MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
        messagePreprocessor.process(listGenerateAST);
        Map<Long, User> users = topic.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(users.size()));
        Iterator<T> it = users.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            long jLongValue = ((Number) entry.getKey()).longValue();
            User user = (User) entry.getValue();
            GuildMember guildMember = topic.getMembers().get(Long.valueOf(jLongValue));
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = user.getUsername();
            }
            linkedHashMap.put(key, username);
        }
        String str = topic2 != null ? topic2 : "";
        Map<Long, Channel> channels = topic.getChannels();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(channels.size()));
        Iterator<T> it2 = channels.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), ChannelUtils.c((Channel) entry2.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            if (((String) entry3.getValue()).length() > 0) {
                linkedHashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        updateViewState(new ViewState.Guild.Topic(str, linkedHashMap3, linkedHashMap, topic.getRoles(), topic.getAllowAnimatedEmojis(), listGenerateAST, messagePreprocessor.isLinkifyConflicting(), topic.getChannelIconType(), topic.getChannel(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    private final void handlePrivateStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.DM)) {
            if (storeState instanceof StoreState.GDM) {
                StoreState.GDM gdm = (StoreState.GDM) storeState;
                updateViewState(new ViewState.GDM(gdm.getChannel(), gdm.getChannel().getId(), gdm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
                return;
            }
            return;
        }
        StoreState.DM dm = (StoreState.DM) storeState;
        User userA = ChannelUtils.a(dm.getChannel());
        String nickOrUsername$default = userA != null ? GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, userA, null, dm.getChannel(), null, 8, null) : null;
        User userA2 = ChannelUtils.a(dm.getChannel());
        Long lValueOf = userA2 != null ? Long.valueOf(userA2.getId()) : null;
        long id2 = dm.getChannel().getId();
        Collection<Map<Long, GuildMember>> guildMembers = dm.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = guildMembers.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            User userA3 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember = (GuildMember) map.get(userA3 != null ? Long.valueOf(userA3.getId()) : null);
            String nick = guildMember != null ? guildMember.getNick() : null;
            if (nick != null) {
                arrayList.add(nick);
            }
        }
        Set set = u.toSet(arrayList);
        Collection<Map<Long, GuildMember>> guildMembers2 = dm.getGuildMembers();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = guildMembers2.iterator();
        while (it2.hasNext()) {
            Map map2 = (Map) it2.next();
            User userA4 = ChannelUtils.a(dm.getChannel());
            GuildMember guildMember2 = (GuildMember) map2.get(userA4 != null ? Long.valueOf(userA4.getId()) : null);
            if (guildMember2 != null) {
                arrayList2.add(guildMember2);
            }
        }
        updateViewState(new ViewState.DM(nickOrUsername$default, lValueOf, set, u.toList(arrayList2), id2, dm.getDeveloperModeEnabled(), storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Long lValueOf;
        if (storeState instanceof StoreState.Guild.Topic) {
            long id2 = ((StoreState.Guild.Topic) storeState).getChannel().getId();
            Long l = this.previousChannelId;
            this.revealedIndices = (l != null && id2 == l.longValue()) ? this.revealedIndices : n0.emptySet();
            lValueOf = Long.valueOf(id2);
        } else {
            lValueOf = storeState instanceof StoreState.Guild.DefaultTopic ? Long.valueOf(((StoreState.Guild.DefaultTopic) storeState).getChannel().getId()) : storeState instanceof StoreState.DM ? Long.valueOf(((StoreState.DM) storeState).getChannel().getId()) : storeState instanceof StoreState.GDM ? Long.valueOf(((StoreState.GDM) storeState).getChannel().getId()) : null;
        }
        this.previousChannelId = lValueOf;
        if (storeState.getIsRightPanelOpened() != this.wasRightPanelOpened || storeState.getIsOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.getIsRightPanelOpened() && storeState.getIsOnHomeTab()) {
                this.eventSubject.k.onNext(Event.FocusFirstElement.INSTANCE);
            }
            this.wasRightPanelOpened = storeState.getIsRightPanelOpened();
            this.wasOnHomeTab = storeState.getIsOnHomeTab();
        }
        if (storeState instanceof StoreState.NoChannel) {
            updateViewState(new ViewState.NoChannel(storeState.getIsRightPanelOpened(), storeState.getIsOnHomeTab()));
        } else if (storeState instanceof StoreState.Guild) {
            handleGuildStoreState((StoreState.Guild) storeState);
        } else {
            handlePrivateStoreState(storeState);
        }
    }

    public final Unit handleClosePrivateChannel(Context context) {
        m.checkNotNullParameter(context, "context");
        Long l = this.previousChannelId;
        if (l == null) {
            return null;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(l.longValue()), false, 1, null), this, null, 2, null), context, "javaClass", (Function1) null, new WidgetChannelTopicViewModel$handleClosePrivateChannel$$inlined$let$lambda$1(this, context), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        return Unit.a;
    }

    @MainThread
    public final void handleOnIndexClicked(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Guild.Topic)) {
            viewState = null;
        }
        ViewState.Guild.Topic topic = (ViewState.Guild.Topic) viewState;
        if (topic != null) {
            List<Node<MessageRenderContext>> listGenerateAST = generateAST(topic.getRawTopicString());
            this.revealedIndices = o0.plus(this.revealedIndices, Integer.valueOf(spoilerNode.getId()));
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(-1L, this.revealedIndices, null, false, null, 28, null);
            messagePreprocessor.process(listGenerateAST);
            updateViewState(ViewState.Guild.Topic.copy$default(topic, null, null, null, null, false, listGenerateAST, messagePreprocessor.isLinkifyConflicting(), null, null, false, false, 1951, null));
        }
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopicViewModel(Observable<StoreState> observable, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(new ViewState.NoChannel(false, false));
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(parser, "topicParser");
        this.topicParser = parser;
        this.revealedIndices = n0.emptySet();
        this.previousChannelId = 0L;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelTopicViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
