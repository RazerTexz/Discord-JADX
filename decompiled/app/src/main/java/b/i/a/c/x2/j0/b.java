package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import b.i.a.c.x2.u;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DefaultOggSeeker.java */
/* loaded from: classes3.dex */
public final class b implements g {
    public final f a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1234b;
    public final long c;
    public final i d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* compiled from: DefaultOggSeeker.java */
    /* renamed from: b.i.a.c.x2.j0.b$b, reason: collision with other inner class name */
    public final class C0104b implements t {
        public C0104b(a aVar) {
        }

        @Override // b.i.a.c.x2.t
        public boolean c() {
            return true;
        }

        @Override // b.i.a.c.x2.t
        public t.a h(long j) {
            b bVar = b.this;
            long j2 = (bVar.d.i * j) / 1000000;
            long j3 = bVar.f1234b;
            long j4 = bVar.c;
            return new t.a(new u(j, e0.i(((((j4 - j3) * j2) / bVar.f) + j3) - 30000, j3, j4 - 1)));
        }

        @Override // b.i.a.c.x2.t
        public long i() {
            return (b.this.f * 1000000) / r0.d.i;
        }
    }

    public b(i iVar, long j, long j2, long j3, long j4, boolean z2) {
        b.c.a.a0.d.j(j >= 0 && j2 > j);
        this.d = iVar;
        this.f1234b = j;
        this.c = j2;
        if (j3 == j2 - j || z2) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new f();
    }

    @Override // b.i.a.c.x2.j0.g
    @Nullable
    public t a() {
        if (this.f != 0) {
            return new C0104b(null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    @Override // b.i.a.c.x2.j0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(b.i.a.c.x2.i iVar) throws IOException {
        boolean z2;
        long jI;
        long j;
        int i = this.e;
        if (i == 0) {
            long position = iVar.getPosition();
            this.g = position;
            this.e = 1;
            long j2 = this.c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                j = -1;
            } else if (this.i == this.j) {
                jI = -1;
                j = -1;
                if (jI == -1) {
                    return jI;
                }
                this.e = 3;
            } else {
                long position2 = iVar.getPosition();
                if (this.a.c(iVar, this.j)) {
                    this.a.a(iVar, false);
                    iVar.k();
                    long j3 = this.h;
                    f fVar = this.a;
                    long j4 = fVar.c;
                    long j5 = j3 - j4;
                    int i2 = fVar.e + fVar.f;
                    if (0 > j5 || j5 >= 72000) {
                        if (j5 < 0) {
                            this.j = position2;
                            this.l = j4;
                        } else {
                            this.i = iVar.getPosition() + i2;
                            this.k = this.a.c;
                        }
                        long j6 = this.j;
                        long j7 = this.i;
                        if (j6 - j7 < 100000) {
                            this.j = j7;
                            jI = j7;
                        } else {
                            long position3 = iVar.getPosition() - (i2 * (j5 <= 0 ? 2L : 1L));
                            long j8 = this.j;
                            long j9 = this.i;
                            jI = e0.i((((j8 - j9) * j5) / (this.l - this.k)) + position3, j9, j8 - 1);
                        }
                    }
                } else {
                    jI = this.i;
                    if (jI == position2) {
                        throw new IOException("No ogg page can be found.");
                    }
                }
                j = -1;
                if (jI == -1) {
                }
            }
            while (true) {
                this.a.c(iVar, j);
                this.a.a(iVar, false);
                f fVar2 = this.a;
                if (fVar2.c > this.h) {
                    iVar.k();
                    this.e = 4;
                    return -(this.k + 2);
                }
                iVar.l(fVar2.e + fVar2.f);
                this.i = iVar.getPosition();
                this.k = this.a.c;
                j = -1;
            }
        }
        this.a.b();
        if (!this.a.c(iVar, -1L)) {
            throw new EOFException();
        }
        this.a.a(iVar, false);
        f fVar3 = this.a;
        iVar.l(fVar3.e + fVar3.f);
        long j10 = this.a.c;
        while (true) {
            f fVar4 = this.a;
            if ((fVar4.f1238b & 4) == 4 || !fVar4.c(iVar, -1L) || iVar.getPosition() >= this.c || !this.a.a(iVar, true)) {
                break;
            }
            f fVar5 = this.a;
            try {
                iVar.l(fVar5.e + fVar5.f);
                z2 = true;
            } catch (EOFException unused) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            j10 = this.a.c;
        }
        this.f = j10;
        this.e = 4;
        return this.g;
    }

    @Override // b.i.a.c.x2.j0.g
    public void c(long j) {
        this.h = e0.i(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.f1234b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
