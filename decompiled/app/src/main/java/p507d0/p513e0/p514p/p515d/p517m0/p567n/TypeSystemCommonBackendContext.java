package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TypeSystemCommonBackendContext.kt */
/* renamed from: d0.e0.p.d.m0.n.d1, reason: use source file name */
/* loaded from: classes3.dex */
public interface TypeSystemCommonBackendContext extends InterfaceC11985n {

    /* compiled from: TypeSystemCommonBackendContext.kt */
    /* renamed from: d0.e0.p.d.m0.n.d1$a */
    public static final class a {
        public static InterfaceC11979h makeNullable(TypeSystemCommonBackendContext typeSystemCommonBackendContext, InterfaceC11979h interfaceC11979h) {
            Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "this");
            Intrinsics3.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11980i interfaceC11980iAsSimpleType = typeSystemCommonBackendContext.asSimpleType(interfaceC11979h);
            return interfaceC11980iAsSimpleType == null ? interfaceC11979h : typeSystemCommonBackendContext.withNullability(interfaceC11980iAsSimpleType, true);
        }
    }

    FqNameUnsafe getClassFqNameUnsafe(InterfaceC11983l interfaceC11983l);

    PrimitiveType getPrimitiveArrayType(InterfaceC11983l interfaceC11983l);

    PrimitiveType getPrimitiveType(InterfaceC11983l interfaceC11983l);

    InterfaceC11979h getRepresentativeUpperBound(InterfaceC11984m interfaceC11984m);

    InterfaceC11979h getSubstitutedUnderlyingType(InterfaceC11979h interfaceC11979h);

    InterfaceC11984m getTypeParameterClassifier(InterfaceC11983l interfaceC11983l);

    boolean hasAnnotation(InterfaceC11979h interfaceC11979h, FqName fqName);

    boolean isInlineClass(InterfaceC11983l interfaceC11983l);

    boolean isUnderKotlinPackage(InterfaceC11983l interfaceC11983l);

    InterfaceC11979h makeNullable(InterfaceC11979h interfaceC11979h);
}
