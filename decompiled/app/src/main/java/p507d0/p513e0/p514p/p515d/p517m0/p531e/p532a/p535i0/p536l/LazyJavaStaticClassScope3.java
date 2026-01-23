package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaStaticClassScope3 implements DFS.c<ClassDescriptor> {

    /* JADX INFO: renamed from: a */
    public static final LazyJavaStaticClassScope3 f23413a = new LazyJavaStaticClassScope3();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.p$a */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends Lambda implements Function1<KotlinType, ClassDescriptor> {

        /* JADX INFO: renamed from: j */
        public static final a f23414j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassDescriptor invoke(KotlinType kotlinType) {
            return invoke2(kotlinType);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ClassDescriptor invoke2(KotlinType kotlinType) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                return (ClassDescriptor) declarationDescriptor;
            }
            return null;
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.c
    public /* bridge */ /* synthetic */ Iterable<? extends ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        return getNeighbors2(classDescriptor);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<ClassDescriptor> getNeighbors2(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return _Sequences2.asIterable(_Sequences2.mapNotNull(_Collections.asSequence(supertypes), a.f23414j));
    }
}
