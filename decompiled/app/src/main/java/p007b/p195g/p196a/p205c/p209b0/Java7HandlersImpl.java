package p007b.p195g.p196a.p205c.p209b0;

import java.nio.file.Path;
import p007b.p195g.p196a.p205c.JsonSerializer;

/* JADX INFO: renamed from: b.g.a.c.b0.b, reason: use source file name */
/* JADX INFO: compiled from: Java7HandlersImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class Java7HandlersImpl extends Java7Handlers {

    /* JADX INFO: renamed from: b */
    public final Class<?> f4621b = Path.class;

    @Override // p007b.p195g.p196a.p205c.p209b0.Java7Handlers
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1803a(Class<?> cls) {
        if (this.f4621b.isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }
}
