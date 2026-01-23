package p007b.p195g.p196a.p205c.p219i0;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p218h0.ClassKey;

/* JADX INFO: renamed from: b.g.a.c.i0.p, reason: use source file name */
/* JADX INFO: compiled from: RootNameLookup.java */
/* JADX INFO: loaded from: classes3.dex */
public class RootNameLookup implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j */
    public transient LRUMap<ClassKey, PropertyName> f4962j = new LRUMap<>(20, 200);

    public Object readResolve() {
        return new RootNameLookup();
    }
}
