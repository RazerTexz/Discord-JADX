package p007b.p225i.p226a.p288f.p313h.p324k;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* renamed from: b.i.a.f.h.k.q */
/* loaded from: classes3.dex */
public final class C3572q {

    /* renamed from: a */
    public static final String[] f9837a;

    /* renamed from: b */
    public static final Map<String, Integer> f9838b;

    static {
        String[] strArr = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        f9837a = strArr;
        f9838b = new HashMap(strArr.length);
        int i = 0;
        while (true) {
            String[] strArr2 = f9837a;
            if (i >= strArr2.length) {
                return;
            }
            f9838b.put(strArr2[i], Integer.valueOf(i));
            i++;
        }
    }
}
