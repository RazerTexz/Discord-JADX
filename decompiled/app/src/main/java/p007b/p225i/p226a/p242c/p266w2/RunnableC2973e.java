package p007b.p225i.p226a.p242c.p266w2;

import android.os.Looper;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Format2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.w2.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2973e implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ DefaultDrmSessionManager.C10707d f7986j;

    /* renamed from: k */
    public final /* synthetic */ Format2 f7987k;

    public /* synthetic */ RunnableC2973e(DefaultDrmSessionManager.C10707d c10707d, Format2 format2) {
        this.f7986j = c10707d;
        this.f7987k = format2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.C10707d c10707d = this.f7986j;
        Format2 format2 = this.f7987k;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.f19829p == 0 || c10707d.f19842d) {
            return;
        }
        Looper looper = defaultDrmSessionManager.f19833t;
        Objects.requireNonNull(looper);
        c10707d.f19841c = defaultDrmSessionManager.m8827e(looper, c10707d.f19840b, format2, false);
        DefaultDrmSessionManager.this.f19827n.add(c10707d);
    }
}
