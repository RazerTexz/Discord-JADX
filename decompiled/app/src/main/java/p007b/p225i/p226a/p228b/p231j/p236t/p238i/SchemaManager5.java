package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: SchemaManager.java */
/* renamed from: b.i.a.b.j.t.i.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class SchemaManager5 extends SQLiteOpenHelper {

    /* renamed from: j */
    public static final List<a> f5456j = Arrays.asList(SchemaManager.f5452a, SchemaManager2.f5453a, SchemaManager3.f5454a, SchemaManager4.f5455a);

    /* renamed from: k */
    public final int f5457k;

    /* renamed from: l */
    public boolean f5458l;

    /* compiled from: SchemaManager.java */
    /* renamed from: b.i.a.b.j.t.i.z$a */
    public interface a {
        /* renamed from: a */
        void mo2411a(SQLiteDatabase sQLiteDatabase);
    }

    public SchemaManager5(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f5458l = false;
        this.f5457k = i;
    }

    /* renamed from: a */
    public final void m2412a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<a> list = f5456j;
        if (i2 <= list.size()) {
            while (i < i2) {
                f5456j.get(i).mo2411a(sQLiteDatabase);
                i++;
            }
        } else {
            StringBuilder sbM835W = outline.m835W("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
            sbM835W.append(list.size());
            sbM835W.append(" migrations are provided");
            throw new IllegalArgumentException(sbM835W.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f5458l = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.f5457k;
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, 0, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f5458l) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.f5458l) {
            onConfigure(sQLiteDatabase);
        }
        m2412a(sQLiteDatabase, i, i2);
    }
}
