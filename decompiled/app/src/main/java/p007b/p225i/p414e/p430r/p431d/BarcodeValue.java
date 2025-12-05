package p007b.p225i.p414e.p430r.p431d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p007b.p225i.p414e.p430r.PDF417Common;

/* compiled from: BarcodeValue.java */
/* renamed from: b.i.e.r.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class BarcodeValue {

    /* renamed from: a */
    public final Map<Integer, Integer> f13469a = new HashMap();

    /* renamed from: a */
    public int[] m7048a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f13469a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return PDF417Common.m7045b(arrayList);
    }

    /* renamed from: b */
    public void m7049b(int i) {
        Integer num = this.f13469a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f13469a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
