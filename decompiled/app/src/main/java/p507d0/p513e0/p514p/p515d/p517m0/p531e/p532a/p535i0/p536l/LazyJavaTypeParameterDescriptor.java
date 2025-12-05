package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractLazyTypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {

    /* renamed from: t */
    public final context4 f23418t;

    /* renamed from: u */
    public final InterfaceC11592y f23419u;

    /* renamed from: v */
    public final LazyJavaAnnotations f23420v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(context4 context4Var, InterfaceC11592y interfaceC11592y, int i, DeclarationDescriptor declarationDescriptor) {
        super(context4Var.getStorageManager(), declarationDescriptor, interfaceC11592y.getName(), Variance.INVARIANT, false, i, SourceElement.f23099a, context4Var.getComponents().getSupertypeLoopChecker());
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11592y, "javaTypeParameter");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        this.f23418t = context4Var;
        this.f23419u = interfaceC11592y;
        this.f23420v = new LazyJavaAnnotations(context4Var, interfaceC11592y, false, 4, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* renamed from: b */
    public List<KotlinType> mo9399b(List<? extends KotlinType> list) {
        Intrinsics3.checkNotNullParameter(list, "bounds");
        return this.f23418t.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.f23418t);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* renamed from: c */
    public void mo9400c(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeParameterDescriptor
    /* renamed from: d */
    public List<KotlinType> mo9401d() {
        Collection<javaTypes3> upperBounds = this.f23419u.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            KotlinType4 anyType = this.f23418t.getModule().getBuiltIns().getAnyType();
            Intrinsics3.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            KotlinType4 nullableAnyType = this.f23418t.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsJVM.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f23418t.getTypeResolver().transformJavaType((javaTypes3) it.next(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public /* bridge */ /* synthetic */ Annotations4 getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public LazyJavaAnnotations getAnnotations() {
        return this.f23420v;
    }
}
