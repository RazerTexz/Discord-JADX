package p600f0.p601e0.p608j;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.Task2;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p608j.Http2Reader;
import p600f0.p601e0.p608j.Http2Stream;
import p600f0.p601e0.p609k.Platform2;
import p615g0.Buffer3;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.e0.j.e, reason: use source file name */
/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final Settings3 f25615j;

    /* JADX INFO: renamed from: k */
    public static final Http2Connection f25616k = null;

    /* JADX INFO: renamed from: A */
    public long f25617A;

    /* JADX INFO: renamed from: B */
    public long f25618B;

    /* JADX INFO: renamed from: C */
    public long f25619C;

    /* JADX INFO: renamed from: D */
    public final Settings3 f25620D;

    /* JADX INFO: renamed from: E */
    public Settings3 f25621E;

    /* JADX INFO: renamed from: F */
    public long f25622F;

    /* JADX INFO: renamed from: G */
    public long f25623G;

    /* JADX INFO: renamed from: H */
    public long f25624H;

    /* JADX INFO: renamed from: I */
    public long f25625I;

    /* JADX INFO: renamed from: J */
    public final Socket f25626J;

    /* JADX INFO: renamed from: K */
    public final Http2Writer f25627K;

    /* JADX INFO: renamed from: L */
    public final d f25628L;

    /* JADX INFO: renamed from: M */
    public final Set<Integer> f25629M;

    /* JADX INFO: renamed from: l */
    public final boolean f25630l;

    /* JADX INFO: renamed from: m */
    public final c f25631m;

    /* JADX INFO: renamed from: n */
    public final Map<Integer, Http2Stream> f25632n;

    /* JADX INFO: renamed from: o */
    public final String f25633o;

    /* JADX INFO: renamed from: p */
    public int f25634p;

    /* JADX INFO: renamed from: q */
    public int f25635q;

    /* JADX INFO: renamed from: r */
    public boolean f25636r;

    /* JADX INFO: renamed from: s */
    public final TaskRunner f25637s;

    /* JADX INFO: renamed from: t */
    public final TaskQueue2 f25638t;

    /* JADX INFO: renamed from: u */
    public final TaskQueue2 f25639u;

    /* JADX INFO: renamed from: v */
    public final TaskQueue2 f25640v;

    /* JADX INFO: renamed from: w */
    public final PushObserver2 f25641w;

    /* JADX INFO: renamed from: x */
    public long f25642x;

    /* JADX INFO: renamed from: y */
    public long f25643y;

    /* JADX INFO: renamed from: z */
    public long f25644z;

    /* JADX INFO: renamed from: f0.e0.j.e$a */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class a extends Task2 {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ Http2Connection f25645e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ long f25646f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Http2Connection http2Connection, long j) {
            super(str2, true);
            this.f25645e = http2Connection;
            this.f25646f = j;
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            Http2Connection http2Connection;
            boolean z2;
            synchronized (this.f25645e) {
                http2Connection = this.f25645e;
                long j = http2Connection.f25643y;
                long j2 = http2Connection.f25642x;
                if (j < j2) {
                    z2 = true;
                } else {
                    http2Connection.f25642x = j2 + 1;
                    z2 = false;
                }
            }
            if (!z2) {
                http2Connection.m10265q(false, 1, 0);
                return this.f25646f;
            }
            ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
            http2Connection.m10258a(errorCode2, errorCode2, null);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$b */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public Socket f25647a;

        /* JADX INFO: renamed from: b */
        public String f25648b;

        /* JADX INFO: renamed from: c */
        public BufferedSource f25649c;

        /* JADX INFO: renamed from: d */
        public BufferedSink f25650d;

        /* JADX INFO: renamed from: e */
        public c f25651e;

        /* JADX INFO: renamed from: f */
        public PushObserver2 f25652f;

        /* JADX INFO: renamed from: g */
        public int f25653g;

        /* JADX INFO: renamed from: h */
        public boolean f25654h;

        /* JADX INFO: renamed from: i */
        public final TaskRunner f25655i;

        public b(boolean z2, TaskRunner taskRunner) {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            this.f25654h = z2;
            this.f25655i = taskRunner;
            this.f25651e = c.f25656a;
            this.f25652f = PushObserver2.f25751a;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$c */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public static final c f25656a = new a();

        /* JADX INFO: renamed from: f0.e0.j.e$c$a */
        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class a extends c {
            @Override // p600f0.p601e0.p608j.Http2Connection.c
            /* JADX INFO: renamed from: b */
            public void mo10193b(Http2Stream http2Stream) throws IOException {
                Intrinsics3.checkParameterIsNotNull(http2Stream, "stream");
                http2Stream.m10284c(ErrorCode2.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo10192a(Http2Connection http2Connection, Settings3 settings3) {
            Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
            Intrinsics3.checkParameterIsNotNull(settings3, "settings");
        }

        /* JADX INFO: renamed from: b */
        public abstract void mo10193b(Http2Stream http2Stream) throws IOException;
    }

    /* JADX INFO: renamed from: f0.e0.j.e$d */
    /* JADX INFO: compiled from: Http2Connection.kt */
    public final class d implements Http2Reader.b, Function0<Unit> {

        /* JADX INFO: renamed from: j */
        public final Http2Reader f25657j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Http2Connection f25658k;

        /* JADX INFO: renamed from: f0.e0.j.e$d$a */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class a extends Task2 {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ Http2Stream f25659e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ d f25660f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ List f25661g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z2, String str2, boolean z3, Http2Stream http2Stream, d dVar, Http2Stream http2Stream2, int i, List list, boolean z4) {
                super(str2, z3);
                this.f25659e = http2Stream;
                this.f25660f = dVar;
                this.f25661g = list;
            }

            @Override // p600f0.p601e0.p604f.Task2
            /* JADX INFO: renamed from: a */
            public long mo10150a() {
                try {
                    this.f25660f.f25658k.f25631m.mo10193b(this.f25659e);
                    return -1L;
                } catch (IOException e) {
                    Platform2.a aVar = Platform2.f25785c;
                    Platform2 platform2 = Platform2.f25783a;
                    StringBuilder sbM833U = outline.m833U("Http2Connection.Listener failure for ");
                    sbM833U.append(this.f25660f.f25658k.f25633o);
                    platform2.m10330i(sbM833U.toString(), 4, e);
                    try {
                        this.f25659e.m10284c(ErrorCode2.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: f0.e0.j.e$d$b */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class b extends Task2 {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ d f25662e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ int f25663f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ int f25664g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z2, String str2, boolean z3, d dVar, int i, int i2) {
                super(str2, z3);
                this.f25662e = dVar;
                this.f25663f = i;
                this.f25664g = i2;
            }

            @Override // p600f0.p601e0.p604f.Task2
            /* JADX INFO: renamed from: a */
            public long mo10150a() {
                this.f25662e.f25658k.m10265q(true, this.f25663f, this.f25664g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: f0.e0.j.e$d$c */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class c extends Task2 {

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ d f25665e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ boolean f25666f;

            /* JADX INFO: renamed from: g */
            public final /* synthetic */ Settings3 f25667g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z2, String str2, boolean z3, d dVar, boolean z4, Settings3 settings3) {
                super(str2, z3);
                this.f25665e = dVar;
                this.f25666f = z4;
                this.f25667g = settings3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, f0.e0.j.s, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, f0.e0.j.s] */
            @Override // p600f0.p601e0.p604f.Task2
            /* JADX INFO: renamed from: a */
            public long mo10150a() throws Throwable {
                Http2Writer http2Writer;
                Http2Connection http2Connection;
                T t;
                TaskQueue2 taskQueue2;
                String str;
                d dVar = this.f25665e;
                boolean z2 = this.f25666f;
                ?? r10 = this.f25667g;
                Objects.requireNonNull(dVar);
                Intrinsics3.checkParameterIsNotNull(r10, "settings");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                Http2Writer http2Writer2 = dVar.f25658k.f25627K;
                synchronized (http2Writer2) {
                    try {
                        Http2Connection http2Connection2 = dVar.f25658k;
                        try {
                            synchronized (http2Connection2) {
                                try {
                                    Settings3 settings3 = dVar.f25658k.f25621E;
                                    if (z2) {
                                        ref$ObjectRef2.element = r10;
                                    } else {
                                        ?? settings32 = new Settings3();
                                        settings32.m10313b(settings3);
                                        settings32.m10313b(r10);
                                        ref$ObjectRef2.element = settings32;
                                    }
                                    long jM10312a = ((long) ((Settings3) ref$ObjectRef2.element).m10312a()) - ((long) settings3.m10312a());
                                    ref$LongRef.element = jM10312a;
                                    if (jM10312a == 0 || dVar.f25658k.f25632n.isEmpty()) {
                                        t = 0;
                                    } else {
                                        Object[] array = dVar.f25658k.f25632n.values().toArray(new Http2Stream[0]);
                                        if (array == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                        t = (Http2Stream[]) array;
                                    }
                                    ref$ObjectRef.element = t;
                                    Http2Connection http2Connection3 = dVar.f25658k;
                                    Settings3 settings33 = (Settings3) ref$ObjectRef2.element;
                                    Objects.requireNonNull(http2Connection3);
                                    Intrinsics3.checkParameterIsNotNull(settings33, "<set-?>");
                                    http2Connection3.f25621E = settings33;
                                    taskQueue2 = dVar.f25658k.f25640v;
                                    str = dVar.f25658k.f25633o + " onSettings";
                                    http2Connection = http2Connection2;
                                    http2Writer = http2Writer2;
                                } catch (Throwable th) {
                                    th = th;
                                    http2Connection = http2Connection2;
                                }
                                try {
                                    taskQueue2.m10154c(new TaskQueue3(str, true, str, true, dVar, z2, ref$ObjectRef2, r10, ref$LongRef, ref$ObjectRef), 0L);
                                    try {
                                        dVar.f25658k.f25627K.m10298a((Settings3) ref$ObjectRef2.element);
                                    } catch (IOException e) {
                                        Http2Connection http2Connection4 = dVar.f25658k;
                                        ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
                                        http2Connection4.m10258a(errorCode2, errorCode2, e);
                                    }
                                    Http2Stream[] http2StreamArr = (Http2Stream[]) ref$ObjectRef.element;
                                    if (http2StreamArr == null) {
                                        return -1L;
                                    }
                                    if (http2StreamArr == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    for (Http2Stream http2Stream : http2StreamArr) {
                                        synchronized (http2Stream) {
                                            long j = ref$LongRef.element;
                                            http2Stream.f25715d += j;
                                            if (j > 0) {
                                                http2Stream.notifyAll();
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
                        http2Writer = http2Writer2;
                    }
                }
            }
        }

        public d(Http2Connection http2Connection, Http2Reader http2Reader) {
            Intrinsics3.checkParameterIsNotNull(http2Reader, "reader");
            this.f25658k = http2Connection;
            this.f25657j = http2Reader;
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: a */
        public void mo10268a() {
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: b */
        public void mo10269b(boolean z2, Settings3 settings3) {
            Intrinsics3.checkParameterIsNotNull(settings3, "settings");
            TaskQueue2 taskQueue2 = this.f25658k.f25638t;
            String strM822J = outline.m822J(new StringBuilder(), this.f25658k.f25633o, " applyAndAckSettings");
            taskQueue2.m10154c(new c(strM822J, true, strM822J, true, this, z2, settings3), 0L);
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: c */
        public void mo10270c(boolean z2, int i, int i2, List<Header2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "headerBlock");
            if (this.f25658k.m10260c(i)) {
                Http2Connection http2Connection = this.f25658k;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
                TaskQueue2 taskQueue2 = http2Connection.f25639u;
                String str = http2Connection.f25633o + '[' + i + "] onHeaders";
                taskQueue2.m10154c(new TaskQueue5(str, true, str, true, http2Connection, i, list, z2), 0L);
                return;
            }
            synchronized (this.f25658k) {
                Http2Stream http2StreamM10259b = this.f25658k.m10259b(i);
                if (http2StreamM10259b != null) {
                    http2StreamM10259b.m10291j(Util7.m10142w(list), z2);
                    return;
                }
                Http2Connection http2Connection2 = this.f25658k;
                if (http2Connection2.f25636r) {
                    return;
                }
                if (i <= http2Connection2.f25634p) {
                    return;
                }
                if (i % 2 == http2Connection2.f25635q % 2) {
                    return;
                }
                Http2Stream http2Stream = new Http2Stream(i, this.f25658k, false, z2, Util7.m10142w(list));
                Http2Connection http2Connection3 = this.f25658k;
                http2Connection3.f25634p = i;
                http2Connection3.f25632n.put(Integer.valueOf(i), http2Stream);
                TaskQueue2 taskQueue2M10162f = this.f25658k.f25637s.m10162f();
                String str2 = this.f25658k.f25633o + '[' + i + "] onStream";
                taskQueue2M10162f.m10154c(new a(str2, true, str2, true, http2Stream, this, http2StreamM10259b, i, list, z2), 0L);
            }
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: d */
        public void mo10271d(int i, long j) {
            if (i == 0) {
                synchronized (this.f25658k) {
                    Http2Connection http2Connection = this.f25658k;
                    http2Connection.f25625I += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream http2StreamM10259b = this.f25658k.m10259b(i);
            if (http2StreamM10259b != null) {
                synchronized (http2StreamM10259b) {
                    http2StreamM10259b.f25715d += j;
                    if (j > 0) {
                        http2StreamM10259b.notifyAll();
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
        
            r3.m10291j(p600f0.p601e0.Util7.f25398b, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        
            return;
         */
        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo10272e(boolean z2, int i, BufferedSource bufferedSource, int i2) throws IOException {
            boolean z3;
            boolean z4;
            long j;
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            if (!this.f25658k.m10260c(i)) {
                Http2Stream http2StreamM10259b = this.f25658k.m10259b(i);
                if (http2StreamM10259b != null) {
                    Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                    byte[] bArr = Util7.f25397a;
                    Http2Stream.b bVar = http2StreamM10259b.f25718g;
                    long j2 = i2;
                    Objects.requireNonNull(bVar);
                    Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                    while (true) {
                        boolean z5 = true;
                        if (j2 <= 0) {
                            break;
                        }
                        synchronized (Http2Stream.this) {
                            z3 = bVar.f25734n;
                            z4 = bVar.f25731k.f26080k + j2 > bVar.f25733m;
                        }
                        if (z4) {
                            bufferedSource.skip(j2);
                            Http2Stream.this.m10286e(ErrorCode2.FLOW_CONTROL_ERROR);
                            break;
                        }
                        if (z3) {
                            bufferedSource.skip(j2);
                            break;
                        }
                        long jMo10176i0 = bufferedSource.mo10176i0(bVar.f25730j, j2);
                        if (jMo10176i0 == -1) {
                            throw new EOFException();
                        }
                        j2 -= jMo10176i0;
                        synchronized (Http2Stream.this) {
                            if (bVar.f25732l) {
                                Buffer3 buffer3 = bVar.f25730j;
                                j = buffer3.f26080k;
                                buffer3.skip(j);
                            } else {
                                Buffer3 buffer32 = bVar.f25731k;
                                if (buffer32.f26080k != 0) {
                                    z5 = false;
                                }
                                buffer32.mo10440P(bVar.f25730j);
                                if (z5) {
                                    Http2Stream http2Stream = Http2Stream.this;
                                    if (http2Stream == null) {
                                        break;
                                    } else {
                                        http2Stream.notifyAll();
                                    }
                                }
                                j = 0;
                            }
                        }
                        if (j > 0) {
                            bVar.m10295a(j);
                        }
                    }
                } else {
                    this.f25658k.m10266s(i, ErrorCode2.PROTOCOL_ERROR);
                    long j3 = i2;
                    this.f25658k.m10263f(j3);
                    bufferedSource.skip(j3);
                }
            } else {
                Http2Connection http2Connection = this.f25658k;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                Buffer3 buffer33 = new Buffer3();
                long j4 = i2;
                bufferedSource.mo10463p0(j4);
                bufferedSource.mo10176i0(buffer33, j4);
                TaskQueue2 taskQueue2 = http2Connection.f25639u;
                String str = http2Connection.f25633o + '[' + i + "] onData";
                taskQueue2.m10154c(new TaskQueue4(str, true, str, true, http2Connection, i, buffer33, i2, z2), 0L);
            }
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: f */
        public void mo10273f(boolean z2, int i, int i2) {
            if (!z2) {
                TaskQueue2 taskQueue2 = this.f25658k.f25638t;
                String strM822J = outline.m822J(new StringBuilder(), this.f25658k.f25633o, " ping");
                taskQueue2.m10154c(new b(strM822J, true, strM822J, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.f25658k) {
                if (i == 1) {
                    this.f25658k.f25643y++;
                } else if (i == 2) {
                    this.f25658k.f25617A++;
                } else if (i == 3) {
                    Http2Connection http2Connection = this.f25658k;
                    http2Connection.f25618B++;
                    http2Connection.notifyAll();
                }
            }
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: g */
        public void mo10274g(int i, int i2, int i3, boolean z2) {
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: h */
        public void mo10275h(int i, ErrorCode2 errorCode2) {
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            if (!this.f25658k.m10260c(i)) {
                Http2Stream http2StreamM10261d = this.f25658k.m10261d(i);
                if (http2StreamM10261d != null) {
                    http2StreamM10261d.m10292k(errorCode2);
                    return;
                }
                return;
            }
            Http2Connection http2Connection = this.f25658k;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            TaskQueue2 taskQueue2 = http2Connection.f25639u;
            String str = http2Connection.f25633o + '[' + i + "] onReset";
            taskQueue2.m10154c(new TaskQueue7(str, true, str, true, http2Connection, i, errorCode2), 0L);
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: i */
        public void mo10276i(int i, int i2, List<Header2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
            Http2Connection http2Connection = this.f25658k;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
            synchronized (http2Connection) {
                if (http2Connection.f25629M.contains(Integer.valueOf(i2))) {
                    http2Connection.m10266s(i2, ErrorCode2.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.f25629M.add(Integer.valueOf(i2));
                TaskQueue2 taskQueue2 = http2Connection.f25639u;
                String str = http2Connection.f25633o + '[' + i2 + "] onRequest";
                taskQueue2.m10154c(new TaskQueue6(str, true, str, true, http2Connection, i2, list), 0L);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [f0.e0.j.a] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws Throwable {
            Throwable th;
            ErrorCode2 errorCode2;
            ErrorCode2 errorCode22 = ErrorCode2.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.f25657j.m10279b(this);
                    while (this.f25657j.m10278a(false, this)) {
                    }
                    ErrorCode2 errorCode23 = ErrorCode2.NO_ERROR;
                    try {
                        this.f25658k.m10258a(errorCode23, ErrorCode2.CANCEL, null);
                        errorCode2 = errorCode23;
                    } catch (IOException e2) {
                        e = e2;
                        ErrorCode2 errorCode24 = ErrorCode2.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.f25658k;
                        http2Connection.m10258a(errorCode24, errorCode24, e);
                        errorCode2 = http2Connection;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f25658k.m10258a(errorCode2, errorCode22, e);
                    Util7.m10123d(this.f25657j);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                errorCode2 = errorCode22;
                this.f25658k.m10258a(errorCode2, errorCode22, e);
                Util7.m10123d(this.f25657j);
                throw th;
            }
            Util7.m10123d(this.f25657j);
            errorCode22 = Unit.f27425a;
            return errorCode22;
        }

        @Override // p600f0.p601e0.p608j.Http2Reader.b
        /* JADX INFO: renamed from: j */
        public void mo10277j(int i, ErrorCode2 errorCode2, ByteString byteString) {
            int i2;
            Http2Stream[] http2StreamArr;
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            Intrinsics3.checkParameterIsNotNull(byteString, "debugData");
            byteString.mo10502j();
            synchronized (this.f25658k) {
                Object[] array = this.f25658k.f25632n.values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.f25658k.f25636r = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.f25724m > i && http2Stream.m10289h()) {
                    http2Stream.m10292k(ErrorCode2.REFUSED_STREAM);
                    this.f25658k.m10261d(http2Stream.f25724m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$e */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends Task2 {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ Http2Connection f25668e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ int f25669f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ ErrorCode2 f25670g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, ErrorCode2 errorCode2) {
            super(str2, z3);
            this.f25668e = http2Connection;
            this.f25669f = i;
            this.f25670g = errorCode2;
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                Http2Connection http2Connection = this.f25668e;
                int i = this.f25669f;
                ErrorCode2 errorCode2 = this.f25670g;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
                http2Connection.f25627K.m10304n(i, errorCode2);
                return -1L;
            } catch (IOException e) {
                Http2Connection http2Connection2 = this.f25668e;
                ErrorCode2 errorCode22 = ErrorCode2.PROTOCOL_ERROR;
                http2Connection2.m10258a(errorCode22, errorCode22, e);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.e$f */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class f extends Task2 {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ Http2Connection f25671e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ int f25672f;

        /* JADX INFO: renamed from: g */
        public final /* synthetic */ long f25673g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, long j) {
            super(str2, z3);
            this.f25671e = http2Connection;
            this.f25672f = i;
            this.f25673g = j;
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                this.f25671e.f25627K.m10305q(this.f25672f, this.f25673g);
                return -1L;
            } catch (IOException e) {
                Http2Connection http2Connection = this.f25671e;
                ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
                http2Connection.m10258a(errorCode2, errorCode2, e);
                return -1L;
            }
        }
    }

    static {
        Settings3 settings3 = new Settings3();
        settings3.m10314c(7, 65535);
        settings3.m10314c(5, 16384);
        f25615j = settings3;
    }

    public Http2Connection(b bVar) {
        Intrinsics3.checkParameterIsNotNull(bVar, "builder");
        boolean z2 = bVar.f25654h;
        this.f25630l = z2;
        this.f25631m = bVar.f25651e;
        this.f25632n = new LinkedHashMap();
        String str = bVar.f25648b;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("connectionName");
        }
        this.f25633o = str;
        this.f25635q = bVar.f25654h ? 3 : 2;
        TaskRunner taskRunner = bVar.f25655i;
        this.f25637s = taskRunner;
        TaskQueue2 taskQueue2M10162f = taskRunner.m10162f();
        this.f25638t = taskQueue2M10162f;
        this.f25639u = taskRunner.m10162f();
        this.f25640v = taskRunner.m10162f();
        this.f25641w = bVar.f25652f;
        Settings3 settings3 = new Settings3();
        if (bVar.f25654h) {
            settings3.m10314c(7, 16777216);
        }
        this.f25620D = settings3;
        this.f25621E = f25615j;
        this.f25625I = r2.m10312a();
        Socket socket = bVar.f25647a;
        if (socket == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("socket");
        }
        this.f25626J = socket;
        BufferedSink bufferedSink = bVar.f25650d;
        if (bufferedSink == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("sink");
        }
        this.f25627K = new Http2Writer(bufferedSink, z2);
        BufferedSource bufferedSource = bVar.f25649c;
        if (bufferedSource == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        this.f25628L = new d(this, new Http2Reader(bufferedSource, z2));
        this.f25629M = new LinkedHashSet();
        int i = bVar.f25653g;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            String strM883w = outline.m883w(str, " ping");
            taskQueue2M10162f.m10154c(new a(strM883w, strM883w, this, nanos), nanos);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m10258a(ErrorCode2 errorCode2, ErrorCode2 errorCode22, IOException iOException) {
        int i;
        Intrinsics3.checkParameterIsNotNull(errorCode2, "connectionCode");
        Intrinsics3.checkParameterIsNotNull(errorCode22, "streamCode");
        byte[] bArr = Util7.f25397a;
        try {
            m10262e(errorCode2);
        } catch (IOException unused) {
        }
        Http2Stream[] http2StreamArr = null;
        synchronized (this) {
            if (!this.f25632n.isEmpty()) {
                Object[] array = this.f25632n.values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.f25632n.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.m10284c(errorCode22, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f25627K.close();
        } catch (IOException unused3) {
        }
        try {
            this.f25626J.close();
        } catch (IOException unused4) {
        }
        this.f25638t.m10156f();
        this.f25639u.m10156f();
        this.f25640v.m10156f();
    }

    /* JADX INFO: renamed from: b */
    public final synchronized Http2Stream m10259b(int i) {
        return this.f25632n.get(Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: c */
    public final boolean m10260c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m10258a(ErrorCode2.NO_ERROR, ErrorCode2.CANCEL, null);
    }

    /* JADX INFO: renamed from: d */
    public final synchronized Http2Stream m10261d(int i) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.f25632n.remove(Integer.valueOf(i));
        notifyAll();
        return http2StreamRemove;
    }

    /* JADX INFO: renamed from: e */
    public final void m10262e(ErrorCode2 errorCode2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
        synchronized (this.f25627K) {
            synchronized (this) {
                if (this.f25636r) {
                    return;
                }
                this.f25636r = true;
                this.f25627K.m10301d(this.f25634p, errorCode2, Util7.f25397a);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final synchronized void m10263f(long j) {
        long j2 = this.f25622F + j;
        this.f25622F = j2;
        long j3 = j2 - this.f25623G;
        if (j3 >= this.f25620D.m10312a() / 2) {
            m10267t(0, j3);
            this.f25623G += j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r5 = (int) java.lang.Math.min(r13, r6 - r4);
        r3.element = r5;
        r4 = java.lang.Math.min(r5, r9.f25627K.f25739l);
        r3.element = r4;
        r9.f25624H += (long) r4;
     */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10264n(int i, boolean z2, Buffer3 buffer3, long j) throws IOException {
        int iMin;
        if (j == 0) {
            this.f25627K.m10299b(z2, i, buffer3, 0);
            return;
        }
        while (j > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (true) {
                    try {
                        long j2 = this.f25624H;
                        long j3 = this.f25625I;
                        if (j2 < j3) {
                            break;
                        } else {
                            if (!this.f25632n.containsKey(Integer.valueOf(i))) {
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
            j -= (long) iMin;
            this.f25627K.m10299b(z2 && j == 0, i, buffer3, iMin);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m10265q(boolean z2, int i, int i2) {
        try {
            this.f25627K.m10303f(z2, i, i2);
        } catch (IOException e2) {
            ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
            m10258a(errorCode2, errorCode2, e2);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m10266s(int i, ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        TaskQueue2 taskQueue2 = this.f25638t;
        String str = this.f25633o + '[' + i + "] writeSynReset";
        taskQueue2.m10154c(new e(str, true, str, true, this, i, errorCode2), 0L);
    }

    /* JADX INFO: renamed from: t */
    public final void m10267t(int i, long j) {
        TaskQueue2 taskQueue2 = this.f25638t;
        String str = this.f25633o + '[' + i + "] windowUpdate";
        taskQueue2.m10154c(new f(str, true, str, true, this, i, j), 0L);
    }
}
