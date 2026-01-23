package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class BlowfishSerializer extends Serializer {
    private static SecretKeySpec keySpec;
    private final Serializer serializer;

    /* JADX INFO: renamed from: com.esotericsoftware.kryo.serializers.BlowfishSerializer$1 */
    public class C106231 extends Output {
        public C106231(OutputStream outputStream, int i) {
            super(outputStream, i);
        }

        @Override // com.esotericsoftware.kryo.p502io.Output, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws KryoException {
        }
    }

    public BlowfishSerializer(Serializer serializer, byte[] bArr) {
        this.serializer = serializer;
        keySpec = new SecretKeySpec(bArr, "Blowfish");
    }

    private static Cipher getCipher(int i) {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(i, keySpec);
            return cipher;
        } catch (Exception e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object copy(Kryo kryo, Object obj) {
        return this.serializer.copy(kryo, obj);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object read(Kryo kryo, Input input, Class cls) {
        return this.serializer.read(kryo, new Input(new CipherInputStream(input, getCipher(2)), 256), cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Object obj) {
        CipherOutputStream cipherOutputStream = new CipherOutputStream(output, getCipher(1));
        C106231 c106231 = new C106231(cipherOutputStream, 256);
        this.serializer.write(kryo, c106231, obj);
        c106231.flush();
        try {
            cipherOutputStream.close();
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }
}
