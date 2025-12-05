package p600f0.p601e0.p605g;

import okio.BufferedSink;
import p600f0.p601e0.p613n.RealWebSocket;
import p615g0.BufferedSource;

/* compiled from: RealConnection.kt */
/* renamed from: f0.e0.g.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealConnection3 extends RealWebSocket.c {

    /* renamed from: m */
    public final /* synthetic */ Exchange f25488m;

    /* renamed from: n */
    public final /* synthetic */ BufferedSource f25489n;

    /* renamed from: o */
    public final /* synthetic */ BufferedSink f25490o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection3(Exchange exchange, BufferedSource bufferedSource, BufferedSink bufferedSink, boolean z2, BufferedSource bufferedSource2, BufferedSink bufferedSink2) {
        super(z2, bufferedSource2, bufferedSink2);
        this.f25488m = exchange;
        this.f25489n = bufferedSource;
        this.f25490o = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25488m.m10167a(-1L, true, true, null);
    }
}
