package p007b.p225i.p226a.p228b.p231j.p232q;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse;

/* JADX INFO: renamed from: b.i.a.b.j.q.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_BackendResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_BackendResponse extends BackendResponse {

    /* JADX INFO: renamed from: a */
    public final BackendResponse.a f5302a;

    /* JADX INFO: renamed from: b */
    public final long f5303b;

    public AutoValue_BackendResponse(BackendResponse.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.f5302a = aVar;
        this.f5303b = j;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse
    /* JADX INFO: renamed from: b */
    public long mo2364b() {
        return this.f5303b;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse
    /* JADX INFO: renamed from: c */
    public BackendResponse.a mo2365c() {
        return this.f5302a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f5302a.equals(backendResponse.mo2365c()) && this.f5303b == backendResponse.mo2364b();
    }

    public int hashCode() {
        int iHashCode = (this.f5302a.hashCode() ^ 1000003) * 1000003;
        long j = this.f5303b;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BackendResponse{status=");
        sbM833U.append(this.f5302a);
        sbM833U.append(", nextRequestWaitMillis=");
        return outline.m815C(sbM833U, this.f5303b, "}");
    }
}
