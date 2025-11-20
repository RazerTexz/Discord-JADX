package b.i.c.m.d.k;

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
import b.i.c.m.d.k.h;
import b.i.c.m.d.l.b;
import b.i.c.m.d.m.b;
import b.i.c.m.d.m.f;
import b.i.c.m.d.m.i;
import b.i.c.m.d.m.v;
import b.i.c.m.d.p.b;
import b.i.c.m.d.q.b;
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

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class x {
    public static final FilenameFilter a = new a("BeginSession");

    /* renamed from: b, reason: collision with root package name */
    public static final FilenameFilter f1699b = new b();
    public static final Comparator<File> c = new c();
    public static final Comparator<File> d = new d();
    public static final Pattern e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    public static final Map<String, String> f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    public static final String[] g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    public final d1 A;
    public p0 B;
    public final Context i;
    public final q0 j;
    public final m0 k;
    public final f1 l;
    public final b.i.c.m.d.k.i m;
    public final b.i.c.m.d.n.b n;
    public final v0 o;
    public final b.i.c.m.d.o.h p;
    public final b.i.c.m.d.k.b q;

    /* renamed from: s, reason: collision with root package name */
    public final j f1700s;
    public final b.i.c.m.d.l.b t;
    public final b.i.c.m.d.q.a u;
    public final b.a v;
    public final b.i.c.m.d.a w;

    /* renamed from: x, reason: collision with root package name */
    public final b.i.c.m.d.t.d f1701x;

    /* renamed from: y, reason: collision with root package name */
    public final String f1702y;

    /* renamed from: z, reason: collision with root package name */
    public final b.i.c.m.d.i.a f1703z;
    public final AtomicInteger h = new AtomicInteger(0);
    public TaskCompletionSource<Boolean> C = new TaskCompletionSource<>();
    public TaskCompletionSource<Boolean> D = new TaskCompletionSource<>();
    public TaskCompletionSource<Void> E = new TaskCompletionSource<>();
    public AtomicBoolean F = new AtomicBoolean(false);
    public final b.InterfaceC0150b r = new h0(this);

    /* compiled from: CrashlyticsController.java */
    public class a extends h {
        public a(String str) {
            super(str);
        }

        @Override // b.i.c.m.d.k.x.h, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class b implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class c implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class d implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsController.java */
    public class e implements b.i.a.f.n.f<Boolean, Void> {
        public final /* synthetic */ Task a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f1704b;

        public e(Task task, float f) {
            this.a = task;
            this.f1704b = f;
        }

        @Override // b.i.a.f.n.f
        @NonNull
        public Task<Void> a(@Nullable Boolean bool) throws Exception {
            return x.this.m.c(new g0(this, bool));
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class f implements FilenameFilter {
        public f(a aVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !((b) x.f1699b).accept(file, str) && x.e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    public interface g {
        void a(b.i.c.m.d.p.c cVar) throws Exception;
    }

    /* compiled from: CrashlyticsController.java */
    public static class h implements FilenameFilter {
        public final String a;

        public h(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ((b.a) b.i.c.m.d.p.b.j).accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static final class j implements b.InterfaceC0138b {
        public final b.i.c.m.d.o.h a;

        public j(b.i.c.m.d.o.h hVar) {
            this.a = hVar;
        }

        public File a() {
            File file = new File(this.a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    public final class k implements b.c {
        public k(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    public final class l implements b.a {
        public l(a aVar) {
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static final class m implements Runnable {
        public final Context j;
        public final b.i.c.m.d.q.c.c k;
        public final b.i.c.m.d.q.b l;
        public final boolean m;

        public m(Context context, b.i.c.m.d.q.c.c cVar, b.i.c.m.d.q.b bVar, boolean z2) {
            this.j = context;
            this.k = cVar;
            this.l = bVar;
            this.m = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.i.c.m.d.k.h.b(this.j)) {
                b.i.c.m.d.b.a.b("Attempting to send crash report at time of crash...");
                this.l.a(this.k, this.m);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    public static class n implements FilenameFilter {
        public final String a;

        public n(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    public x(Context context, b.i.c.m.d.k.i iVar, b.i.c.m.d.n.b bVar, v0 v0Var, q0 q0Var, b.i.c.m.d.o.h hVar, m0 m0Var, b.i.c.m.d.k.b bVar2, b.i.c.m.d.q.a aVar, b.InterfaceC0150b interfaceC0150b, b.i.c.m.d.a aVar2, b.i.c.m.d.i.a aVar3, b.i.c.m.d.s.d dVar) {
        this.i = context;
        this.m = iVar;
        this.n = bVar;
        this.o = v0Var;
        this.j = q0Var;
        this.p = hVar;
        this.k = m0Var;
        this.q = bVar2;
        this.w = aVar2;
        this.f1702y = bVar2.g.a();
        this.f1703z = aVar3;
        f1 f1Var = new f1();
        this.l = f1Var;
        j jVar = new j(hVar);
        this.f1700s = jVar;
        b.i.c.m.d.l.b bVar3 = new b.i.c.m.d.l.b(context, jVar);
        this.t = bVar3;
        this.u = new b.i.c.m.d.q.a(new k(null));
        this.v = new l(null);
        b.i.c.m.d.t.a aVar4 = new b.i.c.m.d.t.a(1024, new b.i.c.m.d.t.c(10));
        this.f1701x = aVar4;
        File file = new File(new File(hVar.a.getFilesDir(), ".com.google.firebase.crashlytics").getPath());
        n0 n0Var = new n0(context, v0Var, bVar2, aVar4);
        b.i.c.m.d.o.g gVar = new b.i.c.m.d.o.g(file, dVar);
        b.i.c.m.d.m.x.h hVar2 = b.i.c.m.d.r.c.a;
        b.i.a.b.j.n.b(context);
        b.i.a.b.g gVarC = b.i.a.b.j.n.a().c(new b.i.a.b.i.a(b.i.c.m.d.r.c.f1746b, b.i.c.m.d.r.c.c));
        b.i.a.b.b bVar4 = new b.i.a.b.b("json");
        b.i.a.b.e<b.i.c.m.d.m.v, byte[]> eVar = b.i.c.m.d.r.c.d;
        this.A = new d1(n0Var, gVar, new b.i.c.m.d.r.c(((b.i.a.b.j.j) gVarC).a("FIREBASE_CRASHLYTICS_REPORT", b.i.c.m.d.m.v.class, bVar4, eVar), eVar), bVar3, f1Var);
    }

    public static void A(b.i.c.m.d.p.c cVar, File file) throws Throwable {
        if (!file.exists()) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Tried to include a file that doesn't exist: ");
            sbU.append(file.getName());
            bVar.d(sbU.toString());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                e(fileInputStream2, cVar, (int) file.length());
                b.i.c.m.d.k.h.c(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                b.i.c.m.d.k.h.c(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(x xVar) throws Exception {
        String str;
        String str2;
        Integer num;
        Objects.requireNonNull(xVar);
        long j2 = j();
        new b.i.c.m.d.k.g(xVar.o);
        String str3 = b.i.c.m.d.k.g.f1684b;
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        b.d.b.a.a.o0("Opening a new session with ID ", str3, bVar);
        xVar.w.h(str3);
        Locale locale = Locale.US;
        String str4 = String.format(locale, "Crashlytics Android SDK/%s", "17.3.0");
        xVar.z(str3, "BeginSession", new u(xVar, str3, str4, j2));
        xVar.w.d(str3, str4, j2);
        v0 v0Var = xVar.o;
        String str5 = v0Var.e;
        b.i.c.m.d.k.b bVar2 = xVar.q;
        String str6 = bVar2.e;
        String str7 = bVar2.f;
        String strB = v0Var.b();
        int iG = r0.f(xVar.q.c).g();
        xVar.z(str3, "SessionApp", new v(xVar, str5, str6, str7, strB, iG));
        xVar.w.f(str3, str5, str6, str7, strB, iG, xVar.f1702y);
        String str8 = Build.VERSION.RELEASE;
        String str9 = Build.VERSION.CODENAME;
        boolean zU = b.i.c.m.d.k.h.u(xVar.i);
        xVar.z(str3, "SessionOS", new w(xVar, str8, str9, zU));
        xVar.w.g(str3, str8, str9, zU);
        Context context = xVar.i;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        h.b bVar3 = h.b.UNKNOWN;
        String str10 = Build.CPU_ABI;
        if (TextUtils.isEmpty(str10)) {
            bVar.b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        } else {
            h.b bVar4 = h.b.t.get(str10.toLowerCase(locale));
            if (bVar4 != null) {
                bVar3 = bVar4;
            }
        }
        int iOrdinal = bVar3.ordinal();
        String str11 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jP = b.i.c.m.d.k.h.p();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean zS = b.i.c.m.d.k.h.s(context);
        int iK = b.i.c.m.d.k.h.k(context);
        String str12 = Build.MANUFACTURER;
        String str13 = Build.PRODUCT;
        xVar.z(str3, "SessionDevice", new y(xVar, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13));
        xVar.w.c(str3, iOrdinal, str11, iAvailableProcessors, jP, blockCount, zS, iK, str12, str13);
        xVar.t.a(str3);
        d1 d1Var = xVar.A;
        String strT = t(str3);
        n0 n0Var = d1Var.a;
        Objects.requireNonNull(n0Var);
        Charset charset = b.i.c.m.d.m.v.a;
        b.C0141b c0141b = new b.C0141b();
        c0141b.a = "17.3.0";
        String str14 = n0Var.e.a;
        Objects.requireNonNull(str14, "Null gmpAppId");
        c0141b.f1714b = str14;
        String strB2 = n0Var.d.b();
        Objects.requireNonNull(strB2, "Null installationUuid");
        c0141b.d = strB2;
        String str15 = n0Var.e.e;
        Objects.requireNonNull(str15, "Null buildVersion");
        c0141b.e = str15;
        String str16 = n0Var.e.f;
        Objects.requireNonNull(str16, "Null displayVersion");
        c0141b.f = str16;
        c0141b.c = 4;
        f.b bVar5 = new f.b();
        bVar5.b(false);
        bVar5.c = Long.valueOf(j2);
        Objects.requireNonNull(strT, "Null identifier");
        bVar5.f1719b = strT;
        String str17 = n0.a;
        Objects.requireNonNull(str17, "Null generator");
        bVar5.a = str17;
        String str18 = n0Var.d.e;
        Objects.requireNonNull(str18, "Null identifier");
        String str19 = n0Var.e.e;
        Objects.requireNonNull(str19, "Null version");
        String str20 = n0Var.e.f;
        String strB3 = n0Var.d.b();
        String strA = n0Var.e.g.a();
        if (strA != null) {
            str2 = strA;
            str = "Unity";
        } else {
            str = null;
            str2 = null;
        }
        bVar5.f = new b.i.c.m.d.m.g(str18, str19, str20, null, strB3, str, str2, null);
        Integer num2 = 3;
        Objects.requireNonNull(str8, "Null version");
        Objects.requireNonNull(str9, "Null buildVersion");
        Boolean boolValueOf = Boolean.valueOf(b.i.c.m.d.k.h.u(n0Var.c));
        String strW = num2 == null ? " platform" : "";
        if (boolValueOf == null) {
            strW = b.d.b.a.a.w(strW, " jailbroken");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        bVar5.h = new b.i.c.m.d.m.t(num2.intValue(), str8, str9, boolValueOf.booleanValue(), null);
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str10) && (num = n0.f1691b.get(str10.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jP2 = b.i.c.m.d.k.h.p();
        long blockCount2 = statFs2.getBlockCount() * statFs2.getBlockSize();
        boolean zS2 = b.i.c.m.d.k.h.s(n0Var.c);
        int iK2 = b.i.c.m.d.k.h.k(n0Var.c);
        i.b bVar6 = new i.b();
        bVar6.a = Integer.valueOf(iIntValue);
        Objects.requireNonNull(str11, "Null model");
        bVar6.f1722b = str11;
        bVar6.c = Integer.valueOf(iAvailableProcessors2);
        bVar6.d = Long.valueOf(jP2);
        bVar6.e = Long.valueOf(blockCount2);
        bVar6.f = Boolean.valueOf(zS2);
        bVar6.g = Integer.valueOf(iK2);
        Objects.requireNonNull(str12, "Null manufacturer");
        bVar6.h = str12;
        Objects.requireNonNull(str13, "Null modelClass");
        bVar6.i = str13;
        bVar5.i = bVar6.a();
        bVar5.k = 3;
        c0141b.g = bVar5.a();
        b.i.c.m.d.m.v vVarA = c0141b.a();
        b.i.c.m.d.o.g gVar = d1Var.f1680b;
        Objects.requireNonNull(gVar);
        v.d dVarH = vVarA.h();
        if (dVarH == null) {
            bVar.b("Could not get session for report");
            return;
        }
        String strG = dVarH.g();
        try {
            File fileH = gVar.h(strG);
            b.i.c.m.d.o.g.i(fileH);
            b.i.c.m.d.o.g.l(new File(fileH, "report"), b.i.c.m.d.o.g.c.g(vVarA));
        } catch (IOException e2) {
            b.i.c.m.d.b.a.c("Could not persist report for session " + strG, e2);
        }
    }

    public static Task b(x xVar) {
        boolean z2;
        Task taskO;
        Objects.requireNonNull(xVar);
        ArrayList arrayList = new ArrayList();
        for (File file : r(xVar.l(), b.i.c.m.d.k.m.a)) {
            try {
                long j2 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z2 = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (z2) {
                    b.i.c.m.d.b.a.b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskO = b.i.a.f.e.o.f.Z(null);
                } else {
                    taskO = b.i.a.f.e.o.f.o(new ScheduledThreadPoolExecutor(1), new a0(xVar, j2));
                }
                arrayList.add(taskO);
            } catch (NumberFormatException unused2) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sbU = b.d.b.a.a.U("Could not parse timestamp from file ");
                sbU.append(file.getName());
                bVar.b(sbU.toString());
            }
            file.delete();
        }
        return b.i.a.f.e.o.f.B1(arrayList);
    }

    public static void c(@Nullable String str, @NonNull File file) throws Exception {
        FileOutputStream fileOutputStream;
        if (str == null) {
            return;
        }
        b.i.c.m.d.p.c cVarI = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                cVarI = b.i.c.m.d.p.c.i(fileOutputStream);
                b.i.c.m.d.p.a aVar = b.i.c.m.d.p.d.a;
                b.i.c.m.d.p.a aVarA = b.i.c.m.d.p.a.a(str);
                cVarI.r(7, 2);
                int iB = b.i.c.m.d.p.c.b(2, aVarA);
                cVarI.o(b.i.c.m.d.p.c.d(iB) + b.i.c.m.d.p.c.e(5) + iB);
                cVarI.r(5, 2);
                cVarI.o(iB);
                cVarI.l(2, aVarA);
                StringBuilder sbU = b.d.b.a.a.U("Failed to flush to append to ");
                sbU.append(file.getPath());
                b.i.c.m.d.k.h.h(cVarI, sbU.toString());
                b.i.c.m.d.k.h.c(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                StringBuilder sbU2 = b.d.b.a.a.U("Failed to flush to append to ");
                sbU2.append(file.getPath());
                b.i.c.m.d.k.h.h(cVarI, sbU2.toString());
                b.i.c.m.d.k.h.c(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static void e(InputStream inputStream, b.i.c.m.d.p.c cVar, int i2) throws IOException {
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
        Objects.requireNonNull(cVar);
        int i5 = cVar.k;
        int i6 = cVar.l;
        int i7 = i5 - i6;
        if (i7 >= i2) {
            System.arraycopy(bArr, 0, cVar.j, i6, i2);
            cVar.l += i2;
            return;
        }
        System.arraycopy(bArr, 0, cVar.j, i6, i7);
        int i8 = i7 + 0;
        int i9 = i2 - i7;
        cVar.l = cVar.k;
        cVar.j();
        if (i9 > cVar.k) {
            cVar.m.write(bArr, i8, i9);
        } else {
            System.arraycopy(bArr, i8, cVar.j, 0, i9);
            cVar.l = i9;
        }
    }

    public static long j() {
        return new Date().getTime() / 1000;
    }

    public static String o(File file) {
        return file.getName().substring(0, 35);
    }

    public static File[] r(File file, FilenameFilter filenameFilter) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    @NonNull
    public static String t(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    public static void x(b.i.c.m.d.p.c cVar, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, b.i.c.m.d.k.h.c);
        for (File file : fileArr) {
            try {
                b.i.c.m.d.b.a.b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                A(cVar, file);
            } catch (Exception e2) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Error writting non-fatal to session.", e2);
                }
            }
        }
    }

    public final void d(b.i.c.m.d.p.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.a();
        } catch (IOException e2) {
            if (b.i.c.m.d.b.a.a(6)) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(int i2, boolean z2) throws Exception {
        FileInputStream fileInputStream;
        f1 f1Var;
        int i3;
        List<File> listF;
        int size;
        String strJ;
        File file;
        String str;
        b.i.c.m.d.m.v vVarJ;
        b.i.c.m.d.p.c cVarI;
        b.i.c.m.d.p.b bVar;
        String str2;
        InputStream inputStreamH;
        int i4 = i2;
        int i5 = (z2 ? 1 : 0) + 8;
        HashSet hashSet = new HashSet();
        File[] fileArrS = s();
        int iMin = Math.min(i5, fileArrS.length);
        for (int i6 = 0; i6 < iMin; i6++) {
            hashSet.add(o(fileArrS[i6]));
        }
        File[] fileArrListFiles = ((j) this.t.c).a().listFiles();
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
        for (File file3 : r(l(), new f(null))) {
            String name2 = file3.getName();
            Matcher matcher = e.matcher(name2);
            if (!matcher.matches()) {
                b.i.c.m.d.b.a.b("Deleting unknown file: " + name2);
                file3.delete();
            } else if (!hashSet.contains(matcher.group(1))) {
                b.i.c.m.d.b.a.b("Trimming session file: " + name2);
                file3.delete();
            }
        }
        File[] fileArrS2 = s();
        if (fileArrS2.length <= z2) {
            b.i.c.m.d.b.a.b("No open sessions to be closed.");
            return;
        }
        String strO = o(fileArrS2[z2 ? 1 : 0]);
        if (p()) {
            f1Var = this.l;
        } else {
            File fileB = new z0(l()).b(strO);
            if (fileB.exists()) {
                try {
                    try {
                        fileInputStream = new FileInputStream(fileB);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                }
                try {
                    f1Var = z0.c(b.i.c.m.d.k.h.x(fileInputStream));
                    b.i.c.m.d.k.h.c(fileInputStream, "Failed to close user metadata file.");
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    if (b.i.c.m.d.b.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                    }
                    b.i.c.m.d.k.h.c(fileInputStream2, "Failed to close user metadata file.");
                    f1Var = new f1();
                    z(strO, "SessionUser", new z(this, f1Var));
                    String str3 = "report";
                    String str4 = "user";
                    if (this.w.e(strO)) {
                    }
                    b.i.c.m.d.b.a.b("Closing open sessions.");
                    i3 = z2 ? 1 : 0;
                    while (i3 < fileArrS2.length) {
                    }
                    String str5 = str3;
                    String str6 = str4;
                    if (z2 == 0) {
                    }
                    d1 d1Var = this.A;
                    long j2 = j();
                    b.i.c.m.d.o.g gVar = d1Var.f1680b;
                    listF = b.i.c.m.d.o.g.f(gVar.g, new b.i.c.m.d.o.b(strT));
                    Collections.sort(listF, b.i.c.m.d.o.g.d);
                    if (listF.size() > 8) {
                    }
                    while (r6.hasNext()) {
                    }
                    Objects.requireNonNull(((b.i.c.m.d.s.c) gVar.k).c().b());
                    ArrayList arrayList = (ArrayList) gVar.e();
                    size = arrayList.size();
                    if (size > 4) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.i.c.m.d.k.h.c(fileInputStream, "Failed to close user metadata file.");
                    throw th;
                }
            } else {
                f1Var = new f1();
            }
        }
        z(strO, "SessionUser", new z(this, f1Var));
        String str32 = "report";
        String str42 = "user";
        if (this.w.e(strO)) {
            b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
            b.d.b.a.a.o0("Finalizing native report for session ", strO, bVar2);
            b.i.c.m.d.d dVarB = this.w.b(strO);
            File fileD = dVarB.d();
            if (fileD == null || !fileD.exists()) {
                bVar2.g("No minidump data found for session " + strO);
            } else {
                long jLastModified = fileD.lastModified();
                b.i.c.m.d.l.b bVar3 = new b.i.c.m.d.l.b(this.i, this.f1700s, strO);
                File file4 = new File(m(), strO);
                if (file4.mkdirs()) {
                    g(jLastModified);
                    File fileL = l();
                    byte[] bArrC = bVar3.d.c();
                    z0 z0Var = new z0(fileL);
                    File fileB2 = z0Var.b(strO);
                    File fileA = z0Var.a(strO);
                    ArrayList<a1> arrayList2 = new ArrayList();
                    arrayList2.add(new b.i.c.m.d.k.f("logs_file", "logs", bArrC));
                    arrayList2.add(new u0("crash_meta_file", "metadata", dVarB.f()));
                    arrayList2.add(new u0("session_meta_file", "session", dVarB.e()));
                    arrayList2.add(new u0("app_meta_file", "app", dVarB.a()));
                    arrayList2.add(new u0("device_meta_file", "device", dVarB.c()));
                    arrayList2.add(new u0("os_meta_file", "os", dVarB.b()));
                    arrayList2.add(new u0("minidump_file", "minidump", dVarB.d()));
                    arrayList2.add(new u0("user_meta_file", "user", fileB2));
                    arrayList2.add(new u0("keys_file", "keys", fileA));
                    for (a1 a1Var : arrayList2) {
                        try {
                            inputStreamH = a1Var.h();
                            if (inputStreamH != null) {
                                try {
                                    b.i.a.f.e.o.f.t0(inputStreamH, new File(file4, a1Var.a()));
                                } catch (IOException unused) {
                                } catch (Throwable th3) {
                                    th = th3;
                                    b.i.c.m.d.k.h.d(inputStreamH);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            inputStreamH = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamH = null;
                        }
                        b.i.c.m.d.k.h.d(inputStreamH);
                    }
                    d1 d1Var2 = this.A;
                    String strReplaceAll = strO.replaceAll("-", "");
                    Objects.requireNonNull(d1Var2);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        v.c.a aVarB = ((a1) it.next()).b();
                        if (aVarB != null) {
                            arrayList3.add(aVarB);
                        }
                    }
                    b.i.c.m.d.o.g gVar2 = d1Var2.f1680b;
                    b.i.c.m.d.m.d dVar = new b.i.c.m.d.m.d(new b.i.c.m.d.m.w(arrayList3), null, null);
                    Objects.requireNonNull(gVar2);
                    File file5 = new File(gVar2.h(strReplaceAll), "report");
                    File file6 = gVar2.j;
                    try {
                        b.i.c.m.d.m.x.h hVar = b.i.c.m.d.o.g.c;
                        b.C0141b c0141b = (b.C0141b) hVar.f(b.i.c.m.d.o.g.j(file5)).i();
                        c0141b.g = null;
                        c0141b.h = dVar;
                        b.i.c.m.d.m.v vVarA = c0141b.a();
                        b.i.c.m.d.o.g.i(file6);
                        b.i.c.m.d.o.g.l(new File(file6, strReplaceAll), hVar.g(vVarA));
                    } catch (IOException e4) {
                        b.i.c.m.d.b.a.c("Could not synthesize final native report file for " + file5, e4);
                    }
                    bVar3.d.d();
                } else {
                    bVar2.b("Couldn't create native sessions directory");
                }
            }
            if (!this.w.a(strO)) {
                b.d.b.a.a.o0("Could not finalize native session: ", strO, b.i.c.m.d.b.a);
            }
        }
        b.i.c.m.d.b.a.b("Closing open sessions.");
        i3 = z2 ? 1 : 0;
        while (i3 < fileArrS2.length) {
            File file7 = fileArrS2[i3];
            String strO2 = o(file7);
            b.i.c.m.d.b bVar4 = b.i.c.m.d.b.a;
            bVar4.b("Closing session: " + strO2);
            bVar4.b("Collecting session parts for ID " + strO2);
            File[] fileArrR = r(l(), new h(b.d.b.a.a.w(strO2, "SessionCrash")));
            boolean z3 = fileArrR.length > 0;
            Locale locale = Locale.US;
            bVar4.b(String.format(locale, "Session %s has fatal exception: %s", strO2, Boolean.valueOf(z3)));
            File[] fileArrR2 = r(l(), new h(b.d.b.a.a.w(strO2, "SessionEvent")));
            boolean z4 = fileArrR2.length > 0;
            String str7 = str32;
            bVar4.b(String.format(locale, "Session %s has non-fatal exceptions: %s", strO2, Boolean.valueOf(z4)));
            if (z3 || z4) {
                if (fileArrR2.length > i4) {
                    bVar4.b(String.format(locale, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
                    v(strO2, i4);
                    fileArrR2 = r(l(), new h(b.d.b.a.a.w(strO2, "SessionEvent")));
                }
                File file8 = z3 ? fileArrR[0] : null;
                boolean z5 = file8 != null;
                File fileK = z5 ? k() : n();
                if (!fileK.exists()) {
                    fileK.mkdirs();
                }
                try {
                    bVar = new b.i.c.m.d.p.b(fileK, strO2);
                    try {
                        cVarI = b.i.c.m.d.p.c.i(bVar);
                        try {
                            try {
                                bVar4.b("Collecting SessionStart data for session ID " + strO2);
                                A(cVarI, file7);
                                str2 = str42;
                            } catch (Exception e5) {
                                e = e5;
                                str2 = str42;
                            }
                            try {
                                cVarI.t(4, j());
                                cVarI.k(5, z5);
                                cVarI.s(11, 1);
                                cVarI.m(12, 3);
                                w(cVarI, strO2);
                                x(cVarI, fileArrR2, strO2);
                                if (z5) {
                                    A(cVarI, file8);
                                }
                                b.i.c.m.d.k.h.h(cVarI, "Error flushing session file stream");
                                b.i.c.m.d.k.h.c(bVar, "Failed to close CLS file");
                            } catch (Exception e6) {
                                e = e6;
                                b.i.c.m.d.b.a.e("Failed to write session file for session ID: " + strO2, e);
                                b.i.c.m.d.k.h.h(cVarI, "Error flushing session file stream");
                                d(bVar);
                                b.i.c.m.d.b.a.b("Removing session part files for ID " + strO2);
                                File[] fileArrR3 = r(l(), new n(strO2));
                                while (i < r5) {
                                }
                                i3++;
                                str42 = str2;
                                str32 = str7;
                                i4 = i2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            b.i.c.m.d.k.h.h(cVarI, "Error flushing session file stream");
                            b.i.c.m.d.k.h.c(bVar, "Failed to close CLS file");
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str42;
                        cVarI = null;
                    } catch (Throwable th6) {
                        th = th6;
                        cVarI = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str2 = str42;
                    cVarI = null;
                    bVar = null;
                } catch (Throwable th7) {
                    th = th7;
                    cVarI = null;
                    bVar = null;
                }
            } else {
                b.d.b.a.a.o0("No events present for session ID ", strO2, bVar4);
                str2 = str42;
            }
            b.i.c.m.d.b.a.b("Removing session part files for ID " + strO2);
            File[] fileArrR32 = r(l(), new n(strO2));
            for (File file9 : fileArrR32) {
                file9.delete();
            }
            i3++;
            str42 = str2;
            str32 = str7;
            i4 = i2;
        }
        String str52 = str32;
        String str62 = str42;
        String strT = z2 == 0 ? t(o(fileArrS2[0])) : null;
        d1 d1Var3 = this.A;
        long j22 = j();
        b.i.c.m.d.o.g gVar3 = d1Var3.f1680b;
        listF = b.i.c.m.d.o.g.f(gVar3.g, new b.i.c.m.d.o.b(strT));
        Collections.sort(listF, b.i.c.m.d.o.g.d);
        if (listF.size() > 8) {
            Iterator<File> it2 = listF.subList(8, listF.size()).iterator();
            while (it2.hasNext()) {
                b.i.c.m.d.o.g.k(it2.next());
            }
            listF = listF.subList(0, 8);
        }
        for (File file10 : listF) {
            b.i.c.m.d.b bVar5 = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Finalizing report for session ");
            sbU.append(file10.getName());
            bVar5.b(sbU.toString());
            List<File> listG = b.i.c.m.d.o.g.g(file10, b.i.c.m.d.o.g.e);
            if (listG.isEmpty()) {
                StringBuilder sbU2 = b.d.b.a.a.U("Session ");
                sbU2.append(file10.getName());
                sbU2.append(" has no events.");
                bVar5.b(sbU2.toString());
            } else {
                Collections.sort(listG);
                ArrayList arrayList4 = new ArrayList();
                while (true) {
                    boolean z6 = false;
                    for (File file11 : listG) {
                        try {
                            b.i.c.m.d.m.x.h hVar2 = b.i.c.m.d.o.g.c;
                            String strJ2 = b.i.c.m.d.o.g.j(file11);
                            Objects.requireNonNull(hVar2);
                            try {
                                JsonReader jsonReader = new JsonReader(new StringReader(strJ2));
                                try {
                                    v.d.AbstractC0143d abstractC0143dB = b.i.c.m.d.m.x.h.b(jsonReader);
                                    jsonReader.close();
                                    arrayList4.add(abstractC0143dB);
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
                            b.i.c.m.d.b.a.c("Could not add event to report for " + file11, e10);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        b.i.c.m.d.b bVar6 = b.i.c.m.d.b.a;
                        StringBuilder sbU3 = b.d.b.a.a.U("Could not parse event files for session ");
                        sbU3.append(file10.getName());
                        bVar6.b(sbU3.toString());
                    } else {
                        File file12 = new File(file10, str62);
                        if (file12.isFile()) {
                            try {
                                strJ = b.i.c.m.d.o.g.j(file12);
                            } catch (IOException e11) {
                                b.i.c.m.d.b bVar7 = b.i.c.m.d.b.a;
                                StringBuilder sbU4 = b.d.b.a.a.U("Could not read user ID file in ");
                                sbU4.append(file10.getName());
                                bVar7.c(sbU4.toString(), e11);
                            }
                            str = str52;
                            file = new File(file10, str);
                            File file13 = !z6 ? gVar3.h : gVar3.i;
                            try {
                                b.i.c.m.d.m.x.h hVar3 = b.i.c.m.d.o.g.c;
                                vVarJ = hVar3.f(b.i.c.m.d.o.g.j(file)).j(j22, z6, strJ);
                                b.i.c.m.d.m.w<v.d.AbstractC0143d> wVar = new b.i.c.m.d.m.w<>(arrayList4);
                                if (vVarJ.h() != null) {
                                    throw new IllegalStateException("Reports without sessions cannot have events added to them.");
                                }
                                v.a aVarI = vVarJ.i();
                                f.b bVar8 = (f.b) vVarJ.h().l();
                                bVar8.j = wVar;
                                b.C0141b c0141b2 = (b.C0141b) aVarI;
                                c0141b2.g = bVar8.a();
                                b.i.c.m.d.m.v vVarA2 = c0141b2.a();
                                v.d dVarH = vVarA2.h();
                                if (dVarH != null) {
                                    b.i.c.m.d.o.g.i(file13);
                                    b.i.c.m.d.o.g.l(new File(file13, dVarH.g()), hVar3.g(vVarA2));
                                }
                            } catch (IOException e12) {
                                b.i.c.m.d.b.a.c("Could not synthesize final report file for " + file, e12);
                            }
                        } else {
                            strJ = null;
                            str = str52;
                            file = new File(file10, str);
                            if (!z6) {
                            }
                            b.i.c.m.d.m.x.h hVar32 = b.i.c.m.d.o.g.c;
                            vVarJ = hVar32.f(b.i.c.m.d.o.g.j(file)).j(j22, z6, strJ);
                            b.i.c.m.d.m.w<v.d.AbstractC0143d> wVar2 = new b.i.c.m.d.m.w<>(arrayList4);
                            if (vVarJ.h() != null) {
                            }
                        }
                    }
                }
                b.i.c.m.d.o.g.k(file10);
                str52 = str;
            }
            str = str52;
            b.i.c.m.d.o.g.k(file10);
            str52 = str;
        }
        Objects.requireNonNull(((b.i.c.m.d.s.c) gVar3.k).c().b());
        ArrayList arrayList5 = (ArrayList) gVar3.e();
        size = arrayList5.size();
        if (size > 4) {
            return;
        }
        Iterator it3 = arrayList5.subList(4, size).iterator();
        while (it3.hasNext()) {
            ((File) it3.next()).delete();
        }
    }

    public final void g(long j2) {
        try {
            new File(l(), ".ae" + j2).createNewFile();
        } catch (IOException unused) {
            b.i.c.m.d.b.a.b("Could not write app exception marker.");
        }
    }

    public boolean h(int i2) {
        this.m.a();
        if (p()) {
            b.i.c.m.d.b.a.b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Finalizing previously open sessions.");
        try {
            f(i2, true);
            bVar.b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e2);
            }
            return false;
        }
    }

    @Nullable
    public final String i() {
        File[] fileArrS = s();
        if (fileArrS.length > 0) {
            return o(fileArrS[0]);
        }
        return null;
    }

    public File k() {
        return new File(l(), "fatal-sessions");
    }

    public File l() {
        return this.p.a();
    }

    public File m() {
        return new File(l(), "native-sessions");
    }

    public File n() {
        return new File(l(), "nonfatal-sessions");
    }

    public boolean p() {
        p0 p0Var = this.B;
        return p0Var != null && p0Var.d.get();
    }

    public File[] q() {
        LinkedList linkedList = new LinkedList();
        File fileK = k();
        FilenameFilter filenameFilter = f1699b;
        File[] fileArrListFiles = fileK.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles);
        File[] fileArrListFiles2 = n().listFiles(filenameFilter);
        if (fileArrListFiles2 == null) {
            fileArrListFiles2 = new File[0];
        }
        Collections.addAll(linkedList, fileArrListFiles2);
        Collections.addAll(linkedList, r(l(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    public final File[] s() {
        File[] fileArrR = r(l(), a);
        Arrays.sort(fileArrR, c);
        return fileArrR;
    }

    public Task<Void> u(float f2, Task<b.i.c.m.d.s.h.b> task) {
        b.i.a.f.n.c0<Void> c0Var;
        Task taskZ;
        b.i.c.m.d.q.a aVar = this.u;
        File[] fileArrQ = x.this.q();
        File[] fileArrListFiles = x.this.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        if (!((fileArrQ != null && fileArrQ.length > 0) || fileArrListFiles.length > 0)) {
            b.i.c.m.d.b.a.b("No reports are available.");
            this.C.b(Boolean.FALSE);
            return b.i.a.f.e.o.f.Z(null);
        }
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Unsent reports are available.");
        if (this.j.b()) {
            bVar.b("Automatic data collection is enabled. Allowing upload.");
            this.C.b(Boolean.FALSE);
            taskZ = b.i.a.f.e.o.f.Z(Boolean.TRUE);
        } else {
            bVar.b("Automatic data collection is disabled.");
            bVar.b("Notifying that unsent reports are available.");
            this.C.b(Boolean.TRUE);
            q0 q0Var = this.j;
            synchronized (q0Var.c) {
                c0Var = q0Var.d.a;
            }
            Task<TContinuationResult> taskQ = c0Var.q(new e0(this));
            bVar.b("Waiting for send/deleteUnsentReports to be called.");
            b.i.a.f.n.c0<Boolean> c0Var2 = this.D.a;
            FilenameFilter filenameFilter = h1.a;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            i1 i1Var = new i1(taskCompletionSource);
            taskQ.h(i1Var);
            c0Var2.h(i1Var);
            taskZ = taskCompletionSource.a;
        }
        return taskZ.q(new e(task, f2));
    }

    public final void v(String str, int i2) {
        h1.b(l(), new h(b.d.b.a.a.w(str, "SessionEvent")), i2, d);
    }

    public final void w(b.i.c.m.d.p.c cVar, String str) throws Throwable {
        for (String str2 : g) {
            File[] fileArrR = r(l(), new h(b.d.b.a.a.y(str, str2, ".cls")));
            if (fileArrR.length == 0) {
                b.i.c.m.d.b.a.b("Can't find " + str2 + " data for session ID " + str);
            } else {
                b.i.c.m.d.b.a.b("Collecting " + str2 + " data for session ID " + str);
                A(cVar, fileArrR[0]);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(b.i.c.m.d.p.c cVar, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> mapA;
        Map<String, String> treeMap;
        byte[] bArrC;
        b.i.c.m.d.p.a aVar;
        String str2;
        b.i.c.m.d.p.a aVar2;
        b.i.c.m.d.p.a aVar3;
        int length;
        int i2;
        b.i.c.m.d.p.a aVar4;
        b.i.c.m.d.t.e eVar = new b.i.c.m.d.t.e(th, this.f1701x);
        Context context = this.i;
        b.i.c.m.d.k.e eVarA = b.i.c.m.d.k.e.a(context);
        Float f2 = eVarA.a;
        int iB = eVarA.b();
        boolean zM = b.i.c.m.d.k.h.m(context);
        int i3 = context.getResources().getConfiguration().orientation;
        long jP = b.i.c.m.d.k.h.p();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        long j3 = jP - memoryInfo.availMem;
        long jA = b.i.c.m.d.k.h.a(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoI = b.i.c.m.d.k.h.i(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = eVar.c;
        String str3 = this.q.f1677b;
        String str4 = this.o.e;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            int i4 = 0;
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i4] = entry.getKey();
                linkedList.add(this.f1701x.a(entry.getValue()));
                i4++;
                threadArr2 = threadArr2;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (b.i.c.m.d.k.h.j(context, "com.crashlytics.CollectCustomKeys", true)) {
            mapA = this.l.a();
            if (mapA != null && mapA.size() > 1) {
                treeMap = new TreeMap(mapA);
            }
            bArrC = this.t.d.c();
            b.i.c.m.d.p.a aVar5 = b.i.c.m.d.p.d.a;
            b.i.c.m.d.p.a aVarA = b.i.c.m.d.p.a.a(str4);
            b.i.c.m.d.p.a aVarA2 = str3 != null ? null : b.i.c.m.d.p.a.a(str3.replace("-", ""));
            if (bArrC == null) {
                int length2 = bArrC.length;
                aVar = aVarA2;
                byte[] bArr = new byte[length2];
                str2 = "";
                System.arraycopy(bArrC, 0, bArr, 0, length2);
                aVar2 = new b.i.c.m.d.p.a(bArr);
            } else {
                aVar = aVarA2;
                str2 = "";
                b.i.c.m.d.b.a.b("No log data to include with this event.");
                aVar2 = null;
            }
            cVar.r(10, 2);
            int iB2 = b.i.c.m.d.p.c.b(2, b.i.c.m.d.p.a.a(str)) + b.i.c.m.d.p.c.h(1, j2) + 0;
            aVar3 = aVar2;
            String str5 = str2;
            Thread[] threadArr3 = threadArr;
            int iF = b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, aVarA, aVar, treeMap, runningAppProcessInfoI, i3);
            int iD = b.i.c.m.d.p.c.d(iF) + b.i.c.m.d.p.c.e(3) + iF + iB2;
            int iG = b.i.c.m.d.p.d.g(f2, iB, zM, i3, j3, jA);
            int iD2 = b.i.c.m.d.p.c.d(iG) + b.i.c.m.d.p.c.e(5) + iG + iD;
            if (aVar3 != null) {
                int iB3 = b.i.c.m.d.p.c.b(1, aVar3);
                iD2 += b.i.c.m.d.p.c.d(iB3) + b.i.c.m.d.p.c.e(6) + iB3;
            }
            cVar.o(iD2);
            cVar.t(1, j2);
            cVar.l(2, b.i.c.m.d.p.a.a(str));
            cVar.r(3, 2);
            b.i.c.m.d.p.a aVar6 = aVar;
            cVar.o(b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr3, linkedList, 8, aVarA, aVar6, treeMap, runningAppProcessInfoI, i3));
            cVar.r(1, 2);
            cVar.o(b.i.c.m.d.p.d.e(eVar, thread, stackTraceElementArr, threadArr3, linkedList, 8, aVarA, aVar6));
            b.i.c.m.d.p.d.m(cVar, thread, stackTraceElementArr, 4, true);
            length = threadArr3.length;
            for (i2 = 0; i2 < length; i2++) {
                b.i.c.m.d.p.d.m(cVar, threadArr3[i2], (StackTraceElement[]) linkedList.get(i2), 0, false);
            }
            b.i.c.m.d.p.d.l(cVar, eVar, 1, 8, 2);
            cVar.r(3, 2);
            cVar.o(b.i.c.m.d.p.d.d());
            b.i.c.m.d.p.a aVar7 = b.i.c.m.d.p.d.a;
            cVar.l(1, aVar7);
            cVar.l(2, aVar7);
            cVar.t(3, 0L);
            cVar.r(4, 2);
            aVar4 = aVar;
            cVar.o(b.i.c.m.d.p.d.a(aVarA, aVar4));
            cVar.t(1, 0L);
            cVar.t(2, 0L);
            cVar.l(3, aVarA);
            if (aVar4 != null) {
                cVar.l(4, aVar4);
            }
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
                    cVar.r(2, 2);
                    cVar.o(b.i.c.m.d.p.d.b(entry2.getKey(), entry2.getValue()));
                    cVar.l(1, b.i.c.m.d.p.a.a(entry2.getKey()));
                    String value = entry2.getValue();
                    if (value == null) {
                        value = str5;
                    }
                    cVar.l(2, b.i.c.m.d.p.a.a(value));
                }
            }
            if (runningAppProcessInfoI != null) {
                cVar.k(3, runningAppProcessInfoI.importance != 100);
            }
            cVar.s(4, i3);
            cVar.r(5, 2);
            cVar.o(b.i.c.m.d.p.d.g(f2, iB, zM, i3, j3, jA));
            if (f2 != null) {
                float fFloatValue = f2.floatValue();
                cVar.o(13);
                int iFloatToRawIntBits = Float.floatToRawIntBits(fFloatValue);
                cVar.n(iFloatToRawIntBits & 255);
                cVar.n((iFloatToRawIntBits >> 8) & 255);
                cVar.n((iFloatToRawIntBits >> 16) & 255);
                cVar.n((iFloatToRawIntBits >> 24) & 255);
            }
            cVar.o(16);
            cVar.o((iB << 1) ^ (iB >> 31));
            cVar.k(3, zM);
            cVar.s(4, i3);
            cVar.t(5, j3);
            cVar.t(6, jA);
            if (aVar3 != null) {
                cVar.r(6, 2);
                cVar.o(b.i.c.m.d.p.c.b(1, aVar3));
                cVar.l(1, aVar3);
            }
            this.t.d.d();
        }
        mapA = new TreeMap<>();
        treeMap = mapA;
        bArrC = this.t.d.c();
        b.i.c.m.d.p.a aVar52 = b.i.c.m.d.p.d.a;
        b.i.c.m.d.p.a aVarA3 = b.i.c.m.d.p.a.a(str4);
        if (str3 != null) {
        }
        if (bArrC == null) {
        }
        cVar.r(10, 2);
        int iB22 = b.i.c.m.d.p.c.b(2, b.i.c.m.d.p.a.a(str)) + b.i.c.m.d.p.c.h(1, j2) + 0;
        aVar3 = aVar2;
        String str52 = str2;
        Thread[] threadArr32 = threadArr;
        int iF2 = b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, aVarA3, aVar, treeMap, runningAppProcessInfoI, i3);
        int iD3 = b.i.c.m.d.p.c.d(iF2) + b.i.c.m.d.p.c.e(3) + iF2 + iB22;
        int iG2 = b.i.c.m.d.p.d.g(f2, iB, zM, i3, j3, jA);
        int iD22 = b.i.c.m.d.p.c.d(iG2) + b.i.c.m.d.p.c.e(5) + iG2 + iD3;
        if (aVar3 != null) {
        }
        cVar.o(iD22);
        cVar.t(1, j2);
        cVar.l(2, b.i.c.m.d.p.a.a(str));
        cVar.r(3, 2);
        b.i.c.m.d.p.a aVar62 = aVar;
        cVar.o(b.i.c.m.d.p.d.f(eVar, thread, stackTraceElementArr, threadArr32, linkedList, 8, aVarA3, aVar62, treeMap, runningAppProcessInfoI, i3));
        cVar.r(1, 2);
        cVar.o(b.i.c.m.d.p.d.e(eVar, thread, stackTraceElementArr, threadArr32, linkedList, 8, aVarA3, aVar62));
        b.i.c.m.d.p.d.m(cVar, thread, stackTraceElementArr, 4, true);
        length = threadArr32.length;
        while (i2 < length) {
        }
        b.i.c.m.d.p.d.l(cVar, eVar, 1, 8, 2);
        cVar.r(3, 2);
        cVar.o(b.i.c.m.d.p.d.d());
        b.i.c.m.d.p.a aVar72 = b.i.c.m.d.p.d.a;
        cVar.l(1, aVar72);
        cVar.l(2, aVar72);
        cVar.t(3, 0L);
        cVar.r(4, 2);
        aVar4 = aVar;
        cVar.o(b.i.c.m.d.p.d.a(aVarA3, aVar4));
        cVar.t(1, 0L);
        cVar.t(2, 0L);
        cVar.l(3, aVarA3);
        if (aVar4 != null) {
        }
        if (treeMap != null) {
            while (r3.hasNext()) {
            }
        }
        if (runningAppProcessInfoI != null) {
        }
        cVar.s(4, i3);
        cVar.r(5, 2);
        cVar.o(b.i.c.m.d.p.d.g(f2, iB, zM, i3, j3, jA));
        if (f2 != null) {
        }
        cVar.o(16);
        cVar.o((iB << 1) ^ (iB >> 31));
        cVar.k(3, zM);
        cVar.s(4, i3);
        cVar.t(5, j3);
        cVar.t(6, jA);
        if (aVar3 != null) {
        }
        this.t.d.d();
    }

    public final void z(String str, String str2, g gVar) throws Exception {
        Throwable th;
        b.i.c.m.d.p.b bVar;
        b.i.c.m.d.p.c cVar = null;
        try {
            bVar = new b.i.c.m.d.p.b(l(), str + str2);
            try {
                b.i.c.m.d.p.c cVarI = b.i.c.m.d.p.c.i(bVar);
                try {
                    gVar.a(cVarI);
                    b.i.c.m.d.k.h.h(cVarI, "Failed to flush to session " + str2 + " file.");
                    b.i.c.m.d.k.h.c(bVar, "Failed to close session " + str2 + " file.");
                } catch (Throwable th2) {
                    th = th2;
                    cVar = cVarI;
                    b.i.c.m.d.k.h.h(cVar, "Failed to flush to session " + str2 + " file.");
                    b.i.c.m.d.k.h.c(bVar, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
        }
    }
}
