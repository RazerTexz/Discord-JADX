package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p257e3.LoadErrorHandlingPolicy;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2;
import p007b.p225i.p226a.p242c.p266w2.ErrorStateDrmSession;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;
import p007b.p225i.p226a.p242c.p266w2.FrameworkCryptoConfig;
import p007b.p225i.p226a.p242c.p266w2.MediaDrmCallback;
import p007b.p225i.p226a.p242c.p266w2.RunnableC2971d;
import p007b.p225i.p226a.p242c.p266w2.RunnableC2973e;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.Collections2;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableSet2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

@RequiresApi(18)
/* loaded from: classes3.dex */
public class DefaultDrmSessionManager implements DrmSessionManager2 {

    /* renamed from: b */
    public final UUID f19815b;

    /* renamed from: c */
    public final ExoMediaDrm.c f19816c;

    /* renamed from: d */
    public final MediaDrmCallback f19817d;

    /* renamed from: e */
    public final HashMap<String, String> f19818e;

    /* renamed from: f */
    public final boolean f19819f;

    /* renamed from: g */
    public final int[] f19820g;

    /* renamed from: h */
    public final boolean f19821h;

    /* renamed from: i */
    public final C10708e f19822i;

    /* renamed from: j */
    public final LoadErrorHandlingPolicy f19823j;

    /* renamed from: k */
    public final C10709f f19824k;

    /* renamed from: l */
    public final long f19825l;

    /* renamed from: m */
    public final List<DefaultDrmSession> f19826m;

    /* renamed from: n */
    public final Set<C10707d> f19827n;

    /* renamed from: o */
    public final Set<DefaultDrmSession> f19828o;

    /* renamed from: p */
    public int f19829p;

    /* renamed from: q */
    @Nullable
    public ExoMediaDrm f19830q;

    /* renamed from: r */
    @Nullable
    public DefaultDrmSession f19831r;

    /* renamed from: s */
    @Nullable
    public DefaultDrmSession f19832s;

    /* renamed from: t */
    public Looper f19833t;

    /* renamed from: u */
    public Handler f19834u;

    /* renamed from: v */
    public int f19835v;

    /* renamed from: w */
    @Nullable
    public byte[] f19836w;

    /* renamed from: x */
    @Nullable
    public volatile HandlerC10706c f19837x;

    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public MissingSchemeDataException(UUID uuid, C10704a c10704a) {
            String strValueOf = String.valueOf(uuid);
            super(outline.m857j(strValueOf.length() + 29, "Media does not support uuid: ", strValueOf));
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$b */
    public class C10705b implements ExoMediaDrm.b {
        public C10705b(C10704a c10704a) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$c */
    public class HandlerC10706c extends Handler {
        public HandlerC10706c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f19826m) {
                if (Arrays.equals(defaultDrmSession.f19803t, bArr)) {
                    if (message.what == 2 && defaultDrmSession.f19788e == 0 && defaultDrmSession.f19797n == 4) {
                        int i = Util2.f6708a;
                        defaultDrmSession.m8816i(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$d */
    public class C10707d implements DrmSessionManager2.b {

        /* renamed from: b */
        @Nullable
        public final DrmSessionEventListener.a f19840b;

        /* renamed from: c */
        @Nullable
        public DrmSession f19841c;

        /* renamed from: d */
        public boolean f19842d;

        public C10707d(@Nullable DrmSessionEventListener.a aVar) {
            this.f19840b = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2.b
        public void release() {
            Handler handler = DefaultDrmSessionManager.this.f19834u;
            Objects.requireNonNull(handler);
            Util2.m2984E(handler, new RunnableC2971d(this));
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$e */
    public class C10708e implements DefaultDrmSession.InterfaceC10699a {

        /* renamed from: a */
        public final Set<DefaultDrmSession> f19844a = new HashSet();

        /* renamed from: b */
        @Nullable
        public DefaultDrmSession f19845b;

        /* renamed from: a */
        public void m8834a(Exception exc, boolean z2) {
            this.f19845b = null;
            ImmutableList2 immutableList2M6264n = ImmutableList2.m6264n(this.f19844a);
            this.f19844a.clear();
            AbstractIndexedListIterator abstractIndexedListIteratorM6268p = immutableList2M6264n.m6268p();
            while (abstractIndexedListIteratorM6268p.hasNext()) {
                ((DefaultDrmSession) abstractIndexedListIteratorM6268p.next()).m8818k(exc, z2 ? 1 : 3);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$f */
    public class C10709f implements DefaultDrmSession.InterfaceC10700b {
        public C10709f(C10704a c10704a) {
        }
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.c cVar, MediaDrmCallback mediaDrmCallback, HashMap map, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, C10704a c10704a) {
        Objects.requireNonNull(uuid);
        AnimatableValueParser.m543m(!C.f8022b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f19815b = uuid;
        this.f19816c = cVar;
        this.f19817d = mediaDrmCallback;
        this.f19818e = map;
        this.f19819f = z2;
        this.f19820g = iArr;
        this.f19821h = z3;
        this.f19823j = loadErrorHandlingPolicy;
        this.f19822i = new C10708e();
        this.f19824k = new C10709f(null);
        this.f19835v = 0;
        this.f19826m = new ArrayList();
        this.f19827n = Collections2.m6240c();
        this.f19828o = Collections2.m6240c();
        this.f19825l = j;
    }

    /* renamed from: f */
    public static boolean m8825f(DrmSession drmSession) {
        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.f19797n == 1) {
            if (Util2.f6708a < 19) {
                return true;
            }
            DrmSession.DrmSessionException drmSessionExceptionMo3611f = defaultDrmSession.mo3611f();
            Objects.requireNonNull(drmSessionExceptionMo3611f);
            if (drmSessionExceptionMo3611f.getCause() instanceof ResourceBusyException) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static List<DrmInitData.SchemeData> m8826i(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.f19850m);
        for (int i = 0; i < drmInitData.f19850m; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.f19847j[i];
            if ((schemeData.m8836a(uuid) || (C.f8023c.equals(uuid) && schemeData.m8836a(C.f8022b))) && (schemeData.f19855n != null || z2)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
    /* renamed from: a */
    public final void mo3597a() {
        int i = this.f19829p;
        this.f19829p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f19830q == null) {
            ExoMediaDrm exoMediaDrmMo3581a = this.f19816c.mo3581a(this.f19815b);
            this.f19830q = exoMediaDrmMo3581a;
            exoMediaDrmMo3581a.mo3576h(new C10705b(null));
        } else if (this.f19825l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.f19826m.size(); i2++) {
                this.f19826m.get(i2).mo3606a(null);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
    /* renamed from: b */
    public DrmSessionManager2.b mo3598b(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2) {
        AnimatableValueParser.m426D(this.f19829p > 0);
        m8830j(looper);
        C10707d c10707d = new C10707d(aVar);
        Handler handler = this.f19834u;
        Objects.requireNonNull(handler);
        handler.post(new RunnableC2973e(c10707d, format2));
        return c10707d;
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
    @Nullable
    /* renamed from: c */
    public DrmSession mo3599c(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2) {
        AnimatableValueParser.m426D(this.f19829p > 0);
        m8830j(looper);
        return m8827e(looper, aVar, format2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3600d(Format2 format2) {
        String str;
        ExoMediaDrm exoMediaDrm = this.f19830q;
        Objects.requireNonNull(exoMediaDrm);
        int iMo3580l = exoMediaDrm.mo3580l();
        DrmInitData drmInitData = format2.f7158z;
        boolean z2 = false;
        if (drmInitData == null) {
            int iM3049g = MimeTypes.m3049g(format2.f7155w);
            int[] iArr = this.f19820g;
            int i = Util2.f6708a;
            int i2 = 0;
            while (true) {
                if (i2 >= iArr.length) {
                    i2 = -1;
                    break;
                }
                if (iArr[i2] == iM3049g) {
                    break;
                }
                i2++;
            }
            if (i2 != -1) {
                return iMo3580l;
            }
            return 0;
        }
        if (this.f19836w == null) {
            if (!((ArrayList) m8826i(drmInitData, this.f19815b, true)).isEmpty()) {
                str = drmInitData.f19849l;
                if (str != null || "cenc".equals(str) || (!"cbcs".equals(str) ? !("cbc1".equals(str) || "cens".equals(str)) : Util2.f6708a >= 25)) {
                    z2 = true;
                }
            } else if (drmInitData.f19850m == 1 && drmInitData.f19847j[0].m8836a(C.f8022b)) {
                String strValueOf = String.valueOf(this.f19815b);
                outline.m854h0(strValueOf.length() + 72, "DrmInitData only contains common PSSH SchemeData. Assuming support for: ", strValueOf, "DefaultDrmSessionMgr");
                str = drmInitData.f19849l;
                if (str != null) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            return iMo3580l;
        }
        return 1;
    }

    @Nullable
    /* renamed from: e */
    public final DrmSession m8827e(Looper looper, @Nullable DrmSessionEventListener.a aVar, Format2 format2, boolean z2) {
        List<DrmInitData.SchemeData> listM8826i;
        if (this.f19837x == null) {
            this.f19837x = new HandlerC10706c(looper);
        }
        DrmInitData drmInitData = format2.f7158z;
        DefaultDrmSession defaultDrmSessionM8829h = null;
        int i = 0;
        if (drmInitData == null) {
            int iM3049g = MimeTypes.m3049g(format2.f7155w);
            ExoMediaDrm exoMediaDrm = this.f19830q;
            Objects.requireNonNull(exoMediaDrm);
            if (exoMediaDrm.mo3580l() == 2 && FrameworkCryptoConfig.f7972a) {
                return null;
            }
            int[] iArr = this.f19820g;
            int i2 = Util2.f6708a;
            while (true) {
                if (i >= iArr.length) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iM3049g) {
                    break;
                }
                i++;
            }
            if (i == -1 || exoMediaDrm.mo3580l() == 1) {
                return null;
            }
            DefaultDrmSession defaultDrmSession = this.f19831r;
            if (defaultDrmSession == null) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
                DefaultDrmSession defaultDrmSessionM8829h2 = m8829h(RegularImmutableList.f12012l, true, null, z2);
                this.f19826m.add(defaultDrmSessionM8829h2);
                this.f19831r = defaultDrmSessionM8829h2;
            } else {
                defaultDrmSession.mo3606a(null);
            }
            return this.f19831r;
        }
        if (this.f19836w == null) {
            listM8826i = m8826i(drmInitData, this.f19815b, false);
            if (((ArrayList) listM8826i).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f19815b, null);
                Log2.m3039b("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.m3591e(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listM8826i = null;
        }
        if (this.f19819f) {
            Iterator<DefaultDrmSession> it = this.f19826m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util2.m2993a(next.f19784a, listM8826i)) {
                    defaultDrmSessionM8829h = next;
                    break;
                }
            }
        } else {
            defaultDrmSessionM8829h = this.f19832s;
        }
        if (defaultDrmSessionM8829h == null) {
            defaultDrmSessionM8829h = m8829h(listM8826i, false, aVar, z2);
            if (!this.f19819f) {
                this.f19832s = defaultDrmSessionM8829h;
            }
            this.f19826m.add(defaultDrmSessionM8829h);
        } else {
            defaultDrmSessionM8829h.mo3606a(aVar);
        }
        return defaultDrmSessionM8829h;
    }

    /* renamed from: g */
    public final DefaultDrmSession m8828g(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.a aVar) {
        Objects.requireNonNull(this.f19830q);
        boolean z3 = this.f19821h | z2;
        UUID uuid = this.f19815b;
        ExoMediaDrm exoMediaDrm = this.f19830q;
        C10708e c10708e = this.f19822i;
        C10709f c10709f = this.f19824k;
        int i = this.f19835v;
        byte[] bArr = this.f19836w;
        HashMap<String, String> map = this.f19818e;
        MediaDrmCallback mediaDrmCallback = this.f19817d;
        Looper looper = this.f19833t;
        Objects.requireNonNull(looper);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(uuid, exoMediaDrm, c10708e, c10709f, list, i, z3, z2, bArr, map, mediaDrmCallback, looper, this.f19823j);
        defaultDrmSession.mo3606a(aVar);
        if (this.f19825l != -9223372036854775807L) {
            defaultDrmSession.mo3606a(null);
        }
        return defaultDrmSession;
    }

    /* renamed from: h */
    public final DefaultDrmSession m8829h(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.a aVar, boolean z3) {
        DefaultDrmSession defaultDrmSessionM8828g = m8828g(list, z2, aVar);
        if (m8825f(defaultDrmSessionM8828g) && !this.f19828o.isEmpty()) {
            m8832l();
            defaultDrmSessionM8828g.mo3607b(aVar);
            if (this.f19825l != -9223372036854775807L) {
                defaultDrmSessionM8828g.mo3607b(null);
            }
            defaultDrmSessionM8828g = m8828g(list, z2, aVar);
        }
        if (!m8825f(defaultDrmSessionM8828g) || !z3 || this.f19827n.isEmpty()) {
            return defaultDrmSessionM8828g;
        }
        m8833m();
        if (!this.f19828o.isEmpty()) {
            m8832l();
        }
        defaultDrmSessionM8828g.mo3607b(aVar);
        if (this.f19825l != -9223372036854775807L) {
            defaultDrmSessionM8828g.mo3607b(null);
        }
        return m8828g(list, z2, aVar);
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    /* renamed from: j */
    public final synchronized void m8830j(Looper looper) {
        Looper looper2 = this.f19833t;
        if (looper2 == null) {
            this.f19833t = looper;
            this.f19834u = new Handler(looper);
        } else {
            AnimatableValueParser.m426D(looper2 == looper);
            Objects.requireNonNull(this.f19834u);
        }
    }

    /* renamed from: k */
    public final void m8831k() {
        if (this.f19830q != null && this.f19829p == 0 && this.f19826m.isEmpty() && this.f19827n.isEmpty()) {
            ExoMediaDrm exoMediaDrm = this.f19830q;
            Objects.requireNonNull(exoMediaDrm);
            exoMediaDrm.release();
            this.f19830q = null;
        }
    }

    /* renamed from: l */
    public final void m8832l() {
        Iterator itMo6251j = ImmutableSet2.m6281m(this.f19828o).mo6251j();
        while (itMo6251j.hasNext()) {
            ((DrmSession) itMo6251j.next()).mo3607b(null);
        }
    }

    /* renamed from: m */
    public final void m8833m() {
        Iterator itMo6251j = ImmutableSet2.m6281m(this.f19827n).mo6251j();
        while (itMo6251j.hasNext()) {
            C10707d c10707d = (C10707d) itMo6251j.next();
            Handler handler = DefaultDrmSessionManager.this.f19834u;
            Objects.requireNonNull(handler);
            Util2.m2984E(handler, new RunnableC2971d(c10707d));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2
    public final void release() {
        int i = this.f19829p - 1;
        this.f19829p = i;
        if (i != 0) {
            return;
        }
        if (this.f19825l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f19826m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).mo3607b(null);
            }
        }
        m8833m();
        m8831k();
    }
}
