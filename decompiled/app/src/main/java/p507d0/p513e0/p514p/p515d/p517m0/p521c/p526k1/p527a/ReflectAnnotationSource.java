package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.lang.annotation.Annotation;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectAnnotationSource.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectAnnotationSource implements SourceElement {

    /* renamed from: b */
    public final Annotation f23012b;

    public ReflectAnnotationSource(Annotation annotation) {
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.f23012b = annotation;
    }

    public final Annotation getAnnotation() {
        return this.f23012b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        Intrinsics3.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }
}
