package b.i.a.b.j.t.i;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import b.i.a.b.j.t.i.z;
import java.util.List;

/* compiled from: SchemaManager.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class x implements z.a {
    public static final x a = new x();

    @Override // b.i.a.b.j.t.i.z.a
    public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        List<z.a> list = z.j;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
