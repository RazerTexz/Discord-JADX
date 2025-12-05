package p007b.p225i.p226a.p242c.p263t2;

import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.f */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2921f implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AudioRendererEventListener2.a f7742j;

    /* renamed from: k */
    public final /* synthetic */ String f7743k;

    /* renamed from: l */
    public final /* synthetic */ long f7744l;

    /* renamed from: m */
    public final /* synthetic */ long f7745m;

    public /* synthetic */ RunnableC2921f(AudioRendererEventListener2.a aVar, String str, long j, long j2) {
        this.f7742j = aVar;
        this.f7743k = str;
        this.f7744l = j;
        this.f7745m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.f7742j;
        String str = this.f7743k;
        long j = this.f7744l;
        long j2 = this.f7745m;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f7791b;
        int i = Util2.f6708a;
        audioRendererEventListener2.mo3292C(str, j, j2);
    }
}
