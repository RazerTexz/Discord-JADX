package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_PersistedEvent extends PersistedEvent {

    /* JADX INFO: renamed from: a */
    public final long f5417a;

    /* JADX INFO: renamed from: b */
    public final TransportContext f5418b;

    /* JADX INFO: renamed from: c */
    public final EventInternal f5419c;

    public AutoValue_PersistedEvent(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.f5417a = j;
        Objects.requireNonNull(transportContext, "Null transportContext");
        this.f5418b = transportContext;
        Objects.requireNonNull(eventInternal, "Null event");
        this.f5419c = eventInternal;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.PersistedEvent
    /* JADX INFO: renamed from: a */
    public EventInternal mo2391a() {
        return this.f5419c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.PersistedEvent
    /* JADX INFO: renamed from: b */
    public long mo2392b() {
        return this.f5417a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.PersistedEvent
    /* JADX INFO: renamed from: c */
    public TransportContext mo2393c() {
        return this.f5418b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.f5417a == persistedEvent.mo2392b() && this.f5418b.equals(persistedEvent.mo2393c()) && this.f5419c.equals(persistedEvent.mo2391a());
    }

    public int hashCode() {
        long j = this.f5417a;
        return this.f5419c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f5418b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("PersistedEvent{id=");
        sbM833U.append(this.f5417a);
        sbM833U.append(", transportContext=");
        sbM833U.append(this.f5418b);
        sbM833U.append(", event=");
        sbM833U.append(this.f5419c);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
