package b.o.a.n.p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: BaseLock.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public abstract class a extends b.o.a.n.o.e {
    @Override // b.o.a.n.o.e
    public final void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        boolean zN = n(cVar);
        if (!m(cVar) || zN) {
            l(Integer.MAX_VALUE);
        } else {
            o(cVar);
        }
    }

    public abstract boolean m(@NonNull b.o.a.n.o.c cVar);

    public abstract boolean n(@NonNull b.o.a.n.o.c cVar);

    public abstract void o(@NonNull b.o.a.n.o.c cVar);
}
