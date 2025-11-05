package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.collections.ShallowPartitionImmutableCollection;
import d0.a0.a;
import d0.d0.f;
import d0.t.c0;
import d0.t.n;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.g0.d;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* compiled from: ShallowPartitionMap.kt */
/* loaded from: classes2.dex */
public class ShallowPartitionMap<K, V> implements Map<K, V>, d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int numPartitions;
    private final Function1<K, Integer> partitionStrategy;
    private final List<Map<K, V>> partitions;
    private int size;

    /* compiled from: ShallowPartitionMap.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShallowPartitionMap create$default(Companion companion, int i, int i2, int i3, Function1 function1, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 100;
            }
            if ((i4 & 4) != 0) {
                i3 = a.roundToInt((float) Math.ceil((i > 0 ? i : 1) / i2));
            }
            if ((i4 & 8) != 0) {
                function1 = companion.getHashCodePartitionStrategy(i3);
            }
            return companion.create(i, i2, i3, function1);
        }

        private final <K> Function1<K, Integer> getHashCodePartitionStrategy(int numPartitions) {
            return new ShallowPartitionMap$Companion$getHashCodePartitionStrategy$1(numPartitions);
        }

        public final <K, V> ShallowPartitionMap<K, V> create(int mapSize, int partitionSize, int partitionCount, Function1<? super K, Integer> partitionStrategy) {
            m.checkNotNullParameter(partitionStrategy, "partitionStrategy");
            IntRange intRange = new IntRange(0, partitionCount);
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ((c0) it).nextInt();
                arrayList.add(new HashMap(partitionSize));
            }
            return new ShallowPartitionMap<>(arrayList, partitionStrategy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ShallowPartitionMap.kt */
    public static class CopiablePartitionMap<K, V> extends ShallowPartitionMap<K, V> {
        private List<? extends Map<K, V>> defensiveCopyPartitions;
        private final HashSet<Integer> dirtyPartitionIndices;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopiablePartitionMap(int i, Function1<? super K, Integer> function1) {
            super(i, function1);
            m.checkNotNullParameter(function1, "partitionStrategy");
            this.dirtyPartitionIndices = u.toHashSet(n.getIndices(getPartitions()));
            this.defensiveCopyPartitions = defensiveCopy(getPartitions());
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
        public void clear() {
            r.addAll(this.dirtyPartitionIndices, n.getIndices(getPartitions()));
            super.clear();
        }

        public final List<Map<K, V>> defensiveCopy(List<? extends Map<K, V>> list) {
            m.checkNotNullParameter(list, "$this$defensiveCopy");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                Object map = (Map) obj;
                if (this.dirtyPartitionIndices.contains(Integer.valueOf(i))) {
                    map = new HashMap(getPartitions().get(i));
                }
                arrayList.add(map);
                i = i2;
            }
            return arrayList;
        }

        public Map<K, V> fastCopy() {
            setDefensiveCopyPartitions(defensiveCopy(this.defensiveCopyPartitions));
            return new ShallowPartitionMap(this.defensiveCopyPartitions, getPartitionStrategy());
        }

        public final List<Map<K, V>> getDefensiveCopyPartitions() {
            return this.defensiveCopyPartitions;
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap
        public Map<K, V> getPartitionForWrite(K key) {
            int iIntValue = getPartitionStrategy().invoke(key).intValue();
            this.dirtyPartitionIndices.add(Integer.valueOf(iIntValue));
            return getPartitions().get(iIntValue);
        }

        public final void setDefensiveCopyPartitions(List<? extends Map<K, V>> list) {
            m.checkNotNullParameter(list, "value");
            this.defensiveCopyPartitions = list;
            this.dirtyPartitionIndices.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShallowPartitionMap(List<? extends Map<K, V>> list, Function1<? super K, Integer> function1) {
        m.checkNotNullParameter(list, "partitions");
        m.checkNotNullParameter(function1, "partitionStrategy");
        this.partitions = list;
        this.partitionStrategy = function1;
        this.numPartitions = list.size();
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Map) it.next()).size();
        }
        this.size = size;
    }

    private final Map<K, V> getPartition(K key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    @Override // java.util.Map
    public void clear() {
        Iterator<T> it = this.partitions.iterator();
        while (it.hasNext()) {
            ((Map) it.next()).clear();
        }
        setSize(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return getPartition(key).containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        List<Map<K, V>> list = this.partitions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        return getPartition(key).get(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).entrySet());
        }
        return new ShallowPartitionImmutableCollection.Set(arrayList, new ShallowPartitionMap$entries$2(this));
    }

    public Set<K> getKeys() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).keySet());
        }
        return new ShallowPartitionImmutableCollection.Set(arrayList, this.partitionStrategy);
    }

    public final int getNumPartitions() {
        return this.numPartitions;
    }

    public Map<K, V> getPartitionForWrite(K key) {
        return this.partitions.get(this.partitionStrategy.invoke(key).intValue());
    }

    public final Function1<K, Integer> getPartitionStrategy() {
        return this.partitionStrategy;
    }

    public final List<Map<K, V>> getPartitions() {
        return this.partitions;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        List<Map<K, V>> list = this.partitions;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map) it.next()).values());
        }
        return new ShallowPartitionImmutableCollection(arrayList, null, 2, null);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        V vPut = getPartitionForWrite(key).put(key, value);
        if (vPut == null) {
            setSize(size() + 1);
        }
        return vPut;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        m.checkNotNullParameter(from, "from");
        for (Map.Entry<? extends K, ? extends V> entry : from.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        V vRemove = getPartitionForWrite(key).remove(key);
        if (vRemove == null) {
            return null;
        }
        setSize(size() - 1);
        return vRemove;
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public /* synthetic */ ShallowPartitionMap(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 200 : i, function1);
    }

    public ShallowPartitionMap(int i, Function1<? super K, Integer> function1) {
        m.checkNotNullParameter(function1, "partitionStrategy");
        IntRange intRangeUntil = f.until(0, i);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            arrayList.add(new HashMap());
        }
        this(arrayList, function1);
    }
}
