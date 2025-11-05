package b.i.a.b.j;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.i.a.b.j.i;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AutoValue_TransportContext.java */
/* loaded from: classes3.dex */
public final class b extends i {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f763b;
    public final b.i.a.b.d c;

    /* compiled from: AutoValue_TransportContext.java */
    /* renamed from: b.i.a.b.j.b$b, reason: collision with other inner class name */
    public static final class C0087b extends i.a {
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f764b;
        public b.i.a.b.d c;

        @Override // b.i.a.b.j.i.a
        public i a() {
            String strW = this.a == null ? " backendName" : "";
            if (this.c == null) {
                strW = b.d.b.a.a.w(strW, " priority");
            }
            if (strW.isEmpty()) {
                return new b(this.a, this.f764b, this.c, null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }

        @Override // b.i.a.b.j.i.a
        public i.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // b.i.a.b.j.i.a
        public i.a c(b.i.a.b.d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.c = dVar;
            return this;
        }
    }

    public b(String str, byte[] bArr, b.i.a.b.d dVar, a aVar) {
        this.a = str;
        this.f763b = bArr;
        this.c = dVar;
    }

    @Override // b.i.a.b.j.i
    public String b() {
        return this.a;
    }

    @Override // b.i.a.b.j.i
    @Nullable
    public byte[] c() {
        return this.f763b;
    }

    @Override // b.i.a.b.j.i
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public b.i.a.b.d d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.a.equals(iVar.b())) {
            if (Arrays.equals(this.f763b, iVar instanceof b ? ((b) iVar).f763b : iVar.c()) && this.c.equals(iVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f763b)) * 1000003) ^ this.c.hashCode();
    }
}
