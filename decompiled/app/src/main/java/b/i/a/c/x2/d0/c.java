package b.i.a.c.x2.d0;

import b.i.a.c.f3.x;
import b.i.a.c.x2.a;
import b.i.a.c.x2.i;
import b.i.a.c.x2.m;
import b.i.a.c.x2.o;
import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FlacBinarySearchSeeker.java */
/* loaded from: classes3.dex */
public final class c extends b.i.a.c.x2.a {

    /* compiled from: FlacBinarySearchSeeker.java */
    public static final class b implements a.f {
        public final o a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1168b;
        public final m.a c = new m.a();

        public b(o oVar, int i, a aVar) {
            this.a = oVar;
            this.f1168b = i;
        }

        @Override // b.i.a.c.x2.a.f
        public /* synthetic */ void a() {
            b.i.a.c.x2.b.a(this);
        }

        @Override // b.i.a.c.x2.a.f
        public a.e b(i iVar, long j) throws IOException {
            long position = iVar.getPosition();
            long jC = c(iVar);
            long jF = iVar.f();
            iVar.g(Math.max(6, this.a.c));
            long jC2 = c(iVar);
            return (jC > j || jC2 <= j) ? jC2 <= j ? a.e.c(jC2, iVar.f()) : a.e.a(jC, position) : a.e.b(jF);
        }

        public final long c(i iVar) throws IOException {
            while (iVar.f() < iVar.b() - 6) {
                o oVar = this.a;
                int i = this.f1168b;
                m.a aVar = this.c;
                long jF = iVar.f();
                byte[] bArr = new byte[2];
                boolean zB = false;
                iVar.o(bArr, 0, 2);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                    iVar.k();
                    iVar.g((int) (jF - iVar.getPosition()));
                } else {
                    x xVar = new x(16);
                    System.arraycopy(bArr, 0, xVar.a, 0, 2);
                    xVar.D(b.c.a.a0.d.z1(iVar, xVar.a, 2, 14));
                    iVar.k();
                    iVar.g((int) (jF - iVar.getPosition()));
                    zB = m.b(xVar, oVar, i, aVar);
                }
                if (zB) {
                    break;
                }
                iVar.g(1);
            }
            if (iVar.f() < iVar.b() - 6) {
                return this.c.a;
            }
            iVar.g((int) (iVar.b() - iVar.f()));
            return this.a.j;
        }
    }

    public c(o oVar, int i, long j, long j2) {
        long j3;
        long j4;
        Objects.requireNonNull(oVar);
        b.i.a.c.x2.d0.b bVar = new b.i.a.c.x2.d0.b(oVar);
        b bVar2 = new b(oVar, i, null);
        long jD = oVar.d();
        long j5 = oVar.j;
        int i2 = oVar.d;
        if (i2 > 0) {
            j3 = (i2 + oVar.c) / 2;
            j4 = 1;
        } else {
            int i3 = oVar.a;
            j3 = ((((i3 != oVar.f1292b || i3 <= 0) ? Permission.SEND_TTS_MESSAGES : i3) * oVar.g) * oVar.h) / 8;
            j4 = 64;
        }
        super(bVar, bVar2, jD, 0L, j5, j, j2, j3 + j4, Math.max(6, oVar.c));
    }
}
