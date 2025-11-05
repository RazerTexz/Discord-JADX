package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetAgeVerifyViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel$Companion$observeStores$1<T, R> implements b<Channel, Observable<? extends Channel>> {
    public static final WidgetAgeVerifyViewModel$Companion$observeStores$1 INSTANCE = new WidgetAgeVerifyViewModel$Companion$observeStores$1();

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Channel, Channel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Channel call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Channel call2(Channel channel) {
            if (channel == null || channel.getNsfw()) {
                return null;
            }
            return channel;
        }
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        return lValueOf == null ? new k(null) : ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(lValueOf.longValue()), 0L, false, 3, null).G(AnonymousClass1.INSTANCE);
    }
}
