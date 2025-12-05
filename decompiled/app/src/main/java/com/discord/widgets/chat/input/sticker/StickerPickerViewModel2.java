package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloads2;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import com.discord.widgets.chat.input.sticker.StickerPickerViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function11;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StickerPickerViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerPickerViewModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends StickerPickerViewModel.StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedPackIdSubject;
    public final /* synthetic */ StoreExpressionPickerNavigation $storeExpressionPickerNavigation;
    public final /* synthetic */ StoreGuildStickers $storeGuildStickers;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreStickers $storeStickers;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    /* compiled from: StickerPickerViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1$1 */
    public static final class C78951<T, R> implements Func1<LinkedHashMap<Long, Guild>, LinkedHashMap<Long, Guild>> {
        public final /* synthetic */ Guild $currentGuild;

        public C78951(Guild guild) {
            this.$currentGuild = guild;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ LinkedHashMap<Long, Guild> call(LinkedHashMap<Long, Guild> linkedHashMap) {
            return call2(linkedHashMap);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedHashMap<Long, Guild> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
            LinkedHashMap<Long, Guild> linkedHashMap2 = new LinkedHashMap<>();
            Guild guild = this.$currentGuild;
            if (guild != null) {
                linkedHashMap2.put(Long.valueOf(guild.getId()), this.$currentGuild);
            }
            Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<Long, Guild> entry : linkedHashMap.entrySet()) {
                Long key = entry.getKey();
                if (!Intrinsics3.areEqual(key, this.$currentGuild != null ? Long.valueOf(r4.getId()) : null)) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            linkedHashMap2.putAll(linkedHashMap3);
            return linkedHashMap2;
        }
    }

    /* compiled from: StickerPickerViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerPickerViewModel$Companion$observeStoreState$1$2 */
    public static final class C78962 extends Lambda implements Function11<LinkedHashMap<Long, Guild>, Map<Long, ? extends Map<Long, ? extends Sticker>>, List<? extends ModelStickerPack>, List<? extends Long>, String, Integer, Long, MeUser, ExpressionTrayTab, Map<Long, ? extends Long>, Integer, StickerPickerViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78962(Channel channel) {
            super(11);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function11
        public /* bridge */ /* synthetic */ StickerPickerViewModel.StoreState.Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, ? extends Sticker>> map, List<? extends ModelStickerPack> list, List<? extends Long> list2, String str, Integer num, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, ? extends Long> map2, Integer num2) {
            return invoke(linkedHashMap, (Map<Long, ? extends Map<Long, Sticker>>) map, (List<ModelStickerPack>) list, (List<Long>) list2, str, num.intValue(), l, meUser, expressionTrayTab, (Map<Long, Long>) map2, num2.intValue());
        }

        public final StickerPickerViewModel.StoreState.Loaded invoke(LinkedHashMap<Long, Guild> linkedHashMap, Map<Long, ? extends Map<Long, Sticker>> map, List<ModelStickerPack> list, List<Long> list2, String str, int i, Long l, MeUser meUser, ExpressionTrayTab expressionTrayTab, Map<Long, Long> map2, int i2) {
            Intrinsics3.checkNotNullParameter(map, "guildStickers");
            Intrinsics3.checkNotNullParameter(list, "enabledStickerPacks");
            Intrinsics3.checkNotNullParameter(list2, "frequentlyUsedStickerIds");
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionPickerTab");
            Intrinsics3.checkNotNullParameter(map2, "allChannelPermissions");
            Intrinsics3.checkNotNullExpressionValue(linkedHashMap, "allGuilds");
            Intrinsics3.checkNotNullExpressionValue(str, "searchInputString");
            boolean z2 = expressionTrayTab == ExpressionTrayTab.STICKER;
            Channel channel = this.$channel;
            Long l2 = map2.get(Long.valueOf(channel != null ? channel.getId() : 0L));
            return new StickerPickerViewModel.StoreState.Loaded(linkedHashMap, map, list, list2, str, i, l, meUser, z2, channel, l2 != null ? l2.longValue() : 0L, i2 > 0);
        }
    }

    public StickerPickerViewModel2(StoreGuilds storeGuilds, StoreGuildsSorted storeGuildsSorted, StoreGuildStickers storeGuildStickers, StoreStickers storeStickers, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, BehaviorSubject behaviorSubject2, StoreUser storeUser, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StorePermissions storePermissions, StoreSlowMode storeSlowMode) {
        this.$storeGuilds = storeGuilds;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$storeGuildStickers = storeGuildStickers;
        this.$storeStickers = storeStickers;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$selectedPackIdSubject = behaviorSubject2;
        this.$storeUser = storeUser;
        this.$storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.$storePermissions = storePermissions;
        this.$storeSlowMode = storeSlowMode;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StickerPickerViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Observable<? extends StickerPickerViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Guild guild;
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent != null) {
            guild = this.$storeGuilds.getGuild(channelOrParent.getGuildId());
            if (guild == null) {
                guild = null;
            }
        }
        Observable<R> observableM11112r = this.$storeGuildsSorted.observeOrderedGuilds().m11083G(new C78951(guild)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "storeGuildsSorted.observ… }.distinctUntilChanged()");
        return ObservableCombineLatestOverloads2.combineLatest(observableM11112r, this.$storeGuildStickers.observeGuildStickers(), this.$storeStickers.observeEnabledStickerPacks(), this.$storeStickers.observeFrequentlyUsedStickerIds(), this.$searchSubject, StoreUserSettings.observeStickerAnimationSettings$default(this.$storeUserSettings, false, 1, null), this.$selectedPackIdSubject, StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeExpressionPickerNavigation.observeSelectedTab(), this.$storePermissions.observePermissionsForAllChannels(), this.$storeSlowMode.observeCooldownSecs(Long.valueOf(resolvedSelectedChannel.getId()), StoreSlowMode.Type.MessageSend.INSTANCE), new C78962(channelOrParent));
    }
}
