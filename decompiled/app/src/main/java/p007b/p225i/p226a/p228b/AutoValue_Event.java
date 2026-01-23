package p007b.p225i.p226a.p228b;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_Event<T> extends Event2<T> {

    /* JADX INFO: renamed from: a */
    public final T f5116a;

    /* JADX INFO: renamed from: b */
    public final Priority3 f5117b;

    public AutoValue_Event(@Nullable Integer num, T t, Priority3 priority3) {
        Objects.requireNonNull(t, "Null payload");
        this.f5116a = t;
        Objects.requireNonNull(priority3, "Null priority");
        this.f5117b = priority3;
    }

    @Override // p007b.p225i.p226a.p228b.Event2
    @Nullable
    /* JADX INFO: renamed from: a */
    public Integer mo2286a() {
        return null;
    }

    @Override // p007b.p225i.p226a.p228b.Event2
    /* JADX INFO: renamed from: b */
    public T mo2287b() {
        return this.f5116a;
    }

    @Override // p007b.p225i.p226a.p228b.Event2
    /* JADX INFO: renamed from: c */
    public Priority3 mo2288c() {
        return this.f5117b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event2)) {
            return false;
        }
        Event2 event2 = (Event2) obj;
        return event2.mo2286a() == null && this.f5116a.equals(event2.mo2287b()) && this.f5117b.equals(event2.mo2288c());
    }

    public int hashCode() {
        return this.f5117b.hashCode() ^ (((-721379959) ^ this.f5116a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + this.f5116a + ", priority=" + this.f5117b + "}";
    }
}
