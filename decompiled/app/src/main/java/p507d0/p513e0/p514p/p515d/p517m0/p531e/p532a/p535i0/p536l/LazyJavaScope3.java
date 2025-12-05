package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaScope3 extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {

    /* renamed from: j */
    public static final LazyJavaScope3 f23408j = new LazyJavaScope3();

    public LazyJavaScope3() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CallableDescriptor invoke2(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return simpleFunctionDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        return invoke2(simpleFunctionDescriptor);
    }
}
