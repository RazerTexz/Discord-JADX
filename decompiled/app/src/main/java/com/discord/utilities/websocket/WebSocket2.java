package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.websocket.WebSocket$connect$1$onClosed$1, reason: use source file name */
/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int $code;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ WebSocket.C70581 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket2(WebSocket.C70581 c70581, int i, String str) {
        super(0);
        this.this$0 = c70581;
        this.$code = i;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.access$setState$p(WebSocket.this, WebSocket.State.CLOSED);
        WebSocket.this.getOnClosed().invoke(new WebSocket.Closed(this.$code, this.$reason));
    }
}
