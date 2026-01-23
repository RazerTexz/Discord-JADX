package p007b.p225i.p408d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.d.n, reason: use source file name */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LongSerializationPolicy {

    /* JADX INFO: renamed from: j */
    public static final LongSerializationPolicy f13108j;

    /* JADX INFO: renamed from: k */
    public static final LongSerializationPolicy f13109k;

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ LongSerializationPolicy[] f13110l;

    /* JADX INFO: renamed from: b.i.d.n$a */
    /* JADX INFO: compiled from: LongSerializationPolicy.java */
    public enum a extends LongSerializationPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    /* JADX INFO: renamed from: b.i.d.n$b */
    /* JADX INFO: compiled from: LongSerializationPolicy.java */
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
