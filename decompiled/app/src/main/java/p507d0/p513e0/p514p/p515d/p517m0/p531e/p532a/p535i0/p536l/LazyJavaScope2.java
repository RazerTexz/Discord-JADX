package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaScope2 extends Lambda implements Function0<AbstractC11815g<?>> {
    public final /* synthetic */ InterfaceC11581n $field;
    public final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope2(LazyJavaScope lazyJavaScope, InterfaceC11581n interfaceC11581n, PropertyDescriptorImpl propertyDescriptorImpl) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = interfaceC11581n;
        this.$propertyDescriptor = propertyDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AbstractC11815g<?> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AbstractC11815g<?> invoke() {
        return this.this$0.f23389c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
