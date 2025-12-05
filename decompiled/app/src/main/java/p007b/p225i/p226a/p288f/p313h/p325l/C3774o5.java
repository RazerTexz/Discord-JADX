package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* renamed from: b.i.a.f.h.l.o5 */
/* loaded from: classes3.dex */
public final class C3774o5 extends AbstractC3748m5 {

    /* renamed from: c */
    public static final Class<?> f10177c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public C3774o5(C3735l5 c3735l5) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* renamed from: a */
    public final <E> void mo5070a(Object obj, Object obj2, long j) {
        C3722k5 c3722k5;
        List list = (List) C3711j7.m4993r(obj2, j);
        int size = list.size();
        List listMo4569f = (List) C3711j7.m4993r(obj, j);
        if (listMo4569f.isEmpty()) {
            listMo4569f = listMo4569f instanceof InterfaceC3709j5 ? new C3722k5(size) : ((listMo4569f instanceof InterfaceC3736l6) && (listMo4569f instanceof InterfaceC3597b5)) ? ((InterfaceC3597b5) listMo4569f).mo4569f(size) : new ArrayList(size);
            C3711j7.m4981f(obj, j, listMo4569f);
        } else {
            if (f10177c.isAssignableFrom(listMo4569f.getClass())) {
                ArrayList arrayList = new ArrayList(listMo4569f.size() + size);
                arrayList.addAll(listMo4569f);
                C3711j7.m4981f(obj, j, arrayList);
                c3722k5 = arrayList;
            } else if (listMo4569f instanceof C3641e7) {
                C3722k5 c3722k52 = new C3722k5(listMo4569f.size() + size);
                c3722k52.addAll(c3722k52.size(), (C3641e7) listMo4569f);
                C3711j7.m4981f(obj, j, c3722k52);
                c3722k5 = c3722k52;
            } else if ((listMo4569f instanceof InterfaceC3736l6) && (listMo4569f instanceof InterfaceC3597b5)) {
                InterfaceC3597b5 interfaceC3597b5 = (InterfaceC3597b5) listMo4569f;
                if (!interfaceC3597b5.mo4568a()) {
                    listMo4569f = interfaceC3597b5.mo4569f(listMo4569f.size() + size);
                    C3711j7.m4981f(obj, j, listMo4569f);
                }
            }
            listMo4569f = c3722k5;
        }
        int size2 = listMo4569f.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listMo4569f.addAll(list);
        }
        if (size2 > 0) {
            list = listMo4569f;
        }
        C3711j7.m4981f(obj, j, list);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* renamed from: b */
    public final void mo5071b(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) C3711j7.m4993r(obj, j);
        if (list instanceof InterfaceC3709j5) {
            objUnmodifiableList = ((InterfaceC3709j5) list).mo4865s();
        } else {
            if (f10177c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC3736l6) && (list instanceof InterfaceC3597b5)) {
                InterfaceC3597b5 interfaceC3597b5 = (InterfaceC3597b5) list;
                if (interfaceC3597b5.mo4568a()) {
                    interfaceC3597b5.mo4570g0();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        C3711j7.m4981f(obj, j, objUnmodifiableList);
    }
}
