package p007b.p195g.p196a.p198b.p201q;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashSet;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonStreamContext;

/* compiled from: JsonWriteContext.java */
/* renamed from: b.g.a.b.q.c, reason: use source file name */
/* loaded from: classes3.dex */
public class JsonWriteContext extends JsonStreamContext {

    /* renamed from: c */
    public final JsonWriteContext f4570c;

    /* renamed from: d */
    public DupDetector f4571d;

    /* renamed from: e */
    public JsonWriteContext f4572e;

    /* renamed from: f */
    public String f4573f;

    /* renamed from: g */
    public Object f4574g;

    /* renamed from: h */
    public boolean f4575h;

    public JsonWriteContext(int i, JsonWriteContext jsonWriteContext, DupDetector dupDetector) {
        this.f4503a = i;
        this.f4570c = jsonWriteContext;
        this.f4571d = dupDetector;
        this.f4504b = -1;
    }

    @Override // p007b.p195g.p196a.p198b.JsonStreamContext
    /* renamed from: a */
    public final String mo1673a() {
        return this.f4573f;
    }

    @Override // p007b.p195g.p196a.p198b.JsonStreamContext
    /* renamed from: d */
    public void mo1676d(Object obj) {
        this.f4574g = obj;
    }

    /* renamed from: f */
    public JsonWriteContext m1706f() {
        JsonWriteContext jsonWriteContext = this.f4572e;
        if (jsonWriteContext != null) {
            jsonWriteContext.m1710j(1);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.f4571d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this, dupDetector == null ? null : dupDetector.m1703a());
        this.f4572e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    /* renamed from: g */
    public JsonWriteContext m1707g(Object obj) {
        JsonWriteContext jsonWriteContext = this.f4572e;
        if (jsonWriteContext != null) {
            jsonWriteContext.m1711k(1, obj);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.f4571d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this, dupDetector == null ? null : dupDetector.m1703a(), obj);
        this.f4572e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    /* renamed from: h */
    public JsonWriteContext m1708h() {
        JsonWriteContext jsonWriteContext = this.f4572e;
        if (jsonWriteContext != null) {
            jsonWriteContext.m1710j(2);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.f4571d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this, dupDetector == null ? null : dupDetector.m1703a());
        this.f4572e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    /* renamed from: i */
    public JsonWriteContext m1709i(Object obj) {
        JsonWriteContext jsonWriteContext = this.f4572e;
        if (jsonWriteContext != null) {
            jsonWriteContext.m1711k(2, obj);
            return jsonWriteContext;
        }
        DupDetector dupDetector = this.f4571d;
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this, dupDetector == null ? null : dupDetector.m1703a(), obj);
        this.f4572e = jsonWriteContext2;
        return jsonWriteContext2;
    }

    /* renamed from: j */
    public JsonWriteContext m1710j(int i) {
        this.f4503a = i;
        this.f4504b = -1;
        this.f4573f = null;
        this.f4575h = false;
        this.f4574g = null;
        DupDetector dupDetector = this.f4571d;
        if (dupDetector != null) {
            dupDetector.f4561b = null;
            dupDetector.f4562c = null;
            dupDetector.f4563d = null;
        }
        return this;
    }

    /* renamed from: k */
    public JsonWriteContext m1711k(int i, Object obj) {
        this.f4503a = i;
        this.f4504b = -1;
        this.f4573f = null;
        this.f4575h = false;
        this.f4574g = obj;
        DupDetector dupDetector = this.f4571d;
        if (dupDetector != null) {
            dupDetector.f4561b = null;
            dupDetector.f4562c = null;
            dupDetector.f4563d = null;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m1712l(String str) throws JsonProcessingException {
        boolean z2;
        if (this.f4503a != 2 || this.f4575h) {
            return 4;
        }
        this.f4575h = true;
        this.f4573f = str;
        DupDetector dupDetector = this.f4571d;
        if (dupDetector != null) {
            String str2 = dupDetector.f4561b;
            if (str2 == null) {
                dupDetector.f4561b = str;
            } else if (!str.equals(str2)) {
                String str3 = dupDetector.f4562c;
                if (str3 == null) {
                    dupDetector.f4562c = str;
                } else {
                    if (str.equals(str3)) {
                        z2 = true;
                    } else {
                        if (dupDetector.f4563d == null) {
                            HashSet<String> hashSet = new HashSet<>(16);
                            dupDetector.f4563d = hashSet;
                            hashSet.add(dupDetector.f4561b);
                            dupDetector.f4563d.add(dupDetector.f4562c);
                        }
                        z2 = !dupDetector.f4563d.add(str);
                    }
                    if (z2) {
                        Object obj = dupDetector.f4560a;
                        throw new JsonGenerationException(outline.m886y("Duplicate field '", str, "'"), obj instanceof JsonGenerator ? (JsonGenerator) obj : null);
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
        }
        return this.f4504b < 0 ? 0 : 1;
    }

    /* renamed from: m */
    public int m1713m() {
        int i = this.f4503a;
        if (i == 2) {
            if (!this.f4575h) {
                return 5;
            }
            this.f4575h = false;
            this.f4504b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.f4504b;
            this.f4504b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.f4504b + 1;
        this.f4504b = i3;
        return i3 == 0 ? 0 : 3;
    }

    public JsonWriteContext(int i, JsonWriteContext jsonWriteContext, DupDetector dupDetector, Object obj) {
        this.f4503a = i;
        this.f4570c = jsonWriteContext;
        this.f4571d = dupDetector;
        this.f4504b = -1;
        this.f4574g = obj;
    }
}
