package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Executors;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: s.a.u0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors4 extends Lambda implements Function1<CoroutineContext.Element, Executors> {

    /* JADX INFO: renamed from: j */
    public static final Executors4 f27905j = new Executors4();

    public Executors4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Executors invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof Executors)) {
            element2 = null;
        }
        return (Executors) element2;
    }
}
