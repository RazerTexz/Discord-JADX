package p007b.p225i.p361c.p368l;

import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.p396q.Publisher;
import p007b.p225i.p361c.p396q.Subscriber2;
import p007b.p225i.p361c.p400t.Provider2;

/* compiled from: ComponentRuntime.java */
/* renamed from: b.i.c.l.k, reason: use source file name */
/* loaded from: classes3.dex */
public class ComponentRuntime4 extends AbstractComponentContainer {

    /* renamed from: a */
    public static final /* synthetic */ int f12191a = 0;

    /* renamed from: b */
    public final Map<Component4<?>, Lazy2<?>> f12192b = new HashMap();

    /* renamed from: c */
    public final Map<Class<?>, Lazy2<?>> f12193c = new HashMap();

    /* renamed from: d */
    public final Map<Class<?>, Lazy2<Set<?>>> f12194d = new HashMap();

    /* renamed from: e */
    public final EventBus2 f12195e;

    public ComponentRuntime4(Executor executor, Iterable<ComponentRegistrar> iterable, Component4<?>... component4Arr) {
        Set<CycleDetector2> set;
        EventBus2 eventBus2 = new EventBus2(executor);
        this.f12195e = eventBus2;
        ArrayList<Component4> arrayList = new ArrayList();
        arrayList.add(Component4.m6349c(eventBus2, EventBus2.class, Subscriber2.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (Component4<?> component4 : component4Arr) {
            if (component4 != null) {
                arrayList.add(component4);
            }
        }
        HashMap map = new HashMap(arrayList.size());
        for (Component4 component42 : arrayList) {
            CycleDetector2 cycleDetector2 = new CycleDetector2(component42);
            Iterator it2 = component42.f12175a.iterator();
            while (it2.hasNext()) {
                Class cls = (Class) it2.next();
                boolean z2 = !component42.m6350b();
                CycleDetector3 cycleDetector3 = new CycleDetector3(cls, z2, null);
                if (!map.containsKey(cycleDetector3)) {
                    map.put(cycleDetector3, new HashSet());
                }
                Set set2 = (Set) map.get(cycleDetector3);
                if (!set2.isEmpty() && !z2) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(cycleDetector2);
            }
        }
        Iterator it3 = map.values().iterator();
        while (it3.hasNext()) {
            for (CycleDetector2 cycleDetector22 : (Set) it3.next()) {
                for (Dependency2 dependency2 : cycleDetector22.f12196a.f12176b) {
                    if ((dependency2.f12203c == 0) && (set = (Set) map.get(new CycleDetector3(dependency2.f12201a, dependency2.m6358a(), null))) != null) {
                        for (CycleDetector2 cycleDetector23 : set) {
                            cycleDetector22.f12197b.add(cycleDetector23);
                            cycleDetector23.f12198c.add(cycleDetector22);
                        }
                    }
                }
            }
        }
        HashSet<CycleDetector2> hashSet = new HashSet();
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            hashSet.addAll((Set) it4.next());
        }
        HashSet hashSet2 = new HashSet();
        for (CycleDetector2 cycleDetector24 : hashSet) {
            if (cycleDetector24.m6357a()) {
                hashSet2.add(cycleDetector24);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            CycleDetector2 cycleDetector25 = (CycleDetector2) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector25);
            i++;
            for (CycleDetector2 cycleDetector26 : cycleDetector25.f12197b) {
                cycleDetector26.f12198c.remove(cycleDetector25);
                if (cycleDetector26.m6357a()) {
                    hashSet2.add(cycleDetector26);
                }
            }
        }
        if (i != arrayList.size()) {
            ArrayList arrayList2 = new ArrayList();
            for (CycleDetector2 cycleDetector27 : hashSet) {
                if (!cycleDetector27.m6357a() && !cycleDetector27.f12197b.isEmpty()) {
                    arrayList2.add(cycleDetector27.f12196a);
                }
            }
            throw new DependencyCycleException(arrayList2);
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            Component4<?> component43 = (Component4) it5.next();
            this.f12192b.put(component43, new Lazy2<>(new ComponentRuntime(this, component43)));
        }
        for (Map.Entry<Component4<?>, Lazy2<?>> entry : this.f12192b.entrySet()) {
            Component4<?> key = entry.getKey();
            if (key.m6350b()) {
                Lazy2<?> value = entry.getValue();
                Iterator<Class<? super Object>> it6 = key.f12175a.iterator();
                while (it6.hasNext()) {
                    this.f12193c.put(it6.next(), value);
                }
            }
        }
        for (Component4<?> component44 : this.f12192b.keySet()) {
            for (Dependency2 dependency22 : component44.f12176b) {
                if ((dependency22.f12202b == 1) && !this.f12193c.containsKey(dependency22.f12201a)) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component44, dependency22.f12201a));
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<Component4<?>, Lazy2<?>> entry2 : this.f12192b.entrySet()) {
            Component4<?> key2 = entry2.getKey();
            if (!key2.m6350b()) {
                Lazy2<?> value2 = entry2.getValue();
                for (Class<? super Object> cls2 : key2.f12175a) {
                    if (!map2.containsKey(cls2)) {
                        map2.put(cls2, new HashSet());
                    }
                    ((Set) map2.get(cls2)).add(value2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            this.f12194d.put((Class) entry3.getKey(), new Lazy2<>(new ComponentRuntime2((Set) entry3.getValue())));
        }
    }

    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: b */
    public <T> Provider2<T> mo6355b(Class<T> cls) {
        Objects.requireNonNull(cls, "Null interface requested.");
        return this.f12193c.get(cls);
    }

    @Override // p007b.p225i.p361c.p368l.ComponentContainer
    /* renamed from: c */
    public <T> Provider2<Set<T>> mo6356c(Class<T> cls) {
        Lazy2<Set<?>> lazy2 = this.f12194d.get(cls);
        return lazy2 != null ? lazy2 : ComponentRuntime3.f12190a;
    }
}
