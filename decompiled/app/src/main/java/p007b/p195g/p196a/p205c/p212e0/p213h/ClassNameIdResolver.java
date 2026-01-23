package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p212e0.PolymorphicTypeValidator;
import p007b.p195g.p196a.p205c.p218h0.CollectionType;
import p007b.p195g.p196a.p205c.p218h0.MapType;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.e0.h.f, reason: use source file name */
/* JADX INFO: compiled from: ClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassNameIdResolver extends TypeIdResolverBase {
    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeIdResolver
    /* JADX INFO: renamed from: a */
    public String mo1946a(Object obj) {
        return m1964d(obj, obj.getClass(), this.f4774a);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeIdResolver
    /* JADX INFO: renamed from: c */
    public String mo1948c(Object obj, Class<?> cls) {
        return m1964d(obj, cls, this.f4774a);
    }

    /* JADX INFO: renamed from: d */
    public String m1964d(Object obj, Class<?> cls, TypeFactory typeFactory) {
        Class<?> declaringClass;
        JavaType javaTypeM2161c;
        JavaType javaTypeM2161c2;
        TypeBindings typeBindings;
        Class<?> declaringClass2;
        TypeBindings typeBindings2;
        Class<?> superclass = (!ClassUtil.m2185q(cls) || cls.isEnum()) ? cls : cls.getSuperclass();
        String name = superclass.getName();
        if (!name.startsWith("java.util.")) {
            return (name.indexOf(36) < 0 || ClassUtil.m2181m(superclass) == null || ClassUtil.m2181m(this.f4775b._class) != null) ? name : this.f4775b._class.getName();
        }
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (enumSet.isEmpty()) {
                Field field = ClassUtil.b.f4951a.f4952b;
                if (field == null) {
                    throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
                }
                try {
                    declaringClass2 = (Class) field.get(enumSet);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
            }
            JavaType javaTypeM2161c3 = typeFactory.m2161c(null, declaringClass2, TypeFactory.f4926l);
            String[] strArr = TypeBindings.f4906j;
            TypeVariable[] typeParameters = EnumSet.class.getTypeParameters();
            int length = typeParameters == null ? 0 : typeParameters.length;
            if (length == 0) {
                typeBindings2 = TypeBindings.f4908l;
            } else {
                if (length != 1) {
                    StringBuilder sbM833U = outline.m833U("Cannot create TypeBindings for class ");
                    sbM833U.append(EnumSet.class.getName());
                    sbM833U.append(" with 1 type parameter: class expects ");
                    sbM833U.append(length);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                typeBindings2 = new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaTypeM2161c3}, null);
            }
            CollectionType collectionType = (CollectionType) typeFactory.m2161c(null, EnumSet.class, typeBindings2);
            if (typeBindings2.m2154i()) {
                JavaType javaTypeMo2099k = collectionType.mo2144i(Collection.class).mo2099k();
                if (!javaTypeMo2099k.equals(javaTypeM2161c3)) {
                    throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", ClassUtil.m2189u(EnumSet.class), javaTypeM2161c3, javaTypeMo2099k));
                }
            }
            return collectionType.mo2106K();
        }
        if (!(obj instanceof EnumMap)) {
            return name;
        }
        EnumMap enumMap = (EnumMap) obj;
        if (enumMap.isEmpty()) {
            Field field2 = ClassUtil.b.f4951a.f4953c;
            if (field2 == null) {
                throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
            }
            try {
                declaringClass = (Class) field2.get(enumMap);
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
        }
        Objects.requireNonNull(typeFactory);
        if (EnumMap.class == Properties.class) {
            javaTypeM2161c = TypeFactory.f4939y;
            javaTypeM2161c2 = javaTypeM2161c;
        } else {
            TypeBindings typeBindings3 = TypeFactory.f4926l;
            javaTypeM2161c = typeFactory.m2161c(null, declaringClass, typeBindings3);
            javaTypeM2161c2 = typeFactory.m2161c(null, Object.class, typeBindings3);
        }
        JavaType[] javaTypeArr = {javaTypeM2161c, javaTypeM2161c2};
        String[] strArr2 = TypeBindings.f4906j;
        TypeVariable[] typeParameters2 = EnumMap.class.getTypeParameters();
        if (typeParameters2 == null || typeParameters2.length == 0) {
            typeBindings = TypeBindings.f4908l;
        } else {
            int length2 = typeParameters2.length;
            String[] strArr3 = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr3[i] = typeParameters2[i].getName();
            }
            if (length2 != 2) {
                StringBuilder sbM833U2 = outline.m833U("Cannot create TypeBindings for class ");
                sbM833U2.append(EnumMap.class.getName());
                sbM833U2.append(" with ");
                sbM833U2.append(2);
                sbM833U2.append(" type parameter");
                sbM833U2.append("s");
                sbM833U2.append(": class expects ");
                sbM833U2.append(length2);
                throw new IllegalArgumentException(sbM833U2.toString());
            }
            typeBindings = new TypeBindings(strArr3, javaTypeArr, null);
        }
        MapType mapType = (MapType) typeFactory.m2161c(null, EnumMap.class, typeBindings);
        if (typeBindings.m2154i()) {
            JavaType javaTypeMo2144i = mapType.mo2144i(Map.class);
            JavaType javaTypeMo2121o = javaTypeMo2144i.mo2121o();
            if (!javaTypeMo2121o.equals(javaTypeM2161c)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", ClassUtil.m2189u(EnumMap.class), javaTypeM2161c, javaTypeMo2121o));
            }
            JavaType javaTypeMo2099k2 = javaTypeMo2144i.mo2099k();
            if (!javaTypeMo2099k2.equals(javaTypeM2161c2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", ClassUtil.m2189u(EnumMap.class), javaTypeM2161c2, javaTypeMo2099k2));
            }
        }
        return mapType.mo2106K();
    }
}
