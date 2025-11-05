package b.f.j.p;

import java.util.Objects;

/* compiled from: ThumbnailBranchProducer.java */
/* loaded from: classes3.dex */
public class j1 implements w0<b.f.j.j.e> {
    public final k1<b.f.j.j.e>[] a;

    /* compiled from: ThumbnailBranchProducer.java */
    public class a extends p<b.f.j.j.e, b.f.j.j.e> {
        public final x0 c;
        public final int d;
        public final b.f.j.d.e e;

        public a(l<b.f.j.j.e> lVar, x0 x0Var, int i) {
            super(lVar);
            this.c = x0Var;
            this.d = i;
            this.e = x0Var.e().j;
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            if (j1.this.c(this.d + 1, this.f632b, this.c)) {
                return;
            }
            this.f632b.c(th);
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            if (eVar != null && (b.f(i) || b.c.a.a0.d.T0(eVar, this.e))) {
                this.f632b.b(eVar, i);
                return;
            }
            if (b.e(i)) {
                if (eVar != null) {
                    eVar.close();
                }
                if (j1.this.c(this.d + 1, this.f632b, this.c)) {
                    return;
                }
                this.f632b.b(null, 1);
            }
        }
    }

    public j1(k1<b.f.j.j.e>... k1VarArr) {
        Objects.requireNonNull(k1VarArr);
        this.a = k1VarArr;
        int length = k1VarArr.length;
        if (length <= 0) {
            if (length < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.q("negative size: ", length));
            }
            throw new IndexOutOfBoundsException(b.c.a.a0.d.k0("%s (%s) must be less than size (%s)", "index", 0, Integer.valueOf(length)));
        }
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        if (x0Var.e().j == null) {
            lVar.b(null, 1);
        } else {
            if (c(0, lVar, x0Var)) {
                return;
            }
            lVar.b(null, 1);
        }
    }

    public final boolean c(int i, l<b.f.j.j.e> lVar, x0 x0Var) {
        b.f.j.d.e eVar = x0Var.e().j;
        while (true) {
            k1<b.f.j.j.e>[] k1VarArr = this.a;
            if (i >= k1VarArr.length) {
                i = -1;
                break;
            }
            if (k1VarArr[i].a(eVar)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        this.a[i].b(new a(lVar, x0Var, i), x0Var);
        return true;
    }
}
