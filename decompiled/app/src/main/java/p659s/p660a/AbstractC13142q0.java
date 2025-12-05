package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p580t._ArraysJvm;
import p659s.p660a.p661a.ArrayQueue;

/* compiled from: EventLoop.common.kt */
/* renamed from: s.a.q0 */
/* loaded from: classes3.dex */
public abstract class AbstractC13142q0 extends CoroutineDispatcher {

    /* renamed from: j */
    public static final /* synthetic */ int f27883j = 0;

    /* renamed from: k */
    public long f27884k;

    /* renamed from: l */
    public boolean f27885l;

    /* renamed from: m */
    public ArrayQueue<DispatchedTask<?>> f27886m;

    /* renamed from: H */
    public final void m11334H(boolean z2) {
        long jM11335I = this.f27884k - m11335I(z2);
        this.f27884k = jM11335I;
        if (jM11335I <= 0 && this.f27885l) {
            shutdown();
        }
    }

    /* renamed from: I */
    public final long m11335I(boolean z2) {
        if (z2) {
            return Permission.REQUEST_TO_SPEAK;
        }
        return 1L;
    }

    /* renamed from: J */
    public final void m11336J(DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f27886m;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.f27886m = arrayQueue;
        }
        Object[] objArr = arrayQueue.f27668a;
        int i = arrayQueue.f27670c;
        objArr[i] = dispatchedTask;
        int length = (objArr.length - 1) & (i + 1);
        arrayQueue.f27670c = length;
        int i2 = arrayQueue.f27669b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            _ArraysJvm.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = arrayQueue.f27668a;
            int length3 = objArr3.length;
            int i3 = arrayQueue.f27669b;
            _ArraysJvm.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            arrayQueue.f27668a = objArr2;
            arrayQueue.f27669b = 0;
            arrayQueue.f27670c = length2;
        }
    }

    /* renamed from: L */
    public final void m11337L(boolean z2) {
        this.f27884k = m11335I(z2) + this.f27884k;
        if (z2) {
            return;
        }
        this.f27885l = true;
    }

    /* renamed from: N */
    public final boolean m11338N() {
        return this.f27884k >= m11335I(true);
    }

    /* renamed from: O */
    public long mo11339O() {
        if (m11340R()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* renamed from: R */
    public final boolean m11340R() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f27886m;
        if (arrayQueue != null) {
            int i = arrayQueue.f27669b;
            DispatchedTask dispatchedTask = null;
            if (i != arrayQueue.f27670c) {
                ?? r3 = arrayQueue.f27668a;
                ?? r6 = r3[i];
                r3[i] = 0;
                arrayQueue.f27669b = (i + 1) & (r3.length - 1);
                Objects.requireNonNull(r6, "null cannot be cast to non-null type T");
                dispatchedTask = r6;
            }
            DispatchedTask dispatchedTask2 = dispatchedTask;
            if (dispatchedTask2 != null) {
                dispatchedTask2.run();
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
    }
}
