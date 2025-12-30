package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.AdjustConfig;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.InterfaceC3400b;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3582a4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3621d1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3630da;
import p007b.p225i.p226a.p288f.p313h.p325l.C3635e1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;
import p007b.p225i.p226a.p288f.p313h.p325l.C3687hb;
import p007b.p225i.p226a.p288f.p313h.p325l.C3691i1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3752m9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3777o8;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.C3847u0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3893x7;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3791p9;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.i.b.k9 */
/* loaded from: classes3.dex */
public class C4097k9 implements InterfaceC4192t5 {

    /* renamed from: a */
    public static volatile C4097k9 f10895a;

    /* renamed from: b */
    public C4147p4 f10897b;

    /* renamed from: c */
    public C4234x3 f10898c;

    /* renamed from: d */
    public C4040g f10899d;

    /* renamed from: e */
    public C3985b4 f10900e;

    /* renamed from: f */
    public C4062h9 f10901f;

    /* renamed from: g */
    public C3991ba f10902g;

    /* renamed from: h */
    public final C4163q9 f10903h;

    /* renamed from: i */
    public C4048g7 f10904i;

    /* renamed from: j */
    public C4162q8 f10905j;

    /* renamed from: k */
    public final C4202u4 f10906k;

    /* renamed from: m */
    public boolean f10908m;

    /* renamed from: n */
    public long f10909n;

    /* renamed from: o */
    public List<Runnable> f10910o;

    /* renamed from: p */
    public int f10911p;

    /* renamed from: q */
    public int f10912q;

    /* renamed from: r */
    public boolean f10913r;

    /* renamed from: s */
    public boolean f10914s;

    /* renamed from: t */
    public boolean f10915t;

    /* renamed from: u */
    public FileLock f10916u;

    /* renamed from: v */
    public FileChannel f10917v;

    /* renamed from: w */
    public List<Long> f10918w;

    /* renamed from: x */
    public List<Long> f10919x;

    /* renamed from: y */
    public long f10920y;

    /* renamed from: z */
    public final Map<String, C4004d> f10921z;

    /* renamed from: l */
    public boolean f10907l = false;

    /* renamed from: A */
    public final InterfaceC4218v9 f10896A = new C4130n9(this);

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* renamed from: b.i.a.f.i.b.k9$a */
    public class a {

        /* renamed from: a */
        public C3635e1 f10922a;

        /* renamed from: b */
        public List<Long> f10923b;

        /* renamed from: c */
        public List<C3579a1> f10924c;

        /* renamed from: d */
        public long f10925d;

        public a(C4097k9 c4097k9, RunnableC4086j9 runnableC4086j9) {
        }

        /* renamed from: a */
        public final void m5746a(C3635e1 c3635e1) {
            this.f10922a = c3635e1;
        }

        /* renamed from: b */
        public final boolean m5747b(long j, C3579a1 c3579a1) {
            if (this.f10924c == null) {
                this.f10924c = new ArrayList();
            }
            if (this.f10923b == null) {
                this.f10923b = new ArrayList();
            }
            if (this.f10924c.size() > 0 && ((this.f10924c.get(0).m4535H() / 1000) / 60) / 60 != ((c3579a1.m4535H() / 1000) / 60) / 60) {
                return false;
            }
            long jMo4606g = this.f10925d + c3579a1.mo4606g();
            if (jMo4606g >= Math.max(0, C4142p.f11077i.m5693a(null).intValue())) {
                return false;
            }
            this.f10925d = jMo4606g;
            this.f10924c.add(c3579a1);
            this.f10923b.add(Long.valueOf(j));
            return this.f10924c.size() < Math.max(1, C4142p.f11079j.m5693a(null).intValue());
        }
    }

    public C4097k9(C4174r9 c4174r9) throws IllegalStateException {
        C4202u4 c4202u4M5933b = C4202u4.m5933b(c4174r9.f11189a, null, null);
        this.f10906k = c4202u4M5933b;
        this.f10920y = -1L;
        C4163q9 c4163q9 = new C4163q9(this);
        c4163q9.m5685o();
        this.f10903h = c4163q9;
        C4234x3 c4234x3 = new C4234x3(this);
        c4234x3.m5685o();
        this.f10898c = c4234x3;
        C4147p4 c4147p4 = new C4147p4(this);
        c4147p4.m5685o();
        this.f10897b = c4147p4;
        this.f10921z = new HashMap();
        c4202u4M5933b.mo5725f().m5852v(new RunnableC4086j9(this, c4174r9));
    }

    /* renamed from: C */
    public static void m5697C(AbstractC4074i9 abstractC4074i9) {
        if (abstractC4074i9 == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (abstractC4074i9.f10828c) {
            return;
        }
        String strValueOf = String.valueOf(abstractC4074i9.getClass());
        throw new IllegalStateException(outline.m857j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    /* renamed from: b */
    public static C4097k9 m5698b(Context context) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (f10895a == null) {
            synchronized (C4097k9.class) {
                if (f10895a == null) {
                    f10895a = new C4097k9(new C4174r9(context));
                }
            }
        }
        return f10895a;
    }

    /* renamed from: d */
    public static void m5699d(C3579a1.a aVar, int i, String str) {
        List<C3607c1> listM4550v = aVar.m4550v();
        for (int i2 = 0; i2 < listM4550v.size(); i2++) {
            if ("_err".equals(listM4550v.get(i2).m4587B())) {
                return;
            }
        }
        C3607c1.a aVarM4578Q = C3607c1.m4578Q();
        aVarM4578Q.m4600s("_err");
        aVarM4578Q.m4599r(Long.valueOf(i).longValue());
        C3607c1 c3607c1 = (C3607c1) ((AbstractC3851u4) aVarM4578Q.m5320p());
        C3607c1.a aVarM4578Q2 = C3607c1.m4578Q();
        aVarM4578Q2.m4600s("_ev");
        aVarM4578Q2.m4601t(str);
        C3607c1 c3607c12 = (C3607c1) ((AbstractC3851u4) aVarM4578Q2.m5320p());
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3579a1.m4522A((C3579a1) aVar.f10347k, c3607c1);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3579a1.m4522A((C3579a1) aVar.f10347k, c3607c12);
    }

    /* renamed from: e */
    public static void m5700e(C3579a1.a aVar, @NonNull String str) {
        List<C3607c1> listM4550v = aVar.m4550v();
        for (int i = 0; i < listM4550v.size(); i++) {
            if (str.equals(listM4550v.get(i).m4587B())) {
                aVar.m4552x(i);
                return;
            }
        }
    }

    /* renamed from: A */
    public final void m5701A(C3579a1.a aVar, C3579a1.a aVar2) {
        AnimatableValueParser.m539l("_e".equals(aVar.m4553y()));
        m5713N();
        C3607c1 c3607c1M5831w = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar.m5320p()), "_et");
        if (!c3607c1M5831w.m4590I() || c3607c1M5831w.m4591J() <= 0) {
            return;
        }
        long jM4591J = c3607c1M5831w.m4591J();
        m5713N();
        C3607c1 c3607c1M5831w2 = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar2.m5320p()), "_et");
        if (c3607c1M5831w2 != null && c3607c1M5831w2.m4591J() > 0) {
            jM4591J += c3607c1M5831w2.m4591J();
        }
        m5713N();
        C4163q9.m5821E(aVar2, "_et", Long.valueOf(jM4591J));
        m5713N();
        C4163q9.m5821E(aVar, "_fr", 1L);
    }

    @WorkerThread
    /* renamed from: B */
    public final void m5702B(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        if (C3644ea.m4872b() && this.f10906k.f11260h.m5526o(C4142p.f11021A0)) {
            C4201u3 c4201u3M5931b = C4201u3.m5931b(zzaqVar);
            this.f10906k.m5949t().m5894H(c4201u3M5931b.f11244d, m5710K().m5636h0(zznVar.f20683j));
            this.f10906k.m5949t().m5903Q(c4201u3M5931b, this.f10906k.f11260h.m5524m(zznVar.f20683j));
            zzaqVar = c4201u3M5931b.m5932a();
        }
        if (this.f10906k.f11260h.m5526o(C4142p.f11070e0) && "_cmp".equals(zzaqVar.f20666j) && "referrer API v2".equals(zzaqVar.f20667k.f20665j.getString("_cis"))) {
            String string = zzaqVar.f20667k.f20665j.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                m5734o(new zzku("_lgclid", zzaqVar.f20669m, string, "auto"), zznVar);
            }
        }
        m5731l(zzaqVar, zznVar);
    }

    @WorkerThread
    /* renamed from: D */
    public final void m5703D(zzku zzkuVar, zzn zznVar) {
        m5720U();
        m5715P();
        if (m5711L(zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            if ("_npa".equals(zzkuVar.f20671k) && zznVar.f20678B != null) {
                this.f10906k.mo5726g().f11148m.m5860a("Falling back to manifest metadata value for ad personalization");
                Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                m5734o(new zzku("_npa", System.currentTimeMillis(), Long.valueOf(zznVar.f20678B.booleanValue() ? 1L : 0L), "auto"), zznVar);
                return;
            }
            this.f10906k.mo5726g().f11148m.m5861b("Removing user property", this.f10906k.m5950u().m5769y(zzkuVar.f20671k));
            m5710K().m5630b0();
            try {
                m5706G(zznVar);
                m5710K().m5624V(zznVar.f20683j, zzkuVar.f20671k);
                m5710K().m5639s();
                this.f10906k.mo5726g().f11148m.m5861b("User property removed", this.f10906k.m5950u().m5769y(zzkuVar.f20671k));
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0237  */
    @WorkerThread
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5704E(zzn zznVar) {
        C3973a4 c3973a4;
        String str;
        long j;
        String str2;
        long j2;
        PackageInfo packageInfoM4374b;
        String str3;
        long j3;
        ApplicationInfo applicationInfoM4373a;
        boolean z2;
        m5720U();
        m5715P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.m583w(zznVar.f20683j);
        if (m5711L(zznVar)) {
            C3973a4 c3973a4M5622T = m5710K().m5622T(zznVar.f20683j);
            if (c3973a4M5622T != null && TextUtils.isEmpty(c3973a4M5622T.m5492v()) && !TextUtils.isEmpty(zznVar.f20684k)) {
                c3973a4M5622T.m5452F(0L);
                m5710K().m5611I(c3973a4M5622T);
                C4147p4 c4147p4M5707H = m5707H();
                String str4 = zznVar.f20683j;
                c4147p4M5707H.mo5848b();
                c4147p4M5707H.f11120g.remove(str4);
            }
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            long jCurrentTimeMillis = zznVar.f20695v;
            if (jCurrentTimeMillis == 0) {
                Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            C4076j c4076jM5954y = this.f10906k.m5954y();
            c4076jM5954y.mo5848b();
            c4076jM5954y.f10833g = null;
            c4076jM5954y.f10834h = 0L;
            int i = zznVar.f20696w;
            if (i != 0 && i != 1) {
                this.f10906k.mo5726g().f11144i.m5862c("Incorrect app type, assuming installed app. appId, appType", C4157q3.m5788s(zznVar.f20683j), Integer.valueOf(i));
                i = 0;
            }
            m5710K().m5630b0();
            try {
                C4207u9 c4207u9M5627Y = m5710K().m5627Y(zznVar.f20683j, "_npa");
                if (c4207u9M5627Y == null || "auto".equals(c4207u9M5627Y.f11291b)) {
                    Boolean bool = zznVar.f20678B;
                    if (bool != null) {
                        c3973a4 = null;
                        zzku zzkuVar = new zzku("_npa", jCurrentTimeMillis, Long.valueOf(bool.booleanValue() ? 1L : 0L), "auto");
                        if (c4207u9M5627Y == null || !c4207u9M5627Y.f11294e.equals(zzkuVar.f20673m)) {
                            m5734o(zzkuVar, zznVar);
                        }
                    } else {
                        c3973a4 = null;
                        if (c4207u9M5627Y != null) {
                            m5703D(new zzku("_npa", jCurrentTimeMillis, null, "auto"), zznVar);
                        }
                    }
                } else {
                    c3973a4 = null;
                }
                C3973a4 c3973a4M5622T2 = m5710K().m5622T(zznVar.f20683j);
                if (c3973a4M5622T2 != null) {
                    this.f10906k.m5949t();
                    if (C4196t9.m5878d0(zznVar.f20684k, c3973a4M5622T2.m5492v(), zznVar.f20677A, c3973a4M5622T2.m5495y())) {
                        this.f10906k.mo5726g().f11144i.m5861b("New GMP App Id passed in. Removing cached database data. appId", C4157q3.m5788s(c3973a4M5622T2.m5485o()));
                        C4040g c4040gM5710K = m5710K();
                        String strM5485o = c3973a4M5622T2.m5485o();
                        c4040gM5710K.m5684n();
                        c4040gM5710K.mo5848b();
                        AnimatableValueParser.m583w(strM5485o);
                        try {
                            SQLiteDatabase sQLiteDatabaseM5640t = c4040gM5710K.m5640t();
                            String[] strArr = {strM5485o};
                            int iDelete = sQLiteDatabaseM5640t.delete("events", "app_id=?", strArr) + 0 + sQLiteDatabaseM5640t.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("apps", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("consent_settings", "app_id=?", strArr);
                            if (iDelete > 0) {
                                c4040gM5710K.mo5726g().f11149n.m5862c("Deleted application data. app, records", strM5485o, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e) {
                            c4040gM5710K.mo5726g().f11141f.m5862c("Error deleting application data. appId, error", C4157q3.m5788s(strM5485o), e);
                        }
                        c3973a4M5622T2 = c3973a4;
                    }
                }
                if (c3973a4M5622T2 != null) {
                    if (((c3973a4M5622T2.m5460N() == -2147483648L || c3973a4M5622T2.m5460N() == zznVar.f20692s) ? false : true) | ((c3973a4M5622T2.m5460N() != -2147483648L || c3973a4M5622T2.m5459M() == null || c3973a4M5622T2.m5459M().equals(zznVar.f20685l)) ? false : true)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", c3973a4M5622T2.m5459M());
                        m5731l(new zzaq("_au", new zzap(bundle), "auto", jCurrentTimeMillis), zznVar);
                    }
                }
                m5706G(zznVar);
                if ((i == 0 ? m5710K().m5646z(zznVar.f20683j, "_f") : i == 1 ? m5710K().m5646z(zznVar.f20683j, "_v") : c3973a4) == null) {
                    long j4 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    if (i == 0) {
                        m5734o(new zzku("_fot", jCurrentTimeMillis, Long.valueOf(j4), "auto"), zznVar);
                        m5720U();
                        this.f10906k.f11276x.m5758a(zznVar.f20683j);
                        m5720U();
                        m5715P();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        if (this.f10906k.f11260h.m5532u(zznVar.f20683j, C4142p.f11054T)) {
                            str2 = "_et";
                            j2 = 1;
                            bundle2.putLong(str2, 1L);
                        } else {
                            str2 = "_et";
                            j2 = 1;
                        }
                        if (zznVar.f20699z) {
                            bundle2.putLong("_dac", j2);
                        }
                        C4040g c4040gM5710K2 = m5710K();
                        String str5 = zznVar.f20683j;
                        AnimatableValueParser.m583w(str5);
                        c4040gM5710K2.mo5848b();
                        c4040gM5710K2.m5684n();
                        long jM5635g0 = c4040gM5710K2.m5635g0(str5, "first_open_count");
                        if (this.f10906k.f11254b.getPackageManager() == null) {
                            this.f10906k.mo5726g().f11141f.m5861b("PackageManager is null, first open report might be inaccurate. appId", C4157q3.m5788s(zznVar.f20683j));
                            str3 = str2;
                            j3 = jM5635g0;
                        } else {
                            try {
                                packageInfoM4374b = C3411b.m4376a(this.f10906k.f11254b).m4374b(zznVar.f20683j, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.f10906k.mo5726g().f11141f.m5862c("Package info is null, first open report might be inaccurate. appId", C4157q3.m5788s(zznVar.f20683j), e2);
                                packageInfoM4374b = c3973a4;
                            }
                            if (packageInfoM4374b != 0) {
                                long j5 = packageInfoM4374b.firstInstallTime;
                                if (j5 != 0) {
                                    str3 = str2;
                                    if (j5 != packageInfoM4374b.lastUpdateTime) {
                                        if (!this.f10906k.f11260h.m5526o(C4142p.f11088n0) || jM5635g0 == 0) {
                                            bundle2.putLong("_uwa", 1L);
                                        }
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    j3 = jM5635g0;
                                    m5734o(new zzku("_fi", jCurrentTimeMillis, Long.valueOf(z2 ? 1L : 0L), "auto"), zznVar);
                                } else {
                                    str3 = str2;
                                    j3 = jM5635g0;
                                }
                                try {
                                    applicationInfoM4373a = C3411b.m4376a(this.f10906k.f11254b).m4373a(zznVar.f20683j, 0);
                                } catch (PackageManager.NameNotFoundException e3) {
                                    this.f10906k.mo5726g().f11141f.m5862c("Application info is null, first open report might be inaccurate. appId", C4157q3.m5788s(zznVar.f20683j), e3);
                                    applicationInfoM4373a = c3973a4;
                                }
                                if (applicationInfoM4373a != 0) {
                                    if ((applicationInfoM4373a.flags & 1) != 0) {
                                        bundle2.putLong("_sys", 1L);
                                    }
                                    if ((applicationInfoM4373a.flags & 128) != 0) {
                                        bundle2.putLong("_sysu", 1L);
                                    }
                                }
                            }
                        }
                        if (j3 >= 0) {
                            bundle2.putLong("_pfo", j3);
                        }
                        m5702B(new zzaq("_f", new zzap(bundle2), "auto", jCurrentTimeMillis), zznVar);
                        str = str3;
                    } else {
                        str = "_et";
                        if (i == 1) {
                            m5734o(new zzku("_fvt", jCurrentTimeMillis, Long.valueOf(j4), "auto"), zznVar);
                            m5720U();
                            m5715P();
                            Bundle bundle3 = new Bundle();
                            bundle3.putLong("_c", 1L);
                            bundle3.putLong("_r", 1L);
                            if (this.f10906k.f11260h.m5532u(zznVar.f20683j, C4142p.f11054T)) {
                                j = 1;
                                bundle3.putLong(str, 1L);
                            } else {
                                j = 1;
                            }
                            if (zznVar.f20699z) {
                                bundle3.putLong("_dac", j);
                            }
                            m5702B(new zzaq("_v", new zzap(bundle3), "auto", jCurrentTimeMillis), zznVar);
                        }
                    }
                    if (!this.f10906k.f11260h.m5532u(zznVar.f20683j, C4142p.f11055U)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong(str, 1L);
                        if (this.f10906k.f11260h.m5532u(zznVar.f20683j, C4142p.f11054T)) {
                            bundle4.putLong("_fr", 1L);
                        }
                        m5702B(new zzaq("_e", new zzap(bundle4), "auto", jCurrentTimeMillis), zznVar);
                    }
                } else if (zznVar.f20691r) {
                    m5702B(new zzaq("_cd", new zzap(new Bundle()), "auto", jCurrentTimeMillis), zznVar);
                }
                m5710K().m5639s();
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    @WorkerThread
    /* renamed from: F */
    public final void m5705F(zzz zzzVar, zzn zznVar) {
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.m583w(zzzVar.f20700j);
        Objects.requireNonNull(zzzVar.f20702l, "null reference");
        AnimatableValueParser.m583w(zzzVar.f20702l.f20671k);
        m5720U();
        m5715P();
        if (m5711L(zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            m5710K().m5630b0();
            try {
                m5706G(zznVar);
                zzz zzzVarM5628Z = m5710K().m5628Z(zzzVar.f20700j, zzzVar.f20702l.f20671k);
                if (zzzVarM5628Z != null) {
                    this.f10906k.mo5726g().f11148m.m5862c("Removing conditional user property", zzzVar.f20700j, this.f10906k.m5950u().m5769y(zzzVar.f20702l.f20671k));
                    m5710K().m5629a0(zzzVar.f20700j, zzzVar.f20702l.f20671k);
                    if (zzzVarM5628Z.f20704n) {
                        m5710K().m5624V(zzzVar.f20700j, zzzVar.f20702l.f20671k);
                    }
                    zzaq zzaqVar = zzzVar.f20710t;
                    if (zzaqVar != null) {
                        zzap zzapVar = zzaqVar.f20667k;
                        Bundle bundleM9114x0 = zzapVar != null ? zzapVar.m9114x0() : null;
                        C4196t9 c4196t9M5949t = this.f10906k.m5949t();
                        String str = zzzVar.f20700j;
                        zzaq zzaqVar2 = zzzVar.f20710t;
                        m5708I(c4196t9M5949t.m5890B(str, zzaqVar2.f20666j, bundleM9114x0, zzzVarM5628Z.f20701k, zzaqVar2.f20669m, true, C3893x7.m5362b() && this.f10906k.f11260h.m5526o(C4142p.f11045M0)), zznVar);
                    }
                } else {
                    this.f10906k.mo5726g().f11144i.m5862c("Conditional user property doesn't exist", C4157q3.m5788s(zzzVar.f20700j), this.f10906k.m5950u().m5769y(zzzVar.f20702l.f20671k));
                }
                m5710K().m5639s();
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0407  */
    @WorkerThread
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C3973a4 m5706G(zzn zznVar) {
        boolean z2;
        long j;
        String str;
        long j2;
        m5720U();
        m5715P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.m583w(zznVar.f20683j);
        C3973a4 c3973a4M5622T = m5710K().m5622T(zznVar.f20683j);
        C4004d c4004dM5570h = C4004d.f10622a;
        C4004d c4004dM5570h2 = (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) ? m5723a(zznVar.f20683j).m5570h(C4004d.m5563b(zznVar.f20682F)) : c4004dM5570h;
        String strM5816t = (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && !c4004dM5570h2.m5571j()) ? "" : this.f10905j.m5816t(zznVar.f20683j);
        if (((InterfaceC3791p9) C3752m9.f10097j.mo4555a()).mo5156a() && this.f10906k.f11260h.m5526o(C4142p.f11090o0)) {
            if (c3973a4M5622T == null) {
                c3973a4M5622T = new C3973a4(this.f10906k, zznVar.f20683j);
                if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
                    if (c4004dM5570h2.m5572k()) {
                        c3973a4M5622T.m5473c(m5724c(c4004dM5570h2));
                    }
                    if (c4004dM5570h2.m5571j()) {
                        c3973a4M5622T.m5494x(strM5816t);
                    }
                } else {
                    c3973a4M5622T.m5473c(m5722W());
                    c3973a4M5622T.m5494x(strM5816t);
                }
            } else if ((!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0) || c4004dM5570h2.m5571j()) && !strM5816t.equals(c3973a4M5622T.m5451E())) {
                c3973a4M5622T.m5494x(strM5816t);
                if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
                    c3973a4M5622T.m5473c(m5724c(c4004dM5570h2));
                } else {
                    c3973a4M5622T.m5473c(m5722W());
                }
            } else if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && TextUtils.isEmpty(c3973a4M5622T.m5489s()) && c4004dM5570h2.m5572k()) {
                c3973a4M5622T.m5473c(m5724c(c4004dM5570h2));
            }
            c3973a4M5622T.m5483m(zznVar.f20684k);
            c3973a4M5622T.m5487q(zznVar.f20677A);
            if (C3630da.m4644b() && this.f10906k.f11260h.m5532u(c3973a4M5622T.m5485o(), C4142p.f11080j0)) {
                c3973a4M5622T.m5491u(zznVar.f20681E);
            }
            if (!TextUtils.isEmpty(zznVar.f20693t)) {
                c3973a4M5622T.m5447A(zznVar.f20693t);
            }
            long j3 = zznVar.f20687n;
            if (j3 != 0) {
                c3973a4M5622T.m5490t(j3);
            }
            if (!TextUtils.isEmpty(zznVar.f20685l)) {
                c3973a4M5622T.m5450D(zznVar.f20685l);
            }
            c3973a4M5622T.m5486p(zznVar.f20692s);
            String str2 = zznVar.f20686m;
            if (str2 != null) {
                c3973a4M5622T.m5453G(str2);
            }
            c3973a4M5622T.m5493w(zznVar.f20688o);
            c3973a4M5622T.m5475e(zznVar.f20690q);
            if (!TextUtils.isEmpty(zznVar.f20689p)) {
                c3973a4M5622T.m5456J(zznVar.f20689p);
            }
            if (!this.f10906k.f11260h.m5526o(C4142p.f11110y0)) {
                c3973a4M5622T.m5464R(zznVar.f20694u);
            }
            c3973a4M5622T.m5484n(zznVar.f20697x);
            c3973a4M5622T.m5488r(zznVar.f20698y);
            c3973a4M5622T.m5472b(zznVar.f20678B);
            c3973a4M5622T.m5496z(zznVar.f20679C);
            c3973a4M5622T.f10516a.mo5725f().mo5848b();
            if (c3973a4M5622T.f10513E) {
                m5710K().m5611I(c3973a4M5622T);
            }
            return c3973a4M5622T;
        }
        if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
            c4004dM5570h = m5723a(zznVar.f20683j).m5570h(C4004d.m5563b(zznVar.f20682F));
        }
        boolean z3 = true;
        if (c3973a4M5622T == null) {
            c3973a4M5622T = new C3973a4(this.f10906k, zznVar.f20683j);
            if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
                if (c4004dM5570h.m5572k()) {
                    c3973a4M5622T.m5473c(m5724c(c4004dM5570h));
                }
                if (c4004dM5570h.m5571j()) {
                    c3973a4M5622T.m5494x(strM5816t);
                }
            } else {
                c3973a4M5622T.m5473c(m5722W());
                c3973a4M5622T.m5494x(strM5816t);
            }
        } else if ((!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0) || c4004dM5570h.m5571j()) && !strM5816t.equals(c3973a4M5622T.m5451E())) {
            c3973a4M5622T.m5494x(strM5816t);
            if (!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
                c3973a4M5622T.m5473c(m5722W());
            } else if (c4004dM5570h.m5572k()) {
                c3973a4M5622T.m5473c(m5724c(c4004dM5570h));
            }
        } else {
            if (!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0) || !TextUtils.isEmpty(c3973a4M5622T.m5489s()) || !c4004dM5570h.m5572k()) {
                z2 = false;
                if (!TextUtils.equals(zznVar.f20684k, c3973a4M5622T.m5492v())) {
                    c3973a4M5622T.m5483m(zznVar.f20684k);
                    z2 = true;
                }
                if (!TextUtils.equals(zznVar.f20677A, c3973a4M5622T.m5495y())) {
                    c3973a4M5622T.m5487q(zznVar.f20677A);
                    z2 = true;
                }
                if (C3630da.m4644b() && this.f10906k.f11260h.m5532u(c3973a4M5622T.m5485o(), C4142p.f11080j0) && !TextUtils.equals(zznVar.f20681E, c3973a4M5622T.m5448B())) {
                    c3973a4M5622T.m5491u(zznVar.f20681E);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.f20693t) && !zznVar.f20693t.equals(c3973a4M5622T.m5454H())) {
                    c3973a4M5622T.m5447A(zznVar.f20693t);
                    z2 = true;
                }
                j = zznVar.f20687n;
                if (j != 0 && j != c3973a4M5622T.m5462P()) {
                    c3973a4M5622T.m5490t(zznVar.f20687n);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.f20685l) && !zznVar.f20685l.equals(c3973a4M5622T.m5459M())) {
                    c3973a4M5622T.m5450D(zznVar.f20685l);
                    z2 = true;
                }
                if (zznVar.f20692s != c3973a4M5622T.m5460N()) {
                    c3973a4M5622T.m5486p(zznVar.f20692s);
                    z2 = true;
                }
                str = zznVar.f20686m;
                if (str != null && !str.equals(c3973a4M5622T.m5461O())) {
                    c3973a4M5622T.m5453G(zznVar.f20686m);
                    z2 = true;
                }
                if (zznVar.f20688o != c3973a4M5622T.m5463Q()) {
                    c3973a4M5622T.m5493w(zznVar.f20688o);
                    z2 = true;
                }
                if (zznVar.f20690q != c3973a4M5622T.m5466T()) {
                    c3973a4M5622T.m5475e(zznVar.f20690q);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.f20689p)) {
                    String str3 = zznVar.f20689p;
                    c3973a4M5622T.f10516a.mo5725f().mo5848b();
                    if (!str3.equals(c3973a4M5622T.f10512D)) {
                        c3973a4M5622T.m5456J(zznVar.f20689p);
                        z2 = true;
                    }
                }
                if (!this.f10906k.f11260h.m5526o(C4142p.f11110y0) && zznVar.f20694u != c3973a4M5622T.m5477g()) {
                    c3973a4M5622T.m5464R(zznVar.f20694u);
                    z2 = true;
                }
                if (zznVar.f20697x != c3973a4M5622T.m5478h()) {
                    c3973a4M5622T.m5484n(zznVar.f20697x);
                    z2 = true;
                }
                if (zznVar.f20698y != c3973a4M5622T.m5479i()) {
                    c3973a4M5622T.m5488r(zznVar.f20698y);
                    z2 = true;
                }
                if (zznVar.f20678B != c3973a4M5622T.m5480j()) {
                    c3973a4M5622T.m5472b(zznVar.f20678B);
                    z2 = true;
                }
                j2 = zznVar.f20679C;
                if (j2 != 0 || j2 == c3973a4M5622T.m5465S()) {
                    z3 = z2;
                } else {
                    c3973a4M5622T.m5496z(zznVar.f20679C);
                }
                if (z3) {
                    m5710K().m5611I(c3973a4M5622T);
                }
                return c3973a4M5622T;
            }
            c3973a4M5622T.m5473c(m5724c(c4004dM5570h));
        }
        z2 = true;
        if (!TextUtils.equals(zznVar.f20684k, c3973a4M5622T.m5492v())) {
        }
        if (!TextUtils.equals(zznVar.f20677A, c3973a4M5622T.m5495y())) {
        }
        if (C3630da.m4644b()) {
            c3973a4M5622T.m5491u(zznVar.f20681E);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.f20693t)) {
            c3973a4M5622T.m5447A(zznVar.f20693t);
            z2 = true;
        }
        j = zznVar.f20687n;
        if (j != 0) {
            c3973a4M5622T.m5490t(zznVar.f20687n);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.f20685l)) {
            c3973a4M5622T.m5450D(zznVar.f20685l);
            z2 = true;
        }
        if (zznVar.f20692s != c3973a4M5622T.m5460N()) {
        }
        str = zznVar.f20686m;
        if (str != null) {
            c3973a4M5622T.m5453G(zznVar.f20686m);
            z2 = true;
        }
        if (zznVar.f20688o != c3973a4M5622T.m5463Q()) {
        }
        if (zznVar.f20690q != c3973a4M5622T.m5466T()) {
        }
        if (!TextUtils.isEmpty(zznVar.f20689p)) {
        }
        if (!this.f10906k.f11260h.m5526o(C4142p.f11110y0)) {
            c3973a4M5622T.m5464R(zznVar.f20694u);
            z2 = true;
        }
        if (zznVar.f20697x != c3973a4M5622T.m5478h()) {
        }
        if (zznVar.f20698y != c3973a4M5622T.m5479i()) {
        }
        if (zznVar.f20678B != c3973a4M5622T.m5480j()) {
        }
        j2 = zznVar.f20679C;
        if (j2 != 0) {
            z3 = z2;
        }
        if (z3) {
        }
        return c3973a4M5622T;
    }

    /* renamed from: H */
    public final C4147p4 m5707H() {
        m5697C(this.f10897b);
        return this.f10897b;
    }

    /* JADX WARN: Removed duplicated region for block: B:296:0x094d A[Catch: all -> 0x099c, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ba A[Catch: all -> 0x099c, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f3 A[Catch: all -> 0x099c, TRY_LEAVE, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    @WorkerThread
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5708I(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        long j;
        int i;
        C4098l c4098lM5748a;
        boolean z2;
        C4207u9 c4207u9M5627Y;
        long jLongValue;
        boolean z3;
        C4040g c4040gM5710K;
        C4207u9 c4207u9;
        C4207u9 c4207u92;
        Long l;
        C3973a4 c3973a4M5622T;
        zzaq zzaqVarM5932a = zzaqVar;
        AnimatableValueParser.m415A(zznVar);
        AnimatableValueParser.m583w(zznVar.f20683j);
        long jNanoTime = System.nanoTime();
        m5720U();
        m5715P();
        String str = zznVar.f20683j;
        m5713N();
        if (C4163q9.m5826O(zzaqVar, zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            boolean z4 = true;
            if (m5707H().m5782x(str, zzaqVarM5932a.f20666j)) {
                this.f10906k.mo5726g().m5792A().m5862c("Dropping blacklisted event. appId", C4157q3.m5788s(str), this.f10906k.m5950u().m5766u(zzaqVarM5932a.f20666j));
                if (!m5707H().m5775C(str) && !m5707H().m5776D(str)) {
                    z4 = false;
                }
                if (z4 || "_err".equals(zzaqVarM5932a.f20666j)) {
                    l = null;
                } else {
                    l = null;
                    this.f10906k.m5949t().m5905S(this.f10896A, str, 11, "_ev", zzaqVarM5932a.f20666j, 0);
                }
                if (!z4 || (c3973a4M5622T = m5710K().m5622T(str)) == null || Math.abs(((C3401c) this.f10906k.mo5728i()).m4186a() - Math.max(c3973a4M5622T.m5469W(), c3973a4M5622T.m5468V())) <= C4142p.f11111z.m5693a(l).longValue()) {
                    return;
                }
                this.f10906k.mo5726g().m5794C().m5860a("Fetching config for blacklisted app");
                m5733n(c3973a4M5622T);
                return;
            }
            if (C3777o8.m5155b() && this.f10906k.m5939a().m5526o(C4142p.f11106w0)) {
                C4201u3 c4201u3M5931b = C4201u3.m5931b(zzaqVar);
                this.f10906k.m5949t().m5903Q(c4201u3M5931b, this.f10906k.m5939a().m5524m(str));
                zzaqVarM5932a = c4201u3M5931b.m5932a();
            }
            if (this.f10906k.mo5726g().m5800x(2)) {
                this.f10906k.mo5726g().m5795D().m5861b("Logging event", this.f10906k.m5950u().m5765t(zzaqVarM5932a));
            }
            m5710K().m5630b0();
            try {
                m5706G(zznVar);
                boolean z5 = "ecommerce_purchase".equals(zzaqVarM5932a.f20666j) || "purchase".equals(zzaqVarM5932a.f20666j) || "refund".equals(zzaqVarM5932a.f20666j);
                if ("_iap".equals(zzaqVarM5932a.f20666j) || z5) {
                    String strM9112A0 = zzaqVarM5932a.f20667k.m9112A0("currency");
                    if (z5) {
                        double dDoubleValue = zzaqVarM5932a.f20667k.m9116z0("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzaqVarM5932a.f20667k.m9115y0("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            this.f10906k.mo5726g().m5792A().m5862c("Data lost. Currency value is too big. appId", C4157q3.m5788s(str), Double.valueOf(dDoubleValue));
                            j = jNanoTime;
                            i = 0;
                            z3 = false;
                            if (!z3) {
                                m5710K().m5639s();
                                return;
                            }
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if ("refund".equals(zzaqVarM5932a.f20666j)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    } else {
                        jLongValue = zzaqVarM5932a.f20667k.m9115y0("value").longValue();
                    }
                    if (!TextUtils.isEmpty(strM9112A0)) {
                        String upperCase = strM9112A0.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strConcat = upperCase.length() != 0 ? "_ltv_".concat(upperCase) : new String("_ltv_");
                            C4207u9 c4207u9M5627Y2 = m5710K().m5627Y(str, strConcat);
                            if (c4207u9M5627Y2 != null) {
                                Object obj = c4207u9M5627Y2.f11294e;
                                if (obj instanceof Long) {
                                    j = jNanoTime;
                                    i = 0;
                                    c4207u9 = new C4207u9(str, zzaqVarM5932a.f20668l, strConcat, ((C3401c) this.f10906k.mo5728i()).m4186a(), Long.valueOf(((Long) obj).longValue() + jLongValue));
                                    c4207u92 = c4207u9;
                                    if (!m5710K().m5615M(c4207u92)) {
                                    }
                                } else {
                                    j = jNanoTime;
                                    i = 0;
                                    c4040gM5710K = m5710K();
                                    int iM5528q = this.f10906k.m5939a().m5528q(str, C4142p.f11028E) - 1;
                                    AnimatableValueParser.m583w(str);
                                    c4040gM5710K.mo5848b();
                                    c4040gM5710K.m5684n();
                                    try {
                                        c4040gM5710K.m5640t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iM5528q)});
                                    } catch (SQLiteException e) {
                                        c4040gM5710K.mo5726g().m5801z().m5862c("Error pruning currencies. appId", C4157q3.m5788s(str), e);
                                    }
                                    c4207u9 = new C4207u9(str, zzaqVarM5932a.f20668l, strConcat, ((C3401c) this.f10906k.mo5728i()).m4186a(), Long.valueOf(jLongValue));
                                    c4207u92 = c4207u9;
                                    if (!m5710K().m5615M(c4207u92)) {
                                        this.f10906k.mo5726g().m5801z().m5863d("Too many unique user properties are set. Ignoring user property. appId", C4157q3.m5788s(str), this.f10906k.m5950u().m5769y(c4207u92.f11292c), c4207u92.f11294e);
                                        this.f10906k.m5949t().m5905S(this.f10896A, str, 9, null, null, 0);
                                    }
                                }
                            } else {
                                j = jNanoTime;
                                i = 0;
                                c4040gM5710K = m5710K();
                                int iM5528q2 = this.f10906k.m5939a().m5528q(str, C4142p.f11028E) - 1;
                                AnimatableValueParser.m583w(str);
                                c4040gM5710K.mo5848b();
                                c4040gM5710K.m5684n();
                                c4040gM5710K.m5640t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iM5528q2)});
                                c4207u9 = new C4207u9(str, zzaqVarM5932a.f20668l, strConcat, ((C3401c) this.f10906k.mo5728i()).m4186a(), Long.valueOf(jLongValue));
                                c4207u92 = c4207u9;
                                if (!m5710K().m5615M(c4207u92)) {
                                }
                            }
                        } else {
                            j = jNanoTime;
                            i = 0;
                        }
                        z3 = true;
                        if (!z3) {
                        }
                    }
                } else {
                    j = jNanoTime;
                    i = 0;
                }
                boolean zM5877X = C4196t9.m5877X(zzaqVarM5932a.f20666j);
                boolean zEquals = "_err".equals(zzaqVarM5932a.f20666j);
                this.f10906k.m5949t();
                C4028f c4028fM5644x = m5710K().m5644x(m5721V(), str, C4196t9.m5887v(zzaqVarM5932a.f20667k) + 1, true, zM5877X, false, zEquals, false);
                long jIntValue = c4028fM5644x.f10705b - C4142p.f11081k.m5693a(null).intValue();
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        this.f10906k.mo5726g().m5801z().m5862c("Data loss. Too many events logged. appId, count", C4157q3.m5788s(str), Long.valueOf(c4028fM5644x.f10705b));
                    }
                    m5710K().m5639s();
                    return;
                }
                if (zM5877X) {
                    long jIntValue2 = c4028fM5644x.f10704a - C4142p.f11085m.m5693a(null).intValue();
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            this.f10906k.mo5726g().m5801z().m5862c("Data loss. Too many public events logged. appId, count", C4157q3.m5788s(str), Long.valueOf(c4028fM5644x.f10704a));
                        }
                        this.f10906k.m5949t().m5905S(this.f10896A, str, 16, "_ev", zzaqVarM5932a.f20666j, 0);
                        m5710K().m5639s();
                        return;
                    }
                }
                if (zEquals) {
                    long jMax = c4028fM5644x.f10707d - Math.max(i, Math.min(1000000, this.f10906k.m5939a().m5528q(zznVar.f20683j, C4142p.f11083l)));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            this.f10906k.mo5726g().m5801z().m5862c("Too many error events logged. appId, count", C4157q3.m5788s(str), Long.valueOf(c4028fM5644x.f10707d));
                        }
                        m5710K().m5639s();
                        return;
                    }
                }
                Bundle bundleM9114x0 = zzaqVarM5932a.f20667k.m9114x0();
                this.f10906k.m5949t().m5895I(bundleM9114x0, "_o", zzaqVarM5932a.f20668l);
                if (this.f10906k.m5949t().m5920s0(str)) {
                    this.f10906k.m5949t().m5895I(bundleM9114x0, "_dbg", 1L);
                    this.f10906k.m5949t().m5895I(bundleM9114x0, "_r", 1L);
                }
                if ("_s".equals(zzaqVarM5932a.f20666j) && (c4207u9M5627Y = m5710K().m5627Y(zznVar.f20683j, "_sno")) != null && (c4207u9M5627Y.f11294e instanceof Long)) {
                    this.f10906k.m5949t().m5895I(bundleM9114x0, "_sno", c4207u9M5627Y.f11294e);
                }
                long jM5626X = m5710K().m5626X(str);
                if (jM5626X > 0) {
                    this.f10906k.mo5726g().m5792A().m5862c("Data lost. Too many events stored on disk, deleted. appId", C4157q3.m5788s(str), Long.valueOf(jM5626X));
                }
                C4109m c4109m = new C4109m(this.f10906k, zzaqVarM5932a.f20668l, str, zzaqVarM5932a.f20666j, zzaqVarM5932a.f20669m, 0L, bundleM9114x0);
                C4098l c4098lM5646z = m5710K().m5646z(str, c4109m.f10953b);
                if (c4098lM5646z != null) {
                    c4109m = c4109m.m5752a(this.f10906k, c4098lM5646z.f10931f);
                    c4098lM5748a = c4098lM5646z.m5748a(c4109m.f10955d);
                } else {
                    if (m5710K().m5634f0(str) >= this.f10906k.m5939a().m5527p(str) && zM5877X) {
                        this.f10906k.mo5726g().m5801z().m5863d("Too many event names used, ignoring event. appId, name, supported count", C4157q3.m5788s(str), this.f10906k.m5950u().m5766u(c4109m.f10953b), Integer.valueOf(this.f10906k.m5939a().m5527p(str)));
                        this.f10906k.m5949t().m5905S(this.f10896A, str, 8, null, null, 0);
                        return;
                    }
                    c4098lM5748a = new C4098l(str, c4109m.f10953b, c4109m.f10955d);
                }
                m5710K().m5610H(c4098lM5748a);
                m5720U();
                m5715P();
                AnimatableValueParser.m415A(c4109m);
                AnimatableValueParser.m415A(zznVar);
                AnimatableValueParser.m583w(c4109m.f10952a);
                AnimatableValueParser.m539l(c4109m.f10952a.equals(zznVar.f20683j));
                C3635e1.a aVarM4690u0 = C3635e1.m4690u0();
                aVarM4690u0.m4804q();
                aVarM4690u0.m4818x("android");
                if (!TextUtils.isEmpty(zznVar.f20683j)) {
                    aVarM4690u0.m4785X(zznVar.f20683j);
                }
                if (!TextUtils.isEmpty(zznVar.f20686m)) {
                    aVarM4690u0.m4781T(zznVar.f20686m);
                }
                if (!TextUtils.isEmpty(zznVar.f20685l)) {
                    aVarM4690u0.m4788a0(zznVar.f20685l);
                }
                long j2 = zznVar.f20692s;
                if (j2 != -2147483648L) {
                    aVarM4690u0.m4790c0((int) j2);
                }
                aVarM4690u0.m4784W(zznVar.f20687n);
                if (!TextUtils.isEmpty(zznVar.f20684k)) {
                    aVarM4690u0.m4800m0(zznVar.f20684k);
                }
                if (C3842t8.m5293b() && this.f10906k.m5939a().m5526o(C4142p.f11039J0)) {
                    aVarM4690u0.m4817w0(m5723a(zznVar.f20683j).m5570h(C4004d.m5563b(zznVar.f20682F)).m5568d());
                }
                if (C3630da.m4644b() && this.f10906k.m5939a().m5533v(zznVar.f20683j, C4142p.f11080j0)) {
                    if (TextUtils.isEmpty(aVarM4690u0.m4809s0()) && !TextUtils.isEmpty(zznVar.f20681E)) {
                        aVarM4690u0.m4813u0(zznVar.f20681E);
                    }
                    if (TextUtils.isEmpty(aVarM4690u0.m4809s0()) && TextUtils.isEmpty(aVarM4690u0.m4819x0()) && !TextUtils.isEmpty(zznVar.f20677A)) {
                        aVarM4690u0.m4807r0(zznVar.f20677A);
                    }
                } else if (TextUtils.isEmpty(aVarM4690u0.m4809s0()) && !TextUtils.isEmpty(zznVar.f20677A)) {
                    aVarM4690u0.m4807r0(zznVar.f20677A);
                }
                long j3 = zznVar.f20688o;
                if (j3 != 0) {
                    aVarM4690u0.m4791d0(j3);
                }
                aVarM4690u0.m4799l0(zznVar.f20679C);
                List<Integer> listM5841U = m5713N().m5841U();
                if (listM5841U != null) {
                    aVarM4690u0.m4774M(listM5841U);
                }
                C4004d c4004dM5570h = m5723a(zznVar.f20683j).m5570h(C4004d.m5563b(zznVar.f20682F));
                if (!C3842t8.m5293b() || !this.f10906k.m5939a().m5526o(C4142p.f11039J0) || c4004dM5570h.m5571j()) {
                    Pair<String, Boolean> pairM5815s = this.f10905j.m5815s(zznVar.f20683j, c4004dM5570h);
                    if (TextUtils.isEmpty((CharSequence) pairM5815s.first)) {
                        if (!this.f10906k.m5954y().m5688s(this.f10906k.mo5729j()) && zznVar.f20698y && (!C3687hb.m4938b() || !this.f10906k.m5939a().m5533v(zznVar.f20683j, C4142p.f11033G0))) {
                            String string = Settings.Secure.getString(this.f10906k.mo5729j().getContentResolver(), "android_id");
                            if (string == null) {
                                this.f10906k.mo5726g().m5792A().m5861b("null secure ID. appId", C4157q3.m5788s(aVarM4690u0.m4798k0()));
                                string = "null";
                            } else if (string.isEmpty()) {
                                this.f10906k.mo5726g().m5792A().m5861b("empty secure ID. appId", C4157q3.m5788s(aVarM4690u0.m4798k0()));
                            }
                            aVarM4690u0.m4802o0(string);
                        }
                    } else if (zznVar.f20697x) {
                        aVarM4690u0.m4792e0((String) pairM5815s.first);
                        Object obj2 = pairM5815s.second;
                        if (obj2 != null) {
                            aVarM4690u0.m4820y(((Boolean) obj2).booleanValue());
                        }
                    }
                }
                this.f10906k.m5954y().m5857o();
                aVarM4690u0.m4772J(Build.MODEL);
                this.f10906k.m5954y().m5857o();
                aVarM4690u0.m4767E(Build.VERSION.RELEASE);
                aVarM4690u0.m4783V((int) this.f10906k.m5954y().m5689t());
                aVarM4690u0.m4775N(this.f10906k.m5954y().m5690u());
                if (!this.f10906k.m5939a().m5526o(C4142p.f11110y0)) {
                    aVarM4690u0.m4796i0(zznVar.f20694u);
                }
                if (this.f10906k.m5940d()) {
                    if (C3842t8.m5293b() && this.f10906k.m5939a().m5526o(C4142p.f11039J0)) {
                        aVarM4690u0.m4798k0();
                    } else {
                        aVarM4690u0.m4798k0();
                    }
                    if (!TextUtils.isEmpty(null)) {
                        aVarM4690u0.m4805q0();
                        throw null;
                    }
                }
                C3973a4 c3973a4M5622T2 = m5710K().m5622T(zznVar.f20683j);
                if (c3973a4M5622T2 == null) {
                    c3973a4M5622T2 = new C3973a4(this.f10906k, zznVar.f20683j);
                    if (C3842t8.m5293b() && this.f10906k.m5939a().m5526o(C4142p.f11039J0)) {
                        c3973a4M5622T2.m5473c(m5724c(c4004dM5570h));
                    } else {
                        c3973a4M5622T2.m5473c(m5722W());
                    }
                    c3973a4M5622T2.m5447A(zznVar.f20693t);
                    c3973a4M5622T2.m5483m(zznVar.f20684k);
                    if (!C3842t8.m5293b() || !this.f10906k.m5939a().m5526o(C4142p.f11039J0) || c4004dM5570h.m5571j()) {
                        c3973a4M5622T2.m5494x(this.f10905j.m5816t(zznVar.f20683j));
                    }
                    c3973a4M5622T2.m5449C(0L);
                    c3973a4M5622T2.m5471a(0L);
                    c3973a4M5622T2.m5482l(0L);
                    c3973a4M5622T2.m5450D(zznVar.f20685l);
                    c3973a4M5622T2.m5486p(zznVar.f20692s);
                    c3973a4M5622T2.m5453G(zznVar.f20686m);
                    c3973a4M5622T2.m5490t(zznVar.f20687n);
                    c3973a4M5622T2.m5493w(zznVar.f20688o);
                    c3973a4M5622T2.m5475e(zznVar.f20690q);
                    if (!this.f10906k.m5939a().m5526o(C4142p.f11110y0)) {
                        c3973a4M5622T2.m5464R(zznVar.f20694u);
                    }
                    c3973a4M5622T2.m5496z(zznVar.f20679C);
                    m5710K().m5611I(c3973a4M5622T2);
                }
                if ((!C3842t8.m5293b() || !this.f10906k.m5939a().m5526o(C4142p.f11039J0) || c4004dM5570h.m5572k()) && !TextUtils.isEmpty(c3973a4M5622T2.m5489s())) {
                    aVarM4690u0.m4795h0(c3973a4M5622T2.m5489s());
                }
                if (!TextUtils.isEmpty(c3973a4M5622T2.m5454H())) {
                    aVarM4690u0.m4801n0(c3973a4M5622T2.m5454H());
                }
                List<C4207u9> listM5606C = m5710K().m5606C(zznVar.f20683j);
                for (int i2 = 0; i2 < listM5606C.size(); i2++) {
                    C3691i1.a aVarM4943L = C3691i1.m4943L();
                    aVarM4943L.m4959r(listM5606C.get(i2).f11292c);
                    aVarM4943L.m4958q(listM5606C.get(i2).f11293d);
                    m5713N().m5835G(aVarM4943L, listM5606C.get(i2).f11294e);
                    aVarM4690u0.m4812u(aVarM4943L);
                }
                try {
                    long jM5642v = m5710K().m5642v((C3635e1) ((AbstractC3851u4) aVarM4690u0.m5320p()));
                    C4040g c4040gM5710K2 = m5710K();
                    zzap zzapVar = c4109m.f10957f;
                    if (zzapVar != null) {
                        Iterator<String> it = zzapVar.iterator();
                        while (true) {
                            C4120n c4120n = (C4120n) it;
                            if (c4120n.hasNext()) {
                                if ("_r".equals((String) c4120n.next())) {
                                    break;
                                }
                            } else {
                                boolean zM5783y = m5707H().m5783y(c4109m.f10952a, c4109m.f10953b);
                                C4028f c4028fM5645y = m5710K().m5645y(m5721V(), c4109m.f10952a, false, false);
                                if (!zM5783y || c4028fM5645y.f10708e >= this.f10906k.m5939a().m5530s(c4109m.f10952a)) {
                                }
                                if (c4040gM5710K2.m5614L(c4109m, jM5642v, z2)) {
                                    this.f10909n = 0L;
                                }
                            }
                        }
                        z2 = true;
                        if (c4040gM5710K2.m5614L(c4109m, jM5642v, z2)) {
                        }
                    } else {
                        z2 = false;
                        if (c4040gM5710K2.m5614L(c4109m, jM5642v, z2)) {
                        }
                    }
                } catch (IOException e2) {
                    this.f10906k.mo5726g().m5801z().m5862c("Data loss. Failed to insert raw event metadata. appId", C4157q3.m5788s(aVarM4690u0.m4798k0()), e2);
                }
                m5710K().m5639s();
                m5710K().m5633e0();
                m5742w();
                this.f10906k.mo5726g().m5795D().m5861b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    /* renamed from: J */
    public final C4234x3 m5709J() {
        m5697C(this.f10898c);
        return this.f10898c;
    }

    /* renamed from: K */
    public final C4040g m5710K() {
        m5697C(this.f10899d);
        return this.f10899d;
    }

    /* renamed from: L */
    public final boolean m5711L(zzn zznVar) {
        return (C3630da.m4644b() && this.f10906k.f11260h.m5532u(zznVar.f20683j, C4142p.f11080j0)) ? (TextUtils.isEmpty(zznVar.f20684k) && TextUtils.isEmpty(zznVar.f20681E) && TextUtils.isEmpty(zznVar.f20677A)) ? false : true : (TextUtils.isEmpty(zznVar.f20684k) && TextUtils.isEmpty(zznVar.f20677A)) ? false : true;
    }

    /* renamed from: M */
    public final C3991ba m5712M() {
        m5697C(this.f10902g);
        return this.f10902g;
    }

    /* renamed from: N */
    public final C4163q9 m5713N() {
        m5697C(this.f10903h);
        return this.f10903h;
    }

    /* renamed from: O */
    public final C4135o3 m5714O() {
        return this.f10906k.m5950u();
    }

    /* renamed from: P */
    public final void m5715P() {
        if (!this.f10907l) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    /* renamed from: Q */
    public final void m5716Q() throws IllegalStateException {
        C3973a4 c3973a4M5622T;
        String strM4715J;
        m5720U();
        m5715P();
        this.f10915t = true;
        try {
            Boolean bool = this.f10906k.m5953x().f11155e;
            if (bool == null) {
                this.f10906k.mo5726g().f11144i.m5860a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (bool.booleanValue()) {
                this.f10906k.mo5726g().f11141f.m5860a("Upload called in the client side when service should be used");
                return;
            }
            if (this.f10909n > 0) {
                m5742w();
                return;
            }
            m5720U();
            if (this.f10918w != null) {
                this.f10906k.mo5726g().f11149n.m5860a("Uploading requested multiple times");
                return;
            }
            if (!m5709J().m5963u()) {
                this.f10906k.mo5726g().f11149n.m5860a("Network not connected, ignoring upload request");
                m5742w();
                return;
            }
            Objects.requireNonNull((C3401c) this.f10906k.f11267o);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iM5528q = this.f10906k.f11260h.m5528q(null, C4142p.f11051Q);
            long jLongValue = jCurrentTimeMillis - C4142p.f11067d.m5693a(null).longValue();
            for (int i = 0; i < iM5528q && m5739t(jLongValue); i++) {
            }
            long jM5648a = this.f10906k.m5946o().f10636f.m5648a();
            if (jM5648a != 0) {
                this.f10906k.mo5726g().f11148m.m5861b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jM5648a)));
            }
            String strM5641u = m5710K().m5641u();
            if (TextUtils.isEmpty(strM5641u)) {
                this.f10920y = -1L;
                String strM5605B = m5710K().m5605B(jCurrentTimeMillis - C4142p.f11067d.m5693a(null).longValue());
                if (!TextUtils.isEmpty(strM5605B) && (c3973a4M5622T = m5710K().m5622T(strM5605B)) != null) {
                    m5733n(c3973a4M5622T);
                }
            } else {
                if (this.f10920y == -1) {
                    this.f10920y = m5710K().m5638j0();
                }
                List<Pair<C3635e1, Long>> listM5607D = m5710K().m5607D(strM5641u, this.f10906k.f11260h.m5528q(strM5641u, C4142p.f11073g), Math.max(0, this.f10906k.f11260h.m5528q(strM5641u, C4142p.f11075h)));
                if (!listM5607D.isEmpty()) {
                    if (!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0) || m5723a(strM5641u).m5571j()) {
                        Iterator<Pair<C3635e1, Long>> it = listM5607D.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                strM4715J = null;
                                break;
                            }
                            C3635e1 c3635e1 = (C3635e1) it.next().first;
                            if (!TextUtils.isEmpty(c3635e1.m4715J())) {
                                strM4715J = c3635e1.m4715J();
                                break;
                            }
                        }
                        if (strM4715J != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= listM5607D.size()) {
                                    break;
                                }
                                C3635e1 c3635e12 = (C3635e1) listM5607D.get(i2).first;
                                if (!TextUtils.isEmpty(c3635e12.m4715J()) && !c3635e12.m4715J().equals(strM4715J)) {
                                    listM5607D = listM5607D.subList(0, i2);
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    C3621d1.a aVarM4623x = C3621d1.m4623x();
                    int size = listM5607D.size();
                    ArrayList arrayList = new ArrayList(listM5607D.size());
                    boolean z2 = "1".equals(this.f10906k.f11260h.f10580c.mo5500h(strM5641u, "gaia_collection_enabled")) && !(C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && !m5723a(strM5641u).m5571j());
                    boolean z3 = (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && !m5723a(strM5641u).m5571j()) ? false : true;
                    boolean z4 = (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && !m5723a(strM5641u).m5572k()) ? false : true;
                    int i3 = 0;
                    while (i3 < size) {
                        C3635e1.a aVarM5315t = ((C3635e1) listM5607D.get(i3).first).m5315t();
                        arrayList.add((Long) listM5607D.get(i3).second);
                        ArrayList arrayList2 = arrayList;
                        if (aVarM5315t.f10348l) {
                            aVarM5315t.m5318n();
                            aVarM5315t.f10348l = false;
                        }
                        C3635e1.m4669W0((C3635e1) aVarM5315t.f10347k, 33025L);
                        if (aVarM5315t.f10348l) {
                            aVarM5315t.m5318n();
                            aVarM5315t.f10348l = false;
                        }
                        C3635e1.m4697y((C3635e1) aVarM5315t.f10347k, jCurrentTimeMillis);
                        if (aVarM5315t.f10348l) {
                            aVarM5315t.m5318n();
                            aVarM5315t.f10348l = false;
                        }
                        C3635e1.m4685m0((C3635e1) aVarM5315t.f10347k, false);
                        if (!z2) {
                            if (aVarM5315t.f10348l) {
                                aVarM5315t.m5318n();
                                aVarM5315t.f10348l = false;
                            }
                            C3635e1.m4678i1((C3635e1) aVarM5315t.f10347k);
                        }
                        if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
                            if (!z3) {
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3635e1.m4653F0((C3635e1) aVarM5315t.f10347k);
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3635e1.m4659L0((C3635e1) aVarM5315t.f10347k);
                            }
                            if (!z4) {
                                if (aVarM5315t.f10348l) {
                                    aVarM5315t.m5318n();
                                    aVarM5315t.f10348l = false;
                                }
                                C3635e1.m4663Q0((C3635e1) aVarM5315t.f10347k);
                            }
                        }
                        if (this.f10906k.f11260h.m5532u(strM5641u, C4142p.f11058X)) {
                            long jM5842t = m5713N().m5842t(((C3635e1) ((AbstractC3851u4) aVarM5315t.m5320p())).m5052d());
                            if (aVarM5315t.f10348l) {
                                aVarM5315t.m5318n();
                                aVarM5315t.f10348l = false;
                            }
                            C3635e1.m4687p1((C3635e1) aVarM5315t.f10347k, jM5842t);
                        }
                        aVarM4623x.m4627q(aVarM5315t);
                        i3++;
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = arrayList;
                    String strM5846z = this.f10906k.mo5726g().m5800x(2) ? m5713N().m5846z((C3621d1) ((AbstractC3851u4) aVarM4623x.m5320p())) : null;
                    m5713N();
                    byte[] bArrM5052d = ((C3621d1) ((AbstractC3851u4) aVarM4623x.m5320p())).m5052d();
                    String strM5693a = C4142p.f11093q.m5693a(null);
                    try {
                        URL url = new URL(strM5693a);
                        AnimatableValueParser.m539l(!arrayList3.isEmpty());
                        if (this.f10918w != null) {
                            this.f10906k.mo5726g().f11141f.m5860a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.f10918w = new ArrayList(arrayList3);
                        }
                        this.f10906k.m5946o().f10637g.m5649b(jCurrentTimeMillis);
                        this.f10906k.mo5726g().f11149n.m5863d("Uploading data. app, uncompressed size, data", size > 0 ? ((C3621d1) aVarM4623x.f10347k).m4625u().m4710G1() : "?", Integer.valueOf(bArrM5052d.length), strM5846z);
                        this.f10914s = true;
                        C4234x3 c4234x3M5709J = m5709J();
                        C4119m9 c4119m9 = new C4119m9(this, strM5641u);
                        c4234x3M5709J.mo5848b();
                        c4234x3M5709J.m5684n();
                        c4234x3M5709J.mo5725f().m5854x(new RunnableC3997c4(c4234x3M5709J, strM5641u, url, bArrM5052d, null, c4119m9));
                    } catch (MalformedURLException unused) {
                        this.f10906k.mo5726g().f11141f.m5862c("Failed to parse upload URL. Not uploading. appId", C4157q3.m5788s(strM5641u), strM5693a);
                    }
                }
            }
        } finally {
            this.f10915t = false;
            m5743x();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @WorkerThread
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5717R() {
        boolean z2;
        FileLock fileLockTryLock;
        int i;
        int i2;
        int i3;
        FileLock fileLock;
        m5720U();
        m5715P();
        if (this.f10908m) {
            return;
        }
        boolean z3 = true;
        this.f10908m = true;
        m5720U();
        if (this.f10906k.f11260h.m5526o(C4142p.f11078i0) && (fileLock = this.f10916u) != null && fileLock.isValid()) {
            this.f10906k.mo5726g().f11149n.m5860a("Storage concurrent access okay");
        } else {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.f10906k.f11254b.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.f10917v = channel;
                fileLockTryLock = channel.tryLock();
                this.f10916u = fileLockTryLock;
            } catch (FileNotFoundException e) {
                this.f10906k.mo5726g().f11141f.m5861b("Failed to acquire storage lock", e);
            } catch (IOException e2) {
                this.f10906k.mo5726g().f11141f.m5861b("Failed to access storage lock file", e2);
            } catch (OverlappingFileLockException e3) {
                this.f10906k.mo5726g().f11144i.m5861b("Storage lock already acquired", e3);
            }
            if (fileLockTryLock != null) {
                this.f10906k.mo5726g().f11149n.m5860a("Storage concurrent access okay");
            } else {
                this.f10906k.mo5726g().f11141f.m5860a("Storage concurrent data access panic");
                z2 = false;
                if (z2) {
                    return;
                }
                FileChannel fileChannel = this.f10917v;
                m5720U();
                if (fileChannel == null || !fileChannel.isOpen()) {
                    this.f10906k.mo5726g().f11141f.m5860a("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0L);
                        i3 = fileChannel.read(byteBufferAllocate);
                    } catch (IOException e4) {
                        this.f10906k.mo5726g().f11141f.m5861b("Failed to read from channel", e4);
                    }
                    if (i3 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                        C4124n3 c4124n3M5955z = this.f10906k.m5955z();
                        c4124n3M5955z.m5497t();
                        i2 = c4124n3M5955z.f10981e;
                        m5720U();
                        if (i <= i2) {
                            this.f10906k.mo5726g().f11141f.m5862c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                            return;
                        }
                        if (i >= i2) {
                            return;
                        }
                        FileChannel fileChannel2 = this.f10917v;
                        m5720U();
                        if (fileChannel2 != null && fileChannel2.isOpen()) {
                            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                            byteBufferAllocate2.putInt(i2);
                            byteBufferAllocate2.flip();
                            try {
                                fileChannel2.truncate(0L);
                                this.f10906k.f11260h.m5526o(C4142p.f11098s0);
                                fileChannel2.write(byteBufferAllocate2);
                                fileChannel2.force(true);
                                if (fileChannel2.size() != 4) {
                                    this.f10906k.mo5726g().f11141f.m5861b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                                }
                            } catch (IOException e5) {
                                this.f10906k.mo5726g().f11141f.m5861b("Failed to write to channel", e5);
                            }
                            if (z3) {
                                this.f10906k.mo5726g().f11141f.m5862c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                return;
                            } else {
                                this.f10906k.mo5726g().f11149n.m5862c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                return;
                            }
                        }
                        this.f10906k.mo5726g().f11141f.m5860a("Bad channel to read from");
                        z3 = false;
                        if (z3) {
                        }
                    } else if (i3 != -1) {
                        this.f10906k.mo5726g().f11144i.m5861b("Unexpected data length. Bytes read", Integer.valueOf(i3));
                    }
                }
                i = 0;
                C4124n3 c4124n3M5955z2 = this.f10906k.m5955z();
                c4124n3M5955z2.m5497t();
                i2 = c4124n3M5955z2.f10981e;
                m5720U();
                if (i <= i2) {
                }
            }
        }
        z2 = true;
        if (z2) {
        }
    }

    /* renamed from: S */
    public final C3985b4 m5718S() {
        C3985b4 c3985b4 = this.f10900e;
        if (c3985b4 != null) {
            return c3985b4;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    /* renamed from: T */
    public final C4062h9 m5719T() {
        m5697C(this.f10901f);
        return this.f10901f;
    }

    @WorkerThread
    /* renamed from: U */
    public final void m5720U() {
        this.f10906k.mo5725f().mo5848b();
    }

    /* renamed from: V */
    public final long m5721V() {
        Objects.requireNonNull((C3401c) this.f10906k.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C4009d4 c4009d4M5946o = this.f10906k.m5946o();
        c4009d4M5946o.m5857o();
        c4009d4M5946o.mo5848b();
        long jM5648a = c4009d4M5946o.f10640j.m5648a();
        if (jM5648a == 0) {
            jM5648a = 1 + c4009d4M5946o.m5866e().m5924v0().nextInt(86400000);
            c4009d4M5946o.f10640j.m5649b(jM5648a);
        }
        return ((((jCurrentTimeMillis + jM5648a) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    @Deprecated
    /* renamed from: W */
    public final String m5722W() {
        byte[] bArr = new byte[16];
        this.f10906k.m5949t().m5924v0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @WorkerThread
    /* renamed from: a */
    public final C4004d m5723a(String str) {
        String string;
        C4004d c4004d = C4004d.f10622a;
        if (!C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
            return c4004d;
        }
        m5720U();
        m5715P();
        C4004d c4004d2 = this.f10921z.get(str);
        if (c4004d2 != null) {
            return c4004d2;
        }
        C4040g c4040gM5710K = m5710K();
        Objects.requireNonNull(c4040gM5710K);
        Objects.requireNonNull(str, "null reference");
        c4040gM5710K.mo5848b();
        c4040gM5710K.m5684n();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c4040gM5710K.m5640t().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                C4004d c4004dM5563b = C4004d.m5563b(string);
                m5738s(str, c4004dM5563b);
                return c4004dM5563b;
            } catch (SQLiteException e) {
                c4040gM5710K.mo5726g().f11141f.m5862c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    /* renamed from: c */
    public final String m5724c(C4004d c4004d) {
        if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0) && !c4004d.m5572k()) {
            return null;
        }
        return m5722W();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* renamed from: f */
    public final C4169r4 mo5725f() {
        return this.f10906k.mo5725f();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* renamed from: g */
    public final C4157q3 mo5726g() {
        return this.f10906k.mo5726g();
    }

    /* renamed from: h */
    public final void m5727h(C3635e1.a aVar, long j, boolean z2) {
        C4207u9 c4207u9;
        boolean z3;
        String str = z2 ? "_se" : "_lte";
        C4207u9 c4207u9M5627Y = m5710K().m5627Y(aVar.m4798k0(), str);
        if (c4207u9M5627Y == null || c4207u9M5627Y.f11294e == null) {
            String strM4798k0 = aVar.m4798k0();
            Objects.requireNonNull((C3401c) this.f10906k.f11267o);
            c4207u9 = new C4207u9(strM4798k0, "auto", str, System.currentTimeMillis(), Long.valueOf(j));
        } else {
            String strM4798k02 = aVar.m4798k0();
            Objects.requireNonNull((C3401c) this.f10906k.f11267o);
            c4207u9 = new C4207u9(strM4798k02, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) c4207u9M5627Y.f11294e).longValue() + j));
        }
        C3691i1.a aVarM4943L = C3691i1.m4943L();
        aVarM4943L.m4959r(str);
        Objects.requireNonNull((C3401c) this.f10906k.f11267o);
        aVarM4943L.m4958q(System.currentTimeMillis());
        aVarM4943L.m4960s(((Long) c4207u9.f11294e).longValue());
        C3691i1 c3691i1 = (C3691i1) ((AbstractC3851u4) aVarM4943L.m5320p());
        int iM5830s = C4163q9.m5830s(aVar, str);
        if (iM5830s >= 0) {
            if (aVar.f10348l) {
                aVar.m5318n();
                aVar.f10348l = false;
            }
            C3635e1.m4695x((C3635e1) aVar.f10347k, iM5830s, c3691i1);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (aVar.f10348l) {
                aVar.m5318n();
                aVar.f10348l = false;
            }
            C3635e1.m4645A((C3635e1) aVar.f10347k, c3691i1);
        }
        if (j > 0) {
            m5710K().m5615M(c4207u9);
            this.f10906k.mo5726g().f11149n.m5862c("Updated engagement user property. scope, value", z2 ? "session-scoped" : "lifetime", c4207u9.f11294e);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* renamed from: i */
    public final InterfaceC3400b mo5728i() {
        return this.f10906k.f11267o;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* renamed from: j */
    public final Context mo5729j() {
        return this.f10906k.f11254b;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* renamed from: k */
    public final C4051ga mo5730k() {
        return this.f10906k.f11259g;
    }

    @WorkerThread
    /* renamed from: l */
    public final void m5731l(zzaq zzaqVar, zzn zznVar) throws IllegalStateException {
        List<zzz> listM5609F;
        List<zzz> listM5609F2;
        List<zzz> listM5609F3;
        zzaq zzaqVar2 = zzaqVar;
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.m583w(zznVar.f20683j);
        m5720U();
        m5715P();
        String str = zznVar.f20683j;
        long j = zzaqVar2.f20669m;
        m5713N();
        if (C4163q9.m5826O(zzaqVar, zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            List<String> list = zznVar.f20680D;
            if (list != null) {
                if (!list.contains(zzaqVar2.f20666j)) {
                    this.f10906k.mo5726g().f11148m.m5863d("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.f20666j, zzaqVar2.f20668l);
                    return;
                } else {
                    Bundle bundleM9114x0 = zzaqVar2.f20667k.m9114x0();
                    bundleM9114x0.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.f20666j, new zzap(bundleM9114x0), zzaqVar2.f20668l, zzaqVar2.f20669m);
                }
            }
            m5710K().m5630b0();
            try {
                C4040g c4040gM5710K = m5710K();
                AnimatableValueParser.m583w(str);
                c4040gM5710K.mo5848b();
                c4040gM5710K.m5684n();
                if (j < 0) {
                    c4040gM5710K.mo5726g().f11144i.m5862c("Invalid time querying timed out conditional properties", C4157q3.m5788s(str), Long.valueOf(j));
                    listM5609F = Collections.emptyList();
                } else {
                    listM5609F = c4040gM5710K.m5609F("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzzVar : listM5609F) {
                    if (zzzVar != null) {
                        this.f10906k.mo5726g().f11149n.m5863d("User property timed out", zzzVar.f20700j, this.f10906k.m5950u().m5769y(zzzVar.f20702l.f20671k), zzzVar.f20702l.m9117w0());
                        zzaq zzaqVar3 = zzzVar.f20706p;
                        if (zzaqVar3 != null) {
                            m5708I(new zzaq(zzaqVar3, j), zznVar);
                        }
                        m5710K().m5629a0(str, zzzVar.f20702l.f20671k);
                    }
                }
                C4040g c4040gM5710K2 = m5710K();
                AnimatableValueParser.m583w(str);
                c4040gM5710K2.mo5848b();
                c4040gM5710K2.m5684n();
                if (j < 0) {
                    c4040gM5710K2.mo5726g().f11144i.m5862c("Invalid time querying expired conditional properties", C4157q3.m5788s(str), Long.valueOf(j));
                    listM5609F2 = Collections.emptyList();
                } else {
                    listM5609F2 = c4040gM5710K2.m5609F("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listM5609F2.size());
                for (zzz zzzVar2 : listM5609F2) {
                    if (zzzVar2 != null) {
                        this.f10906k.mo5726g().f11149n.m5863d("User property expired", zzzVar2.f20700j, this.f10906k.m5950u().m5769y(zzzVar2.f20702l.f20671k), zzzVar2.f20702l.m9117w0());
                        m5710K().m5624V(str, zzzVar2.f20702l.f20671k);
                        zzaq zzaqVar4 = zzzVar2.f20710t;
                        if (zzaqVar4 != null) {
                            arrayList.add(zzaqVar4);
                        }
                        m5710K().m5629a0(str, zzzVar2.f20702l.f20671k);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    m5708I(new zzaq((zzaq) obj, j), zznVar);
                }
                C4040g c4040gM5710K3 = m5710K();
                String str2 = zzaqVar2.f20666j;
                AnimatableValueParser.m583w(str);
                AnimatableValueParser.m583w(str2);
                c4040gM5710K3.mo5848b();
                c4040gM5710K3.m5684n();
                if (j < 0) {
                    c4040gM5710K3.mo5726g().f11144i.m5863d("Invalid time querying triggered conditional properties", C4157q3.m5788s(str), c4040gM5710K3.m5865d().m5766u(str2), Long.valueOf(j));
                    listM5609F3 = Collections.emptyList();
                } else {
                    listM5609F3 = c4040gM5710K3.m5609F("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listM5609F3.size());
                for (zzz zzzVar3 : listM5609F3) {
                    if (zzzVar3 != null) {
                        zzku zzkuVar = zzzVar3.f20702l;
                        C4207u9 c4207u9 = new C4207u9(zzzVar3.f20700j, zzzVar3.f20701k, zzkuVar.f20671k, j, zzkuVar.m9117w0());
                        if (m5710K().m5615M(c4207u9)) {
                            this.f10906k.mo5726g().f11149n.m5863d("User property triggered", zzzVar3.f20700j, this.f10906k.m5950u().m5769y(c4207u9.f11292c), c4207u9.f11294e);
                        } else {
                            this.f10906k.mo5726g().f11141f.m5863d("Too many active user properties, ignoring", C4157q3.m5788s(zzzVar3.f20700j), this.f10906k.m5950u().m5769y(c4207u9.f11292c), c4207u9.f11294e);
                        }
                        zzaq zzaqVar5 = zzzVar3.f20708r;
                        if (zzaqVar5 != null) {
                            arrayList2.add(zzaqVar5);
                        }
                        zzzVar3.f20702l = new zzku(c4207u9);
                        zzzVar3.f20704n = true;
                        m5710K().m5616N(zzzVar3);
                    }
                }
                m5708I(zzaqVar2, zznVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    m5708I(new zzaq((zzaq) obj2, j), zznVar);
                }
                m5710K().m5639s();
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
    @WorkerThread
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5732m(zzaq zzaqVar, String str) throws IllegalStateException {
        boolean z2;
        C3973a4 c3973a4M5622T = m5710K().m5622T(str);
        if (c3973a4M5622T == null || TextUtils.isEmpty(c3973a4M5622T.m5459M())) {
            this.f10906k.mo5726g().f11148m.m5861b("No app data available; dropping event", str);
            return;
        }
        Boolean boolM5745z = m5745z(c3973a4M5622T);
        if (boolM5745z == null) {
            if (!"_ui".equals(zzaqVar.f20666j)) {
                this.f10906k.mo5726g().f11144i.m5861b("Could not find package. appId", C4157q3.m5788s(str));
            }
        } else if (!boolM5745z.booleanValue()) {
            this.f10906k.mo5726g().f11141f.m5861b("App version does not match; dropping event. appId", C4157q3.m5788s(str));
            return;
        }
        String strM5492v = c3973a4M5622T.m5492v();
        String strM5459M = c3973a4M5622T.m5459M();
        long jM5460N = c3973a4M5622T.m5460N();
        String strM5461O = c3973a4M5622T.m5461O();
        long jM5462P = c3973a4M5622T.m5462P();
        long jM5463Q = c3973a4M5622T.m5463Q();
        boolean zM5466T = c3973a4M5622T.m5466T();
        String strM5454H = c3973a4M5622T.m5454H();
        long jM5477g = c3973a4M5622T.m5477g();
        boolean zM5478h = c3973a4M5622T.m5478h();
        boolean zM5479i = c3973a4M5622T.m5479i();
        String strM5495y = c3973a4M5622T.m5495y();
        Boolean boolM5480j = c3973a4M5622T.m5480j();
        long jM5465S = c3973a4M5622T.m5465S();
        List<String> listM5481k = c3973a4M5622T.m5481k();
        if (C3630da.m4644b()) {
            z2 = zM5466T;
            String strM5448B = this.f10906k.f11260h.m5532u(c3973a4M5622T.m5485o(), C4142p.f11080j0) ? c3973a4M5622T.m5448B() : null;
            m5702B(zzaqVar, new zzn(str, strM5492v, strM5459M, jM5460N, strM5461O, jM5462P, jM5463Q, (String) null, z2, false, strM5454H, jM5477g, 0L, 0, zM5478h, zM5479i, false, strM5495y, boolM5480j, jM5465S, listM5481k, strM5448B, (C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0)) ? "" : m5723a(str).m5568d()));
        }
        z2 = zM5466T;
        m5702B(zzaqVar, new zzn(str, strM5492v, strM5459M, jM5460N, strM5461O, jM5462P, jM5463Q, (String) null, z2, false, strM5454H, jM5477g, 0L, 0, zM5478h, zM5479i, false, strM5495y, boolM5480j, jM5465S, listM5481k, strM5448B, (C3842t8.m5293b() || !this.f10906k.f11260h.m5526o(C4142p.f11039J0)) ? "" : m5723a(str).m5568d()));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    @WorkerThread
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5733n(C3973a4 c3973a4) throws IllegalStateException {
        m5720U();
        if (C3630da.m4644b() && this.f10906k.f11260h.m5532u(c3973a4.m5485o(), C4142p.f11080j0)) {
            if (TextUtils.isEmpty(c3973a4.m5492v()) && TextUtils.isEmpty(c3973a4.m5448B()) && TextUtils.isEmpty(c3973a4.m5495y())) {
                m5737r(c3973a4.m5485o(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(c3973a4.m5492v()) && TextUtils.isEmpty(c3973a4.m5495y())) {
            m5737r(c3973a4.m5485o(), 204, null, null, null);
            return;
        }
        C3992c c3992c = this.f10906k.f11260h;
        Objects.requireNonNull(c3992c);
        Uri.Builder builder = new Uri.Builder();
        String strM5492v = c3973a4.m5492v();
        if (TextUtils.isEmpty(strM5492v)) {
            if (C3630da.m4644b() && c3992c.f11202a.f11260h.m5532u(c3973a4.m5485o(), C4142p.f11080j0)) {
                strM5492v = c3973a4.m5448B();
                if (TextUtils.isEmpty(strM5492v)) {
                }
            } else {
                strM5492v = c3973a4.m5495y();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder builderEncodedAuthority = builder.scheme(C4142p.f11069e.m5693a(null)).encodedAuthority(C4142p.f11071f.m5693a(null));
        String strValueOf = String.valueOf(strM5492v);
        builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", c3973a4.m5489s()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "33025");
        String string = builder.build().toString();
        try {
            URL url = new URL(string);
            this.f10906k.mo5726g().f11149n.m5861b("Fetching remote configuration", c3973a4.m5485o());
            C3847u0 c3847u0M5778s = m5707H().m5778s(c3973a4.m5485o());
            C4147p4 c4147p4M5707H = m5707H();
            String strM5485o = c3973a4.m5485o();
            c4147p4M5707H.mo5848b();
            String str = c4147p4M5707H.f11122i.get(strM5485o);
            if (c3847u0M5778s != null && !TextUtils.isEmpty(str)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", str);
            }
            this.f10913r = true;
            C4234x3 c4234x3M5709J = m5709J();
            String strM5485o2 = c3973a4.m5485o();
            C4108l9 c4108l9 = new C4108l9(this);
            c4234x3M5709J.mo5848b();
            c4234x3M5709J.m5684n();
            c4234x3M5709J.mo5725f().m5854x(new RunnableC3997c4(c4234x3M5709J, strM5485o2, url, null, arrayMap, c4108l9));
        } catch (MalformedURLException unused) {
            this.f10906k.mo5726g().f11141f.m5862c("Failed to parse config URL. Not fetching. appId", C4157q3.m5788s(c3973a4.m5485o()), string);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    @WorkerThread
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5734o(zzku zzkuVar, zzn zznVar) {
        m5720U();
        m5715P();
        if (m5711L(zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            int iM5913h0 = this.f10906k.m5949t().m5913h0(zzkuVar.f20671k);
            if (iM5913h0 != 0) {
                this.f10906k.m5949t();
                String strM5872E = C4196t9.m5872E(zzkuVar.f20671k, 24, true);
                String str = zzkuVar.f20671k;
                this.f10906k.m5949t().m5905S(this.f10896A, zznVar.f20683j, iM5913h0, "_ev", strM5872E, str != null ? str.length() : 0);
                return;
            }
            int iM5914i0 = this.f10906k.m5949t().m5914i0(zzkuVar.f20671k, zzkuVar.m9117w0());
            if (iM5914i0 != 0) {
                this.f10906k.m5949t();
                String strM5872E2 = C4196t9.m5872E(zzkuVar.f20671k, 24, true);
                Object objM9117w0 = zzkuVar.m9117w0();
                this.f10906k.m5949t().m5905S(this.f10896A, zznVar.f20683j, iM5914i0, "_ev", strM5872E2, (objM9117w0 == null || !((objM9117w0 instanceof String) || (objM9117w0 instanceof CharSequence))) ? 0 : String.valueOf(objM9117w0).length());
                return;
            }
            Object objM5916n0 = this.f10906k.m5949t().m5916n0(zzkuVar.f20671k, zzkuVar.m9117w0());
            if (objM5916n0 == null) {
                return;
            }
            if ("_sid".equals(zzkuVar.f20671k)) {
                long j = zzkuVar.f20672l;
                String str2 = zzkuVar.f20675o;
                long jLongValue = 0;
                C4207u9 c4207u9M5627Y = m5710K().m5627Y(zznVar.f20683j, "_sno");
                if (c4207u9M5627Y != null) {
                    Object obj = c4207u9M5627Y.f11294e;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (c4207u9M5627Y != null) {
                            this.f10906k.mo5726g().f11144i.m5861b("Retrieved last session number from database does not contain a valid (long) value", c4207u9M5627Y.f11294e);
                        }
                        C4098l c4098lM5646z = m5710K().m5646z(zznVar.f20683j, "_s");
                        if (c4098lM5646z != null) {
                            jLongValue = c4098lM5646z.f10928c;
                            this.f10906k.mo5726g().f11149n.m5861b("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        }
                    }
                    m5734o(new zzku("_sno", j, Long.valueOf(jLongValue + 1), str2), zznVar);
                }
            }
            C4207u9 c4207u9 = new C4207u9(zznVar.f20683j, zzkuVar.f20675o, zzkuVar.f20671k, zzkuVar.f20672l, objM5916n0);
            this.f10906k.mo5726g().f11149n.m5862c("Setting user property", this.f10906k.m5950u().m5769y(c4207u9.f11292c), objM5916n0);
            m5710K().m5630b0();
            try {
                m5706G(zznVar);
                boolean zM5615M = m5710K().m5615M(c4207u9);
                m5710K().m5639s();
                if (!zM5615M) {
                    this.f10906k.mo5726g().f11141f.m5862c("Too many unique user properties are set. Ignoring user property", this.f10906k.m5950u().m5769y(c4207u9.f11292c), c4207u9.f11294e);
                    this.f10906k.m5949t().m5905S(this.f10896A, zznVar.f20683j, 9, null, null, 0);
                }
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    @WorkerThread
    /* renamed from: p */
    public final void m5735p(zzn zznVar) {
        if (this.f10918w != null) {
            ArrayList arrayList = new ArrayList();
            this.f10919x = arrayList;
            arrayList.addAll(this.f10918w);
        }
        C4040g c4040gM5710K = m5710K();
        String str = zznVar.f20683j;
        AnimatableValueParser.m583w(str);
        c4040gM5710K.mo5848b();
        c4040gM5710K.m5684n();
        try {
            SQLiteDatabase sQLiteDatabaseM5640t = c4040gM5710K.m5640t();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseM5640t.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseM5640t.delete("events", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("queue", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseM5640t.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                c4040gM5710K.mo5726g().f11149n.m5862c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            c4040gM5710K.mo5726g().f11141f.m5862c("Error resetting analytics data. appId, error", C4157q3.m5788s(str), e);
        }
        if (zznVar.f20690q) {
            m5704E(zznVar);
        }
    }

    @WorkerThread
    /* renamed from: q */
    public final void m5736q(zzz zzzVar, zzn zznVar) {
        zzaq zzaqVar;
        boolean z2;
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.m583w(zzzVar.f20700j);
        Objects.requireNonNull(zzzVar.f20701k, "null reference");
        Objects.requireNonNull(zzzVar.f20702l, "null reference");
        AnimatableValueParser.m583w(zzzVar.f20702l.f20671k);
        m5720U();
        m5715P();
        if (m5711L(zznVar)) {
            if (!zznVar.f20690q) {
                m5706G(zznVar);
                return;
            }
            zzz zzzVar2 = new zzz(zzzVar);
            boolean z3 = false;
            zzzVar2.f20704n = false;
            m5710K().m5630b0();
            try {
                zzz zzzVarM5628Z = m5710K().m5628Z(zzzVar2.f20700j, zzzVar2.f20702l.f20671k);
                if (zzzVarM5628Z != null && !zzzVarM5628Z.f20701k.equals(zzzVar2.f20701k)) {
                    this.f10906k.mo5726g().f11144i.m5863d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f10906k.m5950u().m5769y(zzzVar2.f20702l.f20671k), zzzVar2.f20701k, zzzVarM5628Z.f20701k);
                }
                if (zzzVarM5628Z != null && (z2 = zzzVarM5628Z.f20704n)) {
                    zzzVar2.f20701k = zzzVarM5628Z.f20701k;
                    zzzVar2.f20703m = zzzVarM5628Z.f20703m;
                    zzzVar2.f20707q = zzzVarM5628Z.f20707q;
                    zzzVar2.f20705o = zzzVarM5628Z.f20705o;
                    zzzVar2.f20708r = zzzVarM5628Z.f20708r;
                    zzzVar2.f20704n = z2;
                    zzku zzkuVar = zzzVar2.f20702l;
                    zzzVar2.f20702l = new zzku(zzkuVar.f20671k, zzzVarM5628Z.f20702l.f20672l, zzkuVar.m9117w0(), zzzVarM5628Z.f20702l.f20675o);
                } else if (TextUtils.isEmpty(zzzVar2.f20705o)) {
                    zzku zzkuVar2 = zzzVar2.f20702l;
                    zzzVar2.f20702l = new zzku(zzkuVar2.f20671k, zzzVar2.f20703m, zzkuVar2.m9117w0(), zzzVar2.f20702l.f20675o);
                    zzzVar2.f20704n = true;
                    z3 = true;
                }
                if (zzzVar2.f20704n) {
                    zzku zzkuVar3 = zzzVar2.f20702l;
                    C4207u9 c4207u9 = new C4207u9(zzzVar2.f20700j, zzzVar2.f20701k, zzkuVar3.f20671k, zzkuVar3.f20672l, zzkuVar3.m9117w0());
                    if (m5710K().m5615M(c4207u9)) {
                        this.f10906k.mo5726g().f11148m.m5863d("User property updated immediately", zzzVar2.f20700j, this.f10906k.m5950u().m5769y(c4207u9.f11292c), c4207u9.f11294e);
                    } else {
                        this.f10906k.mo5726g().f11141f.m5863d("(2)Too many active user properties, ignoring", C4157q3.m5788s(zzzVar2.f20700j), this.f10906k.m5950u().m5769y(c4207u9.f11292c), c4207u9.f11294e);
                    }
                    if (z3 && (zzaqVar = zzzVar2.f20708r) != null) {
                        m5708I(new zzaq(zzaqVar, zzzVar2.f20703m), zznVar);
                    }
                }
                if (m5710K().m5616N(zzzVar2)) {
                    this.f10906k.mo5726g().f11148m.m5863d("Conditional property added", zzzVar2.f20700j, this.f10906k.m5950u().m5769y(zzzVar2.f20702l.f20671k), zzzVar2.f20702l.m9117w0());
                } else {
                    this.f10906k.mo5726g().f11141f.m5863d("Too many conditional properties, ignoring", C4157q3.m5788s(zzzVar2.f20700j), this.f10906k.m5950u().m5769y(zzzVar2.f20702l.f20671k), zzzVar2.f20702l.m9117w0());
                }
                m5710K().m5639s();
            } finally {
                m5710K().m5633e0();
            }
        }
    }

    @WorkerThread
    /* renamed from: r */
    public final void m5737r(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) throws IllegalStateException {
        m5720U();
        m5715P();
        AnimatableValueParser.m583w(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.f10913r = false;
                m5743x();
            }
        }
        this.f10906k.mo5726g().f11149n.m5861b("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        m5710K().m5630b0();
        try {
            C3973a4 c3973a4M5622T = m5710K().m5622T(str);
            boolean z2 = true;
            boolean z3 = (i == 200 || i == 204 || i == 304) && th == null;
            if (c3973a4M5622T == null) {
                this.f10906k.mo5726g().f11144i.m5861b("App does not exist in onConfigFetched. appId", C4157q3.m5788s(str));
            } else if (z3 || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404 && i != 304) {
                    m5707H().m5781w(str, bArr, str2);
                } else if (m5707H().m5778s(str) == null) {
                    m5707H().m5781w(str, null, null);
                }
                Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                c3973a4M5622T.m5452F(System.currentTimeMillis());
                m5710K().m5611I(c3973a4M5622T);
                if (i == 404) {
                    this.f10906k.mo5726g().f11146k.m5861b("Config not found. Using empty config. appId", str);
                } else {
                    this.f10906k.mo5726g().f11149n.m5862c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (m5709J().m5963u() && m5741v()) {
                    m5716Q();
                } else {
                    m5742w();
                }
            } else {
                Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                c3973a4M5622T.m5455I(System.currentTimeMillis());
                m5710K().m5611I(c3973a4M5622T);
                this.f10906k.mo5726g().f11149n.m5862c("Fetching config failed. code, error", Integer.valueOf(i), th);
                C4147p4 c4147p4M5707H = m5707H();
                c4147p4M5707H.mo5848b();
                c4147p4M5707H.f11122i.put(str, null);
                C4057h4 c4057h4 = this.f10906k.m5946o().f10637g;
                Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                c4057h4.m5649b(System.currentTimeMillis());
                if (i != 503 && i != 429) {
                    z2 = false;
                }
                if (z2) {
                    C4057h4 c4057h42 = this.f10906k.m5946o().f10638h;
                    Objects.requireNonNull((C3401c) this.f10906k.f11267o);
                    c4057h42.m5649b(System.currentTimeMillis());
                }
                m5742w();
            }
            m5710K().m5639s();
        } finally {
            m5710K().m5633e0();
        }
    }

    @WorkerThread
    /* renamed from: s */
    public final void m5738s(String str, C4004d c4004d) {
        if (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
            m5720U();
            m5715P();
            this.f10921z.put(str, c4004d);
            C4040g c4040gM5710K = m5710K();
            if (C3842t8.m5293b() && c4040gM5710K.f11202a.f11260h.m5526o(C4142p.f11039J0)) {
                Objects.requireNonNull(str, "null reference");
                c4040gM5710K.mo5848b();
                c4040gM5710K.m5684n();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", c4004d.m5568d());
                try {
                    if (c4040gM5710K.m5640t().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        c4040gM5710K.mo5726g().f11141f.m5861b("Failed to insert/update consent setting (got -1). appId", C4157q3.m5788s(str));
                    }
                } catch (SQLiteException e) {
                    c4040gM5710K.mo5726g().f11141f.m5862c("Error storing consent setting. appId, error", C4157q3.m5788s(str), e);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e8 A[Catch: all -> 0x0ef1, TRY_ENTER, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ef A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02fb A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06b6 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x078d A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0945 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0955 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x096f A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x09f5 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0ce2 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0cf8 A[Catch: all -> 0x0ef1, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0d1f A[Catch: all -> 0x0ef1, TRY_LEAVE, TryCatch #7 {all -> 0x0ef1, blocks: (B:3:0x0015, B:25:0x008a, B:155:0x02eb, B:157:0x02ef, B:163:0x02fb, B:164:0x0321, B:167:0x0337, B:170:0x035d, B:172:0x0396, B:178:0x03ac, B:180:0x03b6, B:381:0x09b8, B:182:0x03e8, B:184:0x03f0, B:186:0x0404, B:188:0x0412, B:191:0x0432, B:193:0x0438, B:195:0x0448, B:197:0x0456, B:199:0x0466, B:200:0x0475, B:201:0x0478, B:204:0x048e, B:234:0x04f0, B:237:0x04fa, B:239:0x0508, B:244:0x0554, B:240:0x0526, B:242:0x0534, B:248:0x0561, B:250:0x058f, B:251:0x05bb, B:253:0x05e8, B:255:0x05ee, B:277:0x06b6, B:278:0x06c2, B:281:0x06cc, B:287:0x06ef, B:284:0x06de, B:290:0x06f5, B:292:0x0701, B:294:0x070d, B:310:0x075c, B:313:0x0779, B:315:0x078d, B:317:0x0799, B:320:0x07ac, B:322:0x07be, B:324:0x07cc, B:371:0x0945, B:373:0x094f, B:375:0x0955, B:376:0x096f, B:378:0x0982, B:379:0x099c, B:380:0x09a2, B:329:0x07ed, B:331:0x07fb, B:334:0x0810, B:336:0x0822, B:338:0x0830, B:342:0x0852, B:344:0x086a, B:346:0x0876, B:349:0x0889, B:351:0x089d, B:353:0x08ec, B:355:0x08f3, B:357:0x08f9, B:359:0x0901, B:361:0x0908, B:363:0x090e, B:365:0x0916, B:366:0x0924, B:298:0x072e, B:302:0x0741, B:304:0x0747, B:307:0x0753, B:258:0x05fa, B:260:0x0629, B:261:0x0646, B:263:0x064c, B:265:0x065a, B:269:0x066e, B:266:0x0663, B:272:0x0675, B:274:0x067c, B:275:0x0699, B:211:0x04b0, B:214:0x04ba, B:217:0x04c4, B:386:0x09d6, B:388:0x09e4, B:390:0x09ed, B:401:0x0a20, B:391:0x09f5, B:393:0x09fe, B:395:0x0a04, B:398:0x0a10, B:400:0x0a1a, B:402:0x0a23, B:403:0x0a31, B:405:0x0a37, B:411:0x0a50, B:412:0x0a5b, B:417:0x0a68, B:421:0x0a8f, B:423:0x0aae, B:425:0x0abc, B:427:0x0ac2, B:429:0x0acc, B:430:0x0afb, B:432:0x0b01, B:434:0x0b0f, B:438:0x0b1a, B:435:0x0b14, B:439:0x0b1d, B:440:0x0b2b, B:442:0x0b31, B:444:0x0b41, B:445:0x0b48, B:447:0x0b54, B:448:0x0b5b, B:449:0x0b5e, B:451:0x0b64, B:453:0x0b76, B:454:0x0b79, B:456:0x0bb5, B:457:0x0bca, B:459:0x0bd0, B:462:0x0bea, B:464:0x0c05, B:465:0x0c16, B:467:0x0c1a, B:469:0x0c26, B:470:0x0c2e, B:472:0x0c32, B:474:0x0c38, B:475:0x0c44, B:476:0x0c4f, B:477:0x0c54, B:481:0x0c8c, B:482:0x0c94, B:484:0x0c9a, B:486:0x0cac, B:488:0x0cba, B:490:0x0cbe, B:492:0x0cc8, B:494:0x0ccc, B:500:0x0ce2, B:503:0x0cf8, B:504:0x0d1f, B:418:0x0a6d, B:420:0x0a73, B:68:0x014d, B:96:0x01fb, B:109:0x0239, B:116:0x0258, B:154:0x02e8, B:127:0x027e, B:57:0x0104, B:72:0x0160), top: B:640:0x0015, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:618:0x1083  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x109a A[Catch: all -> 0x1080, TRY_ENTER, TryCatch #12 {all -> 0x1080, blocks: (B:549:0x0eaf, B:548:0x0eac, B:540:0x0e4b, B:542:0x0e75, B:543:0x0e80, B:544:0x0e92, B:546:0x0e9c, B:537:0x0e32, B:552:0x0ebc, B:554:0x0ec9, B:555:0x0ecf, B:556:0x0ed7, B:558:0x0edd, B:563:0x0ef8, B:565:0x0f09, B:585:0x0f7e, B:587:0x0f84, B:589:0x0f94, B:592:0x0f9b, B:597:0x0fce, B:593:0x0fa3, B:595:0x0faf, B:596:0x0fb5, B:598:0x0fdf, B:599:0x0ff6, B:602:0x0ffe, B:603:0x1003, B:604:0x1013, B:606:0x102d, B:607:0x1046, B:608:0x104e, B:613:0x1070, B:612:0x105f, B:566:0x0f23, B:568:0x0f29, B:570:0x0f33, B:572:0x0f3a, B:578:0x0f4a, B:580:0x0f51, B:582:0x0f70, B:584:0x0f77, B:583:0x0f74, B:579:0x0f4e, B:571:0x0f37, B:619:0x1084, B:626:0x109a, B:627:0x109d), top: B:649:0x002c, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c A[Catch: SQLiteException -> 0x009e, all -> 0x02aa, TRY_LEAVE, TryCatch #2 {all -> 0x02aa, blocks: (B:23:0x0084, B:28:0x0090, B:30:0x0095, B:65:0x0136, B:67:0x013c, B:71:0x015c, B:72:0x0160, B:73:0x0172, B:75:0x0178, B:79:0x0186, B:87:0x019a, B:90:0x01a6, B:93:0x01c4, B:95:0x01ea, B:102:0x0207, B:103:0x0210, B:105:0x021b, B:107:0x0224, B:114:0x0252, B:113:0x0241, B:92:0x01b9, B:126:0x026d, B:55:0x00fe, B:60:0x0109), top: B:631:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:715:? A[Catch: all -> 0x1080, SYNTHETIC, TRY_LEAVE, TryCatch #12 {all -> 0x1080, blocks: (B:549:0x0eaf, B:548:0x0eac, B:540:0x0e4b, B:542:0x0e75, B:543:0x0e80, B:544:0x0e92, B:546:0x0e9c, B:537:0x0e32, B:552:0x0ebc, B:554:0x0ec9, B:555:0x0ecf, B:556:0x0ed7, B:558:0x0edd, B:563:0x0ef8, B:565:0x0f09, B:585:0x0f7e, B:587:0x0f84, B:589:0x0f94, B:592:0x0f9b, B:597:0x0fce, B:593:0x0fa3, B:595:0x0faf, B:596:0x0fb5, B:598:0x0fdf, B:599:0x0ff6, B:602:0x0ffe, B:603:0x1003, B:604:0x1013, B:606:0x102d, B:607:0x1046, B:608:0x104e, B:613:0x1070, B:612:0x105f, B:566:0x0f23, B:568:0x0f29, B:570:0x0f33, B:572:0x0f3a, B:578:0x0f4a, B:580:0x0f51, B:582:0x0f70, B:584:0x0f77, B:583:0x0f74, B:579:0x0f4e, B:571:0x0f37, B:619:0x1084, B:626:0x109a, B:627:0x109d), top: B:649:0x002c, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @WorkerThread
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5739t(long j) throws Throwable {
        a aVar;
        C4040g c4040gM5710K;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Throwable th;
        Cursor cursor;
        SQLiteException sQLiteException;
        Cursor cursor2;
        String string;
        Cursor cursor3;
        Cursor cursor4;
        List<C3579a1> list;
        boolean z2;
        int i;
        boolean z3;
        a aVar2;
        C4097k9 c4097k9;
        boolean z4;
        int iM5784z;
        a aVar3;
        C4097k9 c4097k92;
        SecureRandom secureRandom;
        int i2;
        Long l;
        HashMap map;
        long jM5886u;
        HashMap map2;
        int i3;
        C3973a4 c3973a4M5622T;
        boolean z5;
        boolean z6;
        String str6;
        int i4;
        C3579a1.a aVar4;
        C3635e1.a aVar5;
        C3579a1.a aVar6;
        int i5;
        String str7;
        String str8;
        String str9;
        String str10;
        int i6;
        C3635e1.a aVar7;
        int i7;
        int i8;
        boolean z7;
        C3579a1.a aVar8;
        char c;
        SQLiteDatabase sQLiteDatabaseM5640t;
        SQLiteException sQLiteException2;
        Cursor cursor5;
        Cursor cursor6;
        String[] strArr;
        String string2;
        Cursor cursorQuery;
        Cursor cursor7;
        String str11;
        String[] strArr2;
        C3579a1.a aVar9;
        String[] strArr3;
        C4097k9 c4097k93 = this;
        String str12 = "_sn";
        String str13 = "_ai";
        m5710K().m5630b0();
        try {
            aVar = new a(c4097k93, null);
            c4040gM5710K = m5710K();
            j2 = c4097k93.f10920y;
            AnimatableValueParser.m415A(aVar);
            c4040gM5710K.mo5848b();
            c4040gM5710K.m5684n();
            try {
                try {
                    try {
                        sQLiteDatabaseM5640t = c4040gM5710K.m5640t();
                        try {
                            try {
                            } catch (Throwable th2) {
                                th = th2;
                                cursor3 = "";
                                cursor = cursor3;
                                if (cursor == null) {
                                    throw th;
                                }
                                cursor.close();
                                throw th;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                str = "_si";
                str2 = "_sc";
                str3 = "_sn";
                str4 = "_npa";
                str5 = "";
            }
        } catch (Throwable th5) {
            th = th5;
        }
        if (TextUtils.isEmpty(null)) {
            if (j2 != -1) {
                try {
                    strArr3 = new String[]{String.valueOf(j2), String.valueOf(j)};
                } catch (SQLiteException e3) {
                    sQLiteException2 = e3;
                    str5 = "";
                    cursor5 = null;
                    str = "_si";
                    str2 = "_sc";
                    str4 = "_npa";
                    sQLiteException = sQLiteException2;
                    string = null;
                    cursor6 = cursor5;
                    str3 = "_sn";
                    cursor4 = cursor6;
                    try {
                        c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                        if (cursor4 != null) {
                        }
                        list = aVar.f10924c;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor3 = cursor4;
                        cursor = cursor3;
                        if (cursor == null) {
                        }
                    }
                    Throwable th7 = th;
                    m5710K().m5633e0();
                    throw th7;
                }
            } else {
                try {
                    strArr3 = new String[]{String.valueOf(j)};
                } catch (SQLiteException e4) {
                    e = e4;
                    str5 = "";
                    sQLiteException2 = e;
                    cursor5 = null;
                    str = "_si";
                    str2 = "_sc";
                    str4 = "_npa";
                    sQLiteException = sQLiteException2;
                    string = null;
                    cursor6 = cursor5;
                    str3 = "_sn";
                    cursor4 = cursor6;
                    c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                    if (cursor4 != null) {
                    }
                    list = aVar.f10924c;
                    Throwable th72 = th;
                    m5710K().m5633e0();
                    throw th72;
                }
            }
            String str14 = j2 != -1 ? "rowid <= ? and " : "";
            str5 = "";
            StringBuilder sb = new StringBuilder(str14.length() + Opcodes.LCMP);
            sb.append("select app_id, metadata_fingerprint from raw_events where ");
            sb.append(str14);
            sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
            cursorQuery = sQLiteDatabaseM5640t.rawQuery(sb.toString(), strArr3);
            try {
            } catch (SQLiteException e5) {
                sQLiteException2 = e5;
                cursor5 = cursorQuery;
                str = "_si";
                str2 = "_sc";
                str4 = "_npa";
                sQLiteException = sQLiteException2;
                string = null;
                cursor6 = cursor5;
                str3 = "_sn";
                cursor4 = cursor6;
                c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                if (cursor4 != null) {
                }
                list = aVar.f10924c;
                Throwable th722 = th;
                m5710K().m5633e0();
                throw th722;
            }
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(0);
                try {
                    string2 = cursorQuery.getString(1);
                    cursorQuery.close();
                    cursorQuery = cursorQuery;
                    try {
                        cursor7 = cursorQuery;
                    } catch (SQLiteException e6) {
                        e = e6;
                        str = "_si";
                        str2 = "_sc";
                        str3 = "_sn";
                        str4 = "_npa";
                    } catch (Throwable th8) {
                        th = th8;
                        cursor7 = cursorQuery;
                    }
                    try {
                        cursorQuery = sQLiteDatabaseM5640t.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                    } catch (SQLiteException e7) {
                        e = e7;
                        str = "_si";
                        str2 = "_sc";
                        str3 = "_sn";
                        str4 = "_npa";
                        cursorQuery = cursor7;
                    } catch (Throwable th9) {
                        th = th9;
                        cursor = cursor7;
                        th = th;
                        if (cursor == null) {
                        }
                    }
                } catch (SQLiteException e8) {
                    e = e8;
                    str = "_si";
                    str2 = "_sc";
                    str3 = "_sn";
                    str4 = "_npa";
                    sQLiteException = e;
                    cursor4 = cursorQuery;
                    c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                    if (cursor4 != null) {
                    }
                    list = aVar.f10924c;
                    Throwable th7222 = th;
                    m5710K().m5633e0();
                    throw th7222;
                }
                if (cursorQuery.moveToFirst()) {
                    c4040gM5710K.mo5726g().m5801z().m5861b("Raw event metadata record is missing. appId", C4157q3.m5788s(string));
                    cursorQuery.close();
                    str = "_si";
                    str2 = "_sc";
                    str3 = "_sn";
                    str4 = "_npa";
                    list = aVar.f10924c;
                    if (list != null) {
                        if (!(list != null || list.isEmpty())) {
                        }
                    }
                    Throwable th72222 = th;
                    m5710K().m5633e0();
                    throw th72222;
                }
                str4 = "_npa";
                str3 = null;
                try {
                    try {
                        try {
                            C3635e1 c3635e1 = (C3635e1) ((AbstractC3851u4) ((C3635e1.a) C4163q9.m5832x(C3635e1.m4690u0(), cursorQuery.getBlob(0))).m5320p());
                            if (cursorQuery.moveToNext()) {
                                try {
                                    str = "_si";
                                    str2 = "_sc";
                                    try {
                                        c4040gM5710K.mo5726g().m5792A().m5861b("Get multiple raw event metadata records, expected one. appId", C4157q3.m5788s(string));
                                    } catch (SQLiteException e9) {
                                        e = e9;
                                        sQLiteException = e;
                                        cursor6 = cursorQuery;
                                        str3 = "_sn";
                                        cursor4 = cursor6;
                                        c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                                        if (cursor4 != null) {
                                        }
                                        list = aVar.f10924c;
                                        Throwable th722222 = th;
                                        m5710K().m5633e0();
                                        throw th722222;
                                    }
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    str = "_si";
                                    str2 = "_sc";
                                    sQLiteException = e;
                                    cursor6 = cursorQuery;
                                    str3 = "_sn";
                                    cursor4 = cursor6;
                                    c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                                    if (cursor4 != null) {
                                    }
                                    list = aVar.f10924c;
                                    Throwable th7222222 = th;
                                    m5710K().m5633e0();
                                    throw th7222222;
                                }
                            } else {
                                str = "_si";
                                str2 = "_sc";
                            }
                            try {
                                cursorQuery.close();
                                aVar.m5746a(c3635e1);
                                if (j2 != -1) {
                                    str11 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                    strArr2 = new String[]{string, string2, String.valueOf(j2)};
                                } else {
                                    str11 = "app_id = ? and metadata_fingerprint = ?";
                                    strArr2 = new String[]{string, string2};
                                }
                                cursorQuery = sQLiteDatabaseM5640t.query("raw_events", new String[]{"rowid", ModelAuditLogEntry.CHANGE_KEY_NAME, "timestamp", "data"}, str11, strArr2, null, null, "rowid", null);
                                if (cursorQuery.moveToFirst()) {
                                    while (true) {
                                        long j3 = cursorQuery.getLong(0);
                                        try {
                                            aVar9 = (C3579a1.a) C4163q9.m5832x(C3579a1.m4526M(), cursorQuery.getBlob(3));
                                            aVar9.m4548t(cursorQuery.getString(1));
                                            str3 = str12;
                                            aVar9.m4546r(cursorQuery.getLong(2));
                                        } catch (IOException e11) {
                                            str3 = str12;
                                            c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Failed to merge raw event. appId", C4157q3.m5788s(string), e11);
                                        }
                                        if (!aVar.m5747b(j3, (C3579a1) ((AbstractC3851u4) aVar9.m5320p()))) {
                                            cursorQuery.close();
                                            break;
                                        }
                                        if (!cursorQuery.moveToNext()) {
                                            cursorQuery.close();
                                            break;
                                        }
                                        str12 = str3;
                                    }
                                } else {
                                    c4040gM5710K.mo5726g().m5792A().m5861b("Raw event data disappeared while in transaction. appId", C4157q3.m5788s(string));
                                    cursorQuery.close();
                                    str3 = "_sn";
                                }
                            } catch (SQLiteException e12) {
                                e = e12;
                                str3 = str12;
                                sQLiteException = e;
                                cursor4 = cursorQuery;
                                c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                                if (cursor4 != null) {
                                }
                                list = aVar.f10924c;
                                Throwable th72222222 = th;
                                m5710K().m5633e0();
                                throw th72222222;
                            }
                        } catch (IOException e13) {
                            str = "_si";
                            str2 = "_sc";
                            str3 = "_sn";
                            c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Failed to merge raw event metadata. appId", C4157q3.m5788s(string), e13);
                            cursorQuery.close();
                        }
                    } catch (SQLiteException e14) {
                        e = e14;
                        sQLiteException = e;
                        cursor4 = cursorQuery;
                        c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                        if (cursor4 != null) {
                            cursor4.close();
                        }
                        list = aVar.f10924c;
                        Throwable th722222222 = th;
                        m5710K().m5633e0();
                        throw th722222222;
                    }
                } catch (SQLiteException e15) {
                    e = e15;
                    str = "_si";
                    str2 = "_sc";
                }
                list = aVar.f10924c;
                Throwable th7222222222 = th;
                m5710K().m5633e0();
                throw th7222222222;
            }
            cursorQuery.close();
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            list = aVar.f10924c;
            if (!(list != null || list.isEmpty())) {
                m5710K().m5639s();
                m5710K().m5633e0();
                return false;
            }
            C3635e1.a aVarM5315t = aVar.f10922a.m5315t();
            aVarM5315t.m4768F();
            boolean zM5533v = c4097k93.f10906k.m5939a().m5533v(aVar.f10922a.m4710G1(), C4142p.f11055U);
            int i9 = -1;
            boolean z8 = false;
            int i10 = 0;
            int i11 = 0;
            C3579a1.a aVar10 = null;
            C3579a1.a aVar11 = null;
            int i12 = -1;
            long jLongValue = 0;
            while (true) {
                z2 = z8;
                i = i10;
                String str15 = str3;
                if (i11 >= aVar.f10924c.size()) {
                    break;
                }
                C3579a1.a aVarM5315t2 = aVar.f10924c.get(i11).m5315t();
                int i13 = i11;
                if (m5707H().m5782x(aVar.f10922a.m4710G1(), aVarM5315t2.m4553y())) {
                    z6 = zM5533v;
                    c4097k93.f10906k.mo5726g().m5792A().m5862c("Dropping blacklisted raw event. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()), c4097k93.f10906k.m5950u().m5766u(aVarM5315t2.m4553y()));
                    if (!(m5707H().m5775C(aVar.f10922a.m4710G1()) || m5707H().m5776D(aVar.f10922a.m4710G1())) && !"_err".equals(aVarM5315t2.m4553y())) {
                        c4097k93.f10906k.m5949t().m5905S(c4097k93.f10896A, aVar.f10922a.m4710G1(), 11, "_ev", aVarM5315t2.m4553y(), 0);
                    }
                    i5 = i9;
                    str6 = str13;
                    aVar4 = aVar11;
                    z8 = z2;
                    i10 = i;
                    str7 = str15;
                    str9 = str;
                    str10 = str2;
                    i7 = i13;
                    aVar7 = aVarM5315t;
                } else {
                    z6 = zM5533v;
                    if (C3893x7.m5362b() && c4097k93.f10906k.m5939a().m5533v(aVar.f10922a.m4710G1(), C4142p.f11045M0) && aVarM5315t2.m4553y().equals(C4214v5.m5958a(str13))) {
                        aVarM5315t2.m4548t(str13);
                        c4097k93.f10906k.mo5726g().m5795D().m5860a("Renaming ad_impression to _ai");
                        if (c4097k93.f10906k.mo5726g().m5800x(5)) {
                            for (int i14 = 0; i14 < aVarM5315t2.m4551w(); i14++) {
                                if ("ad_platform".equals(aVarM5315t2.m4549u(i14).m4587B()) && !TextUtils.isEmpty(aVarM5315t2.m4549u(i14).m4589G()) && AdjustConfig.AD_REVENUE_ADMOB.equalsIgnoreCase(aVarM5315t2.m4549u(i14).m4589G())) {
                                    c4097k93.f10906k.mo5726g().m5793B().m5860a("AdMob ad impression logged from app. Potentially duplicative.");
                                }
                            }
                        }
                    }
                    boolean zM5783y = m5707H().m5783y(aVar.f10922a.m4710G1(), aVarM5315t2.m4553y());
                    if (zM5783y) {
                        str6 = str13;
                        i4 = i12;
                    } else {
                        m5713N();
                        String strM4553y = aVarM5315t2.m4553y();
                        AnimatableValueParser.m583w(strM4553y);
                        str6 = str13;
                        int iHashCode = strM4553y.hashCode();
                        i4 = i12;
                        if (iHashCode == 94660) {
                            if (strM4553y.equals("_in")) {
                                c = 0;
                            }
                        } else if (iHashCode != 95025) {
                            c = (iHashCode == 95027 && strM4553y.equals("_ui")) ? (char) 1 : (char) 65535;
                            if (c == 0 || c == 1 || c == 2) {
                                aVar5 = aVarM5315t;
                                aVar6 = aVar10;
                                aVar4 = aVar11;
                                z8 = z2;
                                if (zM5783y) {
                                    if (c4097k93.f10906k.m5939a().m5533v(aVar.f10922a.m4710G1(), C4142p.f11054T)) {
                                    }
                                    i12 = i6;
                                    if (!z6) {
                                    }
                                    i7 = i13;
                                    aVar.f10924c.set(i7, (C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()));
                                    i10 = i + 1;
                                    aVar7.m4810t(aVarM5315t2);
                                    aVar10 = aVar6;
                                } else {
                                    ArrayList arrayList = new ArrayList(aVarM5315t2.m4550v());
                                    int i15 = -1;
                                    int i16 = -1;
                                    for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                        if ("value".equals(((C3607c1) arrayList.get(i17)).m4587B())) {
                                            i15 = i17;
                                        } else if ("currency".equals(((C3607c1) arrayList.get(i17)).m4587B())) {
                                            i16 = i17;
                                        }
                                    }
                                    if (i15 != -1) {
                                        if (((C3607c1) arrayList.get(i15)).m4590I() || ((C3607c1) arrayList.get(i15)).m4594M()) {
                                            if (i16 != -1) {
                                                String strM4589G = ((C3607c1) arrayList.get(i16)).m4589G();
                                                if (strM4589G.length() == 3) {
                                                    int iCharCount = 0;
                                                    while (iCharCount < strM4589G.length()) {
                                                        int iCodePointAt = strM4589G.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                    z7 = false;
                                                }
                                                z7 = true;
                                                break;
                                            }
                                            z7 = true;
                                            if (z7) {
                                                c4097k93.f10906k.mo5726g().m5793B().m5860a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                aVarM5315t2.m4552x(i15);
                                                m5700e(aVarM5315t2, "_c");
                                                m5699d(aVarM5315t2, 19, "currency");
                                            }
                                        } else {
                                            c4097k93.f10906k.mo5726g().m5793B().m5860a("Value must be specified with a numeric type.");
                                            aVarM5315t2.m4552x(i15);
                                            m5700e(aVarM5315t2, "_c");
                                            m5699d(aVarM5315t2, 18, "value");
                                        }
                                    }
                                    if (c4097k93.f10906k.m5939a().m5533v(aVar.f10922a.m4710G1(), C4142p.f11054T)) {
                                        i5 = i9;
                                        str7 = str15;
                                        str8 = "_et";
                                        str9 = str;
                                        str10 = str2;
                                        i6 = i4;
                                        aVar7 = aVar5;
                                    } else {
                                        if ("_e".equals(aVarM5315t2.m4553y())) {
                                            m5713N();
                                            if (C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()), "_fr") == null) {
                                                if (aVar4 != null && Math.abs(aVar4.m4554z() - aVarM5315t2.m4554z()) <= 1000) {
                                                    C3579a1.a aVar12 = (C3579a1.a) ((AbstractC3851u4.b) aVar4.clone());
                                                    if (c4097k93.m5740u(aVarM5315t2, aVar12)) {
                                                        aVar7 = aVar5;
                                                        aVar7.m4806r(i9, aVar12);
                                                        str8 = "_et";
                                                        i8 = i4;
                                                        i5 = i9;
                                                        i12 = i8;
                                                        str7 = str15;
                                                        str9 = str;
                                                        str10 = str2;
                                                        aVar6 = null;
                                                        aVar4 = null;
                                                    }
                                                }
                                                aVar7 = aVar5;
                                                aVar6 = aVarM5315t2;
                                                i12 = i;
                                            } else {
                                                aVar7 = aVar5;
                                                i12 = i4;
                                            }
                                            i5 = i9;
                                            str7 = str15;
                                            str8 = "_et";
                                            str9 = str;
                                            str10 = str2;
                                        } else {
                                            aVar7 = aVar5;
                                            if ("_vs".equals(aVarM5315t2.m4553y())) {
                                                m5713N();
                                                str8 = "_et";
                                                if (C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()), str8) == null) {
                                                    if (aVar6 != null && Math.abs(aVar6.m4554z() - aVarM5315t2.m4554z()) <= 1000) {
                                                        C3579a1.a aVar13 = (C3579a1.a) ((AbstractC3851u4.b) aVar6.clone());
                                                        if (c4097k93.m5740u(aVar13, aVarM5315t2)) {
                                                            i8 = i4;
                                                            aVar7.m4806r(i8, aVar13);
                                                            i5 = i9;
                                                            i12 = i8;
                                                            str7 = str15;
                                                            str9 = str;
                                                            str10 = str2;
                                                            aVar6 = null;
                                                            aVar4 = null;
                                                        }
                                                    }
                                                    aVar4 = aVarM5315t2;
                                                    i12 = i4;
                                                    i5 = i;
                                                    str7 = str15;
                                                    str9 = str;
                                                    str10 = str2;
                                                } else {
                                                    i6 = i4;
                                                }
                                            } else {
                                                str8 = "_et";
                                                i6 = i4;
                                                if (c4097k93.f10906k.m5939a().m5533v(aVar.f10922a.m4710G1(), C4142p.f11086m0) && "_ab".equals(aVarM5315t2.m4553y())) {
                                                    m5713N();
                                                    if (C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()), str8) == null && aVar6 != null && Math.abs(aVar6.m4554z() - aVarM5315t2.m4554z()) <= 4000) {
                                                        C3579a1.a aVar14 = (C3579a1.a) ((AbstractC3851u4.b) aVar6.clone());
                                                        c4097k93.m5701A(aVar14, aVarM5315t2);
                                                        AnimatableValueParser.m539l("_e".equals(aVar14.m4553y()));
                                                        m5713N();
                                                        str7 = str15;
                                                        C3607c1 c3607c1M5831w = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar14.m5320p()), str7);
                                                        m5713N();
                                                        str10 = str2;
                                                        C3607c1 c3607c1M5831w2 = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar14.m5320p()), str10);
                                                        m5713N();
                                                        i5 = i9;
                                                        str9 = str;
                                                        C3607c1 c3607c1M5831w3 = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar14.m5320p()), str9);
                                                        String strM4589G2 = c3607c1M5831w != null ? c3607c1M5831w.m4589G() : str5;
                                                        if (!TextUtils.isEmpty(strM4589G2)) {
                                                            m5713N();
                                                            C4163q9.m5821E(aVarM5315t2, str7, strM4589G2);
                                                        }
                                                        String strM4589G3 = c3607c1M5831w2 != null ? c3607c1M5831w2.m4589G() : str5;
                                                        if (!TextUtils.isEmpty(strM4589G3)) {
                                                            m5713N();
                                                            C4163q9.m5821E(aVarM5315t2, str10, strM4589G3);
                                                        }
                                                        if (c3607c1M5831w3 != null) {
                                                            m5713N();
                                                            C4163q9.m5821E(aVarM5315t2, str9, Long.valueOf(c3607c1M5831w3.m4591J()));
                                                        }
                                                        aVar7.m4806r(i6, aVar14);
                                                        i12 = i6;
                                                        aVar6 = null;
                                                    }
                                                }
                                            }
                                            i5 = i9;
                                            str7 = str15;
                                            str9 = str;
                                            str10 = str2;
                                        }
                                        if (!z6 && "_e".equals(aVarM5315t2.m4553y())) {
                                            if (aVarM5315t2.m4551w() != 0) {
                                                c4097k93.f10906k.mo5726g().m5792A().m5861b("Engagement event does not contain any parameters. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()));
                                            } else {
                                                m5713N();
                                                Long l2 = (Long) C4163q9.m5829R((C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()), str8);
                                                if (l2 == null) {
                                                    c4097k93.f10906k.mo5726g().m5792A().m5861b("Engagement event does not include duration. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()));
                                                } else {
                                                    jLongValue += l2.longValue();
                                                }
                                            }
                                        }
                                        i7 = i13;
                                        aVar.f10924c.set(i7, (C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()));
                                        i10 = i + 1;
                                        aVar7.m4810t(aVarM5315t2);
                                        aVar10 = aVar6;
                                    }
                                    i12 = i6;
                                    if (!z6) {
                                        if (aVarM5315t2.m4551w() != 0) {
                                        }
                                    }
                                    i7 = i13;
                                    aVar.f10924c.set(i7, (C3579a1) ((AbstractC3851u4) aVarM5315t2.m5320p()));
                                    i10 = i + 1;
                                    aVar7.m4810t(aVarM5315t2);
                                    aVar10 = aVar6;
                                }
                            }
                        } else {
                            if (strM4553y.equals("_ug")) {
                                c = 2;
                            }
                            if (c == 0) {
                                if (c == 0 || c == 1 || c == 2) {
                                }
                            }
                        }
                    }
                    aVar6 = aVar10;
                    int i18 = 0;
                    boolean z9 = false;
                    boolean z10 = false;
                    while (true) {
                        aVar5 = aVarM5315t;
                        if (i18 >= aVarM5315t2.m4551w()) {
                            break;
                        }
                        if ("_c".equals(aVarM5315t2.m4549u(i18).m4587B())) {
                            C3607c1.a aVarM5315t3 = aVarM5315t2.m4549u(i18).m5315t();
                            aVarM5315t3.m4599r(1L);
                            aVarM5315t2.m4545q(i18, (C3607c1) ((AbstractC3851u4) aVarM5315t3.m5320p()));
                            aVar8 = aVar11;
                            z9 = true;
                        } else if ("_r".equals(aVarM5315t2.m4549u(i18).m4587B())) {
                            C3607c1.a aVarM5315t4 = aVarM5315t2.m4549u(i18).m5315t();
                            aVar8 = aVar11;
                            aVarM5315t4.m4599r(1L);
                            aVarM5315t2.m4545q(i18, (C3607c1) ((AbstractC3851u4) aVarM5315t4.m5320p()));
                            z10 = true;
                        } else {
                            aVar8 = aVar11;
                        }
                        i18++;
                        aVarM5315t = aVar5;
                        aVar11 = aVar8;
                    }
                    aVar4 = aVar11;
                    if (!z9 && zM5783y) {
                        c4097k93.f10906k.mo5726g().m5795D().m5861b("Marking event as conversion", c4097k93.f10906k.m5950u().m5766u(aVarM5315t2.m4553y()));
                        C3607c1.a aVarM4578Q = C3607c1.m4578Q();
                        aVarM4578Q.m4600s("_c");
                        aVarM4578Q.m4599r(1L);
                        aVarM5315t2.m4547s(aVarM4578Q);
                    }
                    if (!z10) {
                        c4097k93.f10906k.mo5726g().m5795D().m5861b("Marking event as real-time", c4097k93.f10906k.m5950u().m5766u(aVarM5315t2.m4553y()));
                        C3607c1.a aVarM4578Q2 = C3607c1.m4578Q();
                        aVarM4578Q2.m4600s("_r");
                        aVarM4578Q2.m4599r(1L);
                        aVarM5315t2.m4547s(aVarM4578Q2);
                    }
                    if (m5710K().m5645y(m5721V(), aVar.f10922a.m4710G1(), false, true).f10708e > c4097k93.f10906k.m5939a().m5530s(aVar.f10922a.m4710G1())) {
                        m5700e(aVarM5315t2, "_r");
                    } else {
                        z2 = true;
                    }
                    if (C4196t9.m5877X(aVarM5315t2.m4553y()) && zM5783y && m5710K().m5645y(m5721V(), aVar.f10922a.m4710G1(), true, false).f10706c > c4097k93.f10906k.m5939a().m5528q(aVar.f10922a.m4710G1(), C4142p.f11087n)) {
                        c4097k93.f10906k.mo5726g().m5792A().m5861b("Too many conversions. Not logging as conversion. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()));
                        boolean z11 = false;
                        int i19 = -1;
                        C3607c1.a aVarM5315t5 = null;
                        for (int i20 = 0; i20 < aVarM5315t2.m4551w(); i20++) {
                            C3607c1 c3607c1M4549u = aVarM5315t2.m4549u(i20);
                            if ("_c".equals(c3607c1M4549u.m4587B())) {
                                aVarM5315t5 = c3607c1M4549u.m5315t();
                                i19 = i20;
                            } else if ("_err".equals(c3607c1M4549u.m4587B())) {
                                z11 = true;
                            }
                        }
                        if (z11 && aVarM5315t5 != null) {
                            aVarM5315t2.m4552x(i19);
                        } else if (aVarM5315t5 != null) {
                            C3607c1.a aVar15 = (C3607c1.a) ((AbstractC3851u4.b) aVarM5315t5.clone());
                            aVar15.m4600s("_err");
                            aVar15.m4599r(10L);
                            aVarM5315t2.m4545q(i19, (C3607c1) ((AbstractC3851u4) aVar15.m5320p()));
                        } else {
                            c4097k93.f10906k.mo5726g().m5801z().m5861b("Did not find conversion parameter. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()));
                        }
                    }
                    z8 = z2;
                    if (zM5783y) {
                    }
                }
                i11 = i7 + 1;
                str2 = str10;
                str = str9;
                aVarM5315t = aVar7;
                str3 = str7;
                i9 = i5;
                zM5533v = z6;
                str13 = str6;
                aVar11 = aVar4;
            }
            C3635e1.a aVar16 = aVarM5315t;
            if (zM5533v) {
                int i21 = i;
                int i22 = 0;
                while (i22 < i21) {
                    C3579a1 c3579a1M4765B = aVar16.m4765B(i22);
                    if ("_e".equals(c3579a1M4765B.m4533F())) {
                        m5713N();
                        if (C4163q9.m5831w(c3579a1M4765B, "_fr") != null) {
                            aVar16.m4769G(i22);
                            i21--;
                            i22--;
                        } else {
                            m5713N();
                            C3607c1 c3607c1M5831w4 = C4163q9.m5831w(c3579a1M4765B, "_et");
                            if (c3607c1M5831w4 != null) {
                                Long lValueOf = c3607c1M5831w4.m4590I() ? Long.valueOf(c3607c1M5831w4.m4591J()) : null;
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    }
                    i22++;
                }
            }
            long j4 = jLongValue;
            c4097k93.m5727h(aVar16, j4, false);
            Iterator<C3579a1> it = aVar16.m4821z().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                if ("_s".equals(it.next().m4533F())) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                m5710K().m5624V(aVar16.m4798k0(), "_se");
            }
            if (C4163q9.m5830s(aVar16, "_sid") >= 0) {
                c4097k93.m5727h(aVar16, j4, true);
            } else {
                int iM5830s = C4163q9.m5830s(aVar16, "_se");
                if (iM5830s >= 0) {
                    aVar16.m4779R(iM5830s);
                    c4097k93.f10906k.mo5726g().m5801z().m5861b("Session engagement user property is in the bundle without session ID. appId", C4157q3.m5788s(aVar.f10922a.m4710G1()));
                }
            }
            C4163q9 c4163q9M5713N = m5713N();
            c4163q9M5713N.mo5726g().m5795D().m5860a("Checking account type status for ad personalization signals");
            if (c4163q9M5713N.m5687r().m5773A(aVar16.m4798k0()) && (c3973a4M5622T = c4163q9M5713N.m5686q().m5622T(aVar16.m4798k0())) != null && c3973a4M5622T.m5478h() && c4163q9M5713N.m5864c().m5692w()) {
                c4163q9M5713N.mo5726g().m5794C().m5860a("Turning off ad personalization due to account type");
                C3691i1.a aVarM4943L = C3691i1.m4943L();
                String str16 = str4;
                aVarM4943L.m4959r(str16);
                aVarM4943L.m4958q(c4163q9M5713N.m5864c().m5691v());
                aVarM4943L.m4960s(1L);
                C3691i1 c3691i1 = (C3691i1) ((AbstractC3851u4) aVarM4943L.m5320p());
                int i23 = 0;
                while (true) {
                    if (i23 >= aVar16.m4778Q()) {
                        z5 = false;
                        break;
                    }
                    if (str16.equals(aVar16.m4776O(i23).m4949D())) {
                        aVar16.m4808s(i23, c3691i1);
                        z5 = true;
                        break;
                    }
                    i23++;
                }
                if (!z5) {
                    aVar16.m4814v(c3691i1);
                }
            }
            aVar16.m4766D(RecyclerView.FOREVER_NS);
            aVar16.m4770H(Long.MIN_VALUE);
            for (int i24 = 0; i24 < aVar16.m4764A(); i24++) {
                C3579a1 c3579a1M4765B2 = aVar16.m4765B(i24);
                if (c3579a1M4765B2.m4535H() < aVar16.m4782U()) {
                    aVar16.m4766D(c3579a1M4765B2.m4535H());
                }
                if (c3579a1M4765B2.m4535H() > aVar16.m4786Y()) {
                    aVar16.m4770H(c3579a1M4765B2.m4535H());
                }
            }
            if (C3687hb.m4938b() && c4097k93.f10906k.m5939a().m5533v(aVar16.m4798k0(), C4142p.f11033G0)) {
                aVar16.m4815v0();
            }
            aVar16.m4811t0();
            aVar16.m4771I(m5712M().m5517t(aVar16.m4798k0(), aVar16.m4821z(), aVar16.m4777P(), Long.valueOf(aVar16.m4782U()), Long.valueOf(aVar16.m4786Y())));
            if (c4097k93.f10906k.m5939a().m5520A(aVar.f10922a.m4710G1())) {
                HashMap map3 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                SecureRandom secureRandomM5924v0 = c4097k93.f10906k.m5949t().m5924v0();
                int i25 = 0;
                while (i25 < aVar16.m4764A()) {
                    C3579a1.a aVarM5315t6 = aVar16.m4765B(i25).m5315t();
                    if (aVarM5315t6.m4553y().equals("_ep")) {
                        m5713N();
                        String str17 = (String) C4163q9.m5829R((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()), "_en");
                        C4098l c4098lM5646z = (C4098l) map3.get(str17);
                        if (c4098lM5646z == null) {
                            c4098lM5646z = m5710K().m5646z(aVar.f10922a.m4710G1(), str17);
                            map3.put(str17, c4098lM5646z);
                        }
                        if (c4098lM5646z.f10934i == null) {
                            if (c4098lM5646z.f10935j.longValue() > 1) {
                                m5713N();
                                C4163q9.m5821E(aVarM5315t6, "_sr", c4098lM5646z.f10935j);
                            }
                            Boolean bool = c4098lM5646z.f10936k;
                            if (bool != null && bool.booleanValue()) {
                                m5713N();
                                C4163q9.m5821E(aVarM5315t6, "_efs", 1L);
                            }
                            arrayList2.add((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()));
                        }
                        aVar16.m4806r(i25, aVarM5315t6);
                    } else {
                        long jM5774B = m5707H().m5774B(aVar.f10922a.m4710G1());
                        c4097k93.f10906k.m5949t();
                        long jM5886u2 = C4196t9.m5886u(aVarM5315t6.m4554z(), jM5774B);
                        C3579a1 c3579a1 = (C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p());
                        Long l3 = 1L;
                        if (TextUtils.isEmpty("_dbg") || l3 == null) {
                            iM5784z = z4 ? m5707H().m5784z(aVar.f10922a.m4710G1(), aVarM5315t6.m4553y()) : 1;
                            if (iM5784z > 0) {
                                c4097k93.f10906k.mo5726g().m5792A().m5862c("Sample rate must be positive. event, rate", aVarM5315t6.m4553y(), Integer.valueOf(iM5784z));
                                arrayList2.add((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()));
                                aVar16.m4806r(i25, aVarM5315t6);
                            } else {
                                C4098l c4098lM5646z2 = (C4098l) map3.get(aVarM5315t6.m4553y());
                                if (c4098lM5646z2 == null) {
                                    try {
                                        c4098lM5646z2 = m5710K().m5646z(aVar.f10922a.m4710G1(), aVarM5315t6.m4553y());
                                        if (c4098lM5646z2 == null) {
                                            c4097k93.f10906k.mo5726g().m5792A().m5862c("Event being bundled has no eventAggregate. appId, eventName", aVar.f10922a.m4710G1(), aVarM5315t6.m4553y());
                                            c4098lM5646z2 = new C4098l(aVar.f10922a.m4710G1(), aVarM5315t6.m4553y(), 1L, 1L, 1L, aVarM5315t6.m4554z(), 0L, null, null, null, null);
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                    }
                                }
                                m5713N();
                                Long l4 = (Long) C4163q9.m5829R((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()), "_eid");
                                Boolean boolValueOf = Boolean.valueOf(l4 != null);
                                if (iM5784z == 1) {
                                    arrayList2.add((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()));
                                    if (boolValueOf.booleanValue() && (c4098lM5646z2.f10934i != null || c4098lM5646z2.f10935j != null || c4098lM5646z2.f10936k != null)) {
                                        map3.put(aVarM5315t6.m4553y(), c4098lM5646z2.m5750c(null, null, null));
                                    }
                                    aVar16.m4806r(i25, aVarM5315t6);
                                } else {
                                    if (secureRandomM5924v0.nextInt(iM5784z) == 0) {
                                        m5713N();
                                        aVar3 = aVar;
                                        long j5 = iM5784z;
                                        C4163q9.m5821E(aVarM5315t6, "_sr", Long.valueOf(j5));
                                        arrayList2.add((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()));
                                        if (boolValueOf.booleanValue()) {
                                            c4098lM5646z2 = c4098lM5646z2.m5750c(null, Long.valueOf(j5), null);
                                        }
                                        map3.put(aVarM5315t6.m4553y(), c4098lM5646z2.m5749b(aVarM5315t6.m4554z(), jM5886u2));
                                        c4097k92 = this;
                                        map2 = map3;
                                        secureRandom = secureRandomM5924v0;
                                        i3 = i25;
                                    } else {
                                        aVar3 = aVar;
                                        Long l5 = c4098lM5646z2.f10933h;
                                        if (l5 != null) {
                                            long jLongValue2 = l5.longValue();
                                            c4097k92 = this;
                                            l = l4;
                                            map = map3;
                                            jM5886u = jLongValue2;
                                            secureRandom = secureRandomM5924v0;
                                            i2 = i25;
                                        } else {
                                            c4097k92 = this;
                                            secureRandom = secureRandomM5924v0;
                                            c4097k92.f10906k.m5949t();
                                            i2 = i25;
                                            l = l4;
                                            map = map3;
                                            jM5886u = C4196t9.m5886u(aVarM5315t6.m4544A(), jM5774B);
                                        }
                                        if (jM5886u != jM5886u2) {
                                            m5713N();
                                            C4163q9.m5821E(aVarM5315t6, "_efs", 1L);
                                            m5713N();
                                            long j6 = iM5784z;
                                            C4163q9.m5821E(aVarM5315t6, "_sr", Long.valueOf(j6));
                                            arrayList2.add((C3579a1) ((AbstractC3851u4) aVarM5315t6.m5320p()));
                                            if (boolValueOf.booleanValue()) {
                                                c4098lM5646z2 = c4098lM5646z2.m5750c(null, Long.valueOf(j6), Boolean.TRUE);
                                            }
                                            map2 = map;
                                            map2.put(aVarM5315t6.m4553y(), c4098lM5646z2.m5749b(aVarM5315t6.m4554z(), jM5886u2));
                                        } else {
                                            map2 = map;
                                            if (boolValueOf.booleanValue()) {
                                                map2.put(aVarM5315t6.m4553y(), c4098lM5646z2.m5750c(l, null, null));
                                            }
                                        }
                                        i3 = i2;
                                    }
                                    aVar16.m4806r(i3, aVarM5315t6);
                                }
                            }
                        } else {
                            Iterator<C3607c1> it2 = c3579a1.m4543v().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                C3607c1 next = it2.next();
                                Iterator<C3607c1> it3 = it2;
                                if ("_dbg".equals(next.m4587B())) {
                                    z4 = l3.equals(Long.valueOf(next.m4591J())) || ((l3 instanceof String) && l3.equals(next.m4589G())) || ((l3 instanceof Double) && l3.equals(Double.valueOf(next.m4595N())));
                                } else {
                                    it2 = it3;
                                }
                            }
                            if (z4) {
                            }
                            if (iM5784z > 0) {
                            }
                        }
                        i25 = i3 + 1;
                        c4097k93 = c4097k92;
                        map3 = map2;
                        aVar = aVar3;
                        secureRandomM5924v0 = secureRandom;
                    }
                    map2 = map3;
                    secureRandom = secureRandomM5924v0;
                    i3 = i25;
                    aVar3 = aVar;
                    c4097k92 = this;
                    i25 = i3 + 1;
                    c4097k93 = c4097k92;
                    map3 = map2;
                    aVar = aVar3;
                    secureRandomM5924v0 = secureRandom;
                }
                HashMap map4 = map3;
                aVar2 = aVar;
                c4097k9 = c4097k93;
                if (arrayList2.size() < aVar16.m4764A()) {
                    aVar16.m4768F();
                    aVar16.m4816w(arrayList2);
                }
                Iterator it4 = map4.entrySet().iterator();
                while (it4.hasNext()) {
                    m5710K().m5610H((C4098l) ((Map.Entry) it4.next()).getValue());
                }
            } else {
                aVar2 = aVar;
                c4097k9 = c4097k93;
            }
            a aVar17 = aVar2;
            String strM4710G1 = aVar17.f10922a.m4710G1();
            C3973a4 c3973a4M5622T2 = m5710K().m5622T(strM4710G1);
            if (c3973a4M5622T2 == null) {
                c4097k9.f10906k.mo5726g().m5801z().m5861b("Bundling raw events w/o app info. appId", C4157q3.m5788s(aVar17.f10922a.m4710G1()));
            } else if (aVar16.m4764A() > 0) {
                long jM5458L = c3973a4M5622T2.m5458L();
                if (jM5458L != 0) {
                    aVar16.m4780S(jM5458L);
                } else {
                    aVar16.m4793f0();
                }
                long jM5457K = c3973a4M5622T2.m5457K();
                if (jM5457K != 0) {
                    jM5458L = jM5457K;
                }
                if (jM5458L != 0) {
                    aVar16.m4773K(jM5458L);
                } else {
                    aVar16.m4789b0();
                }
                c3973a4M5622T2.m5470X();
                aVar16.m4787Z((int) c3973a4M5622T2.m5467U());
                c3973a4M5622T2.m5471a(aVar16.m4782U());
                c3973a4M5622T2.m5482l(aVar16.m4786Y());
                String strM5476f = c3973a4M5622T2.m5476f();
                if (strM5476f != null) {
                    aVar16.m4797j0(strM5476f);
                } else {
                    aVar16.m4803p0();
                }
                m5710K().m5611I(c3973a4M5622T2);
            }
            if (aVar16.m4764A() > 0) {
                C3847u0 c3847u0M5778s = m5707H().m5778s(aVar17.f10922a.m4710G1());
                if (c3847u0M5778s != null && c3847u0M5778s.m5305x()) {
                    aVar16.m4794g0(c3847u0M5778s.m5306y());
                } else if (TextUtils.isEmpty(aVar17.f10922a.m4726S())) {
                    aVar16.m4794g0(-1L);
                } else {
                    c4097k9.f10906k.mo5726g().m5792A().m5861b("Did not find measurement config or missing version info. appId", C4157q3.m5788s(aVar17.f10922a.m4710G1()));
                }
                m5710K().m5613K((C3635e1) ((AbstractC3851u4) aVar16.m5320p()), z2);
            }
            C4040g c4040gM5710K2 = m5710K();
            List<Long> list2 = aVar17.f10923b;
            AnimatableValueParser.m415A(list2);
            c4040gM5710K2.mo5848b();
            c4040gM5710K2.m5684n();
            StringBuilder sb2 = new StringBuilder("rowid in (");
            for (int i26 = 0; i26 < list2.size(); i26++) {
                if (i26 != 0) {
                    sb2.append(",");
                }
                sb2.append(list2.get(i26).longValue());
            }
            sb2.append(")");
            int iDelete = c4040gM5710K2.m5640t().delete("raw_events", sb2.toString(), null);
            if (iDelete != list2.size()) {
                c4040gM5710K2.mo5726g().m5801z().m5862c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list2.size()));
            }
            C4040g c4040gM5710K3 = m5710K();
            try {
                c4040gM5710K3.m5640t().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strM4710G1, strM4710G1});
            } catch (SQLiteException e16) {
                c4040gM5710K3.mo5726g().m5801z().m5862c("Failed to remove unused event metadata. appId", C4157q3.m5788s(strM4710G1), e16);
            }
            m5710K().m5639s();
            m5710K().m5633e0();
            return true;
        }
        str5 = "";
        if (j2 != -1) {
            strArr = new String[]{null, String.valueOf(j2)};
        } else {
            try {
                strArr = new String[]{null};
            } catch (SQLiteException e17) {
                e = e17;
                str = "_si";
                str2 = "_sc";
                str3 = "_sn";
                str4 = "_npa";
                sQLiteException = e;
                cursor2 = null;
                string = null;
                cursor4 = cursor2;
                c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
                if (cursor4 != null) {
                }
                list = aVar.f10924c;
                Throwable th72222222222 = th;
                m5710K().m5633e0();
                throw th72222222222;
            }
        }
        String str18 = j2 != -1 ? " and rowid <= ?" : str5;
        StringBuilder sb3 = new StringBuilder(str18.length() + 84);
        sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
        sb3.append(str18);
        sb3.append(" order by rowid limit 1;");
        Cursor cursorRawQuery = sQLiteDatabaseM5640t.rawQuery(sb3.toString(), strArr);
        try {
        } catch (SQLiteException e18) {
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            sQLiteException = e18;
            cursor2 = cursorRawQuery;
            string = null;
            cursor4 = cursor2;
            c4040gM5710K.mo5726g().m5801z().m5862c("Data loss. Error selecting raw event. appId", C4157q3.m5788s(string), sQLiteException);
            if (cursor4 != null) {
            }
            list = aVar.f10924c;
            Throwable th722222222222 = th;
            m5710K().m5633e0();
            throw th722222222222;
        }
        if (!cursorRawQuery.moveToFirst()) {
            cursorRawQuery.close();
            str = "_si";
            str2 = "_sc";
            str3 = "_sn";
            str4 = "_npa";
            list = aVar.f10924c;
            Throwable th7222222222222 = th;
            m5710K().m5633e0();
            throw th7222222222222;
        }
        string2 = cursorRawQuery.getString(0);
        cursorRawQuery.close();
        string = null;
        cursorQuery = cursorRawQuery;
        cursor7 = cursorQuery;
        cursorQuery = sQLiteDatabaseM5640t.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
        if (cursorQuery.moveToFirst()) {
        }
    }

    /* renamed from: u */
    public final boolean m5740u(C3579a1.a aVar, C3579a1.a aVar2) {
        AnimatableValueParser.m539l("_e".equals(aVar.m4553y()));
        m5713N();
        C3607c1 c3607c1M5831w = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar.m5320p()), "_sc");
        String strM4589G = c3607c1M5831w == null ? null : c3607c1M5831w.m4589G();
        m5713N();
        C3607c1 c3607c1M5831w2 = C4163q9.m5831w((C3579a1) ((AbstractC3851u4) aVar2.m5320p()), "_pc");
        String strM4589G2 = c3607c1M5831w2 != null ? c3607c1M5831w2.m4589G() : null;
        if (strM4589G2 == null || !strM4589G2.equals(strM4589G)) {
            return false;
        }
        m5701A(aVar, aVar2);
        return true;
    }

    /* renamed from: v */
    public final boolean m5741v() {
        m5720U();
        m5715P();
        return ((m5710K().m5621S("select count(1) > 0 from raw_events", null) > 0L ? 1 : (m5710K().m5621S("select count(1) > 0 from raw_events", null) == 0L ? 0 : -1)) != 0) || !TextUtils.isEmpty(m5710K().m5641u());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    @WorkerThread
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5742w() {
        boolean z2;
        long jMax;
        long jMax2;
        int iIntValue;
        m5720U();
        m5715P();
        if (this.f10909n > 0) {
            Objects.requireNonNull((C3401c) this.f10906k.f11267o);
            long jAbs = 3600000 - Math.abs(SystemClock.elapsedRealtime() - this.f10909n);
            if (jAbs > 0) {
                this.f10906k.mo5726g().f11149n.m5861b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                m5718S().m5501a();
                m5719T().m5659s();
                return;
            }
            this.f10909n = 0L;
        }
        if (!this.f10906k.m5944m() || !m5741v()) {
            this.f10906k.mo5726g().f11149n.m5860a("Nothing to upload or uploading impossible");
            m5718S().m5501a();
            m5719T().m5659s();
            return;
        }
        Objects.requireNonNull((C3401c) this.f10906k.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax3 = Math.max(0L, C4142p.f11020A.m5693a(null).longValue());
        if (m5710K().m5621S("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            z2 = true;
        } else if (!(m5710K().m5621S("select count(1) > 0 from queue where has_realtime = 1", null) != 0)) {
            z2 = false;
        }
        if (z2) {
            String strM5523h = this.f10906k.f11260h.m5523h("debug.firebase.analytics.app", "");
            jMax = (TextUtils.isEmpty(strM5523h) || ".none.".equals(strM5523h)) ? Math.max(0L, C4142p.f11101u.m5693a(null).longValue()) : Math.max(0L, C4142p.f11103v.m5693a(null).longValue());
        } else {
            jMax = Math.max(0L, C4142p.f11099t.m5693a(null).longValue());
        }
        long jM5648a = this.f10906k.m5946o().f10636f.m5648a();
        long jM5648a2 = this.f10906k.m5946o().f10637g.m5648a();
        long j = jMax;
        long jMax4 = Math.max(m5710K().m5643w("select max(bundle_end_timestamp) from queue", null, 0L), m5710K().m5643w("select max(timestamp) from raw_events", null, 0L));
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jM5648a - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jM5648a2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            jMax2 = jMax3 + jAbs2;
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + j;
            }
            if (!m5713N().m5838N(jMax5, j)) {
                jMax2 = jMax5 + j;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                for (int i = 0; i < Math.min(20, Math.max(0, C4142p.f11024C.m5693a(null).intValue())); i++) {
                    jMax2 += Math.max(0L, C4142p.f11022B.m5693a(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                }
                jMax2 = 0;
            }
        }
        if (jMax2 == 0) {
            this.f10906k.mo5726g().f11149n.m5860a("Next upload time is 0");
            m5718S().m5501a();
            m5719T().m5659s();
            return;
        }
        if (!m5709J().m5963u()) {
            this.f10906k.mo5726g().f11149n.m5860a("No network");
            C3985b4 c3985b4M5718S = m5718S();
            c3985b4M5718S.f10561a.m5715P();
            c3985b4M5718S.f10561a.mo5725f().mo5848b();
            if (!c3985b4M5718S.f10562b) {
                c3985b4M5718S.f10561a.f10906k.f11254b.registerReceiver(c3985b4M5718S, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                c3985b4M5718S.f10563c = c3985b4M5718S.f10561a.m5709J().m5963u();
                c3985b4M5718S.f10561a.mo5726g().f11149n.m5861b("Registering connectivity change receiver. Network connected", Boolean.valueOf(c3985b4M5718S.f10563c));
                c3985b4M5718S.f10562b = true;
            }
            m5719T().m5659s();
            return;
        }
        long jM5648a3 = this.f10906k.m5946o().f10638h.m5648a();
        long jMax6 = Math.max(0L, C4142p.f11095r.m5693a(null).longValue());
        if (!m5713N().m5838N(jM5648a3, jMax6)) {
            jMax2 = Math.max(jMax2, jM5648a3 + jMax6);
        }
        m5718S().m5501a();
        Objects.requireNonNull((C3401c) this.f10906k.f11267o);
        long jCurrentTimeMillis2 = jMax2 - System.currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, C4142p.f11105w.m5693a(null).longValue());
            C4057h4 c4057h4 = this.f10906k.m5946o().f10636f;
            Objects.requireNonNull((C3401c) this.f10906k.f11267o);
            c4057h4.m5649b(System.currentTimeMillis());
        }
        this.f10906k.mo5726g().f11149n.m5861b("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        C4062h9 c4062h9M5719T = m5719T();
        c4062h9M5719T.m5684n();
        Context context = c4062h9M5719T.f11202a.f11254b;
        if (!C4125n4.m5761a(context)) {
            c4062h9M5719T.mo5726g().f11148m.m5860a("Receiver not registered/enabled");
        }
        if (!C4196t9.m5874U(context)) {
            c4062h9M5719T.mo5726g().f11148m.m5860a("Service not registered/enabled");
        }
        c4062h9M5719T.m5659s();
        c4062h9M5719T.mo5726g().f11149n.m5861b("Scheduling upload, millis", Long.valueOf(jCurrentTimeMillis2));
        Objects.requireNonNull((C3401c) c4062h9M5719T.f11202a.f11267o);
        long jElapsedRealtime = SystemClock.elapsedRealtime() + jCurrentTimeMillis2;
        if (jCurrentTimeMillis2 < Math.max(0L, C4142p.f11107x.m5693a(null).longValue())) {
            if (!(c4062h9M5719T.f10794e.f10801d != 0)) {
                c4062h9M5719T.f10794e.m5663b(jCurrentTimeMillis2);
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            c4062h9M5719T.f10793d.setInexactRepeating(2, jElapsedRealtime, Math.max(C4142p.f11097s.m5693a(null).longValue(), jCurrentTimeMillis2), c4062h9M5719T.m5661u());
            return;
        }
        Context context2 = c4062h9M5719T.f11202a.f11254b;
        ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iM5660t = c4062h9M5719T.m5660t();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder(iM5660t, componentName).setMinimumLatency(jCurrentTimeMillis2).setOverrideDeadline(jCurrentTimeMillis2 << 1).setExtras(persistableBundle).build();
        Method method = C3582a4.f9846a;
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        if (C3582a4.f9846a == null || context2.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            jobScheduler.schedule(jobInfoBuild);
            return;
        }
        Method method2 = C3582a4.f9847b;
        if (method2 != null) {
            try {
                iIntValue = ((Integer) method2.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        } else {
            iIntValue = 0;
        }
        Method method3 = C3582a4.f9846a;
        if (method3 != null) {
            try {
                ((Integer) method3.invoke(jobScheduler, jobInfoBuild, "com.google.android.gms", Integer.valueOf(iIntValue), "UploadAlarm")).intValue();
                return;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e("UploadAlarm", "error calling scheduleAsPackage", e2);
            }
        }
        jobScheduler.schedule(jobInfoBuild);
    }

    @WorkerThread
    /* renamed from: x */
    public final void m5743x() throws IllegalStateException {
        m5720U();
        if (this.f10913r || this.f10914s || this.f10915t) {
            this.f10906k.mo5726g().f11149n.m5863d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f10913r), Boolean.valueOf(this.f10914s), Boolean.valueOf(this.f10915t));
            return;
        }
        this.f10906k.mo5726g().f11149n.m5860a("Stopping uploading service(s)");
        List<Runnable> list = this.f10910o;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f10910o.clear();
    }

    @WorkerThread
    /* renamed from: y */
    public final zzn m5744y(String str) {
        C3973a4 c3973a4M5622T = m5710K().m5622T(str);
        if (c3973a4M5622T == null || TextUtils.isEmpty(c3973a4M5622T.m5459M())) {
            this.f10906k.mo5726g().f11148m.m5861b("No app data available; dropping", str);
            return null;
        }
        Boolean boolM5745z = m5745z(c3973a4M5622T);
        if (boolM5745z != null && !boolM5745z.booleanValue()) {
            this.f10906k.mo5726g().f11141f.m5861b("App version does not match; dropping. appId", C4157q3.m5788s(str));
            return null;
        }
        return new zzn(str, c3973a4M5622T.m5492v(), c3973a4M5622T.m5459M(), c3973a4M5622T.m5460N(), c3973a4M5622T.m5461O(), c3973a4M5622T.m5462P(), c3973a4M5622T.m5463Q(), (String) null, c3973a4M5622T.m5466T(), false, c3973a4M5622T.m5454H(), c3973a4M5622T.m5477g(), 0L, 0, c3973a4M5622T.m5478h(), c3973a4M5622T.m5479i(), false, c3973a4M5622T.m5495y(), c3973a4M5622T.m5480j(), c3973a4M5622T.m5465S(), c3973a4M5622T.m5481k(), (C3630da.m4644b() && this.f10906k.f11260h.m5532u(str, C4142p.f11080j0)) ? c3973a4M5622T.m5448B() : null, (C3842t8.m5293b() && this.f10906k.f11260h.m5526o(C4142p.f11039J0)) ? m5723a(str).m5568d() : "");
    }

    @WorkerThread
    /* renamed from: z */
    public final Boolean m5745z(C3973a4 c3973a4) {
        try {
            if (c3973a4.m5460N() != -2147483648L) {
                if (c3973a4.m5460N() == C3411b.m4376a(this.f10906k.f11254b).m4374b(c3973a4.m5485o(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = C3411b.m4376a(this.f10906k.f11254b).m4374b(c3973a4.m5485o(), 0).versionName;
                if (c3973a4.m5459M() != null && c3973a4.m5459M().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
