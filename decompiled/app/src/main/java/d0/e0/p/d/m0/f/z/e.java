package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.i.g;
import d0.z.d.m;
import java.util.List;

/* compiled from: ProtoBufUtil.kt */
/* loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends g.d<M>, T> T getExtensionOrNull(g.d<M> dVar, g.f<M, T> fVar) {
        m.checkNotNullParameter(dVar, "<this>");
        m.checkNotNullParameter(fVar, "extension");
        if (dVar.hasExtension(fVar)) {
            return (T) dVar.getExtension(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends g.d<M>, T> T getExtensionOrNull(g.d<M> dVar, g.f<M, List<T>> fVar, int i) {
        m.checkNotNullParameter(dVar, "<this>");
        m.checkNotNullParameter(fVar, "extension");
        if (i < dVar.getExtensionCount(fVar)) {
            return (T) dVar.getExtension(fVar, i);
        }
        return null;
    }
}
