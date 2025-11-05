package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.e.a.c;
import d0.e0.p.d.m0.e.a.k0.z;
import d0.e0.p.d.m0.e.a.u;
import d0.e0.p.d.m0.e.a.y;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: context.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.a$a, reason: collision with other inner class name */
    public static final class C0522a extends o implements Function0<y> {
        public final /* synthetic */ d0.e0.p.d.m0.c.g $containingDeclaration;
        public final /* synthetic */ g $this_childForClassOrPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0522a(g gVar, d0.e0.p.d.m0.c.g gVar2) {
            super(0);
            this.$this_childForClassOrPackage = gVar;
            this.$containingDeclaration = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ y invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            return a.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }
    }

    /* compiled from: context.kt */
    public static final class b extends o implements Function0<y> {
        public final /* synthetic */ d0.e0.p.d.m0.c.g1.g $additionalAnnotations;
        public final /* synthetic */ g $this_copyWithNewDefaultTypeQualifiers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, d0.e0.p.d.m0.c.g1.g gVar2) {
            super(0);
            this.$this_copyWithNewDefaultTypeQualifiers = gVar;
            this.$additionalAnnotations = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ y invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            return a.computeNewDefaultTypeQualifiers(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }
    }

    public static final g a(g gVar, m mVar, z zVar, int i, Lazy<y> lazy) {
        d0.e0.p.d.m0.e.a.i0.b components = gVar.getComponents();
        k hVar = zVar == null ? null : new h(gVar, mVar, zVar, i);
        if (hVar == null) {
            hVar = gVar.getTypeParameterResolver();
        }
        return new g(components, hVar, lazy);
    }

    public static final g child(g gVar, k kVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(kVar, "typeParameterResolver");
        return new g(gVar.getComponents(), kVar, gVar.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final g childForClassOrPackage(g gVar, d0.e0.p.d.m0.c.g gVar2, z zVar, int i) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar2, "containingDeclaration");
        return a(gVar, gVar2, zVar, i, d0.g.lazy(d0.i.NONE, new C0522a(gVar, gVar2)));
    }

    public static /* synthetic */ g childForClassOrPackage$default(g gVar, d0.e0.p.d.m0.c.g gVar2, z zVar, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            zVar = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForClassOrPackage(gVar, gVar2, zVar, i);
    }

    public static final g childForMethod(g gVar, m mVar, z zVar, int i) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(zVar, "typeParameterOwner");
        return a(gVar, mVar, zVar, i, gVar.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ g childForMethod$default(g gVar, m mVar, z zVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForMethod(gVar, mVar, zVar, i);
    }

    public static final y computeNewDefaultTypeQualifiers(g gVar, d0.e0.p.d.m0.c.g1.g gVar2) {
        boolean z2;
        EnumMap enumMap;
        EnumMap<d0.e0.p.d.m0.e.a.a, u> defaultQualifiers;
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar2, "additionalAnnotations");
        if (gVar.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            return gVar.getDefaultTypeQualifiers();
        }
        ArrayList<u> arrayList = new ArrayList();
        Iterator<d0.e0.p.d.m0.c.g1.c> it = gVar2.iterator();
        while (true) {
            z2 = false;
            enumMap = null;
            uVar = null;
            uVar = null;
            u uVar = null;
            enumMap = null;
            if (!it.hasNext()) {
                break;
            }
            d0.e0.p.d.m0.c.g1.c next = it.next();
            d0.e0.p.d.m0.e.a.c annotationTypeQualifierResolver = gVar.getComponents().getAnnotationTypeQualifierResolver();
            u uVarResolveQualifierBuiltInDefaultAnnotation = annotationTypeQualifierResolver.resolveQualifierBuiltInDefaultAnnotation(next);
            if (uVarResolveQualifierBuiltInDefaultAnnotation == null) {
                c.a aVarResolveTypeQualifierDefaultAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierDefaultAnnotation(next);
                if (aVarResolveTypeQualifierDefaultAnnotation != null) {
                    d0.e0.p.d.m0.c.g1.c cVarComponent1 = aVarResolveTypeQualifierDefaultAnnotation.component1();
                    List<d0.e0.p.d.m0.e.a.a> listComponent2 = aVarResolveTypeQualifierDefaultAnnotation.component2();
                    d0.e0.p.d.m0.p.h hVarResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305CustomState(next);
                    if (hVarResolveJsr305CustomState == null) {
                        hVarResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305AnnotationState(cVarComponent1);
                    }
                    if (!hVarResolveJsr305CustomState.isIgnore()) {
                        d0.e0.p.d.m0.e.a.l0.i iVarExtractNullability = gVar.getComponents().getSignatureEnhancement().extractNullability(cVarComponent1, gVar.getComponents().getSettings().getTypeEnhancementImprovements(), false);
                        d0.e0.p.d.m0.e.a.l0.i iVarCopy$default = iVarExtractNullability == null ? null : d0.e0.p.d.m0.e.a.l0.i.copy$default(iVarExtractNullability, null, hVarResolveJsr305CustomState.isWarning(), 1, null);
                        if (iVarCopy$default != null) {
                            uVar = new u(iVarCopy$default, listComponent2, false, 4, null);
                        }
                    }
                }
            } else {
                uVar = uVarResolveQualifierBuiltInDefaultAnnotation;
            }
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        if (arrayList.isEmpty()) {
            return gVar.getDefaultTypeQualifiers();
        }
        y defaultTypeQualifiers = gVar.getDefaultTypeQualifiers();
        if (defaultTypeQualifiers != null && (defaultQualifiers = defaultTypeQualifiers.getDefaultQualifiers()) != null) {
            enumMap = new EnumMap((EnumMap) defaultQualifiers);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(d0.e0.p.d.m0.e.a.a.class);
        }
        for (u uVar2 : arrayList) {
            Iterator<d0.e0.p.d.m0.e.a.a> it2 = uVar2.getQualifierApplicabilityTypes().iterator();
            while (it2.hasNext()) {
                enumMap.put((EnumMap) it2.next(), (d0.e0.p.d.m0.e.a.a) uVar2);
                z2 = true;
            }
        }
        return !z2 ? gVar.getDefaultTypeQualifiers() : new y(enumMap);
    }

    public static final g copyWithNewDefaultTypeQualifiers(g gVar, d0.e0.p.d.m0.c.g1.g gVar2) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar2, "additionalAnnotations");
        return gVar2.isEmpty() ? gVar : new g(gVar.getComponents(), gVar.getTypeParameterResolver(), d0.g.lazy(d0.i.NONE, new b(gVar, gVar2)));
    }

    public static final g replaceComponents(g gVar, d0.e0.p.d.m0.e.a.i0.b bVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "components");
        return new g(bVar, gVar.getTypeParameterResolver(), gVar.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }
}
