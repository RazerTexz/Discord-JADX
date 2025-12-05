package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JavaDescriptorResolver;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModuleClassResolver.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ModuleClassResolver2 implements ModuleClassResolver {

    /* renamed from: a */
    public JavaDescriptorResolver f23320a;

    public final JavaDescriptorResolver getResolver() {
        JavaDescriptorResolver javaDescriptorResolver = this.f23320a;
        if (javaDescriptorResolver != null) {
            return javaDescriptorResolver;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("resolver");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.ModuleClassResolver
    public ClassDescriptor resolveClass(InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "javaClass");
        return getResolver().resolveClass(interfaceC11574g);
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(javaDescriptorResolver, "<set-?>");
        this.f23320a = javaDescriptorResolver;
    }
}
