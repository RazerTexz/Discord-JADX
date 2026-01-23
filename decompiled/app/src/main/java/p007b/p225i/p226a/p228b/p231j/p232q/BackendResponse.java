package p007b.p225i.p226a.p228b.p231j.p232q;

import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.j.q.g, reason: use source file name */
/* JADX INFO: compiled from: BackendResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class BackendResponse {

    /* JADX INFO: renamed from: b.i.a.b.j.q.g$a */
    /* JADX INFO: compiled from: BackendResponse.java */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    /* JADX INFO: renamed from: a */
    public static BackendResponse m2370a() {
        return new AutoValue_BackendResponse(a.FATAL_ERROR, -1L);
    }

    /* JADX INFO: renamed from: b */
    public abstract long mo2364b();

    /* JADX INFO: renamed from: c */
    public abstract a mo2365c();
}
