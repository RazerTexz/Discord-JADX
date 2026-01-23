package p007b.p225i.p226a.p288f.p313h.p323j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.o0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3533o0 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public static final byte[] f9773l = "\n".getBytes();

    /* JADX INFO: renamed from: m */
    public final String f9774m;

    /* JADX INFO: renamed from: n */
    public final C3553y0 f9775n;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C3533o0(C3515g c3515g) {
        String string;
        super(c3515g);
        String str = C3512f.f9715a;
        String str2 = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        if (locale == null) {
            string = null;
        } else {
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                StringBuilder sb = new StringBuilder();
                sb.append(language.toLowerCase(locale));
                if (!TextUtils.isEmpty(locale.getCountry())) {
                    sb.append("-");
                    sb.append(locale.getCountry().toLowerCase(locale));
                }
                string = sb.toString();
            }
        }
        this.f9774m = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", str, str2, string, Build.MODEL, Build.ID);
        this.f9775n = new C3553y0(c3515g.f9724d);
    }

    /* JADX INFO: renamed from: S */
    public static void m4476S(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Constants.ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Constants.ENCODING));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        m4431b("Network initialized. User agent", this.f9774m);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m4477O(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        IOException e;
        HttpURLConnection httpURLConnectionM4480U;
        Objects.requireNonNull(bArr, "null reference");
        m4430a(3, "POST bytes, url", Integer.valueOf(bArr.length), url, null);
        if (Log.isLoggable(C3510e0.f9690b.f9716a, 2)) {
            m4431b("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            this.f9684j.f9722b.getPackageName();
            httpURLConnectionM4480U = m4480U(url);
            try {
                try {
                    httpURLConnectionM4480U.setDoOutput(true);
                    httpURLConnectionM4480U.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionM4480U.connect();
                    outputStream = httpURLConnectionM4480U.getOutputStream();
                    outputStream.write(bArr);
                    m4479T(httpURLConnectionM4480U);
                    int responseCode = httpURLConnectionM4480U.getResponseCode();
                    if (responseCode == 200) {
                        m4436s().m4415O();
                    }
                    m4432d("POST status", Integer.valueOf(responseCode));
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        m4426A("Error closing http post connection output stream", e2);
                    }
                    httpURLConnectionM4480U.disconnect();
                    return responseCode;
                } catch (IOException e3) {
                    e = e3;
                    m4439x("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            m4426A("Error closing http post connection output stream", e4);
                        }
                    }
                    if (httpURLConnectionM4480U == null) {
                        return 0;
                    }
                    httpURLConnectionM4480U.disconnect();
                    return 0;
                }
            } catch (Throwable th) {
                httpURLConnection = httpURLConnectionM4480U;
                th = th;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        m4426A("Error closing http post connection output stream", e5);
                    }
                }
                if (httpURLConnection != null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnectionM4480U = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
        }
    }

    /* JADX INFO: renamed from: R */
    public final String m4478R(C3523j0 c3523j0, boolean z2) {
        long j;
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : c3523j0.f9746a.entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    m4476S(sb, key, entry.getValue());
                }
            }
            m4476S(sb, "ht", String.valueOf(c3523j0.f9749d));
            Objects.requireNonNull((C3401c) this.f9684j.f9724d);
            m4476S(sb, "qt", String.valueOf(System.currentTimeMillis() - c3523j0.f9749d));
            if (z2) {
                AnimatableValueParser.m583w("_s");
                AnimatableValueParser.m551o(true, "Short param name required");
                String str = c3523j0.f9746a.get("_s");
                if (str == null) {
                    str = "0";
                }
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                m4476S(sb, "z", j != 0 ? String.valueOf(j) : String.valueOf(c3523j0.f9748c));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            m4426A("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        m4426A("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4479T(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                inputStream.close();
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        m4426A("Error closing http connection input stream", e);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* JADX INFO: renamed from: U */
    public final HttpURLConnection m4480U(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(C3510e0.f9709u.f9716a.intValue());
        httpURLConnection.setReadTimeout(C3510e0.f9710v.f9716a.intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f9774m);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x014f A[EDGE_INSN: B:237:0x014f->B:64:0x014f BREAK  A[LOOP:0: B:37:0x00c6->B:63:0x0144], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x043c A[EDGE_INSN: B:239:0x043c->B:211:0x043c BREAK  A[LOOP:1: B:139:0x02d0->B:241:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0144 A[LOOP:0: B:37:0x00c6->B:63:0x0144, LOOP_END] */
    /* JADX WARN: Type inference failed for: r0v55, types: [java.lang.Object, java.net.URL] */
    /* JADX WARN: Type inference failed for: r16v0, types: [b.i.a.f.h.j.d, b.i.a.f.h.j.e, b.i.a.f.h.j.o0] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX INFO: renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Long> m4481V(List<C3523j0> list) throws Throwable {
        boolean z2;
        String str;
        String strConcat;
        URL url;
        boolean z3;
        String strM861l;
        URL url2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnectionM4480U;
        int responseCode;
        Object url3;
        ?? r3;
        ?? r2;
        OutputStream outputStream;
        byte[] byteArray;
        boolean z4;
        EnumC3550x enumC3550x = EnumC3550x.GZIP;
        EnumC3548w enumC3548w = EnumC3548w.NONE;
        C3180f.m3967b();
        m4444N();
        int iM4477O = 0;
        if (!this.f9684j.f9725e.m4514g().isEmpty() && this.f9775n.m4507b(((long) C3510e0.f9708t.f9716a.intValue()) * 1000)) {
            String str2 = C3510e0.f9702n.f9716a;
            z2 = ("BATCH_BY_SESSION".equalsIgnoreCase(str2) ? EnumC3548w.BATCH_BY_SESSION : "BATCH_BY_TIME".equalsIgnoreCase(str2) ? EnumC3548w.BATCH_BY_TIME : "BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str2) ? EnumC3548w.BATCH_BY_BRUTE_FORCE : "BATCH_BY_COUNT".equalsIgnoreCase(str2) ? EnumC3548w.BATCH_BY_COUNT : "BATCH_BY_SIZE".equalsIgnoreCase(str2) ? EnumC3548w.BATCH_BY_SIZE : enumC3548w) != enumC3548w;
            boolean z5 = ("GZIP".equalsIgnoreCase(C3510e0.f9703o.f9716a) ? enumC3550x : EnumC3550x.NONE) == enumC3550x;
            if (z2) {
                ArrayList arrayList = new ArrayList(list.size());
                for (C3523j0 c3523j0 : list) {
                    Objects.requireNonNull(c3523j0, "null reference");
                    String strM4478R = m4478R(c3523j0, !c3523j0.f9751f);
                    if (strM4478R != null) {
                        if (strM4478R.length() <= C3510e0.f9701m.f9716a.intValue()) {
                            if (c3523j0.f9751f) {
                                String strM4510d = C3554z.m4510d();
                                String strM4512f = C3554z.m4512f();
                                strM861l = outline.m861l(strM4478R.length() + outline.m841b(strM4512f, outline.m841b(strM4510d, 1)), strM4510d, strM4512f, "?", strM4478R);
                            } else {
                                String strM4511e = C3554z.m4511e();
                                String strM4512f2 = C3554z.m4512f();
                                strM861l = outline.m861l(strM4478R.length() + outline.m841b(strM4512f2, outline.m841b(strM4511e, 1)), strM4511e, strM4512f2, "?", strM4478R);
                            }
                            try {
                                url2 = new URL(strM861l);
                            } catch (MalformedURLException e) {
                                m4426A("Error trying to parse the hardcoded host url", e);
                                url2 = null;
                            }
                            if (url2 == null) {
                                m4429H("Failed to build collect GET endpoint url");
                            } else {
                                m4432d("GET request", url2);
                                try {
                                    httpURLConnectionM4480U = m4480U(url2);
                                    try {
                                        try {
                                            httpURLConnectionM4480U.connect();
                                            m4479T(httpURLConnectionM4480U);
                                            responseCode = httpURLConnectionM4480U.getResponseCode();
                                            if (responseCode == 200) {
                                                m4436s().m4415O();
                                            }
                                            m4432d("GET status", Integer.valueOf(responseCode));
                                            httpURLConnectionM4480U.disconnect();
                                        } catch (Throwable th) {
                                            th = th;
                                            httpURLConnection = httpURLConnectionM4480U;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        m4439x("Network GET connection error", e);
                                        if (httpURLConnectionM4480U != null) {
                                            httpURLConnectionM4480U.disconnect();
                                        }
                                        responseCode = 0;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    httpURLConnectionM4480U = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection = null;
                                }
                                if (responseCode == 200) {
                                }
                            }
                            z3 = false;
                        } else {
                            String strM4478R2 = m4478R(c3523j0, false);
                            if (strM4478R2 == null) {
                                m4434n().m4465O(c3523j0, "Error formatting hit for POST upload");
                            } else {
                                byte[] bytes = strM4478R2.getBytes();
                                if (bytes.length > C3510e0.f9705q.f9716a.intValue()) {
                                    m4434n().m4465O(c3523j0, "Hit payload exceeds size limit");
                                } else if (c3523j0.f9751f) {
                                    String strValueOf = String.valueOf(C3554z.m4510d());
                                    String strValueOf2 = String.valueOf(C3554z.m4512f());
                                    if (strValueOf2.length() != 0) {
                                        strConcat = strValueOf.concat(strValueOf2);
                                        try {
                                            url = new URL(strConcat);
                                        } catch (MalformedURLException e4) {
                                            m4426A("Error trying to parse the hardcoded host url", e4);
                                            url = null;
                                        }
                                        if (url != null) {
                                            m4429H("Failed to build collect POST endpoint url");
                                        } else if (m4477O(url, bytes) == 200) {
                                        }
                                        z3 = false;
                                    } else {
                                        str = new String(strValueOf);
                                        strConcat = str;
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                        z3 = false;
                                    }
                                } else {
                                    String strValueOf3 = String.valueOf(C3554z.m4511e());
                                    String strValueOf4 = String.valueOf(C3554z.m4512f());
                                    if (strValueOf4.length() != 0) {
                                        strConcat = strValueOf3.concat(strValueOf4);
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                        z3 = false;
                                    } else {
                                        str = new String(strValueOf3);
                                        strConcat = str;
                                        url = new URL(strConcat);
                                        if (url != null) {
                                        }
                                        z3 = false;
                                    }
                                }
                            }
                        }
                        if (z3) {
                            break;
                        }
                        arrayList.add(Long.valueOf(c3523j0.f9748c));
                        if (arrayList.size() >= C3554z.m4509c()) {
                            break;
                        }
                    } else {
                        m4434n().m4465O(c3523j0, "Error formatting hit for upload");
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                return arrayList;
            }
            AnimatableValueParser.m539l(!list.isEmpty());
            m4430a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z5), Integer.valueOf(list.size()), null);
            ?? byteArrayOutputStream = new ByteArrayOutputStream();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (C3523j0 c3523j02 : list) {
                Objects.requireNonNull(c3523j02, "null reference");
                int i2 = i + 1;
                if (i2 <= C3510e0.f9696h.f9716a.intValue()) {
                    String strM4478R3 = m4478R(c3523j02, false);
                    if (strM4478R3 != null) {
                        byte[] bytes2 = strM4478R3.getBytes();
                        int length = bytes2.length;
                        if (length <= C3510e0.f9704p.f9716a.intValue()) {
                            if (byteArrayOutputStream.size() > 0) {
                                length++;
                            }
                            if (byteArrayOutputStream.size() + length <= C3510e0.f9706r.f9716a.intValue()) {
                                try {
                                    if (byteArrayOutputStream.size() > 0) {
                                        byteArrayOutputStream.write(f9773l);
                                    }
                                    byteArrayOutputStream.write(bytes2);
                                    i = i2;
                                } catch (IOException e5) {
                                    m4426A("Failed to write payload when batching hits", e5);
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                break;
                            }
                            arrayList2.add(Long.valueOf(c3523j02.f9748c));
                        } else {
                            m4434n().m4465O(c3523j02, "Hit size exceeds the maximum size limit");
                        }
                    } else {
                        m4434n().m4465O(c3523j02, "Error formatting hit");
                    }
                    z4 = true;
                    if (!z4) {
                    }
                } else {
                    z4 = false;
                    if (!z4) {
                    }
                }
            }
            int i3 = i;
            if (i3 == 0) {
                return arrayList2;
            }
            String strValueOf5 = String.valueOf(C3554z.m4510d());
            String strValueOf6 = String.valueOf(C3510e0.f9700l.f9716a);
            try {
                url3 = new URL(strValueOf6.length() != 0 ? strValueOf5.concat(strValueOf6) : new String(strValueOf5));
            } catch (MalformedURLException e6) {
                m4426A("Error trying to parse the hardcoded host url", e6);
                url3 = null;
            }
            ?? r0 = url3;
            if (r0 == 0) {
                m4429H("Failed to build batching endpoint url");
            } else {
                if (z5) {
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    Objects.requireNonNull(byteArray2, "null reference");
                    try {
                        try {
                            this.f9684j.f9722b.getPackageName();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(byteArray2);
                            gZIPOutputStream.close();
                            byteArrayOutputStream2.close();
                            byteArray = byteArrayOutputStream2.toByteArray();
                            m4430a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray.length), Long.valueOf((((long) byteArray.length) * 100) / ((long) byteArray2.length)), r0);
                            if (byteArray.length > byteArray2.length) {
                                m4433f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray.length), Integer.valueOf(byteArray2.length));
                            }
                            if (Log.isLoggable(C3510e0.f9690b.f9716a, 2)) {
                                String str3 = new String(byteArray2);
                                m4431b("Post payload", str3.length() != 0 ? "\n".concat(str3) : new String("\n"));
                            }
                            byteArrayOutputStream = m4480U(r0);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        byteArrayOutputStream = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        r3 = 0;
                        r2 = 0;
                        Throwable th5 = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e8) {
                                m4426A("Error closing http compressed post connection output stream", e8);
                            }
                        }
                        if (r3 != 0) {
                            throw th5;
                        }
                        r3.disconnect();
                        throw th5;
                    }
                    try {
                        byteArrayOutputStream.setDoOutput(true);
                        byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                        byteArrayOutputStream.setFixedLengthStreamingMode(byteArray.length);
                        byteArrayOutputStream.connect();
                        outputStream = byteArrayOutputStream.getOutputStream();
                        try {
                            outputStream.write(byteArray);
                            outputStream.close();
                            m4479T(byteArrayOutputStream);
                            int responseCode2 = byteArrayOutputStream.getResponseCode();
                            if (responseCode2 == 200) {
                                m4436s().m4415O();
                            }
                            url3 = "POST status";
                            m4432d("POST status", Integer.valueOf(responseCode2));
                            byteArrayOutputStream.disconnect();
                            iM4477O = responseCode2;
                        } catch (IOException e9) {
                            e = e9;
                            m4439x("Network compressed POST connection error", e);
                            url3 = outputStream;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                    url3 = outputStream;
                                } catch (IOException e10) {
                                    IOException iOException = e10;
                                    m4426A("Error closing http compressed post connection output stream", iOException);
                                    url3 = iOException;
                                }
                            }
                            if (byteArrayOutputStream != 0) {
                                byteArrayOutputStream.disconnect();
                            }
                        }
                    } catch (IOException e11) {
                        e = e11;
                        outputStream = null;
                        m4439x("Network compressed POST connection error", e);
                        url3 = outputStream;
                        if (outputStream != null) {
                        }
                        if (byteArrayOutputStream != 0) {
                        }
                        if (200 != iM4477O) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        url3 = null;
                        r3 = byteArrayOutputStream;
                        r2 = url3;
                        Throwable th52 = th;
                        if (r2 != 0) {
                        }
                        if (r3 != 0) {
                        }
                    }
                } else {
                    iM4477O = m4477O(r0, byteArrayOutputStream.toByteArray());
                }
                if (200 != iM4477O) {
                    m4431b("Batched upload completed. Hits batched", Integer.valueOf(i3));
                    return arrayList2;
                }
                m4431b("Network error uploading hits. status code", Integer.valueOf(iM4477O));
                if (this.f9684j.f9725e.m4514g().contains(Integer.valueOf(iM4477O))) {
                    m4428D("Server instructed the client to stop batching");
                    this.f9775n.m4506a();
                }
            }
            return Collections.emptyList();
        }
        z2 = false;
        if (z2) {
        }
    }

    /* JADX INFO: renamed from: W */
    public final boolean m4482W() {
        C3180f.m3967b();
        m4444N();
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f9684j.f9722b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        m4427C("No network connectivity");
        return false;
    }
}
