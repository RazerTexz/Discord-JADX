package p007b.p225i.p361c.p401u;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p401u.p402o.AutoValue_PersistedInstallationEntry;
import p007b.p225i.p361c.p401u.p402o.IidStore;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallation;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;
import p007b.p225i.p361c.p401u.p403p.AutoValue_InstallationResponse;
import p007b.p225i.p361c.p401u.p403p.AutoValue_TokenResult;
import p007b.p225i.p361c.p401u.p403p.FirebaseInstallationServiceClient;
import p007b.p225i.p361c.p401u.p403p.InstallationResponse;
import p007b.p225i.p361c.p401u.p403p.TokenResult;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* JADX INFO: renamed from: b.i.c.u.f, reason: use source file name */
/* JADX INFO: compiled from: FirebaseInstallations.java */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseInstallations4 implements InterfaceC4843g {

    /* JADX INFO: renamed from: a */
    public static final Object f12928a = new Object();

    /* JADX INFO: renamed from: b */
    public static final ThreadFactory f12929b = new a();

    /* JADX INFO: renamed from: c */
    public final FirebaseApp2 f12930c;

    /* JADX INFO: renamed from: d */
    public final FirebaseInstallationServiceClient f12931d;

    /* JADX INFO: renamed from: e */
    public final PersistedInstallation f12932e;

    /* JADX INFO: renamed from: f */
    public final Utils6 f12933f;

    /* JADX INFO: renamed from: g */
    public final IidStore f12934g;

    /* JADX INFO: renamed from: h */
    public final RandomFidGenerator f12935h;

    /* JADX INFO: renamed from: i */
    public final Object f12936i;

    /* JADX INFO: renamed from: j */
    public final ExecutorService f12937j;

    /* JADX INFO: renamed from: k */
    public final ExecutorService f12938k;

    /* JADX INFO: renamed from: l */
    @GuardedBy("this")
    public String f12939l;

    /* JADX INFO: renamed from: m */
    @GuardedBy("lock")
    public final List<StateListener> f12940m;

    /* JADX INFO: renamed from: b.i.c.u.f$a */
    /* JADX INFO: compiled from: FirebaseInstallations.java */
    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: j */
        public final AtomicInteger f12941j = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f12941j.getAndIncrement())));
        }
    }

    public FirebaseInstallations4(FirebaseApp2 firebaseApp2, @NonNull Provider2<UserAgentPublisher> provider2, @NonNull Provider2<HeartBeatInfo> provider22) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = f12929b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, timeUnit, linkedBlockingQueue, threadFactory);
        firebaseApp2.m6330a();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp2.f12118d, provider2, provider22);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp2);
        Utils6 utils6M6770c = Utils6.m6770c();
        IidStore iidStore = new IidStore(firebaseApp2);
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.f12936i = new Object();
        this.f12940m = new ArrayList();
        this.f12930c = firebaseApp2;
        this.f12931d = firebaseInstallationServiceClient;
        this.f12932e = persistedInstallation;
        this.f12933f = utils6M6770c;
        this.f12934g = iidStore;
        this.f12935h = randomFidGenerator;
        this.f12937j = threadPoolExecutor;
        this.f12938k = new ThreadPoolExecutor(0, 1, 30L, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static FirebaseInstallations4 m6755f() {
        FirebaseApp2 firebaseApp2M6327b = FirebaseApp2.m6327b();
        AnimatableValueParser.m551o(true, "Null is not a valid value of FirebaseApp.");
        firebaseApp2M6327b.m6330a();
        return (FirebaseInstallations4) firebaseApp2M6327b.f12121g.mo6346a(InterfaceC4843g.class);
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4843g
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<AbstractC4847k> mo6756a(boolean z2) {
        m6762h();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.f12933f, taskCompletionSource);
        synchronized (this.f12936i) {
            this.f12940m.add(getAuthTokenListener);
        }
        Task task = taskCompletionSource.f20845a;
        this.f12937j.execute(new FirebaseInstallations2(this, z2));
        return task;
    }

    /* JADX INFO: renamed from: b */
    public final void m6757b(boolean z2) {
        PersistedInstallationEntry persistedInstallationEntryM6788b;
        synchronized (f12928a) {
            FirebaseApp2 firebaseApp2 = this.f12930c;
            firebaseApp2.m6330a();
            CrossProcessLock crossProcessLockM6753a = CrossProcessLock.m6753a(firebaseApp2.f12118d, "generatefid.lock");
            try {
                persistedInstallationEntryM6788b = this.f12932e.m6788b();
                if (persistedInstallationEntryM6788b.m6790i()) {
                    String strM6763i = m6763i(persistedInstallationEntryM6788b);
                    PersistedInstallation persistedInstallation = this.f12932e;
                    AutoValue_PersistedInstallationEntry.b bVar = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntryM6788b.mo6781k();
                    bVar.f12959a = strM6763i;
                    bVar.mo6783b(PersistedInstallation.a.UNREGISTERED);
                    persistedInstallationEntryM6788b = bVar.mo6782a();
                    persistedInstallation.m6787a(persistedInstallationEntryM6788b);
                }
            } finally {
                if (crossProcessLockM6753a != null) {
                    crossProcessLockM6753a.m6754b();
                }
            }
        }
        if (z2) {
            AutoValue_PersistedInstallationEntry.b bVar2 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntryM6788b.mo6781k();
            bVar2.f12961c = null;
            persistedInstallationEntryM6788b = bVar2.mo6782a();
        }
        m6766l(persistedInstallationEntryM6788b);
        this.f12938k.execute(new FirebaseInstallations3(this, z2));
    }

    /* JADX INFO: renamed from: c */
    public final PersistedInstallationEntry m6758c(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        int responseCode;
        TokenResult tokenResultM6808f;
        FirebaseInstallationsException.EnumC11081a enumC11081a = FirebaseInstallationsException.EnumC11081a.UNAVAILABLE;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.f12931d;
        String strM6759d = m6759d();
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.f12952b;
        String strM6761g = m6761g();
        String str2 = autoValue_PersistedInstallationEntry.f12955e;
        if (!firebaseInstallationServiceClient.f12994f.m6811a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
        }
        URL urlM6805a = firebaseInstallationServiceClient.m6805a(String.format("projects/%s/installations/%s/authTokens:generate", strM6761g, str));
        for (int i = 0; i <= 1; i++) {
            HttpURLConnection httpURLConnectionM6806c = firebaseInstallationServiceClient.m6806c(urlM6805a, strM6759d);
            try {
                httpURLConnectionM6806c.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnectionM6806c.addRequestProperty("Authorization", "FIS_v2 " + str2);
                httpURLConnectionM6806c.setDoOutput(true);
                firebaseInstallationServiceClient.m6810h(httpURLConnectionM6806c);
                responseCode = httpURLConnectionM6806c.getResponseCode();
                firebaseInstallationServiceClient.f12994f.m6812b(responseCode);
            } catch (IOException | AssertionError unused) {
            } catch (Throwable th) {
                httpURLConnectionM6806c.disconnect();
                throw th;
            }
            if (responseCode >= 200 && responseCode < 300) {
                tokenResultM6808f = firebaseInstallationServiceClient.m6808f(httpURLConnectionM6806c);
            } else {
                FirebaseInstallationServiceClient.m6802b(httpURLConnectionM6806c, null, strM6759d, strM6761g);
                if (responseCode == 401 || responseCode == 404) {
                    AutoValue_TokenResult.b bVar = (AutoValue_TokenResult.b) TokenResult.m6813a();
                    bVar.f12988c = TokenResult.b.AUTH_ERROR;
                    tokenResultM6808f = bVar.mo6800a();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.EnumC11081a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        AutoValue_TokenResult.b bVar2 = (AutoValue_TokenResult.b) TokenResult.m6813a();
                        bVar2.f12988c = TokenResult.b.BAD_CONFIG;
                        tokenResultM6808f = bVar2.mo6800a();
                    } else {
                        httpURLConnectionM6806c.disconnect();
                    }
                }
            }
            httpURLConnectionM6806c.disconnect();
            AutoValue_TokenResult autoValue_TokenResult = (AutoValue_TokenResult) tokenResultM6808f;
            int iOrdinal = autoValue_TokenResult.f12985c.ordinal();
            if (iOrdinal == 0) {
                String str3 = autoValue_TokenResult.f12983a;
                long j = autoValue_TokenResult.f12984b;
                long jM6772b = this.f12933f.m6772b();
                AutoValue_PersistedInstallationEntry.b bVar3 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.mo6781k();
                bVar3.f12961c = str3;
                bVar3.f12963e = Long.valueOf(j);
                bVar3.f12964f = Long.valueOf(jM6772b);
                return bVar3.mo6782a();
            }
            if (iOrdinal == 1) {
                AutoValue_PersistedInstallationEntry.b bVar4 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.mo6781k();
                bVar4.f12965g = "BAD CONFIG";
                bVar4.mo6783b(PersistedInstallation.a.REGISTER_ERROR);
                return bVar4.mo6782a();
            }
            if (iOrdinal != 2) {
                throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
            }
            synchronized (this) {
                this.f12939l = null;
            }
            PersistedInstallationEntry.a aVarMo6781k = persistedInstallationEntry.mo6781k();
            aVarMo6781k.mo6783b(PersistedInstallation.a.NOT_GENERATED);
            return aVarMo6781k.mo6782a();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public String m6759d() {
        FirebaseApp2 firebaseApp2 = this.f12930c;
        firebaseApp2.m6330a();
        return firebaseApp2.f12120f.f12134a;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public String m6760e() {
        FirebaseApp2 firebaseApp2 = this.f12930c;
        firebaseApp2.m6330a();
        return firebaseApp2.f12120f.f12135b;
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public String m6761g() {
        FirebaseApp2 firebaseApp2 = this.f12930c;
        firebaseApp2.m6330a();
        return firebaseApp2.f12120f.f12140g;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4843g
    @NonNull
    public Task<String> getId() {
        String str;
        m6762h();
        synchronized (this) {
            str = this.f12939l;
        }
        if (str != null) {
            return C3404f.m4264Z(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.f12936i) {
            this.f12940m.add(getIdListener);
        }
        Task task = taskCompletionSource.f20845a;
        this.f12937j.execute(new FirebaseInstallations(this));
        return task;
    }

    /* JADX INFO: renamed from: h */
    public final void m6762h() {
        AnimatableValueParser.m579v(m6760e(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.m579v(m6761g(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.m579v(m6759d(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String strM6760e = m6760e();
        Pattern pattern = Utils6.f12949b;
        AnimatableValueParser.m551o(strM6760e.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AnimatableValueParser.m551o(Utils6.f12949b.matcher(m6759d()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX INFO: renamed from: i */
    public final String m6763i(PersistedInstallationEntry persistedInstallationEntry) {
        String string;
        FirebaseApp2 firebaseApp2 = this.f12930c;
        firebaseApp2.m6330a();
        if (firebaseApp2.f12119e.equals("CHIME_ANDROID_SDK") || this.f12930c.m6334h()) {
            if (((AutoValue_PersistedInstallationEntry) persistedInstallationEntry).f12953c == PersistedInstallation.a.ATTEMPT_MIGRATION) {
                IidStore iidStore = this.f12934g;
                synchronized (iidStore.f12967b) {
                    synchronized (iidStore.f12967b) {
                        string = iidStore.f12967b.getString("|S|id", null);
                    }
                    if (string == null) {
                        string = iidStore.m6786a();
                    }
                }
                return TextUtils.isEmpty(string) ? this.f12935h.m6769a() : string;
            }
        }
        return this.f12935h.m6769a();
    }

    /* JADX INFO: renamed from: j */
    public final PersistedInstallationEntry m6764j(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        int responseCode;
        InstallationResponse installationResponseM6807e;
        FirebaseInstallationsException.EnumC11081a enumC11081a = FirebaseInstallationsException.EnumC11081a.UNAVAILABLE;
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) persistedInstallationEntry;
        String str = autoValue_PersistedInstallationEntry.f12952b;
        String string = null;
        if (str != null && str.length() == 11) {
            IidStore iidStore = this.f12934g;
            synchronized (iidStore.f12967b) {
                String[] strArr = IidStore.f12966a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str2 = strArr[i];
                    String string2 = iidStore.f12967b.getString("|T|" + iidStore.f12968c + "|" + str2, null);
                    if (string2 == null || string2.isEmpty()) {
                        i++;
                    } else if (string2.startsWith("{")) {
                        try {
                            string = new JSONObject(string2).getString("token");
                        } catch (JSONException unused) {
                        }
                    } else {
                        string = string2;
                    }
                }
            }
        }
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.f12931d;
        String strM6759d = m6759d();
        String str3 = autoValue_PersistedInstallationEntry.f12952b;
        String strM6761g = m6761g();
        String strM6760e = m6760e();
        if (!firebaseInstallationServiceClient.f12994f.m6811a()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
        }
        URL urlM6805a = firebaseInstallationServiceClient.m6805a(String.format("projects/%s/installations", strM6761g));
        for (int i2 = 0; i2 <= 1; i2++) {
            HttpURLConnection httpURLConnectionM6806c = firebaseInstallationServiceClient.m6806c(urlM6805a, strM6759d);
            try {
                try {
                    httpURLConnectionM6806c.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionM6806c.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionM6806c.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    firebaseInstallationServiceClient.m6809g(httpURLConnectionM6806c, str3, strM6760e);
                    responseCode = httpURLConnectionM6806c.getResponseCode();
                    firebaseInstallationServiceClient.f12994f.m6812b(responseCode);
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    installationResponseM6807e = firebaseInstallationServiceClient.m6807e(httpURLConnectionM6806c);
                } else {
                    FirebaseInstallationServiceClient.m6802b(httpURLConnectionM6806c, strM6760e, strM6759d, strM6761g);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.EnumC11081a.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        AutoValue_InstallationResponse autoValue_InstallationResponse = new AutoValue_InstallationResponse(null, null, null, null, InstallationResponse.a.BAD_CONFIG, null);
                        httpURLConnectionM6806c.disconnect();
                        installationResponseM6807e = autoValue_InstallationResponse;
                    } else {
                        httpURLConnectionM6806c.disconnect();
                    }
                }
                AutoValue_InstallationResponse autoValue_InstallationResponse2 = (AutoValue_InstallationResponse) installationResponseM6807e;
                int iOrdinal = autoValue_InstallationResponse2.f12982e.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
                    }
                    AutoValue_PersistedInstallationEntry.b bVar = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.mo6781k();
                    bVar.f12965g = "BAD CONFIG";
                    bVar.mo6783b(PersistedInstallation.a.REGISTER_ERROR);
                    return bVar.mo6782a();
                }
                String str4 = autoValue_InstallationResponse2.f12979b;
                String str5 = autoValue_InstallationResponse2.f12980c;
                long jM6772b = this.f12933f.m6772b();
                String strMo6798c = autoValue_InstallationResponse2.f12981d.mo6798c();
                long jMo6799d = autoValue_InstallationResponse2.f12981d.mo6799d();
                AutoValue_PersistedInstallationEntry.b bVar2 = (AutoValue_PersistedInstallationEntry.b) persistedInstallationEntry.mo6781k();
                bVar2.f12959a = str4;
                bVar2.mo6783b(PersistedInstallation.a.REGISTERED);
                bVar2.f12961c = strMo6798c;
                bVar2.f12962d = str5;
                bVar2.f12963e = Long.valueOf(jMo6799d);
                bVar2.f12964f = Long.valueOf(jM6772b);
                return bVar2.mo6782a();
            } finally {
                httpURLConnectionM6806c.disconnect();
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", enumC11081a);
    }

    /* JADX INFO: renamed from: k */
    public final void m6765k(Exception exc) {
        synchronized (this.f12936i) {
            Iterator<StateListener> it = this.f12940m.iterator();
            while (it.hasNext()) {
                if (it.next().mo6767a(exc)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m6766l(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f12936i) {
            Iterator<StateListener> it = this.f12940m.iterator();
            while (it.hasNext()) {
                if (it.next().mo6768b(persistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }
}
