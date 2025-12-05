package p007b.p225i.p226a.p228b.p231j.p232q;

import com.google.auto.value.AutoValue;

/* compiled from: BackendResponse.java */
@AutoValue
/* renamed from: b.i.a.b.j.q.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BackendResponse {

    /* compiled from: BackendResponse.java */
    /* renamed from: b.i.a.b.j.q.g$a */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    /* renamed from: a */
    public static BackendResponse m2370a() {
        return new AutoValue_BackendResponse(a.FATAL_ERROR, -1L);
    }

    /* renamed from: b */
    public abstract long mo2364b();

    /* renamed from: c */
    public abstract a mo2365c();
}
