package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func6;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends AppFlexInputViewModel.StoreState>> {
    public static final AppFlexInputViewModel2 INSTANCE = new AppFlexInputViewModel2();

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.AppFlexInputViewModel$Companion$observeStores$1$1 */
    /* JADX INFO: compiled from: AppFlexInputViewModel.kt */
    public static final class C76781<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, PanelState, Long, StoreNotices.Notice, Boolean, Boolean, AppFlexInputViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

        public C76781(Channel channel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            this.$channel = channel;
            this.$selectedChannel = resolvedSelectedChannel;
        }

        @Override // p658rx.functions.Func6
        public /* bridge */ /* synthetic */ AppFlexInputViewModel.StoreState call(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
            return call2(panelState, panelState2, l, notice, bool, bool2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final AppFlexInputViewModel.StoreState call2(PanelState panelState, PanelState panelState2, Long l, StoreNotices.Notice notice, Boolean bool, Boolean bool2) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
            Intrinsics3.checkNotNullExpressionValue(panelState2, "rightPanelState");
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "stickerSuggestionsEnabled");
            if (bool.booleanValue()) {
                Intrinsics3.checkNotNullExpressionValue(bool2, "expressionSuggestionsEnabled");
                z2 = bool2.booleanValue();
            }
            return new AppFlexInputViewModel.StoreState(panelState, panelState2, channel, l, notice, z2, this.$selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends AppFlexInputViewModel.StoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AppFlexInputViewModel.StoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11071f(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), companion.getPermissions().observePermissionsForChannel(channelOrParent != null ? channelOrParent.getId() : 0L), companion.getNotices().getNotices(), companion.getUserSettings().observeIsStickerSuggestionsEnabled(), companion.getExpressionSuggestions().observeSuggestionsEnabled(), new C76781(channelOrParent, resolvedSelectedChannel));
    }
}
