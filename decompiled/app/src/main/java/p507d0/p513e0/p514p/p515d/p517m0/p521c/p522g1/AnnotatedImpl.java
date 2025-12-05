package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

/* compiled from: AnnotatedImpl.java */
/* renamed from: d0.e0.p.d.m0.c.g1.b, reason: use source file name */
/* loaded from: classes3.dex */
public class AnnotatedImpl implements Annotations3 {

    /* renamed from: j */
    public final Annotations4 f22716j;

    public AnnotatedImpl(Annotations4 annotations4) {
        if (annotations4 != null) {
            this.f22716j = annotations4;
        } else {
            m9384a(0);
            throw null;
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m9384a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations4 = this.f22716j;
        if (annotations4 != null) {
            return annotations4;
        }
        m9384a(1);
        throw null;
    }
}
