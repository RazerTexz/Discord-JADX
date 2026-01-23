package p007b.p225i.p226a.p242c.p278y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import p007b.p225i.p226a.p242c.Format2;

/* JADX INFO: renamed from: b.i.a.c.y2.g */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3135g implements MediaCodecUtil.InterfaceC10718f {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Format2 f9053a;

    public /* synthetic */ C3135g(Format2 format2) {
        this.f9053a = format2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10718f
    /* JADX INFO: renamed from: a */
    public final int mo3830a(Object obj) {
        try {
            return ((MediaCodecInfo) obj).m3867e(this.f9053a) ? 1 : 0;
        } catch (MediaCodecUtil.DecoderQueryException unused) {
            return -1;
        }
    }
}
