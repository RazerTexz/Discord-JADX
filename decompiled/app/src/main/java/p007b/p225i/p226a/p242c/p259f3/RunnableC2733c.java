package p007b.p225i.p226a.p242c.p259f3;

import p007b.p225i.p226a.p242c.p259f3.NetworkTypeObserver;

/* JADX INFO: renamed from: b.i.a.c.f3.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2733c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ NetworkTypeObserver f6693j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ NetworkTypeObserver.b f6694k;

    public /* synthetic */ RunnableC2733c(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.b bVar) {
        this.f6693j = networkTypeObserver;
        this.f6694k = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        NetworkTypeObserver networkTypeObserver = this.f6693j;
        NetworkTypeObserver.b bVar = this.f6694k;
        synchronized (networkTypeObserver.f6785d) {
            i = networkTypeObserver.f6786e;
        }
        bVar.mo2777a(i);
    }
}
