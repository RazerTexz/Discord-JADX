package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetThreadBrowserViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$1, reason: invalid class name */
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
            WidgetThreadBrowserViewModel.access$handleStoreState(WidgetThreadBrowserViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            return companion.observeStoreState(j, j2, storeChannels, storeGuilds, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(long channelId, long guildId, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            Observable<StoreState> observableI = Observable.i(storeChannels.observeChannel(channelId), storeGuilds.observeGuild(guildId), storePermissions.observePermissionsForChannel(channelId), WidgetThreadBrowserViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…issions\n        )\n      }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Long permissions;

        public StoreState(Channel channel, Guild guild, Long l) {
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, Guild guild, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            if ((i & 4) != 0) {
                l = storeState.permissions;
            }
            return storeState.copy(channel, guild, l);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(Channel channel, Guild guild, Long permissions) {
            return new StoreState(channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.channel, storeState.channel) && m.areEqual(this.guild, storeState.guild) && m.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            return a.G(sbU, this.permissions, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetThreadBrowserViewModel.kt */
        public static final /* data */ class Browser extends ViewState {
            private final boolean canCreateThread;
            private final boolean canViewArchivedThreads;
            private final String channelName;
            private final boolean isForumChannel;

            public Browser(String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                this.channelName = str;
                this.canCreateThread = z2;
                this.canViewArchivedThreads = z3;
                this.isForumChannel = z4;
            }

            public static /* synthetic */ Browser copy$default(Browser browser, String str, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = browser.channelName;
                }
                if ((i & 2) != 0) {
                    z2 = browser.canCreateThread;
                }
                if ((i & 4) != 0) {
                    z3 = browser.canViewArchivedThreads;
                }
                if ((i & 8) != 0) {
                    z4 = browser.isForumChannel;
                }
                return browser.copy(str, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getChannelName() {
                return this.channelName;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsForumChannel() {
                return this.isForumChannel;
            }

            public final Browser copy(String channelName, boolean canCreateThread, boolean canViewArchivedThreads, boolean isForumChannel) {
                return new Browser(channelName, canCreateThread, canViewArchivedThreads, isForumChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Browser)) {
                    return false;
                }
                Browser browser = (Browser) other;
                return m.areEqual(this.channelName, browser.channelName) && this.canCreateThread == browser.canCreateThread && this.canViewArchivedThreads == browser.canViewArchivedThreads && this.isForumChannel == browser.isForumChannel;
            }

            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            public final String getChannelName() {
                return this.channelName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.channelName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.canCreateThread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.canViewArchivedThreads;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isForumChannel;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isForumChannel() {
                return this.isForumChannel;
            }

            public String toString() {
                StringBuilder sbU = a.U("Browser(channelName=");
                sbU.append(this.channelName);
                sbU.append(", canCreateThread=");
                sbU.append(this.canCreateThread);
                sbU.append(", canViewArchivedThreads=");
                sbU.append(this.canViewArchivedThreads);
                sbU.append(", isForumChannel=");
                return a.O(sbU, this.isForumChannel, ")");
            }
        }

        /* compiled from: WidgetThreadBrowserViewModel.kt */
        public static final /* data */ class GoToChannel extends ViewState {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GoToChannel(Channel channel) {
                super(null);
                m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ GoToChannel copy$default(GoToChannel goToChannel, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = goToChannel.channel;
                }
                return goToChannel.copy(channel);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final GoToChannel copy(Channel channel) {
                m.checkNotNullParameter(channel, "channel");
                return new GoToChannel(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof GoToChannel) && m.areEqual(this.channel, ((GoToChannel) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("GoToChannel(channel=");
                sbU.append(this.channel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, channels, guilds, permissions, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, j2, j, channels, guilds, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel, StoreState storeState) {
        widgetThreadBrowserViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.GoToChannel) {
            return;
        }
        Channel channel = storeState.getChannel();
        String strC = channel != null ? ChannelUtils.c(channel) : null;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        boolean zCanCreateThread = threadUtils.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild());
        boolean zCanViewAllPublicArchivedThreads = threadUtils.canViewAllPublicArchivedThreads(storeState.getChannel(), storeState.getPermissions());
        Channel channel2 = storeState.getChannel();
        updateViewState(new ViewState.Browser(strC, zCanCreateThread, zCanViewAllPublicArchivedThreads, channel2 != null && channel2.getType() == 15));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void openThread(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        updateViewState(new ViewState.GoToChannel(channel));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
