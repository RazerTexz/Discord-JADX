package p007b.p109f.p161j.p181p;

import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p109f.p115d.p119d.ImmutableSet;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p170e.ImagePipelineConfigInterface;
import p007b.p109f.p161j.p175j.EncodedImageOrigin;

/* compiled from: BaseProducerContext.java */
/* renamed from: b.f.j.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public class BaseProducerContext implements ProducerContext {

    /* renamed from: a */
    public static final Set<String> f4025a;

    /* renamed from: b */
    public final ImageRequest f4026b;

    /* renamed from: c */
    public final String f4027c;

    /* renamed from: d */
    public final String f4028d;

    /* renamed from: e */
    public final ProducerListener2 f4029e;

    /* renamed from: f */
    public final Object f4030f;

    /* renamed from: g */
    public final ImageRequest.EnumC10667c f4031g;

    /* renamed from: h */
    public final Map<String, Object> f4032h;

    /* renamed from: i */
    public boolean f4033i;

    /* renamed from: j */
    public Priority2 f4034j;

    /* renamed from: k */
    public boolean f4035k;

    /* renamed from: l */
    public boolean f4036l;

    /* renamed from: m */
    public final List<ProducerContextCallbacks> f4037m;

    /* renamed from: n */
    public final ImagePipelineConfigInterface f4038n;

    static {
        String[] strArr = {ModelAuditLogEntry.CHANGE_KEY_ID, "uri_source"};
        int i = ImmutableSet.f3093j;
        HashSet hashSet = new HashSet(2);
        Collections.addAll(hashSet, strArr);
        f4025a = new ImmutableSet(hashSet);
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.EnumC10667c enumC10667c, boolean z2, boolean z3, Priority2 priority2, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.f4026b = imageRequest;
        this.f4027c = str;
        HashMap map = new HashMap();
        this.f4032h = map;
        map.put(ModelAuditLogEntry.CHANGE_KEY_ID, str);
        map.put("uri_source", imageRequest == null ? "null-request" : imageRequest.f19585c);
        this.f4028d = str2;
        this.f4029e = producerListener2;
        this.f4030f = obj;
        this.f4031g = enumC10667c;
        this.f4033i = z2;
        this.f4034j = priority2;
        this.f4035k = z3;
        this.f4036l = false;
        this.f4037m = new ArrayList();
        this.f4038n = imagePipelineConfigInterface;
    }

    /* renamed from: r */
    public static void m1440r(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1439b();
        }
    }

    /* renamed from: s */
    public static void m1441s(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1463d();
        }
    }

    /* renamed from: t */
    public static void m1442t(List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo1462c();
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: a */
    public Map<String, Object> mo1443a() {
        return this.f4032h;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: b */
    public Object mo1444b() {
        return this.f4030f;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: c */
    public synchronized Priority2 mo1445c() {
        return this.f4034j;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: d */
    public void mo1446d(String str, Object obj) {
        if (f4025a.contains(str)) {
            return;
        }
        this.f4032h.put(str, obj);
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: e */
    public ImageRequest mo1447e() {
        return this.f4026b;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: f */
    public void mo1448f(ProducerContextCallbacks producerContextCallbacks) {
        boolean z2;
        synchronized (this) {
            this.f4037m.add(producerContextCallbacks);
            z2 = this.f4036l;
        }
        if (z2) {
            producerContextCallbacks.mo1438a();
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: g */
    public ImagePipelineConfigInterface mo1449g() {
        return this.f4038n;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    public String getId() {
        return this.f4027c;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: h */
    public void mo1450h(EncodedImageOrigin encodedImageOrigin) {
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: i */
    public void mo1451i(String str, String str2) {
        this.f4032h.put("origin", str);
        this.f4032h.put("origin_sub", str2);
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: j */
    public void mo1452j(Map<String, ?> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            mo1446d(entry.getKey(), entry.getValue());
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: k */
    public synchronized boolean mo1453k() {
        return this.f4033i;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: l */
    public <T> T mo1454l(String str) {
        return (T) this.f4032h.get(str);
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: m */
    public String mo1455m() {
        return this.f4028d;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: n */
    public void mo1456n(String str) {
        this.f4032h.put("origin", str);
        this.f4032h.put("origin_sub", "default");
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: o */
    public ProducerListener2 mo1457o() {
        return this.f4029e;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: p */
    public synchronized boolean mo1458p() {
        return this.f4035k;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContext
    /* renamed from: q */
    public ImageRequest.EnumC10667c mo1459q() {
        return this.f4031g;
    }

    /* renamed from: u */
    public void m1460u() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.f4036l) {
                arrayList = null;
            } else {
                this.f4036l = true;
                arrayList = new ArrayList(this.f4037m);
            }
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).mo1438a();
        }
    }

    /* renamed from: v */
    public synchronized List<ProducerContextCallbacks> m1461v(Priority2 priority2) {
        if (priority2 == this.f4034j) {
            return null;
        }
        this.f4034j = priority2;
        return new ArrayList(this.f4037m);
    }
}
