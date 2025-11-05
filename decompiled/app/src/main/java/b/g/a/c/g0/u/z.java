package b.g.a.c.g0.u;

import b.g.a.b.f;
import java.io.IOException;

/* compiled from: NumberSerializers.java */
@b.g.a.c.y.a
/* loaded from: classes3.dex */
public class z extends w<Object> {
    public static final z k = new z();

    public z() {
        super(Number.class, f.b.INT, "integer");
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.H(((Number) obj).intValue());
    }
}
