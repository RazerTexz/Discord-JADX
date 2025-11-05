package d0.e0.p.d.m0.e.a.k0;

import java.util.List;

/* compiled from: javaLoading.kt */
/* loaded from: classes3.dex */
public final class p {
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isObjectMethodInInterface(q qVar) {
        boolean zIsEmpty;
        d0.e0.p.d.m0.g.b fqName;
        d0.z.d.m.checkNotNullParameter(qVar, "<this>");
        if (qVar.getContainingClass().isInterface() && (qVar instanceof r)) {
            r rVar = (r) qVar;
            String strAsString = rVar.getName().asString();
            int iHashCode = strAsString.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && strAsString.equals("hashCode")) {
                        zIsEmpty = rVar.getValueParameters().isEmpty();
                    }
                } else if (strAsString.equals("equals")) {
                    a0 a0Var = (a0) d0.t.u.singleOrNull((List) rVar.getValueParameters());
                    x type = a0Var == null ? null : a0Var.getType();
                    j jVar = type instanceof j ? (j) type : null;
                    if (jVar != null) {
                        i classifier = jVar.getClassifier();
                        if ((classifier instanceof g) && (fqName = ((g) classifier).getFqName()) != null && d0.z.d.m.areEqual(fqName.asString(), "java.lang.Object")) {
                            zIsEmpty = true;
                        }
                    }
                }
                zIsEmpty = false;
            } else if (!strAsString.equals("toString")) {
                zIsEmpty = false;
            }
            if (zIsEmpty) {
                return true;
            }
        }
        return false;
    }
}
