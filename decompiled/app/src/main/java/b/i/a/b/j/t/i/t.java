package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import b.i.a.b.j.u.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: SQLiteEventStore.java */
@WorkerThread
/* loaded from: classes3.dex */
public class t implements b.i.a.b.j.t.i.c, b.i.a.b.j.u.a {
    public static final b.i.a.b.b j = new b.i.a.b.b("proto");
    public final z k;
    public final b.i.a.b.j.v.a l;
    public final b.i.a.b.j.v.a m;
    public final b.i.a.b.j.t.i.d n;

    /* compiled from: SQLiteEventStore.java */
    public interface b<T, U> {
        U apply(T t);
    }

    /* compiled from: SQLiteEventStore.java */
    public static class c {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f802b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.f802b = str2;
        }
    }

    /* compiled from: SQLiteEventStore.java */
    public interface d<T> {
        T a();
    }

    public t(b.i.a.b.j.v.a aVar, b.i.a.b.j.v.a aVar2, b.i.a.b.j.t.i.d dVar, z zVar) {
        this.k = zVar;
        this.l = aVar;
        this.m = aVar2;
        this.n = dVar;
    }

    public static String f(Iterable<h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T n(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // b.i.a.b.j.u.a
    public <T> T a(a.InterfaceC0091a<T> interfaceC0091a) {
        SQLiteDatabase sQLiteDatabaseB = b();
        e(new m(sQLiteDatabaseB), n.a);
        try {
            T tExecute = interfaceC0091a.execute();
            sQLiteDatabaseB.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    @Override // b.i.a.b.j.t.i.c
    @Nullable
    public h a0(b.i.a.b.j.i iVar, b.i.a.b.j.f fVar) {
        b.c.a.a0.d.Y("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", iVar.d(), fVar.g(), iVar.b());
        long jLongValue = ((Long) d(new s(this, iVar, fVar))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return new b.i.a.b.j.t.i.b(jLongValue, iVar, fVar);
    }

    @VisibleForTesting
    public SQLiteDatabase b() {
        z zVar = this.k;
        zVar.getClass();
        return (SQLiteDatabase) e(new o(zVar), r.a);
    }

    @Nullable
    public final Long c(SQLiteDatabase sQLiteDatabase, b.i.a.b.j.i iVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.b(), String.valueOf(b.i.a.b.j.w.a.a(iVar.d()))));
        if (iVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(iVar.c(), 0));
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
        this.k.close();
    }

    public final <T> T d(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseB);
            sQLiteDatabaseB.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }

    public final <T> T e(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.m.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.m.a() >= this.n.a() + jA) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public long h0(b.i.a.b.j.i iVar) {
        Cursor cursorRawQuery = b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{iVar.b(), String.valueOf(b.i.a.b.j.w.a.a(iVar.d()))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            return lValueOf.longValue();
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public int l() {
        long jA = this.l.a() - this.n.b();
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Integer numValueOf = Integer.valueOf(sQLiteDatabaseB.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jA)}));
            sQLiteDatabaseB.setTransactionSuccessful();
            sQLiteDatabaseB.endTransaction();
            return numValueOf.intValue();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public boolean l0(b.i.a.b.j.i iVar) {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            Long lC = c(sQLiteDatabaseB, iVar);
            Boolean bool = lC == null ? Boolean.FALSE : (Boolean) n(b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC.toString()}), q.a);
            sQLiteDatabaseB.setTransactionSuccessful();
            sQLiteDatabaseB.endTransaction();
            return bool.booleanValue();
        } catch (Throwable th) {
            sQLiteDatabaseB.endTransaction();
            throw th;
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public void m(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = b.d.b.a.a.U("DELETE FROM events WHERE _id in ");
            sbU.append(f(iterable));
            b().compileStatement(sbU.toString()).execute();
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public void n0(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder sbU = b.d.b.a.a.U("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
            sbU.append(f(iterable));
            String string = sbU.toString();
            SQLiteDatabase sQLiteDatabaseB = b();
            sQLiteDatabaseB.beginTransaction();
            try {
                sQLiteDatabaseB.compileStatement(string).execute();
                sQLiteDatabaseB.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseB.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseB.endTransaction();
            }
        }
    }

    @Override // b.i.a.b.j.t.i.c
    public Iterable<h> r(b.i.a.b.j.i iVar) {
        return (Iterable) d(new j(this, iVar));
    }

    @Override // b.i.a.b.j.t.i.c
    public void v(b.i.a.b.j.i iVar, long j2) {
        d(new i(j2, iVar));
    }

    @Override // b.i.a.b.j.t.i.c
    public Iterable<b.i.a.b.j.i> z() {
        SQLiteDatabase sQLiteDatabaseB = b();
        sQLiteDatabaseB.beginTransaction();
        try {
            List list = (List) n(sQLiteDatabaseB.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a);
            sQLiteDatabaseB.setTransactionSuccessful();
            return list;
        } finally {
            sQLiteDatabaseB.endTransaction();
        }
    }
}
