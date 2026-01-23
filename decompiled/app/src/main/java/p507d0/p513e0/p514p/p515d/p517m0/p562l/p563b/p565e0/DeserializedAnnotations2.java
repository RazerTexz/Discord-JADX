package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.n, reason: use source file name */
/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedAnnotations2 extends DeserializedAnnotations {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedAnnotations2(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        super(storageManager, function0);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "compute");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedAnnotations, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4
    public boolean isEmpty() {
        return false;
    }
}
