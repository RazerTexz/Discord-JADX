package p007b.p225i.p226a.p288f.p313h.p325l;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.h.l.x1 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3887x1 implements InterfaceC3622d2 {

    /* renamed from: a */
    public final C3900y1 f10399a;

    public C3887x1(C3900y1 c3900y1) {
        this.f10399a = c3900y1;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3622d2
    /* renamed from: a */
    public final Object mo4628a() {
        C3900y1 c3900y1 = this.f10399a;
        Cursor cursorQuery = c3900y1.f10419c.query(c3900y1.f10420d, C3900y1.f10418b, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            cursorQuery.close();
            return arrayMap;
        } finally {
            cursorQuery.close();
        }
    }
}
