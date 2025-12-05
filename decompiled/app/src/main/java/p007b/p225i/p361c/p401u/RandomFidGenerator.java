package p007b.p225i.p361c.p401u;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* compiled from: RandomFidGenerator.java */
/* renamed from: b.i.c.u.l, reason: use source file name */
/* loaded from: classes3.dex */
public class RandomFidGenerator {

    /* renamed from: a */
    public static final byte f12946a = Byte.parseByte("01110000", 2);

    /* renamed from: b */
    public static final byte f12947b = Byte.parseByte("00001111", 2);

    @NonNull
    /* renamed from: a */
    public String m6769a() {
        UUID uuidRandomUUID = UUID.randomUUID();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[17]);
        byteBufferWrap.putLong(uuidRandomUUID.getMostSignificantBits());
        byteBufferWrap.putLong(uuidRandomUUID.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        bArrArray[16] = bArrArray[0];
        bArrArray[0] = (byte) ((f12947b & bArrArray[0]) | f12946a);
        return new String(Base64.encode(bArrArray, 11), Charset.defaultCharset()).substring(0, 22);
    }
}
