package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModuleDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.c0, reason: use source file name */
/* loaded from: classes3.dex */
public interface ModuleDescriptor2 extends DeclarationDescriptor {

    /* compiled from: ModuleDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.c.c0$a */
    public static final class a {
        public static <R, D> R accept(ModuleDescriptor2 moduleDescriptor2, DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "this");
            Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
            return declarationDescriptorVisitor.visitModuleDeclaration(moduleDescriptor2, d);
        }

        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "this");
            return null;
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> moduleCapability);

    List<ModuleDescriptor2> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1);

    boolean shouldSeeInternalsOf(ModuleDescriptor2 moduleDescriptor2);
}
