package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.f, reason: use source file name */
/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class protoTypeTableUtil {
    public static final C11692q abbreviatedType(C11692q c11692q, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11692q, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11692q.hasAbbreviatedType()) {
            return c11692q.getAbbreviatedType();
        }
        if (c11692q.hasAbbreviatedTypeId()) {
            return typeTable.get(c11692q.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final C11692q expandedType(C11693r c11693r, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11693r, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11693r.hasExpandedType()) {
            C11692q expandedType = c11693r.getExpandedType();
            Intrinsics3.checkNotNullExpressionValue(expandedType, "expandedType");
            return expandedType;
        }
        if (c11693r.hasExpandedTypeId()) {
            return typeTable.get(c11693r.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final C11692q flexibleUpperBound(C11692q c11692q, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11692q, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11692q.hasFlexibleUpperBound()) {
            return c11692q.getFlexibleUpperBound();
        }
        if (c11692q.hasFlexibleUpperBoundId()) {
            return typeTable.get(c11692q.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean hasReceiver(C11684i c11684i) {
        Intrinsics3.checkNotNullParameter(c11684i, "<this>");
        return c11684i.hasReceiverType() || c11684i.hasReceiverTypeId();
    }

    public static final C11692q outerType(C11692q c11692q, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11692q, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11692q.hasOuterType()) {
            return c11692q.getOuterType();
        }
        if (c11692q.hasOuterTypeId()) {
            return typeTable.get(c11692q.getOuterTypeId());
        }
        return null;
    }

    public static final C11692q receiverType(C11684i c11684i, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11684i, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11684i.hasReceiverType()) {
            return c11684i.getReceiverType();
        }
        if (c11684i.hasReceiverTypeId()) {
            return typeTable.get(c11684i.getReceiverTypeId());
        }
        return null;
    }

    public static final C11692q returnType(C11684i c11684i, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11684i, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11684i.hasReturnType()) {
            C11692q returnType = c11684i.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (c11684i.hasReturnTypeId()) {
            return typeTable.get(c11684i.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final List<C11692q> supertypes(C11678c c11678c, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11678c, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        List<C11692q> supertypeList = c11678c.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = c11678c.getSupertypeIdList();
            Intrinsics3.checkNotNullExpressionValue(supertypeIdList, "supertypeIdList");
            supertypeList = new ArrayList<>(Iterables2.collectionSizeOrDefault(supertypeIdList, 10));
            for (Integer num : supertypeIdList) {
                Intrinsics3.checkNotNullExpressionValue(num, "it");
                supertypeList.add(typeTable.get(num.intValue()));
            }
        }
        return supertypeList;
    }

    public static final C11692q type(C11692q.b bVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(bVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (bVar.hasType()) {
            return bVar.getType();
        }
        if (bVar.hasTypeId()) {
            return typeTable.get(bVar.getTypeId());
        }
        return null;
    }

    public static final C11692q underlyingType(C11693r c11693r, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11693r, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11693r.hasUnderlyingType()) {
            C11692q underlyingType = c11693r.getUnderlyingType();
            Intrinsics3.checkNotNullExpressionValue(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (c11693r.hasUnderlyingTypeId()) {
            return typeTable.get(c11693r.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<C11692q> upperBounds(C11694s c11694s, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11694s, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        List<C11692q> upperBoundList = c11694s.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = c11694s.getUpperBoundIdList();
            Intrinsics3.checkNotNullExpressionValue(upperBoundIdList, "upperBoundIdList");
            upperBoundList = new ArrayList<>(Iterables2.collectionSizeOrDefault(upperBoundIdList, 10));
            for (Integer num : upperBoundIdList) {
                Intrinsics3.checkNotNullExpressionValue(num, "it");
                upperBoundList.add(typeTable.get(num.intValue()));
            }
        }
        return upperBoundList;
    }

    public static final C11692q varargElementType(C11696u c11696u, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11696u, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11696u.hasVarargElementType()) {
            return c11696u.getVarargElementType();
        }
        if (c11696u.hasVarargElementTypeId()) {
            return typeTable.get(c11696u.getVarargElementTypeId());
        }
        return null;
    }

    public static final boolean hasReceiver(C11689n c11689n) {
        Intrinsics3.checkNotNullParameter(c11689n, "<this>");
        return c11689n.hasReceiverType() || c11689n.hasReceiverTypeId();
    }

    public static final C11692q receiverType(C11689n c11689n, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11689n, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11689n.hasReceiverType()) {
            return c11689n.getReceiverType();
        }
        if (c11689n.hasReceiverTypeId()) {
            return typeTable.get(c11689n.getReceiverTypeId());
        }
        return null;
    }

    public static final C11692q type(C11696u c11696u, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11696u, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11696u.hasType()) {
            C11692q type = c11696u.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            return type;
        }
        if (c11696u.hasTypeId()) {
            return typeTable.get(c11696u.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final C11692q returnType(C11689n c11689n, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(c11689n, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (c11689n.hasReturnType()) {
            C11692q returnType = c11689n.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (c11689n.hasReturnTypeId()) {
            return typeTable.get(c11689n.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }
}
