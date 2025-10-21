package com.discord.utilities.websocket;

import com.discord.utilities.websocket.WebSocket;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.Response;

/* compiled from: WebSocket.kt */
/* renamed from: com.discord.utilities.websocket.WebSocket$connect$1$onOpen$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WebSocket4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Response $response;
    public final /* synthetic */ okhttp3.WebSocket $webSocket;
    public final /* synthetic */ WebSocket.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocket4(WebSocket.AnonymousClass1 anonymousClass1, okhttp3.WebSocket webSocket, Response response) {
        super(0);
        this.this$0 = anonymousClass1;
        this.$webSocket = webSocket;
        this.$response = response;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WebSocket.access$setClient$p(WebSocket.this, this.$webSocket);
        WebSocket.access$setState$p(WebSocket.this, WebSocket.State.CONNECTED);
        WebSocket.this.getOnOpened().invoke(new WebSocket.Opened(this.$response));
    }
}
