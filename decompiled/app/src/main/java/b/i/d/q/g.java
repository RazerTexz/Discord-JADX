package b.i.d.q;

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

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public final class g {
    public final Map<Type, b.i.d.f<?>> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.d.q.y.b f1808b = b.i.d.q.y.b.a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class a<T> implements r<T> {
        public final /* synthetic */ b.i.d.f a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f1809b;

        public a(g gVar, b.i.d.f fVar, Type type) {
            this.a = fVar;
            this.f1809b = type;
        }

        @Override // b.i.d.q.r
        public T a() {
            return (T) this.a.a(this.f1809b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class b<T> implements r<T> {
        public final /* synthetic */ b.i.d.f a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f1810b;

        public b(g gVar, b.i.d.f fVar, Type type) {
            this.a = fVar;
            this.f1810b = type;
        }

        @Override // b.i.d.q.r
        public T a() {
            return (T) this.a.a(this.f1810b);
        }
    }

    public g(Map<Type, b.i.d.f<?>> map) {
        this.a = map;
    }

    public <T> r<T> a(TypeToken<T> typeToken) throws SecurityException {
        h hVar;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        b.i.d.f<?> fVar = this.a.get(type);
        if (fVar != null) {
            return new a(this, fVar, type);
        }
        b.i.d.f<?> fVar2 = this.a.get(rawType);
        if (fVar2 != null) {
            return new b(this, fVar2, type);
        }
        r<T> nVar = null;
        try {
            Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f1808b.a(declaredConstructor);
            }
            hVar = new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            hVar = null;
        }
        if (hVar != null) {
            return hVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            nVar = SortedSet.class.isAssignableFrom(rawType) ? new i<>(this) : EnumSet.class.isAssignableFrom(rawType) ? new j<>(this, type) : Set.class.isAssignableFrom(rawType) ? new k<>(this) : Queue.class.isAssignableFrom(rawType) ? new l<>(this) : new m<>(this);
        } else if (Map.class.isAssignableFrom(rawType)) {
            nVar = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new n<>(this) : ConcurrentMap.class.isAssignableFrom(rawType) ? new b.i.d.q.b<>(this) : SortedMap.class.isAssignableFrom(rawType) ? new c<>(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new e<>(this) : new d<>(this);
        }
        return nVar != null ? nVar : new f(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
