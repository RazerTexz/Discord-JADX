package d0.e0.p.d.m0.l.b;

import java.util.List;

/* compiled from: ErrorReporter.java */
/* loaded from: classes3.dex */
public interface p {
    public static final p a = new a();

    /* compiled from: ErrorReporter.java */
    public static class a implements p {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.l.b.p
        public void reportCannotInferVisibility(d0.e0.p.d.m0.c.b bVar) {
            if (bVar != null) {
                return;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.l.b.p
        public void reportIncompleteHierarchy(d0.e0.p.d.m0.c.e eVar, List<String> list) {
            if (eVar == null) {
                a(0);
                throw null;
            }
            if (list != null) {
                return;
            }
            a(1);
            throw null;
        }
    }

    void reportCannotInferVisibility(d0.e0.p.d.m0.c.b bVar);

    void reportIncompleteHierarchy(d0.e0.p.d.m0.c.e eVar, List<String> list);
}
