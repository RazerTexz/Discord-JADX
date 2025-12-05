package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.HandlerWrapper;

/* compiled from: SystemHandlerWrapper.java */
/* renamed from: b.i.a.c.f3.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: a */
    @GuardedBy("messagePool")
    public static final List<b> f6690a = new ArrayList(50);

    /* renamed from: b */
    public final Handler f6691b;

    /* compiled from: SystemHandlerWrapper.java */
    /* renamed from: b.i.a.c.f3.b0$b */
    public static final class b implements HandlerWrapper.a {

        /* renamed from: a */
        @Nullable
        public Message f6692a;

        public b() {
        }

        /* renamed from: a */
        public final void m2964a() {
            this.f6692a = null;
            List<b> list = SystemHandlerWrapper.f6690a;
            synchronized (list) {
                if (list.size() < 50) {
                    list.add(this);
                }
            }
        }

        /* renamed from: b */
        public void m2965b() {
            Message message = this.f6692a;
            Objects.requireNonNull(message);
            message.sendToTarget();
            m2964a();
        }

        public b(a aVar) {
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f6691b = handler;
    }

    /* renamed from: k */
    public static b m2953k() {
        b bVar;
        List<b> list = f6690a;
        synchronized (list) {
            bVar = list.isEmpty() ? new b(null) : list.remove(list.size() - 1);
        }
        return bVar;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: a */
    public HandlerWrapper.a mo2954a(int i, int i2, int i3) {
        b bVarM2953k = m2953k();
        bVarM2953k.f6692a = this.f6691b.obtainMessage(i, i2, i3);
        return bVarM2953k;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: b */
    public boolean mo2955b(Runnable runnable) {
        return this.f6691b.post(runnable);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: c */
    public HandlerWrapper.a mo2956c(int i) {
        b bVarM2953k = m2953k();
        bVarM2953k.f6692a = this.f6691b.obtainMessage(i);
        return bVarM2953k;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: d */
    public boolean mo2957d(HandlerWrapper.a aVar) {
        b bVar = (b) aVar;
        Handler handler = this.f6691b;
        Message message = bVar.f6692a;
        Objects.requireNonNull(message);
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        bVar.m2964a();
        return zSendMessageAtFrontOfQueue;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: e */
    public boolean mo2958e(int i) {
        return this.f6691b.hasMessages(i);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: f */
    public boolean mo2959f(int i) {
        return this.f6691b.sendEmptyMessage(i);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: g */
    public boolean mo2960g(int i, long j) {
        return this.f6691b.sendEmptyMessageAtTime(i, j);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: h */
    public void mo2961h(int i) {
        this.f6691b.removeMessages(i);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: i */
    public HandlerWrapper.a mo2962i(int i, @Nullable Object obj) {
        b bVarM2953k = m2953k();
        bVarM2953k.f6692a = this.f6691b.obtainMessage(i, obj);
        return bVarM2953k;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.HandlerWrapper
    /* renamed from: j */
    public void mo2963j(@Nullable Object obj) {
        this.f6691b.removeCallbacksAndMessages(null);
    }
}
