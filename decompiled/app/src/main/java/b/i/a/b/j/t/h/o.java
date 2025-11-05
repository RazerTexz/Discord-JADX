package b.i.a.b.j.t.h;

import b.i.a.b.j.u.a;
import java.util.Iterator;

/* compiled from: WorkInitializer.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements a.InterfaceC0091a {
    public final p a;

    public o(p pVar) {
        this.a = pVar;
    }

    @Override // b.i.a.b.j.u.a.InterfaceC0091a
    public Object execute() {
        p pVar = this.a;
        Iterator<b.i.a.b.j.i> it = pVar.f793b.z().iterator();
        while (it.hasNext()) {
            pVar.c.a(it.next(), 1);
        }
        return null;
    }
}
