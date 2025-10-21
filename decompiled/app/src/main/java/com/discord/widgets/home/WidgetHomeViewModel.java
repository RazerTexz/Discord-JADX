package com.discord.widgets.home;

import a0.a.a.b;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.ChannelOnboardingManager;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.playstation.PlaystationUpsellManager;
import com.discord.widgets.servers.guild_role_subscription.upsell.GuildRoleSubscriptionOnboardingUpsellManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetHomeViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHomeViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChannelOnboardingManager channelOnboardingManager;
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final GuildRoleSubscriptionOnboardingUpsellManager guildRoleSubscriptionsUpsellManager;
    private final PlaystationUpsellManager playstationUpsellManager;
    private PanelState previousLeftPanelState;
    private final SharedPreferences sharedPreferences;
    private final StoreExperiments storeExperiments;
    private final StoreGuildWelcomeScreens storeGuildWelcomeScreens;
    private final StoreNavigation storeNavigation;
    private final StoreUser storeUser;
    private boolean wasThreadPeek;
    private WidgetHomeModel widgetHomeModel;

    /* compiled from: WidgetHomeViewModel.kt */
    /* renamed from: com.discord.widgets.home.WidgetHomeViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetHomeViewModel widgetHomeViewModel = WidgetHomeViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetHomeViewModel.access$handleStoreState(widgetHomeViewModel, storeState);
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    /* renamed from: com.discord.widgets.home.WidgetHomeViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreNavigation.PanelAction, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.PanelAction panelAction) {
            invoke2(panelAction);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNavigation.PanelAction panelAction) {
            Intrinsics3.checkNotNullParameter(panelAction, "panelAction");
            WidgetHomeViewModel.access$handleNavDrawerAction(WidgetHomeViewModel.this, panelAction);
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreNavigation storeNavigation, StoreLurking storeLurking, StoreUser storeUser, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreUserConnections storeUserConnections, StoreGuildsNsfw storeGuildsNsfw) {
            return companion.observeStoreState(storeGuilds, storeGuildSelected, storeNavigation, storeLurking, storeUser, storeGuildWelcomeScreens, storeChannelsSelected, storeExperiments, storePermissions, storeUserConnections, storeGuildsNsfw);
        }

        private final Observable<StoreState> observeStoreState(StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreNavigation storeNavigation, StoreLurking storeLurking, StoreUser storeUser, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreUserConnections storeUserConnections, StoreGuildsNsfw storeGuildsNsfw) {
            Observable<StoreState> observableD = Observable.d(storeNavigation.observeLeftPanelState(), storeNavigation.observeRightPanelState(), storeGuildSelected.observeSelectedGuildId().Y(new WidgetHomeViewModel3(storeGuilds, storeLurking, storeGuildWelcomeScreens, storePermissions, storeGuildsNsfw)), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeResolvedSelectedChannel(), storeExperiments.observeUserExperiment("2021-09_events_upsell", false), storeUserConnections.observeConnectedAccounts(), storeExperiments.observeUserExperiment("2021-12_connected_accounts_playstation", false), WidgetHomeViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableD, "Observable.combineLatest…counts,\n        )\n      }");
            return observableD;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class AnimatePeekIn extends Event {
            public static final AnimatePeekIn INSTANCE = new AnimatePeekIn();

            private AnimatePeekIn() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class AnimatePeekOut extends Event {
            public static final AnimatePeekOut INSTANCE = new AnimatePeekOut();

            private AnimatePeekOut() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class ClosePanels extends Event {
            public static final ClosePanels INSTANCE = new ClosePanels();

            private ClosePanels() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class OpenLeftPanel extends Event {
            public static final OpenLeftPanel INSTANCE = new OpenLeftPanel();

            private OpenLeftPanel() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class ShowChannelOnboardingSheet extends Event {
            public static final ShowChannelOnboardingSheet INSTANCE = new ShowChannelOnboardingSheet();

            private ShowChannelOnboardingSheet() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildEventUpsell extends Event {
            private final long guildId;

            public ShowGuildEventUpsell(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildEventUpsell copy$default(ShowGuildEventUpsell showGuildEventUpsell, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildEventUpsell.guildId;
                }
                return showGuildEventUpsell.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildEventUpsell copy(long guildId) {
                return new ShowGuildEventUpsell(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildEventUpsell) && this.guildId == ((ShowGuildEventUpsell) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("ShowGuildEventUpsell(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildRoleSubscriptionUpsell extends Event {
            private final long guildId;

            public ShowGuildRoleSubscriptionUpsell(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildRoleSubscriptionUpsell copy$default(ShowGuildRoleSubscriptionUpsell showGuildRoleSubscriptionUpsell, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildRoleSubscriptionUpsell.guildId;
                }
                return showGuildRoleSubscriptionUpsell.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildRoleSubscriptionUpsell copy(long guildId) {
                return new ShowGuildRoleSubscriptionUpsell(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildRoleSubscriptionUpsell) && this.guildId == ((ShowGuildRoleSubscriptionUpsell) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("ShowGuildRoleSubscriptionUpsell(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final /* data */ class ShowGuildWelcomeSheet extends Event {
            private final long guildId;

            public ShowGuildWelcomeSheet(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ ShowGuildWelcomeSheet copy$default(ShowGuildWelcomeSheet showGuildWelcomeSheet, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showGuildWelcomeSheet.guildId;
                }
                return showGuildWelcomeSheet.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final ShowGuildWelcomeSheet copy(long guildId) {
                return new ShowGuildWelcomeSheet(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowGuildWelcomeSheet) && this.guildId == ((ShowGuildWelcomeSheet) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("ShowGuildWelcomeSheet(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class ShowPlaystationUpsell extends Event {
            public static final ShowPlaystationUpsell INSTANCE = new ShowPlaystationUpsell();

            private ShowPlaystationUpsell() {
                super(null);
            }
        }

        /* compiled from: WidgetHomeViewModel.kt */
        public static final class UnlockLeftPanel extends Event {
            public static final UnlockLeftPanel INSTANCE = new UnlockLeftPanel();

            private UnlockLeftPanel() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class GuildInfo {
        private final boolean canManageEvents;
        private final Guild guild;
        private final long guildId;
        private final boolean isLurking;
        private final boolean isNsfwUnconsented;
        private final StoreGuildWelcomeScreens.State welcomeScreenState;

        public GuildInfo(long j, Guild guild, boolean z2, StoreGuildWelcomeScreens.State state, boolean z3, boolean z4) {
            this.guildId = j;
            this.guild = guild;
            this.isLurking = z2;
            this.welcomeScreenState = state;
            this.isNsfwUnconsented = z3;
            this.canManageEvents = z4;
        }

        public static /* synthetic */ GuildInfo copy$default(GuildInfo guildInfo, long j, Guild guild, boolean z2, StoreGuildWelcomeScreens.State state, boolean z3, boolean z4, int i, Object obj) {
            return guildInfo.copy((i & 1) != 0 ? guildInfo.guildId : j, (i & 2) != 0 ? guildInfo.guild : guild, (i & 4) != 0 ? guildInfo.isLurking : z2, (i & 8) != 0 ? guildInfo.welcomeScreenState : state, (i & 16) != 0 ? guildInfo.isNsfwUnconsented : z3, (i & 32) != 0 ? guildInfo.canManageEvents : z4);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLurking() {
            return this.isLurking;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreGuildWelcomeScreens.State getWelcomeScreenState() {
            return this.welcomeScreenState;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final GuildInfo copy(long guildId, Guild guild, boolean isLurking, StoreGuildWelcomeScreens.State welcomeScreenState, boolean isNsfwUnconsented, boolean canManageEvents) {
            return new GuildInfo(guildId, guild, isLurking, welcomeScreenState, isNsfwUnconsented, canManageEvents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildInfo)) {
                return false;
            }
            GuildInfo guildInfo = (GuildInfo) other;
            return this.guildId == guildInfo.guildId && Intrinsics3.areEqual(this.guild, guildInfo.guild) && this.isLurking == guildInfo.isLurking && Intrinsics3.areEqual(this.welcomeScreenState, guildInfo.welcomeScreenState) && this.isNsfwUnconsented == guildInfo.isNsfwUnconsented && this.canManageEvents == guildInfo.canManageEvents;
        }

        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final StoreGuildWelcomeScreens.State getWelcomeScreenState() {
            return this.welcomeScreenState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            Guild guild = this.guild;
            int iHashCode = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isLurking;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            StoreGuildWelcomeScreens.State state = this.welcomeScreenState;
            int iHashCode2 = (i2 + (state != null ? state.hashCode() : 0)) * 31;
            boolean z3 = this.isNsfwUnconsented;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode2 + i3) * 31;
            boolean z4 = this.canManageEvents;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isLurking() {
            return this.isLurking;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildInfo(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", isLurking=");
            sbU.append(this.isLurking);
            sbU.append(", welcomeScreenState=");
            sbU.append(this.welcomeScreenState);
            sbU.append(", isNsfwUnconsented=");
            sbU.append(this.isNsfwUnconsented);
            sbU.append(", canManageEvents=");
            return outline.O(sbU, this.canManageEvents, ")");
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreUserConnections.State connectedAccountsState;
        private final long guildId;
        private final GuildInfo guildInfo;
        private final boolean isChannelNsfw;
        private final boolean isInEventsUpsellExperiment;
        private final boolean isThreadPeek;
        private final PanelState leftPanelState;
        private final MeUser me;
        private final NsfwAllowance nsfwAllowed;
        private final PanelState rightPanelState;

        public StoreState(PanelState panelState, PanelState panelState2, GuildInfo guildInfo, MeUser meUser, boolean z2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, long j, StoreUserConnections.State state) {
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(panelState2, "rightPanelState");
            Intrinsics3.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(state, "connectedAccountsState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.guildInfo = guildInfo;
            this.me = meUser;
            this.isThreadPeek = z2;
            this.isInEventsUpsellExperiment = z3;
            this.isChannelNsfw = z4;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
            this.connectedAccountsState = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, PanelState panelState2, GuildInfo guildInfo, MeUser meUser, boolean z2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, long j, StoreUserConnections.State state, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.leftPanelState : panelState, (i & 2) != 0 ? storeState.rightPanelState : panelState2, (i & 4) != 0 ? storeState.guildInfo : guildInfo, (i & 8) != 0 ? storeState.me : meUser, (i & 16) != 0 ? storeState.isThreadPeek : z2, (i & 32) != 0 ? storeState.isInEventsUpsellExperiment : z3, (i & 64) != 0 ? storeState.isChannelNsfw : z4, (i & 128) != 0 ? storeState.nsfwAllowed : nsfwAllowance, (i & 256) != 0 ? storeState.guildId : j, (i & 512) != 0 ? storeState.connectedAccountsState : state);
        }

        /* renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* renamed from: component10, reason: from getter */
        public final StoreUserConnections.State getConnectedAccountsState() {
            return this.connectedAccountsState;
        }

        /* renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsThreadPeek() {
            return this.isThreadPeek;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsInEventsUpsellExperiment() {
            return this.isInEventsUpsellExperiment;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* renamed from: component8, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component9, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final StoreState copy(PanelState leftPanelState, PanelState rightPanelState, GuildInfo guildInfo, MeUser me2, boolean isThreadPeek, boolean isInEventsUpsellExperiment, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId, StoreUserConnections.State connectedAccountsState) {
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(rightPanelState, "rightPanelState");
            Intrinsics3.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(connectedAccountsState, "connectedAccountsState");
            return new StoreState(leftPanelState, rightPanelState, guildInfo, me2, isThreadPeek, isInEventsUpsellExperiment, isChannelNsfw, nsfwAllowed, guildId, connectedAccountsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.leftPanelState, storeState.leftPanelState) && Intrinsics3.areEqual(this.rightPanelState, storeState.rightPanelState) && Intrinsics3.areEqual(this.guildInfo, storeState.guildInfo) && Intrinsics3.areEqual(this.me, storeState.me) && this.isThreadPeek == storeState.isThreadPeek && this.isInEventsUpsellExperiment == storeState.isInEventsUpsellExperiment && this.isChannelNsfw == storeState.isChannelNsfw && Intrinsics3.areEqual(this.nsfwAllowed, storeState.nsfwAllowed) && this.guildId == storeState.guildId && Intrinsics3.areEqual(this.connectedAccountsState, storeState.connectedAccountsState);
        }

        public final StoreUserConnections.State getConnectedAccountsState() {
            return this.connectedAccountsState;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final GuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            GuildInfo guildInfo = this.guildInfo;
            int iHashCode3 = (iHashCode2 + (guildInfo != null ? guildInfo.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            boolean z2 = this.isThreadPeek;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            boolean z3 = this.isInEventsUpsellExperiment;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isChannelNsfw;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            int iA = (b.a(this.guildId) + ((i5 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31)) * 31;
            StoreUserConnections.State state = this.connectedAccountsState;
            return iA + (state != null ? state.hashCode() : 0);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isInEventsUpsellExperiment() {
            return this.isInEventsUpsellExperiment;
        }

        public final boolean isThreadPeek() {
            return this.isThreadPeek;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", rightPanelState=");
            sbU.append(this.rightPanelState);
            sbU.append(", guildInfo=");
            sbU.append(this.guildInfo);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", isThreadPeek=");
            sbU.append(this.isThreadPeek);
            sbU.append(", isInEventsUpsellExperiment=");
            sbU.append(this.isInEventsUpsellExperiment);
            sbU.append(", isChannelNsfw=");
            sbU.append(this.isChannelNsfw);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", connectedAccountsState=");
            sbU.append(this.connectedAccountsState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetHomeViewModel.kt */
    public static final /* data */ class ViewState {
        private final long guildId;
        private final boolean isChannelNsfw;
        private final boolean isNsfwUnconsented;
        private final PanelState leftPanelState;
        private final NsfwAllowance nsfwAllowed;
        private final PanelState rightPanelState;

        public ViewState(PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(panelState2, "rightPanelState");
            this.leftPanelState = panelState;
            this.rightPanelState = panelState2;
            this.isNsfwUnconsented = z2;
            this.isChannelNsfw = z3;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                panelState = viewState.leftPanelState;
            }
            if ((i & 2) != 0) {
                panelState2 = viewState.rightPanelState;
            }
            PanelState panelState3 = panelState2;
            if ((i & 4) != 0) {
                z2 = viewState.isNsfwUnconsented;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = viewState.isChannelNsfw;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                nsfwAllowance = viewState.nsfwAllowed;
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowance;
            if ((i & 32) != 0) {
                j = viewState.guildId;
            }
            return viewState.copy(panelState, panelState3, z4, z5, nsfwAllowance2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* renamed from: component2, reason: from getter */
        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* renamed from: component5, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component6, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final ViewState copy(PanelState leftPanelState, PanelState rightPanelState, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(rightPanelState, "rightPanelState");
            return new ViewState(leftPanelState, rightPanelState, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.leftPanelState, viewState.leftPanelState) && Intrinsics3.areEqual(this.rightPanelState, viewState.rightPanelState) && this.isNsfwUnconsented == viewState.isNsfwUnconsented && this.isChannelNsfw == viewState.isChannelNsfw && Intrinsics3.areEqual(this.nsfwAllowed, viewState.nsfwAllowed) && this.guildId == viewState.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final PanelState getRightPanelState() {
            return this.rightPanelState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            PanelState panelState2 = this.rightPanelState;
            int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
            boolean z2 = this.isNsfwUnconsented;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isChannelNsfw;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return b.a(this.guildId) + ((i3 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", rightPanelState=");
            sbU.append(this.rightPanelState);
            sbU.append(", isNsfwUnconsented=");
            sbU.append(this.isNsfwUnconsented);
            sbU.append(", isChannelNsfw=");
            sbU.append(this.isChannelNsfw);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreNavigation.PanelAction.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreNavigation.PanelAction.OPEN.ordinal()] = 1;
            iArr[StoreNavigation.PanelAction.CLOSE.ordinal()] = 2;
            iArr[StoreNavigation.PanelAction.UNLOCK_LEFT.ordinal()] = 3;
            iArr[StoreNavigation.PanelAction.NOOP.ordinal()] = 4;
        }
    }

    public WidgetHomeViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable observable, Observable observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        StoreNavigation navigation = (i & 1) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreGuildWelcomeScreens guildWelcomeScreens = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildWelcomeScreens() : storeGuildWelcomeScreens;
        StoreExperiments experiments = (i & 4) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        if ((i & 64) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStoreState = Companion.access$observeStoreState(companion, guilds, companion2.getGuildSelected(), navigation, companion2.getLurking(), users, guildWelcomeScreens, companion2.getChannelsSelected(), experiments, companion2.getPermissions(), companion2.getUserConnections(), companion2.getGuildsNsfw());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(navigation, guildWelcomeScreens, experiments, guilds, permissions, users, observableAccess$observeStoreState, (i & 128) != 0 ? navigation.getNavigationPanelAction() : observable2, (i & 256) != 0 ? new ChannelOnboardingManager() : channelOnboardingManager, (i & 512) != 0 ? SharedPreferencesProvider.INSTANCE.get() : sharedPreferences, (i & 1024) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ void access$handleNavDrawerAction(WidgetHomeViewModel widgetHomeViewModel, StoreNavigation.PanelAction panelAction) {
        widgetHomeViewModel.handleNavDrawerAction(panelAction);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetHomeViewModel widgetHomeViewModel, StoreState storeState) {
        widgetHomeViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void emitAnimatePeekIn() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.AnimatePeekIn.INSTANCE);
    }

    @MainThread
    private final void emitAnimatePeekOut() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.AnimatePeekOut.INSTANCE);
    }

    @MainThread
    private final void emitClosePanelsEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ClosePanels.INSTANCE);
    }

    @MainThread
    private final void emitShowChannelOnboardingSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowChannelOnboardingSheet.INSTANCE);
    }

    @MainThread
    private final void emitShowGuildEventUpsell(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowGuildEventUpsell(guildId));
    }

    @MainThread
    private final void emitShowGuildRoleSubscriptionUpsell(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowGuildRoleSubscriptionUpsell(guildId));
    }

    @MainThread
    private final void emitShowPlaystationUpsell() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowPlaystationUpsell.INSTANCE);
    }

    @MainThread
    private final void emitShowWelcomeSheet(long guildId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowGuildWelcomeSheet(guildId));
    }

    @MainThread
    private final void emitUnlockLeftPanelEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.UnlockLeftPanel.INSTANCE);
    }

    @MainThread
    private final void handleNavDrawerAction(StoreNavigation.PanelAction navPanelAction) {
        int iOrdinal = navPanelAction.ordinal();
        if (iOrdinal == 1) {
            emitOpenLeftPanelEvent();
        } else if (iOrdinal == 2) {
            emitClosePanelsEvent();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            emitUnlockLeftPanelEvent();
        }
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        PanelState leftPanelState = storeState.getLeftPanelState();
        PanelState rightPanelState = storeState.getRightPanelState();
        long guildId = storeState.getGuildInfo().getGuildId();
        boolean zIsLurking = storeState.getGuildInfo().isLurking();
        StoreGuildWelcomeScreens.State welcomeScreenState = storeState.getGuildInfo().getWelcomeScreenState();
        boolean zIsNewUser = UserUtils.INSTANCE.isNewUser(storeState.getMe(), this.clock);
        updateViewState(new ViewState(leftPanelState, rightPanelState, storeState.getGuildInfo().isNsfwUnconsented(), storeState.isChannelNsfw(), storeState.getNsfwAllowed(), storeState.getGuildId()));
        if (zIsLurking && !this.storeGuildWelcomeScreens.hasWelcomeScreenBeenSeen(guildId)) {
            if (welcomeScreenState instanceof StoreGuildWelcomeScreens.State.Loaded) {
                emitShowWelcomeSheet(guildId);
            } else if (welcomeScreenState == null) {
                this.storeGuildWelcomeScreens.fetchIfNonexisting(guildId);
            }
        }
        if (shouldShowChannelOnboardingSheet(this.previousLeftPanelState, leftPanelState, guildId, zIsNewUser)) {
            emitShowChannelOnboardingSheet();
        } else if (shouldShowGuildEventUpsell(storeState.getGuildInfo().getCanManageEvents(), storeState.isInEventsUpsellExperiment())) {
            SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, true);
            editorEdit.apply();
            emitShowGuildEventUpsell(guildId);
        } else if (this.playstationUpsellManager.canShow(storeState.getMe(), storeState.getConnectedAccountsState())) {
            emitShowPlaystationUpsell();
            this.playstationUpsellManager.setHasBeenShown();
        } else if (storeState.getGuildInfo().getGuild() != null && this.guildRoleSubscriptionsUpsellManager.canShow(storeState.getGuildInfo().getGuild())) {
            emitShowGuildRoleSubscriptionUpsell(storeState.getGuildId());
            this.guildRoleSubscriptionsUpsellManager.setHasBeenShown();
        }
        this.previousLeftPanelState = leftPanelState;
        if (storeState.isThreadPeek() && !this.wasThreadPeek) {
            emitAnimatePeekIn();
        }
        if (!storeState.isThreadPeek() && this.wasThreadPeek) {
            emitAnimatePeekOut();
        }
        this.wasThreadPeek = storeState.isThreadPeek();
    }

    private final boolean shouldShowChannelOnboardingSheet(PanelState previousLeftPanelState, PanelState leftPanelState, long guildId, boolean isNewUser) {
        return ((previousLeftPanelState instanceof PanelState.d) && (leftPanelState instanceof PanelState.c)) && ((guildId > 0L ? 1 : (guildId == 0L ? 0 : -1)) != 0) && isNewUser && !this.channelOnboardingManager.hasUserSeenChannelOnboarding();
    }

    private final boolean shouldShowGuildEventUpsell(boolean canManageEvents, boolean isInEventsUpsellExperiment) {
        return canManageEvents && !this.sharedPreferences.getBoolean(WidgetGuildScheduledEventUpsellBottomSheet.GUILD_EVENT_UPSELL_CACHE_KEY, false) && isInEventsUpsellExperiment;
    }

    @MainThread
    public final void emitOpenLeftPanelEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.OpenLeftPanel.INSTANCE);
    }

    /* renamed from: getWidgetHomeModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetHomeModel getWidgetHomeModel() {
        return this.widgetHomeModel;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onEndPanelStateChange(PanelState panelState) {
        Intrinsics3.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setRightPanelState(panelState);
    }

    public final void onStartPanelStateChange(PanelState panelState) {
        Intrinsics3.checkNotNullParameter(panelState, "panelState");
        this.storeNavigation.setLeftPanelState(panelState);
    }

    public final void setWidgetHomeModel$app_productionGoogleRelease(WidgetHomeModel widgetHomeModel) {
        this.widgetHomeModel = widgetHomeModel;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHomeViewModel(StoreNavigation storeNavigation, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, Observable<StoreState> observable, Observable<StoreNavigation.PanelAction> observable2, ChannelOnboardingManager channelOnboardingManager, SharedPreferences sharedPreferences, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(storeGuildWelcomeScreens, "storeGuildWelcomeScreens");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(observable2, "navPanelActionObservable");
        Intrinsics3.checkNotNullParameter(channelOnboardingManager, "channelOnboardingManager");
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        PanelState.a aVar = PanelState.a.a;
        super(new ViewState(aVar, aVar, false, false, NsfwAllowance.UNKNOWN, 0L));
        this.storeNavigation = storeNavigation;
        this.storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.storeExperiments = storeExperiments;
        this.storeUser = storeUser;
        this.channelOnboardingManager = channelOnboardingManager;
        this.sharedPreferences = sharedPreferences;
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        this.playstationUpsellManager = new PlaystationUpsellManager(sharedPreferences, storeExperiments, clock);
        this.guildRoleSubscriptionsUpsellManager = new GuildRoleSubscriptionOnboardingUpsellManager(sharedPreferences, storePermissions, storeUser, storeExperiments, storeGuilds);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetHomeViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), WidgetHomeViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
