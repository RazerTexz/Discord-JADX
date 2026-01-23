package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p579g0.StringBuilder;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.j0, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType4 extends KotlinType3 implements InterfaceC11980i, InterfaceC11981j {
    public KotlinType4() {
        super(null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public abstract KotlinType4 makeNullableAsSpecified(boolean z2);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public abstract KotlinType4 replaceAnnotations(Annotations4 annotations4);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringBuilder.append(sb, "[", DescriptorRenderer2.renderAnnotation$default(DescriptorRenderer2.f24227c, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            _Collections.joinTo$default(getArguments(), sb, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
