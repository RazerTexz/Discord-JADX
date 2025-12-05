package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* compiled from: SQLiteEventStore.java */
@WorkerThread
/* renamed from: b.i.a.b.j.t.i.t */
/* loaded from: classes3.dex */
public class C2511t implements EventStore, SynchronizationGuard {

    /* renamed from: j */
    public static final Encoding2 f5441j = new Encoding2("proto");

    /* renamed from: k */
    public final SchemaManager5 f5442k;

    /* renamed from: l */
    public final Clock3 f5443l;

    /* renamed from: m */
    public final Clock3 f5444m;

    /* renamed from: n */
    public final EventStoreConfig f5445n;

    /* compiled from: SQLiteEventStore.java */
    /* renamed from: b.i.a.b.j.t.i.t$b */
    public interface b<T, U> {
        U apply(T t);
    }

    /* compiled from: SQLiteEventStore.java */
    /* renamed from: b.i.a.b.j.t.i.t$c */
    public static class c {

        /* renamed from: a */
        public final String f5446a;

        /* renamed from: b */
        public final String f5447b;

        public c(String str, String str2, a aVar) {
            this.f5446a = str;
            this.f5447b = str2;
        }
    }

    /* compiled from: SQLiteEventStore.java */
    /* renamed from: b.i.a.b.j.t.i.t$d */
    public interface d<T> {
        /* renamed from: a */
        T mo2403a();
    }

    public C2511t(Clock3 clock3, Clock3 clock32, EventStoreConfig eventStoreConfig, SchemaManager5 schemaManager5) {
        this.f5442k = schemaManager5;
        this.f5443l = clock3;
        this.f5444m = clock32;
        this.f5445n = eventStoreConfig;
    }

    /* renamed from: f */
    public static String m2404f(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo2392b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: n */
    public static <T> T m2405n(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard
    /* renamed from: a */
    public <T> T mo2406a(SynchronizationGuard.a<T> aVar) {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        m2410e(new C2504m(sQLiteDatabaseM2407b), C2505n.f5433a);
        try {
            T tExecute = aVar.execute();
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    @Nullable
    /* renamed from: a0 */
    public PersistedEvent mo2394a0(TransportContext transportContext, EventInternal eventInternal) {
        AnimatableValueParser.m489Y("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.mo2350d(), eventInternal.mo2340g(), transportContext.mo2348b());
        long jLongValue = ((Long) m2409d(new C2510s(this, transportContext, eventInternal))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return new AutoValue_PersistedEvent(jLongValue, transportContext, eventInternal);
    }

    @VisibleForTesting
    /* renamed from: b */
    public SQLiteDatabase m2407b() {
        SchemaManager5 schemaManager5 = this.f5442k;
        schemaManager5.getClass();
        return (SQLiteDatabase) m2410e(new C2506o(schemaManager5), C2509r.f5437a);
    }

    @Nullable
    /* renamed from: c */
    public final Long m2408c(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.mo2348b(), String.valueOf(PriorityMapping.m2414a(transportContext.mo2350d()))));
        if (transportContext.mo2349c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.mo2349c(), 0));
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5442k.close();
    }

    /* renamed from: d */
    public final <T> T m2409d(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseM2407b);
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }

    /* renamed from: e */
    public final <T> T m2410e(d<T> dVar, b<Throwable, T> bVar) {
        long jMo2413a = this.f5444m.mo2413a();
        while (true) {
            try {
                return dVar.mo2403a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f5444m.mo2413a() >= this.f5445n.mo2386a() + jMo2413a) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: h0 */
    public long mo2395h0(TransportContext transportContext) {
        Cursor cursorRawQuery = m2407b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.mo2348b(), String.valueOf(PriorityMapping.m2414a(transportContext.mo2350d()))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            return lValueOf.longValue();
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: l */
    public int mo2396l() {
        long jMo2413a = this.f5443l.mo2413a() - this.f5445n.mo2387b();
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            Integer numValueOf = Integer.valueOf(sQLiteDatabaseM2407b.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jMo2413a)}));
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            sQLiteDatabaseM2407b.endTransaction();
            return numValueOf.intValue();
        } catch (Throwable th) {
            sQLiteDatabaseM2407b.endTransaction();
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: l0 */
    public boolean mo2397l0(TransportContext transportContext) {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            Long lM2408c = m2408c(sQLiteDatabaseM2407b, transportContext);
            Boolean bool = lM2408c == null ? Boolean.FALSE : (Boolean) m2405n(m2407b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lM2408c.toString()}), C2508q.f5436a);
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            sQLiteDatabaseM2407b.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            sQLiteDatabaseM2407b.endTransaction();
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: m */
    public void mo2398m(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbM833U = outline.m833U("DELETE FROM events WHERE _id in ");
            sbM833U.append(m2404f(iterable));
            m2407b().compileStatement(sbM833U.toString()).execute();
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: n0 */
    public void mo2399n0(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbM833U = outline.m833U("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            sbM833U.append(m2404f(iterable));
            String string = sbM833U.toString();
            SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
            sQLiteDatabaseM2407b.beginTransaction();
            try {
                sQLiteDatabaseM2407b.compileStatement(string).execute();
                sQLiteDatabaseM2407b.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseM2407b.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseM2407b.endTransaction();
            }
        }
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: r */
    public Iterable<PersistedEvent> mo2400r(TransportContext transportContext) {
        return (Iterable) m2409d(new C2501j(this, transportContext));
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: v */
    public void mo2401v(TransportContext transportContext, long j) {
        m2409d(new C2500i(j, transportContext));
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore
    /* renamed from: z */
    public Iterable<TransportContext> mo2402z() {
        SQLiteDatabase sQLiteDatabaseM2407b = m2407b();
        sQLiteDatabaseM2407b.beginTransaction();
        try {
            List list = (List) m2405n(sQLiteDatabaseM2407b.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C2507p.f5435a);
            sQLiteDatabaseM2407b.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseM2407b.endTransaction();
        }
    }
}
