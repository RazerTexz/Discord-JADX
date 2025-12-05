package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: ChannelGroupDMSettingsViewModel.kt */
/* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel2<T, R> implements Func1<Channel, Observable<? extends ChannelGroupDMSettingsViewModel.StoreState>> {
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1 */
    public static final class C75721<T1, T2, R> implements Func2<Channel, ModelNotificationSettings, ChannelGroupDMSettingsViewModel.StoreState.Valid> {
        public static final C75721 INSTANCE = new C75721();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ ChannelGroupDMSettingsViewModel.StoreState.Valid call(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            return call2(channel, modelNotificationSettings);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChannelGroupDMSettingsViewModel.StoreState.Valid call2(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "notificationSettings");
            return new ChannelGroupDMSettingsViewModel.StoreState.Valid(channel, modelNotificationSettings);
        }
    }

    public ChannelGroupDMSettingsViewModel2(StoreUserGuildSettings storeUserGuildSettings) {
        this.$storeUserGuildSettings = storeUserGuildSettings;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(ChannelGroupDMSettingsViewModel.StoreState.Invalid.INSTANCE) : Observable.m11076j(new ScalarSynchronousObservable(channel), this.$storeUserGuildSettings.observeGuildSettings(channel.getGuildId()), C75721.INSTANCE);
    }
}
