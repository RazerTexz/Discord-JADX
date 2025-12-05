package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.RawType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: RawType.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.m.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class RawType2 extends KotlinType6 implements RawType3 {

    /* compiled from: RawType.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.m.g$a */
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* renamed from: j */
        public static final a f23435j = new a();

        public a() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return Intrinsics3.stringPlus("(raw) ", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
            return invoke2(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawType2(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        super(kotlinType4, kotlinType42);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
        KotlinTypeChecker.f24806a.isSubtypeOf(kotlinType4, kotlinType42);
    }

    /* renamed from: a */
    public static final List<String> m9503a(DescriptorRenderer2 descriptorRenderer2, KotlinType kotlinType) {
        List<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer2.renderTypeProjection((TypeProjection) it.next()));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static final String m9504b(String str, String str2) {
        if (!Strings4.contains$default((CharSequence) str, '<', false, 2, (Object) null)) {
            return str;
        }
        return Strings4.substringBefore$default(str, '<', (String) null, 2, (Object) null) + '<' + str2 + '>' + Strings4.substringAfterLast$default(str, '>', null, 2, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public KotlinType4 getDelegate() {
        return getLowerBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        ClassifierDescriptor declarationDescriptor = getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor == null) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Incorrect classifier: ", getConstructor().getDeclarationDescriptor()).toString());
        }
        MemberScope3 memberScope = classDescriptor.getMemberScope(RawType.f23432b);
        Intrinsics3.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
        return memberScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        String strRenderType = descriptorRenderer2.renderType(getLowerBound());
        String strRenderType2 = descriptorRenderer2.renderType(getUpperBound());
        if (descriptorRenderer4.getDebugMode()) {
            return "raw (" + strRenderType + ".." + strRenderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer2.renderFlexibleType(strRenderType, strRenderType2, TypeUtils2.getBuiltIns(this));
        }
        List<String> listM9503a = m9503a(descriptorRenderer2, getLowerBound());
        List<String> listM9503a2 = m9503a(descriptorRenderer2, getUpperBound());
        String strJoinToString$default = _Collections.joinToString$default(listM9503a, ", ", null, null, 0, null, a.f23435j, 30, null);
        List<Tuples2> listZip = _Collections.zip(listM9503a, listM9503a2);
        boolean z2 = false;
        if ((listZip instanceof Collection) && listZip.isEmpty()) {
            z2 = true;
        } else {
            for (Tuples2 tuples2 : listZip) {
                String str = (String) tuples2.getFirst();
                String str2 = (String) tuples2.getSecond();
                if (!(Intrinsics3.areEqual(str, Strings4.removePrefix(str2, "out ")) || Intrinsics3.areEqual(str2, "*"))) {
                    break;
                }
            }
            z2 = true;
        }
        if (z2) {
            strRenderType2 = m9504b(strRenderType2, strJoinToString$default);
        }
        String strM9504b = m9504b(strRenderType, strJoinToString$default);
        return Intrinsics3.areEqual(strM9504b, strRenderType2) ? strM9504b : descriptorRenderer2.renderFlexibleType(strM9504b, strRenderType2, TypeUtils2.getBuiltIns(this));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public RawType2 makeNullableAsSpecified(boolean z2) {
        return new RawType2(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public RawType2 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new RawType2(getLowerBound().replaceAnnotations(annotations4), getUpperBound().replaceAnnotations(annotations4));
    }

    public RawType2(KotlinType4 kotlinType4, KotlinType4 kotlinType42, boolean z2) {
        super(kotlinType4, kotlinType42);
        if (z2) {
            return;
        }
        KotlinTypeChecker.f24806a.isSubtypeOf(kotlinType4, kotlinType42);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public KotlinType6 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new RawType2((KotlinType4) kotlinTypeRefiner.refineType(getLowerBound()), (KotlinType4) kotlinTypeRefiner.refineType(getUpperBound()), true);
    }
}
