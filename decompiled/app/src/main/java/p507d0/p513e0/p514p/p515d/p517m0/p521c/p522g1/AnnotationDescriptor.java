package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AnnotationDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.g1.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface AnnotationDescriptor {

    /* compiled from: AnnotationDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.c.g1.c$a */
    public static final class a {
        public static FqName getFqName(AnnotationDescriptor annotationDescriptor) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "this");
            ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
            if (annotationClass == null) {
                return null;
            }
            if (ErrorUtils.isError(annotationClass)) {
                annotationClass = null;
            }
            if (annotationClass == null) {
                return null;
            }
            return DescriptorUtils2.fqNameOrNull(annotationClass);
        }
    }

    Map<Name, AbstractC11815g<?>> getAllValueArguments();

    FqName getFqName();

    SourceElement getSource();

    KotlinType getType();
}
