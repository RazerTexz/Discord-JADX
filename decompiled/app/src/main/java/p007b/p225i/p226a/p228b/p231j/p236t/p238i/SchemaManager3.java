package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.x, reason: use source file name */
/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SchemaManager3 implements SchemaManager5.a {

    /* JADX INFO: renamed from: a */
    public static final SchemaManager3 f5454a = new SchemaManager3();

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager5.a
    /* JADX INFO: renamed from: a */
    public void mo2411a(SQLiteDatabase sQLiteDatabase) {
        List<SchemaManager5.a> list = SchemaManager5.f5456j;
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
