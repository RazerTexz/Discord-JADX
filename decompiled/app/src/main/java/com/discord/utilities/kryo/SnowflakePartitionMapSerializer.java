package com.discord.utilities.kryo;

import com.discord.utilities.collections.SnowflakePartitionMap;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import d0.d0.f;
import d0.t.c0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SnowflakePartitionMapSerializer.kt */
/* loaded from: classes2.dex */
public final class SnowflakePartitionMapSerializer extends Serializer<SnowflakePartitionMap<?>> {
    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ SnowflakePartitionMap<?> read(Kryo kryo, Input input, Class<SnowflakePartitionMap<?>> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, SnowflakePartitionMap<?> snowflakePartitionMap) throws KryoException {
        write2(kryo, output, snowflakePartitionMap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public SnowflakePartitionMap<?> read(Kryo kryo, Input input, Class<SnowflakePartitionMap<?>> type) throws KryoException {
        m.checkNotNullParameter(kryo, "kryo");
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(type, "type");
        int i = input.readInt(true);
        int i2 = input.readInt(true);
        SnowflakePartitionMap<?> snowflakePartitionMap = new SnowflakePartitionMap<>(i);
        Iterator<Integer> it = f.until(0, i2).iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            snowflakePartitionMap.put(Long.valueOf(input.readLong()), kryo.readClassAndObject(input));
        }
        return snowflakePartitionMap;
    }

    /* renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, SnowflakePartitionMap<?> target) throws KryoException {
        m.checkNotNullParameter(kryo, "kryo");
        m.checkNotNullParameter(output, "output");
        m.checkNotNullParameter(target, "target");
        output.writeInt(target.getNumPartitions(), true);
        output.writeInt(target.size(), true);
        for (Map.Entry<Long, ?> entry : target.entrySet()) {
            output.writeLong(entry.getKey().longValue());
            kryo.writeClassAndObject(output, entry.getValue());
        }
    }
}
