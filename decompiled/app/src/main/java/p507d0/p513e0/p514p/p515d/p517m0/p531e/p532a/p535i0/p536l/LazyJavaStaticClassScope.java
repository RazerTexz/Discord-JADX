package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaStaticClassScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope extends Lambda implements Function1<InterfaceC11584q, Boolean> {

    /* renamed from: j */
    public static final LazyJavaStaticClassScope f23409j = new LazyJavaStaticClassScope();

    public LazyJavaStaticClassScope() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11584q interfaceC11584q) {
        return Boolean.valueOf(invoke2(interfaceC11584q));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(InterfaceC11584q interfaceC11584q) {
        Intrinsics3.checkNotNullParameter(interfaceC11584q, "it");
        return interfaceC11584q.isStatic();
    }
}
