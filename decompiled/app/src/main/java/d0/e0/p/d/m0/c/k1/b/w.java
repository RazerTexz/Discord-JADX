package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.x;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReflectJavaType.kt */
/* loaded from: classes3.dex */
public abstract class w implements d0.e0.p.d.m0.e.a.k0.x {
    public static final a a = new a(null);

    /* compiled from: ReflectJavaType.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final w create(Type type) {
            d0.z.d.m.checkNotNullParameter(type, "type");
            boolean z2 = type instanceof Class;
            if (z2) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new v(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) ? new i(type) : type instanceof WildcardType ? new z((WildcardType) type) : new l(type);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && d0.z.d.m.areEqual(getReflectType(), ((w) obj).getReflectType());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return x.a.findAnnotation(this, bVar);
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
