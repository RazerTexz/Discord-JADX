package p007b.p225i.p226a.p242c.p278y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.y2.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3133e implements MediaCodecUtil.InterfaceC10718f {

    /* renamed from: a */
    public static final /* synthetic */ C3133e f9051a = new C3133e();

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10718f
    /* renamed from: a */
    public final int mo3830a(Object obj) {
        Pattern pattern = MediaCodecUtil.f19928a;
        String str = ((MediaCodecInfo) obj).f9112a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util2.f6708a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
