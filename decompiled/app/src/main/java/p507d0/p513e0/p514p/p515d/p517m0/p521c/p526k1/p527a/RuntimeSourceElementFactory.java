package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11579l;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RuntimeSourceElementFactory.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory2 {

    /* renamed from: a */
    public static final RuntimeSourceElementFactory f23025a = new RuntimeSourceElementFactory();

    /* compiled from: RuntimeSourceElementFactory.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.a.m$a */
    public static final class a implements JavaSourceElementFactory {

        /* renamed from: b */
        public final ReflectJavaElement f23026b;

        public a(ReflectJavaElement reflectJavaElement) {
            Intrinsics3.checkNotNullParameter(reflectJavaElement, "javaElement");
            this.f23026b = reflectJavaElement;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement
        public InterfaceC11469v0 getContainingFile() {
            InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
            Intrinsics3.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
            return interfaceC11469v0;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory
        public ReflectJavaElement getJavaElement() {
            return this.f23026b;
        }

        public String toString() {
            return a.class.getName() + ": " + getJavaElement();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory
        public /* bridge */ /* synthetic */ InterfaceC11579l getJavaElement() {
            return getJavaElement();
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory2
    public JavaSourceElementFactory source(InterfaceC11579l interfaceC11579l) {
        Intrinsics3.checkNotNullParameter(interfaceC11579l, "javaElement");
        return new a((ReflectJavaElement) interfaceC11579l);
    }
}
