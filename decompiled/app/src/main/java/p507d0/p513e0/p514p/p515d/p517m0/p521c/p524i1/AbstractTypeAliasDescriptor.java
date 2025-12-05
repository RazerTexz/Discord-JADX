package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AbstractTypeAliasDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractTypeAliasDescriptor extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
    public final /* synthetic */ AbstractTypeAliasDescriptor2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor(AbstractTypeAliasDescriptor2 abstractTypeAliasDescriptor2) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        return invoke2(kotlinTypeRefiner);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType4 invoke2(KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor classifierDescriptorRefineDescriptor = kotlinTypeRefiner.refineDescriptor(this.this$0);
        if (classifierDescriptorRefineDescriptor == null) {
            return null;
        }
        return classifierDescriptorRefineDescriptor.getDefaultType();
    }
}
