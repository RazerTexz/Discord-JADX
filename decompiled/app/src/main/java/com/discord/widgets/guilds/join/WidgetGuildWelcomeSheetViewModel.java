package com.discord.widgets.guilds.join;

import a0.a.a.b;
import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long guildId;

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
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
            m.checkNotNullParameter(storeState, "storeState");
            WidgetGuildWelcomeSheetViewModel.access$handleStoreState(WidgetGuildWelcomeSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getGuilds().observeGuild(guildId), companion.getGuildWelcomeScreens().observeGuildWelcomeScreen(guildId), WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable\n            .…          )\n            }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildWelcomeScreens.State guildWelcomeScreen;

        public StoreState(Guild guild, StoreGuildWelcomeScreens.State state) {
            this.guild = guild;
            this.guildWelcomeScreen = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildWelcomeScreens.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                state = storeState.guildWelcomeScreen;
            }
            return storeState.copy(guild, state);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public final StoreState copy(Guild guild, StoreGuildWelcomeScreens.State guildWelcomeScreen) {
            return new StoreState(guild, guildWelcomeScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.guild, storeState.guild) && m.areEqual(this.guildWelcomeScreen, storeState.guildWelcomeScreen);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildWelcomeScreens.State state = this.guildWelcomeScreen;
            return iHashCode + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", guildWelcomeScreen=");
            sbU.append(this.guildWelcomeScreen);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final List<GuildWelcomeChannel> welcomeChannelsData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, List<GuildWelcomeChannel> list) {
                super(null);
                m.checkNotNullParameter(str, "guildName");
                m.checkNotNullParameter(str2, "guildShortName");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.welcomeChannelsData = list;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, String str, String str2, String str3, String str4, List list, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.guildId : j, (i & 2) != 0 ? loaded.guildName : str, (i & 4) != 0 ? loaded.guildShortName : str2, (i & 8) != 0 ? loaded.guildIcon : str3, (i & 16) != 0 ? loaded.guildDescription : str4, (i & 32) != 0 ? loaded.welcomeChannelsData : list);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final List<GuildWelcomeChannel> component6() {
                return this.welcomeChannelsData;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, List<GuildWelcomeChannel> welcomeChannelsData) {
                m.checkNotNullParameter(guildName, "guildName");
                m.checkNotNullParameter(guildShortName, "guildShortName");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, welcomeChannelsData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && m.areEqual(this.guildName, loaded.guildName) && m.areEqual(this.guildShortName, loaded.guildShortName) && m.areEqual(this.guildIcon, loaded.guildIcon) && m.areEqual(this.guildDescription, loaded.guildDescription) && m.areEqual(this.welcomeChannelsData, loaded.welcomeChannelsData);
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final List<GuildWelcomeChannel> getWelcomeChannelsData() {
                return this.welcomeChannelsData;
            }

            public int hashCode() {
                int iA = b.a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                List<GuildWelcomeChannel> list = this.welcomeChannelsData;
                return iHashCode4 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildShortName=");
                sbU.append(this.guildShortName);
                sbU.append(", guildIcon=");
                sbU.append(this.guildIcon);
                sbU.append(", guildDescription=");
                sbU.append(this.guildDescription);
                sbU.append(", welcomeChannelsData=");
                return a.L(sbU, this.welcomeChannelsData, ")");
            }
        }

        /* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ WidgetGuildWelcomeSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildWelcomeSheetViewModel widgetGuildWelcomeSheetViewModel, StoreState storeState) {
        widgetGuildWelcomeSheetViewModel.handleStoreState(storeState);
    }

    private final void handleLoadedGuild(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen != null ? welcomeScreen.getDescription() : null, welcomeScreen != null ? welcomeScreen.b() : null));
    }

    private final void handleLoadedWelcomeScreen(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen.getDescription(), welcomeScreen.b()));
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildWelcomeScreens.State guildWelcomeScreen = storeState.getGuildWelcomeScreen();
        StoreGuildWelcomeScreens.State.Loaded loaded = (StoreGuildWelcomeScreens.State.Loaded) (!(guildWelcomeScreen instanceof StoreGuildWelcomeScreens.State.Loaded) ? null : guildWelcomeScreen);
        if (guild != null && guildWelcomeScreen == StoreGuildWelcomeScreens.State.Failure.INSTANCE) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (guildWelcomeScreen == StoreGuildWelcomeScreens.State.Fetching.INSTANCE) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (guild != null) {
            if ((loaded != null ? loaded.getData() : null) != null) {
                handleLoadedWelcomeScreen(guild, loaded.getData());
                return;
            }
        }
        if (guild != null) {
            handleLoadedGuild(guild, loaded != null ? loaded.getData() : null);
            return;
        }
        if ((loaded != null ? loaded.getData() : null) == null) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    public final void onClickChannel(long guildId, long channelId, int index, List<GuildWelcomeChannel> welcomeChannels) {
        m.checkNotNullParameter(welcomeChannels, "welcomeChannels");
        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), guildId, channelId, null, null, 12, null);
        String description = welcomeChannels.get(index).getDescription();
        boolean z2 = welcomeChannels.get(index).getEmojiId() != null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GuildWelcomeChannel guildWelcomeChannel : welcomeChannels) {
            arrayList2.add(Long.valueOf(guildWelcomeChannel.getChannelId()));
            arrayList.add(guildWelcomeChannel.getDescription());
        }
        AnalyticsTracker.welcomeScreenChannelSelected(index, guildId, arrayList, arrayList2, description, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheetViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetGuildWelcomeSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildWelcomeScreens().fetchIfNonexisting(j);
        companion.getGuildWelcomeScreens().markWelcomeScreenShown(j);
        AnalyticsTracker.openModal("Guild Welcome Screen", "", Long.valueOf(j));
    }
}
