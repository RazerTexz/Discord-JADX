package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.util.ArrayList;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p580t.ReversedViews3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.b, reason: use source file name */
/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassifierNamePolicy {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$a */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class a implements ClassifierNamePolicy {

        /* JADX INFO: renamed from: a */
        public static final a f24222a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer2.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return descriptorRenderer2.renderFqName(fqName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$b */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class b implements ClassifierNamePolicy {

        /* JADX INFO: renamed from: a */
        public static final b f24223a = new b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [d0.e0.p.d.m0.c.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [d0.e0.p.d.m0.c.m] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer2.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(classifierDescriptor.getName());
                classifierDescriptor = classifierDescriptor.getContainingDeclaration();
            } while (classifierDescriptor instanceof ClassDescriptor);
            return RenderingUtils.renderFqName(ReversedViews3.asReversedMutable(arrayList));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$c */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class c implements ClassifierNamePolicy {

        /* JADX INFO: renamed from: a */
        public static final c f24224a = new c();

        /* JADX INFO: renamed from: a */
        public final String m9869a(ClassifierDescriptor classifierDescriptor) {
            String strRender;
            Name name = classifierDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "descriptor.name");
            String strRender2 = RenderingUtils.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return strRender2;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                strRender = m9869a((ClassifierDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) containingDeclaration).getFqName().toUnsafe();
                Intrinsics3.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                strRender = RenderingUtils.render(unsafe);
            } else {
                strRender = null;
            }
            if (strRender == null || Intrinsics3.areEqual(strRender, "")) {
                return strRender2;
            }
            return ((Object) strRender) + '.' + strRender2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2) {
            Intrinsics3.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
            return m9869a(classifierDescriptor);
        }
    }

    String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer2 descriptorRenderer2);
}
