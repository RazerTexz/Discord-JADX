package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.C11972a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11978g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AbstractTypeChecker.kt */
/* renamed from: d0.e0.p.d.m0.n.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractTypeChecker2 {

    /* renamed from: a */
    public static final AbstractTypeChecker2 f24752a = new AbstractTypeChecker2();

    /* renamed from: a */
    public static final boolean m10004a(AbstractTypeChecker3 abstractTypeChecker3, AbstractTypeChecker2 abstractTypeChecker2, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2, boolean z2) {
        Collection<InterfaceC11979h> collectionPossibleIntegerTypes = abstractTypeChecker3.possibleIntegerTypes(interfaceC11980i);
        if ((collectionPossibleIntegerTypes instanceof Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (InterfaceC11979h interfaceC11979h : collectionPossibleIntegerTypes) {
            if (Intrinsics3.areEqual(abstractTypeChecker3.typeConstructor(interfaceC11979h), abstractTypeChecker3.typeConstructor(interfaceC11980i2)) || (z2 && isSubtypeOf$default(abstractTypeChecker2, abstractTypeChecker3, interfaceC11980i2, interfaceC11979h, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker2 abstractTypeChecker2, AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return abstractTypeChecker2.isSubtypeOf(abstractTypeChecker3, interfaceC11979h, interfaceC11979h2, z2);
    }

    /* renamed from: b */
    public final List<InterfaceC11980i> m10005b(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        AbstractTypeChecker3.b bVarSubstitutionSupertypePolicy;
        EnumC11973b enumC11973b = EnumC11973b.FOR_SUBTYPING;
        List<InterfaceC11980i> listFastCorrespondingSupertypes = abstractTypeChecker3.fastCorrespondingSupertypes(interfaceC11980i, interfaceC11983l);
        if (listFastCorrespondingSupertypes == null) {
            if (!abstractTypeChecker3.isClassTypeConstructor(interfaceC11983l) && abstractTypeChecker3.isClassType(interfaceC11980i)) {
                return Collections2.emptyList();
            }
            if (abstractTypeChecker3.isCommonFinalClassConstructor(interfaceC11983l)) {
                if (!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(interfaceC11980i), interfaceC11983l)) {
                    return Collections2.emptyList();
                }
                InterfaceC11980i interfaceC11980iCaptureFromArguments = abstractTypeChecker3.captureFromArguments(interfaceC11980i, enumC11973b);
                if (interfaceC11980iCaptureFromArguments != null) {
                    interfaceC11980i = interfaceC11980iCaptureFromArguments;
                }
                return CollectionsJVM.listOf(interfaceC11980i);
            }
            listFastCorrespondingSupertypes = new SmartList<>();
            abstractTypeChecker3.initialize();
            ArrayDeque<InterfaceC11980i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
            Intrinsics3.checkNotNull(supertypesDeque);
            Set<InterfaceC11980i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
            Intrinsics3.checkNotNull(supertypesSet);
            supertypesDeque.push(interfaceC11980i);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbM838Z = outline.m838Z("Too many supertypes for type: ", interfaceC11980i, ". Supertypes = ");
                    sbM838Z.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbM838Z.toString().toString());
                }
                InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
                Intrinsics3.checkNotNullExpressionValue(interfaceC11980iPop, "current");
                if (supertypesSet.add(interfaceC11980iPop)) {
                    InterfaceC11980i interfaceC11980iCaptureFromArguments2 = abstractTypeChecker3.captureFromArguments(interfaceC11980iPop, enumC11973b);
                    if (interfaceC11980iCaptureFromArguments2 == null) {
                        interfaceC11980iCaptureFromArguments2 = interfaceC11980iPop;
                    }
                    if (abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(interfaceC11980iCaptureFromArguments2), interfaceC11983l)) {
                        listFastCorrespondingSupertypes.add(interfaceC11980iCaptureFromArguments2);
                        bVarSubstitutionSupertypePolicy = AbstractTypeChecker3.b.c.f24767a;
                    } else {
                        bVarSubstitutionSupertypePolicy = abstractTypeChecker3.argumentsCount(interfaceC11980iCaptureFromArguments2) == 0 ? AbstractTypeChecker3.b.C13335b.f24766a : abstractTypeChecker3.substitutionSupertypePolicy(interfaceC11980iCaptureFromArguments2);
                    }
                    if (!(!Intrinsics3.areEqual(bVarSubstitutionSupertypePolicy, AbstractTypeChecker3.b.c.f24767a))) {
                        bVarSubstitutionSupertypePolicy = null;
                    }
                    if (bVarSubstitutionSupertypePolicy != null) {
                        Iterator<InterfaceC11979h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(interfaceC11980iPop)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(bVarSubstitutionSupertypePolicy.transformType(abstractTypeChecker3, it.next()));
                        }
                    }
                }
            }
            abstractTypeChecker3.clear();
        }
        return listFastCorrespondingSupertypes;
    }

    /* renamed from: c */
    public final List<InterfaceC11980i> m10006c(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        List<InterfaceC11980i> listM10005b = m10005b(abstractTypeChecker3, interfaceC11980i, interfaceC11983l);
        if (listM10005b.size() < 2) {
            return listM10005b;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM10005b.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC11981j interfaceC11981jAsArgumentList = abstractTypeChecker3.asArgumentList((InterfaceC11980i) next);
            int size = abstractTypeChecker3.size(interfaceC11981jAsArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(abstractTypeChecker3.asFlexibleType(abstractTypeChecker3.getType(abstractTypeChecker3.get(interfaceC11981jAsArgumentList, i))) == null)) {
                    z2 = false;
                    break;
                }
                i++;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : listM10005b;
    }

    /* renamed from: d */
    public final boolean m10007d(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h) {
        return abstractTypeChecker3.isDenotable(abstractTypeChecker3.typeConstructor(interfaceC11979h)) && !abstractTypeChecker3.isDynamic(interfaceC11979h) && !abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11979h) && Intrinsics3.areEqual(abstractTypeChecker3.typeConstructor(abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979h)), abstractTypeChecker3.typeConstructor(abstractTypeChecker3.upperBoundIfFlexible(interfaceC11979h)));
    }

    public final EnumC11989r effectiveVariance(EnumC11989r enumC11989r, EnumC11989r enumC11989r2) {
        Intrinsics3.checkNotNullParameter(enumC11989r, "declared");
        Intrinsics3.checkNotNullParameter(enumC11989r2, "useSite");
        EnumC11989r enumC11989r3 = EnumC11989r.INV;
        if (enumC11989r == enumC11989r3) {
            return enumC11989r2;
        }
        if (enumC11989r2 == enumC11989r3 || enumC11989r == enumC11989r2) {
            return enumC11989r;
        }
        return null;
    }

    public final boolean equalTypes(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "a");
        Intrinsics3.checkNotNullParameter(interfaceC11979h2, "b");
        if (interfaceC11979h == interfaceC11979h2) {
            return true;
        }
        if (m10007d(abstractTypeChecker3, interfaceC11979h) && m10007d(abstractTypeChecker3, interfaceC11979h2)) {
            InterfaceC11979h interfaceC11979hRefineType = abstractTypeChecker3.refineType(interfaceC11979h);
            InterfaceC11979h interfaceC11979hRefineType2 = abstractTypeChecker3.refineType(interfaceC11979h2);
            InterfaceC11980i interfaceC11980iLowerBoundIfFlexible = abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979hRefineType);
            if (!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(interfaceC11979hRefineType), abstractTypeChecker3.typeConstructor(interfaceC11979hRefineType2))) {
                return false;
            }
            if (abstractTypeChecker3.argumentsCount(interfaceC11980iLowerBoundIfFlexible) == 0) {
                return abstractTypeChecker3.hasFlexibleNullability(interfaceC11979hRefineType) || abstractTypeChecker3.hasFlexibleNullability(interfaceC11979hRefineType2) || abstractTypeChecker3.isMarkedNullable(interfaceC11980iLowerBoundIfFlexible) == abstractTypeChecker3.isMarkedNullable(abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979hRefineType2));
            }
        }
        return isSubtypeOf$default(this, abstractTypeChecker3, interfaceC11979h, interfaceC11979h2, false, 8, null) && isSubtypeOf$default(this, abstractTypeChecker3, interfaceC11979h2, interfaceC11979h, false, 8, null);
    }

    public final List<InterfaceC11980i> findCorrespondingSupertypes(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        AbstractTypeChecker3.b bVar;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11983l, "superConstructor");
        if (abstractTypeChecker3.isClassType(interfaceC11980i)) {
            return m10006c(abstractTypeChecker3, interfaceC11980i, interfaceC11983l);
        }
        if (!abstractTypeChecker3.isClassTypeConstructor(interfaceC11983l) && !abstractTypeChecker3.isIntegerLiteralTypeConstructor(interfaceC11983l)) {
            return m10005b(abstractTypeChecker3, interfaceC11980i, interfaceC11983l);
        }
        SmartList<InterfaceC11980i> smartList = new SmartList();
        abstractTypeChecker3.initialize();
        ArrayDeque<InterfaceC11980i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
        Intrinsics3.checkNotNull(supertypesDeque);
        Set<InterfaceC11980i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
        Intrinsics3.checkNotNull(supertypesSet);
        supertypesDeque.push(interfaceC11980i);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbM838Z = outline.m838Z("Too many supertypes for type: ", interfaceC11980i, ". Supertypes = ");
                sbM838Z.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbM838Z.toString().toString());
            }
            InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
            Intrinsics3.checkNotNullExpressionValue(interfaceC11980iPop, "current");
            if (supertypesSet.add(interfaceC11980iPop)) {
                if (abstractTypeChecker3.isClassType(interfaceC11980iPop)) {
                    smartList.add(interfaceC11980iPop);
                    bVar = AbstractTypeChecker3.b.c.f24767a;
                } else {
                    bVar = AbstractTypeChecker3.b.C13335b.f24766a;
                }
                if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.f24767a))) {
                    bVar = null;
                }
                if (bVar != null) {
                    Iterator<InterfaceC11979h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(interfaceC11980iPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(bVar.transformType(abstractTypeChecker3, it.next()));
                    }
                }
            }
        }
        abstractTypeChecker3.clear();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11980i interfaceC11980i2 : smartList) {
            Intrinsics3.checkNotNullExpressionValue(interfaceC11980i2, "it");
            MutableCollections.addAll(arrayList, m10006c(abstractTypeChecker3, interfaceC11980i2, interfaceC11983l));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11981j interfaceC11981j, InterfaceC11980i interfaceC11980i) {
        boolean zIsSubtypeOf$default;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11981j, "capturedSubArguments");
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "superType");
        InterfaceC11983l interfaceC11983lTypeConstructor = abstractTypeChecker3.typeConstructor(interfaceC11980i);
        int iParametersCount = abstractTypeChecker3.parametersCount(interfaceC11983lTypeConstructor);
        if (iParametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                InterfaceC11982k argument = abstractTypeChecker3.getArgument(interfaceC11980i, i);
                if (!abstractTypeChecker3.isStarProjection(argument)) {
                    InterfaceC11979h type = abstractTypeChecker3.getType(argument);
                    InterfaceC11982k interfaceC11982k = abstractTypeChecker3.get(interfaceC11981j, i);
                    abstractTypeChecker3.getVariance(interfaceC11982k);
                    EnumC11989r enumC11989r = EnumC11989r.INV;
                    InterfaceC11979h type2 = abstractTypeChecker3.getType(interfaceC11982k);
                    EnumC11989r enumC11989rEffectiveVariance = effectiveVariance(abstractTypeChecker3.getVariance(abstractTypeChecker3.getParameter(interfaceC11983lTypeConstructor, i)), abstractTypeChecker3.getVariance(argument));
                    if (enumC11989rEffectiveVariance == null) {
                        return abstractTypeChecker3.isErrorTypeEqualsToAnything();
                    }
                    if (AbstractTypeChecker3.access$getArgumentsDepth(abstractTypeChecker3) > 100) {
                        throw new IllegalStateException(Intrinsics3.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                    AbstractTypeChecker3.access$setArgumentsDepth(abstractTypeChecker3, AbstractTypeChecker3.access$getArgumentsDepth(abstractTypeChecker3) + 1);
                    int iOrdinal = enumC11989rEffectiveVariance.ordinal();
                    if (iOrdinal == 0) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractTypeChecker3, type, type2, false, 8, null);
                    } else if (iOrdinal == 1) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractTypeChecker3, type2, type, false, 8, null);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zIsSubtypeOf$default = equalTypes(abstractTypeChecker3, type2, type);
                    }
                    AbstractTypeChecker3.access$setArgumentsDepth(abstractTypeChecker3, AbstractTypeChecker3.access$getArgumentsDepth(abstractTypeChecker3) - 1);
                    if (!zIsSubtypeOf$default) {
                        return false;
                    }
                }
                if (i2 >= iParametersCount) {
                    break;
                }
                i = i2;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0278 A[LOOP:2: B:142:0x024f->B:155:0x0278, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isSubtypeOf(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2) {
        Boolean boolValueOf;
        boolean z3;
        Boolean bool;
        boolean z4;
        boolean z5;
        InterfaceC11983l interfaceC11983l;
        InterfaceC11983l interfaceC11983l2;
        boolean z6;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(interfaceC11979h, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11979h2, "superType");
        if (interfaceC11979h == interfaceC11979h2) {
            return true;
        }
        if (!abstractTypeChecker3.customIsSubtypeOf(interfaceC11979h, interfaceC11979h2)) {
            return false;
        }
        InterfaceC11979h interfaceC11979hPrepareType = abstractTypeChecker3.prepareType(abstractTypeChecker3.refineType(interfaceC11979h));
        InterfaceC11979h interfaceC11979hPrepareType2 = abstractTypeChecker3.prepareType(abstractTypeChecker3.refineType(interfaceC11979h2));
        InterfaceC11980i interfaceC11980iLowerBoundIfFlexible = abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979hPrepareType);
        InterfaceC11980i interfaceC11980iUpperBoundIfFlexible = abstractTypeChecker3.upperBoundIfFlexible(interfaceC11979hPrepareType2);
        if (abstractTypeChecker3.isError(interfaceC11980iLowerBoundIfFlexible) || abstractTypeChecker3.isError(interfaceC11980iUpperBoundIfFlexible)) {
            boolValueOf = abstractTypeChecker3.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!abstractTypeChecker3.isMarkedNullable(interfaceC11980iLowerBoundIfFlexible) || abstractTypeChecker3.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible)) ? Boolean.valueOf(AbstractStrictEqualityTypeChecker.f24747a.strictEqualTypes(abstractTypeChecker3, abstractTypeChecker3.withNullability(interfaceC11980iLowerBoundIfFlexible, false), abstractTypeChecker3.withNullability(interfaceC11980iUpperBoundIfFlexible, false))) : Boolean.FALSE;
        } else if (abstractTypeChecker3.isStubType(interfaceC11980iLowerBoundIfFlexible) || abstractTypeChecker3.isStubType(interfaceC11980iUpperBoundIfFlexible)) {
            boolValueOf = Boolean.valueOf(abstractTypeChecker3.isStubTypeEqualsToAnything());
        } else {
            InterfaceC11975d interfaceC11975dAsDefinitelyNotNullType = abstractTypeChecker3.asDefinitelyNotNullType(interfaceC11980iUpperBoundIfFlexible);
            InterfaceC11974c interfaceC11974cAsCapturedType = abstractTypeChecker3.asCapturedType(interfaceC11975dAsDefinitelyNotNullType == null ? interfaceC11980iUpperBoundIfFlexible : abstractTypeChecker3.original(interfaceC11975dAsDefinitelyNotNullType));
            InterfaceC11979h interfaceC11979hLowerType = interfaceC11974cAsCapturedType == null ? null : abstractTypeChecker3.lowerType(interfaceC11974cAsCapturedType);
            if (interfaceC11974cAsCapturedType == null || interfaceC11979hLowerType == null) {
                InterfaceC11983l interfaceC11983lTypeConstructor = abstractTypeChecker3.typeConstructor(interfaceC11980iUpperBoundIfFlexible);
                if (abstractTypeChecker3.isIntersection(interfaceC11983lTypeConstructor)) {
                    abstractTypeChecker3.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible);
                    Collection<InterfaceC11979h> collectionSupertypes = abstractTypeChecker3.supertypes(interfaceC11983lTypeConstructor);
                    if ((collectionSupertypes instanceof Collection) && collectionSupertypes.isEmpty()) {
                        z6 = true;
                        boolValueOf = Boolean.valueOf(z6);
                    } else {
                        Iterator<T> it = collectionSupertypes.iterator();
                        while (it.hasNext()) {
                            if (!isSubtypeOf$default(this, abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible, (InterfaceC11979h) it.next(), false, 8, null)) {
                                z6 = false;
                                break;
                            }
                        }
                        z6 = true;
                        boolValueOf = Boolean.valueOf(z6);
                    }
                } else {
                    boolValueOf = null;
                }
            } else {
                if (abstractTypeChecker3.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible)) {
                    interfaceC11979hLowerType = abstractTypeChecker3.withNullability(interfaceC11979hLowerType, true);
                } else if (abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11980iUpperBoundIfFlexible)) {
                    interfaceC11979hLowerType = abstractTypeChecker3.makeDefinitelyNotNullOrNotNull(interfaceC11979hLowerType);
                }
                InterfaceC11979h interfaceC11979h3 = interfaceC11979hLowerType;
                int iOrdinal = abstractTypeChecker3.getLowerCapturedTypePolicy(interfaceC11980iLowerBoundIfFlexible, interfaceC11974cAsCapturedType).ordinal();
                if (iOrdinal == 0) {
                    boolValueOf = Boolean.valueOf(isSubtypeOf$default(this, abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible, interfaceC11979h3, false, 8, null));
                } else if (iOrdinal == 1 && isSubtypeOf$default(this, abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible, interfaceC11979h3, false, 8, null)) {
                    boolValueOf = Boolean.TRUE;
                }
            }
        }
        if (boolValueOf != null) {
            boolean zBooleanValue = boolValueOf.booleanValue();
            abstractTypeChecker3.addSubtypeConstraint(interfaceC11979hPrepareType, interfaceC11979hPrepareType2, z2);
            return zBooleanValue;
        }
        Boolean boolAddSubtypeConstraint = abstractTypeChecker3.addSubtypeConstraint(interfaceC11979hPrepareType, interfaceC11979hPrepareType2, z2);
        if (boolAddSubtypeConstraint != null) {
            return boolAddSubtypeConstraint.booleanValue();
        }
        InterfaceC11980i interfaceC11980iLowerBoundIfFlexible2 = abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11979hPrepareType);
        InterfaceC11980i interfaceC11980iUpperBoundIfFlexible2 = abstractTypeChecker3.upperBoundIfFlexible(interfaceC11979hPrepareType2);
        if (AbstractTypeChecker.f24743a.isPossibleSubtype(abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible2, interfaceC11980iUpperBoundIfFlexible2)) {
            InterfaceC11980i interfaceC11980iLowerBoundIfFlexible3 = abstractTypeChecker3.lowerBoundIfFlexible(interfaceC11980iLowerBoundIfFlexible2);
            InterfaceC11980i interfaceC11980iUpperBoundIfFlexible3 = abstractTypeChecker3.upperBoundIfFlexible(interfaceC11980iUpperBoundIfFlexible2);
            if (abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3) || abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                if (abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3) && abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                    bool = Boolean.TRUE;
                } else if (abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3)) {
                    bool = m10004a(abstractTypeChecker3, this, interfaceC11980iLowerBoundIfFlexible3, interfaceC11980iUpperBoundIfFlexible3, false) ? Boolean.TRUE : null;
                } else if (abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                    InterfaceC11983l interfaceC11983lTypeConstructor2 = abstractTypeChecker3.typeConstructor(interfaceC11980iLowerBoundIfFlexible3);
                    if (interfaceC11983lTypeConstructor2 instanceof InterfaceC11978g) {
                        Collection<InterfaceC11979h> collectionSupertypes2 = abstractTypeChecker3.supertypes(interfaceC11983lTypeConstructor2);
                        if ((collectionSupertypes2 instanceof Collection) && collectionSupertypes2.isEmpty()) {
                            z4 = false;
                            if (!z4) {
                            }
                            if (!z3) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            Iterator<T> it2 = collectionSupertypes2.iterator();
                            while (it2.hasNext()) {
                                InterfaceC11980i interfaceC11980iAsSimpleType = abstractTypeChecker3.asSimpleType((InterfaceC11979h) it2.next());
                                if (Intrinsics3.areEqual(interfaceC11980iAsSimpleType == null ? null : Boolean.valueOf(abstractTypeChecker3.isIntegerLiteralType(interfaceC11980iAsSimpleType)), Boolean.TRUE)) {
                                    z4 = true;
                                    break;
                                }
                            }
                            z4 = false;
                            z3 = !z4;
                            if (!z3 || m10004a(abstractTypeChecker3, this, interfaceC11980iUpperBoundIfFlexible3, interfaceC11980iLowerBoundIfFlexible3, true)) {
                                bool = Boolean.TRUE;
                            }
                        }
                    }
                }
                if (bool != null) {
                    boolean zBooleanValue2 = bool.booleanValue();
                    AbstractTypeChecker3.addSubtypeConstraint$default(abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible2, interfaceC11980iUpperBoundIfFlexible2, false, 4, null);
                    return zBooleanValue2;
                }
                InterfaceC11983l interfaceC11983lTypeConstructor3 = abstractTypeChecker3.typeConstructor(interfaceC11980iUpperBoundIfFlexible2);
                if ((!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(interfaceC11980iLowerBoundIfFlexible2), interfaceC11983lTypeConstructor3) || abstractTypeChecker3.parametersCount(interfaceC11983lTypeConstructor3) != 0) && !abstractTypeChecker3.isAnyConstructor(abstractTypeChecker3.typeConstructor(interfaceC11980iUpperBoundIfFlexible2))) {
                    List<InterfaceC11980i> listFindCorrespondingSupertypes = findCorrespondingSupertypes(abstractTypeChecker3, interfaceC11980iLowerBoundIfFlexible2, interfaceC11983lTypeConstructor3);
                    int size = listFindCorrespondingSupertypes.size();
                    if (size == 0) {
                        InterfaceC11983l interfaceC11983lTypeConstructor4 = abstractTypeChecker3.typeConstructor(interfaceC11980iLowerBoundIfFlexible2);
                        if (abstractTypeChecker3.isClassTypeConstructor(interfaceC11983lTypeConstructor4)) {
                            return abstractTypeChecker3.isNothingConstructor(interfaceC11983lTypeConstructor4);
                        }
                        if (!abstractTypeChecker3.isNothingConstructor(abstractTypeChecker3.typeConstructor(interfaceC11980iLowerBoundIfFlexible2))) {
                            abstractTypeChecker3.initialize();
                            ArrayDeque<InterfaceC11980i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
                            Intrinsics3.checkNotNull(supertypesDeque);
                            Set<InterfaceC11980i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
                            Intrinsics3.checkNotNull(supertypesSet);
                            supertypesDeque.push(interfaceC11980iLowerBoundIfFlexible2);
                            while (!supertypesDeque.isEmpty()) {
                                if (supertypesSet.size() > 1000) {
                                    StringBuilder sbM838Z = outline.m838Z("Too many supertypes for type: ", interfaceC11980iLowerBoundIfFlexible2, ". Supertypes = ");
                                    sbM838Z.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                                    throw new IllegalStateException(sbM838Z.toString().toString());
                                }
                                InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
                                Intrinsics3.checkNotNullExpressionValue(interfaceC11980iPop, "current");
                                if (supertypesSet.add(interfaceC11980iPop)) {
                                    AbstractTypeChecker3.b bVar = abstractTypeChecker3.isClassType(interfaceC11980iPop) ? AbstractTypeChecker3.b.c.f24767a : AbstractTypeChecker3.b.C13335b.f24766a;
                                    if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.f24767a))) {
                                        bVar = null;
                                    }
                                    if (bVar == null) {
                                        continue;
                                    } else {
                                        Iterator<InterfaceC11979h> it3 = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(interfaceC11980iPop)).iterator();
                                        while (it3.hasNext()) {
                                            InterfaceC11980i interfaceC11980iTransformType = bVar.transformType(abstractTypeChecker3, it3.next());
                                            if (abstractTypeChecker3.isNothingConstructor(abstractTypeChecker3.typeConstructor(interfaceC11980iTransformType))) {
                                                abstractTypeChecker3.clear();
                                            } else {
                                                supertypesDeque.add(interfaceC11980iTransformType);
                                            }
                                        }
                                    }
                                }
                            }
                            abstractTypeChecker3.clear();
                        }
                    } else {
                        if (size == 1) {
                            return isSubtypeForSameConstructor(abstractTypeChecker3, abstractTypeChecker3.asArgumentList((InterfaceC11980i) _Collections.first((List) listFindCorrespondingSupertypes)), interfaceC11980iUpperBoundIfFlexible2);
                        }
                        C11972a c11972a = new C11972a(abstractTypeChecker3.parametersCount(interfaceC11983lTypeConstructor3));
                        int iParametersCount = abstractTypeChecker3.parametersCount(interfaceC11983lTypeConstructor3);
                        if (iParametersCount > 0) {
                            int i = 0;
                            z5 = false;
                            while (true) {
                                int i2 = i + 1;
                                z5 = z5 || abstractTypeChecker3.getVariance(abstractTypeChecker3.getParameter(interfaceC11983lTypeConstructor3, i)) != EnumC11989r.OUT;
                                if (z5) {
                                    interfaceC11983l = interfaceC11983lTypeConstructor3;
                                } else {
                                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFindCorrespondingSupertypes, 10));
                                    for (InterfaceC11980i interfaceC11980i : listFindCorrespondingSupertypes) {
                                        InterfaceC11982k argumentOrNull = abstractTypeChecker3.getArgumentOrNull(interfaceC11980i, i);
                                        if (argumentOrNull == null) {
                                            interfaceC11983l2 = interfaceC11983lTypeConstructor3;
                                        } else {
                                            interfaceC11983l2 = interfaceC11983lTypeConstructor3;
                                            if (!(abstractTypeChecker3.getVariance(argumentOrNull) == EnumC11989r.INV)) {
                                            }
                                            if (argumentOrNull != null) {
                                                throw new IllegalStateException(("Incorrect type: " + interfaceC11980i + ", subType: " + interfaceC11980iLowerBoundIfFlexible2 + ", superType: " + interfaceC11980iUpperBoundIfFlexible2).toString());
                                            }
                                            arrayList.add(abstractTypeChecker3.getType(argumentOrNull));
                                            interfaceC11983lTypeConstructor3 = interfaceC11983l2;
                                        }
                                        argumentOrNull = null;
                                        if (argumentOrNull != null) {
                                        }
                                    }
                                    interfaceC11983l = interfaceC11983lTypeConstructor3;
                                    c11972a.add(abstractTypeChecker3.asTypeArgument(abstractTypeChecker3.intersectTypes(arrayList)));
                                }
                                if (i2 >= iParametersCount) {
                                    break;
                                }
                                interfaceC11983lTypeConstructor3 = interfaceC11983l;
                                i = i2;
                            }
                        } else {
                            z5 = false;
                        }
                        if (z5 || !isSubtypeForSameConstructor(abstractTypeChecker3, c11972a, interfaceC11980iUpperBoundIfFlexible2)) {
                            if (!listFindCorrespondingSupertypes.isEmpty()) {
                                Iterator<T> it4 = listFindCorrespondingSupertypes.iterator();
                                while (it4.hasNext()) {
                                    if (isSubtypeForSameConstructor(abstractTypeChecker3, abstractTypeChecker3.asArgumentList((InterfaceC11980i) it4.next()), interfaceC11980iUpperBoundIfFlexible2)) {
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
