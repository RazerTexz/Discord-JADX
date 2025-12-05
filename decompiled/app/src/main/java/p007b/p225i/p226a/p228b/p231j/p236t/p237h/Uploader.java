package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.g, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader implements Runnable {

    /* renamed from: j */
    public final Uploader6 f5370j;

    /* renamed from: k */
    public final TransportContext f5371k;

    /* renamed from: l */
    public final int f5372l;

    /* renamed from: m */
    public final Runnable f5373m;

    public Uploader(Uploader6 uploader6, TransportContext transportContext, int i, Runnable runnable) {
        this.f5370j = uploader6;
        this.f5371k = transportContext;
        this.f5372l = i;
        this.f5373m = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uploader6 uploader6 = this.f5370j;
        TransportContext transportContext = this.f5371k;
        int i = this.f5372l;
        Runnable runnable = this.f5373m;
        try {
            try {
                SynchronizationGuard synchronizationGuard = uploader6.f5390f;
                EventStore eventStore = uploader6.f5387c;
                eventStore.getClass();
                synchronizationGuard.mo2406a(new Uploader4(eventStore));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader6.f5385a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    uploader6.m2385a(transportContext, i);
                } else {
                    uploader6.f5390f.mo2406a(new Uploader5(uploader6, transportContext, i));
                }
            } catch (SynchronizationException unused) {
                uploader6.f5388d.mo2382a(transportContext, i + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
