package com.discord.widgets.chat.input.sticker;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems2;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems3;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: StickerPickerViewModel.kt */
/* loaded from: classes2.dex */
public class StickerPickerViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long RECENT_SELECTED_ID = -1;
    private final StoreChannelsSelected channelSelectedStore;
    private final StoreChannels channelStore;
    private final PublishSubject<Event> eventSubject;
    private final long initialStickerPackId;
    private final Locale locale;
    private final MessageManager messageManager;
    private final StorePermissions permissionStore;
    private final BehaviorSubject<String> searchSubject;
    private final BehaviorSubject<Long> selectedCategoryIdSubject;
    private int stickerCountToDisplayForStore;
    private final StoreStickers stickersStore;
    private final StoreUser userStore;

    /* compiled from: StickerPickerViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$1, reason: invalid class name */
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
            StickerPickerViewModel stickerPickerViewModel = StickerPickerViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            StickerPickerViewModel.access$handleStoreState(stickerPickerViewModel, storeState);
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ List access$buildGuildStickersListItems(Companion companion, List list, Guild guild, int i, String str, MeUser meUser, Locale locale, Channel channel, long j) {
            return companion.buildGuildStickersListItems(list, guild, i, str, meUser, locale, channel, j);
        }

        public static final /* synthetic */ List access$buildStickerListItems(Companion companion, ModelStickerPack modelStickerPack, String str, int i, Locale locale, MeUser meUser) {
            return companion.buildStickerListItems(modelStickerPack, str, i, locale, meUser);
        }

        private final List<MGRecyclerDataPayload> buildGuildStickersListItems(List<Sticker> stickers, Guild guild, int stickerAnimationSettings, String searchInputLower, MeUser meUser, Locale locale, Channel currentChannel, long currentChannelPermissions) {
            ArrayList arrayList = new ArrayList();
            for (Sticker sticker : stickers) {
                String name = sticker.getName();
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!Strings4.contains$default((CharSequence) lowerCase, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                    String tags = sticker.getTags();
                    Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase2 = tags.toLowerCase(locale);
                    Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                    if (Strings4.contains$default((CharSequence) lowerCase2, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                    }
                }
                arrayList.add(new StickerAdapterItems3(sticker, stickerAnimationSettings, StickerAdapterItems3.Mode.OWNED, StickerUtils.INSTANCE.getStickerSendability(sticker, meUser, currentChannel, Long.valueOf(currentChannelPermissions))));
            }
            if ((searchInputLower.length() > 0) && arrayList.isEmpty()) {
                return Collections2.emptyList();
            }
            arrayList.add(0, new StickerAdapterItems(new StickerAdapterItems2.GuildItem(guild)));
            return arrayList;
        }

        private final List<MGRecyclerDataPayload> buildStickerListItems(ModelStickerPack stickerPack, String searchInputLower, int stickerAnimationSettings, Locale locale, MeUser meUser) {
            ArrayList arrayList = new ArrayList();
            if (stickerPack.getStickers().isEmpty()) {
                return Collections2.emptyList();
            }
            for (Sticker sticker : stickerPack.getStickers()) {
                String name = sticker.getName();
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!Strings4.contains$default((CharSequence) lowerCase, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                    String tags = sticker.getTags();
                    Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase2 = tags.toLowerCase(locale);
                    Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                    if (Strings4.contains$default((CharSequence) lowerCase2, (CharSequence) searchInputLower, false, 2, (Object) null)) {
                    }
                }
                arrayList.add(new StickerAdapterItems3(sticker, stickerAnimationSettings, StickerAdapterItems3.Mode.OWNED, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
            }
            if ((searchInputLower.length() > 0) && arrayList.isEmpty()) {
                return Collections2.emptyList();
            }
            arrayList.add(0, new StickerAdapterItems(new StickerAdapterItems2.PackItem(stickerPack)));
            return arrayList;
        }

        private final Observable<StoreState> observeStoreState(BehaviorSubject<String> searchSubject, BehaviorSubject<Long> selectedPackIdSubject, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelSelected, StorePermissions storePermissions, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds) {
            Observable observableY = storeChannelSelected.observeResolvedSelectedChannel().Y(new StickerPickerViewModel2(storeGuilds, storeGuildsSorted, storeGuildStickers, storeStickers, searchSubject, storeUserSettings, selectedPackIdSubject, storeUser, storeExpressionPickerNavigation, storePermissions, storeSlowMode));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelSelected.obs…      )\n        }\n      }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, int i, Object obj) {
            return companion.observeStoreState(behaviorSubject, behaviorSubject2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted, (i & 8) != 0 ? StoreStream.INSTANCE.getGuildStickers() : storeGuildStickers, (i & 16) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, (i & 32) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 64) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 128) != 0 ? StoreStream.INSTANCE.getExpressionPickerNavigation() : storeExpressionPickerNavigation, (i & 256) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 1024) != 0 ? StoreStream.INSTANCE.getSlowMode() : storeSlowMode, (i & 2048) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    public static abstract class Event {

        /* compiled from: StickerPickerViewModel.kt */
        public static final /* data */ class ScrollToStickerItemPosition extends Event {
            private final int position;

            public ScrollToStickerItemPosition(int i) {
                super(null);
                this.position = i;
            }

            public static /* synthetic */ ScrollToStickerItemPosition copy$default(ScrollToStickerItemPosition scrollToStickerItemPosition, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = scrollToStickerItemPosition.position;
                }
                return scrollToStickerItemPosition.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getPosition() {
                return this.position;
            }

            public final ScrollToStickerItemPosition copy(int position) {
                return new ScrollToStickerItemPosition(position);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ScrollToStickerItemPosition) && this.position == ((ScrollToStickerItemPosition) other).position;
                }
                return true;
            }

            public final int getPosition() {
                return this.position;
            }

            public int hashCode() {
                return this.position;
            }

            public String toString() {
                return outline.B(outline.U("ScrollToStickerItemPosition(position="), this.position, ")");
            }
        }

        /* compiled from: StickerPickerViewModel.kt */
        public static final class ShowStickerPremiumUpsell extends Event {
            public static final ShowStickerPremiumUpsell INSTANCE = new ShowStickerPremiumUpsell();

            private ShowStickerPremiumUpsell() {
                super(null);
            }
        }

        /* compiled from: StickerPickerViewModel.kt */
        public static final class SlowMode extends Event {
            public static final SlowMode INSTANCE = new SlowMode();

            private SlowMode() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: StickerPickerViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final LinkedHashMap<Long, Guild> allGuilds;
            private final Channel currentChannel;
            private final long currentChannelPermissions;
            private final List<ModelStickerPack> enabledStickerPacks;
            private final List<Long> frequentlyUsedStickerIds;
            private final Map<Long, Map<Long, Sticker>> guildStickers;
            private final boolean isOnCooldown;
            private final boolean isStickersSelectedTab;
            private final MeUser meUser;
            private final String searchInputStringUpper;
            private final Long selectedCategoryId;
            private final int stickerAnimationSettings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, Sticker>> map, List<ModelStickerPack> list, List<Long> list2, String str, int i, Long l, MeUser meUser, boolean z2, Channel channel, long j, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(linkedHashMap, "allGuilds");
                Intrinsics3.checkNotNullParameter(map, "guildStickers");
                Intrinsics3.checkNotNullParameter(list, "enabledStickerPacks");
                Intrinsics3.checkNotNullParameter(list2, "frequentlyUsedStickerIds");
                Intrinsics3.checkNotNullParameter(str, "searchInputStringUpper");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.allGuilds = linkedHashMap;
                this.guildStickers = map;
                this.enabledStickerPacks = list;
                this.frequentlyUsedStickerIds = list2;
                this.searchInputStringUpper = str;
                this.stickerAnimationSettings = i;
                this.selectedCategoryId = l;
                this.meUser = meUser;
                this.isStickersSelectedTab = z2;
                this.currentChannel = channel;
                this.currentChannelPermissions = j;
                this.isOnCooldown = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, LinkedHashMap linkedHashMap, Map map, List list, List list2, String str, int i, Long l, MeUser meUser, boolean z2, Channel channel, long j, boolean z3, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.allGuilds : linkedHashMap, (i2 & 2) != 0 ? loaded.guildStickers : map, (i2 & 4) != 0 ? loaded.enabledStickerPacks : list, (i2 & 8) != 0 ? loaded.frequentlyUsedStickerIds : list2, (i2 & 16) != 0 ? loaded.searchInputStringUpper : str, (i2 & 32) != 0 ? loaded.stickerAnimationSettings : i, (i2 & 64) != 0 ? loaded.selectedCategoryId : l, (i2 & 128) != 0 ? loaded.meUser : meUser, (i2 & 256) != 0 ? loaded.isStickersSelectedTab : z2, (i2 & 512) != 0 ? loaded.currentChannel : channel, (i2 & 1024) != 0 ? loaded.currentChannelPermissions : j, (i2 & 2048) != 0 ? loaded.isOnCooldown : z3);
            }

            public final boolean canUseExternalStickersInCurrentChannel(long externalStickerGuildId) {
                Channel channel = this.currentChannel;
                if ((channel != null && ChannelUtils.B(channel)) || PermissionUtils.can(Permission.USE_EXTERNAL_STICKERS, Long.valueOf(this.currentChannelPermissions))) {
                    return true;
                }
                Channel channel2 = this.currentChannel;
                return channel2 != null && externalStickerGuildId == channel2.getGuildId();
            }

            public final LinkedHashMap<Long, Guild> component1() {
                return this.allGuilds;
            }

            /* renamed from: component10, reason: from getter */
            public final Channel getCurrentChannel() {
                return this.currentChannel;
            }

            /* renamed from: component11, reason: from getter */
            public final long getCurrentChannelPermissions() {
                return this.currentChannelPermissions;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            public final Map<Long, Map<Long, Sticker>> component2() {
                return this.guildStickers;
            }

            public final List<ModelStickerPack> component3() {
                return this.enabledStickerPacks;
            }

            public final List<Long> component4() {
                return this.frequentlyUsedStickerIds;
            }

            /* renamed from: component5, reason: from getter */
            public final String getSearchInputStringUpper() {
                return this.searchInputStringUpper;
            }

            /* renamed from: component6, reason: from getter */
            public final int getStickerAnimationSettings() {
                return this.stickerAnimationSettings;
            }

            /* renamed from: component7, reason: from getter */
            public final Long getSelectedCategoryId() {
                return this.selectedCategoryId;
            }

            /* renamed from: component8, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            public final Loaded copy(LinkedHashMap<Long, Guild> allGuilds, Map<Long, ? extends Map<Long, Sticker>> guildStickers, List<ModelStickerPack> enabledStickerPacks, List<Long> frequentlyUsedStickerIds, String searchInputStringUpper, int stickerAnimationSettings, Long selectedCategoryId, MeUser meUser, boolean isStickersSelectedTab, Channel currentChannel, long currentChannelPermissions, boolean isOnCooldown) {
                Intrinsics3.checkNotNullParameter(allGuilds, "allGuilds");
                Intrinsics3.checkNotNullParameter(guildStickers, "guildStickers");
                Intrinsics3.checkNotNullParameter(enabledStickerPacks, "enabledStickerPacks");
                Intrinsics3.checkNotNullParameter(frequentlyUsedStickerIds, "frequentlyUsedStickerIds");
                Intrinsics3.checkNotNullParameter(searchInputStringUpper, "searchInputStringUpper");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Loaded(allGuilds, guildStickers, enabledStickerPacks, frequentlyUsedStickerIds, searchInputStringUpper, stickerAnimationSettings, selectedCategoryId, meUser, isStickersSelectedTab, currentChannel, currentChannelPermissions, isOnCooldown);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.allGuilds, loaded.allGuilds) && Intrinsics3.areEqual(this.guildStickers, loaded.guildStickers) && Intrinsics3.areEqual(this.enabledStickerPacks, loaded.enabledStickerPacks) && Intrinsics3.areEqual(this.frequentlyUsedStickerIds, loaded.frequentlyUsedStickerIds) && Intrinsics3.areEqual(this.searchInputStringUpper, loaded.searchInputStringUpper) && this.stickerAnimationSettings == loaded.stickerAnimationSettings && Intrinsics3.areEqual(this.selectedCategoryId, loaded.selectedCategoryId) && Intrinsics3.areEqual(this.meUser, loaded.meUser) && this.isStickersSelectedTab == loaded.isStickersSelectedTab && Intrinsics3.areEqual(this.currentChannel, loaded.currentChannel) && this.currentChannelPermissions == loaded.currentChannelPermissions && this.isOnCooldown == loaded.isOnCooldown;
            }

            public final LinkedHashMap<Long, Guild> getAllGuilds() {
                return this.allGuilds;
            }

            public final Channel getCurrentChannel() {
                return this.currentChannel;
            }

            public final long getCurrentChannelPermissions() {
                return this.currentChannelPermissions;
            }

            public final List<ModelStickerPack> getEnabledStickerPacks() {
                return this.enabledStickerPacks;
            }

            public final List<Long> getFrequentlyUsedStickerIds() {
                return this.frequentlyUsedStickerIds;
            }

            public final Map<Long, Map<Long, Sticker>> getGuildStickers() {
                return this.guildStickers;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final String getSearchInputStringUpper() {
                return this.searchInputStringUpper;
            }

            public final Long getSelectedCategoryId() {
                return this.selectedCategoryId;
            }

            public final int getStickerAnimationSettings() {
                return this.stickerAnimationSettings;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                LinkedHashMap<Long, Guild> linkedHashMap = this.allGuilds;
                int iHashCode = (linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31;
                Map<Long, Map<Long, Sticker>> map = this.guildStickers;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                List<ModelStickerPack> list = this.enabledStickerPacks;
                int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                List<Long> list2 = this.frequentlyUsedStickerIds;
                int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
                String str = this.searchInputStringUpper;
                int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.stickerAnimationSettings) * 31;
                Long l = this.selectedCategoryId;
                int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
                MeUser meUser = this.meUser;
                int iHashCode7 = (iHashCode6 + (meUser != null ? meUser.hashCode() : 0)) * 31;
                boolean z2 = this.isStickersSelectedTab;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode7 + i) * 31;
                Channel channel = this.currentChannel;
                int iA = (b.a(this.currentChannelPermissions) + ((i2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
                boolean z3 = this.isOnCooldown;
                return iA + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public final boolean isStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(allGuilds=");
                sbU.append(this.allGuilds);
                sbU.append(", guildStickers=");
                sbU.append(this.guildStickers);
                sbU.append(", enabledStickerPacks=");
                sbU.append(this.enabledStickerPacks);
                sbU.append(", frequentlyUsedStickerIds=");
                sbU.append(this.frequentlyUsedStickerIds);
                sbU.append(", searchInputStringUpper=");
                sbU.append(this.searchInputStringUpper);
                sbU.append(", stickerAnimationSettings=");
                sbU.append(this.stickerAnimationSettings);
                sbU.append(", selectedCategoryId=");
                sbU.append(this.selectedCategoryId);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", isStickersSelectedTab=");
                sbU.append(this.isStickersSelectedTab);
                sbU.append(", currentChannel=");
                sbU.append(this.currentChannel);
                sbU.append(", currentChannelPermissions=");
                sbU.append(this.currentChannelPermissions);
                sbU.append(", isOnCooldown=");
                return outline.O(sbU, this.isOnCooldown, ")");
            }
        }

        /* compiled from: StickerPickerViewModel.kt */
        public static final class Uninitialized extends StoreState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    public static abstract class ViewState {
        private final String searchQuery;

        /* compiled from: StickerPickerViewModel.kt */
        public static final /* data */ class EmptyNonPremium extends ViewState {
            private final List<Sticker> emptyStateStickers;
            private final boolean isStickersSelectedTab;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmptyNonPremium(List<Sticker> list, boolean z2) {
                super("", null);
                Intrinsics3.checkNotNullParameter(list, "emptyStateStickers");
                this.emptyStateStickers = list;
                this.isStickersSelectedTab = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EmptyNonPremium copy$default(EmptyNonPremium emptyNonPremium, List list, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = emptyNonPremium.emptyStateStickers;
                }
                if ((i & 2) != 0) {
                    z2 = emptyNonPremium.isStickersSelectedTab;
                }
                return emptyNonPremium.copy(list, z2);
            }

            public final List<Sticker> component1() {
                return this.emptyStateStickers;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            public final EmptyNonPremium copy(List<Sticker> emptyStateStickers, boolean isStickersSelectedTab) {
                Intrinsics3.checkNotNullParameter(emptyStateStickers, "emptyStateStickers");
                return new EmptyNonPremium(emptyStateStickers, isStickersSelectedTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmptyNonPremium)) {
                    return false;
                }
                EmptyNonPremium emptyNonPremium = (EmptyNonPremium) other;
                return Intrinsics3.areEqual(this.emptyStateStickers, emptyNonPremium.emptyStateStickers) && this.isStickersSelectedTab == emptyNonPremium.isStickersSelectedTab;
            }

            public final List<Sticker> getEmptyStateStickers() {
                return this.emptyStateStickers;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                List<Sticker> list = this.emptyStateStickers;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.isStickersSelectedTab;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmptyNonPremium(emptyStateStickers=");
                sbU.append(this.emptyStateStickers);
                sbU.append(", isStickersSelectedTab=");
                return outline.O(sbU, this.isStickersSelectedTab, ")");
            }
        }

        /* compiled from: StickerPickerViewModel.kt */
        public static final /* data */ class EmptySearchResults extends ViewState {
            private final List<StickerCategoryItem> categoryItems;
            private final String searchQuery;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public EmptySearchResults(String str, List<? extends StickerCategoryItem> list) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "searchQuery");
                Intrinsics3.checkNotNullParameter(list, "categoryItems");
                this.searchQuery = str;
                this.categoryItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EmptySearchResults copy$default(EmptySearchResults emptySearchResults, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = emptySearchResults.getSearchQuery();
                }
                if ((i & 2) != 0) {
                    list = emptySearchResults.categoryItems;
                }
                return emptySearchResults.copy(str, list);
            }

            public final String component1() {
                return getSearchQuery();
            }

            public final List<StickerCategoryItem> component2() {
                return this.categoryItems;
            }

            public final EmptySearchResults copy(String searchQuery, List<? extends StickerCategoryItem> categoryItems) {
                Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
                Intrinsics3.checkNotNullParameter(categoryItems, "categoryItems");
                return new EmptySearchResults(searchQuery, categoryItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmptySearchResults)) {
                    return false;
                }
                EmptySearchResults emptySearchResults = (EmptySearchResults) other;
                return Intrinsics3.areEqual(getSearchQuery(), emptySearchResults.getSearchQuery()) && Intrinsics3.areEqual(this.categoryItems, emptySearchResults.categoryItems);
            }

            public final List<StickerCategoryItem> getCategoryItems() {
                return this.categoryItems;
            }

            @Override // com.discord.widgets.chat.input.sticker.StickerPickerViewModel.ViewState
            public String getSearchQuery() {
                return this.searchQuery;
            }

            public int hashCode() {
                String searchQuery = getSearchQuery();
                int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
                List<StickerCategoryItem> list = this.categoryItems;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmptySearchResults(searchQuery=");
                sbU.append(getSearchQuery());
                sbU.append(", categoryItems=");
                return outline.L(sbU, this.categoryItems, ")");
            }
        }

        /* compiled from: StickerPickerViewModel.kt */
        public static final /* data */ class Stickers extends ViewState {
            private final List<StickerCategoryItem> categoryItems;
            private final boolean isOnCooldown;
            private final boolean isStickersSelectedTab;
            private final String searchQuery;
            private final List<MGRecyclerDataPayload> stickerItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Stickers(String str, List<? extends MGRecyclerDataPayload> list, List<? extends StickerCategoryItem> list2, boolean z2, boolean z3) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(str, "searchQuery");
                Intrinsics3.checkNotNullParameter(list, "stickerItems");
                Intrinsics3.checkNotNullParameter(list2, "categoryItems");
                this.searchQuery = str;
                this.stickerItems = list;
                this.categoryItems = list2;
                this.isStickersSelectedTab = z2;
                this.isOnCooldown = z3;
            }

            public static /* synthetic */ Stickers copy$default(Stickers stickers, String str, List list, List list2, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = stickers.getSearchQuery();
                }
                if ((i & 2) != 0) {
                    list = stickers.stickerItems;
                }
                List list3 = list;
                if ((i & 4) != 0) {
                    list2 = stickers.categoryItems;
                }
                List list4 = list2;
                if ((i & 8) != 0) {
                    z2 = stickers.isStickersSelectedTab;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    z3 = stickers.isOnCooldown;
                }
                return stickers.copy(str, list3, list4, z4, z3);
            }

            public final String component1() {
                return getSearchQuery();
            }

            public final List<MGRecyclerDataPayload> component2() {
                return this.stickerItems;
            }

            public final List<StickerCategoryItem> component3() {
                return this.categoryItems;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsOnCooldown() {
                return this.isOnCooldown;
            }

            public final Stickers copy(String searchQuery, List<? extends MGRecyclerDataPayload> stickerItems, List<? extends StickerCategoryItem> categoryItems, boolean isStickersSelectedTab, boolean isOnCooldown) {
                Intrinsics3.checkNotNullParameter(searchQuery, "searchQuery");
                Intrinsics3.checkNotNullParameter(stickerItems, "stickerItems");
                Intrinsics3.checkNotNullParameter(categoryItems, "categoryItems");
                return new Stickers(searchQuery, stickerItems, categoryItems, isStickersSelectedTab, isOnCooldown);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Stickers)) {
                    return false;
                }
                Stickers stickers = (Stickers) other;
                return Intrinsics3.areEqual(getSearchQuery(), stickers.getSearchQuery()) && Intrinsics3.areEqual(this.stickerItems, stickers.stickerItems) && Intrinsics3.areEqual(this.categoryItems, stickers.categoryItems) && this.isStickersSelectedTab == stickers.isStickersSelectedTab && this.isOnCooldown == stickers.isOnCooldown;
            }

            public final List<StickerCategoryItem> getCategoryItems() {
                return this.categoryItems;
            }

            @Override // com.discord.widgets.chat.input.sticker.StickerPickerViewModel.ViewState
            public String getSearchQuery() {
                return this.searchQuery;
            }

            public final List<MGRecyclerDataPayload> getStickerItems() {
                return this.stickerItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String searchQuery = getSearchQuery();
                int iHashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
                List<MGRecyclerDataPayload> list = this.stickerItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                List<StickerCategoryItem> list2 = this.categoryItems;
                int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
                boolean z2 = this.isStickersSelectedTab;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode3 + i) * 31;
                boolean z3 = this.isOnCooldown;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isOnCooldown() {
                return this.isOnCooldown;
            }

            public final boolean isStickersSelectedTab() {
                return this.isStickersSelectedTab;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Stickers(searchQuery=");
                sbU.append(getSearchQuery());
                sbU.append(", stickerItems=");
                sbU.append(this.stickerItems);
                sbU.append(", categoryItems=");
                sbU.append(this.categoryItems);
                sbU.append(", isStickersSelectedTab=");
                sbU.append(this.isStickersSelectedTab);
                sbU.append(", isOnCooldown=");
                return outline.O(sbU, this.isOnCooldown, ")");
            }
        }

        private ViewState(String str) {
            this.searchQuery = str;
        }

        public String getSearchQuery() {
            return this.searchQuery;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPickerViewModel(BehaviorSubject behaviorSubject, BehaviorSubject behaviorSubject2, Locale locale, MessageManager messageManager, StoreStickers storeStickers, long j, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL02;
        if ((i & 1) != 0) {
            behaviorSubjectL0 = BehaviorSubject.l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        } else {
            behaviorSubjectL0 = behaviorSubject;
        }
        if ((i & 2) != 0) {
            behaviorSubjectL02 = BehaviorSubject.l0(null);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL02, "BehaviorSubject.create(null as Long?)");
        } else {
            behaviorSubjectL02 = behaviorSubject2;
        }
        this(behaviorSubjectL0, behaviorSubjectL02, locale, messageManager, (i & 16) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers, j, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 256) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 1024) != 0 ? Companion.observeStoreState$default(INSTANCE, behaviorSubjectL0, behaviorSubjectL02, null, null, null, null, null, null, null, null, null, null, 4092, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerPickerViewModel stickerPickerViewModel, StoreState storeState) {
        stickerPickerViewModel.handleStoreState(storeState);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<StickerCategoryItem> createCategoryItems(StoreState.Loaded storeState, List<? extends MGRecyclerDataPayload> listItems, List<Sticker> frequentlyUsedStickers) {
        boolean z2;
        int size;
        Collection<Sticker> collectionValues;
        List list;
        StoreState.Loaded loaded;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        Long selectedCategoryId = storeState.getSelectedCategoryId();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        if ((!UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()) && storeState.getGuildStickers().isEmpty()) || storeState.getEnabledStickerPacks().isEmpty()) {
            return Collections2.emptyList();
        }
        if (listItems == null) {
            linkedHashSet.add(-1L);
            Iterator<T> it = storeState.getEnabledStickerPacks().iterator();
            while (it.hasNext()) {
                linkedHashSet.add(Long.valueOf(((ModelStickerPack) it.next()).getId()));
            }
        } else {
            for (MGRecyclerDataPayload mGRecyclerDataPayload : listItems) {
                if (mGRecyclerDataPayload instanceof StickerAdapterItems3) {
                    Sticker sticker = ((StickerAdapterItems3) mGRecyclerDataPayload).getSticker();
                    if ((frequentlyUsedStickers instanceof Collection) && frequentlyUsedStickers.isEmpty()) {
                        z2 = false;
                        if (z2) {
                        }
                        if (sticker.getPackId() != null) {
                        }
                        if (sticker.getGuildId() == null) {
                        }
                    } else {
                        Iterator<T> it2 = frequentlyUsedStickers.iterator();
                        while (it2.hasNext()) {
                            if (((Sticker) it2.next()).getId() == sticker.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            linkedHashSet.add(-1L);
                        }
                        if (sticker.getPackId() != null) {
                            Long packId = sticker.getPackId();
                            Objects.requireNonNull(packId, "null cannot be cast to non-null type kotlin.Long");
                            linkedHashSet.add(packId);
                        }
                        if (sticker.getGuildId() == null) {
                            Long guildId = sticker.getGuildId();
                            Objects.requireNonNull(guildId, "null cannot be cast to non-null type kotlin.Long");
                            linkedHashSet2.add(guildId);
                        }
                    }
                }
            }
        }
        if (!frequentlyUsedStickers.isEmpty()) {
            size = frequentlyUsedStickers.size() + 1 + 0;
            if (linkedHashSet.contains(-1L)) {
                arrayList.add(new StickerCategoryItem.RecentItem(selectedCategoryId != null && selectedCategoryId.longValue() == -1, new Tuples2(0, Integer.valueOf(size))));
            }
        } else {
            size = 0;
        }
        for (Map.Entry<Long, Guild> entry : storeState.getAllGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            Map<Long, Sticker> map = storeState.getGuildStickers().get(Long.valueOf(jLongValue));
            if (map != null && (collectionValues = map.values()) != null && (list = _Collections.toList(collectionValues)) != null) {
                long id2 = value.getId();
                if (selectedCategoryId != null && selectedCategoryId.longValue() == id2) {
                    loaded = storeState;
                    z3 = true;
                } else {
                    loaded = storeState;
                    z3 = false;
                }
                if (loaded.canUseExternalStickersInCurrentChannel(jLongValue)) {
                    int size2 = list.size() + 1 + size;
                    if (linkedHashSet2.contains(Long.valueOf(jLongValue))) {
                        arrayList.add(new StickerCategoryItem.GuildItem(value, list, new Tuples2(Integer.valueOf(size), Integer.valueOf(size2)), z3));
                    }
                    size = size2;
                }
            }
        }
        if (UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser())) {
            for (ModelStickerPack modelStickerPack : storeState.getEnabledStickerPacks()) {
                boolean z4 = selectedCategoryId != null && selectedCategoryId.longValue() == modelStickerPack.getId();
                int size3 = modelStickerPack.getStickers().size() + 1 + size;
                if (linkedHashSet.contains(Long.valueOf(modelStickerPack.getId()))) {
                    arrayList.add(new StickerCategoryItem.PackItem(modelStickerPack, new Tuples2(Integer.valueOf(size), Integer.valueOf(size3)), z4));
                }
                size = size3;
            }
        }
        return arrayList;
    }

    private final Map<Long, Sticker> getAllStickersById(StoreState.Loaded storeState) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = storeState.getEnabledStickerPacks().iterator();
        while (it.hasNext()) {
            for (Sticker sticker : ((ModelStickerPack) it.next()).getStickers()) {
                linkedHashMap.put(Long.valueOf(sticker.getId()), sticker);
            }
        }
        Iterator<T> it2 = storeState.getGuildStickers().values().iterator();
        while (it2.hasNext()) {
            for (Sticker sticker2 : ((Map) it2.next()).values()) {
                linkedHashMap.put(Long.valueOf(sticker2.getId()), sticker2);
            }
        }
        return Maps6.toMap(linkedHashMap);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Loaded) {
            StoreState.Loaded loaded = (StoreState.Loaded) storeState;
            Long lValueOf = loaded.getSelectedCategoryId() == null ? Long.valueOf(this.initialStickerPackId) : null;
            handleStoreStateForPage(loaded);
            scrollToPackId(lValueOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreStateForPage(StoreState.Loaded storeState) {
        boolean z2;
        List<? extends MGRecyclerDataPayload> list;
        Collection<Sticker> collectionValues;
        List list2;
        String str;
        StoreState.Loaded loaded = storeState;
        Map<Long, Sticker> allStickersById = getAllStickersById(storeState);
        List<ModelStickerPack> enabledStickerPacks = storeState.getEnabledStickerPacks();
        int stickerAnimationSettings = storeState.getStickerAnimationSettings();
        String searchInputStringUpper = storeState.getSearchInputStringUpper();
        Locale locale = this.locale;
        Objects.requireNonNull(searchInputStringUpper, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = searchInputStringUpper.toLowerCase(locale);
        String str2 = "(this as java.lang.String).toLowerCase(locale)";
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List<Long> frequentlyUsedStickerIds = storeState.getFrequentlyUsedStickerIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = frequentlyUsedStickerIds.iterator();
        while (it.hasNext()) {
            Sticker sticker = allStickersById.get(Long.valueOf(((Number) it.next()).longValue()));
            if (sticker != null) {
                arrayList.add(sticker);
            }
        }
        ArrayList<Sticker> arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (true) {
            z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (StickerUtils.INSTANCE.getStickerSendability((Sticker) next, storeState.getMeUser(), storeState.getCurrentChannel(), Long.valueOf(storeState.getCurrentChannelPermissions())) != StickerUtils.StickerSendability.NONSENDABLE) {
                arrayList2.add(next);
            }
        }
        List<? extends MGRecyclerDataPayload> arrayList3 = new ArrayList<>();
        int i = 2;
        if (!arrayList2.isEmpty()) {
            for (Sticker sticker2 : arrayList2) {
                String name = sticker2.getName();
                Locale locale2 = this.locale;
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = name.toLowerCase(locale2);
                Intrinsics3.checkNotNullExpressionValue(lowerCase2, str2);
                if (!Strings4.contains$default(lowerCase2, lowerCase, z2, i, (Object) null)) {
                    String tags = sticker2.getTags();
                    Locale locale3 = this.locale;
                    Objects.requireNonNull(tags, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase3 = tags.toLowerCase(locale3);
                    Intrinsics3.checkNotNullExpressionValue(lowerCase3, str2);
                    if (Strings4.contains$default(lowerCase3, lowerCase, z2, i, (Object) null)) {
                        str = str2;
                        arrayList3.add(new StickerAdapterItems3(sticker2, stickerAnimationSettings, StickerAdapterItems3.Mode.OWNED, StickerUtils.INSTANCE.getStickerSendability(sticker2, storeState.getMeUser(), storeState.getCurrentChannel(), Long.valueOf(storeState.getCurrentChannelPermissions()))));
                    } else {
                        str = str2;
                    }
                }
                str2 = str;
                i = 2;
                z2 = false;
            }
            if (!arrayList3.isEmpty()) {
                arrayList3.add(0, new StickerAdapterItems(StickerAdapterItems2.Recent.INSTANCE));
            }
        }
        for (Map.Entry<Long, Guild> entry : storeState.getAllGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            Map<Long, Sticker> map = storeState.getGuildStickers().get(Long.valueOf(jLongValue));
            if (map == null || (collectionValues = map.values()) == null || (list2 = _Collections.toList(collectionValues)) == null || !loaded.canUseExternalStickersInCurrentChannel(jLongValue)) {
                list = arrayList3;
            } else {
                list = arrayList3;
                list.addAll(Companion.access$buildGuildStickersListItems(INSTANCE, list2, value, stickerAnimationSettings, lowerCase, storeState.getMeUser(), this.locale, storeState.getCurrentChannel(), storeState.getCurrentChannelPermissions()));
            }
            arrayList3 = list;
            loaded = storeState;
        }
        List<? extends MGRecyclerDataPayload> list3 = arrayList3;
        if (UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser())) {
            Iterator<ModelStickerPack> it3 = enabledStickerPacks.iterator();
            while (it3.hasNext()) {
                list3.addAll(Companion.access$buildStickerListItems(INSTANCE, it3.next(), lowerCase, stickerAnimationSettings, this.locale, storeState.getMeUser()));
            }
        }
        List<StickerCategoryItem> listCreateCategoryItems = createCategoryItems(storeState, list3, arrayList2);
        if (!UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()) && storeState.getGuildStickers().isEmpty()) {
            updateViewState(new ViewState.EmptyNonPremium(Collections2.listOfNotNull((Object[]) new Sticker[]{this.stickersStore.getStickers().get(781323769960202280L), this.stickersStore.getStickers().get(809209266556764241L), this.stickersStore.getStickers().get(818597810047680532L), this.stickersStore.getStickers().get(819129296374595614L)}), storeState.isStickersSelectedTab()));
            return;
        }
        if (list3.isEmpty()) {
            if (lowerCase.length() > 0) {
                updateViewState(new ViewState.EmptySearchResults(storeState.getSearchInputStringUpper(), listCreateCategoryItems));
                return;
            }
        }
        updateViewState(new ViewState.Stickers(storeState.getSearchInputStringUpper(), list3, listCreateCategoryItems, storeState.isStickersSelectedTab(), storeState.isOnCooldown()));
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final boolean onStickerSelected(Sticker sticker) {
        long id2;
        Channel channelFindChannelById;
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        if ((getViewState() instanceof ViewState.Stickers) && (channelFindChannelById = this.channelStore.findChannelById((id2 = this.channelSelectedStore.getId()))) != null) {
            Long l = this.permissionStore.getPermissionsByChannel().get(Long.valueOf(id2));
            boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(channelFindChannelById, l);
            StickerUtils.StickerSendability stickerSendability = StickerUtils.INSTANCE.getStickerSendability(sticker, this.userStore.getMeSnapshot(), channelFindChannelById, l);
            if (stickerSendability == StickerUtils.StickerSendability.SENDABLE_WITH_PREMIUM) {
                this.eventSubject.k.onNext(Event.ShowStickerPremiumUpsell.INSTANCE);
                return false;
            }
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.chat.input.sticker.StickerPickerViewModel.ViewState.Stickers");
            if (((ViewState.Stickers) viewState).isOnCooldown()) {
                this.eventSubject.k.onNext(Event.SlowMode.INSTANCE);
                return false;
            }
            if (zHasAccessWrite && stickerSendability == StickerUtils.StickerSendability.SENDABLE) {
                this.stickersStore.onStickerUsed(sticker);
                MessageManager.sendMessage$default(this.messageManager, null, null, null, null, CollectionsJVM.listOf(sticker), false, null, null, null, 495, null);
                this.searchSubject.onNext("");
                return true;
            }
        }
        return false;
    }

    public final void scrollToPackId(Long packId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Stickers)) {
            viewState = null;
        }
        ViewState.Stickers stickers = (ViewState.Stickers) viewState;
        if (stickers == null || packId == null) {
            return;
        }
        packId.longValue();
        int size = stickers.getStickerItems().size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MGRecyclerDataPayload mGRecyclerDataPayload = stickers.getStickerItems().get(i2);
            if (mGRecyclerDataPayload instanceof StickerAdapterItems) {
                StickerAdapterItems stickerAdapterItems = (StickerAdapterItems) mGRecyclerDataPayload;
                if ((stickerAdapterItems.getHeaderType() instanceof StickerAdapterItems2.PackItem) && ((StickerAdapterItems2.PackItem) stickerAdapterItems.getHeaderType()).getPack().getId() == packId.longValue()) {
                    i = i2;
                    break;
                }
            }
            i2++;
        }
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ScrollToStickerItemPosition(i));
    }

    public final void setSearchText(String searchText) {
        Intrinsics3.checkNotNullParameter(searchText, "searchText");
        this.searchSubject.onNext(searchText);
    }

    public final void setSelectedCategoryId(long categoryId) {
        this.selectedCategoryIdSubject.onNext(Long.valueOf(categoryId));
    }

    public final void setStickerCountToDisplayForStore(int count) {
        this.stickerCountToDisplayForStore = count;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerViewModel(BehaviorSubject<String> behaviorSubject, BehaviorSubject<Long> behaviorSubject2, Locale locale, MessageManager messageManager, StoreStickers storeStickers, long j, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StorePermissions storePermissions, StoreUser storeUser, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchSubject");
        Intrinsics3.checkNotNullParameter(behaviorSubject2, "selectedCategoryIdSubject");
        Intrinsics3.checkNotNullParameter(locale, "locale");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(storeStickers, "stickersStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "channelSelectedStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.searchSubject = behaviorSubject;
        this.selectedCategoryIdSubject = behaviorSubject2;
        this.locale = locale;
        this.messageManager = messageManager;
        this.stickersStore = storeStickers;
        this.initialStickerPackId = j;
        this.channelStore = storeChannels;
        this.channelSelectedStore = storeChannelsSelected;
        this.permissionStore = storePermissions;
        this.userStore = storeUser;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        this.stickerCountToDisplayForStore = 4;
        storeStickers.fetchEnabledStickerDirectory();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
