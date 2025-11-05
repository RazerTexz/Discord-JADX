package b.i.a.c.w2;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.i.a.c.e3.n;
import b.i.a.c.e3.r;
import b.i.a.c.w2.a0;
import b.i.a.c.x0;
import b.i.b.b.i0;
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

/* compiled from: HttpMediaDrmCallback.java */
/* loaded from: classes3.dex */
public final class d0 implements e0 {
    public final b.i.a.c.e3.t a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1152b;
    public final boolean c;
    public final Map<String, String> d;

    public d0(@Nullable String str, boolean z2, b.i.a.c.e3.t tVar) {
        b.c.a.a0.d.j((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.a = tVar;
        this.f1152b = str;
        this.c = z2;
        this.d = new HashMap();
    }

    public static byte[] b(b.i.a.c.e3.t tVar, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        Map<String, List<String>> map2;
        List<String> list;
        b.i.a.c.e3.y yVar = new b.i.a.c.e3.y(((r.b) tVar).b());
        Collections.emptyMap();
        Uri uri = Uri.parse(str);
        if (uri == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        b.i.a.c.e3.n nVar = new b.i.a.c.e3.n(uri, 0L, 2, bArr, map, 0L, -1L, null, 1, null);
        b.i.a.c.e3.n nVarA = nVar;
        int i = 0;
        while (true) {
            try {
                b.i.a.c.e3.m mVar = new b.i.a.c.e3.m(yVar, nVarA);
                try {
                    try {
                        byte[] bArrK = b.i.a.c.f3.e0.K(mVar);
                        try {
                            mVar.close();
                        } catch (IOException unused) {
                        }
                        return bArrK;
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
                        n.b bVarA = nVarA.a();
                        bVarA.a = Uri.parse(str2);
                        nVarA = bVarA.a();
                        try {
                            mVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                } finally {
                    int i3 = b.i.a.c.f3.e0.a;
                    try {
                        mVar.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Exception e2) {
                Uri uri2 = yVar.c;
                Objects.requireNonNull(uri2);
                throw new MediaDrmCallbackException(nVar, uri2, yVar.j(), yVar.f956b, e2);
            }
        }
    }

    public byte[] a(UUID uuid, a0.a aVar) throws MediaDrmCallbackException {
        String str = aVar.f1148b;
        if (this.c || TextUtils.isEmpty(str)) {
            str = this.f1152b;
        }
        if (TextUtils.isEmpty(str)) {
            Map mapEmptyMap = Collections.emptyMap();
            Uri uri = Uri.EMPTY;
            if (uri != null) {
                throw new MediaDrmCallbackException(new b.i.a.c.e3.n(uri, 0L, 1, null, mapEmptyMap, 0L, -1L, null, 0, null), Uri.EMPTY, i0.m, 0L, new IllegalStateException("No license URL"));
            }
            throw new IllegalStateException("The uri must be set.");
        }
        HashMap map = new HashMap();
        UUID uuid2 = x0.e;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : x0.c.equals(uuid) ? RestAPIBuilder.CONTENT_TYPE_JSON : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            map.putAll(this.d);
        }
        return b(this.a, str, aVar.a, map);
    }

    public byte[] c(UUID uuid, a0.d dVar) throws MediaDrmCallbackException {
        String str = dVar.f1149b;
        String strL = b.i.a.c.f3.e0.l(dVar.a);
        return b(this.a, b.d.b.a.a.k(strL.length() + b.d.b.a.a.b(str, 15), str, "&signedRequest=", strL), null, Collections.emptyMap());
    }
}
