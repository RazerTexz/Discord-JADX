package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1.CapturedTypeApproximation2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: utils.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class utils8 {
    /* renamed from: a */
    public static final String m10017a(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        m10018b(Intrinsics3.stringPlus("type: ", typeConstructor), sb);
        m10018b(Intrinsics3.stringPlus("hashCode: ", Integer.valueOf(typeConstructor.hashCode())), sb);
        m10018b(Intrinsics3.stringPlus("javaClass: ", typeConstructor.getClass().getCanonicalName()), sb);
        for (DeclarationDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor(); declarationDescriptor != null; declarationDescriptor = declarationDescriptor.getContainingDeclaration()) {
            m10018b(Intrinsics3.stringPlus("fqName: ", DescriptorRenderer2.f24226b.render(declarationDescriptor)), sb);
            m10018b(Intrinsics3.stringPlus("javaClass: ", declarationDescriptor.getClass().getCanonicalName()), sb);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: b */
    public static final StringBuilder m10018b(String str, StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        Intrinsics3.checkNotNullParameter(sb, "$this_anonymous");
        sb.append(str);
        Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
        return sb;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z2;
        Variance variance = Variance.INVARIANT;
        Intrinsics3.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics3.checkNotNullParameter(kotlinType2, "supertype");
        Intrinsics3.checkNotNullParameter(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new utils7(kotlinType, null));
        TypeConstructor constructor = kotlinType2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            utils7 utils7Var = (utils7) arrayDeque.poll();
            KotlinType type = utils7Var.getType();
            TypeConstructor constructor2 = type.getConstructor();
            TypeCheckerProcedureCallbacksImpl typeCheckerProcedureCallbacksImpl = (TypeCheckerProcedureCallbacksImpl) typeCheckingProcedureCallbacks;
            if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean zIsMarkedNullable = type.isMarkedNullable();
                for (utils7 previous = utils7Var.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if ((arguments instanceof Collection) && arguments.isEmpty()) {
                        z2 = false;
                    } else {
                        Iterator<T> it = arguments.iterator();
                        while (it.hasNext()) {
                            if (((TypeProjection) it.next()).getProjectionKind() != variance) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        KotlinType kotlinTypeSafeSubstitute = CapturedTypeConstructor4.wrapWithCapturingSubstitution$default(TypeSubstitution3.f24889b.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, variance);
                        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                        type = CapturedTypeApproximation2.approximateCapturedTypes(kotlinTypeSafeSubstitute).getUpper();
                    } else {
                        type = TypeSubstitution3.f24889b.create(type2).buildSubstitutor().safeSubstitute(type, variance);
                        Intrinsics3.checkNotNullExpressionValue(type, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    zIsMarkedNullable = zIsMarkedNullable || type2.isMarkedNullable();
                }
                TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(type, zIsMarkedNullable);
                }
                StringBuilder sbM833U = outline.m833U("Type constructors should be equals!\nsubstitutedSuperType: ");
                sbM833U.append(m10017a(constructor3));
                sbM833U.append(", \n\nsupertype: ");
                sbM833U.append(m10017a(constructor));
                sbM833U.append(" \n");
                sbM833U.append(typeCheckerProcedureCallbacksImpl.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(sbM833U.toString());
            }
            for (KotlinType kotlinType3 : constructor2.getSupertypes()) {
                Intrinsics3.checkNotNullExpressionValue(kotlinType3, "immediateSupertype");
                arrayDeque.add(new utils7(kotlinType3, utils7Var));
            }
        }
        return null;
    }
}
