package b.i.a.c.e3.b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.c.f3.e0;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: CachedContentIndex.java */
/* loaded from: classes3.dex */
public class j {
    public final HashMap<String, i> a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f932b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;

    @Nullable
    public c f;

    /* compiled from: CachedContentIndex.java */
    public static final class a implements c {
        public static final String[] a = {ModelAuditLogEntry.CHANGE_KEY_ID, "key", "metadata"};

        /* renamed from: b, reason: collision with root package name */
        public final b.i.a.c.u2.a f933b;
        public final SparseArray<i> c = new SparseArray<>();
        public String d;
        public String e;

        public a(b.i.a.c.u2.a aVar) {
            this.f933b = aVar;
        }

        public static void j(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
            String strValueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(strValueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf) : new String("DROP TABLE IF EXISTS "));
        }

        public static String k(String str) {
            String strValueOf = String.valueOf(str);
            return strValueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(strValueOf) : new String("ExoPlayerCacheIndex");
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void a(i iVar, boolean z2) {
            if (z2) {
                this.c.delete(iVar.a);
            } else {
                this.c.put(iVar.a, null);
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void b(HashMap<String, i> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    l(writableDatabase);
                    Iterator<i> it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.c.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void c(i iVar) {
            this.c.put(iVar.a, iVar);
        }

        @Override // b.i.a.c.e3.b0.j.c
        public boolean d() throws DatabaseIOException {
            SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
            String str = this.d;
            Objects.requireNonNull(str);
            return b.i.a.c.u2.d.a(readableDatabase, 1, str) != -1;
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void e(HashMap<String, i> map) throws IOException {
            if (this.c.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.c.size(); i++) {
                    try {
                        i iVarValueAt = this.c.valueAt(i);
                        if (iVarValueAt == null) {
                            int iKeyAt = this.c.keyAt(i);
                            String str = this.e;
                            Objects.requireNonNull(str);
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            i(writableDatabase, iVarValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.c.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void f(long j) {
            String hexString = Long.toHexString(j);
            this.d = hexString;
            this.e = k(hexString);
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void g(HashMap<String, i> map, SparseArray<String> sparseArray) throws IOException {
            b.c.a.a0.d.D(this.c.size() == 0);
            try {
                SQLiteDatabase readableDatabase = this.f933b.getReadableDatabase();
                String str = this.d;
                Objects.requireNonNull(str);
                if (b.i.a.c.u2.d.a(readableDatabase, 1, str) != 1) {
                    SQLiteDatabase writableDatabase = this.f933b.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        l(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                SQLiteDatabase readableDatabase2 = this.f933b.getReadableDatabase();
                String str2 = this.e;
                Objects.requireNonNull(str2);
                Cursor cursorQuery = readableDatabase2.query(str2, a, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        Objects.requireNonNull(string);
                        map.put(string, new i(i, string, j.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                        sparseArray.put(i, string);
                    } finally {
                    }
                }
                cursorQuery.close();
            } catch (SQLiteException e) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e);
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void h() throws DatabaseIOException {
            b.i.a.c.u2.a aVar = this.f933b;
            String str = this.d;
            Objects.requireNonNull(str);
            try {
                String strK = k(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i = b.i.a.c.u2.d.a;
                    try {
                        if (e0.J(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        j(writableDatabase, strK);
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e) {
                        throw new DatabaseIOException(e);
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase, i iVar) throws IOException, SQLException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j.b(iVar.e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_ID, Integer.valueOf(iVar.a));
            contentValues.put("key", iVar.f930b);
            contentValues.put("metadata", byteArray);
            String str = this.e;
            Objects.requireNonNull(str);
            sQLiteDatabase.replaceOrThrow(str, null, contentValues);
        }

        public final void l(SQLiteDatabase sQLiteDatabase) throws SQLException, DatabaseIOException {
            String str = this.d;
            Objects.requireNonNull(str);
            b.i.a.c.u2.d.b(sQLiteDatabase, 1, str, 1);
            String str2 = this.e;
            Objects.requireNonNull(str2);
            j(sQLiteDatabase, str2);
            String str3 = this.e;
            sQLiteDatabase.execSQL(b.d.b.a.a.l(b.d.b.a.a.b(str3, 88), "CREATE TABLE ", str3, " ", "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)"));
        }
    }

    /* compiled from: CachedContentIndex.java */
    public static class b implements c {
        public final boolean a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Cipher f934b;

        @Nullable
        public final SecretKeySpec c;

        @Nullable
        public final SecureRandom d;
        public final b.i.a.c.f3.e e;
        public boolean f;

        @Nullable
        public p g;

        public b(File file, @Nullable byte[] bArr, boolean z2) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            b.c.a.a0.d.D((bArr == null && z2) ? false : true);
            if (bArr != null) {
                b.c.a.a0.d.j(bArr.length == 16);
                try {
                    if (e0.a == 18) {
                        try {
                            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                        } catch (Throwable unused) {
                        }
                        secretKeySpec = new SecretKeySpec(bArr, "AES");
                    } else {
                        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                        secretKeySpec = new SecretKeySpec(bArr, "AES");
                    }
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                b.c.a.a0.d.j(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.a = z2;
            this.f934b = cipher;
            this.c = secretKeySpec;
            this.d = z2 ? new SecureRandom() : null;
            this.e = new b.i.a.c.f3.e(file);
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void a(i iVar, boolean z2) {
            this.f = true;
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void b(HashMap<String, i> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamC = this.e.c();
                p pVar = this.g;
                if (pVar == null) {
                    this.g = new p(outputStreamC);
                } else {
                    pVar.a(outputStreamC);
                }
                p pVar2 = this.g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(pVar2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.a ? 1 : 0);
                    if (this.a) {
                        byte[] bArr = new byte[16];
                        SecureRandom secureRandom = this.d;
                        int i = e0.a;
                        secureRandom.nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.f934b.init(1, this.c, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(pVar2, this.f934b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    int i2 = 0;
                    for (i iVar : map.values()) {
                        dataOutputStream2.writeInt(iVar.a);
                        dataOutputStream2.writeUTF(iVar.f930b);
                        j.b(iVar.e, dataOutputStream2);
                        i2 += i(iVar, 2);
                    }
                    dataOutputStream2.writeInt(i2);
                    b.i.a.c.f3.e eVar = this.e;
                    Objects.requireNonNull(eVar);
                    dataOutputStream2.close();
                    eVar.f967b.delete();
                    int i3 = e0.a;
                    this.f = false;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    int i4 = e0.a;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void c(i iVar) {
            this.f = true;
        }

        @Override // b.i.a.c.e3.b0.j.c
        public boolean d() {
            return this.e.a();
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void e(HashMap<String, i> map) throws Throwable {
            if (this.f) {
                b(map);
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void f(long j) {
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        @Override // b.i.a.c.e3.b0.j.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(HashMap<String, i> map, SparseArray<String> sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            boolean z2 = true;
            b.c.a.a0.d.D(!this.f);
            if (this.e.a()) {
                DataInputStream dataInputStream2 = null;
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(this.e.b());
                        dataInputStream = new DataInputStream(bufferedInputStream);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int i = dataInputStream.readInt();
                    if (i >= 0 && i <= 2) {
                        if ((dataInputStream.readInt() & 1) != 0) {
                            if (this.f934b != null) {
                                byte[] bArr = new byte[16];
                                dataInputStream.readFully(bArr);
                                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                try {
                                    Cipher cipher = this.f934b;
                                    SecretKeySpec secretKeySpec = this.c;
                                    int i2 = e0.a;
                                    cipher.init(2, secretKeySpec, ivParameterSpec);
                                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f934b));
                                } catch (InvalidAlgorithmParameterException e) {
                                    e = e;
                                    throw new IllegalStateException(e);
                                } catch (InvalidKeyException e2) {
                                    e = e2;
                                    throw new IllegalStateException(e);
                                }
                            }
                        } else if (this.a) {
                            this.f = true;
                        }
                        int i3 = dataInputStream.readInt();
                        int i4 = 0;
                        for (int i5 = 0; i5 < i3; i5++) {
                            i iVarJ = j(i, dataInputStream);
                            map.put(iVarJ.f930b, iVarJ);
                            sparseArray.put(iVarJ.a, iVarJ.f930b);
                            i4 += i(iVarJ, i);
                        }
                        int i6 = dataInputStream.readInt();
                        boolean z3 = dataInputStream.read() == -1;
                        if (i6 == i4 && z3) {
                            int i7 = e0.a;
                            try {
                                dataInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                    int i8 = e0.a;
                    dataInputStream.close();
                } catch (IOException unused4) {
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        int i9 = e0.a;
                        dataInputStream2.close();
                    }
                    z2 = false;
                    if (z2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        int i10 = e0.a;
                        try {
                            dataInputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
                z2 = false;
            }
            if (z2) {
                map.clear();
                sparseArray.clear();
                b.i.a.c.f3.e eVar = this.e;
                eVar.a.delete();
                eVar.f967b.delete();
            }
        }

        @Override // b.i.a.c.e3.b0.j.c
        public void h() {
            b.i.a.c.f3.e eVar = this.e;
            eVar.a.delete();
            eVar.f967b.delete();
        }

        public final int i(i iVar, int i) {
            int iHashCode = iVar.f930b.hashCode() + (iVar.a * 31);
            if (i >= 2) {
                return (iHashCode * 31) + iVar.e.hashCode();
            }
            long jA = k.a(iVar.e);
            return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
        }

        public final i j(int i, DataInputStream dataInputStream) throws IOException {
            n nVarA;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                m mVar = new m();
                m.a(mVar, j);
                nVarA = n.a.a(mVar);
            } else {
                nVarA = j.a(dataInputStream);
            }
            return new i(i2, utf, nVarA);
        }
    }

    /* compiled from: CachedContentIndex.java */
    public interface c {
        void a(i iVar, boolean z2);

        void b(HashMap<String, i> map) throws IOException;

        void c(i iVar);

        boolean d() throws IOException;

        void e(HashMap<String, i> map) throws IOException;

        void f(long j);

        void g(HashMap<String, i> map, SparseArray<String> sparseArray) throws IOException;

        void h() throws IOException;
    }

    public j(@Nullable b.i.a.c.u2.a aVar, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        b.c.a.a0.d.D((aVar == null && file == null) ? false : true);
        this.a = new HashMap<>();
        this.f932b = new SparseArray<>();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (aVar2 != null && (bVar == null || !z3)) {
            this.e = aVar2;
            this.f = bVar;
        } else {
            int i = e0.a;
            this.e = bVar;
            this.f = aVar2;
        }
    }

    public static n a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException(b.d.b.a.a.g(31, "Invalid value size: ", i3));
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = e0.f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new n(map);
    }

    public static void b(n nVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setEntrySet = nVar.c.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry<String, byte[]> entry : setEntrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    public i c(String str) {
        return this.a.get(str);
    }

    public i d(String str) {
        i iVar = this.a.get(str);
        if (iVar != null) {
            return iVar;
        }
        SparseArray<String> sparseArray = this.f932b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        i iVar2 = new i(iKeyAt, str, n.a);
        this.a.put(str, iVar2);
        this.f932b.put(iKeyAt, str);
        this.d.put(iKeyAt, true);
        this.e.c(iVar2);
        return iVar2;
    }

    @WorkerThread
    public void e(long j) throws IOException {
        c cVar;
        this.e.f(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.f(j);
        }
        if (this.e.d() || (cVar = this.f) == null || !cVar.d()) {
            this.e.g(this.a, this.f932b);
        } else {
            this.f.g(this.a, this.f932b);
            this.e.b(this.a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.h();
            this.f = null;
        }
    }

    public void f(String str) {
        i iVar = this.a.get(str);
        if (iVar != null && iVar.c.isEmpty() && iVar.d.isEmpty()) {
            this.a.remove(str);
            int i = iVar.a;
            boolean z2 = this.d.get(i);
            this.e.a(iVar, z2);
            if (z2) {
                this.f932b.remove(i);
                this.d.delete(i);
            } else {
                this.f932b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    @WorkerThread
    public void g() throws IOException {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.f932b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
