package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedParameter;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* compiled from: PropertyNamingStrategy.java */
/* renamed from: b.g.a.c.u, reason: use source file name */
/* loaded from: classes3.dex */
public class PropertyNamingStrategy implements Serializable {

    /* renamed from: j */
    @Deprecated
    public static final PropertyNamingStrategy f5031j = new c();

    /* renamed from: k */
    @Deprecated
    public static final PropertyNamingStrategy f5032k = new b();
    private static final long serialVersionUID = 2;

    /* compiled from: PropertyNamingStrategy.java */
    @Deprecated
    /* renamed from: b.g.a.c.u$a */
    public static abstract class a extends PropertyNamingStrategy {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* renamed from: a */
        public String mo2231a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* renamed from: b */
        public String mo2232b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* renamed from: c */
        public String mo2233c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* renamed from: d */
        public String mo2234d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return mo2235e(str);
        }

        /* renamed from: e */
        public abstract String mo2235e(String str);
    }

    /* compiled from: PropertyNamingStrategy.java */
    @Deprecated
    /* renamed from: b.g.a.c.u$b */
    public static class b extends a {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy.a
        /* renamed from: e */
        public String mo2235e(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (i2 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z2 && i > 0 && sb.charAt(i - 1) != '_') {
                            sb.append('_');
                            i++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sb.append(cCharAt);
                    i++;
                }
            }
            return i > 0 ? sb.toString() : str;
        }
    }

    /* compiled from: PropertyNamingStrategy.java */
    @Deprecated
    /* renamed from: b.g.a.c.u$c */
    public static class c extends a {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy.a
        /* renamed from: e */
        public String mo2235e(String str) {
            char cCharAt;
            char upperCase;
            if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(0, upperCase);
            return sb.toString();
        }
    }

    /* renamed from: a */
    public String mo2231a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
        return str;
    }

    /* renamed from: b */
    public String mo2232b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
        return str;
    }

    /* renamed from: c */
    public String mo2233c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }

    /* renamed from: d */
    public String mo2234d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }
}
