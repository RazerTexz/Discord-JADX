package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.u.p.f;

/* compiled from: AutoValue_TokenResult.java */
/* loaded from: classes3.dex */
public final class b extends f {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1789b;
    public final f.b c;

    /* compiled from: AutoValue_TokenResult.java */
    /* renamed from: b.i.c.u.p.b$b, reason: collision with other inner class name */
    public static final class C0154b extends f.a {
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public Long f1790b;
        public f.b c;

        @Override // b.i.c.u.p.f.a
        public f a() {
            String str = this.f1790b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new b(this.a, this.f1790b.longValue(), this.c, null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str));
        }

        @Override // b.i.c.u.p.f.a
        public f.a b(long j) {
            this.f1790b = Long.valueOf(j);
            return this;
        }
    }

    public b(String str, long j, f.b bVar, a aVar) {
        this.a = str;
        this.f1789b = j;
        this.c = bVar;
    }

    @Override // b.i.c.u.p.f
    @Nullable
    public f.b b() {
        return this.c;
    }

    @Override // b.i.c.u.p.f
    @Nullable
    public String c() {
        return this.a;
    }

    @Override // b.i.c.u.p.f
    @NonNull
    public long d() {
        return this.f1789b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f1789b == fVar.d()) {
                f.b bVar = this.c;
                if (bVar == null) {
                    if (fVar.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f1789b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        f.b bVar = this.c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("TokenResult{token=");
        sbU.append(this.a);
        sbU.append(", tokenExpirationTimestamp=");
        sbU.append(this.f1789b);
        sbU.append(", responseCode=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
