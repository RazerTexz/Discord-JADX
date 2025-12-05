package p007b.p225i.p361c.p369m.p370d.p387t;

/* compiled from: TrimmedThrowableData.java */
/* renamed from: b.i.c.m.d.t.e, reason: use source file name */
/* loaded from: classes3.dex */
public class TrimmedThrowableData {

    /* renamed from: a */
    public final String f12777a;

    /* renamed from: b */
    public final String f12778b;

    /* renamed from: c */
    public final StackTraceElement[] f12779c;

    /* renamed from: d */
    public final TrimmedThrowableData f12780d;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f12777a = th.getLocalizedMessage();
        this.f12778b = th.getClass().getName();
        this.f12779c = stackTraceTrimmingStrategy.mo6696a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f12780d = cause != null ? new TrimmedThrowableData(cause, stackTraceTrimmingStrategy) : null;
    }
}
