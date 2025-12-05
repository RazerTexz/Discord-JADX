package p007b.p225i.p226a.p242c.p257e3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DefaultHttpDataSource;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: DefaultDataSource.java */
/* renamed from: b.i.a.c.e3.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultDataSource implements DataSource3 {

    /* renamed from: a */
    public final Context f6594a;

    /* renamed from: b */
    public final List<TransferListener> f6595b;

    /* renamed from: c */
    public final DataSource3 f6596c;

    /* renamed from: d */
    @Nullable
    public DataSource3 f6597d;

    /* renamed from: e */
    @Nullable
    public DataSource3 f6598e;

    /* renamed from: f */
    @Nullable
    public DataSource3 f6599f;

    /* renamed from: g */
    @Nullable
    public DataSource3 f6600g;

    /* renamed from: h */
    @Nullable
    public DataSource3 f6601h;

    /* renamed from: i */
    @Nullable
    public DataSource3 f6602i;

    /* renamed from: j */
    @Nullable
    public DataSource3 f6603j;

    /* renamed from: k */
    @Nullable
    public DataSource3 f6604k;

    /* compiled from: DefaultDataSource.java */
    /* renamed from: b.i.a.c.e3.q$a */
    public static final class a implements DataSource3.a {

        /* renamed from: a */
        public final Context f6605a;

        /* renamed from: b */
        public final DataSource3.a f6606b;

        public a(Context context) {
            DefaultHttpDataSource.b bVar = new DefaultHttpDataSource.b();
            this.f6605a = context.getApplicationContext();
            this.f6606b = bVar;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3.a
        /* renamed from: a */
        public /* bridge */ /* synthetic */ DataSource3 mo234a() {
            return m2865b();
        }

        /* renamed from: b */
        public DefaultDataSource m2865b() {
            return new DefaultDataSource(this.f6605a, this.f6606b.mo234a());
        }
    }

    public DefaultDataSource(Context context, DataSource3 dataSource3) {
        this.f6594a = context.getApplicationContext();
        Objects.requireNonNull(dataSource3);
        this.f6596c = dataSource3;
        this.f6595b = new ArrayList();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: a */
    public long mo2586a(DataSpec dataSpec) throws IOException {
        boolean z2 = true;
        AnimatableValueParser.m426D(this.f6604k == null);
        String scheme = dataSpec.f6542a.getScheme();
        Uri uri = dataSpec.f6542a;
        int i = Util2.f6708a;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            z2 = false;
        }
        if (z2) {
            String path = dataSpec.f6542a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f6597d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.f6597d = fileDataSource;
                    m2864p(fileDataSource);
                }
                this.f6604k = this.f6597d;
            } else {
                if (this.f6598e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(this.f6594a);
                    this.f6598e = assetDataSource;
                    m2864p(assetDataSource);
                }
                this.f6604k = this.f6598e;
            }
        } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(scheme)) {
            if (this.f6598e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(this.f6594a);
                this.f6598e = assetDataSource2;
                m2864p(assetDataSource2);
            }
            this.f6604k = this.f6598e;
        } else if ("content".equals(scheme)) {
            if (this.f6599f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(this.f6594a);
                this.f6599f = contentDataSource;
                m2864p(contentDataSource);
            }
            this.f6604k = this.f6599f;
        } else if ("rtmp".equals(scheme)) {
            if (this.f6600g == null) {
                try {
                    DataSource3 dataSource3 = (DataSource3) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.f6600g = dataSource3;
                    m2864p(dataSource3);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.f6600g == null) {
                    this.f6600g = this.f6596c;
                }
            }
            this.f6604k = this.f6600g;
        } else if ("udp".equals(scheme)) {
            if (this.f6601h == null) {
                UdpDataSource udpDataSource = new UdpDataSource();
                this.f6601h = udpDataSource;
                m2864p(udpDataSource);
            }
            this.f6604k = this.f6601h;
        } else if ("data".equals(scheme)) {
            if (this.f6602i == null) {
                DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
                this.f6602i = dataSchemeDataSource;
                m2864p(dataSchemeDataSource);
            }
            this.f6604k = this.f6602i;
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            if (this.f6603j == null) {
                RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f6594a);
                this.f6603j = rawResourceDataSource;
                m2864p(rawResourceDataSource);
            }
            this.f6604k = this.f6603j;
        } else {
            this.f6604k = this.f6596c;
        }
        return this.f6604k.mo2586a(dataSpec);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    public void close() throws IOException {
        DataSource3 dataSource3 = this.f6604k;
        if (dataSource3 != null) {
            try {
                dataSource3.close();
            } finally {
                this.f6604k = null;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: d */
    public void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f6596c.mo2587d(transferListener);
        this.f6595b.add(transferListener);
        DataSource3 dataSource3 = this.f6597d;
        if (dataSource3 != null) {
            dataSource3.mo2587d(transferListener);
        }
        DataSource3 dataSource32 = this.f6598e;
        if (dataSource32 != null) {
            dataSource32.mo2587d(transferListener);
        }
        DataSource3 dataSource33 = this.f6599f;
        if (dataSource33 != null) {
            dataSource33.mo2587d(transferListener);
        }
        DataSource3 dataSource34 = this.f6600g;
        if (dataSource34 != null) {
            dataSource34.mo2587d(transferListener);
        }
        DataSource3 dataSource35 = this.f6601h;
        if (dataSource35 != null) {
            dataSource35.mo2587d(transferListener);
        }
        DataSource3 dataSource36 = this.f6602i;
        if (dataSource36 != null) {
            dataSource36.mo2587d(transferListener);
        }
        DataSource3 dataSource37 = this.f6603j;
        if (dataSource37 != null) {
            dataSource37.mo2587d(transferListener);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* renamed from: j */
    public Map<String, List<String>> mo2588j() {
        DataSource3 dataSource3 = this.f6604k;
        return dataSource3 == null ? Collections.emptyMap() : dataSource3.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    @Nullable
    /* renamed from: n */
    public Uri mo2589n() {
        DataSource3 dataSource3 = this.f6604k;
        if (dataSource3 == null) {
            return null;
        }
        return dataSource3.mo2589n();
    }

    /* renamed from: p */
    public final void m2864p(DataSource3 dataSource3) {
        for (int i = 0; i < this.f6595b.size(); i++) {
            dataSource3.mo2587d(this.f6595b.get(i));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        DataSource3 dataSource3 = this.f6604k;
        Objects.requireNonNull(dataSource3);
        return dataSource3.read(bArr, i, i2);
    }
}
