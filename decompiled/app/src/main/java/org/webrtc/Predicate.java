package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface Predicate<T> {

    /* JADX INFO: renamed from: org.webrtc.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: a */
        public static Predicate m11035a(Predicate _this, Predicate predicate) {
            return new C129812(predicate);
        }

        /* JADX INFO: renamed from: b */
        public static Predicate m11036b(Predicate _this) {
            return new C129823();
        }

        /* JADX INFO: renamed from: c */
        public static Predicate m11037c(Predicate _this, Predicate predicate) {
            return new C129801(predicate);
        }
    }

    /* JADX INFO: renamed from: org.webrtc.Predicate$1 */
    public class C129801 implements Predicate<T> {
        public final /* synthetic */ Predicate val$other;

        public C129801(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.m11035a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.m11036b(this);
        }

        @Override // org.webrtc.Predicate
        /* JADX INFO: renamed from: or */
        public /* synthetic */ Predicate mo11025or(Predicate predicate) {
            return CC.m11037c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return Predicate.this.test(t) || this.val$other.test(t);
        }
    }

    /* JADX INFO: renamed from: org.webrtc.Predicate$2 */
    public class C129812 implements Predicate<T> {
        public final /* synthetic */ Predicate val$other;

        public C129812(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.m11035a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.m11036b(this);
        }

        @Override // org.webrtc.Predicate
        /* JADX INFO: renamed from: or */
        public /* synthetic */ Predicate mo11025or(Predicate predicate) {
            return CC.m11037c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return Predicate.this.test(t) && this.val$other.test(t);
        }
    }

    /* JADX INFO: renamed from: org.webrtc.Predicate$3 */
    public class C129823 implements Predicate<T> {
        public C129823() {
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.m11035a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.m11036b(this);
        }

        @Override // org.webrtc.Predicate
        /* JADX INFO: renamed from: or */
        public /* synthetic */ Predicate mo11025or(Predicate predicate) {
            return CC.m11037c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return !Predicate.this.test(t);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    /* JADX INFO: renamed from: or */
    Predicate<T> mo11025or(Predicate<? super T> predicate);

    boolean test(T t);
}
