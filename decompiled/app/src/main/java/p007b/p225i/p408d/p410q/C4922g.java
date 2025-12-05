package p007b.p225i.p408d.p410q;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import p007b.p225i.p408d.InstanceCreator;
import p007b.p225i.p408d.p410q.p413y.ReflectionAccessor;

/* compiled from: ConstructorConstructor.java */
/* renamed from: b.i.d.q.g */
/* loaded from: classes3.dex */
public final class C4922g {

    /* renamed from: a */
    public final Map<Type, InstanceCreator<?>> f13115a;

    /* renamed from: b */
    public final ReflectionAccessor f13116b = ReflectionAccessor.f13148a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: b.i.d.q.g$a */
    public class a<T> implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ InstanceCreator f13117a;

        /* renamed from: b */
        public final /* synthetic */ Type f13118b;

        public a(C4922g c4922g, InstanceCreator instanceCreator, Type type) {
            this.f13117a = instanceCreator;
            this.f13118b = type;
        }

        @Override // p007b.p225i.p408d.p410q.ObjectConstructor
        /* renamed from: a */
        public T mo6869a() {
            return (T) this.f13117a.m6853a(this.f13118b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: b.i.d.q.g$b */
    public class b<T> implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ InstanceCreator f13119a;

        /* renamed from: b */
        public final /* synthetic */ Type f13120b;

        public b(C4922g c4922g, InstanceCreator instanceCreator, Type type) {
            this.f13119a = instanceCreator;
            this.f13120b = type;
        }

        @Override // p007b.p225i.p408d.p410q.ObjectConstructor
        /* renamed from: a */
        public T mo6869a() {
            return (T) this.f13119a.m6853a(this.f13120b);
        }
    }

    public C4922g(Map<Type, InstanceCreator<?>> map) {
        this.f13115a = map;
    }

    /* renamed from: a */
    public <T> ObjectConstructor<T> m6870a(TypeToken<T> typeToken) throws SecurityException {
        C4923h c4923h;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.f13115a.get(type);
        if (instanceCreator != null) {
            return new a(this, instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.f13115a.get(rawType);
        if (instanceCreator2 != null) {
            return new b(this, instanceCreator2, type);
        }
        ObjectConstructor<T> c4929n = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f13116b.mo6912a(declaredConstructor);
            }
            c4923h = new C4923h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            c4923h = null;
        }
        if (c4923h != null) {
            return c4923h;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            c4929n = SortedSet.class.isAssignableFrom(rawType) ? new C4924i<>(this) : EnumSet.class.isAssignableFrom(rawType) ? new C4925j<>(this, type) : Set.class.isAssignableFrom(rawType) ? new C4926k<>(this) : Queue.class.isAssignableFrom(rawType) ? new C4927l<>(this) : new C4928m<>(this);
        } else if (Map.class.isAssignableFrom(rawType)) {
            c4929n = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new C4929n<>(this) : ConcurrentMap.class.isAssignableFrom(rawType) ? new C4917b<>(this) : SortedMap.class.isAssignableFrom(rawType) ? new C4918c<>(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new C4920e<>(this) : new C4919d<>(this);
        }
        return c4929n != null ? c4929n : new C4921f(this, rawType, type);
    }

    public String toString() {
        return this.f13115a.toString();
    }
}
