package p007b.p225i.p361c.p369m.p370d.p387t;

/* JADX INFO: renamed from: b.i.c.m.d.t.a, reason: use source file name */
/* JADX INFO: compiled from: MiddleOutFallbackStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a */
    public final StackTraceTrimmingStrategy[] f12774a;

    /* JADX INFO: renamed from: b */
    public final MiddleOutStrategy f12775b;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f12774a = stackTraceTrimmingStrategyArr;
        this.f12775b = new MiddleOutStrategy(i);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p387t.StackTraceTrimmingStrategy
    /* JADX INFO: renamed from: a */
    public StackTraceElement[] mo6696a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrMo6696a = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f12774a) {
            if (stackTraceElementArrMo6696a.length <= 1024) {
                break;
            }
            stackTraceElementArrMo6696a = stackTraceTrimmingStrategy.mo6696a(stackTraceElementArr);
        }
        return stackTraceElementArrMo6696a.length > 1024 ? this.f12775b.mo6696a(stackTraceElementArrMo6696a) : stackTraceElementArrMo6696a;
    }
}
