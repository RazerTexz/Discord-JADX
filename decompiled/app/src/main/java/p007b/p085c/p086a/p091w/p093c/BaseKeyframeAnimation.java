package p007b.p085c.p086a.p091w.p093c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.a, reason: use source file name */
/* loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: c */
    public final d<K> f2598c;

    /* renamed from: e */
    @Nullable
    public LottieValueCallback<A> f2600e;

    /* renamed from: a */
    public final List<b> f2596a = new ArrayList(1);

    /* renamed from: b */
    public boolean f2597b = false;

    /* renamed from: d */
    public float f2599d = 0.0f;

    /* renamed from: f */
    @Nullable
    public A f2601f = null;

    /* renamed from: g */
    public float f2602g = -1.0f;

    /* renamed from: h */
    public float f2603h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: b.c.a.w.c.a$b */
    public interface b {
        /* renamed from: a */
        void mo709a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: b.c.a.w.c.a$c */
    public static final class c<T> implements d<T> {
        public c(a aVar) {
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: a */
        public boolean mo732a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: b */
        public Keyframe<T> mo733b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: c */
        public boolean mo734c(float f) {
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: d */
        public float mo735d() {
            return 1.0f;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: e */
        public float mo736e() {
            return 0.0f;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: b.c.a.w.c.a$d */
    public interface d<T> {
        /* renamed from: a */
        boolean mo732a(float f);

        /* renamed from: b */
        Keyframe<T> mo733b();

        /* renamed from: c */
        boolean mo734c(float f);

        @FloatRange(from = 0.0d, m75to = 1.0d)
        /* renamed from: d */
        float mo735d();

        @FloatRange(from = 0.0d, m75to = 1.0d)
        /* renamed from: e */
        float mo736e();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: b.c.a.w.c.a$e */
    public static final class e<T> implements d<T> {

        /* renamed from: a */
        public final List<? extends Keyframe<T>> f2604a;

        /* renamed from: c */
        public Keyframe<T> f2606c = null;

        /* renamed from: d */
        public float f2607d = -1.0f;

        /* renamed from: b */
        @NonNull
        public Keyframe<T> f2605b = m737f(0.0f);

        public e(List<? extends Keyframe<T>> list) {
            this.f2604a = list;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: a */
        public boolean mo732a(float f) {
            Keyframe<T> keyframe = this.f2606c;
            Keyframe<T> keyframe2 = this.f2605b;
            if (keyframe == keyframe2 && this.f2607d == f) {
                return true;
            }
            this.f2606c = keyframe2;
            this.f2607d = f;
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        @NonNull
        /* renamed from: b */
        public Keyframe<T> mo733b() {
            return this.f2605b;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: c */
        public boolean mo734c(float f) {
            if (this.f2605b.m664a(f)) {
                return !this.f2605b.m667d();
            }
            this.f2605b = m737f(f);
            return true;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: d */
        public float mo735d() {
            return this.f2604a.get(r0.size() - 1).m665b();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: e */
        public float mo736e() {
            return this.f2604a.get(0).m666c();
        }

        /* renamed from: f */
        public final Keyframe<T> m737f(float f) {
            List<? extends Keyframe<T>> list = this.f2604a;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f >= keyframe.m666c()) {
                return keyframe;
            }
            for (int size = this.f2604a.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = this.f2604a.get(size);
                if (this.f2605b != keyframe2 && keyframe2.m664a(f)) {
                    return keyframe2;
                }
            }
            return this.f2604a.get(0);
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: b.c.a.w.c.a$f */
    public static final class f<T> implements d<T> {

        /* renamed from: a */
        @NonNull
        public final Keyframe<T> f2608a;

        /* renamed from: b */
        public float f2609b = -1.0f;

        public f(List<? extends Keyframe<T>> list) {
            this.f2608a = list.get(0);
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: a */
        public boolean mo732a(float f) {
            if (this.f2609b == f) {
                return true;
            }
            this.f2609b = f;
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: b */
        public Keyframe<T> mo733b() {
            return this.f2608a;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: c */
        public boolean mo734c(float f) {
            return !this.f2608a.m667d();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: d */
        public float mo735d() {
            return this.f2608a.m665b();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        /* renamed from: e */
        public float mo736e() {
            return this.f2608a.m666c();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return false;
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        d fVar;
        if (list.isEmpty()) {
            fVar = new c(null);
        } else {
            fVar = list.size() == 1 ? new f(list) : new e(list);
        }
        this.f2598c = fVar;
    }

    /* renamed from: a */
    public Keyframe<K> m723a() {
        Keyframe<K> keyframeMo733b = this.f2598c.mo733b();
        L.m663a("BaseKeyframeAnimation#getCurrentKeyframe");
        return keyframeMo733b;
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    /* renamed from: b */
    public float mo724b() {
        if (this.f2603h == -1.0f) {
            this.f2603h = this.f2598c.mo735d();
        }
        return this.f2603h;
    }

    /* renamed from: c */
    public float m725c() {
        Keyframe<K> keyframeM723a = m723a();
        if (keyframeM723a.m667d()) {
            return 0.0f;
        }
        return keyframeM723a.f2319d.getInterpolation(m726d());
    }

    /* renamed from: d */
    public float m726d() {
        if (this.f2597b) {
            return 0.0f;
        }
        Keyframe<K> keyframeM723a = m723a();
        if (keyframeM723a.m667d()) {
            return 0.0f;
        }
        return (this.f2599d - keyframeM723a.m666c()) / (keyframeM723a.m665b() - keyframeM723a.m666c());
    }

    /* renamed from: e */
    public A mo727e() {
        float fM725c = m725c();
        if (this.f2600e == null && this.f2598c.mo732a(fM725c)) {
            return this.f2601f;
        }
        A aMo728f = mo728f(m723a(), fM725c);
        this.f2601f = aMo728f;
        return aMo728f;
    }

    /* renamed from: f */
    public abstract A mo728f(Keyframe<K> keyframe, float f2);

    /* renamed from: g */
    public void mo729g() {
        for (int i = 0; i < this.f2596a.size(); i++) {
            this.f2596a.get(i).mo709a();
        }
    }

    /* renamed from: h */
    public void mo730h(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        if (this.f2598c.isEmpty()) {
            return;
        }
        if (this.f2602g == -1.0f) {
            this.f2602g = this.f2598c.mo736e();
        }
        float f3 = this.f2602g;
        if (f2 < f3) {
            if (f3 == -1.0f) {
                this.f2602g = this.f2598c.mo736e();
            }
            f2 = this.f2602g;
        } else if (f2 > mo724b()) {
            f2 = mo724b();
        }
        if (f2 == this.f2599d) {
            return;
        }
        this.f2599d = f2;
        if (this.f2598c.mo734c(f2)) {
            mo729g();
        }
    }

    /* renamed from: i */
    public void m731i(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.f2600e;
        this.f2600e = null;
    }
}
