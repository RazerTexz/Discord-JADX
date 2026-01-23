package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.KPropertyImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.u, reason: use source file name */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KPropertyImpl3 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl3(KPropertyImpl.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return !TypeUtils.isNullableType(this.$this_computeCallerForAccessor.getProperty().getDescriptor().getType());
    }
}
