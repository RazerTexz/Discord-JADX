package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p242c.p264u2.DatabaseProvider;
import p007b.p225i.p226a.p242c.p264u2.VersionTable;

/* compiled from: CacheFileMetadataIndex.java */
/* renamed from: b.i.a.c.e3.b0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class CacheFileMetadataIndex {

    /* renamed from: a */
    public static final String[] f6461a = {ModelAuditLogEntry.CHANGE_KEY_NAME, "length", "last_touch_timestamp"};

    /* renamed from: b */
    public final DatabaseProvider f6462b;

    /* renamed from: c */
    public String f6463c;

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider) {
        this.f6462b = databaseProvider;
    }

    @WorkerThread
    /* renamed from: a */
    public Map<String, CacheFileMetadata> m2787a() throws DatabaseIOException {
        try {
            Objects.requireNonNull(this.f6463c);
            Cursor cursorQuery = this.f6462b.getReadableDatabase().query(this.f6463c, f6461a, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    Objects.requireNonNull(string);
                    map.put(string, new CacheFileMetadata(cursorQuery.getLong(1), cursorQuery.getLong(2)));
                }
                cursorQuery.close();
                return map;
            } finally {
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    /* renamed from: b */
    public void m2788b(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            String strValueOf = String.valueOf(hexString);
            this.f6463c = strValueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(strValueOf) : new String("ExoPlayerCacheFileMetadata");
            if (VersionTable.m3545a(this.f6462b.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.m3546b(writableDatabase, 2, hexString, 1);
                    String strValueOf2 = String.valueOf(this.f6463c);
                    writableDatabase.execSQL(strValueOf2.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf2) : new String("DROP TABLE IF EXISTS "));
                    String str = this.f6463c;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 108);
                    sb.append("CREATE TABLE ");
                    sb.append(str);
                    sb.append(" ");
                    sb.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.execSQL(sb.toString());
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    /* renamed from: c */
    public void m2789c(Set<String> set) throws DatabaseIOException {
        Objects.requireNonNull(this.f6463c);
        try {
            SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f6463c, "name = ?", new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    /* renamed from: d */
    public void m2790d(String str, long j, long j2) throws DatabaseIOException {
        Objects.requireNonNull(this.f6463c);
        try {
            SQLiteDatabase writableDatabase = this.f6462b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.f6463c, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
