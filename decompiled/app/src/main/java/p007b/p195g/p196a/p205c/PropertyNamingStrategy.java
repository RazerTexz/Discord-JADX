package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedParameter;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.u, reason: use source file name */
/* JADX INFO: compiled from: PropertyNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyNamingStrategy implements Serializable {

    /* JADX INFO: renamed from: j */
    @Deprecated
    public static final PropertyNamingStrategy f5031j = new c();

    /* JADX INFO: renamed from: k */
    @Deprecated
    public static final PropertyNamingStrategy f5032k = new b();
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: b.g.a.c.u$a */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static abstract class a extends PropertyNamingStrategy {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* JADX INFO: renamed from: a */
        public String mo2231a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* JADX INFO: renamed from: b */
        public String mo2232b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* JADX INFO: renamed from: c */
        public String mo2233c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return mo2235e(str);
        }

        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy
        /* JADX INFO: renamed from: d */
        public String mo2234d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return mo2235e(str);
        }

        /* JADX INFO: renamed from: e */
        public abstract String mo2235e(String str);
    }

    /* JADX INFO: renamed from: b.g.a.c.u$b */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class b extends a {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy.a
        /* JADX INFO: renamed from: e */
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

    /* JADX INFO: renamed from: b.g.a.c.u$c */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class c extends a {
        @Override // p007b.p195g.p196a.p205c.PropertyNamingStrategy.a
        /* JADX INFO: renamed from: e */
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

    /* JADX INFO: renamed from: a */
    public String mo2231a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
        return str;
    }

    /* JADX INFO: renamed from: b */
    public String mo2232b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
        return str;
    }

    /* JADX INFO: renamed from: c */
    public String mo2233c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }

    /* JADX INFO: renamed from: d */
    public String mo2234d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }
}
