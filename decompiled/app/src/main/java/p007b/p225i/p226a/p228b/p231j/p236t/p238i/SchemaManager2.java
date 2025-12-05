package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.w, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager2 implements SchemaManager5.a {

    /* renamed from: a */
    public static final SchemaManager2 f5453a = new SchemaManager2();

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5.a
    /* renamed from: a */
    public void mo2411a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        List<SchemaManager5.a> list = SchemaManager5.f5456j;
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }
}
