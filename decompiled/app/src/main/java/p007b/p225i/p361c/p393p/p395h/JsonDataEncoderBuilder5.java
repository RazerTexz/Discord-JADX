package p007b.p225i.p361c.p393p.p395h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ValueEncoder;
import p007b.p225i.p361c.p393p.ValueEncoderContext;
import p007b.p225i.p361c.p393p.p394g.EncoderConfig;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonDataEncoderBuilder5 implements EncoderConfig<JsonDataEncoderBuilder5> {

    /* renamed from: a */
    public static final a f12821a = new a(null);

    /* renamed from: b */
    public final Map<Class<?>, ObjectEncoder<?>> f12822b;

    /* renamed from: c */
    public final Map<Class<?>, ValueEncoder<?>> f12823c;

    /* renamed from: d */
    public ObjectEncoder<Object> f12824d;

    /* renamed from: e */
    public boolean f12825e;

    /* compiled from: JsonDataEncoderBuilder.java */
    /* renamed from: b.i.c.p.h.e$a */
    public static final class a implements ValueEncoder<Date> {

        /* renamed from: a */
        public static final DateFormat f12826a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f12826a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(JsonDataEncoderBuilder4 jsonDataEncoderBuilder4) {
        }

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(@NonNull Object obj, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.mo6709d(f12826a.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder5() {
        HashMap map = new HashMap();
        this.f12822b = map;
        HashMap map2 = new HashMap();
        this.f12823c = map2;
        this.f12824d = JsonDataEncoderBuilder.f12817a;
        this.f12825e = false;
        map2.put(String.class, JsonDataEncoderBuilder2.f12818a);
        map.remove(String.class);
        map2.put(Boolean.class, JsonDataEncoderBuilder3.f12819a);
        map.remove(Boolean.class);
        map2.put(Date.class, f12821a);
        map.remove(Date.class);
    }
}
