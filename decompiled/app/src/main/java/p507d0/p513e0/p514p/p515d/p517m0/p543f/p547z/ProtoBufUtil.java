package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.e, reason: use source file name */
/* JADX INFO: compiled from: ProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBufUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.d<M>, T> T getExtensionOrNull(GeneratedMessageLite.d<M> dVar, GeneratedMessageLite.f<M, T> fVar) {
        Intrinsics3.checkNotNullParameter(dVar, "<this>");
        Intrinsics3.checkNotNullParameter(fVar, "extension");
        if (dVar.hasExtension(fVar)) {
            return (T) dVar.getExtension(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends GeneratedMessageLite.d<M>, T> T getExtensionOrNull(GeneratedMessageLite.d<M> dVar, GeneratedMessageLite.f<M, List<T>> fVar, int i) {
        Intrinsics3.checkNotNullParameter(dVar, "<this>");
        Intrinsics3.checkNotNullParameter(fVar, "extension");
        if (i < dVar.getExtensionCount(fVar)) {
            return (T) dVar.getExtension(fVar, i);
        }
        return null;
    }
}
