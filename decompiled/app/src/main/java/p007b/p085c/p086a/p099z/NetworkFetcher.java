package p007b.p085c.p086a.p099z;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.restapi.RestAPIBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.LottieCompositionFactory;
import p007b.p085c.p086a.LottieResult;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.z.c, reason: use source file name */
/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class NetworkFetcher {

    /* JADX INFO: renamed from: a */
    public final Context f2928a;

    /* JADX INFO: renamed from: b */
    public final String f2929b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final NetworkCache f2930c;

    public NetworkFetcher(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f2928a = applicationContext;
        this.f2929b = str;
        if (str2 == null) {
            this.f2930c = null;
        } else {
            this.f2930c = new NetworkCache(applicationContext);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final LottieResult<LottieComposition> m796a() throws IOException {
        StringBuilder sbM833U = outline.m833U("Fetching ");
        sbM833U.append(this.f2929b);
        Logger2.m639a(sbM833U.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2929b).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                LottieResult<LottieComposition> lottieResultM798c = m798c(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(lottieResultM798c.f2449a != null);
                Logger2.m639a(sb.toString());
                return lottieResultM798c;
            }
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to fetch " + this.f2929b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + m797b(httpURLConnection)));
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m797b(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final LottieResult<LottieComposition> m798c(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResultM675b;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = RestAPIBuilder.CONTENT_TYPE_JSON;
        }
        if (contentType.contains("application/zip")) {
            Logger2.m639a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.f2930c;
            lottieResultM675b = networkCache == null ? LottieCompositionFactory.m677d(new ZipInputStream(httpURLConnection.getInputStream()), null) : LottieCompositionFactory.m677d(new ZipInputStream(new FileInputStream(networkCache.m795c(this.f2929b, httpURLConnection.getInputStream(), fileExtension))), this.f2929b);
        } else {
            Logger2.m639a("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache2 = this.f2930c;
            lottieResultM675b = networkCache2 == null ? LottieCompositionFactory.m675b(httpURLConnection.getInputStream(), null) : LottieCompositionFactory.m675b(new FileInputStream(new File(networkCache2.m795c(this.f2929b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f2929b);
        }
        NetworkCache networkCache3 = this.f2930c;
        if (networkCache3 != null && lottieResultM675b.f2449a != null) {
            File file = new File(networkCache3.m794b(), NetworkCache.m793a(this.f2929b, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            Logger2.m639a("Copying temp file to real file (" + file2 + ")");
            if (!zRenameTo) {
                StringBuilder sbM833U = outline.m833U("Unable to rename cache file ");
                sbM833U.append(file.getAbsolutePath());
                sbM833U.append(" to ");
                sbM833U.append(file2.getAbsolutePath());
                sbM833U.append(".");
                Logger2.m640b(sbM833U.toString());
            }
        }
        return lottieResultM675b;
    }
}
