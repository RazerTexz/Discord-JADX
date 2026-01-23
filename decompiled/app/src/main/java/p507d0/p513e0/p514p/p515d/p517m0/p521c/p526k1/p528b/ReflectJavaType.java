package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.w, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaType implements javaTypes5 {

    /* JADX INFO: renamed from: a */
    public static final a f23065a = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.w$a */
    /* JADX INFO: compiled from: ReflectJavaType.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectJavaType create(Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            boolean z2 = type instanceof Class;
            if (z2) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) ? new ReflectJavaArrayType(type) : type instanceof WildcardType ? new ReflectJavaWildcardType((WildcardType) type) : new ReflectJavaClassifierType(type);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics3.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(FqName fqName) {
        return javaTypes5.a.findAnnotation(this, fqName);
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
