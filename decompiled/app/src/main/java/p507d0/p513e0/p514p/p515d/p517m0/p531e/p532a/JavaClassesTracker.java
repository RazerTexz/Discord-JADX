package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.t, reason: use source file name */
/* JADX INFO: compiled from: JavaClassesTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface JavaClassesTracker {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.t$a */
    /* JADX INFO: compiled from: JavaClassesTracker.kt */
    public static final class a implements JavaClassesTracker {

        /* JADX INFO: renamed from: a */
        public static final a f23521a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassesTracker
        public void reportClass(JavaClassDescriptor javaClassDescriptor) {
            Intrinsics3.checkNotNullParameter(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(JavaClassDescriptor javaClassDescriptor);
}
