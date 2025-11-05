package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChannelGroupDMSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1<T, R> implements b<Channel, Observable<? extends ChannelGroupDMSettingsViewModel.StoreState>> {
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Channel, ModelNotificationSettings, ChannelGroupDMSettingsViewModel.StoreState.Valid> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ChannelGroupDMSettingsViewModel.StoreState.Valid call(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            return call2(channel, modelNotificationSettings);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChannelGroupDMSettingsViewModel.StoreState.Valid call2(Channel channel, ModelNotificationSettings modelNotificationSettings) {
            m.checkNotNullExpressionValue(channel, "channel");
            m.checkNotNullExpressionValue(modelNotificationSettings, "notificationSettings");
            return new ChannelGroupDMSettingsViewModel.StoreState.Valid(channel, modelNotificationSettings);
        }
    }

    public ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1(StoreUserGuildSettings storeUserGuildSettings) {
        this.$storeUserGuildSettings = storeUserGuildSettings;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChannelGroupDMSettingsViewModel.StoreState> call2(Channel channel) {
        return channel == null ? new k(ChannelGroupDMSettingsViewModel.StoreState.Invalid.INSTANCE) : Observable.j(new k(channel), this.$storeUserGuildSettings.observeGuildSettings(channel.getGuildId()), AnonymousClass1.INSTANCE);
    }
}
