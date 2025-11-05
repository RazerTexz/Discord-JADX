package b.c.a.w.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {
    public final d<K> c;

    @Nullable
    public b.c.a.c0.c<A> e;
    public final List<b> a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public boolean f392b = false;
    public float d = 0.0f;

    @Nullable
    public A f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    public interface b {
        void a();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class c<T> implements d<T> {
        public c(C0063a c0063a) {
        }

        @Override // b.c.a.w.c.a.d
        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // b.c.a.w.c.a.d
        public b.c.a.c0.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // b.c.a.w.c.a.d
        public boolean c(float f) {
            return false;
        }

        @Override // b.c.a.w.c.a.d
        public float d() {
            return 1.0f;
        }

        @Override // b.c.a.w.c.a.d
        public float e() {
            return 0.0f;
        }

        @Override // b.c.a.w.c.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public interface d<T> {
        boolean a(float f);

        b.c.a.c0.a<T> b();

        boolean c(float f);

        @FloatRange(from = 0.0d, to = 1.0d)
        float d();

        @FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class e<T> implements d<T> {
        public final List<? extends b.c.a.c0.a<T>> a;
        public b.c.a.c0.a<T> c = null;
        public float d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        public b.c.a.c0.a<T> f393b = f(0.0f);

        public e(List<? extends b.c.a.c0.a<T>> list) {
            this.a = list;
        }

        @Override // b.c.a.w.c.a.d
        public boolean a(float f) {
            b.c.a.c0.a<T> aVar = this.c;
            b.c.a.c0.a<T> aVar2 = this.f393b;
            if (aVar == aVar2 && this.d == f) {
                return true;
            }
            this.c = aVar2;
            this.d = f;
            return false;
        }

        @Override // b.c.a.w.c.a.d
        @NonNull
        public b.c.a.c0.a<T> b() {
            return this.f393b;
        }

        @Override // b.c.a.w.c.a.d
        public boolean c(float f) {
            if (this.f393b.a(f)) {
                return !this.f393b.d();
            }
            this.f393b = f(f);
            return true;
        }

        @Override // b.c.a.w.c.a.d
        public float d() {
            return this.a.get(r0.size() - 1).b();
        }

        @Override // b.c.a.w.c.a.d
        public float e() {
            return this.a.get(0).c();
        }

        public final b.c.a.c0.a<T> f(float f) {
            List<? extends b.c.a.c0.a<T>> list = this.a;
            b.c.a.c0.a<T> aVar = list.get(list.size() - 1);
            if (f >= aVar.c()) {
                return aVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                b.c.a.c0.a<T> aVar2 = this.a.get(size);
                if (this.f393b != aVar2 && aVar2.a(f)) {
                    return aVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // b.c.a.w.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class f<T> implements d<T> {

        @NonNull
        public final b.c.a.c0.a<T> a;

        /* renamed from: b, reason: collision with root package name */
        public float f394b = -1.0f;

        public f(List<? extends b.c.a.c0.a<T>> list) {
            this.a = list.get(0);
        }

        @Override // b.c.a.w.c.a.d
        public boolean a(float f) {
            if (this.f394b == f) {
                return true;
            }
            this.f394b = f;
            return false;
        }

        @Override // b.c.a.w.c.a.d
        public b.c.a.c0.a<T> b() {
            return this.a;
        }

        @Override // b.c.a.w.c.a.d
        public boolean c(float f) {
            return !this.a.d();
        }

        @Override // b.c.a.w.c.a.d
        public float d() {
            return this.a.b();
        }

        @Override // b.c.a.w.c.a.d
        public float e() {
            return this.a.c();
        }

        @Override // b.c.a.w.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends b.c.a.c0.a<K>> list) {
        d fVar;
        if (list.isEmpty()) {
            fVar = new c(null);
        } else {
            fVar = list.size() == 1 ? new f(list) : new e(list);
        }
        this.c = fVar;
    }

    public b.c.a.c0.a<K> a() {
        b.c.a.c0.a<K> aVarB = this.c.b();
        b.c.a.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        if (this.h == -1.0f) {
            this.h = this.c.d();
        }
        return this.h;
    }

    public float c() {
        b.c.a.c0.a<K> aVarA = a();
        if (aVarA.d()) {
            return 0.0f;
        }
        return aVarA.d.getInterpolation(d());
    }

    public float d() {
        if (this.f392b) {
            return 0.0f;
        }
        b.c.a.c0.a<K> aVarA = a();
        if (aVarA.d()) {
            return 0.0f;
        }
        return (this.d - aVarA.c()) / (aVarA.b() - aVarA.c());
    }

    public A e() {
        float fC = c();
        if (this.e == null && this.c.a(fC)) {
            return this.f;
        }
        A aF = f(a(), fC);
        this.f = aF;
        return aF;
    }

    public abstract A f(b.c.a.c0.a<K> aVar, float f2);

    public void g() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    public void h(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.c.isEmpty()) {
            return;
        }
        if (this.g == -1.0f) {
            this.g = this.c.e();
        }
        float f3 = this.g;
        if (f2 < f3) {
            if (f3 == -1.0f) {
                this.g = this.c.e();
            }
            f2 = this.g;
        } else if (f2 > b()) {
            f2 = b();
        }
        if (f2 == this.d) {
            return;
        }
        this.d = f2;
        if (this.c.c(f2)) {
            g();
        }
    }

    public void i(@Nullable b.c.a.c0.c<A> cVar) {
        b.c.a.c0.c<A> cVar2 = this.e;
        this.e = null;
    }
}
