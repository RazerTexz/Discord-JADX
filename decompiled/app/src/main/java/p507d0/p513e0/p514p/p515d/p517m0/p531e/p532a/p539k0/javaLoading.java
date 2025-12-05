package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: javaLoading.kt */
/* renamed from: d0.e0.p.d.m0.e.a.k0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class javaLoading {
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isObjectMethodInInterface(InterfaceC11584q interfaceC11584q) {
        boolean zIsEmpty;
        FqName fqName;
        Intrinsics3.checkNotNullParameter(interfaceC11584q, "<this>");
        if (interfaceC11584q.getContainingClass().isInterface() && (interfaceC11584q instanceof InterfaceC11585r)) {
            InterfaceC11585r interfaceC11585r = (InterfaceC11585r) interfaceC11584q;
            String strAsString = interfaceC11585r.getName().asString();
            int iHashCode = strAsString.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && strAsString.equals("hashCode")) {
                        zIsEmpty = interfaceC11585r.getValueParameters().isEmpty();
                    }
                } else if (strAsString.equals("equals")) {
                    InterfaceC11565a0 interfaceC11565a0 = (InterfaceC11565a0) _Collections.singleOrNull((List) interfaceC11585r.getValueParameters());
                    javaTypes5 type = interfaceC11565a0 == null ? null : interfaceC11565a0.getType();
                    javaTypes3 javatypes3 = type instanceof javaTypes3 ? (javaTypes3) type : null;
                    if (javatypes3 != null) {
                        InterfaceC11576i classifier = javatypes3.getClassifier();
                        if ((classifier instanceof InterfaceC11574g) && (fqName = ((InterfaceC11574g) classifier).getFqName()) != null && Intrinsics3.areEqual(fqName.asString(), "java.lang.Object")) {
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
