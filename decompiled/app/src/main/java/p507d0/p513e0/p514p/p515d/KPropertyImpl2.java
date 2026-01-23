package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.KPropertyImpl;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.t, reason: use source file name */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KPropertyImpl2 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl2(KPropertyImpl.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.$this_computeCallerForAccessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(util2.getJVM_STATIC());
    }
}
