package b.i.a.c.x2;

import androidx.annotation.Nullable;

/* compiled from: SeekMap.java */
/* loaded from: classes3.dex */
public interface t {

    /* compiled from: SeekMap.java */
    public static class b implements t {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final a f1297b;

        public b(long j, long j2) {
            this.a = j;
            this.f1297b = new a(j2 == 0 ? u.a : new u(0L, j2));
        }

        @Override // b.i.a.c.x2.t
        public boolean c() {
            return false;
        }

        @Override // b.i.a.c.x2.t
        public a h(long j) {
            return this.f1297b;
        }

        @Override // b.i.a.c.x2.t
        public long i() {
            return this.a;
        }
    }

    boolean c();

    a h(long j);

    long i();

    /* compiled from: SeekMap.java */
    public static final class a {
        public final u a;

        /* renamed from: b, reason: collision with root package name */
        public final u f1296b;

        public a(u uVar) {
            this.a = uVar;
            this.f1296b = uVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.f1296b.equals(aVar.f1296b);
        }

        public int hashCode() {
            return this.f1296b.hashCode() + (this.a.hashCode() * 31);
        }

        public String toString() {
            String strJ;
            String strValueOf = String.valueOf(this.a);
            if (this.a.equals(this.f1296b)) {
                strJ = "";
            } else {
                String strValueOf2 = String.valueOf(this.f1296b);
                strJ = b.d.b.a.a.j(strValueOf2.length() + 2, ", ", strValueOf2);
            }
            return b.d.b.a.a.l(b.d.b.a.a.b(strJ, strValueOf.length() + 2), "[", strValueOf, strJ, "]");
        }

        public a(u uVar, u uVar2) {
            this.a = uVar;
            this.f1296b = uVar2;
        }
    }
}
