package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: javaElements.kt */
/* renamed from: d0.e0.p.d.m0.e.a.k0.d0 */
/* loaded from: classes3.dex */
public interface InterfaceC11571d0 extends InterfaceC11570d {

    /* compiled from: javaElements.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.k0.d0$a */
    public static final class a {
        public static InterfaceC11564a findAnnotation(InterfaceC11571d0 interfaceC11571d0, FqName fqName) {
            Object obj;
            Intrinsics3.checkNotNullParameter(interfaceC11571d0, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = interfaceC11571d0.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassId classId = ((InterfaceC11564a) next).getClassId();
                if (Intrinsics3.areEqual(classId != null ? classId.asSingleFqName() : null, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (InterfaceC11564a) obj;
        }
    }
}
