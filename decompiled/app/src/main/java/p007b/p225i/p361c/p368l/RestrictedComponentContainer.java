package p007b.p225i.p361c.p368l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p007b.p225i.p361c.p396q.Publisher;
import p007b.p225i.p361c.p400t.Provider2;

/* compiled from: RestrictedComponentContainer.java */
/* renamed from: b.i.c.l.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class RestrictedComponentContainer extends AbstractComponentContainer {

    /* renamed from: a */
    public final Set<Class<?>> f12212a;

    /* renamed from: b */
    public final Set<Class<?>> f12213b;

    /* renamed from: c */
    public final Set<Class<?>> f12214c;

    /* renamed from: d */
    public final Set<Class<?>> f12215d;

    /* renamed from: e */
    public final Set<Class<?>> f12216e;

    /* renamed from: f */
    public final ComponentContainer f12217f;

    /* compiled from: RestrictedComponentContainer.java */
    /* renamed from: b.i.c.l.s$a */
    public static class a implements Publisher {

        /* renamed from: a */
        public final Publisher f12218a;

        public a(Set<Class<?>> set, Publisher publisher) {
            this.f12218a = publisher;
        }
    }

    public RestrictedComponentContainer(Component4<?> component4, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency2 dependency2 : component4.f12176b) {
            if (dependency2.f12203c == 0) {
                if (dependency2.m6358a()) {
                    hashSet3.add(dependency2.f12201a);
                } else {
                    hashSet.add(dependency2.f12201a);
                }
            } else if (dependency2.m6358a()) {
                hashSet4.add(dependency2.f12201a);
            } else {
                hashSet2.add(dependency2.f12201a);
            }
        }
        if (!component4.f12180f.isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.f12212a = Collections.unmodifiableSet(hashSet);
        this.f12213b = Collections.unmodifiableSet(hashSet2);
        this.f12214c = Collections.unmodifiableSet(hashSet3);
        this.f12215d = Collections.unmodifiableSet(hashSet4);
        this.f12216e = component4.f12180f;
        this.f12217f = componentContainer;
    }

    @Override // p007b.p225i.p361c.p368l.AbstractComponentContainer, p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: a */
    public <T> T mo6346a(Class<T> cls) {
        if (!this.f12212a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f12217f.mo6346a(cls);
        return !cls.equals(Publisher.class) ? t : (T) new a(this.f12216e, (Publisher) t);
    }

    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: b */
    public <T> Provider2<T> mo6355b(Class<T> cls) {
        if (this.f12213b.contains(cls)) {
            return this.f12217f.mo6355b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: c */
    public <T> Provider2<Set<T>> mo6356c(Class<T> cls) {
        if (this.f12215d.contains(cls)) {
            return this.f12217f.mo6356c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // p007b.p225i.p361c.p368l.AbstractComponentContainer, p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: d */
    public <T> Set<T> mo6347d(Class<T> cls) {
        if (this.f12214c.contains(cls)) {
            return this.f12217f.mo6347d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}
