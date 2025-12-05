package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import p007b.p100d.p104b.p105a.outline;

/* loaded from: classes.dex */
public class EnumNameSerializer extends Serializer<Enum> {
    private final Class<? extends Enum> enumType;
    private final Serializer stringSerializer;

    public EnumNameSerializer(Kryo kryo, Class<? extends Enum> cls) {
        this.enumType = cls;
        this.stringSerializer = kryo.getSerializer(String.class);
        setImmutable(true);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ Enum read(Kryo kryo, Input input, Class<Enum> cls) {
        return read(kryo, input, cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Enum r3) {
        write2(kryo, output, r3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.esotericsoftware.kryo.Serializer
    public Enum read(Kryo kryo, Input input, Class<Enum> cls) {
        String str = (String) kryo.readObject(input, String.class, this.stringSerializer);
        try {
            return Enum.valueOf(this.enumType, str);
        } catch (IllegalArgumentException e) {
            StringBuilder sbM833U = outline.m833U("Invalid name for enum \"");
            sbM833U.append(this.enumType.getName());
            sbM833U.append("\": ");
            sbM833U.append(str);
            throw new KryoException(sbM833U.toString(), e);
        }
    }

    /* renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(Kryo kryo, Output output, Enum r4) {
        kryo.writeObject(output, r4.name(), this.stringSerializer);
    }
}
