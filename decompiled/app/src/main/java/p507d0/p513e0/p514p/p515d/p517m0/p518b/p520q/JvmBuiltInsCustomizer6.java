package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.k, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer6 implements DFS.c<ClassDescriptor> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ JvmBuiltInsCustomizer2 f22662a;

    public JvmBuiltInsCustomizer6(JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2) {
        this.f22662a = jvmBuiltInsCustomizer2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.c
    public /* bridge */ /* synthetic */ Iterable<? extends ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        return getNeighbors2(classDescriptor);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<ClassDescriptor> getNeighbors2(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        JvmBuiltInsCustomizer2 jvmBuiltInsCustomizer2 = this.f22662a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = ((KotlinType) it.next()).getConstructor().getDeclarationDescriptor();
            ClassifierDescriptor original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
            ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            LazyJavaClassDescriptor lazyJavaClassDescriptorAccess$getJavaAnalogue = classDescriptor2 != null ? JvmBuiltInsCustomizer2.access$getJavaAnalogue(jvmBuiltInsCustomizer2, classDescriptor2) : null;
            if (lazyJavaClassDescriptorAccess$getJavaAnalogue != null) {
                arrayList.add(lazyJavaClassDescriptorAccess$getJavaAnalogue);
            }
        }
        return arrayList;
    }
}
