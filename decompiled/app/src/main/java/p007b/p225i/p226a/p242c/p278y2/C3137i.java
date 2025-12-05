package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p260g3.MediaCodecVideoRenderer;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;

/* compiled from: lambda */
/* renamed from: b.i.a.c.y2.i */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3137i implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a */
    public final /* synthetic */ SynchronousMediaCodecAdapter f9055a;

    /* renamed from: b */
    public final /* synthetic */ MediaCodecAdapter.c f9056b;

    public /* synthetic */ C3137i(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.c cVar) {
        this.f9055a = synchronousMediaCodecAdapter;
        this.f9056b = cVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = this.f9055a;
        MediaCodecAdapter.c cVar = this.f9056b;
        Objects.requireNonNull(synchronousMediaCodecAdapter);
        ((MediaCodecVideoRenderer.b) cVar).m3176b(synchronousMediaCodecAdapter, j, j2);
    }
}
