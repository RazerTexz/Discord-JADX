package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.EmptyPackageFragmentDesciptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.MutableClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.l, reason: use source file name */
/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class suspendFunctionTypes {

    /* JADX INFO: renamed from: a */
    public static final MutableClassDescriptor f22572a;

    /* JADX INFO: renamed from: b */
    public static final MutableClassDescriptor f22573b;

    static {
        ModuleDescriptor2 errorModule = ErrorUtils.getErrorModule();
        Intrinsics3.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        EmptyPackageFragmentDesciptor emptyPackageFragmentDesciptor = new EmptyPackageFragmentDesciptor(errorModule, StandardNames.f22492e);
        ClassKind classKind = ClassKind.INTERFACE;
        Name nameShortName = StandardNames.f22493f.shortName();
        SourceElement sourceElement = SourceElement.f23099a;
        StorageManager storageManager = LockBasedStorageManager.f24710b;
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(emptyPackageFragmentDesciptor, classKind, false, false, nameShortName, sourceElement, storageManager);
        Modality modality = Modality.ABSTRACT;
        mutableClassDescriptor.setModality(modality);
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23087e;
        mutableClassDescriptor.setVisibility(descriptorVisibility2);
        Annotations4.a aVar = Annotations4.f22735f;
        Annotations4 empty = aVar.getEMPTY();
        Variance variance = Variance.IN_VARIANCE;
        mutableClassDescriptor.setTypeParameterDescriptors(CollectionsJVM.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, empty, false, variance, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, storageManager)));
        mutableClassDescriptor.createTypeConstructor();
        f22572a = mutableClassDescriptor;
        ModuleDescriptor2 errorModule2 = ErrorUtils.getErrorModule();
        Intrinsics3.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor2 = new MutableClassDescriptor(new EmptyPackageFragmentDesciptor(errorModule2, StandardNames.f22491d), classKind, false, false, StandardNames.f22494g.shortName(), sourceElement, storageManager);
        mutableClassDescriptor2.setModality(modality);
        mutableClassDescriptor2.setVisibility(descriptorVisibility2);
        mutableClassDescriptor2.setTypeParameterDescriptors(CollectionsJVM.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor2, aVar.getEMPTY(), false, variance, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, storageManager)));
        mutableClassDescriptor2.createTypeConstructor();
        f22573b = mutableClassDescriptor2;
    }

    public static final boolean isContinuation(FqName fqName, boolean z2) {
        return z2 ? Intrinsics3.areEqual(fqName, StandardNames.f22494g) : Intrinsics3.areEqual(fqName, StandardNames.f22493f);
    }

    public static final KotlinType4 transformSuspendFunctionToRuntimeFunctionType(KotlinType kotlinType, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "suspendFunType");
        functionTypes.isSuspendFunctionType(kotlinType);
        KotlinBuiltIns builtIns = TypeUtils2.getBuiltIns(kotlinType);
        Annotations4 annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(kotlinType);
        List<TypeProjection> valueParameterTypesFromFunctionType = functionTypes.getValueParameterTypesFromFunctionType(kotlinType);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        Iterator<T> it = valueParameterTypesFromFunctionType.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeProjection) it.next()).getType());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        Annotations4 empty = Annotations4.f22735f.getEMPTY();
        TypeConstructor typeConstructor = z2 ? f22573b.getTypeConstructor() : f22572a.getTypeConstructor();
        Intrinsics3.checkNotNullExpressionValue(typeConstructor, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        List listPlus = _Collections.plus((Collection<? extends KotlinType4>) arrayList, KotlinTypeFactory.simpleType$default(empty, typeConstructor, CollectionsJVM.listOf(TypeUtils2.asTypeProjection(functionTypes.getReturnTypeFromFunctionType(kotlinType))), false, null, 16, null));
        KotlinType4 nullableAnyType = TypeUtils2.getBuiltIns(kotlinType).getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return functionTypes.createFunctionType$default(builtIns, annotations, receiverTypeFromFunctionType, listPlus, null, nullableAnyType, false, 64, null).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }
}
