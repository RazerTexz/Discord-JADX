package p007b.p225i.p408d;

import java.lang.reflect.Field;
import java.util.Locale;
import p007b.p100d.p104b.p105a.outline;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: b.i.d.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {

    /* renamed from: j */
    public static final FieldNamingPolicy f13088j;

    /* renamed from: k */
    public static final FieldNamingPolicy f13089k;

    /* renamed from: l */
    public static final FieldNamingPolicy f13090l;

    /* renamed from: m */
    public static final FieldNamingPolicy f13091m;

    /* renamed from: n */
    public static final FieldNamingPolicy f13092n;

    /* renamed from: o */
    public static final FieldNamingPolicy f13093o;

    /* renamed from: p */
    public static final /* synthetic */ FieldNamingPolicy[] f13094p;

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$a */
    public enum a extends FieldNamingPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return field.getName();
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$b */
    public enum b extends FieldNamingPolicy {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return FieldNamingPolicy.m6849h(field.getName());
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$c */
    public enum c extends FieldNamingPolicy {
        public c(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return FieldNamingPolicy.m6849h(FieldNamingPolicy.m6848g(field.getName(), " "));
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$d */
    public enum d extends FieldNamingPolicy {
        public d(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return FieldNamingPolicy.m6848g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$e */
    public enum e extends FieldNamingPolicy {
        public e(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return FieldNamingPolicy.m6848g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$f */
    public enum f extends FieldNamingPolicy {
        public f(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.FieldNamingStrategy
        /* renamed from: f */
        public String mo6850f(Field field) {
            return FieldNamingPolicy.m6848g(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f13088j = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1);
        f13089k = bVar;
        c cVar = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        f13090l = cVar;
        d dVar = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
        f13091m = dVar;
        e eVar = new e("LOWER_CASE_WITH_DASHES", 4);
        f13092n = eVar;
        f fVar = new f("LOWER_CASE_WITH_DOTS", 5);
        f13093o = fVar;
        f13094p = new FieldNamingPolicy[]{aVar, bVar, cVar, dVar, eVar, fVar};
    }

    public FieldNamingPolicy(String str, int i, a aVar) {
    }

    /* renamed from: g */
    public static String m6848g(String str, String str2) {
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

    /* renamed from: h */
    public static String m6849h(String str) {
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
            StringBuilder sbM829Q = outline.m829Q(upperCase);
            sbM829Q.append(str.substring(1));
            return sbM829Q.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f13094p.clone();
    }
}
