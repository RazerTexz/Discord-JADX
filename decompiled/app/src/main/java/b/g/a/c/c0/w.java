package b.g.a.c.c0;

import b.g.a.c.c0.a;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: DefaultAccessorNamingStrategy.java */
/* loaded from: classes3.dex */
public class w extends b.g.a.c.c0.a {
    public final a a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f695b;
    public final String c;
    public final String d;
    public final String e;

    /* compiled from: DefaultAccessorNamingStrategy.java */
    public interface a {
        boolean a(char c, String str, int i);
    }

    /* compiled from: DefaultAccessorNamingStrategy.java */
    public static class b extends a.AbstractC0083a implements Serializable {
        private static final long serialVersionUID = 1;
        public final String _setterPrefix = "set";
        public final String _withPrefix = "with";
        public final String _getterPrefix = "get";
        public final String _isGetterPrefix = "is";
        public final a _baseNameValidator = null;
    }

    /* compiled from: DefaultAccessorNamingStrategy.java */
    public static class c extends w {
        public final Set<String> f;

        public c(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.c cVar) {
            super(lVar, cVar, null, "get", "is", null);
            this.f = new HashSet();
            Class<?> cls = cVar.l;
            RuntimeException runtimeException = b.g.a.c.d0.a.f697b;
            if (runtimeException != null) {
                throw runtimeException;
            }
            b.g.a.c.d0.a aVar = b.g.a.c.d0.a.a;
            Objects.requireNonNull(aVar);
            try {
                Object[] objArr = (Object[]) aVar.c.invoke(cls, new Object[0]);
                int length = objArr.length;
                String[] strArr = new String[length];
                for (int i = 0; i < objArr.length; i++) {
                    try {
                        strArr[i] = (String) aVar.d.invoke(objArr[i], new Object[0]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArr.length), b.g.a.c.i0.d.u(cls)), e);
                    }
                }
                for (int i2 = 0; i2 < length; i2++) {
                    this.f.add(strArr[i2]);
                }
            } catch (Exception unused) {
                StringBuilder sbU = b.d.b.a.a.U("Failed to access RecordComponents of type ");
                sbU.append(b.g.a.c.i0.d.u(cls));
                throw new IllegalArgumentException(sbU.toString());
            }
        }

        @Override // b.g.a.c.c0.w, b.g.a.c.c0.a
        public String c(j jVar, String str) {
            return this.f.contains(str) ? str : super.c(jVar, str);
        }
    }

    public w(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.c cVar, String str, String str2, String str3, a aVar) {
        this.f695b = lVar.q(b.g.a.c.p.USE_STD_BEAN_NAMING);
        this.e = str;
        this.c = str2;
        this.d = str3;
        this.a = aVar;
    }

    @Override // b.g.a.c.c0.a
    public String a(j jVar, String str) {
        if (this.d == null) {
            return null;
        }
        Class<?> clsD = jVar.d();
        if ((clsD == Boolean.class || clsD == Boolean.TYPE) && str.startsWith(this.d)) {
            return this.f695b ? e(str, 2) : d(str, 2);
        }
        return null;
    }

    @Override // b.g.a.c.c0.a
    public String b(j jVar, String str) {
        String str2 = this.e;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f695b ? e(str, this.e.length()) : d(str, this.e.length());
    }

    @Override // b.g.a.c.c0.a
    public String c(j jVar, String str) {
        String str2 = this.c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> clsD = jVar.d();
            boolean z2 = false;
            if (clsD.isArray()) {
                String name = clsD.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && jVar.d().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.f695b ? e(str, this.c.length()) : d(str, this.c.length());
    }

    public String d(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.a;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    public String e(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.a;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i2, length);
        return sb.toString();
    }
}
