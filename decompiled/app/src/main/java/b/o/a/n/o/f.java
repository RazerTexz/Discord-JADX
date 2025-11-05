package b.o.a.n.o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: CompletionCallback.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public abstract class f implements b {
    @Override // b.o.a.n.o.b
    public final void a(@NonNull a aVar, int i) {
        if (i == Integer.MAX_VALUE) {
            b(aVar);
        }
    }

    public abstract void b(@NonNull a aVar);
}
