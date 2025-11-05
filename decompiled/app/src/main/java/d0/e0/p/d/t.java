package d0.e0.p.d;

import d0.e0.p.d.s;
import kotlin.jvm.functions.Function0;

/* compiled from: KPropertyImpl.kt */
/* loaded from: classes3.dex */
public final class t extends d0.z.d.o implements Function0<Boolean> {
    public final /* synthetic */ s.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.$this_computeCallerForAccessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(j0.getJVM_STATIC());
    }
}
