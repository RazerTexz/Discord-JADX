package b.f.d.d;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: Objects.java */
/* loaded from: classes.dex */
public final class i {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final a f469b;
    public a c;

    /* compiled from: Objects.java */
    public static final class a {
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public Object f470b;
        public a c;

        public a(h hVar) {
        }
    }

    public i(String str, h hVar) {
        a aVar = new a(null);
        this.f469b = aVar;
        this.c = aVar;
        this.a = str;
    }

    public i a(String str, int i) {
        c(str, String.valueOf(i));
        return this;
    }

    public i b(String str, boolean z2) {
        c(str, String.valueOf(z2));
        return this;
    }

    public final i c(String str, Object obj) {
        a aVar = new a(null);
        this.c.c = aVar;
        this.c = aVar;
        aVar.f470b = obj;
        Objects.requireNonNull(str);
        aVar.a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        a aVar = this.f469b.c;
        String str = "";
        while (aVar != null) {
            Object obj = aVar.f470b;
            sb.append(str);
            String str2 = aVar.a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            aVar = aVar.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
