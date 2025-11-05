package b.i.a.b.j.q;

import b.i.a.b.j.q.g;
import java.util.Objects;

/* compiled from: AutoValue_BackendResponse.java */
/* loaded from: classes3.dex */
public final class b extends g {
    public final g.a a;

    /* renamed from: b, reason: collision with root package name */
    public final long f772b;

    public b(g.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.a = aVar;
        this.f772b = j;
    }

    @Override // b.i.a.b.j.q.g
    public long b() {
        return this.f772b;
    }

    @Override // b.i.a.b.j.q.g
    public g.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.c()) && this.f772b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.f772b;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("BackendResponse{status=");
        sbU.append(this.a);
        sbU.append(", nextRequestWaitMillis=");
        return b.d.b.a.a.C(sbU, this.f772b, "}");
    }
}
