package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;
import p600f0.HttpUrl;

/* compiled from: RequestFactory.java */
/* renamed from: i0.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class RequestFactory {

    /* renamed from: a */
    public final Method f26633a;

    /* renamed from: b */
    public final HttpUrl f26634b;

    /* renamed from: c */
    public final String f26635c;

    /* renamed from: d */
    public final String f26636d;

    /* renamed from: e */
    public final Headers f26637e;

    /* renamed from: f */
    public final MediaType f26638f;

    /* renamed from: g */
    public final boolean f26639g;

    /* renamed from: h */
    public final boolean f26640h;

    /* renamed from: i */
    public final boolean f26641i;

    /* renamed from: j */
    public final ParameterHandler3<?>[] f26642j;

    /* renamed from: k */
    public final boolean f26643k;

    /* compiled from: RequestFactory.java */
    /* renamed from: i0.w$a */
    public static final class a {

        /* renamed from: a */
        public static final Pattern f26644a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: b */
        public static final Pattern f26645b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: c */
        public final Retrofit2 f26646c;

        /* renamed from: d */
        public final Method f26647d;

        /* renamed from: e */
        public final Annotation[] f26648e;

        /* renamed from: f */
        public final Annotation[][] f26649f;

        /* renamed from: g */
        public final Type[] f26650g;

        /* renamed from: h */
        public boolean f26651h;

        /* renamed from: i */
        public boolean f26652i;

        /* renamed from: j */
        public boolean f26653j;

        /* renamed from: k */
        public boolean f26654k;

        /* renamed from: l */
        public boolean f26655l;

        /* renamed from: m */
        public boolean f26656m;

        /* renamed from: n */
        public boolean f26657n;

        /* renamed from: o */
        public boolean f26658o;

        /* renamed from: p */
        public String f26659p;

        /* renamed from: q */
        public boolean f26660q;

        /* renamed from: r */
        public boolean f26661r;

        /* renamed from: s */
        public boolean f26662s;

        /* renamed from: t */
        public String f26663t;

        /* renamed from: u */
        public Headers f26664u;

        /* renamed from: v */
        public MediaType f26665v;

        /* renamed from: w */
        public Set<String> f26666w;

        /* renamed from: x */
        public ParameterHandler3<?>[] f26667x;

        /* renamed from: y */
        public boolean f26668y;

        public a(Retrofit2 retrofit22, Method method) {
            this.f26646c = retrofit22;
            this.f26647d = method;
            this.f26648e = method.getAnnotations();
            this.f26650g = method.getGenericParameterTypes();
            this.f26649f = method.getParameterAnnotations();
        }

        /* renamed from: a */
        public static Class<?> m10722a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        /* renamed from: b */
        public final void m10723b(String str, String str2, boolean z2) {
            String str3 = this.f26659p;
            if (str3 != null) {
                throw Utils8.m10690j(this.f26647d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f26659p = str;
            this.f26660q = z2;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f26644a.matcher(strSubstring).find()) {
                    throw Utils8.m10690j(this.f26647d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f26663t = str2;
            Matcher matcher = f26644a.matcher(str2);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            this.f26666w = linkedHashSet;
        }

        /* renamed from: c */
        public final void m10724c(int i, Type type) {
            if (Utils8.m10688h(type)) {
                throw Utils8.m10692l(this.f26647d, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public RequestFactory(a aVar) {
        this.f26633a = aVar.f26647d;
        this.f26634b = aVar.f26646c.f26675c;
        this.f26635c = aVar.f26659p;
        this.f26636d = aVar.f26663t;
        this.f26637e = aVar.f26664u;
        this.f26638f = aVar.f26665v;
        this.f26639g = aVar.f26660q;
        this.f26640h = aVar.f26661r;
        this.f26641i = aVar.f26662s;
        this.f26642j = aVar.f26667x;
        this.f26643k = aVar.f26668y;
    }
}
