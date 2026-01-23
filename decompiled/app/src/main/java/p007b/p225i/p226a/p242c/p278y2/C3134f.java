package p007b.p225i.p226a.p242c.p278y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.y2.f */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3134f implements MediaCodecUtil.InterfaceC10718f {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C3134f f9052a = new C3134f();

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10718f
    /* JADX INFO: renamed from: a */
    public final int mo3830a(Object obj) {
        Pattern pattern = MediaCodecUtil.f19928a;
        return ((MediaCodecInfo) obj).f9112a.startsWith("OMX.google") ? 1 : 0;
    }
}
