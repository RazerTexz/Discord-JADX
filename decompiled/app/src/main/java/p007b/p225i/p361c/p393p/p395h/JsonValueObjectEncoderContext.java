package p007b.p225i.p361c.p393p.p395h;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ObjectEncoderContext;
import p007b.p225i.p361c.p393p.ValueEncoder;
import p007b.p225i.p361c.p393p.ValueEncoderContext;

/* compiled from: JsonValueObjectEncoderContext.java */
/* renamed from: b.i.c.p.h.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a */
    public boolean f12827a = true;

    /* renamed from: b */
    public final JsonWriter f12828b;

    /* renamed from: c */
    public final Map<Class<?>, ObjectEncoder<?>> f12829c;

    /* renamed from: d */
    public final Map<Class<?>, ValueEncoder<?>> f12830d;

    /* renamed from: e */
    public final ObjectEncoder<Object> f12831e;

    /* renamed from: f */
    public final boolean f12832f;

    public JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z2) {
        this.f12828b = new JsonWriter(writer);
        this.f12829c = map;
        this.f12830d = map2;
        this.f12831e = objectEncoder;
        this.f12832f = z2;
    }

    @Override // p007b.p225i.p361c.p393p.ObjectEncoderContext
    @NonNull
    /* renamed from: a */
    public ObjectEncoderContext mo6705a(@NonNull String str, boolean z2) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(z2);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.ObjectEncoderContext
    @NonNull
    /* renamed from: b */
    public ObjectEncoderContext mo6706b(@NonNull String str, long j) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(j);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.ObjectEncoderContext
    @NonNull
    /* renamed from: c */
    public ObjectEncoderContext mo6707c(@NonNull String str, int i) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(i);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.ValueEncoderContext
    @NonNull
    /* renamed from: d */
    public ValueEncoderContext mo6709d(@Nullable String str) throws IOException {
        m6715i();
        this.f12828b.value(str);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.ValueEncoderContext
    @NonNull
    /* renamed from: e */
    public ValueEncoderContext mo6710e(boolean z2) throws IOException {
        m6715i();
        this.f12828b.value(z2);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.ObjectEncoderContext
    @NonNull
    /* renamed from: f */
    public /* bridge */ /* synthetic */ ObjectEncoderContext mo6708f(@NonNull String str, @Nullable Object obj) throws IOException {
        return m6714h(str, obj);
    }

    @NonNull
    /* renamed from: g */
    public JsonValueObjectEncoderContext m6713g(@Nullable Object obj, boolean z2) throws IOException {
        int i = 0;
        if (z2) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                objArr[0] = obj == null ? null : obj.getClass();
                throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.f12828b.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f12828b.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f12828b.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m6713g(it.next(), false);
                }
                this.f12828b.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f12828b.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m6714h((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.f12828b.endObject();
                return this;
            }
            ObjectEncoder<?> objectEncoder = this.f12829c.get(obj.getClass());
            if (objectEncoder != null) {
                if (!z2) {
                    this.f12828b.beginObject();
                }
                objectEncoder.mo2312a(obj, this);
                if (!z2) {
                    this.f12828b.endObject();
                }
                return this;
            }
            ValueEncoder<?> valueEncoder = this.f12830d.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.mo2312a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                m6715i();
                this.f12828b.value(strName);
                return this;
            }
            ObjectEncoder<Object> objectEncoder2 = this.f12831e;
            if (!z2) {
                this.f12828b.beginObject();
            }
            objectEncoder2.mo2312a(obj, this);
            if (!z2) {
                this.f12828b.endObject();
            }
            return this;
        }
        if (obj instanceof byte[]) {
            m6715i();
            this.f12828b.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        this.f12828b.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.f12828b.value(r6[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                m6715i();
                this.f12828b.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.f12828b.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.f12828b.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                m6713g(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                m6713g(obj2, false);
            }
        }
        this.f12828b.endArray();
        return this;
    }

    @NonNull
    /* renamed from: h */
    public JsonValueObjectEncoderContext m6714h(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f12832f) {
            if (obj == null) {
                return this;
            }
            m6715i();
            this.f12828b.name(str);
            return m6713g(obj, false);
        }
        m6715i();
        this.f12828b.name(str);
        if (obj != null) {
            return m6713g(obj, false);
        }
        this.f12828b.nullValue();
        return this;
    }

    /* renamed from: i */
    public final void m6715i() throws IOException {
        if (!this.f12827a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
