package com.discord.widgets.voice.fullscreen;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.model.CallModel;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func7;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState>> {
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreMentions $storeMentions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreVoiceChannelSelected $storeVoiceChannelSelected;
    public final /* synthetic */ long $voiceChannelId;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Boolean, Integer, Map<Long, ? extends Integer>, CallModel, Channel, WidgetCallPreviewFullscreenViewModel.StoreState> {
        public final /* synthetic */ Channel $voiceChannel;

        public AnonymousClass1(Channel channel) {
            this.$voiceChannel = channel;
        }

        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetCallPreviewFullscreenViewModel.StoreState call(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, ? extends Integer> map, CallModel callModel, Channel channel2) {
            return call2(meUser, channel, bool, num, (Map<Long, Integer>) map, callModel, channel2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetCallPreviewFullscreenViewModel.StoreState call2(MeUser meUser, Channel channel, Boolean bool, Integer num, Map<Long, Integer> map, CallModel callModel, Channel channel2) {
            if (callModel == null || this.$voiceChannel == null || channel == null) {
                return WidgetCallPreviewFullscreenViewModel.StoreState.Invalid.INSTANCE;
            }
            boolean z2 = !StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.$voiceChannel.getGuildId());
            boolean nsfw = this.$voiceChannel.getNsfw();
            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
            Channel channel3 = this.$voiceChannel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isTextInVoiceEnabled");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(num, "totalMentionsCount");
            int iIntValue = num.intValue();
            Integer num2 = (Integer) outline.m845d(this.$voiceChannel, map);
            return new WidgetCallPreviewFullscreenViewModel.StoreState.Valid(channel3, channel, zBooleanValue, iIntValue, num2 != null ? num2.intValue() : 0, z2, nsfw, nsfwAllowance, callModel, channel2);
        }
    }

    public WidgetCallPreviewFullscreenViewModel2(StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, long j, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        this.$storeUser = storeUser;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeMentions = storeMentions;
        this.$voiceChannelId = j;
        this.$storeVoiceChannelSelected = storeVoiceChannelSelected;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetCallPreviewFullscreenViewModel.StoreState> call2(Channel channel) {
        return Observable.m11069e(StoreUser.observeMe$default(this.$storeUser, false, 1, null), this.$storeChannelsSelected.observeSelectedChannel(), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), this.$storeMentions.observeTotalMentions(), this.$storeMentions.observeMentionCounts(), CallModel.INSTANCE.get(this.$voiceChannelId), this.$storeVoiceChannelSelected.observeSelectedChannel(), new AnonymousClass1(channel));
    }
}
