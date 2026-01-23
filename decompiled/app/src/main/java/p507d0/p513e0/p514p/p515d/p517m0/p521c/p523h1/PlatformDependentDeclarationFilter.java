package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c, reason: use source file name */
/* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PlatformDependentDeclarationFilter {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c$a */
    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class a implements PlatformDependentDeclarationFilter {

        /* JADX INFO: renamed from: a */
        public static final a f22797a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c$b */
    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class b implements PlatformDependentDeclarationFilter {

        /* JADX INFO: renamed from: a */
        public static final b f22798a = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
            return !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilter2.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor);
}
