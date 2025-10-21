package com.discord.gateway;

import androidx.core.app.NotificationCompat;
import com.discord.gateway.GatewaySocket;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* compiled from: GatewaySocket.kt */
/* loaded from: classes.dex */
public final class GatewaySocket$Timer$schedule$1<T> implements Action1<Long> {
    public final /* synthetic */ Function0 $action;
    public final /* synthetic */ GatewaySocket.Timer this$0;

    public GatewaySocket$Timer$schedule$1(GatewaySocket.Timer timer, Function0 function0) {
        this.this$0 = timer;
        this.$action = function0;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        try {
            this.$action.invoke();
        } finally {
            GatewaySocket.Timer.access$setSubscription$p(this.this$0, null);
        }
    }
}
