package b.i.a.c.e3;

import androidx.core.view.PointerIconCompat;
import b.i.a.c.a3.a0;
import b.i.a.c.e3.f;
import b.i.a.c.s2.g1;
import b.i.a.c.s2.h1;
import b.i.a.c.s2.s0;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ f.a.C0099a.C0100a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ a(f.a.C0099a.C0100a c0100a, int i, long j, long j2) {
        this.j = c0100a;
        this.k = i;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0.a next;
        a0.a aVar;
        a0.a aVar2;
        f.a.C0099a.C0100a c0100a = this.j;
        int i = this.k;
        long j = this.l;
        long j2 = this.m;
        g1 g1Var = (g1) c0100a.f940b;
        g1.a aVar3 = g1Var.m;
        if (aVar3.f1081b.isEmpty()) {
            aVar2 = null;
        } else {
            b.i.b.b.p<a0.a> pVar = aVar3.f1081b;
            if (!(pVar instanceof List)) {
                Iterator<a0.a> it = pVar.iterator();
                do {
                    next = it.next();
                } while (it.hasNext());
                aVar = next;
            } else {
                if (pVar.isEmpty()) {
                    throw new NoSuchElementException();
                }
                aVar = pVar.get(pVar.size() - 1);
            }
            aVar2 = aVar;
        }
        h1.a aVarM0 = g1Var.m0(aVar2);
        s0 s0Var = new s0(aVarM0, i, j, j2);
        g1Var.n.put(PointerIconCompat.TYPE_CELL, aVarM0);
        b.i.a.c.f3.p<h1> pVar2 = g1Var.o;
        pVar2.b(PointerIconCompat.TYPE_CELL, s0Var);
        pVar2.a();
    }
}
