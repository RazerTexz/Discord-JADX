package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.i, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer4 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ JvmBuiltInsCustomizer2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer4(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KotlinType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KotlinType invoke() {
        KotlinType4 anyType = JvmBuiltInsCustomizer2.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType();
        Intrinsics3.checkNotNullExpressionValue(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
