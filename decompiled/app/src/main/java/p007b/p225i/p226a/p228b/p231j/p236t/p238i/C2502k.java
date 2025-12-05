package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.Cursor;
import java.util.HashMap;
import java.util.List;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.AutoValue_EventInternal;
import p007b.p225i.p226a.p228b.p231j.EncodedPayload;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;

/* compiled from: SQLiteEventStore.java */
/* renamed from: b.i.a.b.j.t.i.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2502k implements C2511t.b {

    /* renamed from: a */
    public final C2511t f5428a;

    /* renamed from: b */
    public final List f5429b;

    /* renamed from: c */
    public final TransportContext f5430c;

    public C2502k(C2511t c2511t, List list, TransportContext transportContext) {
        this.f5428a = c2511t;
        this.f5429b = list;
        this.f5430c = transportContext;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        C2511t c2511t = this.f5428a;
        List list = this.f5429b;
        TransportContext transportContext = this.f5430c;
        Cursor cursor = (Cursor) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z2 = cursor.getInt(7) != 0;
            AutoValue_EventInternal.b bVar = new AutoValue_EventInternal.b();
            bVar.f5257f = new HashMap();
            bVar.m2346f(cursor.getString(1));
            bVar.m2345e(cursor.getLong(2));
            bVar.m2347g(cursor.getLong(3));
            if (z2) {
                String string = cursor.getString(4);
                bVar.m2344d(new EncodedPayload(string == null ? C2511t.f5441j : new Encoding2(string), cursor.getBlob(5)));
            } else {
                String string2 = cursor.getString(4);
                bVar.m2344d(new EncodedPayload(string2 == null ? C2511t.f5441j : new Encoding2(string2), (byte[]) C2511t.m2405n(c2511t.m2407b().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), C2503l.f5431a)));
            }
            if (!cursor.isNull(6)) {
                bVar.f5253b = Integer.valueOf(cursor.getInt(6));
            }
            list.add(new AutoValue_PersistedEvent(j, transportContext, bVar.mo2342b()));
        }
        return null;
    }
}
