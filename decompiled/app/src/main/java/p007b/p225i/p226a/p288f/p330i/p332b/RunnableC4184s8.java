package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Intent;

/* JADX INFO: renamed from: b.i.a.f.i.b.s8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4184s8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C4151p8 f11211j;

    /* JADX INFO: renamed from: k */
    public final int f11212k;

    /* JADX INFO: renamed from: l */
    public final C4157q3 f11213l;

    /* JADX INFO: renamed from: m */
    public final Intent f11214m;

    public RunnableC4184s8(C4151p8 c4151p8, int i, C4157q3 c4157q3, Intent intent) {
        this.f11211j = c4151p8;
        this.f11212k = i;
        this.f11213l = c4157q3;
        this.f11214m = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4151p8 c4151p8 = this.f11211j;
        int i = this.f11212k;
        C4157q3 c4157q3 = this.f11213l;
        Intent intent = this.f11214m;
        if (c4151p8.f11131a.mo5870f(i)) {
            c4157q3.f11149n.m5861b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            c4151p8.m5786b().f11149n.m5860a("Completed wakeful intent.");
            c4151p8.f11131a.mo5869b(intent);
        }
    }
}
