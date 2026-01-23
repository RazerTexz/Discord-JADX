package p007b.p225i.p361c.p401u.p403p;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3399a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3402d;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p401u.p403p.AutoValue_TokenResult;
import p007b.p225i.p361c.p401u.p403p.InstallationResponse;
import p007b.p225i.p361c.p401u.p403p.TokenResult;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* JADX INFO: renamed from: b.i.c.u.p.c, reason: use source file name */
/* JADX INFO: compiled from: FirebaseInstallationServiceClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallationServiceClient {

    /* JADX INFO: renamed from: a */
    public static final Pattern f12989a = Pattern.compile("[0-9]+s");

    /* JADX INFO: renamed from: b */
    public static final Charset f12990b = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: c */
    public final Context f12991c;

    /* JADX INFO: renamed from: d */
    public final Provider2<UserAgentPublisher> f12992d;

    /* JADX INFO: renamed from: e */
    public final Provider2<HeartBeatInfo> f12993e;

    /* JADX INFO: renamed from: f */
    public final RequestLimiter f12994f = new RequestLimiter();

    public FirebaseInstallationServiceClient(@NonNull Context context, @NonNull Provider2<UserAgentPublisher> provider2, @NonNull Provider2<HeartBeatInfo> provider22) {
        this.f12991c = context;
        this.f12992d = provider2;
        this.f12993e = provider22;
    }

    /* JADX INFO: renamed from: b */
    public static void m6802b(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        StringBuilder sb;
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f12990b));
            try {
                sb = new StringBuilder();
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                    bufferedReader.close();
                }
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        Log.w("Firebase-Installations", str4);
        Object[] objArr = new Object[3];
        objArr[0] = str2;
        objArr[1] = str3;
        objArr[2] = TextUtils.isEmpty(str) ? "" : outline.m883w(", ", str);
        Log.w("Firebase-Installations", String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr));
    }

    /* JADX INFO: renamed from: d */
    public static long m6803d(String str) {
        AnimatableValueParser.m551o(f12989a.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    /* JADX INFO: renamed from: i */
    public static void m6804i(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final URL m6805a(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e) {
            throw new FirebaseInstallationsException(e.getMessage(), FirebaseInstallationsException.EnumC11081a.UNAVAILABLE);
        }
    }

    /* JADX INFO: renamed from: c */
    public final HttpURLConnection m6806c(URL url, String str) throws FirebaseInstallationsException {
        MessageDigest messageDigestM4185a;
        HeartBeatInfo.a aVarMo6716a;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", RestAPIBuilder.CONTENT_TYPE_JSON);
            httpURLConnection.addRequestProperty("Accept", RestAPIBuilder.CONTENT_TYPE_JSON);
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.f12991c.getPackageName());
            if (this.f12993e.get() != null && this.f12992d.get() != null && (aVarMo6716a = this.f12993e.get().mo6716a("fire-installations-id")) != HeartBeatInfo.a.NONE) {
                httpURLConnection.addRequestProperty("x-firebase-client", this.f12992d.get().getUserAgent());
                httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(aVarMo6716a.m6717f()));
            }
            String strM4187a = null;
            try {
                Context context = this.f12991c;
                PackageInfo packageInfo = C3411b.m4376a(context).f9605a.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                byte[] bArrDigest = (signatureArr == null || signatureArr.length != 1 || (messageDigestM4185a = C3399a.m4185a("SHA1")) == null) ? null : messageDigestM4185a.digest(packageInfo.signatures[0].toByteArray());
                if (bArrDigest == null) {
                    Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f12991c.getPackageName());
                } else {
                    strM4187a = C3402d.m4187a(bArrDigest, false);
                }
            } catch (PackageManager.NameNotFoundException e) {
                StringBuilder sbM833U = outline.m833U("No such package: ");
                sbM833U.append(this.f12991c.getPackageName());
                Log.e("ContentValues", sbM833U.toString(), e);
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", strM4187a);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.EnumC11081a.UNAVAILABLE);
        }
    }

    /* JADX INFO: renamed from: e */
    public final InstallationResponse m6807e(HttpURLConnection httpURLConnection) throws IOException, AssertionError {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f12990b));
        TokenResult.a aVarM6813a = TokenResult.m6813a();
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        String strNextString3 = null;
        TokenResult tokenResultMo6800a = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals("fid")) {
                strNextString2 = jsonReader.nextString();
            } else if (strNextName.equals("refreshToken")) {
                strNextString3 = jsonReader.nextString();
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        ((AutoValue_TokenResult.b) aVarM6813a).f12986a = jsonReader.nextString();
                    } else if (strNextName2.equals("expiresIn")) {
                        aVarM6813a.mo6801b(m6803d(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                tokenResultMo6800a = aVarM6813a.mo6800a();
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new AutoValue_InstallationResponse(strNextString, strNextString2, strNextString3, tokenResultMo6800a, InstallationResponse.a.OK, null);
    }

    /* JADX INFO: renamed from: f */
    public final TokenResult m6808f(HttpURLConnection httpURLConnection) throws IOException, AssertionError {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f12990b));
        TokenResult.a aVarM6813a = TokenResult.m6813a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                ((AutoValue_TokenResult.b) aVarM6813a).f12986a = jsonReader.nextString();
            } else if (strNextName.equals("expiresIn")) {
                aVarM6813a.mo6801b(m6803d(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        AutoValue_TokenResult.b bVar = (AutoValue_TokenResult.b) aVarM6813a;
        bVar.f12988c = TokenResult.b.OK;
        return bVar.mo6800a();
    }

    /* JADX INFO: renamed from: g */
    public final void m6809g(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:16.3.4");
            m6804i(httpURLConnection, jSONObject.toString().getBytes(Constants.ENCODING));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m6810h(HttpURLConnection httpURLConnection) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:16.3.4");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            m6804i(httpURLConnection, jSONObject2.toString().getBytes(Constants.ENCODING));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }
}
