package p007b.p225i.p226a.p242c.p278y2;

import android.os.HandlerThread;
import p007b.p225i.p355b.p356a.Supplier2;

/* JADX INFO: renamed from: b.i.a.c.y2.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3130b implements Supplier2 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f9046j;

    public /* synthetic */ C3130b(int i) {
        this.f9046j = i;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        return new HandlerThread(AsynchronousMediaCodecAdapter.m3833l(this.f9046j, "ExoPlayer:MediaCodecQueueingThread:"));
    }
}
