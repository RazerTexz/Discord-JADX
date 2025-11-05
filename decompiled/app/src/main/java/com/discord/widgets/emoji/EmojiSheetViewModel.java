package com.discord.widgets.emoji;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaFavorites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: EmojiSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EmojiNode.EmojiIdAndType emojiIdAndType;
    private final RestAPI restAPI;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreEmojiCustom storeEmojiCustom;
    private final StoreGuilds storeGuilds;
    private final StoreMediaFavorites storeMediaFavorites;
    private final StoreUser storeUsers;

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$1, reason: invalid class name */
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
            EmojiSheetViewModel emojiSheetViewModel = EmojiSheetViewModel.this;
            m.checkNotNullExpressionValue(storeState, "it");
            EmojiSheetViewModel.access$handleStoreState(emojiSheetViewModel, storeState);
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    public static final class Companion {

        /* compiled from: EmojiSheetViewModel.kt */
        public static abstract class CustomEmojGuildInfo {

            /* compiled from: EmojiSheetViewModel.kt */
            public static final /* data */ class Known extends CustomEmojGuildInfo {
                private final Integer approximateOnline;
                private final Guild guild;
                private final boolean isPublic;
                private final boolean isUserInGuild;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Known(Guild guild, boolean z2, boolean z3, Integer num) {
                    super(null);
                    m.checkNotNullParameter(guild, "guild");
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

                /* renamed from: component1, reason: from getter */
                public final Guild getGuild() {
                    return this.guild;
                }

                public final boolean component2() {
                    return getIsPublic();
                }

                public final boolean component3() {
                    return getIsUserInGuild();
                }

                /* renamed from: component4, reason: from getter */
                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
                    m.checkNotNullParameter(guild, "guild");
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
                    return m.areEqual(this.guild, known.guild) && getIsPublic() == known.getIsPublic() && getIsUserInGuild() == known.getIsUserInGuild() && m.areEqual(this.approximateOnline, known.approximateOnline);
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

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isUserInGuild, reason: from getter */
                public boolean getIsUserInGuild() {
                    return this.isUserInGuild;
                }

                public String toString() {
                    StringBuilder sbU = a.U("Known(guild=");
                    sbU.append(this.guild);
                    sbU.append(", isPublic=");
                    sbU.append(getIsPublic());
                    sbU.append(", isUserInGuild=");
                    sbU.append(getIsUserInGuild());
                    sbU.append(", approximateOnline=");
                    return a.F(sbU, this.approximateOnline, ")");
                }
            }

            /* compiled from: EmojiSheetViewModel.kt */
            public static final class Unknown extends CustomEmojGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private CustomEmojGuildInfo() {
            }

            /* renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ CustomEmojGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreUser storeUser, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
            return companion.observeStoreState(restAPI, emojiIdAndType, storeUser, storeGuilds, storeEmojiCustom, storeChannelsSelected, storeMediaFavorites);
        }

        private final Observable<CustomEmojGuildInfo> getGuildForCustomEmoji(RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
            if (!(emojiIdAndType instanceof EmojiNode.EmojiIdAndType.Custom)) {
                emojiIdAndType = null;
            }
            EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emojiIdAndType;
            if (custom != null) {
                Observable<CustomEmojGuildInfo> observableA = Observable.D(new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1(storeEmojiCustom, custom, storeGuilds)).A(new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2(restAPI, custom));
                m.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
                return observableA;
            }
            k kVar = new k(null);
            m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
            return kVar;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, StoreUser storeUsers, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
            Observable<StoreState> observableG = Observable.g(getGuildForCustomEmoji(restAPI, emojiIdAndType, storeGuilds, storeEmojiCustom), StoreUser.observeMe$default(storeUsers, false, 1, null), storeGuilds.observeGuilds(), storeChannelsSelected.observeSelectedChannel(), storeMediaFavorites.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), new EmojiSheetViewModel$Companion$observeStoreState$1(emojiIdAndType));
            m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…es,\n          )\n        }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel currentChannel;
        private final Companion.CustomEmojGuildInfo customEmojiGuildInfo;
        private final EmojiNode.EmojiIdAndType emoji;
        private final Set<StoreMediaFavorites.Favorite> favorites;
        private final Set<Long> joinedGuildIds;
        private final boolean meUserIsPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set<Long> set, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set2) {
            m.checkNotNullParameter(emojiIdAndType, "emoji");
            m.checkNotNullParameter(set, "joinedGuildIds");
            m.checkNotNullParameter(set2, "favorites");
            this.customEmojiGuildInfo = customEmojGuildInfo;
            this.emoji = emojiIdAndType;
            this.meUserIsPremium = z2;
            this.joinedGuildIds = set;
            this.currentChannel = channel;
            this.favorites = set2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set set, Channel channel, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                customEmojGuildInfo = storeState.customEmojiGuildInfo;
            }
            if ((i & 2) != 0) {
                emojiIdAndType = storeState.emoji;
            }
            EmojiNode.EmojiIdAndType emojiIdAndType2 = emojiIdAndType;
            if ((i & 4) != 0) {
                z2 = storeState.meUserIsPremium;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                set = storeState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                channel = storeState.currentChannel;
            }
            Channel channel2 = channel;
            if ((i & 32) != 0) {
                set2 = storeState.favorites;
            }
            return storeState.copy(customEmojGuildInfo, emojiIdAndType2, z3, set3, channel2, set2);
        }

        /* renamed from: component1, reason: from getter */
        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        /* renamed from: component2, reason: from getter */
        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        /* renamed from: component5, reason: from getter */
        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Set<StoreMediaFavorites.Favorite> component6() {
            return this.favorites;
        }

        public final StoreState copy(Companion.CustomEmojGuildInfo customEmojiGuildInfo, EmojiNode.EmojiIdAndType emoji, boolean meUserIsPremium, Set<Long> joinedGuildIds, Channel currentChannel, Set<? extends StoreMediaFavorites.Favorite> favorites) {
            m.checkNotNullParameter(emoji, "emoji");
            m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            m.checkNotNullParameter(favorites, "favorites");
            return new StoreState(customEmojiGuildInfo, emoji, meUserIsPremium, joinedGuildIds, currentChannel, favorites);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.customEmojiGuildInfo, storeState.customEmojiGuildInfo) && m.areEqual(this.emoji, storeState.emoji) && this.meUserIsPremium == storeState.meUserIsPremium && m.areEqual(this.joinedGuildIds, storeState.joinedGuildIds) && m.areEqual(this.currentChannel, storeState.currentChannel) && m.areEqual(this.favorites, storeState.favorites);
        }

        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        public final Set<StoreMediaFavorites.Favorite> getFavorites() {
            return this.favorites;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Companion.CustomEmojGuildInfo customEmojGuildInfo = this.customEmojiGuildInfo;
            int iHashCode = (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0) * 31;
            EmojiNode.EmojiIdAndType emojiIdAndType = this.emoji;
            int iHashCode2 = (iHashCode + (emojiIdAndType != null ? emojiIdAndType.hashCode() : 0)) * 31;
            boolean z2 = this.meUserIsPremium;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (i2 + (set != null ? set.hashCode() : 0)) * 31;
            Channel channel = this.currentChannel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<StoreMediaFavorites.Favorite> set2 = this.favorites;
            return iHashCode4 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(customEmojiGuildInfo=");
            sbU.append(this.customEmojiGuildInfo);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", meUserIsPremium=");
            sbU.append(this.meUserIsPremium);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", currentChannel=");
            sbU.append(this.currentChannel);
            sbU.append(", favorites=");
            return a.N(sbU, this.favorites, ")");
        }
    }

    /* compiled from: EmojiSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: EmojiSheetViewModel.kt */
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        public static final /* data */ class EmojiCustom extends ViewState {
            private final boolean canFavorite;
            private final EmojiNode.EmojiIdAndType.Custom emojiCustom;
            private final Companion.CustomEmojGuildInfo emojiGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isFavorite;
            private final boolean isUserPremium;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiCustom(EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(null);
                m.checkNotNullParameter(custom, "emojiCustom");
                m.checkNotNullParameter(customEmojGuildInfo, "emojiGuildInfo");
                this.emojiCustom = custom;
                this.emojiGuildInfo = customEmojGuildInfo;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.canFavorite = z4;
                this.isFavorite = z5;
            }

            public static /* synthetic */ EmojiCustom copy$default(EmojiCustom emojiCustom, EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
                if ((i & 1) != 0) {
                    custom = emojiCustom.emojiCustom;
                }
                if ((i & 2) != 0) {
                    customEmojGuildInfo = emojiCustom.emojiGuildInfo;
                }
                Companion.CustomEmojGuildInfo customEmojGuildInfo2 = customEmojGuildInfo;
                if ((i & 4) != 0) {
                    z2 = emojiCustom.isUserPremium;
                }
                boolean z6 = z2;
                if ((i & 8) != 0) {
                    z3 = emojiCustom.isCurrentGuild;
                }
                boolean z7 = z3;
                if ((i & 16) != 0) {
                    z4 = emojiCustom.canFavorite;
                }
                boolean z8 = z4;
                if ((i & 32) != 0) {
                    z5 = emojiCustom.isFavorite;
                }
                return emojiCustom.copy(custom, customEmojGuildInfo2, z6, z7, z8, z5);
            }

            /* renamed from: component1, reason: from getter */
            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            /* renamed from: component2, reason: from getter */
            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiCustom copy(EmojiNode.EmojiIdAndType.Custom emojiCustom, Companion.CustomEmojGuildInfo emojiGuildInfo, boolean isUserPremium, boolean isCurrentGuild, boolean canFavorite, boolean isFavorite) {
                m.checkNotNullParameter(emojiCustom, "emojiCustom");
                m.checkNotNullParameter(emojiGuildInfo, "emojiGuildInfo");
                return new EmojiCustom(emojiCustom, emojiGuildInfo, isUserPremium, isCurrentGuild, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiCustom)) {
                    return false;
                }
                EmojiCustom emojiCustom = (EmojiCustom) other;
                return m.areEqual(this.emojiCustom, emojiCustom.emojiCustom) && m.areEqual(this.emojiGuildInfo, emojiCustom.emojiGuildInfo) && this.isUserPremium == emojiCustom.isUserPremium && this.isCurrentGuild == emojiCustom.isCurrentGuild && this.canFavorite == emojiCustom.canFavorite && this.isFavorite == emojiCustom.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                EmojiNode.EmojiIdAndType.Custom custom = this.emojiCustom;
                int iHashCode = (custom != null ? custom.hashCode() : 0) * 31;
                Companion.CustomEmojGuildInfo customEmojGuildInfo = this.emojiGuildInfo;
                int iHashCode2 = (iHashCode + (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0)) * 31;
                boolean z2 = this.isUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.isCurrentGuild;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.canFavorite;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isFavorite;
                return i6 + (z5 ? 1 : z5 ? 1 : 0);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbU = a.U("EmojiCustom(emojiCustom=");
                sbU.append(this.emojiCustom);
                sbU.append(", emojiGuildInfo=");
                sbU.append(this.emojiGuildInfo);
                sbU.append(", isUserPremium=");
                sbU.append(this.isUserPremium);
                sbU.append(", isCurrentGuild=");
                sbU.append(this.isCurrentGuild);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return a.O(sbU, this.isFavorite, ")");
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        public static final /* data */ class EmojiUnicode extends ViewState {
            private final boolean canFavorite;
            private final ModelEmojiUnicode emojiUnicode;
            private final boolean isFavorite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiUnicode(ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3) {
                super(null);
                m.checkNotNullParameter(modelEmojiUnicode, "emojiUnicode");
                this.emojiUnicode = modelEmojiUnicode;
                this.canFavorite = z2;
                this.isFavorite = z3;
            }

            public static /* synthetic */ EmojiUnicode copy$default(EmojiUnicode emojiUnicode, ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiUnicode = emojiUnicode.emojiUnicode;
                }
                if ((i & 2) != 0) {
                    z2 = emojiUnicode.canFavorite;
                }
                if ((i & 4) != 0) {
                    z3 = emojiUnicode.isFavorite;
                }
                return emojiUnicode.copy(modelEmojiUnicode, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiUnicode copy(ModelEmojiUnicode emojiUnicode, boolean canFavorite, boolean isFavorite) {
                m.checkNotNullParameter(emojiUnicode, "emojiUnicode");
                return new EmojiUnicode(emojiUnicode, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiUnicode)) {
                    return false;
                }
                EmojiUnicode emojiUnicode = (EmojiUnicode) other;
                return m.areEqual(this.emojiUnicode, emojiUnicode.emojiUnicode) && this.canFavorite == emojiUnicode.canFavorite && this.isFavorite == emojiUnicode.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelEmojiUnicode modelEmojiUnicode = this.emojiUnicode;
                int iHashCode = (modelEmojiUnicode != null ? modelEmojiUnicode.hashCode() : 0) * 31;
                boolean z2 = this.canFavorite;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isFavorite;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public String toString() {
                StringBuilder sbU = a.U("EmojiUnicode(emojiUnicode=");
                sbU.append(this.emojiUnicode);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return a.O(sbU, this.isFavorite, ")");
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: EmojiSheetViewModel.kt */
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

    /* compiled from: EmojiSheetViewModel.kt */
    /* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            m.checkNotNullParameter(guild, "it");
            EmojiSheetViewModel.access$updateViewState(EmojiSheetViewModel.this, ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreEmoji emojis = (i & 4) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreEmojiCustom customEmojis = (i & 8) != 0 ? StoreStream.INSTANCE.getCustomEmojis() : storeEmojiCustom;
        StoreAnalytics analytics = (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannelsSelected channelsSelected = (i & 128) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreMediaFavorites mediaFavorites = (i & 256) != 0 ? StoreStream.INSTANCE.getMediaFavorites() : storeMediaFavorites;
        this(emojiIdAndType, api, emojis, customEmojis, analytics, users, guilds, channelsSelected, mediaFavorites, (i & 512) != 0 ? Companion.access$observeStoreState(INSTANCE, api, emojiIdAndType, users, guilds, customEmojis, channelsSelected, mediaFavorites) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EmojiSheetViewModel emojiSheetViewModel, StoreState storeState) {
        emojiSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(EmojiSheetViewModel emojiSheetViewModel, ViewState viewState) {
        emojiSheetViewModel.updateViewState(viewState);
    }

    private final void customPopoutAnalytics(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        m.checkNotNull(customEmojiGuildInfo);
        boolean z2 = !customEmojiGuildInfo.getIsPublic();
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        boolean meUserIsPremium = storeState.getMeUserIsPremium();
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openCustomEmojiPopout(currentChannel, custom.getId(), meUserIsPremium, isUserInGuild, z2);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        if (emoji instanceof EmojiNode.EmojiIdAndType.Unicode) {
            standardPopoutAnalytics(storeState);
            handleStoreStateUnicode(storeState);
        } else if (emoji instanceof EmojiNode.EmojiIdAndType.Custom) {
            customPopoutAnalytics(storeState);
            handleStoreStateCustom(storeState);
        }
    }

    private final void handleStoreStateCustom(StoreState storeState) {
        boolean z2;
        Guild guild;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        m.checkNotNull(customEmojiGuildInfo);
        boolean zContains = storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavCustomEmoji(custom));
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        Channel currentChannel = storeState.getCurrentChannel();
        boolean z3 = false;
        if (currentChannel != null) {
            long guildId = currentChannel.getGuildId();
            Companion.CustomEmojGuildInfo.Known known = (Companion.CustomEmojGuildInfo.Known) (!(customEmojiGuildInfo instanceof Companion.CustomEmojGuildInfo.Known) ? null : customEmojiGuildInfo);
            if (known != null && (guild = known.getGuild()) != null && guild.getId() == guildId) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        updateViewState(new ViewState.EmojiCustom(custom, customEmojiGuildInfo, storeState.getMeUserIsPremium(), z2, isUserInGuild, zContains));
    }

    private final void handleStoreStateUnicode(StoreState storeState) {
        ViewState emojiUnicode;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Unicode");
        ModelEmojiUnicode modelEmojiUnicode = this.storeEmoji.getUnicodeEmojisNamesMap().get(((EmojiNode.EmojiIdAndType.Unicode) emoji).getName());
        if (modelEmojiUnicode != null) {
            emojiUnicode = new ViewState.EmojiUnicode(modelEmojiUnicode, true, storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavUnicodeEmoji(modelEmojiUnicode)));
        } else {
            emojiUnicode = ViewState.Invalid.INSTANCE;
        }
        updateViewState(emojiUnicode);
    }

    private final void standardPopoutAnalytics(StoreState storeState) {
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openUnicodeEmojiPopout(currentChannel);
        }
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelperKt.joinGuild$default(contextRequireContext, guild.getId(), false, null, null, null, EmojiSheetViewModel.class, null, null, null, new AnonymousClass1(), 952, null);
    }

    public final void setFavorite(boolean favorite) {
        Object favUnicodeEmoji;
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState instanceof ViewState.EmojiCustom) {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavCustomEmoji(((ViewState.EmojiCustom) viewState).getEmojiCustom());
            } else if (!(viewState instanceof ViewState.EmojiUnicode)) {
                return;
            } else {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavUnicodeEmoji(((ViewState.EmojiUnicode) viewState).getEmojiUnicode());
            }
            Object exhaustive = KotlinExtensionsKt.getExhaustive(favUnicodeEmoji);
            if (favorite) {
                this.storeMediaFavorites.addFavorite((StoreMediaFavorites.Favorite) exhaustive);
            } else {
                this.storeMediaFavorites.removeFavorite((StoreMediaFavorites.Favorite) exhaustive);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeMediaFavorites, "storeMediaFavorites");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.emojiIdAndType = emojiIdAndType;
        this.restAPI = restAPI;
        this.storeEmoji = storeEmoji;
        this.storeEmojiCustom = storeEmojiCustom;
        this.storeAnalytics = storeAnalytics;
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeMediaFavorites = storeMediaFavorites;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, EmojiSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
