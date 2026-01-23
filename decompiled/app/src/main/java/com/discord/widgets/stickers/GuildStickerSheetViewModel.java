package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RestAPI restAPI;
    private final Sticker sticker;
    private final StoreUser storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$1 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101191 extends Lambda implements Function1<StoreState, Unit> {
        public C101191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildStickerSheetViewModel.access$handleStoreState(GuildStickerSheetViewModel.this, storeState);
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static abstract class GuildStickerGuildInfo {

            /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
            public static final /* data */ class Known extends GuildStickerGuildInfo {
                private final Integer approximateOnline;
                private final Guild guild;
                private final boolean isPublic;
                private final boolean isUserInGuild;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Known(Guild guild, boolean z2, boolean z3, Integer num) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    this.guild = guild;
                    this.isPublic = z2;
                    this.isUserInGuild = z3;
                    this.approximateOnline = num;
                }

                public static /* synthetic */ Known copy$default(Known known, Guild guild, boolean z2, boolean z3, Integer num, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guild = known.guild;
                    }
                    if ((i & 2) != 0) {
                        z2 = known.getIsPublic();
                    }
                    if ((i & 4) != 0) {
                        z3 = known.getIsUserInGuild();
                    }
                    if ((i & 8) != 0) {
                        num = known.approximateOnline;
                    }
                    return known.copy(guild, z2, z3, num);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Guild getGuild() {
                    return this.guild;
                }

                public final boolean component2() {
                    return getIsPublic();
                }

                public final boolean component3() {
                    return getIsUserInGuild();
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    return new Known(guild, isPublic, isUserInGuild, approximateOnline);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Known)) {
                        return false;
                    }
                    Known known = (Known) other;
                    return Intrinsics3.areEqual(this.guild, known.guild) && getIsPublic() == known.getIsPublic() && getIsUserInGuild() == known.getIsUserInGuild() && Intrinsics3.areEqual(this.approximateOnline, known.approximateOnline);
                }

                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Guild getGuild() {
                    return this.guild;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v4 */
                /* JADX WARN: Type inference failed for: r2v5 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                /* JADX WARN: Type inference failed for: r3v2 */
                public int hashCode() {
                    Guild guild = this.guild;
                    int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                    boolean isPublic = getIsPublic();
                    ?? r2 = isPublic;
                    if (isPublic) {
                        r2 = 1;
                    }
                    int i = (iHashCode + r2) * 31;
                    boolean isUserInGuild = getIsUserInGuild();
                    int i2 = (i + (isUserInGuild ? 1 : isUserInGuild)) * 31;
                    Integer num = this.approximateOnline;
                    return i2 + (num != null ? num.hashCode() : 0);
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isUserInGuild, reason: from getter */
                public boolean getIsUserInGuild() {
                    return this.isUserInGuild;
                }

                public String toString() {
                    StringBuilder sbM833U = outline.m833U("Known(guild=");
                    sbM833U.append(this.guild);
                    sbM833U.append(", isPublic=");
                    sbM833U.append(getIsPublic());
                    sbM833U.append(", isUserInGuild=");
                    sbM833U.append(getIsUserInGuild());
                    sbM833U.append(", approximateOnline=");
                    return outline.m818F(sbM833U, this.approximateOnline, ")");
                }
            }

            /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
            public static final class Unknown extends GuildStickerGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private GuildStickerGuildInfo() {
            }

            /* JADX INFO: renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* JADX INFO: renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ GuildStickerGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
            return companion.observeStoreState(restAPI, sticker, storeUser, storeChannelsSelected, storeGuilds);
        }

        private final Observable<GuildStickerGuildInfo> getGuildForGuildSticker(RestAPI restAPI, Sticker sticker, StoreGuilds storeGuilds) {
            Observable<GuildStickerGuildInfo> observableM11082A = Observable.m11060D(new GuildStickerSheetViewModel2(storeGuilds, sticker)).m11082A(new GuildStickerSheetViewModel3(restAPI, sticker));
            Intrinsics3.checkNotNullExpressionValue(observableM11082A, "Observable.fromCallable …      }\n        }\n      }");
            return observableM11082A;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
            Observable<StoreState> observableM11073h = Observable.m11073h(getGuildForGuildSticker(restAPI, sticker, storeGuilds), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeSelectedChannel(), storeGuilds.observeGuilds(), GuildStickerSheetViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…erGuildInfo\n      )\n    }");
            return observableM11073h;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long currentGuildId;
        private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
        private final MeUser meUser;
        private final Map<Long, Guild> userGuilds;

        public StoreState(MeUser meUser, Long l, Map<Long, Guild> map, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "userGuilds");
            Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            this.meUser = meUser;
            this.currentGuildId = l;
            this.userGuilds = map;
            this.guildStickerGuildInfo = guildStickerGuildInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Long l, Map map, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 2) != 0) {
                l = storeState.currentGuildId;
            }
            if ((i & 4) != 0) {
                map = storeState.userGuilds;
            }
            if ((i & 8) != 0) {
                guildStickerGuildInfo = storeState.guildStickerGuildInfo;
            }
            return storeState.copy(meUser, l, map, guildStickerGuildInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Map<Long, Guild> component3() {
            return this.userGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final StoreState copy(MeUser meUser, Long currentGuildId, Map<Long, Guild> userGuilds, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(userGuilds, "userGuilds");
            Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            return new StoreState(meUser, currentGuildId, userGuilds, guildStickerGuildInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.currentGuildId, storeState.currentGuildId) && Intrinsics3.areEqual(this.userGuilds, storeState.userGuilds) && Intrinsics3.areEqual(this.guildStickerGuildInfo, storeState.guildStickerGuildInfo);
        }

        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Guild> getUserGuilds() {
            return this.userGuilds;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Long l = this.currentGuildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Guild> map = this.userGuilds;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
            return iHashCode3 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", currentGuildId=");
            sbM833U.append(this.currentGuildId);
            sbM833U.append(", userGuilds=");
            sbM833U.append(this.userGuilds);
            sbM833U.append(", guildStickerGuildInfo=");
            sbM833U.append(this.guildStickerGuildInfo);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isUserPremium;
            private final Sticker sticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                super(null);
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
                Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                this.sticker = sticker;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.guildStickerGuildInfo = guildStickerGuildInfo;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = loaded.sticker;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isUserPremium;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.isCurrentGuild;
                }
                if ((i & 8) != 0) {
                    guildStickerGuildInfo = loaded.guildStickerGuildInfo;
                }
                return loaded.copy(sticker, z2, z3, guildStickerGuildInfo);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Sticker getSticker() {
                return this.sticker;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Loaded copy(Sticker sticker, boolean isUserPremium, boolean isCurrentGuild, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
                Intrinsics3.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                return new Loaded(sticker, isUserPremium, isCurrentGuild, guildStickerGuildInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.sticker, loaded.sticker) && this.isUserPremium == loaded.isUserPremium && this.isCurrentGuild == loaded.isCurrentGuild && Intrinsics3.areEqual(this.guildStickerGuildInfo, loaded.guildStickerGuildInfo);
            }

            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Sticker getSticker() {
                return this.sticker;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Sticker sticker = this.sticker;
                int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
                boolean z2 = this.isUserPremium;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                boolean z3 = this.isCurrentGuild;
                int i2 = (i + (z3 ? 1 : z3)) * 31;
                Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
                return i2 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(sticker=");
                sbM833U.append(this.sticker);
                sbM833U.append(", isUserPremium=");
                sbM833U.append(this.isUserPremium);
                sbM833U.append(", isCurrentGuild=");
                sbM833U.append(this.isCurrentGuild);
                sbM833U.append(", guildStickerGuildInfo=");
                sbM833U.append(this.guildStickerGuildInfo);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$joinGuild$1 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101261 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public C101261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            GuildStickerSheetViewModel.access$updateViewState(GuildStickerSheetViewModel.this, ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(sticker, api, users, channelsSelected, guilds, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, api, sticker, users, channelsSelected, guilds) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GuildStickerSheetViewModel guildStickerSheetViewModel, StoreState storeState) {
        guildStickerSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(GuildStickerSheetViewModel guildStickerSheetViewModel, ViewState viewState) {
        guildStickerSheetViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(this.sticker, UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()), Intrinsics3.areEqual(storeState.getCurrentGuildId(), this.sticker.getGuildId()), storeState.getGuildStickerGuildInfo()));
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelper.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, GuildStickerSheetViewModel.class, null, null, null, new C101261(), 952, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.restAPI = restAPI;
        this.storeUser = storeUser;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildStickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101191(), 62, (Object) null);
    }
}
