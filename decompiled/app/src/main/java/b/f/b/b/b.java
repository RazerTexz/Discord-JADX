package b.f.b.b;

import b.f.b.b.c;

/* compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* loaded from: classes.dex */
public class b implements g {

    /* compiled from: DefaultEntryEvictionComparatorSupplier.java */
    public class a implements f {
        public a(b bVar) {
        }

        @Override // java.util.Comparator
        public int compare(c.a aVar, c.a aVar2) {
            long jA = aVar.a();
            long jA2 = aVar2.a();
            if (jA < jA2) {
                return -1;
            }
            return jA2 == jA ? 0 : 1;
        }
    }

    @Override // b.f.b.b.g
    public f get() {
        return new a(this);
    }
}
