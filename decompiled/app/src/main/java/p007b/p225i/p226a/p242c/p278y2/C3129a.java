package p007b.p225i.p226a.p242c.p278y2;

import android.os.HandlerThread;
import p007b.p225i.p355b.p356a.Supplier2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.y2.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3129a implements Supplier2 {

    /* renamed from: j */
    public final /* synthetic */ int f9045j;

    public /* synthetic */ C3129a(int i) {
        this.f9045j = i;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        return new HandlerThread(AsynchronousMediaCodecAdapter.m3833l(this.f9045j, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }
}
