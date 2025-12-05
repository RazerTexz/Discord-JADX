package p007b.p225i.p408d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: b.i.d.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LongSerializationPolicy {

    /* renamed from: j */
    public static final LongSerializationPolicy f13108j;

    /* renamed from: k */
    public static final LongSerializationPolicy f13109k;

    /* renamed from: l */
    public static final /* synthetic */ LongSerializationPolicy[] f13110l;

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: b.i.d.n$a */
    public enum a extends LongSerializationPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: b.i.d.n$b */
    public enum b extends LongSerializationPolicy {
        public b(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f13108j = aVar;
        b bVar = new b("STRING", 1);
        f13109k = bVar;
        f13110l = new LongSerializationPolicy[]{aVar, bVar};
    }

    public LongSerializationPolicy(String str, int i, a aVar) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f13110l.clone();
    }
}
