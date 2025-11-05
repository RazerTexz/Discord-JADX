package s.a;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class q0 extends CoroutineDispatcher {
    public static final /* synthetic */ int j = 0;
    public long k;
    public boolean l;
    public s.a.a.b<j0<?>> m;

    public final void H(boolean z2) {
        long jI = this.k - I(z2);
        this.k = jI;
        if (jI <= 0 && this.l) {
            shutdown();
        }
    }

    public final long I(boolean z2) {
        if (z2) {
            return Permission.REQUEST_TO_SPEAK;
        }
        return 1L;
    }

    public final void J(j0<?> j0Var) {
        s.a.a.b<j0<?>> bVar = this.m;
        if (bVar == null) {
            bVar = new s.a.a.b<>();
            this.m = bVar;
        }
        Object[] objArr = bVar.a;
        int i = bVar.c;
        objArr[i] = j0Var;
        int length = (objArr.length - 1) & (i + 1);
        bVar.c = length;
        int i2 = bVar.f3826b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            d0.t.j.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = bVar.a;
            int length3 = objArr3.length;
            int i3 = bVar.f3826b;
            d0.t.j.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            bVar.a = objArr2;
            bVar.f3826b = 0;
            bVar.c = length2;
        }
    }

    public final void L(boolean z2) {
        this.k = I(z2) + this.k;
        if (z2) {
            return;
        }
        this.l = true;
    }

    public final boolean N() {
        return this.k >= I(true);
    }

    public long O() {
        if (R()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    public final boolean R() {
        s.a.a.b<j0<?>> bVar = this.m;
        if (bVar != null) {
            int i = bVar.f3826b;
            j0 j0Var = null;
            if (i != bVar.c) {
                ?? r3 = bVar.a;
                ?? r6 = r3[i];
                r3[i] = 0;
                bVar.f3826b = (i + 1) & (r3.length - 1);
                Objects.requireNonNull(r6, "null cannot be cast to non-null type T");
                j0Var = r6;
            }
            j0 j0Var2 = j0Var;
            if (j0Var2 != null) {
                j0Var2.run();
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
    }
}
