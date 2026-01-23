package p007b.p225i.p226a.p242c.p260g3;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;

/* JADX INFO: renamed from: b.i.a.c.g3.i */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2772i implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoRendererEventListener2.a f6825j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f6826k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f6827l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f6828m;

    public /* synthetic */ RunnableC2772i(VideoRendererEventListener2.a aVar, String str, long j, long j2) {
        this.f6825j = aVar;
        this.f6826k = str;
        this.f6827l = j;
        this.f6828m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.f6825j;
        String str = this.f6826k;
        long j = this.f6827l;
        long j2 = this.f6828m;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f6953b;
        int i = Util2.f6708a;
        videoRendererEventListener2.mo3195n(str, j, j2);
    }
}
