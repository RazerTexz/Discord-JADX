package p007b.p225i.p226a.p242c.p278y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

/* JADX INFO: renamed from: b.i.a.c.y2.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3136h implements Comparator {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ MediaCodecUtil.InterfaceC10718f f9054j;

    public /* synthetic */ C3136h(MediaCodecUtil.InterfaceC10718f interfaceC10718f) {
        this.f9054j = interfaceC10718f;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        MediaCodecUtil.InterfaceC10718f interfaceC10718f = this.f9054j;
        return interfaceC10718f.mo3830a(obj2) - interfaceC10718f.mo3830a(obj);
    }
}
