package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import kotlin.Tuples2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.findClassInModule;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.j */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11818j extends AbstractC11815g<Tuples2<? extends ClassId, ? extends Name>> {

    /* JADX INFO: renamed from: b */
    public final ClassId f24440b;

    /* JADX INFO: renamed from: c */
    public final Name f24441c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11818j(ClassId classId, Name name) {
        super(Tuples.m10073to(classId, name));
        Intrinsics3.checkNotNullParameter(classId, "enumClassId");
        Intrinsics3.checkNotNullParameter(name, "enumEntryName");
        this.f24440b = classId;
        this.f24441c = name;
    }

    public final Name getEnumEntryName() {
        return this.f24441c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, this.f24440b);
        KotlinType4 defaultType = null;
        if (classDescriptorFindClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(classDescriptorFindClassAcrossModuleDependencies)) {
                classDescriptorFindClassAcrossModuleDependencies = null;
            }
            if (classDescriptorFindClassAcrossModuleDependencies != null) {
                defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (defaultType != null) {
            return defaultType;
        }
        StringBuilder sbM833U = outline.m833U("Containing class for error-class based enum entry ");
        sbM833U.append(this.f24440b);
        sbM833U.append('.');
        sbM833U.append(this.f24441c);
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(sbM833U.toString());
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return kotlinType4CreateErrorType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24440b.getShortClassName());
        sb.append('.');
        sb.append(this.f24441c);
        return sb.toString();
    }
}
