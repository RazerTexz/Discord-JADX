package b.i.a.c.x2.f0;

import b.i.a.c.x2.j;
import b.i.a.c.x2.t;
import b.i.a.c.x2.u;
import b.i.a.c.x2.w;

/* compiled from: StartOffsetExtractorOutput.java */
/* loaded from: classes3.dex */
public final class d implements j {
    public final long j;
    public final j k;

    /* compiled from: StartOffsetExtractorOutput.java */
    public class a implements t {
        public final /* synthetic */ t a;

        public a(t tVar) {
            this.a = tVar;
        }

        @Override // b.i.a.c.x2.t
        public boolean c() {
            return this.a.c();
        }

        @Override // b.i.a.c.x2.t
        public t.a h(long j) {
            t.a aVarH = this.a.h(j);
            u uVar = aVarH.a;
            long j2 = uVar.f1298b;
            long j3 = uVar.c;
            long j4 = d.this.j;
            u uVar2 = new u(j2, j3 + j4);
            u uVar3 = aVarH.f1296b;
            return new t.a(uVar2, new u(uVar3.f1298b, uVar3.c + j4));
        }

        @Override // b.i.a.c.x2.t
        public long i() {
            return this.a.i();
        }
    }

    public d(long j, j jVar) {
        this.j = j;
        this.k = jVar;
    }

    @Override // b.i.a.c.x2.j
    public void a(t tVar) {
        this.k.a(new a(tVar));
    }

    @Override // b.i.a.c.x2.j
    public void j() {
        this.k.j();
    }

    @Override // b.i.a.c.x2.j
    public w p(int i, int i2) {
        return this.k.p(i, i2);
    }
}
