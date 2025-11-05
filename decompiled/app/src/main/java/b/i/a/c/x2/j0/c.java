package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.x2.j0.i;
import b.i.a.c.x2.m;
import b.i.a.c.x2.n;
import b.i.a.c.x2.o;
import b.i.a.c.x2.t;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: FlacReader.java */
/* loaded from: classes3.dex */
public final class c extends i {

    @Nullable
    public o n;

    @Nullable
    public a o;

    /* compiled from: FlacReader.java */
    public static final class a implements g {
        public o a;

        /* renamed from: b, reason: collision with root package name */
        public o.a f1235b;
        public long c = -1;
        public long d = -1;

        public a(o oVar, o.a aVar) {
            this.a = oVar;
            this.f1235b = aVar;
        }

        @Override // b.i.a.c.x2.j0.g
        public t a() {
            b.c.a.a0.d.D(this.c != -1);
            return new n(this.a, this.c);
        }

        @Override // b.i.a.c.x2.j0.g
        public long b(b.i.a.c.x2.i iVar) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        @Override // b.i.a.c.x2.j0.g
        public void c(long j) {
            long[] jArr = this.f1235b.a;
            this.d = jArr[e0.e(jArr, j, true, true)];
        }
    }

    @Override // b.i.a.c.x2.j0.i
    public long c(x xVar) {
        byte[] bArr = xVar.a;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            xVar.F(4);
            xVar.z();
        }
        int iC = m.c(xVar, i);
        xVar.E(0);
        return iC;
    }

    @Override // b.i.a.c.x2.j0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(x xVar, long j, i.b bVar) {
        byte[] bArr = xVar.a;
        o oVar = this.n;
        if (oVar == null) {
            o oVar2 = new o(bArr, 17);
            this.n = oVar2;
            bVar.a = oVar2.e(Arrays.copyOfRange(bArr, 9, xVar.c), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            o.a aVarL1 = b.c.a.a0.d.L1(xVar);
            o oVarB = oVar.b(aVarL1);
            this.n = oVarB;
            this.o = new a(oVarB, aVarL1);
            return true;
        }
        if (!(bArr[0] == -1)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.c = j;
            bVar.f1240b = aVar;
        }
        Objects.requireNonNull(bVar.a);
        return false;
    }

    @Override // b.i.a.c.x2.j0.i
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.o = null;
        }
    }
}
