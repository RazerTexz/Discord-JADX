package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UnsignedType.kt */
/* renamed from: d0.e0.p.d.m0.b.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class UnsignedType3 {

    /* renamed from: a */
    public static final UnsignedType3 f22584a = new UnsignedType3();

    /* renamed from: b */
    public static final Set<Name> f22585b;

    /* renamed from: c */
    public static final HashMap<ClassId, ClassId> f22586c;

    /* renamed from: d */
    public static final HashMap<ClassId, ClassId> f22587d;

    /* renamed from: e */
    public static final Set<Name> f22588e;

    static {
        UnsignedType2[] unsignedType2ArrValues = UnsignedType2.values();
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(unsignedType2ArrValues[i2].getTypeName());
        }
        f22585b = _Collections.toSet(arrayList);
        UnsignedType[] unsignedTypeArrValues = UnsignedType.values();
        ArrayList arrayList2 = new ArrayList(4);
        for (int i3 = 0; i3 < 4; i3++) {
            arrayList2.add(unsignedTypeArrValues[i3].getTypeName());
        }
        _Collections.toSet(arrayList2);
        f22586c = new HashMap<>();
        f22587d = new HashMap<>();
        Maps6.hashMapOf(Tuples.m10073to(UnsignedType.f22574j, Name.identifier("ubyteArrayOf")), Tuples.m10073to(UnsignedType.f22575k, Name.identifier("ushortArrayOf")), Tuples.m10073to(UnsignedType.f22576l, Name.identifier("uintArrayOf")), Tuples.m10073to(UnsignedType.f22577m, Name.identifier("ulongArrayOf")));
        UnsignedType2[] unsignedType2ArrValues2 = UnsignedType2.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i4 = 0; i4 < 4; i4++) {
            linkedHashSet.add(unsignedType2ArrValues2[i4].getArrayClassId().getShortClassName());
        }
        f22588e = linkedHashSet;
        UnsignedType2[] unsignedType2ArrValues3 = UnsignedType2.values();
        while (i < 4) {
            UnsignedType2 unsignedType2 = unsignedType2ArrValues3[i];
            i++;
            f22586c.put(unsignedType2.getArrayClassId(), unsignedType2.getClassId());
            f22587d.put(unsignedType2.getClassId(), unsignedType2.getArrayClassId());
        }
    }

    public static final boolean isUnsignedType(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        if (TypeUtils.noExpectedType(kotlinType) || (declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor()) == null) {
            return false;
        }
        return f22584a.isUnsignedClass(declarationDescriptor);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "arrayClassId");
        return f22586c.get(classId);
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return f22588e.contains(name);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics3.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), StandardNames.f22499l) && f22585b.contains(declarationDescriptor.getName());
    }
}
