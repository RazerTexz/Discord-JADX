package p007b.p225i.p361c.p369m.p370d.p373k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p226a.p228b.TransportFactory;
import p007b.p225i.p226a.p228b.p229i.CCTDestination;
import p007b.p225i.p226a.p228b.p231j.TransportFactoryImpl;
import p007b.p225i.p226a.p228b.p231j.TransportRuntime;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.NativeSessionFileProvider;
import p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p374l.LogFileManager;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_FilesPayload;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Application;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_Device;
import p007b.p225i.p361c.p369m.p370d.p375m.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p369m.p370d.p375m.ImmutableList3;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence2;
import p007b.p225i.p361c.p369m.p370d.p378o.CrashlyticsReportPersistence7;
import p007b.p225i.p361c.p369m.p370d.p378o.FileStoreImpl;
import p007b.p225i.p361c.p369m.p370d.p379p.ByteString2;
import p007b.p225i.p361c.p369m.p370d.p379p.ClsFileOutputStream;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;
import p007b.p225i.p361c.p369m.p370d.p379p.SessionProtobufHelper;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportManager;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportUploader;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2;
import p007b.p225i.p361c.p369m.p370d.p383r.DataTransportCrashlyticsReportSender3;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;
import p007b.p225i.p361c.p369m.p370d.p387t.MiddleOutFallbackStrategy;
import p007b.p225i.p361c.p369m.p370d.p387t.RemoveRepeatsStrategy;
import p007b.p225i.p361c.p369m.p370d.p387t.StackTraceTrimmingStrategy;
import p007b.p225i.p361c.p369m.p370d.p387t.TrimmedThrowableData;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.x */
/* loaded from: classes3.dex */
public class C4663x {

    /* renamed from: a */
    public static final FilenameFilter f12415a = new a("BeginSession");

    /* renamed from: b */
    public static final FilenameFilter f12416b = new b();

    /* renamed from: c */
    public static final Comparator<File> f12417c = new c();

    /* renamed from: d */
    public static final Comparator<File> f12418d = new d();

    /* renamed from: e */
    public static final Pattern f12419e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: f */
    public static final Map<String, String> f12420f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* renamed from: g */
    public static final String[] f12421g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* renamed from: A */
    public final SessionReportingCoordinator3 f12422A;

    /* renamed from: B */
    public CrashlyticsUncaughtExceptionHandler f12423B;

    /* renamed from: i */
    public final Context f12429i;

    /* renamed from: j */
    public final DataCollectionArbiter f12430j;

    /* renamed from: k */
    public final CrashlyticsFileMarker f12431k;

    /* renamed from: l */
    public final UserMetadata f12432l;

    /* renamed from: m */
    public final CrashlyticsBackgroundWorker f12433m;

    /* renamed from: n */
    public final HttpRequestFactory f12434n;

    /* renamed from: o */
    public final IdManager f12435o;

    /* renamed from: p */
    public final FileStoreImpl f12436p;

    /* renamed from: q */
    public final AppData f12437q;

    /* renamed from: s */
    public final j f12439s;

    /* renamed from: t */
    public final LogFileManager f12440t;

    /* renamed from: u */
    public final ReportManager f12441u;

    /* renamed from: v */
    public final ReportUploader.a f12442v;

    /* renamed from: w */
    public final CrashlyticsNativeComponent f12443w;

    /* renamed from: x */
    public final StackTraceTrimmingStrategy f12444x;

    /* renamed from: y */
    public final String f12445y;

    /* renamed from: z */
    public final AnalyticsEventLogger f12446z;

    /* renamed from: h */
    public final AtomicInteger f12428h = new AtomicInteger(0);

    /* renamed from: C */
    public TaskCompletionSource<Boolean> f12424C = new TaskCompletionSource<>();

    /* renamed from: D */
    public TaskCompletionSource<Boolean> f12425D = new TaskCompletionSource<>();

    /* renamed from: E */
    public TaskCompletionSource<Void> f12426E = new TaskCompletionSource<>();

    /* renamed from: F */
    public AtomicBoolean f12427F = new AtomicBoolean(false);

    /* renamed from: r */
    public final ReportUploader.b f12438r = new C4629h0(this);

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$a */
    public class a extends h {
        public a(String str) {
            super(str);
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.h, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$b */
    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$c */
    public class c implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$d */
    public class d implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$e */
    public class e implements InterfaceC4362f<Boolean, Void> {

        /* renamed from: a */
        public final /* synthetic */ Task f12447a;

        /* renamed from: b */
        public final /* synthetic */ float f12448b;

        public e(Task task, float f) {
            this.f12447a = task;
            this.f12448b = f;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
        @NonNull
        /* renamed from: a */
        public Task<Void> mo4013a(@Nullable Boolean bool) throws Exception {
            return C4663x.this.f12433m.m6438c(new CallableC4626g0(this, bool));
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$f */
    public static class f implements FilenameFilter {
        public f(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !((b) C4663x.f12416b).accept(file, str) && C4663x.f12419e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$g */
    public interface g {
        /* renamed from: a */
        void mo6454a(CodedOutputStream2 codedOutputStream2) throws Exception;
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$h */
    public static class h implements FilenameFilter {

        /* renamed from: a */
        public final String f12450a;

        public h(String str) {
            this.f12450a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f12450a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$i */
    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ((ClsFileOutputStream.a) ClsFileOutputStream.f12686j).accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$j */
    public static final class j implements LogFileManager.b {

        /* renamed from: a */
        public final FileStoreImpl f12451a;

        public j(FileStoreImpl fileStoreImpl) {
            this.f12451a = fileStoreImpl;
        }

        /* renamed from: a */
        public File m6487a() {
            File file = new File(this.f12451a.m6636a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$k */
    public final class k implements ReportUploader.c {
        public k(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$l */
    public final class l implements ReportUploader.a {
        public l(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$m */
    public static final class m implements Runnable {

        /* renamed from: j */
        public final Context f12454j;

        /* renamed from: k */
        public final Report2 f12455k;

        /* renamed from: l */
        public final ReportUploader f12456l;

        /* renamed from: m */
        public final boolean f12457m;

        public m(Context context, Report2 report2, ReportUploader reportUploader, boolean z2) {
            this.f12454j = context;
            this.f12455k = report2;
            this.f12456l = reportUploader;
            this.f12457m = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.m6408b(this.f12454j)) {
                Logger3.f12227a.m6371b("Attempting to send crash report at time of crash...");
                this.f12456l.m6670a(this.f12455k, this.f12457m);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: b.i.c.m.d.k.x$n */
    public static class n implements FilenameFilter {

        /* renamed from: a */
        public final String f12458a;

        public n(String str) {
            this.f12458a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12458a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f12458a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    public C4663x(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStoreImpl fileStoreImpl, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, ReportManager reportManager, ReportUploader.b bVar, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger, SettingsDataProvider settingsDataProvider) {
        this.f12429i = context;
        this.f12433m = crashlyticsBackgroundWorker;
        this.f12434n = httpRequestFactory;
        this.f12435o = idManager;
        this.f12430j = dataCollectionArbiter;
        this.f12436p = fileStoreImpl;
        this.f12431k = crashlyticsFileMarker;
        this.f12437q = appData;
        this.f12443w = crashlyticsNativeComponent;
        this.f12445y = appData.f12265g.m6697a();
        this.f12446z = analyticsEventLogger;
        UserMetadata userMetadata = new UserMetadata();
        this.f12432l = userMetadata;
        j jVar = new j(fileStoreImpl);
        this.f12439s = jVar;
        LogFileManager logFileManager = new LogFileManager(context, jVar);
        this.f12440t = logFileManager;
        this.f12441u = new ReportManager(new k(null));
        this.f12442v = new l(null);
        MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
        this.f12444x = middleOutFallbackStrategy;
        File file = new File(new File(fileStoreImpl.f12683a.getFilesDir(), ".com.google.firebase.crashlytics").getPath());
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = new CrashlyticsReportDataCapture(context, idManager, appData, middleOutFallbackStrategy);
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = new CrashlyticsReportPersistence7(file, settingsDataProvider);
        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = DataTransportCrashlyticsReportSender3.f12723a;
        TransportRuntime.m2360b(context);
        TransportFactory transportFactoryM2361c = TransportRuntime.m2359a().m2361c(new CCTDestination(DataTransportCrashlyticsReportSender3.f12724b, DataTransportCrashlyticsReportSender3.f12725c));
        Encoding2 encoding2 = new Encoding2("json");
        Transformer<CrashlyticsReport, byte[]> transformer = DataTransportCrashlyticsReportSender3.f12726d;
        this.f12422A = new SessionReportingCoordinator3(crashlyticsReportDataCapture, crashlyticsReportPersistence7, new DataTransportCrashlyticsReportSender3(((TransportFactoryImpl) transportFactoryM2361c).mo2291a("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, encoding2, transformer), transformer), logFileManager, userMetadata);
    }

    /* renamed from: A */
    public static void m6460A(CodedOutputStream2 codedOutputStream2, File file) throws Throwable {
        if (!file.exists()) {
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Tried to include a file that doesn't exist: ");
            sbM833U.append(file.getName());
            logger3.m6373d(sbM833U.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                m6464e(fileInputStream2, codedOutputStream2, (int) file.length());
                CommonUtils.m6409c(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CommonUtils.m6409c(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m6461a(C4663x c4663x) throws Exception {
        String str;
        String str2;
        Integer num;
        Objects.requireNonNull(c4663x);
        long jM6465j = m6465j();
        new CLSUUID(c4663x.f12435o);
        String str3 = CLSUUID.f12293b;
        Logger3 logger3 = Logger3.f12227a;
        outline.m868o0("Opening a new session with ID ", str3, logger3);
        c4663x.f12443w.mo6369h(str3);
        Locale locale = Locale.US;
        String str4 = String.format(locale, "Crashlytics Android SDK/%s", "17.3.0");
        c4663x.m6486z(str3, "BeginSession", new C4657u(c4663x, str3, str4, jM6465j));
        c4663x.f12443w.mo6365d(str3, str4, jM6465j);
        IdManager idManager = c4663x.f12435o;
        String str5 = idManager.f12411e;
        AppData appData = c4663x.f12437q;
        String str6 = appData.f12263e;
        String str7 = appData.f12264f;
        String strM6456b = idManager.m6456b();
        int iM6453g = DeliveryMechanism.m6452f(c4663x.f12437q.f12261c).m6453g();
        c4663x.m6486z(str3, "SessionApp", new C4659v(c4663x, str5, str6, str7, strM6456b, iM6453g));
        c4663x.f12443w.mo6367f(str3, str5, str6, str7, strM6456b, iM6453g, c4663x.f12445y);
        String str8 = Build.VERSION.RELEASE;
        String str9 = Build.VERSION.CODENAME;
        boolean zM6427u = CommonUtils.m6427u(c4663x.f12429i);
        c4663x.m6486z(str3, "SessionOS", new C4661w(c4663x, str8, str9, zM6427u));
        c4663x.f12443w.mo6368g(str3, str8, str9, zM6427u);
        Context context = c4663x.f12429i;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        CommonUtils.b bVar = CommonUtils.b.UNKNOWN;
        String str10 = Build.CPU_ABI;
        if (TextUtils.isEmpty(str10)) {
            logger3.m6371b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            CommonUtils.b bVar2 = CommonUtils.b.f12310t.get(str10.toLowerCase(locale));
            if (bVar2 != null) {
                bVar = bVar2;
            }
        }
        int iOrdinal = bVar.ordinal();
        String str11 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jM6422p = CommonUtils.m6422p();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean zM6425s = CommonUtils.m6425s(context);
        int iM6417k = CommonUtils.m6417k(context);
        String str12 = Build.MANUFACTURER;
        String str13 = Build.PRODUCT;
        c4663x.m6486z(str3, "SessionDevice", new C4665y(c4663x, iOrdinal, str11, iAvailableProcessors, jM6422p, blockCount, zM6425s, iM6417k, str12, str13));
        c4663x.f12443w.mo6364c(str3, iOrdinal, str11, iAvailableProcessors, jM6422p, blockCount, zM6425s, iM6417k, str12, str13);
        c4663x.f12440t.m6496a(str3);
        SessionReportingCoordinator3 sessionReportingCoordinator3 = c4663x.f12422A;
        String strM6468t = m6468t(str3);
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = sessionReportingCoordinator3.f12278a;
        Objects.requireNonNull(crashlyticsReportDataCapture);
        Charset charset = CrashlyticsReport.f12647a;
        AutoValue_CrashlyticsReport.b bVar3 = new AutoValue_CrashlyticsReport.b();
        bVar3.f12526a = "17.3.0";
        String str14 = crashlyticsReportDataCapture.f12357e.f12259a;
        Objects.requireNonNull(str14, "Null gmpAppId");
        bVar3.f12527b = str14;
        String strM6456b2 = crashlyticsReportDataCapture.f12356d.m6456b();
        Objects.requireNonNull(strM6456b2, "Null installationUuid");
        bVar3.f12529d = strM6456b2;
        String str15 = crashlyticsReportDataCapture.f12357e.f12263e;
        Objects.requireNonNull(str15, "Null buildVersion");
        bVar3.f12530e = str15;
        String str16 = crashlyticsReportDataCapture.f12357e.f12264f;
        Objects.requireNonNull(str16, "Null displayVersion");
        bVar3.f12531f = str16;
        bVar3.f12528c = 4;
        AutoValue_CrashlyticsReport_Session.b bVar4 = new AutoValue_CrashlyticsReport_Session.b();
        bVar4.m6544b(false);
        bVar4.f12553c = Long.valueOf(jM6465j);
        Objects.requireNonNull(strM6468t, "Null identifier");
        bVar4.f12552b = strM6468t;
        String str17 = CrashlyticsReportDataCapture.f12353a;
        Objects.requireNonNull(str17, "Null generator");
        bVar4.f12551a = str17;
        String str18 = crashlyticsReportDataCapture.f12356d.f12411e;
        Objects.requireNonNull(str18, "Null identifier");
        String str19 = crashlyticsReportDataCapture.f12357e.f12263e;
        Objects.requireNonNull(str19, "Null version");
        String str20 = crashlyticsReportDataCapture.f12357e.f12264f;
        String strM6456b3 = crashlyticsReportDataCapture.f12356d.m6456b();
        String strM6697a = crashlyticsReportDataCapture.f12357e.f12265g.m6697a();
        if (strM6697a != null) {
            str2 = strM6697a;
            str = "Unity";
        } else {
            str = null;
            str2 = null;
        }
        bVar4.f12556f = new AutoValue_CrashlyticsReport_Session_Application(str18, str19, str20, null, strM6456b3, str, str2, null);
        Integer num2 = 3;
        Objects.requireNonNull(str8, "Null version");
        Objects.requireNonNull(str9, "Null buildVersion");
        Boolean boolValueOf = Boolean.valueOf(CommonUtils.m6427u(crashlyticsReportDataCapture.f12355c));
        String strM883w = num2 == null ? " platform" : "";
        if (boolValueOf == null) {
            strM883w = outline.m883w(strM883w, " jailbroken");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }
        bVar4.f12558h = new AutoValue_CrashlyticsReport_Session_OperatingSystem(num2.intValue(), str8, str9, boolValueOf.booleanValue(), null);
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str10) && (num = CrashlyticsReportDataCapture.f12354b.get(str10.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jM6422p2 = CommonUtils.m6422p();
        long blockCount2 = statFs2.getBlockCount() * statFs2.getBlockSize();
        boolean zM6425s2 = CommonUtils.m6425s(crashlyticsReportDataCapture.f12355c);
        int iM6417k2 = CommonUtils.m6417k(crashlyticsReportDataCapture.f12355c);
        AutoValue_CrashlyticsReport_Session_Device.b bVar5 = new AutoValue_CrashlyticsReport_Session_Device.b();
        bVar5.f12578a = Integer.valueOf(iIntValue);
        Objects.requireNonNull(str11, "Null model");
        bVar5.f12579b = str11;
        bVar5.f12580c = Integer.valueOf(iAvailableProcessors2);
        bVar5.f12581d = Long.valueOf(jM6422p2);
        bVar5.f12582e = Long.valueOf(blockCount2);
        bVar5.f12583f = Boolean.valueOf(zM6425s2);
        bVar5.f12584g = Integer.valueOf(iM6417k2);
        Objects.requireNonNull(str12, "Null manufacturer");
        bVar5.f12585h = str12;
        Objects.requireNonNull(str13, "Null modelClass");
        bVar5.f12586i = str13;
        bVar4.f12559i = bVar5.m6562a();
        bVar4.f12561k = 3;
        bVar3.f12532g = bVar4.mo6543a();
        CrashlyticsReport crashlyticsReportMo6524a = bVar3.mo6524a();
        CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = sessionReportingCoordinator3.f12279b;
        Objects.requireNonNull(crashlyticsReportPersistence7);
        CrashlyticsReport.d dVarMo6522h = crashlyticsReportMo6524a.mo6522h();
        if (dVarMo6522h == null) {
            logger3.m6371b("Could not get session for report");
            return;
        }
        String strMo6537g = dVarMo6522h.mo6537g();
        try {
            File fileM6635h = crashlyticsReportPersistence7.m6635h(strMo6537g);
            CrashlyticsReportPersistence7.m6628i(fileM6635h);
            CrashlyticsReportPersistence7.m6631l(new File(fileM6635h, "report"), CrashlyticsReportPersistence7.f12674c.m6620g(crashlyticsReportMo6524a));
        } catch (IOException e2) {
            Logger3.f12227a.m6372c("Could not persist report for session " + strMo6537g, e2);
        }
    }

    /* renamed from: b */
    public static Task m6462b(C4663x c4663x) {
        boolean z2;
        Task taskM4323o;
        Objects.requireNonNull(c4663x);
        ArrayList arrayList = new ArrayList();
        for (File file : m6467r(c4663x.m6476l(), C4641m.f12347a)) {
            try {
                long j2 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    Logger3.f12227a.m6371b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskM4323o = C3404f.m4264Z(null);
                } else {
                    taskM4323o = C3404f.m4323o(new ScheduledThreadPoolExecutor(1), new CallableC4608a0(c4663x, j2));
                }
                arrayList.add(taskM4323o);
            } catch (NumberFormatException unused2) {
                Logger3 logger3 = Logger3.f12227a;
                StringBuilder sbM833U = outline.m833U("Could not parse timestamp from file ");
                sbM833U.append(file.getName());
                logger3.m6371b(sbM833U.toString());
            }
            file.delete();
        }
        return C3404f.m4194B1(arrayList);
    }

    /* renamed from: c */
    public static void m6463c(@Nullable String str, @NonNull File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        CodedOutputStream2 codedOutputStream2M6646i = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                codedOutputStream2M6646i = CodedOutputStream2.m6646i(fileOutputStream);
                ByteString2 byteString2 = SessionProtobufHelper.f12694a;
                ByteString2 byteString2M6637a = ByteString2.m6637a(str);
                codedOutputStream2M6646i.m6654r(7, 2);
                int iM6640b = CodedOutputStream2.m6640b(2, byteString2M6637a);
                codedOutputStream2M6646i.m6652o(CodedOutputStream2.m6642d(iM6640b) + CodedOutputStream2.m6643e(5) + iM6640b);
                codedOutputStream2M6646i.m6654r(5, 2);
                codedOutputStream2M6646i.m6652o(iM6640b);
                codedOutputStream2M6646i.m6649l(2, byteString2M6637a);
                StringBuilder sbM833U = outline.m833U("Failed to flush to append to ");
                sbM833U.append(file.getPath());
                CommonUtils.m6414h(codedOutputStream2M6646i, sbM833U.toString());
                CommonUtils.m6409c(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                StringBuilder sbM833U2 = outline.m833U("Failed to flush to append to ");
                sbM833U2.append(file.getPath());
                CommonUtils.m6414h(codedOutputStream2M6646i, sbM833U2.toString());
                CommonUtils.m6409c(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* renamed from: e */
    public static void m6464e(InputStream inputStream, CodedOutputStream2 codedOutputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                break;
            } else {
                i3 += i4;
            }
        }
        Objects.requireNonNull(codedOutputStream2);
        int i5 = codedOutputStream2.f12691k;
        int i6 = codedOutputStream2.f12692l;
        int i7 = i5 - i6;
        if (i7 >= i2) {
            System.arraycopy(bArr, 0, codedOutputStream2.f12690j, i6, i2);
            codedOutputStream2.f12692l += i2;
            return;
        }
        System.arraycopy(bArr, 0, codedOutputStream2.f12690j, i6, i7);
        int i8 = i7 + 0;
        int i9 = i2 - i7;
        codedOutputStream2.f12692l = codedOutputStream2.f12691k;
        codedOutputStream2.m6647j();
        if (i9 > codedOutputStream2.f12691k) {
            codedOutputStream2.f12693m.write(bArr, i8, i9);
        } else {
            System.arraycopy(bArr, i8, codedOutputStream2.f12690j, 0, i9);
            codedOutputStream2.f12692l = i9;
        }
    }

    /* renamed from: j */
    public static long m6465j() {
        return new Date().getTime() / 1000;
    }

    /* renamed from: o */
    public static String m6466o(File file) {
        return file.getName().substring(0, 35);
    }

    /* renamed from: r */
    public static File[] m6467r(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    @NonNull
    /* renamed from: t */
    public static String m6468t(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    /* renamed from: x */
    public static void m6469x(CodedOutputStream2 codedOutputStream2, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, CommonUtils.f12299c);
        for (File file : fileArr) {
            try {
                Logger3.f12227a.m6371b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                m6460A(codedOutputStream2, file);
            } catch (Exception e2) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Error writting non-fatal to session.", e2);
                }
            }
        }
    }

    /* renamed from: d */
    public final void m6470d(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream == null) {
            return;
        }
        try {
            clsFileOutputStream.m6638a();
        } catch (IOException e2) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Error closing session file stream in the presence of an exception", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04a2 A[LOOP:6: B:151:0x04a0->B:152:0x04a2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0646 A[Catch: IOException -> 0x0685, TryCatch #14 {IOException -> 0x0685, blocks: (B:217:0x062d, B:219:0x0646, B:222:0x0669, B:223:0x067d, B:224:0x0684), top: B:250:0x062d }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x067d A[Catch: IOException -> 0x0685, TryCatch #14 {IOException -> 0x0685, blocks: (B:217:0x062d, B:219:0x0646, B:222:0x0669, B:223:0x067d, B:224:0x0684), top: B:250:0x062d }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x06d8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030e  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6471f(int i2, boolean z2) throws Exception {
        FileInputStream fileInputStream;
        UserMetadata userMetadata;
        int i3;
        List<File> listM6626f;
        int size;
        String strM6629j;
        File file;
        String str;
        CrashlyticsReport crashlyticsReportM6612j;
        CodedOutputStream2 codedOutputStream2M6646i;
        ClsFileOutputStream clsFileOutputStream;
        String str2;
        InputStream inputStreamMo6394h;
        int i4 = i2;
        int i5 = (z2 ? 1 : 0) + 8;
        HashSet hashSet = new HashSet();
        File[] fileArrM6481s = m6481s();
        int iMin = Math.min(i5, fileArrM6481s.length);
        for (int i6 = 0; i6 < iMin; i6++) {
            hashSet.add(m6466o(fileArrM6481s[i6]));
        }
        File[] fileArrListFiles = ((j) this.f12440t.f12472c).m6487a().listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                int iLastIndexOf = name.lastIndexOf(".temp");
                if (iLastIndexOf != -1) {
                    name = name.substring(20, iLastIndexOf);
                }
                if (!hashSet.contains(name)) {
                    file2.delete();
                }
            }
        }
        FileInputStream fileInputStream2 = null;
        for (File file3 : m6467r(m6476l(), new f(null))) {
            String name2 = file3.getName();
            Matcher matcher = f12419e.matcher(name2);
            if (!matcher.matches()) {
                Logger3.f12227a.m6371b("Deleting unknown file: " + name2);
                file3.delete();
            } else if (!hashSet.contains(matcher.group(1))) {
                Logger3.f12227a.m6371b("Trimming session file: " + name2);
                file3.delete();
            }
        }
        File[] fileArrM6481s2 = m6481s();
        if (fileArrM6481s2.length <= z2) {
            Logger3.f12227a.m6371b("No open sessions to be closed.");
            return;
        }
        String strM6466o = m6466o(fileArrM6481s2[z2 ? 1 : 0]);
        if (m6479p()) {
            userMetadata = this.f12432l;
        } else {
            File fileM6490b = new MetaDataStore2(m6476l()).m6490b(strM6466o);
            if (fileM6490b.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(fileM6490b);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                }
                try {
                    userMetadata = MetaDataStore2.m6488c(CommonUtils.m6430x(fileInputStream));
                    CommonUtils.m6409c(fileInputStream, "Failed to close user metadata file.");
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    if (Logger3.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                    }
                    CommonUtils.m6409c(fileInputStream2, "Failed to close user metadata file.");
                    userMetadata = new UserMetadata();
                    m6486z(strM6466o, "SessionUser", new C4667z(this, userMetadata));
                    String str3 = "report";
                    String str4 = "user";
                    if (this.f12443w.mo6366e(strM6466o)) {
                    }
                    Logger3.f12227a.m6371b("Closing open sessions.");
                    i3 = z2 ? 1 : 0;
                    while (i3 < fileArrM6481s2.length) {
                    }
                    String str5 = str3;
                    String str6 = str4;
                    if (z2 == 0) {
                    }
                    SessionReportingCoordinator3 sessionReportingCoordinator3 = this.f12422A;
                    long jM6465j = m6465j();
                    CrashlyticsReportPersistence7 crashlyticsReportPersistence7 = sessionReportingCoordinator3.f12279b;
                    listM6626f = CrashlyticsReportPersistence7.m6626f(crashlyticsReportPersistence7.f12678g, new CrashlyticsReportPersistence2(strM6468t));
                    Collections.sort(listM6626f, CrashlyticsReportPersistence7.f12675d);
                    if (listM6626f.size() > 8) {
                    }
                    while (r6.hasNext()) {
                    }
                    Objects.requireNonNull(((SettingsController) crashlyticsReportPersistence7.f12682k).m6685c().mo6690b());
                    ArrayList arrayList = (ArrayList) crashlyticsReportPersistence7.m6634e();
                    size = arrayList.size();
                    if (size > 4) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.m6409c(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } else {
                userMetadata = new UserMetadata();
            }
        }
        m6486z(strM6466o, "SessionUser", new C4667z(this, userMetadata));
        String str32 = "report";
        String str42 = "user";
        if (this.f12443w.mo6366e(strM6466o)) {
            Logger3 logger3 = Logger3.f12227a;
            outline.m868o0("Finalizing native report for session ", strM6466o, logger3);
            NativeSessionFileProvider nativeSessionFileProviderMo6363b = this.f12443w.mo6363b(strM6466o);
            File fileMo6380d = nativeSessionFileProviderMo6363b.mo6380d();
            if (fileMo6380d == null || !fileMo6380d.exists()) {
                logger3.m6376g("No minidump data found for session " + strM6466o);
            } else {
                long jLastModified = fileMo6380d.lastModified();
                LogFileManager logFileManager = new LogFileManager(this.f12429i, this.f12439s, strM6466o);
                File file4 = new File(m6477m(), strM6466o);
                if (file4.mkdirs()) {
                    m6472g(jLastModified);
                    File fileM6476l = m6476l();
                    byte[] bArrMo6493c = logFileManager.f12473d.mo6493c();
                    MetaDataStore2 metaDataStore2 = new MetaDataStore2(fileM6476l);
                    File fileM6490b2 = metaDataStore2.m6490b(strM6466o);
                    File fileM6489a = metaDataStore2.m6489a(strM6466o);
                    ArrayList<NativeSessionFile> arrayList2 = new ArrayList();
                    arrayList2.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArrMo6493c));
                    arrayList2.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProviderMo6363b.mo6382f()));
                    arrayList2.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProviderMo6363b.mo6381e()));
                    arrayList2.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProviderMo6363b.mo6377a()));
                    arrayList2.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProviderMo6363b.mo6379c()));
                    arrayList2.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProviderMo6363b.mo6378b()));
                    arrayList2.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProviderMo6363b.mo6380d()));
                    arrayList2.add(new FileBackedNativeSessionFile("user_meta_file", "user", fileM6490b2));
                    arrayList2.add(new FileBackedNativeSessionFile("keys_file", "keys", fileM6489a));
                    for (NativeSessionFile nativeSessionFile : arrayList2) {
                        try {
                            inputStreamMo6394h = nativeSessionFile.mo6394h();
                            if (inputStreamMo6394h != null) {
                                try {
                                    C3404f.m4344t0(inputStreamMo6394h, new File(file4, nativeSessionFile.mo6392a()));
                                } catch (IOException unused) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    CommonUtils.m6410d(inputStreamMo6394h);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            inputStreamMo6394h = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamMo6394h = null;
                        }
                        CommonUtils.m6410d(inputStreamMo6394h);
                    }
                    SessionReportingCoordinator3 sessionReportingCoordinator32 = this.f12422A;
                    String strReplaceAll = strM6466o.replaceAll("-", "");
                    Objects.requireNonNull(sessionReportingCoordinator32);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        CrashlyticsReport.c.a aVarMo6393b = ((NativeSessionFile) it.next()).mo6393b();
                        if (aVarMo6393b != null) {
                            arrayList3.add(aVarMo6393b);
                        }
                    }
                    CrashlyticsReportPersistence7 crashlyticsReportPersistence72 = sessionReportingCoordinator32.f12279b;
                    AutoValue_CrashlyticsReport_FilesPayload autoValue_CrashlyticsReport_FilesPayload = new AutoValue_CrashlyticsReport_FilesPayload(new ImmutableList3(arrayList3), null, null);
                    Objects.requireNonNull(crashlyticsReportPersistence72);
                    File file5 = new File(crashlyticsReportPersistence72.m6635h(strReplaceAll), "report");
                    File file6 = crashlyticsReportPersistence72.f12681j;
                    try {
                        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = CrashlyticsReportPersistence7.f12674c;
                        AutoValue_CrashlyticsReport.b bVar = (AutoValue_CrashlyticsReport.b) crashlyticsReportJsonTransform8.m6619f(CrashlyticsReportPersistence7.m6629j(file5)).mo6523i();
                        bVar.f12532g = null;
                        bVar.f12533h = autoValue_CrashlyticsReport_FilesPayload;
                        CrashlyticsReport crashlyticsReportMo6524a = bVar.mo6524a();
                        CrashlyticsReportPersistence7.m6628i(file6);
                        CrashlyticsReportPersistence7.m6631l(new File(file6, strReplaceAll), crashlyticsReportJsonTransform8.m6620g(crashlyticsReportMo6524a));
                    } catch (IOException e4) {
                        Logger3.f12227a.m6372c("Could not synthesize final native report file for " + file5, e4);
                    }
                    logFileManager.f12473d.mo6494d();
                } else {
                    logger3.m6371b("Couldn't create native sessions directory");
                }
            }
            if (!this.f12443w.mo6362a(strM6466o)) {
                outline.m868o0("Could not finalize native session: ", strM6466o, Logger3.f12227a);
            }
        }
        Logger3.f12227a.m6371b("Closing open sessions.");
        i3 = z2 ? 1 : 0;
        while (i3 < fileArrM6481s2.length) {
            File file7 = fileArrM6481s2[i3];
            String strM6466o2 = m6466o(file7);
            Logger3 logger32 = Logger3.f12227a;
            logger32.m6371b("Closing session: " + strM6466o2);
            logger32.m6371b("Collecting session parts for ID " + strM6466o2);
            File[] fileArrM6467r = m6467r(m6476l(), new h(outline.m883w(strM6466o2, "SessionCrash")));
            boolean z3 = fileArrM6467r.length > 0;
            Locale locale = Locale.US;
            logger32.m6371b(String.format(locale, "Session %s has fatal exception: %s", strM6466o2, Boolean.valueOf(z3)));
            File[] fileArrM6467r2 = m6467r(m6476l(), new h(outline.m883w(strM6466o2, "SessionEvent")));
            boolean z4 = fileArrM6467r2.length > 0;
            String str7 = str32;
            logger32.m6371b(String.format(locale, "Session %s has non-fatal exceptions: %s", strM6466o2, Boolean.valueOf(z4)));
            if (z3 || z4) {
                if (fileArrM6467r2.length > i4) {
                    logger32.m6371b(String.format(locale, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
                    m6483v(strM6466o2, i4);
                    fileArrM6467r2 = m6467r(m6476l(), new h(outline.m883w(strM6466o2, "SessionEvent")));
                }
                File file8 = z3 ? fileArrM6467r[0] : null;
                boolean z5 = file8 != null;
                File fileM6475k = z5 ? m6475k() : m6478n();
                if (!fileM6475k.exists()) {
                    fileM6475k.mkdirs();
                }
                try {
                    clsFileOutputStream = new ClsFileOutputStream(fileM6475k, strM6466o2);
                    try {
                        codedOutputStream2M6646i = CodedOutputStream2.m6646i(clsFileOutputStream);
                        try {
                            try {
                                logger32.m6371b("Collecting SessionStart data for session ID " + strM6466o2);
                                m6460A(codedOutputStream2M6646i, file7);
                                str2 = str42;
                            } catch (Exception e5) {
                                e = e5;
                                str2 = str42;
                            }
                            try {
                                codedOutputStream2M6646i.m6656t(4, m6465j());
                                codedOutputStream2M6646i.m6648k(5, z5);
                                codedOutputStream2M6646i.m6655s(11, 1);
                                codedOutputStream2M6646i.m6650m(12, 3);
                                m6484w(codedOutputStream2M6646i, strM6466o2);
                                m6469x(codedOutputStream2M6646i, fileArrM6467r2, strM6466o2);
                                if (z5) {
                                    m6460A(codedOutputStream2M6646i, file8);
                                }
                                CommonUtils.m6414h(codedOutputStream2M6646i, "Error flushing session file stream");
                                CommonUtils.m6409c(clsFileOutputStream, "Failed to close CLS file");
                            } catch (Exception e6) {
                                e = e6;
                                Logger3.f12227a.m6374e("Failed to write session file for session ID: " + strM6466o2, e);
                                CommonUtils.m6414h(codedOutputStream2M6646i, "Error flushing session file stream");
                                m6470d(clsFileOutputStream);
                                Logger3.f12227a.m6371b("Removing session part files for ID " + strM6466o2);
                                File[] fileArrM6467r3 = m6467r(m6476l(), new n(strM6466o2));
                                while (i < r5) {
                                }
                                i3++;
                                str42 = str2;
                                str32 = str7;
                                i4 = i2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            CommonUtils.m6414h(codedOutputStream2M6646i, "Error flushing session file stream");
                            CommonUtils.m6409c(clsFileOutputStream, "Failed to close CLS file");
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str42;
                        codedOutputStream2M6646i = null;
                    } catch (Throwable th6) {
                        th = th6;
                        codedOutputStream2M6646i = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str2 = str42;
                    codedOutputStream2M6646i = null;
                    clsFileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    codedOutputStream2M6646i = null;
                    clsFileOutputStream = null;
                }
            } else {
                outline.m868o0("No events present for session ID ", strM6466o2, logger32);
                str2 = str42;
            }
            Logger3.f12227a.m6371b("Removing session part files for ID " + strM6466o2);
            File[] fileArrM6467r32 = m6467r(m6476l(), new n(strM6466o2));
            for (File file9 : fileArrM6467r32) {
                file9.delete();
            }
            i3++;
            str42 = str2;
            str32 = str7;
            i4 = i2;
        }
        String str52 = str32;
        String str62 = str42;
        String strM6468t = z2 == 0 ? m6468t(m6466o(fileArrM6481s2[0])) : null;
        SessionReportingCoordinator3 sessionReportingCoordinator33 = this.f12422A;
        long jM6465j2 = m6465j();
        CrashlyticsReportPersistence7 crashlyticsReportPersistence73 = sessionReportingCoordinator33.f12279b;
        listM6626f = CrashlyticsReportPersistence7.m6626f(crashlyticsReportPersistence73.f12678g, new CrashlyticsReportPersistence2(strM6468t));
        Collections.sort(listM6626f, CrashlyticsReportPersistence7.f12675d);
        if (listM6626f.size() > 8) {
            Iterator<File> it2 = listM6626f.subList(8, listM6626f.size()).iterator();
            while (it2.hasNext()) {
                CrashlyticsReportPersistence7.m6630k(it2.next());
            }
            listM6626f = listM6626f.subList(0, 8);
        }
        for (File file10 : listM6626f) {
            Logger3 logger33 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Finalizing report for session ");
            sbM833U.append(file10.getName());
            logger33.m6371b(sbM833U.toString());
            List<File> listM6627g = CrashlyticsReportPersistence7.m6627g(file10, CrashlyticsReportPersistence7.f12676e);
            if (listM6627g.isEmpty()) {
                StringBuilder sbM833U2 = outline.m833U("Session ");
                sbM833U2.append(file10.getName());
                sbM833U2.append(" has no events.");
                logger33.m6371b(sbM833U2.toString());
            } else {
                Collections.sort(listM6627g);
                ArrayList arrayList4 = new ArrayList();
                while (true) {
                    boolean z6 = false;
                    for (File file11 : listM6627g) {
                        try {
                            CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform82 = CrashlyticsReportPersistence7.f12674c;
                            String strM6629j2 = CrashlyticsReportPersistence7.m6629j(file11);
                            Objects.requireNonNull(crashlyticsReportJsonTransform82);
                            try {
                                JsonReader jsonReader = new JsonReader(new StringReader(strM6629j2));
                                try {
                                    CrashlyticsReport.d.AbstractC13233d abstractC13233dM6615b = CrashlyticsReportJsonTransform8.m6615b(jsonReader);
                                    jsonReader.close();
                                    arrayList4.add(abstractC13233dM6615b);
                                    if (!z6) {
                                        String name3 = file11.getName();
                                        if (!(name3.startsWith("event") && name3.endsWith("_"))) {
                                            break;
                                        }
                                    }
                                    z6 = true;
                                } catch (Throwable th8) {
                                    try {
                                        jsonReader.close();
                                    } catch (Throwable unused3) {
                                    }
                                    throw th8;
                                }
                            } catch (IllegalStateException e9) {
                                throw new IOException(e9);
                            }
                        } catch (IOException e10) {
                            Logger3.f12227a.m6372c("Could not add event to report for " + file11, e10);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        Logger3 logger34 = Logger3.f12227a;
                        StringBuilder sbM833U3 = outline.m833U("Could not parse event files for session ");
                        sbM833U3.append(file10.getName());
                        logger34.m6371b(sbM833U3.toString());
                    } else {
                        File file12 = new File(file10, str62);
                        if (file12.isFile()) {
                            try {
                                strM6629j = CrashlyticsReportPersistence7.m6629j(file12);
                            } catch (IOException e11) {
                                Logger3 logger35 = Logger3.f12227a;
                                StringBuilder sbM833U4 = outline.m833U("Could not read user ID file in ");
                                sbM833U4.append(file10.getName());
                                logger35.m6372c(sbM833U4.toString(), e11);
                            }
                            str = str52;
                            file = new File(file10, str);
                            File file13 = !z6 ? crashlyticsReportPersistence73.f12679h : crashlyticsReportPersistence73.f12680i;
                            try {
                                CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform83 = CrashlyticsReportPersistence7.f12674c;
                                crashlyticsReportM6612j = crashlyticsReportJsonTransform83.m6619f(CrashlyticsReportPersistence7.m6629j(file)).m6612j(jM6465j2, z6, strM6629j);
                                ImmutableList3<CrashlyticsReport.d.AbstractC13233d> immutableList3 = new ImmutableList3<>(arrayList4);
                                if (crashlyticsReportM6612j.mo6522h() != null) {
                                    throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                                }
                                CrashlyticsReport.a aVarMo6523i = crashlyticsReportM6612j.mo6523i();
                                AutoValue_CrashlyticsReport_Session.b bVar2 = (AutoValue_CrashlyticsReport_Session.b) crashlyticsReportM6612j.mo6522h().mo6542l();
                                bVar2.f12560j = immutableList3;
                                AutoValue_CrashlyticsReport.b bVar3 = (AutoValue_CrashlyticsReport.b) aVarMo6523i;
                                bVar3.f12532g = bVar2.mo6543a();
                                CrashlyticsReport crashlyticsReportMo6524a2 = bVar3.mo6524a();
                                CrashlyticsReport.d dVarMo6522h = crashlyticsReportMo6524a2.mo6522h();
                                if (dVarMo6522h != null) {
                                    CrashlyticsReportPersistence7.m6628i(file13);
                                    CrashlyticsReportPersistence7.m6631l(new File(file13, dVarMo6522h.mo6537g()), crashlyticsReportJsonTransform83.m6620g(crashlyticsReportMo6524a2));
                                }
                            } catch (IOException e12) {
                                Logger3.f12227a.m6372c("Could not synthesize final report file for " + file, e12);
                            }
                        } else {
                            strM6629j = null;
                            str = str52;
                            file = new File(file10, str);
                            if (!z6) {
                            }
                            CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform832 = CrashlyticsReportPersistence7.f12674c;
                            crashlyticsReportM6612j = crashlyticsReportJsonTransform832.m6619f(CrashlyticsReportPersistence7.m6629j(file)).m6612j(jM6465j2, z6, strM6629j);
                            ImmutableList3<CrashlyticsReport.d.AbstractC13233d> immutableList32 = new ImmutableList3<>(arrayList4);
                            if (crashlyticsReportM6612j.mo6522h() != null) {
                            }
                        }
                    }
                }
                CrashlyticsReportPersistence7.m6630k(file10);
                str52 = str;
            }
            str = str52;
            CrashlyticsReportPersistence7.m6630k(file10);
            str52 = str;
        }
        Objects.requireNonNull(((SettingsController) crashlyticsReportPersistence73.f12682k).m6685c().mo6690b());
        ArrayList arrayList5 = (ArrayList) crashlyticsReportPersistence73.m6634e();
        size = arrayList5.size();
        if (size > 4) {
            return;
        }
        Iterator it3 = arrayList5.subList(4, size).iterator();
        while (it3.hasNext()) {
            ((File) it3.next()).delete();
        }
    }

    /* renamed from: g */
    public final void m6472g(long j2) {
        try {
            new File(m6476l(), ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            Logger3.f12227a.m6371b("Could not write app exception marker.");
        }
    }

    /* renamed from: h */
    public boolean m6473h(int i2) {
        this.f12433m.m6436a();
        if (m6479p()) {
            Logger3.f12227a.m6371b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger3 logger3 = Logger3.f12227a;
        logger3.m6371b("Finalizing previously open sessions.");
        try {
            m6471f(i2, true);
            logger3.m6371b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e2);
            }
            return false;
        }
    }

    @Nullable
    /* renamed from: i */
    public final String m6474i() {
        File[] fileArrM6481s = m6481s();
        if (fileArrM6481s.length > 0) {
            return m6466o(fileArrM6481s[0]);
        }
        return null;
    }

    /* renamed from: k */
    public File m6475k() {
        return new File(m6476l(), "fatal-sessions");
    }

    /* renamed from: l */
    public File m6476l() {
        return this.f12436p.m6636a();
    }

    /* renamed from: m */
    public File m6477m() {
        return new File(m6476l(), "native-sessions");
    }

    /* renamed from: n */
    public File m6478n() {
        return new File(m6476l(), "nonfatal-sessions");
    }

    /* renamed from: p */
    public boolean m6479p() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f12423B;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.f12368d.get();
    }

    /* renamed from: q */
    public File[] m6480q() {
        LinkedList linkedList = new LinkedList();
        File fileM6475k = m6475k();
        FilenameFilter filenameFilter = f12416b;
        File[] fileArrListFiles = fileM6475k.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles);
        File[] fileArrListFiles2 = m6478n().listFiles(filenameFilter);
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles2);
        Collections.addAll(linkedList, m6467r(m6476l(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* renamed from: s */
    public final File[] m6481s() {
        File[] fileArrM6467r = m6467r(m6476l(), f12415a);
        Arrays.sort(fileArrM6467r, f12417c);
        return fileArrM6467r;
    }

    /* renamed from: u */
    public Task<Void> m6482u(float f2, Task<AppSettingsData> task) {
        C4358c0<Void> c4358c0;
        Task taskM4264Z;
        ReportManager reportManager = this.f12441u;
        File[] fileArrM6480q = C4663x.this.m6480q();
        File[] fileArrListFiles = C4663x.this.m6477m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (!((fileArrM6480q != null && fileArrM6480q.length > 0) || fileArrListFiles.length > 0)) {
            Logger3.f12227a.m6371b("No reports are available.");
            this.f12424C.m9126b(Boolean.FALSE);
            return C3404f.m4264Z(null);
        }
        Logger3 logger3 = Logger3.f12227a;
        logger3.m6371b("Unsent reports are available.");
        if (this.f12430j.m6450b()) {
            logger3.m6371b("Automatic data collection is enabled. Allowing upload.");
            this.f12424C.m9126b(Boolean.FALSE);
            taskM4264Z = C3404f.m4264Z(Boolean.TRUE);
        } else {
            logger3.m6371b("Automatic data collection is disabled.");
            logger3.m6371b("Notifying that unsent reports are available.");
            this.f12424C.m9126b(Boolean.TRUE);
            DataCollectionArbiter dataCollectionArbiter = this.f12430j;
            synchronized (dataCollectionArbiter.f12373c) {
                c4358c0 = dataCollectionArbiter.f12374d.f20845a;
            }
            Task<TContinuationResult> taskMo6022q = c4358c0.mo6022q(new C4620e0(this));
            logger3.m6371b("Waiting for send/deleteUnsentReports to be called.");
            C4358c0<Boolean> c4358c02 = this.f12425D.f20845a;
            FilenameFilter filenameFilter = Utils3.f12313a;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            Utils4 utils4 = new Utils4(taskCompletionSource);
            taskMo6022q.mo6013h(utils4);
            c4358c02.mo6013h(utils4);
            taskM4264Z = taskCompletionSource.f20845a;
        }
        return taskM4264Z.mo6022q(new e(task, f2));
    }

    /* renamed from: v */
    public final void m6483v(String str, int i2) {
        Utils3.m6433b(m6476l(), new h(outline.m883w(str, "SessionEvent")), i2, f12418d);
    }

    /* renamed from: w */
    public final void m6484w(CodedOutputStream2 codedOutputStream2, String str) throws Throwable {
        for (String str2 : f12421g) {
            File[] fileArrM6467r = m6467r(m6476l(), new h(outline.m886y(str, str2, ".cls")));
            if (fileArrM6467r.length == 0) {
                Logger3.f12227a.m6371b("Can't find " + str2 + " data for session ID " + str);
            } else {
                Logger3.f12227a.m6371b("Collecting " + str2 + " data for session ID " + str);
                m6460A(codedOutputStream2, fileArrM6467r[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f0 A[LOOP:1: B:30:0x01ee->B:31:0x01f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0306  */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6485y(CodedOutputStream2 codedOutputStream2, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> mapM6404a;
        Map<String, String> treeMap;
        byte[] bArrMo6493c;
        ByteString2 byteString2;
        String str2;
        ByteString2 byteString22;
        ByteString2 byteString23;
        int length;
        int i2;
        ByteString2 byteString24;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.f12444x);
        Context context = this.f12429i;
        BatteryState batteryStateM6401a = BatteryState.m6401a(context);
        Float f2 = batteryStateM6401a.f12283a;
        int iM6402b = batteryStateM6401a.m6402b();
        boolean zM6419m = CommonUtils.m6419m(context);
        int i3 = context.getResources().getConfiguration().orientation;
        long jM6422p = CommonUtils.m6422p();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j3 = jM6422p - memoryInfo.availMem;
        long jM6407a = CommonUtils.m6407a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoM6415i = CommonUtils.m6415i(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f12779c;
        String str3 = this.f12437q.f12260b;
        String str4 = this.f12435o.f12411e;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            int i4 = 0;
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i4] = entry.getKey();
                linkedList.add(this.f12444x.mo6696a(entry.getValue()));
                i4++;
                threadArr2 = threadArr2;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.m6416j(context, "com.crashlytics.CollectCustomKeys", true)) {
            mapM6404a = this.f12432l.m6404a();
            if (mapM6404a != null && mapM6404a.size() > 1) {
                treeMap = new TreeMap(mapM6404a);
            }
            bArrMo6493c = this.f12440t.f12473d.mo6493c();
            ByteString2 byteString25 = SessionProtobufHelper.f12694a;
            ByteString2 byteString2M6637a = ByteString2.m6637a(str4);
            ByteString2 byteString2M6637a2 = str3 != null ? null : ByteString2.m6637a(str3.replace("-", ""));
            if (bArrMo6493c == null) {
                int length2 = bArrMo6493c.length;
                byteString2 = byteString2M6637a2;
                byte[] bArr = new byte[length2];
                str2 = "";
                System.arraycopy(bArrMo6493c, 0, bArr, 0, length2);
                byteString22 = new ByteString2(bArr);
            } else {
                byteString2 = byteString2M6637a2;
                str2 = "";
                Logger3.f12227a.m6371b("No log data to include with this event.");
                byteString22 = null;
            }
            codedOutputStream2.m6654r(10, 2);
            int iM6640b = CodedOutputStream2.m6640b(2, ByteString2.m6637a(str)) + CodedOutputStream2.m6645h(1, j2) + 0;
            byteString23 = byteString22;
            String str5 = str2;
            Thread[] threadArr3 = threadArr;
            int iM6662f = SessionProtobufHelper.m6662f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, byteString2M6637a, byteString2, treeMap, runningAppProcessInfoM6415i, i3);
            int iM6642d = CodedOutputStream2.m6642d(iM6662f) + CodedOutputStream2.m6643e(3) + iM6662f + iM6640b;
            int iM6663g = SessionProtobufHelper.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a);
            int iM6642d2 = CodedOutputStream2.m6642d(iM6663g) + CodedOutputStream2.m6643e(5) + iM6663g + iM6642d;
            if (byteString23 != null) {
                int iM6640b2 = CodedOutputStream2.m6640b(1, byteString23);
                iM6642d2 += CodedOutputStream2.m6642d(iM6640b2) + CodedOutputStream2.m6643e(6) + iM6640b2;
            }
            codedOutputStream2.m6652o(iM6642d2);
            codedOutputStream2.m6656t(1, j2);
            codedOutputStream2.m6649l(2, ByteString2.m6637a(str));
            codedOutputStream2.m6654r(3, 2);
            ByteString2 byteString26 = byteString2;
            codedOutputStream2.m6652o(SessionProtobufHelper.m6662f(trimmedThrowableData, thread, stackTraceElementArr, threadArr3, linkedList, 8, byteString2M6637a, byteString26, treeMap, runningAppProcessInfoM6415i, i3));
            codedOutputStream2.m6654r(1, 2);
            codedOutputStream2.m6652o(SessionProtobufHelper.m6661e(trimmedThrowableData, thread, stackTraceElementArr, threadArr3, linkedList, 8, byteString2M6637a, byteString26));
            SessionProtobufHelper.m6669m(codedOutputStream2, thread, stackTraceElementArr, 4, true);
            length = threadArr3.length;
            for (i2 = 0; i2 < length; i2++) {
                SessionProtobufHelper.m6669m(codedOutputStream2, threadArr3[i2], (StackTraceElement[]) linkedList.get(i2), 0, false);
            }
            SessionProtobufHelper.m6668l(codedOutputStream2, trimmedThrowableData, 1, 8, 2);
            codedOutputStream2.m6654r(3, 2);
            codedOutputStream2.m6652o(SessionProtobufHelper.m6660d());
            ByteString2 byteString27 = SessionProtobufHelper.f12694a;
            codedOutputStream2.m6649l(1, byteString27);
            codedOutputStream2.m6649l(2, byteString27);
            codedOutputStream2.m6656t(3, 0L);
            codedOutputStream2.m6654r(4, 2);
            byteString24 = byteString2;
            codedOutputStream2.m6652o(SessionProtobufHelper.m6657a(byteString2M6637a, byteString24));
            codedOutputStream2.m6656t(1, 0L);
            codedOutputStream2.m6656t(2, 0L);
            codedOutputStream2.m6649l(3, byteString2M6637a);
            if (byteString24 != null) {
                codedOutputStream2.m6649l(4, byteString24);
            }
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
                    codedOutputStream2.m6654r(2, 2);
                    codedOutputStream2.m6652o(SessionProtobufHelper.m6658b(entry2.getKey(), entry2.getValue()));
                    codedOutputStream2.m6649l(1, ByteString2.m6637a(entry2.getKey()));
                    String value = entry2.getValue();
                    if (value == null) {
                        value = str5;
                    }
                    codedOutputStream2.m6649l(2, ByteString2.m6637a(value));
                }
            }
            if (runningAppProcessInfoM6415i != null) {
                codedOutputStream2.m6648k(3, runningAppProcessInfoM6415i.importance != 100);
            }
            codedOutputStream2.m6655s(4, i3);
            codedOutputStream2.m6654r(5, 2);
            codedOutputStream2.m6652o(SessionProtobufHelper.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a));
            if (f2 != null) {
                float fFloatValue = f2.floatValue();
                codedOutputStream2.m6652o(13);
                int iFloatToRawIntBits = Float.floatToRawIntBits(fFloatValue);
                codedOutputStream2.m6651n(iFloatToRawIntBits & 255);
                codedOutputStream2.m6651n((iFloatToRawIntBits >> 8) & 255);
                codedOutputStream2.m6651n((iFloatToRawIntBits >> 16) & 255);
                codedOutputStream2.m6651n((iFloatToRawIntBits >> 24) & 255);
            }
            codedOutputStream2.m6652o(16);
            codedOutputStream2.m6652o((iM6402b << 1) ^ (iM6402b >> 31));
            codedOutputStream2.m6648k(3, zM6419m);
            codedOutputStream2.m6655s(4, i3);
            codedOutputStream2.m6656t(5, j3);
            codedOutputStream2.m6656t(6, jM6407a);
            if (byteString23 != null) {
                codedOutputStream2.m6654r(6, 2);
                codedOutputStream2.m6652o(CodedOutputStream2.m6640b(1, byteString23));
                codedOutputStream2.m6649l(1, byteString23);
            }
            this.f12440t.f12473d.mo6494d();
        }
        mapM6404a = new TreeMap<>();
        treeMap = mapM6404a;
        bArrMo6493c = this.f12440t.f12473d.mo6493c();
        ByteString2 byteString252 = SessionProtobufHelper.f12694a;
        ByteString2 byteString2M6637a3 = ByteString2.m6637a(str4);
        if (str3 != null) {
        }
        if (bArrMo6493c == null) {
        }
        codedOutputStream2.m6654r(10, 2);
        int iM6640b3 = CodedOutputStream2.m6640b(2, ByteString2.m6637a(str)) + CodedOutputStream2.m6645h(1, j2) + 0;
        byteString23 = byteString22;
        String str52 = str2;
        Thread[] threadArr32 = threadArr;
        int iM6662f2 = SessionProtobufHelper.m6662f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, 8, byteString2M6637a3, byteString2, treeMap, runningAppProcessInfoM6415i, i3);
        int iM6642d3 = CodedOutputStream2.m6642d(iM6662f2) + CodedOutputStream2.m6643e(3) + iM6662f2 + iM6640b3;
        int iM6663g2 = SessionProtobufHelper.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a);
        int iM6642d22 = CodedOutputStream2.m6642d(iM6663g2) + CodedOutputStream2.m6643e(5) + iM6663g2 + iM6642d3;
        if (byteString23 != null) {
        }
        codedOutputStream2.m6652o(iM6642d22);
        codedOutputStream2.m6656t(1, j2);
        codedOutputStream2.m6649l(2, ByteString2.m6637a(str));
        codedOutputStream2.m6654r(3, 2);
        ByteString2 byteString262 = byteString2;
        codedOutputStream2.m6652o(SessionProtobufHelper.m6662f(trimmedThrowableData, thread, stackTraceElementArr, threadArr32, linkedList, 8, byteString2M6637a3, byteString262, treeMap, runningAppProcessInfoM6415i, i3));
        codedOutputStream2.m6654r(1, 2);
        codedOutputStream2.m6652o(SessionProtobufHelper.m6661e(trimmedThrowableData, thread, stackTraceElementArr, threadArr32, linkedList, 8, byteString2M6637a3, byteString262));
        SessionProtobufHelper.m6669m(codedOutputStream2, thread, stackTraceElementArr, 4, true);
        length = threadArr32.length;
        while (i2 < length) {
        }
        SessionProtobufHelper.m6668l(codedOutputStream2, trimmedThrowableData, 1, 8, 2);
        codedOutputStream2.m6654r(3, 2);
        codedOutputStream2.m6652o(SessionProtobufHelper.m6660d());
        ByteString2 byteString272 = SessionProtobufHelper.f12694a;
        codedOutputStream2.m6649l(1, byteString272);
        codedOutputStream2.m6649l(2, byteString272);
        codedOutputStream2.m6656t(3, 0L);
        codedOutputStream2.m6654r(4, 2);
        byteString24 = byteString2;
        codedOutputStream2.m6652o(SessionProtobufHelper.m6657a(byteString2M6637a3, byteString24));
        codedOutputStream2.m6656t(1, 0L);
        codedOutputStream2.m6656t(2, 0L);
        codedOutputStream2.m6649l(3, byteString2M6637a3);
        if (byteString24 != null) {
        }
        if (treeMap != null) {
            while (r3.hasNext()) {
            }
        }
        if (runningAppProcessInfoM6415i != null) {
        }
        codedOutputStream2.m6655s(4, i3);
        codedOutputStream2.m6654r(5, 2);
        codedOutputStream2.m6652o(SessionProtobufHelper.m6663g(f2, iM6402b, zM6419m, i3, j3, jM6407a));
        if (f2 != null) {
        }
        codedOutputStream2.m6652o(16);
        codedOutputStream2.m6652o((iM6402b << 1) ^ (iM6402b >> 31));
        codedOutputStream2.m6648k(3, zM6419m);
        codedOutputStream2.m6655s(4, i3);
        codedOutputStream2.m6656t(5, j3);
        codedOutputStream2.m6656t(6, jM6407a);
        if (byteString23 != null) {
        }
        this.f12440t.f12473d.mo6494d();
    }

    /* renamed from: z */
    public final void m6486z(String str, String str2, g gVar) throws Exception {
        Throwable th;
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream2 codedOutputStream2 = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m6476l(), str + str2);
            try {
                CodedOutputStream2 codedOutputStream2M6646i = CodedOutputStream2.m6646i(clsFileOutputStream);
                try {
                    gVar.mo6454a(codedOutputStream2M6646i);
                    CommonUtils.m6414h(codedOutputStream2M6646i, "Failed to flush to session " + str2 + " file.");
                    CommonUtils.m6409c(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                } catch (Throwable th2) {
                    th = th2;
                    codedOutputStream2 = codedOutputStream2M6646i;
                    CommonUtils.m6414h(codedOutputStream2, "Failed to flush to session " + str2 + " file.");
                    CommonUtils.m6409c(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
        }
    }
}
