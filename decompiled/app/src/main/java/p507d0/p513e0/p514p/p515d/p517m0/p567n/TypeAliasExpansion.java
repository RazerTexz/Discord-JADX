package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeAliasExpansion.kt */
/* renamed from: d0.e0.p.d.m0.n.r0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypeAliasExpansion {

    /* renamed from: a */
    public static final a f24866a = new a(null);

    /* renamed from: b */
    public final TypeAliasExpansion f24867b;

    /* renamed from: c */
    public final TypeAliasDescriptor f24868c;

    /* renamed from: d */
    public final List<TypeProjection> f24869d;

    /* renamed from: e */
    public final Map<TypeParameterDescriptor, TypeProjection> f24870e;

    /* compiled from: TypeAliasExpansion.kt */
    /* renamed from: d0.e0.p.d.m0.n.r0$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics3.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((TypeParameterDescriptor) it.next()).getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, Maps6.toMap(_Collections.zip(arrayList, list)), null);
        }
    }

    public TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24867b = typeAliasExpansion;
        this.f24868c = typeAliasDescriptor;
        this.f24869d = list;
        this.f24870e = map;
    }

    public final List<TypeProjection> getArguments() {
        return this.f24869d;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.f24868c;
    }

    public final TypeProjection getReplacement(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.f24870e.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics3.areEqual(this.f24868c, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.f24867b;
            if (!(typeAliasExpansion == null ? false : typeAliasExpansion.isRecursion(typeAliasDescriptor))) {
                return false;
            }
        }
        return true;
    }
}
