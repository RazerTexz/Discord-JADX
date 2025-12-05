package p007b.p195g.p196a.p205c.p218h0;

import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: TypeBindings.java */
/* renamed from: b.g.a.c.h0.m, reason: use source file name */
/* loaded from: classes3.dex */
public class TypeBindings implements Serializable {

    /* renamed from: j */
    public static final String[] f4906j;

    /* renamed from: k */
    public static final JavaType[] f4907k;

    /* renamed from: l */
    public static final TypeBindings f4908l;
    private static final long serialVersionUID = 1;
    private final int _hashCode;
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;

    /* compiled from: TypeBindings.java */
    /* renamed from: b.g.a.c.h0.m$a */
    public static final class a {

        /* renamed from: a */
        public final Class<?> f4909a;

        /* renamed from: b */
        public final JavaType[] f4910b;

        /* renamed from: c */
        public final int f4911c;

        public a(Class<?> cls, JavaType[] javaTypeArr, int i) {
            this.f4909a = cls;
            this.f4910b = javaTypeArr;
            this.f4911c = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4911c == aVar.f4911c && this.f4909a == aVar.f4909a) {
                JavaType[] javaTypeArr = aVar.f4910b;
                int length = this.f4910b.length;
                if (length == javaTypeArr.length) {
                    for (int i = 0; i < length; i++) {
                        if (!this.f4910b[i].equals(javaTypeArr[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f4911c;
        }

        public String toString() {
            return outline.m867o(this.f4909a, new StringBuilder(), "<>");
        }
    }

    /* compiled from: TypeBindings.java */
    /* renamed from: b.g.a.c.h0.m$b */
    public static class b {

        /* renamed from: a */
        public static final TypeVariable<?>[] f4912a = AbstractList.class.getTypeParameters();

        /* renamed from: b */
        public static final TypeVariable<?>[] f4913b = Collection.class.getTypeParameters();

        /* renamed from: c */
        public static final TypeVariable<?>[] f4914c = Iterable.class.getTypeParameters();

        /* renamed from: d */
        public static final TypeVariable<?>[] f4915d = List.class.getTypeParameters();

        /* renamed from: e */
        public static final TypeVariable<?>[] f4916e = ArrayList.class.getTypeParameters();

        /* renamed from: f */
        public static final TypeVariable<?>[] f4917f = Map.class.getTypeParameters();

        /* renamed from: g */
        public static final TypeVariable<?>[] f4918g = HashMap.class.getTypeParameters();

        /* renamed from: h */
        public static final TypeVariable<?>[] f4919h = LinkedHashMap.class.getTypeParameters();
    }

    static {
        String[] strArr = new String[0];
        f4906j = strArr;
        JavaType[] javaTypeArr = new JavaType[0];
        f4907k = javaTypeArr;
        f4908l = new TypeBindings(strArr, javaTypeArr, null);
    }

    public TypeBindings(String[] strArr, JavaType[] javaTypeArr, String[] strArr2) {
        strArr = strArr == null ? f4906j : strArr;
        this._names = strArr;
        javaTypeArr = javaTypeArr == null ? f4907k : javaTypeArr;
        this._types = javaTypeArr;
        if (strArr.length != javaTypeArr.length) {
            StringBuilder sbM833U = outline.m833U("Mismatching names (");
            sbM833U.append(strArr.length);
            sbM833U.append("), types (");
            throw new IllegalArgumentException(outline.m814B(sbM833U, javaTypeArr.length, ")"));
        }
        int length = javaTypeArr.length;
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            i += this._types[i2]._hash;
        }
        this._unboundVariables = strArr2;
        this._hashCode = i;
    }

    /* renamed from: b */
    public static TypeBindings m2146b(Class<?> cls, JavaType javaType) {
        TypeVariable<?>[] typeVariableArr = b.f4912a;
        TypeVariable[] typeParameters = cls == Collection.class ? b.f4913b : cls == List.class ? b.f4915d : cls == ArrayList.class ? b.f4916e : cls == AbstractList.class ? b.f4912a : cls == Iterable.class ? b.f4914c : cls.getTypeParameters();
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new TypeBindings(new String[]{typeParameters[0].getName()}, new JavaType[]{javaType}, null);
        }
        StringBuilder sbM833U = outline.m833U("Cannot create TypeBindings for class ");
        sbM833U.append(cls.getName());
        sbM833U.append(" with 1 type parameter: class expects ");
        sbM833U.append(length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* renamed from: c */
    public static TypeBindings m2147c(Class<?> cls, JavaType javaType, JavaType javaType2) {
        TypeVariable<?>[] typeVariableArr = b.f4912a;
        TypeVariable[] typeParameters = cls == Map.class ? b.f4917f : cls == HashMap.class ? b.f4918g : cls == LinkedHashMap.class ? b.f4919h : cls.getTypeParameters();
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new TypeBindings(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new JavaType[]{javaType, javaType2}, null);
        }
        StringBuilder sbM833U = outline.m833U("Cannot create TypeBindings for class ");
        sbM833U.append(cls.getName());
        sbM833U.append(" with 2 type parameters: class expects ");
        sbM833U.append(length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* renamed from: d */
    public static TypeBindings m2148d(Class<?> cls, JavaType[] javaTypeArr) {
        String[] strArr;
        int length = javaTypeArr.length;
        if (length == 1) {
            return m2146b(cls, javaTypeArr[0]);
        }
        if (length == 2) {
            return m2147c(cls, javaTypeArr[0], javaTypeArr[1]);
        }
        TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f4906j;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr[i] = typeParameters[i].getName();
            }
        }
        if (strArr.length == javaTypeArr.length) {
            return new TypeBindings(strArr, javaTypeArr, null);
        }
        StringBuilder sbM833U = outline.m833U("Cannot create TypeBindings for class ");
        outline.m860k0(cls, sbM833U, " with ");
        sbM833U.append(javaTypeArr.length);
        sbM833U.append(" type parameter");
        sbM833U.append(javaTypeArr.length == 1 ? "" : "s");
        sbM833U.append(": class expects ");
        sbM833U.append(strArr.length);
        throw new IllegalArgumentException(sbM833U.toString());
    }

    /* renamed from: a */
    public Object m2149a(Class<?> cls) {
        return new a(cls, this._types, this._hashCode);
    }

    /* renamed from: e */
    public JavaType m2150e(String str) {
        JavaType javaType;
        int length = this._names.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(this._names[i])) {
                JavaType javaType2 = this._types[i];
                return (!(javaType2 instanceof ResolvedRecursiveType) || (javaType = ((ResolvedRecursiveType) javaType2)._referencedType) == null) ? javaType2 : javaType;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!ClassUtil.m2183o(obj, TypeBindings.class)) {
            return false;
        }
        int length = this._types.length;
        JavaType[] javaTypeArr = ((TypeBindings) obj)._types;
        if (length != javaTypeArr.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!javaTypeArr[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public JavaType m2151f(int i) {
        if (i < 0) {
            return null;
        }
        JavaType[] javaTypeArr = this._types;
        if (i >= javaTypeArr.length) {
            return null;
        }
        return javaTypeArr[i];
    }

    /* renamed from: g */
    public List<JavaType> m2152g() {
        JavaType[] javaTypeArr = this._types;
        return javaTypeArr.length == 0 ? Collections.emptyList() : Arrays.asList(javaTypeArr);
    }

    /* renamed from: h */
    public boolean m2153h(String str) {
        String[] strArr = this._unboundVariables;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this._unboundVariables[length]));
        return true;
    }

    public int hashCode() {
        return this._hashCode;
    }

    /* renamed from: i */
    public boolean m2154i() {
        return this._types.length == 0;
    }

    /* renamed from: j */
    public int m2155j() {
        return this._types.length;
    }

    /* renamed from: k */
    public JavaType[] m2156k() {
        return this._types;
    }

    /* renamed from: l */
    public TypeBindings m2157l(String str) {
        String[] strArr = this._unboundVariables;
        int length = strArr == null ? 0 : strArr.length;
        String[] strArr2 = length == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr, length + 1);
        strArr2[length] = str;
        return new TypeBindings(this._names, this._types, strArr2);
    }

    public Object readResolve() {
        String[] strArr = this._names;
        return (strArr == null || strArr.length == 0) ? f4908l : this;
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sbM829Q = outline.m829Q('<');
        int length = this._types.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sbM829Q.append(',');
            }
            JavaType javaType = this._types[i];
            StringBuilder sb = new StringBuilder(40);
            javaType.mo2101m(sb);
            sbM829Q.append(sb.toString());
        }
        sbM829Q.append('>');
        return sbM829Q.toString();
    }
}
