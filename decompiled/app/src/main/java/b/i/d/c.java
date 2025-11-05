package b.i.d;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes3.dex */
public abstract class c implements b.i.d.d {
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final /* synthetic */ c[] p;

    /* compiled from: FieldNamingPolicy.java */
    public enum a extends c {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return field.getName();
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    public enum b extends c {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return c.h(field.getName());
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$c, reason: collision with other inner class name */
    public enum C0155c extends c {
        public C0155c(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return c.h(c.g(field.getName(), " "));
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    public enum d extends c {
        public d(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return c.g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    public enum e extends c {
        public e(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return c.g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    public enum f extends c {
        public f(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.d
        public String f(Field field) {
            return c.g(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        j = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1);
        k = bVar;
        C0155c c0155c = new C0155c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        l = c0155c;
        d dVar = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
        m = dVar;
        e eVar = new e("LOWER_CASE_WITH_DASHES", 4);
        n = eVar;
        f fVar = new f("LOWER_CASE_WITH_DOTS", 5);
        o = fVar;
        p = new c[]{aVar, bVar, c0155c, dVar, eVar, fVar};
    }

    public c(String str, int i, a aVar) {
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String h(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i == 0) {
            StringBuilder sbQ = b.d.b.a.a.Q(upperCase);
            sbQ.append(str.substring(1));
            return sbQ.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) p.clone();
    }
}
