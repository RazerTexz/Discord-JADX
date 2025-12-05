package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AbstractTypeChecker.kt */
/* renamed from: d0.e0.p.d.m0.n.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractTypeChecker {

    /* renamed from: a */
    public static final AbstractTypeChecker f24743a = new AbstractTypeChecker();

    /* renamed from: a */
    public final boolean m9997a(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        if (abstractTypeChecker3.isNothing(interfaceC11980i)) {
            return true;
        }
        if (abstractTypeChecker3.isMarkedNullable(interfaceC11980i)) {
            return false;
        }
        if (abstractTypeChecker3.isStubTypeEqualsToAnything() && abstractTypeChecker3.isStubType(interfaceC11980i)) {
            return true;
        }
        return abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(interfaceC11980i), interfaceC11983l);
    }

    public final boolean hasNotNullSupertype(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, AbstractTypeChecker3.b bVar) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "type");
        Intrinsics3.checkNotNullParameter(bVar, "supertypesPolicy");
        if (!((abstractTypeChecker3.isClassType(interfaceC11980i) && !abstractTypeChecker3.isMarkedNullable(interfaceC11980i)) || abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11980i))) {
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
                    AbstractTypeChecker3.b bVar2 = abstractTypeChecker3.isMarkedNullable(interfaceC11980iPop) ? AbstractTypeChecker3.b.c.f24767a : bVar;
                    if (!(!Intrinsics3.areEqual(bVar2, AbstractTypeChecker3.b.c.f24767a))) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        continue;
                    } else {
                        Iterator<InterfaceC11979h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(interfaceC11980iPop)).iterator();
                        while (it.hasNext()) {
                            InterfaceC11980i interfaceC11980iTransformType = bVar2.transformType(abstractTypeChecker3, it.next());
                            if ((abstractTypeChecker3.isClassType(interfaceC11980iTransformType) && !abstractTypeChecker3.isMarkedNullable(interfaceC11980iTransformType)) || abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11980iTransformType)) {
                                abstractTypeChecker3.clear();
                            } else {
                                supertypesDeque.add(interfaceC11980iTransformType);
                            }
                        }
                    }
                }
            }
            abstractTypeChecker3.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "start");
        Intrinsics3.checkNotNullParameter(interfaceC11983l, "end");
        if (m9997a(abstractTypeChecker3, interfaceC11980i, interfaceC11983l)) {
            return true;
        }
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
                AbstractTypeChecker3.b bVar = abstractTypeChecker3.isMarkedNullable(interfaceC11980iPop) ? AbstractTypeChecker3.b.c.f24767a : AbstractTypeChecker3.b.C13335b.f24766a;
                if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.f24767a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator<InterfaceC11979h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(interfaceC11980iPop)).iterator();
                    while (it.hasNext()) {
                        InterfaceC11980i interfaceC11980iTransformType = bVar.transformType(abstractTypeChecker3, it.next());
                        if (m9997a(abstractTypeChecker3, interfaceC11980iTransformType, interfaceC11983l)) {
                            abstractTypeChecker3.clear();
                            return true;
                        }
                        supertypesDeque.add(interfaceC11980iTransformType);
                    }
                }
            }
        }
        abstractTypeChecker3.clear();
        return false;
    }

    public final boolean isPossibleSubtype(AbstractTypeChecker3 abstractTypeChecker3, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(interfaceC11980i, "subType");
        Intrinsics3.checkNotNullParameter(interfaceC11980i2, "superType");
        if (abstractTypeChecker3.isMarkedNullable(interfaceC11980i2) || abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11980i)) {
            return true;
        }
        if (((interfaceC11980i instanceof InterfaceC11974c) && abstractTypeChecker3.isProjectionNotNull((InterfaceC11974c) interfaceC11980i)) || hasNotNullSupertype(abstractTypeChecker3, interfaceC11980i, AbstractTypeChecker3.b.C13335b.f24766a)) {
            return true;
        }
        if (abstractTypeChecker3.isDefinitelyNotNullType(interfaceC11980i2) || hasNotNullSupertype(abstractTypeChecker3, interfaceC11980i2, AbstractTypeChecker3.b.d.f24768a) || abstractTypeChecker3.isClassType(interfaceC11980i)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(abstractTypeChecker3, interfaceC11980i, abstractTypeChecker3.typeConstructor(interfaceC11980i2));
    }
}
