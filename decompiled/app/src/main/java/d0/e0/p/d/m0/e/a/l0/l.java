package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.a;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.b0;
import d0.e0.p.d.m0.e.a.c;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.y;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
public final class l {
    public final d0.e0.p.d.m0.e.a.c a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.p.e f3348b;
    public final d0.e0.p.d.m0.e.a.l0.d c;

    /* compiled from: signatureEnhancement.kt */
    public static class a {
        public final c0 a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3349b;
        public final boolean c;

        public a(c0 c0Var, boolean z2, boolean z3) {
            d0.z.d.m.checkNotNullParameter(c0Var, "type");
            this.a = c0Var;
            this.f3349b = z2;
            this.c = z3;
        }

        public final boolean getContainsFunctionN() {
            return this.c;
        }

        public final c0 getType() {
            return this.a;
        }

        public final boolean getWereChanges() {
            return this.f3349b;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    public static final class c extends a {
        public final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c0 c0Var, boolean z2, boolean z3, boolean z4) {
            super(c0Var, z3, z4);
            d0.z.d.m.checkNotNullParameter(c0Var, "type");
            this.d = z2;
        }

        public final boolean getHasDefaultValue() {
            return this.d;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    public static final class d extends d0.z.d.o implements Function1<i1, Boolean> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
            return Boolean.valueOf(invoke2(i1Var));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(i1 i1Var) {
            d0.z.d.m.checkNotNullParameter(i1Var, "it");
            return i1Var instanceof i0;
        }
    }

    public l(d0.e0.p.d.m0.e.a.c cVar, d0.e0.p.d.m0.p.e eVar, d0.e0.p.d.m0.e.a.l0.d dVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "annotationTypeQualifierResolver");
        d0.z.d.m.checkNotNullParameter(eVar, "javaTypeEnhancementState");
        d0.z.d.m.checkNotNullParameter(dVar, "typeEnhancement");
        this.a = cVar;
        this.f3348b = eVar;
        this.c = dVar;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.c access$getAnnotationTypeQualifierResolver$p(l lVar) {
        return lVar.a;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.l0.d access$getTypeEnhancement$p(l lVar) {
        return lVar.c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final i a(d0.e0.p.d.m0.c.g1.c cVar, boolean z2, boolean z3) {
        i iVar;
        i iVar2;
        i iVar3;
        h hVar = h.FORCE_FLEXIBILITY;
        h hVar2 = h.NULLABLE;
        d0.e0.p.d.m0.g.b fqName = cVar.getFqName();
        if (fqName == null) {
            return null;
        }
        boolean z4 = (cVar instanceof d0.e0.p.d.m0.e.a.i0.l.e) && (((d0.e0.p.d.m0.e.a.i0.l.e) cVar).isFreshlySupportedTypeUseAnnotation() || z3) && !z2;
        if (this.f3348b.getJspecifyReportLevel() != d0.e0.p.d.m0.p.h.IGNORE) {
            boolean z5 = this.f3348b.getJspecifyReportLevel() == d0.e0.p.d.m0.p.h.WARN;
            iVar = d0.z.d.m.areEqual(fqName, b0.getJSPECIFY_NULLABLE()) ? new i(hVar2, z5) : d0.z.d.m.areEqual(fqName, b0.getJSPECIFY_NULLNESS_UNKNOWN()) ? new i(hVar, z5) : null;
        }
        if (iVar == null) {
            h hVar3 = h.NOT_NULL;
            if (b0.getNULLABLE_ANNOTATIONS().contains(fqName)) {
                iVar = new i(hVar2, z4);
            } else {
                if (b0.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
                    iVar3 = new i(hVar3, z4);
                } else if (d0.z.d.m.areEqual(fqName, b0.getJAVAX_NONNULL_ANNOTATION())) {
                    d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = d0.e0.p.d.m0.k.x.a.firstArgument(cVar);
                    d0.e0.p.d.m0.k.v.j jVar = gVarFirstArgument instanceof d0.e0.p.d.m0.k.v.j ? (d0.e0.p.d.m0.k.v.j) gVarFirstArgument : null;
                    if (jVar != null) {
                        String strAsString = jVar.getEnumEntryName().asString();
                        switch (strAsString.hashCode()) {
                            case 73135176:
                                if (!strAsString.equals("MAYBE")) {
                                    iVar = null;
                                } else {
                                    iVar = new i(hVar2, z4);
                                }
                                break;
                            case 74175084:
                                if (!strAsString.equals("NEVER")) {
                                }
                                break;
                            case 433141802:
                                if (strAsString.equals("UNKNOWN")) {
                                    iVar = new i(hVar, z4);
                                    break;
                                }
                                break;
                            case 1933739535:
                                if (strAsString.equals("ALWAYS")) {
                                    iVar3 = new i(hVar3, z4);
                                }
                                iVar = null;
                                break;
                        }
                    } else {
                        iVar3 = new i(hVar3, z4);
                    }
                } else if (d0.z.d.m.areEqual(fqName, b0.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    iVar = new i(hVar2, z4);
                } else if (d0.z.d.m.areEqual(fqName, b0.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.f3348b.getEnableCompatqualCheckerFrameworkAnnotations()) {
                    iVar3 = new i(hVar3, z4);
                } else {
                    if (d0.z.d.m.areEqual(fqName, b0.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
                        iVar2 = new i(hVar3, true);
                    } else {
                        if (d0.z.d.m.areEqual(fqName, b0.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
                            iVar2 = new i(hVar2, true);
                        }
                        iVar = null;
                    }
                    iVar = iVar2;
                }
                iVar = iVar3;
            }
            if (iVar == null) {
                return null;
            }
        }
        return (!iVar.isForWarningOnly() && (cVar instanceof d0.e0.p.d.m0.e.a.h0.i) && ((d0.e0.p.d.m0.e.a.h0.i) cVar).isIdeExternalAnnotation()) ? i.copy$default(iVar, null, true, 1, null) : iVar;
    }

    public final b b(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.g1.a aVar, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, Function1<? super d0.e0.p.d.m0.c.b, ? extends c0> function1) {
        c0 c0VarInvoke = function1.invoke(bVar);
        Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (d0.e0.p.d.m0.c.b bVar2 : overriddenDescriptors) {
            d0.z.d.m.checkNotNullExpressionValue(bVar2, "it");
            arrayList.add(function1.invoke(bVar2));
        }
        return new b(aVar, c0VarInvoke, arrayList, z2, d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, function1.invoke(bVar).getAnnotations()), aVar2, false, 64, null);
    }

    public final b c(d0.e0.p.d.m0.c.b bVar, c1 c1Var, d0.e0.p.d.m0.e.a.i0.g gVar, Function1<? super d0.e0.p.d.m0.c.b, ? extends c0> function1) {
        d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers;
        return b(bVar, c1Var, false, (c1Var == null || (gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, c1Var.getAnnotations())) == null) ? gVar : gVarCopyWithNewDefaultTypeQualifiers, d0.e0.p.d.m0.e.a.a.VALUE_PARAMETER, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0298 A[LOOP:4: B:153:0x0292->B:155:0x0298, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <D extends d0.e0.p.d.m0.c.b> Collection<D> enhanceSignatures(d0.e0.p.d.m0.e.a.i0.g gVar, Collection<? extends D> collection) {
        d0.e0.p.d.m0.c.b bVar;
        d0.e0.p.d.m0.e.a.h0.b bVar2;
        a aVarEnhance$default;
        k kVar;
        Boolean bool;
        boolean z2;
        boolean z3;
        boolean z4;
        c0 type;
        boolean zDeclaresDefaultValue;
        List<w> parametersInfo;
        String strSignature;
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(collection, "platformSignatures");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.b bVarEnhance = (d0.e0.p.d.m0.c.b) it.next();
            if (bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.b) {
                d0.e0.p.d.m0.e.a.h0.b bVar3 = (d0.e0.p.d.m0.e.a.h0.b) bVarEnhance;
                if (bVar3.getKind() != b.a.FAKE_OVERRIDE || bVar3.getOriginal().getOverriddenDescriptors().size() != 1) {
                    d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, bVarEnhance.getAnnotations());
                    w wVar = null;
                    if (bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.g) {
                        d0.e0.p.d.m0.e.a.h0.g gVar2 = (d0.e0.p.d.m0.e.a.h0.g) bVarEnhance;
                        d0 getter = gVar2.getGetter();
                        if (d0.z.d.m.areEqual(getter == null ? null : Boolean.valueOf(getter.isDefault()), Boolean.FALSE)) {
                            d0 getter2 = gVar2.getGetter();
                            d0.z.d.m.checkNotNull(getter2);
                            bVar = getter2;
                        }
                        bVar2 = (d0.e0.p.d.m0.e.a.h0.b) bVarEnhance;
                        if (bVar2.getExtensionReceiverParameter() == null) {
                        }
                        if (!(bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.f)) {
                        }
                        if (fVar == null) {
                            if (kVar != null) {
                            }
                            List<c1> valueParameters = bVar.getValueParameters();
                            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "annotationOwnerForMember.valueParameters");
                            ArrayList<c> arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(valueParameters, 10));
                            while (r0.hasNext()) {
                            }
                            n0 n0Var = (n0) (bVarEnhance instanceof n0 ? null : bVarEnhance);
                            if (n0Var != null) {
                            }
                            bool = Boolean.TRUE;
                            a aVarEnhance = b(bVarEnhance, bVar, true, gVarCopyWithNewDefaultTypeQualifiers, !d0.z.d.m.areEqual(boolValueOf, bool) ? d0.e0.p.d.m0.e.a.a.FIELD : d0.e0.p.d.m0.e.a.a.METHOD_RETURN_TYPE, o.j).enhance(kVar != null ? null : kVar.getReturnTypeInfo());
                            if (d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getContainsFunctionN()), bool)) {
                                z2 = true;
                                if (d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                                }
                            }
                        }
                    } else {
                        bVar = bVarEnhance;
                        bVar2 = (d0.e0.p.d.m0.e.a.h0.b) bVarEnhance;
                        if (bVar2.getExtensionReceiverParameter() == null) {
                            d0.e0.p.d.m0.c.x xVar = (d0.e0.p.d.m0.c.x) (!(bVar instanceof d0.e0.p.d.m0.c.x) ? null : bVar);
                            aVarEnhance$default = b.enhance$default(c(bVarEnhance, xVar == null ? null : (c1) xVar.getUserData(d0.e0.p.d.m0.e.a.h0.f.M), gVarCopyWithNewDefaultTypeQualifiers, n.j), null, 1, null);
                        } else {
                            aVarEnhance$default = null;
                        }
                        d0.e0.p.d.m0.e.a.h0.f fVar = !(bVarEnhance instanceof d0.e0.p.d.m0.e.a.h0.f) ? (d0.e0.p.d.m0.e.a.h0.f) bVarEnhance : null;
                        kVar = (fVar == null || (strSignature = d0.e0.p.d.m0.e.b.t.signature(d0.e0.p.d.m0.e.b.w.a, (d0.e0.p.d.m0.c.e) fVar.getContainingDeclaration(), d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(fVar, false, false, 3, null))) == null) ? null : j.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature);
                        if (kVar != null) {
                            kVar.getParametersInfo().size();
                            bVar2.getValueParameters().size();
                        }
                        List<c1> valueParameters2 = bVar.getValueParameters();
                        d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "annotationOwnerForMember.valueParameters");
                        ArrayList<c> arrayList22 = new ArrayList(d0.t.o.collectionSizeOrDefault(valueParameters2, 10));
                        for (c1 c1Var : valueParameters2) {
                            a aVarEnhance2 = c(bVarEnhance, c1Var, gVarCopyWithNewDefaultTypeQualifiers, new p(c1Var)).enhance((kVar == null || (parametersInfo = kVar.getParametersInfo()) == null) ? wVar : (w) d0.t.u.getOrNull(parametersInfo, c1Var.getIndex()));
                            if (aVarEnhance2.getWereChanges()) {
                                type = aVarEnhance2.getType();
                            } else {
                                type = c1Var.getType();
                                d0.z.d.m.checkNotNullExpressionValue(type, "p.type");
                            }
                            d0.z.d.m.checkNotNullExpressionValue(c1Var, "p");
                            d0.e0.p.d.m0.e.a.h0.a defaultValueFromAnnotation = d0.e0.p.d.m0.e.a.h0.k.getDefaultValueFromAnnotation(c1Var);
                            if (defaultValueFromAnnotation instanceof d0.e0.p.d.m0.e.a.h0.j) {
                                zDeclaresDefaultValue = f0.lexicalCastFrom(type, ((d0.e0.p.d.m0.e.a.h0.j) defaultValueFromAnnotation).getValue()) != null;
                            } else if (d0.z.d.m.areEqual(defaultValueFromAnnotation, d0.e0.p.d.m0.e.a.h0.h.a)) {
                                zDeclaresDefaultValue = e1.acceptsNullable(type);
                            } else {
                                if (defaultValueFromAnnotation != null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                zDeclaresDefaultValue = c1Var.declaresDefaultValue();
                            }
                            boolean z5 = zDeclaresDefaultValue && c1Var.getOverriddenDescriptors().isEmpty();
                            arrayList22.add(new c(aVarEnhance2.getType(), z5, aVarEnhance2.getWereChanges() || z5 != c1Var.declaresDefaultValue(), aVarEnhance2.getContainsFunctionN()));
                            wVar = null;
                        }
                        n0 n0Var2 = (n0) (bVarEnhance instanceof n0 ? null : bVarEnhance);
                        Boolean boolValueOf = n0Var2 != null ? null : Boolean.valueOf(d0.e0.p.d.m0.e.a.i0.l.c.isJavaField(n0Var2));
                        bool = Boolean.TRUE;
                        a aVarEnhance3 = b(bVarEnhance, bVar, true, gVarCopyWithNewDefaultTypeQualifiers, !d0.z.d.m.areEqual(boolValueOf, bool) ? d0.e0.p.d.m0.e.a.a.FIELD : d0.e0.p.d.m0.e.a.a.METHOD_RETURN_TYPE, o.j).enhance(kVar != null ? null : kVar.getReturnTypeInfo());
                        if (!d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getContainsFunctionN()), bool) || aVarEnhance3.getContainsFunctionN()) {
                            z2 = true;
                            if (!d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE) || aVarEnhance3.getWereChanges()) {
                                Pair<a.InterfaceC0511a<?>, ?> pair = z2 ? d0.o.to(d0.e0.p.d.m0.k.w.a.getDEPRECATED_FUNCTION_KEY(), new d0.e0.p.d.m0.e.a.m(bVarEnhance)) : null;
                                c0 type2 = aVarEnhance$default == null ? null : aVarEnhance$default.getType();
                                ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList22, 10));
                                for (c cVar : arrayList22) {
                                    arrayList3.add(new d0.e0.p.d.m0.e.a.h0.l(cVar.getType(), cVar.getHasDefaultValue()));
                                }
                                bVarEnhance = bVar2.enhance(type2, arrayList3, aVarEnhance3.getType(), pair);
                            } else if (arrayList22.isEmpty()) {
                                z3 = false;
                                if (!z3 || z2) {
                                }
                            } else {
                                Iterator it2 = arrayList22.iterator();
                                while (it2.hasNext()) {
                                    if (((c) it2.next()).getWereChanges()) {
                                        z3 = true;
                                        break;
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                    if (z2) {
                                    }
                                    if (aVarEnhance$default == null) {
                                    }
                                    ArrayList arrayList32 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList22, 10));
                                    while (r3.hasNext()) {
                                    }
                                    bVarEnhance = bVar2.enhance(type2, arrayList32, aVarEnhance3.getType(), pair);
                                }
                            }
                        } else if (arrayList22.isEmpty()) {
                            z4 = false;
                            if (z4) {
                                z2 = false;
                            }
                            if (d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                                if (z2) {
                                }
                                if (aVarEnhance$default == null) {
                                }
                                ArrayList arrayList322 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList22, 10));
                                while (r3.hasNext()) {
                                }
                                bVarEnhance = bVar2.enhance(type2, arrayList322, aVarEnhance3.getType(), pair);
                            }
                        } else {
                            Iterator it3 = arrayList22.iterator();
                            while (it3.hasNext()) {
                                if (((c) it3.next()).getContainsFunctionN()) {
                                    z4 = true;
                                    break;
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (d0.z.d.m.areEqual(aVarEnhance$default != null ? null : Boolean.valueOf(aVarEnhance$default.getWereChanges()), Boolean.TRUE)) {
                            }
                        }
                    }
                }
            }
            arrayList.add(bVarEnhance);
        }
        return arrayList;
    }

    public final c0 enhanceSuperType(c0 c0Var, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        d0.z.d.m.checkNotNullParameter(gVar, "context");
        return b.enhance$default(new b(null, c0Var, d0.t.n.emptyList(), false, gVar, d0.e0.p.d.m0.e.a.a.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    public final List<c0> enhanceTypeParameterBounds(z0 z0Var, List<? extends c0> list, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(z0Var, "typeParameter");
        d0.z.d.m.checkNotNullParameter(list, "bounds");
        d0.z.d.m.checkNotNullParameter(gVar, "context");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        for (c0 type : list) {
            if (!d0.e0.p.d.m0.n.o1.a.contains(type, d.j)) {
                type = b.enhance$default(new b(this, z0Var, type, d0.t.n.emptyList(), false, gVar, d0.e0.p.d.m0.e.a.a.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(type);
        }
        return arrayList;
    }

    public final i extractNullability(d0.e0.p.d.m0.c.g1.c cVar, boolean z2, boolean z3) {
        i iVarA;
        d0.z.d.m.checkNotNullParameter(cVar, "annotationDescriptor");
        i iVarA2 = a(cVar, z2, z3);
        if (iVarA2 != null) {
            return iVarA2;
        }
        d0.e0.p.d.m0.c.g1.c cVarResolveTypeQualifierAnnotation = this.a.resolveTypeQualifierAnnotation(cVar);
        if (cVarResolveTypeQualifierAnnotation == null) {
            return null;
        }
        d0.e0.p.d.m0.p.h hVarResolveJsr305AnnotationState = this.a.resolveJsr305AnnotationState(cVar);
        if (hVarResolveJsr305AnnotationState.isIgnore() || (iVarA = a(cVarResolveTypeQualifierAnnotation, z2, z3)) == null) {
            return null;
        }
        return i.copy$default(iVarA, null, hVarResolveJsr305AnnotationState.isWarning(), 1, null);
    }

    /* compiled from: signatureEnhancement.kt */
    public final class b {
        public final d0.e0.p.d.m0.c.g1.a a;

        /* renamed from: b, reason: collision with root package name */
        public final c0 f3350b;
        public final Collection<c0> c;
        public final boolean d;
        public final d0.e0.p.d.m0.e.a.i0.g e;
        public final d0.e0.p.d.m0.e.a.a f;
        public final boolean g;

        /* compiled from: signatureEnhancement.kt */
        public static final class a extends d0.z.d.o implements Function1<i1, Boolean> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
                return invoke2(i1Var);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(i1 i1Var) {
                d0.e0.p.d.m0.c.h declarationDescriptor = i1Var.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    return Boolean.FALSE;
                }
                d0.e0.p.d.m0.g.e name = declarationDescriptor.getName();
                d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
                return Boolean.valueOf(d0.z.d.m.areEqual(name, cVar.getFUNCTION_N_FQ_NAME().shortName()) && d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.fqNameOrNull(declarationDescriptor), cVar.getFUNCTION_N_FQ_NAME()));
            }
        }

        /* compiled from: signatureEnhancement.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.l0.l$b$b, reason: collision with other inner class name */
        public static final class C0529b extends d0.z.d.o implements Function1<Integer, e> {
            public final /* synthetic */ w $predefined;
            public final /* synthetic */ Function1<Integer, e> $qualifiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0529b(w wVar, Function1<? super Integer, e> function1) {
                super(1);
                this.$predefined = wVar;
                this.$qualifiers = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ e invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final e invoke(int i) {
                e eVar = this.$predefined.getMap().get(Integer.valueOf(i));
                return eVar == null ? this.$qualifiers.invoke(Integer.valueOf(i)) : eVar;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar, d0.e0.p.d.m0.c.g1.a aVar, c0 c0Var, Collection<? extends c0> collection, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, boolean z3) {
            d0.z.d.m.checkNotNullParameter(lVar, "this$0");
            d0.z.d.m.checkNotNullParameter(c0Var, "fromOverride");
            d0.z.d.m.checkNotNullParameter(collection, "fromOverridden");
            d0.z.d.m.checkNotNullParameter(gVar, "containerContext");
            d0.z.d.m.checkNotNullParameter(aVar2, "containerApplicabilityType");
            l.this = lVar;
            this.a = aVar;
            this.f3350b = c0Var;
            this.c = collection;
            this.d = z2;
            this.e = gVar;
            this.f = aVar2;
            this.g = z3;
        }

        public static final <T> T c(List<d0.e0.p.d.m0.g.b> list, d0.e0.p.d.m0.c.g1.g gVar, T t) {
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (gVar.findAnnotation((d0.e0.p.d.m0.g.b) it.next()) != null) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                return t;
            }
            return null;
        }

        public static final void d(b bVar, ArrayList<s> arrayList, c0 c0Var, d0.e0.p.d.m0.e.a.i0.g gVar, z0 z0Var) {
            d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, c0Var.getAnnotations());
            y defaultTypeQualifiers = gVarCopyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            d0.e0.p.d.m0.e.a.u uVar = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(bVar.g ? d0.e0.p.d.m0.e.a.a.TYPE_PARAMETER_BOUNDS : d0.e0.p.d.m0.e.a.a.TYPE_USE);
            arrayList.add(new s(c0Var, uVar, z0Var, false));
            List<w0> arguments = c0Var.getArguments();
            List<z0> parameters = c0Var.getConstructor().getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
            for (Pair pair : d0.t.u.zip(arguments, parameters)) {
                w0 w0Var = (w0) pair.component1();
                z0 z0Var2 = (z0) pair.component2();
                if (w0Var.isStarProjection()) {
                    c0 type = w0Var.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type, "arg.type");
                    arrayList.add(new s(type, uVar, z0Var2, true));
                } else {
                    c0 type2 = w0Var.getType();
                    d0.z.d.m.checkNotNullExpressionValue(type2, "arg.type");
                    d(bVar, arrayList, type2, gVarCopyWithNewDefaultTypeQualifiers, z0Var2);
                }
            }
        }

        public static /* synthetic */ a enhance$default(b bVar, w wVar, int i, Object obj) {
            if ((i & 1) != 0) {
                wVar = null;
            }
            return bVar.enhance(wVar);
        }

        public final h a(z0 z0Var) {
            boolean z2;
            boolean z3;
            if (!(z0Var instanceof d0.e0.p.d.m0.e.a.i0.l.s)) {
                return null;
            }
            d0.e0.p.d.m0.e.a.i0.l.s sVar = (d0.e0.p.d.m0.e.a.i0.l.s) z0Var;
            List<c0> upperBounds = sVar.getUpperBounds();
            d0.z.d.m.checkNotNullExpressionValue(upperBounds, "upperBounds");
            boolean z4 = false;
            if ((upperBounds instanceof Collection) && upperBounds.isEmpty()) {
                z2 = true;
            } else {
                Iterator<T> it = upperBounds.iterator();
                while (it.hasNext()) {
                    if (!e0.isError((c0) it.next())) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
            }
            if (z2) {
                return null;
            }
            List<c0> upperBounds2 = sVar.getUpperBounds();
            d0.z.d.m.checkNotNullExpressionValue(upperBounds2, "upperBounds");
            if ((upperBounds2 instanceof Collection) && upperBounds2.isEmpty()) {
                z3 = true;
            } else {
                Iterator<T> it2 = upperBounds2.iterator();
                while (it2.hasNext()) {
                    if (!r.access$isNullabilityFlexible((c0) it2.next())) {
                        z3 = false;
                        break;
                    }
                }
                z3 = true;
            }
            if (z3) {
                return null;
            }
            List<c0> upperBounds3 = sVar.getUpperBounds();
            d0.z.d.m.checkNotNullExpressionValue(upperBounds3, "upperBounds");
            if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                Iterator<T> it3 = upperBounds3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    d0.z.d.m.checkNotNullExpressionValue((c0) it3.next(), "it");
                    if (!e0.isNullable(r0)) {
                        z4 = true;
                        break;
                    }
                }
            }
            return z4 ? h.NOT_NULL : h.NULLABLE;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final e b(c0 c0Var) {
            Pair pair;
            h hVar;
            h hVar2;
            if (d0.e0.p.d.m0.n.y.isFlexible(c0Var)) {
                d0.e0.p.d.m0.n.v vVarAsFlexibleType = d0.e0.p.d.m0.n.y.asFlexibleType(c0Var);
                pair = new Pair(vVarAsFlexibleType.getLowerBound(), vVarAsFlexibleType.getUpperBound());
            } else {
                pair = new Pair(c0Var, c0Var);
            }
            c0 c0Var2 = (c0) pair.component1();
            c0 c0Var3 = (c0) pair.component2();
            d0.e0.p.d.m0.b.q.d dVar = d0.e0.p.d.m0.b.q.d.a;
            if (c0Var2.isMarkedNullable()) {
                hVar2 = h.NULLABLE;
            } else {
                if (c0Var3.isMarkedNullable()) {
                    hVar = null;
                    return new e(hVar, !dVar.isReadOnly(c0Var2) ? f.READ_ONLY : dVar.isMutable(c0Var3) ? f.MUTABLE : null, c0Var.unwrap() instanceof g, false, 8, null);
                }
                hVar2 = h.NOT_NULL;
            }
            hVar = hVar2;
            return new e(hVar, !dVar.isReadOnly(c0Var2) ? f.READ_ONLY : dVar.isMutable(c0Var3) ? f.MUTABLE : null, c0Var.unwrap() instanceof g, false, 8, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0227  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0247  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x024d  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0255  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x02b7  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x02fc  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x030a  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x030e  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x0315  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x032c  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0333  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0335  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x035a  */
        /* JADX WARN: Removed duplicated region for block: B:190:0x035d  */
        /* JADX WARN: Removed duplicated region for block: B:196:0x036a  */
        /* JADX WARN: Removed duplicated region for block: B:198:0x036d  */
        /* JADX WARN: Removed duplicated region for block: B:199:0x036f  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0388  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x038a  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x038f  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x03a1  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x03ab  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:232:0x03cd  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x03dc  */
        /* JADX WARN: Removed duplicated region for block: B:239:0x03e7  */
        /* JADX WARN: Removed duplicated region for block: B:243:0x03f0  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x0413  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0415  */
        /* JADX WARN: Removed duplicated region for block: B:258:0x0418 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:260:0x0424  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x0426  */
        /* JADX WARN: Removed duplicated region for block: B:262:0x0428  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x02ac A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0222  */
        /* JADX WARN: Type inference failed for: r1v1, types: [d0.e0.p.d.m0.e.a.l0.m, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18, types: [d0.e0.p.d.m0.e.a.l0.e] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r4v4, types: [d0.e0.p.d.m0.e.a.l0.d] */
        /* JADX WARN: Type inference failed for: r6v3, types: [d0.e0.p.d.m0.e.a.l0.l$a] */
        /* JADX WARN: Type inference failed for: r6v44 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a enhance(w wVar) {
            Object obj;
            boolean z2;
            ArrayList arrayList;
            e[] eVarArr;
            int i;
            d0.e0.p.d.m0.e.a.u uVar;
            d0.e0.p.d.m0.c.g1.g annotations;
            d0.e0.p.d.m0.c.g1.a aVar;
            d0.e0.p.d.m0.e.a.u uVar2;
            h hVarA;
            Set set;
            Set set2;
            Set set3;
            Pair pair;
            Iterator<d0.e0.p.d.m0.c.g1.c> it;
            i iVarExtractNullability;
            i iVar;
            h hVar;
            i iVar2;
            boolean z3;
            e eVar;
            Object objC;
            h nullability;
            h nullability2;
            Set set4;
            boolean z4;
            h hVarSelect;
            Set set5;
            boolean z5;
            boolean z6;
            e eVarCreateJavaTypeQualifiers;
            boolean z7;
            i nullabilityQualifier;
            boolean z8;
            Collection<c0> collection = this.c;
            int i2 = 10;
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
            Iterator it2 = collection.iterator();
            while (true) {
                obj = null;
                if (!it2.hasNext()) {
                    break;
                }
                c0 c0Var = (c0) it2.next();
                ArrayList arrayList3 = new ArrayList(1);
                d(this, arrayList3, c0Var, this.e, null);
                arrayList2.add(arrayList3);
            }
            c0 c0Var2 = this.f3350b;
            ArrayList arrayList4 = new ArrayList(1);
            d(this, arrayList4, c0Var2, this.e, null);
            if (this.d) {
                Collection<c0> collection2 = this.c;
                if ((collection2 instanceof Collection) && collection2.isEmpty()) {
                    z8 = false;
                    if (!z8) {
                    }
                } else {
                    Iterator it3 = collection2.iterator();
                    while (it3.hasNext()) {
                        if (!d0.e0.p.d.m0.n.l1.f.a.equalTypes((c0) it3.next(), this.f3350b)) {
                            z8 = true;
                            break;
                        }
                    }
                    z8 = false;
                    z2 = !z8;
                }
            }
            int size = z2 ? 1 : arrayList4.size();
            e[] eVarArr2 = new e[size];
            int i3 = 0;
            while (i3 < size) {
                boolean z9 = i3 == 0;
                s sVar = (s) arrayList4.get(i3);
                c0 c0VarComponent1 = sVar.component1();
                d0.e0.p.d.m0.e.a.u uVarComponent2 = sVar.component2();
                z0 z0VarComponent3 = sVar.component3();
                boolean zComponent4 = sVar.component4();
                ArrayList arrayList5 = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    s sVar2 = (s) d0.t.u.getOrNull((List) it4.next(), i3);
                    Object type = sVar2 == null ? obj : sVar2.getType();
                    if (type != null) {
                        arrayList5.add(type);
                    }
                }
                h hVar2 = h.NULLABLE;
                int i4 = size;
                ArrayList arrayList6 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList5, i2));
                Iterator it5 = arrayList5.iterator();
                while (it5.hasNext()) {
                    arrayList6.add(b((c0) it5.next()));
                }
                ArrayList arrayList7 = new ArrayList();
                Iterator it6 = arrayList6.iterator();
                while (it6.hasNext()) {
                    ArrayList arrayList8 = arrayList2;
                    f mutability = ((e) it6.next()).getMutability();
                    if (mutability != null) {
                        arrayList7.add(mutability);
                    }
                    arrayList2 = arrayList8;
                }
                ArrayList arrayList9 = arrayList2;
                Set set6 = d0.t.u.toSet(arrayList7);
                ArrayList arrayList10 = new ArrayList();
                Iterator it7 = arrayList6.iterator();
                while (it7.hasNext()) {
                    Iterator it8 = it7;
                    h nullability3 = ((e) it7.next()).getNullability();
                    if (nullability3 != null) {
                        arrayList10.add(nullability3);
                    }
                    it7 = it8;
                }
                Set set7 = d0.t.u.toSet(arrayList10);
                ArrayList arrayList11 = new ArrayList();
                Iterator it9 = arrayList5.iterator();
                while (it9.hasNext()) {
                    ArrayList arrayList12 = arrayList4;
                    h nullability4 = b(g1.unwrapEnhancement((c0) it9.next())).getNullability();
                    if (nullability4 != null) {
                        arrayList11.add(nullability4);
                    }
                    arrayList4 = arrayList12;
                }
                ArrayList arrayList13 = arrayList4;
                Set set8 = d0.t.u.toSet(arrayList11);
                h hVar3 = h.NOT_NULL;
                boolean typeEnhancementImprovements = this.e.getComponents().getSettings().getTypeEnhancementImprovements();
                if (z9) {
                    uVar = uVarComponent2;
                    d0.e0.p.d.m0.c.g1.a aVar2 = this.a;
                    if (aVar2 == null || (aVar2 instanceof z0) || !typeEnhancementImprovements) {
                        arrayList = arrayList6;
                        eVarArr = eVarArr2;
                        i = i3;
                    } else {
                        d0.e0.p.d.m0.c.g1.g annotations2 = aVar2.getAnnotations();
                        l lVar = l.this;
                        eVarArr = eVarArr2;
                        ArrayList arrayList14 = new ArrayList();
                        Iterator<d0.e0.p.d.m0.c.g1.c> it10 = annotations2.iterator();
                        while (it10.hasNext()) {
                            int i5 = i3;
                            d0.e0.p.d.m0.c.g1.c next = it10.next();
                            Iterator<d0.e0.p.d.m0.c.g1.c> it11 = it10;
                            ArrayList arrayList15 = arrayList6;
                            c.a aVarResolveAnnotation = l.access$getAnnotationTypeQualifierResolver$p(lVar).resolveAnnotation(next);
                            if ((aVarResolveAnnotation == null || aVarResolveAnnotation.component2().contains(d0.e0.p.d.m0.e.a.a.TYPE_USE)) ? false : true) {
                                arrayList14.add(next);
                            }
                            i3 = i5;
                            it10 = it11;
                            arrayList6 = arrayList15;
                        }
                        arrayList = arrayList6;
                        i = i3;
                        annotations = d0.e0.p.d.m0.c.g1.i.composeAnnotations(d0.e0.p.d.m0.c.g1.g.f.create(arrayList14), c0VarComponent1.getAnnotations());
                        if (z9) {
                            uVar2 = uVar;
                        } else {
                            y defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                            uVar2 = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(this.f);
                        }
                        if (uVar2 != null) {
                            if (!(uVar2.getAffectsTypeParameterBasedTypes() || !d0.e0.p.d.m0.n.o1.a.isTypeParameter(c0VarComponent1))) {
                                uVar2 = null;
                            }
                        }
                        d0.e0.p.d.m0.c.h declarationDescriptor = c0VarComponent1.getConstructor().getDeclarationDescriptor();
                        z0 z0Var = !(declarationDescriptor instanceof z0) ? (z0) declarationDescriptor : null;
                        hVarA = z0Var != null ? null : a(z0Var);
                        if (hVarA != null) {
                            pair = new Pair(null, Boolean.FALSE);
                            set2 = set6;
                            set3 = set7;
                            set = set8;
                        } else {
                            set = set8;
                            set2 = set6;
                            set3 = set7;
                            pair = new Pair(new i(hVar3, false, 2, null), Boolean.valueOf(hVarA == hVar3));
                        }
                        i iVar3 = (i) pair.component1();
                        boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
                        boolean z10 = this.g;
                        l lVar2 = l.this;
                        it = annotations.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                iVarExtractNullability = null;
                                break;
                            }
                            iVarExtractNullability = lVar2.extractNullability(it.next(), typeEnhancementImprovements, z10);
                            if (iVarExtractNullability != null) {
                                break;
                            }
                        }
                        iVar = (iVarExtractNullability == null && !zComponent4) ? iVarExtractNullability : null;
                        if (iVar != null) {
                            if (iVar3 == null) {
                                iVar3 = (uVar2 == null || (nullabilityQualifier = uVar2.getNullabilityQualifier()) == null) ? null : new i(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                            }
                            h hVarA2 = z0VarComponent3 == null ? null : a(z0VarComponent3);
                            if (hVarA2 == null) {
                                iVar2 = iVar3;
                                hVar = null;
                            } else if (iVar3 == null) {
                                iVar2 = new i(hVarA2, false, 2, null);
                                hVar = null;
                            } else {
                                h qualifier = iVar3.getQualifier();
                                h hVar4 = h.FORCE_FLEXIBILITY;
                                if (hVarA2 != hVar4) {
                                    if (qualifier != hVar4) {
                                        if (hVarA2 == hVar2) {
                                            hVarA2 = qualifier;
                                        } else if (qualifier != hVar2) {
                                            hVarA2 = hVar3;
                                        }
                                    }
                                    hVar = null;
                                    iVar2 = new i(hVarA2, false, 2, null);
                                }
                            }
                        } else {
                            hVar = null;
                            iVar2 = iVar;
                        }
                        if (iVar == null) {
                            z3 = iVar.getQualifier() == hVar3;
                        } else {
                            if (!zBooleanValue) {
                                if (d0.z.d.m.areEqual(uVar2 == null ? hVar : Boolean.valueOf(uVar2.getMakesTypeParameterNotNull()), Boolean.TRUE)) {
                                }
                            }
                        }
                        h qualifier2 = iVar2 != null ? hVar : iVar2.getQualifier();
                        List<d0.e0.p.d.m0.g.b> read_only_annotations = b0.getREAD_ONLY_ANNOTATIONS();
                        f fVar = f.READ_ONLY;
                        objC = c(read_only_annotations, annotations, fVar);
                        List<d0.e0.p.d.m0.g.b> mutable_annotations = b0.getMUTABLE_ANNOTATIONS();
                        f fVar2 = f.MUTABLE;
                        Object objC2 = c(mutable_annotations, annotations, fVar2);
                        if (objC == null && objC2 != null && !d0.z.d.m.areEqual(objC, objC2)) {
                            objC2 = hVar;
                        } else if (objC != null) {
                            objC2 = objC;
                        }
                        eVar = new e(qualifier2, (f) objC2, !z3 && d0.e0.p.d.m0.n.o1.a.isTypeParameter(c0VarComponent1), d0.z.d.m.areEqual(iVar2 != null ? hVar : Boolean.valueOf(iVar2.isForWarningOnly()), Boolean.TRUE));
                        ?? r1 = !(eVar.isNullabilityQualifierForWarning() ^ true) ? eVar : hVar;
                        nullability = r1 != 0 ? hVar : r1.getNullability();
                        nullability2 = eVar.getNullability();
                        if (this.d || !z9) {
                            set4 = set3;
                            z4 = false;
                        } else {
                            set4 = set3;
                            z4 = true;
                        }
                        hVarSelect = v.select(set4, nullability, z4);
                        if (hVarSelect != null) {
                            hVarSelect = hVar;
                        } else {
                            Object obj2 = this.a;
                            if (!(obj2 instanceof c1)) {
                                obj2 = hVar;
                            }
                            c1 c1Var = (c1) obj2;
                            if (((c1Var == null ? hVar : c1Var.getVarargElementType()) != null) && z9 && hVarSelect == hVar2) {
                            }
                        }
                        f fVar3 = (f) v.select(set2, fVar2, fVar, eVar.getMutability(), z4);
                        if (nullability2 != nullability) {
                            set5 = set;
                            if (d0.z.d.m.areEqual(set5, set4)) {
                                z5 = false;
                            }
                            if (eVar.isNotNullTypeParameter()) {
                                z6 = true;
                            } else if (arrayList.isEmpty()) {
                                z7 = false;
                                if (z7) {
                                    z6 = false;
                                }
                            } else {
                                Iterator it12 = arrayList.iterator();
                                while (it12.hasNext()) {
                                    if (((e) it12.next()).isNotNullTypeParameter()) {
                                        z7 = true;
                                        break;
                                    }
                                }
                                z7 = false;
                                if (z7) {
                                }
                            }
                            if (hVarSelect == null && z5) {
                                eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(v.select(set5, nullability2, z4), fVar3, true, z6);
                            } else {
                                eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar3, hVarSelect != null, z6);
                            }
                            eVarArr[i] = eVarCreateJavaTypeQualifiers;
                            i3 = i + 1;
                            obj = hVar;
                            size = i4;
                            arrayList2 = arrayList9;
                            arrayList4 = arrayList13;
                            eVarArr2 = eVarArr;
                            i2 = 10;
                        } else {
                            set5 = set;
                        }
                        z5 = true;
                        if (eVar.isNotNullTypeParameter()) {
                        }
                        if (hVarSelect == null) {
                            eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar3, hVarSelect != null, z6);
                        }
                        eVarArr[i] = eVarCreateJavaTypeQualifiers;
                        i3 = i + 1;
                        obj = hVar;
                        size = i4;
                        arrayList2 = arrayList9;
                        arrayList4 = arrayList13;
                        eVarArr2 = eVarArr;
                        i2 = 10;
                    }
                } else {
                    arrayList = arrayList6;
                    eVarArr = eVarArr2;
                    i = i3;
                    uVar = uVarComponent2;
                }
                annotations = (!z9 || (aVar = this.a) == null) ? c0VarComponent1.getAnnotations() : d0.e0.p.d.m0.c.g1.i.composeAnnotations(aVar.getAnnotations(), c0VarComponent1.getAnnotations());
                if (z9) {
                }
                if (uVar2 != null) {
                }
                d0.e0.p.d.m0.c.h declarationDescriptor2 = c0VarComponent1.getConstructor().getDeclarationDescriptor();
                if (!(declarationDescriptor2 instanceof z0)) {
                }
                if (z0Var != null) {
                }
                if (hVarA != null) {
                }
                i iVar32 = (i) pair.component1();
                boolean zBooleanValue2 = ((Boolean) pair.component2()).booleanValue();
                boolean z102 = this.g;
                l lVar22 = l.this;
                it = annotations.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                if (iVarExtractNullability == null) {
                }
                if (iVar != null) {
                }
                if (iVar == null) {
                }
                if (iVar2 != null) {
                }
                List<d0.e0.p.d.m0.g.b> read_only_annotations2 = b0.getREAD_ONLY_ANNOTATIONS();
                f fVar4 = f.READ_ONLY;
                objC = c(read_only_annotations2, annotations, fVar4);
                List<d0.e0.p.d.m0.g.b> mutable_annotations2 = b0.getMUTABLE_ANNOTATIONS();
                f fVar22 = f.MUTABLE;
                Object objC22 = c(mutable_annotations2, annotations, fVar22);
                if (objC == null) {
                    if (objC != null) {
                    }
                }
                eVar = new e(qualifier2, (f) objC22, !z3 && d0.e0.p.d.m0.n.o1.a.isTypeParameter(c0VarComponent1), d0.z.d.m.areEqual(iVar2 != null ? hVar : Boolean.valueOf(iVar2.isForWarningOnly()), Boolean.TRUE));
                if (!(eVar.isNullabilityQualifierForWarning() ^ true)) {
                }
                if (r1 != 0) {
                }
                nullability2 = eVar.getNullability();
                if (this.d) {
                    set4 = set3;
                    z4 = false;
                }
                hVarSelect = v.select(set4, nullability, z4);
                if (hVarSelect != null) {
                }
                f fVar32 = (f) v.select(set2, fVar22, fVar4, eVar.getMutability(), z4);
                if (nullability2 != nullability) {
                }
                z5 = true;
                if (eVar.isNotNullTypeParameter()) {
                }
                if (hVarSelect == null) {
                }
                eVarArr[i] = eVarCreateJavaTypeQualifiers;
                i3 = i + 1;
                obj = hVar;
                size = i4;
                arrayList2 = arrayList9;
                arrayList4 = arrayList13;
                eVarArr2 = eVarArr;
                i2 = 10;
            }
            Object obj3 = obj;
            ?? mVar = new m(eVarArr2);
            Object c0529b = wVar == null ? obj3 : new C0529b(wVar, mVar);
            boolean zContains = e1.contains(this.f3350b, a.j);
            ?? Access$getTypeEnhancement$p = l.access$getTypeEnhancement$p(l.this);
            c0 c0Var3 = this.f3350b;
            if (c0529b != null) {
                mVar = c0529b;
            }
            c0 c0VarEnhance = Access$getTypeEnhancement$p.enhance(c0Var3, mVar);
            ?? aVar3 = c0VarEnhance == null ? obj3 : new a(c0VarEnhance, true, zContains);
            return aVar3 == 0 ? new a(this.f3350b, false, zContains) : aVar3;
        }

        public /* synthetic */ b(d0.e0.p.d.m0.c.g1.a aVar, c0 c0Var, Collection collection, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(l.this, aVar, c0Var, collection, z2, gVar, aVar2, (i & 64) != 0 ? false : z3);
        }
    }
}
