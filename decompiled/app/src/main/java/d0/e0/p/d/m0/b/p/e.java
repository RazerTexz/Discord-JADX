package d0.e0.p.d.m0.b.p;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.o.j;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.t.z;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FunctionInvokeDescriptor.kt */
/* loaded from: classes3.dex */
public final class e extends g0 {
    public static final a M = new a(null);

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final e create(b bVar, boolean z2) {
            String lowerCase;
            m.checkNotNullParameter(bVar, "functionClass");
            List<z0> declaredTypeParameters = bVar.getDeclaredTypeParameters();
            e eVar = new e(bVar, null, b.a.DECLARATION, z2, null);
            q0 thisAsReceiverParameter = bVar.getThisAsReceiverParameter();
            List<? extends z0> listEmptyList = n.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((z0) obj).getVariance() == j1.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<z> iterableWithIndex = u.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(iterableWithIndex, 10));
            for (z zVar : iterableWithIndex) {
                int index = zVar.getIndex();
                z0 z0Var = (z0) zVar.getValue();
                String strAsString = z0Var.getName().asString();
                m.checkNotNullExpressionValue(strAsString, "typeParameter.name.asString()");
                if (m.areEqual(strAsString, ExifInterface.GPS_DIRECTION_TRUE)) {
                    lowerCase = "instance";
                } else if (m.areEqual(strAsString, ExifInterface.LONGITUDE_EAST)) {
                    lowerCase = "receiver";
                } else {
                    lowerCase = strAsString.toLowerCase();
                    m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                }
                g empty = g.f.getEMPTY();
                d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(lowerCase);
                m.checkNotNullExpressionValue(eVarIdentifier, "identifier(name)");
                j0 defaultType = z0Var.getDefaultType();
                m.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
                u0 u0Var = u0.a;
                m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new l0(eVar, null, index, empty, eVarIdentifier, defaultType, false, false, false, null, u0Var));
                arrayList2 = arrayList3;
            }
            eVar.initialize((q0) null, thisAsReceiverParameter, listEmptyList, (List<c1>) arrayList2, (c0) ((z0) u.last((List) declaredTypeParameters)).getDefaultType(), d0.e0.p.d.m0.c.z.ABSTRACT, t.e);
            eVar.setHasSynthesizedParameterNames(true);
            return eVar;
        }
    }

    public e(d0.e0.p.d.m0.c.m mVar, e eVar, b.a aVar, boolean z2) {
        super(mVar, eVar, g.f.getEMPTY(), j.g, aVar, u0.a);
        setOperator(true);
        setSuspend(z2);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ e(d0.e0.p.d.m0.c.m mVar, e eVar, b.a aVar, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, eVar, aVar, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(d0.e0.p.d.m0.c.m mVar, x xVar, b.a aVar, d0.e0.p.d.m0.g.e eVar, g gVar, u0 u0Var) {
        m.checkNotNullParameter(mVar, "newOwner");
        m.checkNotNullParameter(aVar, "kind");
        m.checkNotNullParameter(gVar, "annotations");
        m.checkNotNullParameter(u0Var, "source");
        return new e(mVar, (e) xVar, aVar, isSuspend());
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public x c(q.c cVar) {
        boolean z2;
        d0.e0.p.d.m0.g.e eVar;
        m.checkNotNullParameter(cVar, "configuration");
        e eVar2 = (e) super.c(cVar);
        if (eVar2 == null) {
            return null;
        }
        List<c1> valueParameters = eVar2.getValueParameters();
        m.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z3 = true;
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            z2 = true;
        } else {
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                c0 type = ((c1) it.next()).getType();
                m.checkNotNullExpressionValue(type, "it.type");
                if (d0.e0.p.d.m0.b.g.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
        }
        if (z2) {
            return eVar2;
        }
        List<c1> valueParameters2 = eVar2.getValueParameters();
        m.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(valueParameters2, 10));
        Iterator<T> it2 = valueParameters2.iterator();
        while (it2.hasNext()) {
            c0 type2 = ((c1) it2.next()).getType();
            m.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(d0.e0.p.d.m0.b.g.extractParameterNameFromFunctionTypeArgument(type2));
        }
        int size = eVar2.getValueParameters().size() - arrayList.size();
        List<c1> valueParameters3 = eVar2.getValueParameters();
        m.checkNotNullExpressionValue(valueParameters3, "valueParameters");
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(valueParameters3, 10));
        for (c1 c1Var : valueParameters3) {
            d0.e0.p.d.m0.g.e name = c1Var.getName();
            m.checkNotNullExpressionValue(name, "it.name");
            int index = c1Var.getIndex();
            int i = index - size;
            if (i >= 0 && (eVar = (d0.e0.p.d.m0.g.e) arrayList.get(i)) != null) {
                name = eVar;
            }
            arrayList2.add(c1Var.copy(eVar2, name, index));
        }
        q.c cVarD = eVar2.d(d0.e0.p.d.m0.n.c1.a);
        if (arrayList.isEmpty()) {
            z3 = false;
        } else {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((d0.e0.p.d.m0.g.e) it3.next()) == null) {
                    break;
                }
            }
            z3 = false;
        }
        q.c original = cVarD.setHasSynthesizedParameterNames(z3).setValueParameters((List<c1>) arrayList2).setOriginal((d0.e0.p.d.m0.c.b) eVar2.getOriginal());
        m.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        x xVarC = super.c(original);
        m.checkNotNull(xVarC);
        return xVarC;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isTailrec() {
        return false;
    }
}
