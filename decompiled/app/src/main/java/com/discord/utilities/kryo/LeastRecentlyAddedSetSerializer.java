package com.discord.utilities.kryo;

import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.d0._Ranges;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.Iterator;

/* compiled from: LeastRecentlyAddedSetSerializer.kt */
/* loaded from: classes2.dex */
public final class LeastRecentlyAddedSetSerializer extends Serializer<LeastRecentlyAddedSet<?>> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LeastRecentlyAddedSet<?> leastRecentlyAddedSet) throws KryoException {
        write2(kryo, output, leastRecentlyAddedSet);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public LeastRecentlyAddedSet<?> read(Kryo kryo, Input input, Class<LeastRecentlyAddedSet<?>> type) throws KryoException {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        LeastRecentlyAddedSet<?> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(i, null, 2, null);
        Iterator<Integer> it = _Ranges.until(0, i2).iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
            Object classAndObject = kryo.readClassAndObject(input);
            Intrinsics3.checkNotNullExpressionValue(classAndObject, "kryo.readClassAndObject(input)");
            leastRecentlyAddedSet.add(classAndObject);
        }
        return leastRecentlyAddedSet;
    }

    /* renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, LeastRecentlyAddedSet<?> target) throws KryoException {
        Intrinsics3.checkNotNullParameter(kryo, "kryo");
        Intrinsics3.checkNotNullParameter(output, "output");
        Intrinsics3.checkNotNullParameter(target, "target");
        output.writeInt(target.getMaxSize(), true);
        output.writeInt(target.size(), true);
        Iterator<?> it = target.iterator();
        while (it.hasNext()) {
            kryo.writeClassAndObject(output, it.next());
        }
    }
}
