package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* compiled from: BinarySearchSeeker.java */
/* loaded from: classes3.dex */
public abstract class a {
    public final C0102a a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1159b;

    @Nullable
    public c c;
    public final int d;

    /* compiled from: BinarySearchSeeker.java */
    /* renamed from: b.i.a.c.x2.a$a, reason: collision with other inner class name */
    public static class C0102a implements t {
        public final d a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1160b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public C0102a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.f1160b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // b.i.a.c.x2.t
        public boolean c() {
            return true;
        }

        @Override // b.i.a.c.x2.t
        public t.a h(long j) {
            return new t.a(new u(j, c.a(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // b.i.a.c.x2.t
        public long i() {
            return this.f1160b;
        }
    }

    /* compiled from: BinarySearchSeeker.java */
    public static final class b implements d {
        @Override // b.i.a.c.x2.a.d
        public long a(long j) {
            return j;
        }
    }

    /* compiled from: BinarySearchSeeker.java */
    public static class c {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1161b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.f1161b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = a(j2, j3, j4, j5, j6, j7);
        }

        public static long a(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return e0.i(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }
    }

    /* compiled from: BinarySearchSeeker.java */
    public interface d {
        long a(long j);
    }

    /* compiled from: BinarySearchSeeker.java */
    public static final class e {
        public static final e a = new e(-3, -9223372036854775807L, -1);

        /* renamed from: b, reason: collision with root package name */
        public final int f1162b;
        public final long c;
        public final long d;

        public e(int i, long j, long j2) {
            this.f1162b = i;
            this.c = j;
            this.d = j2;
        }

        public static e a(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e b(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e c(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* compiled from: BinarySearchSeeker.java */
    public interface f {
        void a();

        e b(i iVar, long j) throws IOException;
    }

    public a(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.f1159b = fVar;
        this.d = i;
        this.a = new C0102a(dVar, j, j2, j3, j4, j5, j6);
    }

    public int a(i iVar, s sVar) throws IOException {
        while (true) {
            c cVar = this.c;
            b.c.a.a0.d.H(cVar);
            long j = cVar.f;
            long j2 = cVar.g;
            long j3 = cVar.h;
            if (j2 - j <= this.d) {
                c(false, j);
                return d(iVar, j, sVar);
            }
            if (!f(iVar, j3)) {
                return d(iVar, j3, sVar);
            }
            iVar.k();
            e eVarB = this.f1159b.b(iVar, cVar.f1161b);
            int i = eVarB.f1162b;
            if (i == -3) {
                c(false, j3);
                return d(iVar, j3, sVar);
            }
            if (i == -2) {
                long j4 = eVarB.c;
                long j5 = eVarB.d;
                cVar.d = j4;
                cVar.f = j5;
                cVar.h = c.a(cVar.f1161b, j4, cVar.e, j5, cVar.g, cVar.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    f(iVar, eVarB.d);
                    c(true, eVarB.d);
                    return d(iVar, eVarB.d, sVar);
                }
                long j6 = eVarB.c;
                long j7 = eVarB.d;
                cVar.e = j6;
                cVar.g = j7;
                cVar.h = c.a(cVar.f1161b, cVar.d, j6, cVar.f, j7, cVar.c);
            }
        }
    }

    public final boolean b() {
        return this.c != null;
    }

    public final void c(boolean z2, long j) {
        this.c = null;
        this.f1159b.a();
    }

    public final int d(i iVar, long j, s sVar) {
        if (j == iVar.getPosition()) {
            return 0;
        }
        sVar.a = j;
        return 1;
    }

    public final void e(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.a != j) {
            long jA = this.a.a.a(j);
            C0102a c0102a = this.a;
            this.c = new c(j, jA, c0102a.c, c0102a.d, c0102a.e, c0102a.f, c0102a.g);
        }
    }

    public final boolean f(i iVar, long j) throws IOException {
        long position = j - iVar.getPosition();
        if (position < 0 || position > Permission.USE_EXTERNAL_EMOJIS) {
            return false;
        }
        iVar.l((int) position);
        return true;
    }
}
