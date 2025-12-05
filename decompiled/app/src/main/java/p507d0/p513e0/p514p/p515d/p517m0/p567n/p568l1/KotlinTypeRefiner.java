package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KotlinTypeRefiner.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KotlinTypeRefiner {

    /* compiled from: KotlinTypeRefiner.kt */
    /* renamed from: d0.e0.p.d.m0.n.l1.g$a */
    public static final class a extends KotlinTypeRefiner {

        /* renamed from: a */
        public static final a f24807a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public <S extends MemberScope3> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics3.checkNotNullParameter(function0, "compute");
            return function0.invoke();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            return refineDescriptor(declarationDescriptor);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics3.checkNotNullExpressionValue(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner
        public KotlinType refineType(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "type");
            return kotlinType;
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId classId);

    public abstract <S extends MemberScope3> S getOrPutScopeForClass(ClassDescriptor classDescriptor, Function0<? extends S> function0);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor2 moduleDescriptor2);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor typeConstructor);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor classDescriptor);

    public abstract KotlinType refineType(KotlinType kotlinType);
}
