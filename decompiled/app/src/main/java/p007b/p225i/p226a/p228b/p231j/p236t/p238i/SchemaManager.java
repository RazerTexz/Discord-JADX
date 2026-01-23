package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.v, reason: use source file name */
/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager implements SchemaManager5.a {

    /* JADX INFO: renamed from: a */
    public static final SchemaManager f5452a = new SchemaManager();

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5.a
    /* JADX INFO: renamed from: a */
    public void mo2411a(SQLiteDatabase sQLiteDatabase) {
        List<SchemaManager5.a> list = SchemaManager5.f5456j;
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }
}
