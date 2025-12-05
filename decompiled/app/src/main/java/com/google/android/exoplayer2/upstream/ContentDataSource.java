package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.ApplicationMediaCapabilities;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import p007b.p225i.p226a.p242c.p257e3.BaseDataSource;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public final class ContentDataSource extends BaseDataSource {

    /* renamed from: e */
    public final ContentResolver f20218e;

    /* renamed from: f */
    @Nullable
    public Uri f20219f;

    /* renamed from: g */
    @Nullable
    public AssetFileDescriptor f20220g;

    /* renamed from: h */
    @Nullable
    public FileInputStream f20221h;

    /* renamed from: i */
    public long f20222i;

    /* renamed from: j */
    public boolean f20223j;

    public static class ContentDataSourceException extends DataSourceException {
        public ContentDataSourceException(@Nullable IOException iOException, int i) {
            super(iOException, i);
        }
    }

    @RequiresApi(31)
    /* renamed from: com.google.android.exoplayer2.upstream.ContentDataSource$a */
    public static final class C10764a {
        @DoNotInline
        /* renamed from: a */
        public static void m8934a(Bundle bundle) {
            bundle.putParcelable("android.provider.extra.MEDIA_CAPABILITIES", new ApplicationMediaCapabilities.Builder().addSupportedVideoMimeType("video/hevc").addSupportedHdrType("android.media.feature.hdr.dolby_vision").addSupportedHdrType("android.media.feature.hdr.hdr10").addSupportedHdrType("android.media.feature.hdr.hdr10_plus").addSupportedHdrType("android.media.feature.hdr.hlg").build());
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f20218e = context.getContentResolver();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = dataSpec.f6542a;
            this.f20219f = uri;
            m2850r(dataSpec);
            if ("content".equals(dataSpec.f6542a.getScheme())) {
                Bundle bundle = new Bundle();
                if (Util2.f6708a >= 31) {
                    C10764a.m8934a(bundle);
                }
                assetFileDescriptorOpenAssetFileDescriptor = this.f20218e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f20218e.openAssetFileDescriptor(uri, "r");
            }
            this.f20220g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(strValueOf);
                throw new ContentDataSourceException(new IOException(sb.toString()), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f20221h = fileInputStream;
            if (length != -1 && dataSpec.f6547f > length) {
                throw new ContentDataSourceException(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(dataSpec.f6547f + startOffset) - startOffset;
            if (jSkip != dataSpec.f6547f) {
                throw new ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f20222i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f20222i = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j = length - jSkip;
                this.f20222i = j;
                if (j < 0) {
                    throw new ContentDataSourceException(null, 2008);
                }
            }
            long jMin = dataSpec.f6548g;
            if (jMin != -1) {
                long j2 = this.f20222i;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f20222i = jMin;
            }
            this.f20223j = true;
            m2851s(dataSpec);
            long j3 = dataSpec.f6548g;
            return j3 != -1 ? j3 : this.f20222i;
        } catch (ContentDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws ContentDataSourceException {
        this.f20219f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f20221h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f20221h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f20220g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f20220g = null;
                        if (this.f20223j) {
                            this.f20223j = false;
                            m2849q();
                        }
                    }
                } catch (IOException e) {
                    throw new ContentDataSourceException(e, 2000);
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            }
        } catch (Throwable th) {
            this.f20221h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f20220g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f20220g = null;
                    if (this.f20223j) {
                        this.f20223j = false;
                        m2849q();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new ContentDataSourceException(e3, 2000);
                }
            } finally {
                this.f20220g = null;
                if (this.f20223j) {
                    this.f20223j = false;
                    m2849q();
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        return this.f20219f;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f20222i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ContentDataSourceException(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.f20221h;
        int i3 = Util2.f6708a;
        int i4 = fileInputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.f20222i;
        if (j2 != -1) {
            this.f20222i = j2 - i4;
        }
        m2848p(i4);
        return i4;
    }
}
