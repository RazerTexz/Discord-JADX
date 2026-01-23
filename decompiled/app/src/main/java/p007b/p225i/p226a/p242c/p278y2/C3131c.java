package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p260g3.MediaCodecVideoRenderer;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;

/* JADX INFO: renamed from: b.i.a.c.y2.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3131c implements MediaCodec.OnFrameRenderedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AsynchronousMediaCodecAdapter f9047a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MediaCodecAdapter.c f9048b;

    public /* synthetic */ C3131c(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.c cVar) {
        this.f9047a = asynchronousMediaCodecAdapter;
        this.f9048b = cVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = this.f9047a;
        MediaCodecAdapter.c cVar = this.f9048b;
        Objects.requireNonNull(asynchronousMediaCodecAdapter);
        ((MediaCodecVideoRenderer.b) cVar).m3176b(asynchronousMediaCodecAdapter, j, j2);
    }
}
