package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;

/* compiled from: ErrorReporter.java */
/* renamed from: d0.e0.p.d.m0.l.b.p, reason: use source file name */
/* loaded from: classes3.dex */
public interface ErrorReporter {

    /* renamed from: a */
    public static final ErrorReporter f24676a = new a();

    /* compiled from: ErrorReporter.java */
    /* renamed from: d0.e0.p.d.m0.l.b.p$a */
    public static class a implements ErrorReporter {
        /* renamed from: a */
        public static /* synthetic */ void m9967a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter
        public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor != null) {
                return;
            }
            m9967a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter
        public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
            if (classDescriptor == null) {
                m9967a(0);
                throw null;
            }
            if (list != null) {
                return;
            }
            m9967a(1);
            throw null;
        }
    }

    void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor);

    void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list);
}
