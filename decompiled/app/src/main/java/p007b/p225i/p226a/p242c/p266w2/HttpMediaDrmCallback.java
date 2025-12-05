package p007b.p225i.p226a.p242c.p266w2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.discord.restapi.RestAPIBuilder;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.p257e3.DataSourceInputStream;
import p007b.p225i.p226a.p242c.p257e3.DataSpec;
import p007b.p225i.p226a.p242c.p257e3.DefaultHttpDataSource;
import p007b.p225i.p226a.p242c.p257e3.HttpDataSource;
import p007b.p225i.p226a.p242c.p257e3.StatsDataSource;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;
import p007b.p225i.p355b.p357b.RegularImmutableMap;

/* compiled from: HttpMediaDrmCallback.java */
/* renamed from: b.i.a.c.w2.d0, reason: use source file name */
/* loaded from: classes3.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a */
    public final HttpDataSource f7982a;

    /* renamed from: b */
    @Nullable
    public final String f7983b;

    /* renamed from: c */
    public final boolean f7984c;

    /* renamed from: d */
    public final Map<String, String> f7985d;

    public HttpMediaDrmCallback(@Nullable String str, boolean z2, HttpDataSource httpDataSource) {
        AnimatableValueParser.m531j((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.f7982a = httpDataSource;
        this.f7983b = str;
        this.f7984c = z2;
        this.f7985d = new HashMap();
    }

    /* renamed from: b */
    public static byte[] m3583b(HttpDataSource httpDataSource, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        Map<String, List<String>> map2;
        List<String> list;
        StatsDataSource statsDataSource = new StatsDataSource(((DefaultHttpDataSource.b) httpDataSource).m2872b());
        Collections.emptyMap();
        Uri uri = Uri.parse(str);
        if (uri == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        DataSpec dataSpec = new DataSpec(uri, 0L, 2, bArr, map, 0L, -1L, null, 1, null);
        DataSpec dataSpecM2857a = dataSpec;
        int i = 0;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecM2857a);
                try {
                    try {
                        byte[] bArrM2990K = Util2.m2990K(dataSourceInputStream);
                        try {
                            dataSourceInputStream.close();
                        } catch (IOException unused) {
                        }
                        return bArrM2990K;
                    } catch (HttpDataSource$InvalidResponseCodeException e) {
                        int i2 = e.responseCode;
                        String str2 = null;
                        if (((i2 == 307 || i2 == 308) && i < 5) && (map2 = e.headerFields) != null && (list = map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = list.get(0);
                        }
                        if (str2 == null) {
                            throw e;
                        }
                        i++;
                        DataSpec.b bVarM2855a = dataSpecM2857a.m2855a();
                        bVarM2855a.f6552a = Uri.parse(str2);
                        dataSpecM2857a = bVarM2855a.m2857a();
                        try {
                            dataSourceInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } finally {
                    int i3 = Util2.f6708a;
                    try {
                        dataSourceInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Exception e2) {
                Uri uri2 = statsDataSource.f6643c;
                Objects.requireNonNull(uri2);
                throw new MediaDrmCallbackException(dataSpec, uri2, statsDataSource.mo2588j(), statsDataSource.f6642b, e2);
            }
        }
    }

    /* renamed from: a */
    public byte[] m3584a(UUID uuid, ExoMediaDrm.a aVar) throws MediaDrmCallbackException {
        String str = aVar.f7968b;
        if (this.f7984c || TextUtils.isEmpty(str)) {
            str = this.f7983b;
        }
        if (TextUtils.isEmpty(str)) {
            Map mapEmptyMap = Collections.emptyMap();
            Uri uri = Uri.EMPTY;
            if (uri != null) {
                throw new MediaDrmCallbackException(new DataSpec(uri, 0L, 1, null, mapEmptyMap, 0L, -1L, null, 0, null), Uri.EMPTY, RegularImmutableMap.f12015m, 0L, new IllegalStateException("No license URL"));
            }
            throw new IllegalStateException("The uri must be set.");
        }
        HashMap map = new HashMap();
        UUID uuid2 = C.f8025e;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : C.f8023c.equals(uuid) ? RestAPIBuilder.CONTENT_TYPE_JSON : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f7985d) {
            map.putAll(this.f7985d);
        }
        return m3583b(this.f7982a, str, aVar.f7967a, map);
    }

    /* renamed from: c */
    public byte[] m3585c(UUID uuid, ExoMediaDrm.d dVar) throws MediaDrmCallbackException {
        String str = dVar.f7970b;
        String strM3004l = Util2.m3004l(dVar.f7969a);
        return m3583b(this.f7982a, outline.m859k(strM3004l.length() + outline.m841b(str, 15), str, "&signedRequest=", strM3004l), null, Collections.emptyMap());
    }
}
