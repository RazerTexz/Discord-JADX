package p007b.p225i.p226a.p242c.p257e3.p258b0;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p355b.p356a.Charsets;

/* compiled from: DefaultContentMetadata.java */
/* renamed from: b.i.a.c.e3.b0.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultContentMetadata implements ContentMetadata2 {

    /* renamed from: a */
    public static final DefaultContentMetadata f6498a = new DefaultContentMetadata(Collections.emptyMap());

    /* renamed from: b */
    public int f6499b;

    /* renamed from: c */
    public final Map<String, byte[]> f6500c;

    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }

    /* renamed from: b */
    public static boolean m2816b(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public DefaultContentMetadata m2817a(ContentMetadataMutations contentMetadataMutations) {
        byte[] bytes;
        HashMap map = new HashMap(this.f6500c);
        Objects.requireNonNull(contentMetadataMutations);
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(contentMetadataMutations.f6497b));
        for (int i = 0; i < listUnmodifiableList.size(); i++) {
            map.remove(listUnmodifiableList.get(i));
        }
        HashMap map2 = new HashMap(contentMetadataMutations.f6496a);
        for (Map.Entry entry : map2.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        for (Map.Entry entry2 : Collections.unmodifiableMap(map2).entrySet()) {
            String str = (String) entry2.getKey();
            Object value2 = entry2.getValue();
            if (value2 instanceof Long) {
                bytes = ByteBuffer.allocate(8).putLong(((Long) value2).longValue()).array();
            } else if (value2 instanceof String) {
                bytes = ((String) value2).getBytes(Charsets.f11945c);
            } else {
                if (!(value2 instanceof byte[])) {
                    throw new IllegalArgumentException();
                }
                bytes = (byte[]) value2;
            }
            map.put(str, bytes);
        }
        return m2816b(this.f6500c, map) ? this : new DefaultContentMetadata(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return m2816b(this.f6500c, ((DefaultContentMetadata) obj).f6500c);
    }

    public int hashCode() {
        if (this.f6499b == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.f6500c.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f6499b = iHashCode;
        }
        return this.f6499b;
    }

    public DefaultContentMetadata(Map<String, byte[]> map) {
        this.f6500c = Collections.unmodifiableMap(map);
    }
}
