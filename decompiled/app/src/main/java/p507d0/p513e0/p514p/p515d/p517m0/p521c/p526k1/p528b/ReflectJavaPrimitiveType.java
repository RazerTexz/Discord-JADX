package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Type;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.v, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements javaTypes4 {

    /* JADX INFO: renamed from: b */
    public final Class<?> f23063b;

    /* JADX INFO: renamed from: c */
    public final Collection<InterfaceC11564a> f23064c;

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "reflectType");
        this.f23063b = cls;
        this.f23064c = Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23064c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType
    public Type getReflectType() {
        return this.f23063b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes4
    public PrimitiveType getType() {
        if (Intrinsics3.areEqual(this.f23063b, Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(this.f23063b.getName()).getPrimitiveType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
