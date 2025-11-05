package b.i.c.p.h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: JsonDataEncoderBuilder.java */
/* loaded from: classes3.dex */
public final class e implements b.i.c.p.g.b<e> {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, b.i.c.p.c<?>> f1761b;
    public final Map<Class<?>, b.i.c.p.e<?>> c;
    public b.i.c.p.c<Object> d;
    public boolean e;

    /* compiled from: JsonDataEncoderBuilder.java */
    public static final class a implements b.i.c.p.e<Date> {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(d dVar) {
        }

        @Override // b.i.c.p.b
        public void a(@NonNull Object obj, @NonNull b.i.c.p.f fVar) throws IOException {
            fVar.d(a.format((Date) obj));
        }
    }

    public e() {
        HashMap map = new HashMap();
        this.f1761b = map;
        HashMap map2 = new HashMap();
        this.c = map2;
        this.d = b.i.c.p.h.a.a;
        this.e = false;
        map2.put(String.class, b.a);
        map.remove(String.class);
        map2.put(Boolean.class, c.a);
        map.remove(Boolean.class);
        map2.put(Date.class, a);
        map.remove(Date.class);
    }
}
