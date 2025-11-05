package b.g.a.c.i0;

import java.io.Serializable;

/* compiled from: RootNameLookup.java */
/* loaded from: classes3.dex */
public class p implements Serializable {
    private static final long serialVersionUID = 1;
    public transient h<b.g.a.c.h0.b, b.g.a.c.t> j = new h<>(20, 200);

    public Object readResolve() {
        return new p();
    }
}
