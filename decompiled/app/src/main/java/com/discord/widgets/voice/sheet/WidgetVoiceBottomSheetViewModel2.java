package com.discord.widgets.voice.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1$1 */
    public static final class C106031<T1, T2, T3, R> implements Func3<CallModel, Long, Boolean, WidgetVoiceBottomSheetViewModel.StoreState> {
        public static final C106031 INSTANCE = new C106031();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetVoiceBottomSheetViewModel.StoreState call(CallModel callModel, Long l, Boolean bool) {
            return call2(callModel, l, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetVoiceBottomSheetViewModel.StoreState call2(CallModel callModel, Long l, Boolean bool) {
            if (callModel != null) {
                if (Sets5.setOf((Object[]) new Integer[]{2, 13, 1, 3}).contains(Integer.valueOf(callModel.getChannel().getType()))) {
                    Boolean boolValueOf = Boolean.valueOf(callModel.getVoiceSettings().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Cancellation);
                    Intrinsics3.checkNotNullExpressionValue(bool, "textInVoiceEnabled");
                    return new WidgetVoiceBottomSheetViewModel.StoreState.Valid(callModel, boolValueOf, l, bool.booleanValue());
                }
            }
            return WidgetVoiceBottomSheetViewModel.StoreState.Invalid.INSTANCE;
        }
    }

    public WidgetVoiceBottomSheetViewModel2(long j, StorePermissions storePermissions) {
        this.$channelId = j;
        this.$permissionsStore = storePermissions;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceBottomSheetViewModel.StoreState> call2(Channel channel) {
        return Observable.m11075i(CallModel.INSTANCE.get(this.$channelId), this.$permissionsStore.observePermissionsForChannel(this.$channelId), TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(channel != null ? Long.valueOf(channel.getGuildId()) : null), C106031.INSTANCE);
    }
}
