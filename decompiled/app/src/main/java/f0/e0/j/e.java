package f0.e0.j;

import f0.e0.j.m;
import f0.e0.j.n;
import f0.e0.k.h;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: Http2Connection.kt */
/* loaded from: classes3.dex */
public final class e implements Closeable {
    public static final s j;
    public static final e k = null;
    public long A;
    public long B;
    public long C;
    public final s D;
    public s E;
    public long F;
    public long G;
    public long H;
    public long I;
    public final Socket J;
    public final o K;
    public final d L;
    public final Set<Integer> M;
    public final boolean l;
    public final c m;
    public final Map<Integer, n> n;
    public final String o;
    public int p;
    public int q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final f0.e0.f.d f3638s;
    public final f0.e0.f.c t;
    public final f0.e0.f.c u;
    public final f0.e0.f.c v;
    public final r w;

    /* renamed from: x, reason: collision with root package name */
    public long f3639x;

    /* renamed from: y, reason: collision with root package name */
    public long f3640y;

    /* renamed from: z, reason: collision with root package name */
    public long f3641z;

    /* compiled from: TaskQueue.kt */
    public static final class a extends f0.e0.f.a {
        public final /* synthetic */ e e;
        public final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, e eVar, long j) {
            super(str2, true);
            this.e = eVar;
            this.f = j;
        }

        @Override // f0.e0.f.a
        public long a() {
            e eVar;
            boolean z2;
            synchronized (this.e) {
                eVar = this.e;
                long j = eVar.f3640y;
                long j2 = eVar.f3639x;
                if (j < j2) {
                    z2 = true;
                } else {
                    eVar.f3639x = j2 + 1;
                    z2 = false;
                }
            }
            if (!z2) {
                eVar.q(false, 1, 0);
                return this.f;
            }
            f0.e0.j.a aVar = f0.e0.j.a.PROTOCOL_ERROR;
            eVar.a(aVar, aVar, null);
            return -1L;
        }
    }

    /* compiled from: Http2Connection.kt */
    public static final class b {
        public Socket a;

        /* renamed from: b, reason: collision with root package name */
        public String f3642b;
        public g0.g c;
        public BufferedSink d;
        public c e;
        public r f;
        public int g;
        public boolean h;
        public final f0.e0.f.d i;

        public b(boolean z2, f0.e0.f.d dVar) {
            d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
            this.h = z2;
            this.i = dVar;
            this.e = c.a;
            this.f = r.a;
        }
    }

    /* compiled from: Http2Connection.kt */
    public static abstract class c {
        public static final c a = new a();

        /* compiled from: Http2Connection.kt */
        public static final class a extends c {
            @Override // f0.e0.j.e.c
            public void b(n nVar) throws IOException {
                d0.z.d.m.checkParameterIsNotNull(nVar, "stream");
                nVar.c(f0.e0.j.a.REFUSED_STREAM, null);
            }
        }

        public void a(e eVar, s sVar) {
            d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
            d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
        }

        public abstract void b(n nVar) throws IOException;
    }

    /* compiled from: Http2Connection.kt */
    public final class d implements m.b, Function0<Unit> {
        public final m j;
        public final /* synthetic */ e k;

        /* compiled from: TaskQueue.kt */
        public static final class a extends f0.e0.f.a {
            public final /* synthetic */ n e;
            public final /* synthetic */ d f;
            public final /* synthetic */ List g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z2, String str2, boolean z3, n nVar, d dVar, n nVar2, int i, List list, boolean z4) {
                super(str2, z3);
                this.e = nVar;
                this.f = dVar;
                this.g = list;
            }

            @Override // f0.e0.f.a
            public long a() {
                try {
                    this.f.k.m.b(this.e);
                    return -1L;
                } catch (IOException e) {
                    h.a aVar = f0.e0.k.h.c;
                    f0.e0.k.h hVar = f0.e0.k.h.a;
                    StringBuilder sbU = b.d.b.a.a.U("Http2Connection.Listener failure for ");
                    sbU.append(this.f.k.o);
                    hVar.i(sbU.toString(), 4, e);
                    try {
                        this.e.c(f0.e0.j.a.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* compiled from: TaskQueue.kt */
        public static final class b extends f0.e0.f.a {
            public final /* synthetic */ d e;
            public final /* synthetic */ int f;
            public final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z2, String str2, boolean z3, d dVar, int i, int i2) {
                super(str2, z3);
                this.e = dVar;
                this.f = i;
                this.g = i2;
            }

            @Override // f0.e0.f.a
            public long a() {
                this.e.k.q(true, this.f, this.g);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        public static final class c extends f0.e0.f.a {
            public final /* synthetic */ d e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ s g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z2, String str2, boolean z3, d dVar, boolean z4, s sVar) {
                super(str2, z3);
                this.e = dVar;
                this.f = z4;
                this.g = sVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, f0.e0.j.s, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, f0.e0.j.s] */
            @Override // f0.e0.f.a
            public long a() throws Throwable {
                o oVar;
                e eVar;
                T t;
                f0.e0.f.c cVar;
                String str;
                d dVar = this.e;
                boolean z2 = this.f;
                ?? r10 = this.g;
                Objects.requireNonNull(dVar);
                d0.z.d.m.checkParameterIsNotNull(r10, "settings");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                o oVar2 = dVar.k.K;
                synchronized (oVar2) {
                    try {
                        e eVar2 = dVar.k;
                        try {
                            synchronized (eVar2) {
                                try {
                                    s sVar = dVar.k.E;
                                    if (z2) {
                                        ref$ObjectRef2.element = r10;
                                    } else {
                                        ?? sVar2 = new s();
                                        sVar2.b(sVar);
                                        sVar2.b(r10);
                                        ref$ObjectRef2.element = sVar2;
                                    }
                                    long jA = ((s) ref$ObjectRef2.element).a() - sVar.a();
                                    ref$LongRef.element = jA;
                                    if (jA == 0 || dVar.k.n.isEmpty()) {
                                        t = 0;
                                    } else {
                                        Object[] array = dVar.k.n.values().toArray(new n[0]);
                                        if (array == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                        t = (n[]) array;
                                    }
                                    ref$ObjectRef.element = t;
                                    e eVar3 = dVar.k;
                                    s sVar3 = (s) ref$ObjectRef2.element;
                                    Objects.requireNonNull(eVar3);
                                    d0.z.d.m.checkParameterIsNotNull(sVar3, "<set-?>");
                                    eVar3.E = sVar3;
                                    cVar = dVar.k.v;
                                    str = dVar.k.o + " onSettings";
                                    eVar = eVar2;
                                    oVar = oVar2;
                                } catch (Throwable th) {
                                    th = th;
                                    eVar = eVar2;
                                }
                                try {
                                    cVar.c(new f0.e0.j.f(str, true, str, true, dVar, z2, ref$ObjectRef2, r10, ref$LongRef, ref$ObjectRef), 0L);
                                    try {
                                        dVar.k.K.a((s) ref$ObjectRef2.element);
                                    } catch (IOException e) {
                                        e eVar4 = dVar.k;
                                        f0.e0.j.a aVar = f0.e0.j.a.PROTOCOL_ERROR;
                                        eVar4.a(aVar, aVar, e);
                                    }
                                    n[] nVarArr = (n[]) ref$ObjectRef.element;
                                    if (nVarArr == null) {
                                        return -1L;
                                    }
                                    if (nVarArr == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    for (n nVar : nVarArr) {
                                        synchronized (nVar) {
                                            long j = ref$LongRef.element;
                                            nVar.d += j;
                                            if (j > 0) {
                                                nVar.notifyAll();
                                            }
                                        }
                                    }
                                    return -1L;
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        oVar = oVar2;
                    }
                }
            }
        }

        public d(e eVar, m mVar) {
            d0.z.d.m.checkParameterIsNotNull(mVar, "reader");
            this.k = eVar;
            this.j = mVar;
        }

        @Override // f0.e0.j.m.b
        public void a() {
        }

        @Override // f0.e0.j.m.b
        public void b(boolean z2, s sVar) {
            d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
            f0.e0.f.c cVar = this.k.t;
            String strJ = b.d.b.a.a.J(new StringBuilder(), this.k.o, " applyAndAckSettings");
            cVar.c(new c(strJ, true, strJ, true, this, z2, sVar), 0L);
        }

        @Override // f0.e0.j.m.b
        public void c(boolean z2, int i, int i2, List<f0.e0.j.b> list) {
            d0.z.d.m.checkParameterIsNotNull(list, "headerBlock");
            if (this.k.c(i)) {
                e eVar = this.k;
                Objects.requireNonNull(eVar);
                d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
                f0.e0.f.c cVar = eVar.u;
                String str = eVar.o + '[' + i + "] onHeaders";
                cVar.c(new h(str, true, str, true, eVar, i, list, z2), 0L);
                return;
            }
            synchronized (this.k) {
                n nVarB = this.k.b(i);
                if (nVarB != null) {
                    nVarB.j(f0.e0.c.w(list), z2);
                    return;
                }
                e eVar2 = this.k;
                if (eVar2.r) {
                    return;
                }
                if (i <= eVar2.p) {
                    return;
                }
                if (i % 2 == eVar2.q % 2) {
                    return;
                }
                n nVar = new n(i, this.k, false, z2, f0.e0.c.w(list));
                e eVar3 = this.k;
                eVar3.p = i;
                eVar3.n.put(Integer.valueOf(i), nVar);
                f0.e0.f.c cVarF = this.k.f3638s.f();
                String str2 = this.k.o + '[' + i + "] onStream";
                cVarF.c(new a(str2, true, str2, true, nVar, this, nVarB, i, list, z2), 0L);
            }
        }

        @Override // f0.e0.j.m.b
        public void d(int i, long j) {
            if (i == 0) {
                synchronized (this.k) {
                    e eVar = this.k;
                    eVar.I += j;
                    eVar.notifyAll();
                }
                return;
            }
            n nVarB = this.k.b(i);
            if (nVarB != null) {
                synchronized (nVarB) {
                    nVarB.d += j;
                    if (j > 0) {
                        nVarB.notifyAll();
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
        
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        
            if (r18 == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x010a, code lost:
        
            r3.j(f0.e0.c.f3605b, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        
            return;
         */
        @Override // f0.e0.j.m.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(boolean z2, int i, g0.g gVar, int i2) throws IOException {
            boolean z3;
            boolean z4;
            long j;
            d0.z.d.m.checkParameterIsNotNull(gVar, "source");
            if (!this.k.c(i)) {
                n nVarB = this.k.b(i);
                if (nVarB != null) {
                    d0.z.d.m.checkParameterIsNotNull(gVar, "source");
                    byte[] bArr = f0.e0.c.a;
                    n.b bVar = nVarB.g;
                    long j2 = i2;
                    Objects.requireNonNull(bVar);
                    d0.z.d.m.checkParameterIsNotNull(gVar, "source");
                    while (true) {
                        boolean z5 = true;
                        if (j2 <= 0) {
                            break;
                        }
                        synchronized (n.this) {
                            z3 = bVar.n;
                            z4 = bVar.k.k + j2 > bVar.m;
                        }
                        if (z4) {
                            gVar.skip(j2);
                            n.this.e(f0.e0.j.a.FLOW_CONTROL_ERROR);
                            break;
                        }
                        if (z3) {
                            gVar.skip(j2);
                            break;
                        }
                        long jI0 = gVar.i0(bVar.j, j2);
                        if (jI0 == -1) {
                            throw new EOFException();
                        }
                        j2 -= jI0;
                        synchronized (n.this) {
                            if (bVar.l) {
                                g0.e eVar = bVar.j;
                                j = eVar.k;
                                eVar.skip(j);
                            } else {
                                g0.e eVar2 = bVar.k;
                                if (eVar2.k != 0) {
                                    z5 = false;
                                }
                                eVar2.P(bVar.j);
                                if (z5) {
                                    n nVar = n.this;
                                    if (nVar == null) {
                                        break;
                                    } else {
                                        nVar.notifyAll();
                                    }
                                }
                                j = 0;
                            }
                        }
                        if (j > 0) {
                            bVar.a(j);
                        }
                    }
                } else {
                    this.k.s(i, f0.e0.j.a.PROTOCOL_ERROR);
                    long j3 = i2;
                    this.k.f(j3);
                    gVar.skip(j3);
                }
            } else {
                e eVar3 = this.k;
                Objects.requireNonNull(eVar3);
                d0.z.d.m.checkParameterIsNotNull(gVar, "source");
                g0.e eVar4 = new g0.e();
                long j4 = i2;
                gVar.p0(j4);
                gVar.i0(eVar4, j4);
                f0.e0.f.c cVar = eVar3.u;
                String str = eVar3.o + '[' + i + "] onData";
                cVar.c(new g(str, true, str, true, eVar3, i, eVar4, i2, z2), 0L);
            }
        }

        @Override // f0.e0.j.m.b
        public void f(boolean z2, int i, int i2) {
            if (!z2) {
                f0.e0.f.c cVar = this.k.t;
                String strJ = b.d.b.a.a.J(new StringBuilder(), this.k.o, " ping");
                cVar.c(new b(strJ, true, strJ, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.k) {
                if (i == 1) {
                    this.k.f3640y++;
                } else if (i == 2) {
                    this.k.A++;
                } else if (i == 3) {
                    e eVar = this.k;
                    eVar.B++;
                    eVar.notifyAll();
                }
            }
        }

        @Override // f0.e0.j.m.b
        public void g(int i, int i2, int i3, boolean z2) {
        }

        @Override // f0.e0.j.m.b
        public void h(int i, f0.e0.j.a aVar) {
            d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
            if (!this.k.c(i)) {
                n nVarD = this.k.d(i);
                if (nVarD != null) {
                    nVarD.k(aVar);
                    return;
                }
                return;
            }
            e eVar = this.k;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
            f0.e0.f.c cVar = eVar.u;
            String str = eVar.o + '[' + i + "] onReset";
            cVar.c(new j(str, true, str, true, eVar, i, aVar), 0L);
        }

        @Override // f0.e0.j.m.b
        public void i(int i, int i2, List<f0.e0.j.b> list) {
            d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
            e eVar = this.k;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(list, "requestHeaders");
            synchronized (eVar) {
                if (eVar.M.contains(Integer.valueOf(i2))) {
                    eVar.s(i2, f0.e0.j.a.PROTOCOL_ERROR);
                    return;
                }
                eVar.M.add(Integer.valueOf(i2));
                f0.e0.f.c cVar = eVar.u;
                String str = eVar.o + '[' + i2 + "] onRequest";
                cVar.c(new i(str, true, str, true, eVar, i2, list), 0L);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [f0.e0.j.a] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws Throwable {
            Throwable th;
            f0.e0.j.a aVar;
            f0.e0.j.a aVar2 = f0.e0.j.a.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.j.b(this);
                    while (this.j.a(false, this)) {
                    }
                    f0.e0.j.a aVar3 = f0.e0.j.a.NO_ERROR;
                    try {
                        this.k.a(aVar3, f0.e0.j.a.CANCEL, null);
                        aVar = aVar3;
                    } catch (IOException e2) {
                        e = e2;
                        f0.e0.j.a aVar4 = f0.e0.j.a.PROTOCOL_ERROR;
                        e eVar = this.k;
                        eVar.a(aVar4, aVar4, e);
                        aVar = eVar;
                        f0.e0.c.d(this.j);
                        aVar2 = Unit.a;
                        return aVar2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.k.a(aVar, aVar2, e);
                    f0.e0.c.d(this.j);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                aVar = aVar2;
                this.k.a(aVar, aVar2, e);
                f0.e0.c.d(this.j);
                throw th;
            }
            f0.e0.c.d(this.j);
            aVar2 = Unit.a;
            return aVar2;
        }

        @Override // f0.e0.j.m.b
        public void j(int i, f0.e0.j.a aVar, ByteString byteString) {
            int i2;
            n[] nVarArr;
            d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
            d0.z.d.m.checkParameterIsNotNull(byteString, "debugData");
            byteString.j();
            synchronized (this.k) {
                Object[] array = this.k.n.values().toArray(new n[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                nVarArr = (n[]) array;
                this.k.r = true;
            }
            for (n nVar : nVarArr) {
                if (nVar.m > i && nVar.h()) {
                    nVar.k(f0.e0.j.a.REFUSED_STREAM);
                    this.k.d(nVar.m);
                }
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: f0.e0.j.e$e, reason: collision with other inner class name */
    public static final class C0608e extends f0.e0.f.a {
        public final /* synthetic */ e e;
        public final /* synthetic */ int f;
        public final /* synthetic */ f0.e0.j.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0608e(String str, boolean z2, String str2, boolean z3, e eVar, int i, f0.e0.j.a aVar) {
            super(str2, z3);
            this.e = eVar;
            this.f = i;
            this.g = aVar;
        }

        @Override // f0.e0.f.a
        public long a() {
            try {
                e eVar = this.e;
                int i = this.f;
                f0.e0.j.a aVar = this.g;
                Objects.requireNonNull(eVar);
                d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
                eVar.K.n(i, aVar);
                return -1L;
            } catch (IOException e) {
                e eVar2 = this.e;
                f0.e0.j.a aVar2 = f0.e0.j.a.PROTOCOL_ERROR;
                eVar2.a(aVar2, aVar2, e);
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    public static final class f extends f0.e0.f.a {
        public final /* synthetic */ e e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, e eVar, int i, long j) {
            super(str2, z3);
            this.e = eVar;
            this.f = i;
            this.g = j;
        }

        @Override // f0.e0.f.a
        public long a() {
            try {
                this.e.K.q(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                e eVar = this.e;
                f0.e0.j.a aVar = f0.e0.j.a.PROTOCOL_ERROR;
                eVar.a(aVar, aVar, e);
                return -1L;
            }
        }
    }

    static {
        s sVar = new s();
        sVar.c(7, 65535);
        sVar.c(5, 16384);
        j = sVar;
    }

    public e(b bVar) {
        d0.z.d.m.checkParameterIsNotNull(bVar, "builder");
        boolean z2 = bVar.h;
        this.l = z2;
        this.m = bVar.e;
        this.n = new LinkedHashMap();
        String str = bVar.f3642b;
        if (str == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("connectionName");
        }
        this.o = str;
        this.q = bVar.h ? 3 : 2;
        f0.e0.f.d dVar = bVar.i;
        this.f3638s = dVar;
        f0.e0.f.c cVarF = dVar.f();
        this.t = cVarF;
        this.u = dVar.f();
        this.v = dVar.f();
        this.w = bVar.f;
        s sVar = new s();
        if (bVar.h) {
            sVar.c(7, 16777216);
        }
        this.D = sVar;
        this.E = j;
        this.I = r2.a();
        Socket socket = bVar.a;
        if (socket == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("socket");
        }
        this.J = socket;
        BufferedSink bufferedSink = bVar.d;
        if (bufferedSink == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("sink");
        }
        this.K = new o(bufferedSink, z2);
        g0.g gVar = bVar.c;
        if (gVar == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("source");
        }
        this.L = new d(this, new m(gVar, z2));
        this.M = new LinkedHashSet();
        int i = bVar.g;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            String strW = b.d.b.a.a.w(str, " ping");
            cVarF.c(new a(strW, strW, this, nanos), nanos);
        }
    }

    public final void a(f0.e0.j.a aVar, f0.e0.j.a aVar2, IOException iOException) {
        int i;
        d0.z.d.m.checkParameterIsNotNull(aVar, "connectionCode");
        d0.z.d.m.checkParameterIsNotNull(aVar2, "streamCode");
        byte[] bArr = f0.e0.c.a;
        try {
            e(aVar);
        } catch (IOException unused) {
        }
        n[] nVarArr = null;
        synchronized (this) {
            if (!this.n.isEmpty()) {
                Object[] array = this.n.values().toArray(new n[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                nVarArr = (n[]) array;
                this.n.clear();
            }
        }
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                try {
                    nVar.c(aVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.K.close();
        } catch (IOException unused3) {
        }
        try {
            this.J.close();
        } catch (IOException unused4) {
        }
        this.t.f();
        this.u.f();
        this.v.f();
    }

    public final synchronized n b(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    public final boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(f0.e0.j.a.NO_ERROR, f0.e0.j.a.CANCEL, null);
    }

    public final synchronized n d(int i) {
        n nVarRemove;
        nVarRemove = this.n.remove(Integer.valueOf(i));
        notifyAll();
        return nVarRemove;
    }

    public final void e(f0.e0.j.a aVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
        synchronized (this.K) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.K.d(this.p, aVar, f0.e0.c.a);
            }
        }
    }

    public final synchronized void f(long j2) {
        long j3 = this.F + j2;
        this.F = j3;
        long j4 = j3 - this.G;
        if (j4 >= this.D.a() / 2) {
            t(0, j4);
            this.G += j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r5 = (int) java.lang.Math.min(r13, r6 - r4);
        r3.element = r5;
        r4 = java.lang.Math.min(r5, r9.K.l);
        r3.element = r4;
        r9.H += r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, boolean z2, g0.e eVar, long j2) throws IOException {
        int iMin;
        if (j2 == 0) {
            this.K.b(z2, i, eVar, 0);
            return;
        }
        while (j2 > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (true) {
                    try {
                        long j3 = this.H;
                        long j4 = this.I;
                        if (j3 < j4) {
                            break;
                        } else {
                            if (!this.n.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j2 -= iMin;
            this.K.b(z2 && j2 == 0, i, eVar, iMin);
        }
    }

    public final void q(boolean z2, int i, int i2) {
        try {
            this.K.f(z2, i, i2);
        } catch (IOException e) {
            f0.e0.j.a aVar = f0.e0.j.a.PROTOCOL_ERROR;
            a(aVar, aVar, e);
        }
    }

    public final void s(int i, f0.e0.j.a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        f0.e0.f.c cVar = this.t;
        String str = this.o + '[' + i + "] writeSynReset";
        cVar.c(new C0608e(str, true, str, true, this, i, aVar), 0L);
    }

    public final void t(int i, long j2) {
        f0.e0.f.c cVar = this.t;
        String str = this.o + '[' + i + "] windowUpdate";
        cVar.c(new f(str, true, str, true, this, i, j2), 0L);
    }
}
