package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.AtomicFile3;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p264u2.DatabaseProvider;
import p007b.p225i.p226a.p242c.p264u2.VersionTable;

/* compiled from: CachedContentIndex.java */
/* renamed from: b.i.a.c.e3.b0.j, reason: use source file name */
/* loaded from: classes3.dex */
public class CachedContentIndex {

    /* renamed from: a */
    public final HashMap<String, CachedContent> f6478a;

    /* renamed from: b */
    public final SparseArray<String> f6479b;

    /* renamed from: c */
    public final SparseBooleanArray f6480c;

    /* renamed from: d */
    public final SparseBooleanArray f6481d;

    /* renamed from: e */
    public c f6482e;

    /* renamed from: f */
    @Nullable
    public c f6483f;

    /* compiled from: CachedContentIndex.java */
    /* renamed from: b.i.a.c.e3.b0.j$a */
    public static final class a implements c {

        /* renamed from: a */
        public static final String[] f6484a = {ModelAuditLogEntry.CHANGE_KEY_ID, "key", "metadata"};

        /* renamed from: b */
        public final DatabaseProvider f6485b;

        /* renamed from: c */
        public final SparseArray<CachedContent> f6486c = new SparseArray<>();

        /* renamed from: d */
        public String f6487d;

        /* renamed from: e */
        public String f6488e;

        public a(DatabaseProvider databaseProvider) {
            this.f6485b = databaseProvider;
        }

        /* renamed from: j */
        public static void m2800j(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
            String strValueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(strValueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(strValueOf) : new String("DROP TABLE IF EXISTS "));
        }

        /* renamed from: k */
        public static String m2801k(String str) {
            String strValueOf = String.valueOf(str);
            return strValueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(strValueOf) : new String("ExoPlayerCacheIndex");
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: a */
        public void mo2802a(CachedContent cachedContent, boolean z2) {
            if (z2) {
                this.f6486c.delete(cachedContent.f6471a);
            } else {
                this.f6486c.put(cachedContent.f6471a, null);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: b */
        public void mo2803b(HashMap<String, CachedContent> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    m2811l(writableDatabase);
                    Iterator<CachedContent> it = map.values().iterator();
                    while (it.hasNext()) {
                        m2810i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f6486c.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: c */
        public void mo2804c(CachedContent cachedContent) {
            this.f6486c.put(cachedContent.f6471a, cachedContent);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: d */
        public boolean mo2805d() throws DatabaseIOException {
            SQLiteDatabase readableDatabase = this.f6485b.getReadableDatabase();
            String str = this.f6487d;
            Objects.requireNonNull(str);
            return VersionTable.m3545a(readableDatabase, 1, str) != -1;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: e */
        public void mo2806e(HashMap<String, CachedContent> map) throws IOException {
            if (this.f6486c.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.f6486c.size(); i++) {
                    try {
                        CachedContent cachedContentValueAt = this.f6486c.valueAt(i);
                        if (cachedContentValueAt == null) {
                            int iKeyAt = this.f6486c.keyAt(i);
                            String str = this.f6488e;
                            Objects.requireNonNull(str);
                            writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                        } else {
                            m2810i(writableDatabase, cachedContentValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f6486c.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: f */
        public void mo2807f(long j) {
            String hexString = Long.toHexString(j);
            this.f6487d = hexString;
            this.f6488e = m2801k(hexString);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: g */
        public void mo2808g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException {
            AnimatableValueParser.m426D(this.f6486c.size() == 0);
            try {
                SQLiteDatabase readableDatabase = this.f6485b.getReadableDatabase();
                String str = this.f6487d;
                Objects.requireNonNull(str);
                if (VersionTable.m3545a(readableDatabase, 1, str) != 1) {
                    SQLiteDatabase writableDatabase = this.f6485b.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        m2811l(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                SQLiteDatabase readableDatabase2 = this.f6485b.getReadableDatabase();
                String str2 = this.f6488e;
                Objects.requireNonNull(str2);
                Cursor cursorQuery = readableDatabase2.query(str2, f6484a, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(0);
                        String string = cursorQuery.getString(1);
                        Objects.requireNonNull(string);
                        map.put(string, new CachedContent(i, string, CachedContentIndex.m2793a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
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

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: h */
        public void mo2809h() throws DatabaseIOException {
            DatabaseProvider databaseProvider = this.f6485b;
            String str = this.f6487d;
            Objects.requireNonNull(str);
            try {
                String strM2801k = m2801k(str);
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int i = VersionTable.f7887a;
                    try {
                        if (Util2.m2989J(writableDatabase, "ExoPlayerVersions")) {
                            writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                        }
                        m2800j(writableDatabase, strM2801k);
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

        /* renamed from: i */
        public final void m2810i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException, SQLException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.m2794b(cachedContent.f6475e, new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ModelAuditLogEntry.CHANGE_KEY_ID, Integer.valueOf(cachedContent.f6471a));
            contentValues.put("key", cachedContent.f6472b);
            contentValues.put("metadata", byteArray);
            String str = this.f6488e;
            Objects.requireNonNull(str);
            sQLiteDatabase.replaceOrThrow(str, null, contentValues);
        }

        /* renamed from: l */
        public final void m2811l(SQLiteDatabase sQLiteDatabase) throws SQLException, DatabaseIOException {
            String str = this.f6487d;
            Objects.requireNonNull(str);
            VersionTable.m3546b(sQLiteDatabase, 1, str, 1);
            String str2 = this.f6488e;
            Objects.requireNonNull(str2);
            m2800j(sQLiteDatabase, str2);
            String str3 = this.f6488e;
            sQLiteDatabase.execSQL(outline.m861l(outline.m841b(str3, 88), "CREATE TABLE ", str3, " ", "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)"));
        }
    }

    /* compiled from: CachedContentIndex.java */
    /* renamed from: b.i.a.c.e3.b0.j$b */
    public static class b implements c {

        /* renamed from: a */
        public final boolean f6489a;

        /* renamed from: b */
        @Nullable
        public final Cipher f6490b;

        /* renamed from: c */
        @Nullable
        public final SecretKeySpec f6491c;

        /* renamed from: d */
        @Nullable
        public final SecureRandom f6492d;

        /* renamed from: e */
        public final AtomicFile3 f6493e;

        /* renamed from: f */
        public boolean f6494f;

        /* renamed from: g */
        @Nullable
        public ReusableBufferedOutputStream f6495g;

        public b(File file, @Nullable byte[] bArr, boolean z2) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            AnimatableValueParser.m426D((bArr == null && z2) ? false : true);
            if (bArr != null) {
                AnimatableValueParser.m531j(bArr.length == 16);
                try {
                    if (Util2.f6708a == 18) {
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
                AnimatableValueParser.m531j(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.f6489a = z2;
            this.f6490b = cipher;
            this.f6491c = secretKeySpec;
            this.f6492d = z2 ? new SecureRandom() : null;
            this.f6493e = new AtomicFile3(file);
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: a */
        public void mo2802a(CachedContent cachedContent, boolean z2) {
            this.f6494f = true;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: b */
        public void mo2803b(HashMap<String, CachedContent> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamM2979c = this.f6493e.m2979c();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.f6495g;
                if (reusableBufferedOutputStream == null) {
                    this.f6495g = new ReusableBufferedOutputStream(outputStreamM2979c);
                } else {
                    reusableBufferedOutputStream.m2822a(outputStreamM2979c);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.f6495g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    dataOutputStream2.writeInt(this.f6489a ? 1 : 0);
                    if (this.f6489a) {
                        byte[] bArr = new byte[16];
                        SecureRandom secureRandom = this.f6492d;
                        int i = Util2.f6708a;
                        secureRandom.nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            this.f6490b.init(1, this.f6491c, new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.f6490b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    int iM2812i = 0;
                    for (CachedContent cachedContent : map.values()) {
                        dataOutputStream2.writeInt(cachedContent.f6471a);
                        dataOutputStream2.writeUTF(cachedContent.f6472b);
                        CachedContentIndex.m2794b(cachedContent.f6475e, dataOutputStream2);
                        iM2812i += m2812i(cachedContent, 2);
                    }
                    dataOutputStream2.writeInt(iM2812i);
                    AtomicFile3 atomicFile3 = this.f6493e;
                    Objects.requireNonNull(atomicFile3);
                    dataOutputStream2.close();
                    atomicFile3.f6705b.delete();
                    int i2 = Util2.f6708a;
                    this.f6494f = false;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    int i3 = Util2.f6708a;
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

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: c */
        public void mo2804c(CachedContent cachedContent) {
            this.f6494f = true;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: d */
        public boolean mo2805d() {
            return this.f6493e.m2977a();
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: e */
        public void mo2806e(HashMap<String, CachedContent> map) throws Throwable {
            if (this.f6494f) {
                mo2803b(map);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: f */
        public void mo2807f(long j) {
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo2808g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            boolean z2 = true;
            AnimatableValueParser.m426D(!this.f6494f);
            if (this.f6493e.m2977a()) {
                DataInputStream dataInputStream2 = null;
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(this.f6493e.m2978b());
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
                            if (this.f6490b != null) {
                                byte[] bArr = new byte[16];
                                dataInputStream.readFully(bArr);
                                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                                try {
                                    Cipher cipher = this.f6490b;
                                    SecretKeySpec secretKeySpec = this.f6491c;
                                    int i2 = Util2.f6708a;
                                    cipher.init(2, secretKeySpec, ivParameterSpec);
                                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f6490b));
                                } catch (InvalidAlgorithmParameterException e) {
                                    e = e;
                                    throw new IllegalStateException(e);
                                } catch (InvalidKeyException e2) {
                                    e = e2;
                                    throw new IllegalStateException(e);
                                }
                            }
                        } else if (this.f6489a) {
                            this.f6494f = true;
                        }
                        int i3 = dataInputStream.readInt();
                        int iM2812i = 0;
                        for (int i4 = 0; i4 < i3; i4++) {
                            CachedContent cachedContentM2813j = m2813j(i, dataInputStream);
                            map.put(cachedContentM2813j.f6472b, cachedContentM2813j);
                            sparseArray.put(cachedContentM2813j.f6471a, cachedContentM2813j.f6472b);
                            iM2812i += m2812i(cachedContentM2813j, i);
                        }
                        int i5 = dataInputStream.readInt();
                        boolean z3 = dataInputStream.read() == -1;
                        if (i5 == iM2812i && z3) {
                            int i6 = Util2.f6708a;
                            try {
                                dataInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                    int i7 = Util2.f6708a;
                    dataInputStream.close();
                } catch (IOException unused4) {
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        int i8 = Util2.f6708a;
                        dataInputStream2.close();
                    }
                    z2 = false;
                    if (z2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        int i9 = Util2.f6708a;
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
                AtomicFile3 atomicFile3 = this.f6493e;
                atomicFile3.f6704a.delete();
                atomicFile3.f6705b.delete();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContentIndex.c
        /* renamed from: h */
        public void mo2809h() {
            AtomicFile3 atomicFile3 = this.f6493e;
            atomicFile3.f6704a.delete();
            atomicFile3.f6705b.delete();
        }

        /* renamed from: i */
        public final int m2812i(CachedContent cachedContent, int i) {
            int iHashCode = cachedContent.f6472b.hashCode() + (cachedContent.f6471a * 31);
            if (i >= 2) {
                return (iHashCode * 31) + cachedContent.f6475e.hashCode();
            }
            long jM2814a = ContentMetadata.m2814a(cachedContent.f6475e);
            return (iHashCode * 31) + ((int) (jM2814a ^ (jM2814a >>> 32)));
        }

        /* renamed from: j */
        public final CachedContent m2813j(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadataM2793a;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.m2815a(contentMetadataMutations, j);
                defaultContentMetadataM2793a = DefaultContentMetadata.f6498a.m2817a(contentMetadataMutations);
            } else {
                defaultContentMetadataM2793a = CachedContentIndex.m2793a(dataInputStream);
            }
            return new CachedContent(i2, utf, defaultContentMetadataM2793a);
        }
    }

    /* compiled from: CachedContentIndex.java */
    /* renamed from: b.i.a.c.e3.b0.j$c */
    public interface c {
        /* renamed from: a */
        void mo2802a(CachedContent cachedContent, boolean z2);

        /* renamed from: b */
        void mo2803b(HashMap<String, CachedContent> map) throws IOException;

        /* renamed from: c */
        void mo2804c(CachedContent cachedContent);

        /* renamed from: d */
        boolean mo2805d() throws IOException;

        /* renamed from: e */
        void mo2806e(HashMap<String, CachedContent> map) throws IOException;

        /* renamed from: f */
        void mo2807f(long j);

        /* renamed from: g */
        void mo2808g(HashMap<String, CachedContent> map, SparseArray<String> sparseArray) throws IOException;

        /* renamed from: h */
        void mo2809h() throws IOException;
    }

    public CachedContentIndex(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        AnimatableValueParser.m426D((databaseProvider == null && file == null) ? false : true);
        this.f6478a = new HashMap<>();
        this.f6479b = new SparseArray<>();
        this.f6480c = new SparseBooleanArray();
        this.f6481d = new SparseBooleanArray();
        a aVar = databaseProvider != null ? new a(databaseProvider) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (aVar != null && (bVar == null || !z3)) {
            this.f6482e = aVar;
            this.f6483f = bVar;
        } else {
            int i = Util2.f6708a;
            this.f6482e = bVar;
            this.f6483f = aVar;
        }
    }

    /* renamed from: a */
    public static DefaultContentMetadata m2793a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException(outline.m851g(31, "Invalid value size: ", i3));
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = Util2.f6713f;
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
        return new DefaultContentMetadata(map);
    }

    /* renamed from: b */
    public static void m2794b(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setEntrySet = defaultContentMetadata.f6500c.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry<String, byte[]> entry : setEntrySet) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    /* renamed from: c */
    public CachedContent m2795c(String str) {
        return this.f6478a.get(str);
    }

    /* renamed from: d */
    public CachedContent m2796d(String str) {
        CachedContent cachedContent = this.f6478a.get(str);
        if (cachedContent != null) {
            return cachedContent;
        }
        SparseArray<String> sparseArray = this.f6479b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        CachedContent cachedContent2 = new CachedContent(iKeyAt, str, DefaultContentMetadata.f6498a);
        this.f6478a.put(str, cachedContent2);
        this.f6479b.put(iKeyAt, str);
        this.f6481d.put(iKeyAt, true);
        this.f6482e.mo2804c(cachedContent2);
        return cachedContent2;
    }

    @WorkerThread
    /* renamed from: e */
    public void m2797e(long j) throws IOException {
        c cVar;
        this.f6482e.mo2807f(j);
        c cVar2 = this.f6483f;
        if (cVar2 != null) {
            cVar2.mo2807f(j);
        }
        if (this.f6482e.mo2805d() || (cVar = this.f6483f) == null || !cVar.mo2805d()) {
            this.f6482e.mo2808g(this.f6478a, this.f6479b);
        } else {
            this.f6483f.mo2808g(this.f6478a, this.f6479b);
            this.f6482e.mo2803b(this.f6478a);
        }
        c cVar3 = this.f6483f;
        if (cVar3 != null) {
            cVar3.mo2809h();
            this.f6483f = null;
        }
    }

    /* renamed from: f */
    public void m2798f(String str) {
        CachedContent cachedContent = this.f6478a.get(str);
        if (cachedContent != null && cachedContent.f6473c.isEmpty() && cachedContent.f6474d.isEmpty()) {
            this.f6478a.remove(str);
            int i = cachedContent.f6471a;
            boolean z2 = this.f6481d.get(i);
            this.f6482e.mo2802a(cachedContent, z2);
            if (z2) {
                this.f6479b.remove(i);
                this.f6481d.delete(i);
            } else {
                this.f6479b.put(i, null);
                this.f6480c.put(i, true);
            }
        }
    }

    @WorkerThread
    /* renamed from: g */
    public void m2799g() throws IOException {
        this.f6482e.mo2806e(this.f6478a);
        int size = this.f6480c.size();
        for (int i = 0; i < size; i++) {
            this.f6479b.remove(this.f6480c.keyAt(i));
        }
        this.f6480c.clear();
        this.f6481d.clear();
    }
}
