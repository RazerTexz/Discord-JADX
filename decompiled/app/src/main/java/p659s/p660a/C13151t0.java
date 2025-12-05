package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import p659s.p660a.p661a.Symbol3;

/* compiled from: EventLoop.common.kt */
/* renamed from: s.a.t0 */
/* loaded from: classes3.dex */
public final class C13151t0 {

    /* renamed from: a */
    public static final Symbol3 f27903a = new Symbol3("REMOVED_TASK");

    /* renamed from: b */
    public static final Symbol3 f27904b = new Symbol3("CLOSED_EMPTY");

    /* renamed from: a */
    public static final long m11348a(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j;
    }
}
