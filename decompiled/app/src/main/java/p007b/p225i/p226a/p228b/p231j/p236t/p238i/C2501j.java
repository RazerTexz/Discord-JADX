package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;

/* compiled from: SQLiteEventStore.java */
/* renamed from: b.i.a.b.j.t.i.j */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2501j implements C2511t.b {

    /* renamed from: a */
    public final C2511t f5426a;

    /* renamed from: b */
    public final TransportContext f5427b;

    public C2501j(C2511t c2511t, TransportContext transportContext) {
        this.f5426a = c2511t;
        this.f5427b = transportContext;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t.b
    public Object apply(Object obj) {
        C2511t c2511t = this.f5426a;
        TransportContext transportContext = this.f5427b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding2 encoding2 = C2511t.f5441j;
        Objects.requireNonNull(c2511t);
        ArrayList arrayList = new ArrayList();
        Long lM2408c = c2511t.m2408c(sQLiteDatabase, transportContext);
        if (lM2408c != null) {
            C2511t.m2405n(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", ModelAuditLogEntry.CHANGE_KEY_CODE, "inline"}, "context_id = ?", new String[]{lM2408c.toString()}, null, null, null, String.valueOf(c2511t.f5445n.mo2388c())), new C2502k(c2511t, arrayList, transportContext));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((PersistedEvent) arrayList.get(i)).mo2392b());
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", ModelAuditLogEntry.CHANGE_KEY_NAME, "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new C2511t.c(cursorQuery.getString(1), cursorQuery.getString(2), null));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent persistedEvent = (PersistedEvent) listIterator.next();
            if (map.containsKey(Long.valueOf(persistedEvent.mo2392b()))) {
                EventInternal.a aVarM2356i = persistedEvent.mo2391a().m2356i();
                for (C2511t.c cVar : (Set) map.get(Long.valueOf(persistedEvent.mo2392b()))) {
                    aVarM2356i.m2357a(cVar.f5446a, cVar.f5447b);
                }
                listIterator.set(new AutoValue_PersistedEvent(persistedEvent.mo2392b(), persistedEvent.mo2393c(), aVarM2356i.mo2342b()));
            }
        }
        return arrayList;
    }
}
