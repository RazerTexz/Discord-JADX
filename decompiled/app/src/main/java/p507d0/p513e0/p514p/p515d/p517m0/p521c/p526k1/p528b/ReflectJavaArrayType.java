package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaArrayType.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements javaTypes2 {

    /* renamed from: b */
    public final Type f23043b;

    /* renamed from: c */
    public final ReflectJavaType f23044c;

    /* renamed from: d */
    public final Collection<InterfaceC11564a> f23045d;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaTypeCreate;
        Intrinsics3.checkNotNullParameter(type, "reflectType");
        this.f23043b = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    ReflectJavaType.a aVar = ReflectJavaType.f23065a;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics3.checkNotNullExpressionValue(componentType, "getComponentType()");
                    reflectJavaTypeCreate = aVar.create(componentType);
                }
            }
            StringBuilder sbM833U = outline.m833U("Not an array type (");
            sbM833U.append(type.getClass());
            sbM833U.append("): ");
            sbM833U.append(type);
            throw new IllegalArgumentException(sbM833U.toString());
        }
        ReflectJavaType.a aVar2 = ReflectJavaType.f23065a;
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        Intrinsics3.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
        reflectJavaTypeCreate = aVar2.create(genericComponentType);
        this.f23044c = reflectJavaTypeCreate;
        this.f23045d = Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23045d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2
    public /* bridge */ /* synthetic */ javaTypes5 getComponentType() {
        return getComponentType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaType
    public Type getReflectType() {
        return this.f23043b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2
    public ReflectJavaType getComponentType() {
        return this.f23044c;
    }
}
