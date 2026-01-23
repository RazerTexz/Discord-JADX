package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.Supplier2;

/* JADX INFO: renamed from: b.i.b.b.c0, reason: use source file name */
/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultimapBuilder<V> implements Supplier2<List<V>>, Serializable {
    private final int expectedValuesPerKey;

    public MultimapBuilder(int i) {
        C3404f.m4189A(i, "expectedValuesPerKey");
        this.expectedValuesPerKey = i;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public Object get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
