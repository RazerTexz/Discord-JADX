package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.PointerIconCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p257e3.BaseDataSource;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public final class FileDataSource extends BaseDataSource {

    /* renamed from: e */
    @Nullable
    public RandomAccessFile f20225e;

    /* renamed from: f */
    @Nullable
    public Uri f20226f;

    /* renamed from: g */
    public long f20227g;

    /* renamed from: h */
    public boolean f20228h;

    public static class FileDataSourceException extends DataSourceException {
        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    @RequiresApi(21)
    /* renamed from: com.google.android.exoplayer2.upstream.FileDataSource$a */
    public static final class C10765a {
        /* renamed from: a */
        public static /* synthetic */ boolean m8935a(Throwable th) {
            return m8936b(th);
        }

        @DoNotInline
        /* renamed from: b */
        private static boolean m8936b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public FileDataSource() {
        super(false);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f6542a;
        this.f20226f = uri;
        m2850r(dataSpec);
        try {
            String path = uri.getPath();
            Objects.requireNonNull(path);
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f20225e = randomAccessFile;
            try {
                randomAccessFile.seek(dataSpec.f6547f);
                long length = dataSpec.f6548g;
                if (length == -1) {
                    length = this.f20225e.length() - dataSpec.f6547f;
                }
                this.f20227g = length;
                if (length < 0) {
                    throw new FileDataSourceException(null, null, 2008);
                }
                this.f20228h = true;
                m2851s(dataSpec);
                return this.f20227g;
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e2, (Util2.f6708a < 21 || !C10765a.m8935a(e2.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, PointerIconCompat.TYPE_WAIT);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, 2006);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, 2000);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws FileDataSourceException {
        this.f20226f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f20225e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } finally {
            this.f20225e = null;
            if (this.f20228h) {
                this.f20228h = false;
                m2849q();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        return this.f20226f;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f20227g;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f20225e;
            int i3 = Util2.f6708a;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.f20227g -= i4;
                m2848p(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
