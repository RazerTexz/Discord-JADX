package b.i.a.c.x2.k0;

import b.i.a.c.x2.a;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* compiled from: TsBinarySearchSeeker.java */
/* loaded from: classes3.dex */
public final class f0 extends b.i.a.c.x2.a {

    /* compiled from: TsBinarySearchSeeker.java */
    public static final class a implements a.f {
        public final b.i.a.c.f3.d0 a;

        /* renamed from: b, reason: collision with root package name */
        public final b.i.a.c.f3.x f1248b = new b.i.a.c.f3.x();
        public final int c;
        public final int d;

        public a(int i, b.i.a.c.f3.d0 d0Var, int i2) {
            this.c = i;
            this.a = d0Var;
            this.d = i2;
        }

        @Override // b.i.a.c.x2.a.f
        public void a() {
            this.f1248b.B(b.i.a.c.f3.e0.f);
        }

        @Override // b.i.a.c.x2.a.f
        public a.e b(b.i.a.c.x2.i iVar, long j) throws IOException {
            long position = iVar.getPosition();
            int iMin = (int) Math.min(this.d, iVar.b() - position);
            this.f1248b.A(iMin);
            iVar.o(this.f1248b.a, 0, iMin);
            b.i.a.c.f3.x xVar = this.f1248b;
            int i = xVar.c;
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (xVar.a() >= 188) {
                byte[] bArr = xVar.a;
                int i2 = xVar.f984b;
                while (i2 < i && bArr[i2] != 71) {
                    i2++;
                }
                int i3 = i2 + Opcodes.NEWARRAY;
                if (i3 > i) {
                    break;
                }
                long jK1 = b.c.a.a0.d.K1(xVar, i2, this.c);
                if (jK1 != -9223372036854775807L) {
                    long jB = this.a.b(jK1);
                    if (jB > j) {
                        return j4 == -9223372036854775807L ? a.e.a(jB, position) : a.e.b(position + j3);
                    }
                    if (100000 + jB > j) {
                        return a.e.b(position + i2);
                    }
                    j4 = jB;
                    j3 = i2;
                }
                xVar.E(i3);
                j2 = i3;
            }
            return j4 != -9223372036854775807L ? a.e.c(j4, position + j2) : a.e.a;
        }
    }

    public f0(b.i.a.c.f3.d0 d0Var, long j, long j2, int i, int i2) {
        super(new a.b(), new a(i, d0Var, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
