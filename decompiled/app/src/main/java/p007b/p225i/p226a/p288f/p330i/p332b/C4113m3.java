package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.m3 */
/* loaded from: classes3.dex */
public final class C4113m3 extends AbstractC3974a5 {

    /* renamed from: c */
    public final C4146p3 f10961c;

    /* renamed from: d */
    public boolean f10962d;

    public C4113m3(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10961c = new C4146p3(this, this.f11202a.f11254b, "google_app_measurement_local.db");
    }

    /* renamed from: w */
    public static long m5753w(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j = cursorQuery.getLong(0);
            cursorQuery.close();
            return j;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* renamed from: A */
    public final SQLiteDatabase m5754A() throws SQLiteException {
        if (this.f10962d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f10961c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f10962d = true;
        return null;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* renamed from: v */
    public final boolean mo5499v() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0121  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @WorkerThread
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5755x(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabaseM5754A;
        Cursor cursor;
        mo5848b();
        ?? r2 = 0;
        if (this.f10962d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            Cursor cursor2 = null;
            cursor = null;
            cursor2 = null;
            Cursor cursor3 = null;
            Cursor cursor4 = null;
            cursor2 = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseM5754A = m5754A();
                try {
                    if (sQLiteDatabaseM5754A == null) {
                        this.f10962d = true;
                        if (sQLiteDatabaseM5754A != null) {
                            sQLiteDatabaseM5754A.close();
                        }
                        return r2;
                    }
                    sQLiteDatabaseM5754A.beginTransaction();
                    long j = 0;
                    Cursor cursorRawQuery = sQLiteDatabaseM5754A.rawQuery("select count(1) from messages", null);
                    if (cursorRawQuery != 0) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                j = cursorRawQuery.getLong(r2);
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            cursor4 = cursorRawQuery;
                            SystemClock.sleep(i3);
                            i3 += 20;
                            if (cursor4 != null) {
                                cursor4.close();
                            }
                            if (sQLiteDatabaseM5754A != null) {
                                sQLiteDatabaseM5754A.close();
                            }
                            i2++;
                            r2 = 0;
                        } catch (SQLiteFullException e) {
                            e = e;
                            cursor2 = cursorRawQuery;
                            try {
                                mo5726g().f11141f.m5861b("Error writing entry; local database full", e);
                                this.f10962d = true;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (sQLiteDatabaseM5754A != null) {
                                    sQLiteDatabaseM5754A.close();
                                }
                                i2++;
                                r2 = 0;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabaseM5754A != null) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor3 = cursorRawQuery;
                            cursor = cursor3;
                            sQLiteDatabase = sQLiteDatabaseM5754A;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseM5754A = sQLiteDatabase;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseM5754A != null) {
                                        sQLiteDatabaseM5754A.close();
                                    }
                                    throw th;
                                }
                            }
                            mo5726g().f11141f.m5861b("Error writing entry to local database", e);
                            this.f10962d = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            r2 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursorRawQuery;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabaseM5754A != null) {
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        mo5726g().f11141f.m5860a("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        strArr[r2] = Long.toString(j2);
                        long jDelete = sQLiteDatabaseM5754A.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (jDelete != j2) {
                            mo5726g().f11141f.m5863d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                        }
                    }
                    sQLiteDatabaseM5754A.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseM5754A.setTransactionSuccessful();
                    sQLiteDatabaseM5754A.endTransaction();
                    if (cursorRawQuery != 0) {
                        cursorRawQuery.close();
                    }
                    sQLiteDatabaseM5754A.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e3) {
                    e = e3;
                } catch (SQLiteException e4) {
                    e = e4;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseM5754A = null;
            } catch (SQLiteFullException e5) {
                e = e5;
                sQLiteDatabaseM5754A = null;
            } catch (SQLiteException e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseM5754A = null;
            }
        }
        mo5726g().f11149n.m5860a("Failed to write entry to local database");
        return false;
    }

    @WorkerThread
    /* renamed from: y */
    public final void m5756y() {
        mo5848b();
        try {
            int iDelete = m5754A().delete("messages", null, null) + 0;
            if (iDelete > 0) {
                mo5726g().f11149n.m5861b("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            mo5726g().f11141f.m5861b("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    /* renamed from: z */
    public final boolean m5757z() {
        mo5848b();
        if (this.f10962d || !this.f11202a.f11254b.getDatabasePath("google_app_measurement_local.db").exists()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabaseM5754A = m5754A();
                if (sQLiteDatabaseM5754A == null) {
                    this.f10962d = true;
                    if (sQLiteDatabaseM5754A != null) {
                        sQLiteDatabaseM5754A.close();
                    }
                    return false;
                }
                sQLiteDatabaseM5754A.beginTransaction();
                sQLiteDatabaseM5754A.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabaseM5754A.setTransactionSuccessful();
                sQLiteDatabaseM5754A.endTransaction();
                sQLiteDatabaseM5754A.close();
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e) {
                mo5726g().f11141f.m5861b("Error deleting app launch break from local database", e);
                this.f10962d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                mo5726g().f11141f.m5861b("Error deleting app launch break from local database", e2);
                this.f10962d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        mo5726g().f11144i.m5860a("Error deleting app launch break from local database in reasonable time");
        return false;
    }
}
