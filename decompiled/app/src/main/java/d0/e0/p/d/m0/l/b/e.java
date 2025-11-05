package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.k.v.k;
import d0.e0.p.d.m0.n.j0;
import d0.t.g0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* compiled from: AnnotationDeserializer.kt */
/* loaded from: classes3.dex */
public final class e {
    public final d0.e0.p.d.m0.c.c0 a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f3486b;

    /* compiled from: AnnotationDeserializer.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            b.C0546b.c.EnumC0549c.values();
            a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        }
    }

    public e(d0.e0.p.d.m0.c.c0 c0Var, d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        this.a = c0Var;
        this.f3486b = d0Var;
    }

    public final boolean a(d0.e0.p.d.m0.k.v.g<?> gVar, d0.e0.p.d.m0.n.c0 c0Var, b.C0546b.c cVar) {
        b.C0546b.c.EnumC0549c type = cVar.getType();
        int i = type == null ? -1 : a.a[type.ordinal()];
        if (i != 10) {
            if (i != 13) {
                return d0.z.d.m.areEqual(gVar.getType(this.a), c0Var);
            }
            if (!((gVar instanceof d0.e0.p.d.m0.k.v.b) && ((d0.e0.p.d.m0.k.v.b) gVar).getValue().size() == cVar.getArrayElementList().size())) {
                throw new IllegalStateException(d0.z.d.m.stringPlus("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
            d0.e0.p.d.m0.n.c0 arrayElementType = this.a.getBuiltIns().getArrayElementType(c0Var);
            d0.z.d.m.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
            d0.e0.p.d.m0.k.v.b bVar = (d0.e0.p.d.m0.k.v.b) gVar;
            Iterable indices = d0.t.n.getIndices(bVar.getValue());
            if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                return true;
            }
            Iterator it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((d0.t.c0) it).nextInt();
                d0.e0.p.d.m0.k.v.g<?> gVar2 = bVar.getValue().get(iNextInt);
                b.C0546b.c arrayElement = cVar.getArrayElement(iNextInt);
                d0.z.d.m.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                if (!a(gVar2, arrayElementType, arrayElement)) {
                }
            }
            return true;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        d0.e0.p.d.m0.c.e eVar = declarationDescriptor instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) declarationDescriptor : null;
        if (eVar == null || d0.e0.p.d.m0.b.h.isKClass(eVar)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.Pair] */
    public final d0.e0.p.d.m0.c.g1.c deserializeAnnotation(d0.e0.p.d.m0.f.b bVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.e0.p.d.m0.c.e eVarFindNonGenericClassAcrossDependencies = d0.e0.p.d.m0.c.w.findNonGenericClassAcrossDependencies(this.a, w.getClassId(cVar, bVar.getId()), this.f3486b);
        Map mapEmptyMap = h0.emptyMap();
        if (bVar.getArgumentCount() != 0 && !d0.e0.p.d.m0.n.t.isError(eVarFindNonGenericClassAcrossDependencies) && d0.e0.p.d.m0.k.e.isAnnotationClass(eVarFindNonGenericClassAcrossDependencies)) {
            Collection<d0.e0.p.d.m0.c.d> constructors = eVarFindNonGenericClassAcrossDependencies.getConstructors();
            d0.z.d.m.checkNotNullExpressionValue(constructors, "annotationClass.constructors");
            d0.e0.p.d.m0.c.d dVar = (d0.e0.p.d.m0.c.d) d0.t.u.singleOrNull(constructors);
            if (dVar != null) {
                List<c1> valueParameters = dVar.getValueParameters();
                d0.z.d.m.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(valueParameters, 10)), 16));
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((c1) obj).getName(), obj);
                }
                List<b.C0546b> argumentList = bVar.getArgumentList();
                ArrayList arrayListA0 = b.d.b.a.a.a0(argumentList, "proto.argumentList");
                for (b.C0546b c0546b : argumentList) {
                    d0.z.d.m.checkNotNullExpressionValue(c0546b, "it");
                    c1 c1Var = (c1) linkedHashMap.get(w.getName(cVar, c0546b.getNameId()));
                    if (c1Var != null) {
                        d0.e0.p.d.m0.g.e name = w.getName(cVar, c0546b.getNameId());
                        d0.e0.p.d.m0.n.c0 type = c1Var.getType();
                        d0.z.d.m.checkNotNullExpressionValue(type, "parameter.type");
                        b.C0546b.c value = c0546b.getValue();
                        d0.z.d.m.checkNotNullExpressionValue(value, "proto.value");
                        d0.e0.p.d.m0.k.v.g<?> gVarResolveValue = resolveValue(type, value, cVar);
                        pair = a(gVarResolveValue, type, value) ? gVarResolveValue : null;
                        if (pair == null) {
                            k.a aVar = d0.e0.p.d.m0.k.v.k.f3474b;
                            StringBuilder sbU = b.d.b.a.a.U("Unexpected argument value: actual type ");
                            sbU.append(value.getType());
                            sbU.append(" != expected type ");
                            sbU.append(type);
                            pair = aVar.create(sbU.toString());
                        }
                        pair = new Pair(name, pair);
                    }
                    if (pair != null) {
                        arrayListA0.add(pair);
                    }
                }
                mapEmptyMap = h0.toMap(arrayListA0);
            }
        }
        return new d0.e0.p.d.m0.c.g1.d(eVarFindNonGenericClassAcrossDependencies.getDefaultType(), mapEmptyMap, u0.a);
    }

    public final d0.e0.p.d.m0.k.v.g<?> resolveValue(d0.e0.p.d.m0.n.c0 c0Var, b.C0546b.c cVar, d0.e0.p.d.m0.f.z.c cVar2) {
        d0.e0.p.d.m0.k.v.g<?> dVar;
        d0.z.d.m.checkNotNullParameter(c0Var, "expectedType");
        d0.z.d.m.checkNotNullParameter(cVar, "value");
        d0.z.d.m.checkNotNullParameter(cVar2, "nameResolver");
        Boolean bool = d0.e0.p.d.m0.f.z.b.M.get(cVar.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = bool.booleanValue();
        b.C0546b.c.EnumC0549c type = cVar.getType();
        switch (type == null ? -1 : a.a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) cVar.getIntValue();
                if (zBooleanValue) {
                    dVar = new d0.e0.p.d.m0.k.v.x(intValue);
                    break;
                } else {
                    dVar = new d0.e0.p.d.m0.k.v.d(intValue);
                    break;
                }
            case 2:
                return new d0.e0.p.d.m0.k.v.e((char) cVar.getIntValue());
            case 3:
                short intValue2 = (short) cVar.getIntValue();
                if (zBooleanValue) {
                    dVar = new d0.e0.p.d.m0.k.v.a0(intValue2);
                    break;
                } else {
                    dVar = new d0.e0.p.d.m0.k.v.v(intValue2);
                    break;
                }
            case 4:
                int intValue3 = (int) cVar.getIntValue();
                return zBooleanValue ? new d0.e0.p.d.m0.k.v.y(intValue3) : new d0.e0.p.d.m0.k.v.m(intValue3);
            case 5:
                long intValue4 = cVar.getIntValue();
                return zBooleanValue ? new d0.e0.p.d.m0.k.v.z(intValue4) : new d0.e0.p.d.m0.k.v.s(intValue4);
            case 6:
                return new d0.e0.p.d.m0.k.v.l(cVar.getFloatValue());
            case 7:
                return new d0.e0.p.d.m0.k.v.i(cVar.getDoubleValue());
            case 8:
                return new d0.e0.p.d.m0.k.v.c(cVar.getIntValue() != 0);
            case 9:
                return new d0.e0.p.d.m0.k.v.w(cVar2.getString(cVar.getStringValue()));
            case 10:
                return new d0.e0.p.d.m0.k.v.r(w.getClassId(cVar2, cVar.getClassId()), cVar.getArrayDimensionCount());
            case 11:
                return new d0.e0.p.d.m0.k.v.j(w.getClassId(cVar2, cVar.getClassId()), w.getName(cVar2, cVar.getEnumValueId()));
            case 12:
                d0.e0.p.d.m0.f.b annotation = cVar.getAnnotation();
                d0.z.d.m.checkNotNullExpressionValue(annotation, "value.annotation");
                return new d0.e0.p.d.m0.k.v.a(deserializeAnnotation(annotation, cVar2));
            case 13:
                d0.e0.p.d.m0.k.v.h hVar = d0.e0.p.d.m0.k.v.h.a;
                List<b.C0546b.c> arrayElementList = cVar.getArrayElementList();
                d0.z.d.m.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayElementList, 10));
                for (b.C0546b.c cVar3 : arrayElementList) {
                    j0 anyType = this.a.getBuiltIns().getAnyType();
                    d0.z.d.m.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    d0.z.d.m.checkNotNullExpressionValue(cVar3, "it");
                    arrayList.add(resolveValue(anyType, cVar3, cVar2));
                }
                return hVar.createArrayValue(arrayList, c0Var);
            default:
                StringBuilder sbU = b.d.b.a.a.U("Unsupported annotation argument type: ");
                sbU.append(cVar.getType());
                sbU.append(" (expected ");
                sbU.append(c0Var);
                sbU.append(')');
                throw new IllegalStateException(sbU.toString().toString());
        }
        return dVar;
    }
}
