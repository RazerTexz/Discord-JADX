package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p580t.Collections2;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.z, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements javaTypes {

    /* JADX INFO: renamed from: b */
    public final WildcardType f23071b;

    /* JADX INFO: renamed from: c */
    public final Collection<InterfaceC11564a> f23072c;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics3.checkNotNullParameter(wildcardType, "reflectType");
        this.f23071b = wildcardType;
        this.f23072c = Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23072c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes
    public ReflectJavaType getBound() {
        Type[] upperBounds = this.f23071b.getUpperBounds();
        Type[] lowerBounds = this.f23071b.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(Intrinsics3.stringPlus("Wildcard types with many bounds are not yet supported: ", this.f23071b));
        }
        if (lowerBounds.length == 1) {
            ReflectJavaType.a aVar = ReflectJavaType.f23065a;
            Intrinsics3.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object objSingle = _Arrays.single(lowerBounds);
            Intrinsics3.checkNotNullExpressionValue(objSingle, "lowerBounds.single()");
            return aVar.create((Type) objSingle);
        }
        if (upperBounds.length != 1) {
            return null;
        }
        Intrinsics3.checkNotNullExpressionValue(upperBounds, "upperBounds");
        Type type = (Type) _Arrays.single(upperBounds);
        if (Intrinsics3.areEqual(type, Object.class)) {
            return null;
        }
        ReflectJavaType.a aVar2 = ReflectJavaType.f23065a;
        Intrinsics3.checkNotNullExpressionValue(type, "ub");
        return aVar2.create(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType
    public Type getReflectType() {
        return this.f23071b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes
    public boolean isExtends() {
        Intrinsics3.checkNotNullExpressionValue(this.f23071b.getUpperBounds(), "reflectType.upperBounds");
        return !Intrinsics3.areEqual(_Arrays.firstOrNull(r0), Object.class);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes
    public /* bridge */ /* synthetic */ javaTypes5 getBound() {
        return getBound();
    }
}
