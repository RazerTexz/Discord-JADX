package b.o.a.x;

import androidx.annotation.NonNull;
import b.i.a.f.e.o.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SizeSelectors.java */
/* loaded from: classes3.dex */
public class l implements c {
    public c[] a;

    public l(c[] cVarArr, f.a aVar) {
        this.a = cVarArr;
    }

    @Override // b.o.a.x.c
    @NonNull
    public List<b> a(@NonNull List<b> list) {
        List<b> listA = null;
        for (c cVar : this.a) {
            listA = cVar.a(list);
            if (!listA.isEmpty()) {
                break;
            }
        }
        return listA == null ? new ArrayList() : listA;
    }
}
