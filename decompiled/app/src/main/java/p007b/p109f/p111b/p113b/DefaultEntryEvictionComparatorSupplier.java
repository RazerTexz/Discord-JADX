package p007b.p109f.p111b.p113b;

import p007b.p109f.p111b.p113b.DiskStorage;

/* JADX INFO: renamed from: b.f.b.b.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {

    /* JADX INFO: renamed from: b.f.b.b.b$a */
    /* JADX INFO: compiled from: DefaultEntryEvictionComparatorSupplier.java */
    public class a implements EntryEvictionComparator {
        public a(DefaultEntryEvictionComparatorSupplier defaultEntryEvictionComparatorSupplier) {
        }

        @Override // java.util.Comparator
        public int compare(DiskStorage.a aVar, DiskStorage.a aVar2) {
            long jMo945a = aVar.mo945a();
            long jMo945a2 = aVar2.mo945a();
            if (jMo945a < jMo945a2) {
                return -1;
            }
            return jMo945a2 == jMo945a ? 0 : 1;
        }
    }

    @Override // p007b.p109f.p111b.p113b.EntryEvictionComparatorSupplier
    public EntryEvictionComparator get() {
        return new a(this);
    }
}
