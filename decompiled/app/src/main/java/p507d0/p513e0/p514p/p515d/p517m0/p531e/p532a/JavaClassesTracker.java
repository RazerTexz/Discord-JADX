package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaClassDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaClassesTracker.kt */
/* renamed from: d0.e0.p.d.m0.e.a.t, reason: use source file name */
/* loaded from: classes3.dex */
public interface JavaClassesTracker {

    /* compiled from: JavaClassesTracker.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.t$a */
    public static final class a implements JavaClassesTracker {

        /* renamed from: a */
        public static final a f23521a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassesTracker
        public void reportClass(JavaClassDescriptor javaClassDescriptor) {
            Intrinsics3.checkNotNullParameter(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(JavaClassDescriptor javaClassDescriptor);
}
