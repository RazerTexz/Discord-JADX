package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetAgeVerifyViewModel.kt */
/* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel2<T, R> implements Func1<Channel, Observable<? extends Channel>> {
    public static final WidgetAgeVerifyViewModel2 INSTANCE = new WidgetAgeVerifyViewModel2();

    /* compiled from: WidgetAgeVerifyViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$1$1 */
    public static final class C71631<T, R> implements Func1<Channel, Channel> {
        public static final C71631 INSTANCE = new C71631();

        @Override // p637j0.p641k.Func1
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

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Channel> call2(Channel channel) {
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        return lValueOf == null ? new ScalarSynchronousObservable(null) : ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(lValueOf.longValue()), 0L, false, 3, null).m11083G(C71631.INSTANCE);
    }
}
