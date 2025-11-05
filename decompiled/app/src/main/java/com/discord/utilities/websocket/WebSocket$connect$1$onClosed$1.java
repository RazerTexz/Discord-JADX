package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WebSocket.kt */
/* loaded from: classes2.dex */
public final class WebSocket$connect$1$onClosed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ int $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ WebSocket.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket$connect$1$onClosed$1(WebSocket.AnonymousClass1 anonymousClass1, int i, String str) {
        super(0);
        this.this$0 = anonymousClass1;
        this.$code = i;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.access$setState$p(WebSocket.this, WebSocket.State.CLOSED);
        WebSocket.this.getOnClosed().invoke(new WebSocket.Closed(this.$code, this.$reason));
    }
}
