package p507d0.p592z.p594d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: SpreadBuilder.java */
/* renamed from: d0.z.d.c0, reason: use source file name */
/* loaded from: classes3.dex */
public class SpreadBuilder {

    /* renamed from: a */
    public final ArrayList<Object> f25279a;

    public SpreadBuilder(int i) {
        this.f25279a = new ArrayList<>(i);
    }

    public void add(Object obj) {
        this.f25279a.add(obj);
    }

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f25279a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f25279a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f25279a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f25279a.add(it.next());
            }
            return;
        }
        if (!(obj instanceof Iterator)) {
            StringBuilder sbM833U = outline.m833U("Don't know how to spread ");
            sbM833U.append(obj.getClass());
            throw new UnsupportedOperationException(sbM833U.toString());
        }
        Iterator it2 = (Iterator) obj;
        while (it2.hasNext()) {
            this.f25279a.add(it2.next());
        }
    }

    public int size() {
        return this.f25279a.size();
    }

    public Object[] toArray(Object[] objArr) {
        return this.f25279a.toArray(objArr);
    }
}
