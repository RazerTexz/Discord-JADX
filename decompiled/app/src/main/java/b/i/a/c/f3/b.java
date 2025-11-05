package b.i.a.c.f3;

import android.os.Handler;
import android.os.Message;
import b.i.a.c.f3.n;
import b.i.a.c.f3.p;
import java.util.Iterator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Handler.Callback {
    public final /* synthetic */ p j;

    public /* synthetic */ b(p pVar) {
        this.j = pVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        p pVar = this.j;
        Iterator it = pVar.d.iterator();
        while (it.hasNext()) {
            p.c cVar = (p.c) it.next();
            p.b<T> bVar = pVar.c;
            if (!cVar.d && cVar.c) {
                n nVarB = cVar.f974b.b();
                cVar.f974b = new n.b();
                cVar.c = false;
                bVar.a(cVar.a, nVarB);
            }
            if (pVar.f973b.e(0)) {
                return true;
            }
        }
        return true;
    }
}
