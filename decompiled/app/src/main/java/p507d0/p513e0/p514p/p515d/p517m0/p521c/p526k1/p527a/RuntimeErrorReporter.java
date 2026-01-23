package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.j, reason: use source file name */
/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeErrorReporter implements ErrorReporter {

    /* JADX INFO: renamed from: b */
    public static final RuntimeErrorReporter f23021b = new RuntimeErrorReporter();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException(Intrinsics3.stringPlus("Cannot infer visibility for ", callableMemberDescriptor));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder sbM833U = outline.m833U("Incomplete hierarchy for class ");
        sbM833U.append(classDescriptor.getName());
        sbM833U.append(", unresolved classes ");
        sbM833U.append(list);
        throw new IllegalStateException(sbM833U.toString());
    }
}
