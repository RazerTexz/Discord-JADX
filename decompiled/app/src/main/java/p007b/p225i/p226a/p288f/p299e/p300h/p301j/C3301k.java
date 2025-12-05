package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.j.k */
/* loaded from: classes3.dex */
public final class C3301k<L> {

    /* renamed from: a */
    public final c f9428a;

    /* renamed from: b */
    @Nullable
    public volatile L f9429b;

    /* renamed from: c */
    @Nullable
    public volatile a<L> f9430c;

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.j.k$a */
    public static final class a<L> {

        /* renamed from: a */
        public final L f9431a;

        /* renamed from: b */
        public final String f9432b;

        public a(L l, String str) {
            this.f9431a = l;
            this.f9432b = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9431a == aVar.f9431a && this.f9432b.equals(aVar.f9432b);
        }

        public final int hashCode() {
            return this.f9432b.hashCode() + (System.identityHashCode(this.f9431a) * 31);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.j.k$b */
    public interface b<L> {
        /* renamed from: a */
        void mo4107a(L l);

        /* renamed from: b */
        void mo4108b();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.j.k$c */
    public final class c extends HandlerC3479c {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AnimatableValueParser.m539l(message.what == 1);
            b bVar = (b) message.obj;
            L l = C3301k.this.f9429b;
            if (l == null) {
                bVar.mo4108b();
                return;
            }
            try {
                bVar.mo4107a(l);
            } catch (RuntimeException e) {
                bVar.mo4108b();
                throw e;
            }
        }
    }

    public C3301k(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.f9428a = new c(looper);
        AnimatableValueParser.m595z(l, "Listener must not be null");
        this.f9429b = l;
        AnimatableValueParser.m583w(str);
        this.f9430c = new a<>(l, str);
    }

    /* renamed from: a */
    public final void m4106a(b<? super L> bVar) {
        AnimatableValueParser.m595z(bVar, "Notifier must not be null");
        this.f9428a.sendMessage(this.f9428a.obtainMessage(1, bVar));
    }
}
