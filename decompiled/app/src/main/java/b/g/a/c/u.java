package b.g.a.c;

import java.io.Serializable;

/* compiled from: PropertyNamingStrategy.java */
/* loaded from: classes3.dex */
public class u implements Serializable {

    @Deprecated
    public static final u j = new c();

    @Deprecated
    public static final u k = new b();
    private static final long serialVersionUID = 2;

    /* compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static abstract class a extends u {
        @Override // b.g.a.c.u
        public String a(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.m mVar, String str) {
            return e(str);
        }

        @Override // b.g.a.c.u
        public String b(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.g gVar, String str) {
            return e(str);
        }

        @Override // b.g.a.c.u
        public String c(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.j jVar, String str) {
            return e(str);
        }

        @Override // b.g.a.c.u
        public String d(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.j jVar, String str) {
            return e(str);
        }

        public abstract String e(String str);
    }

    /* compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class b extends a {
        @Override // b.g.a.c.u.a
        public String e(String str) {
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
    public static class c extends a {
        @Override // b.g.a.c.u.a
        public String e(String str) {
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

    public String a(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.m mVar, String str) {
        return str;
    }

    public String b(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.g gVar, String str) {
        return str;
    }

    public String c(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.j jVar, String str) {
        return str;
    }

    public String d(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.j jVar, String str) {
        return str;
    }
}
