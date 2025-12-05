package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p170e.ImagePipelineConfigInterface;
import p007b.p109f.p161j.p175j.EncodedImageOrigin;

/* compiled from: ProducerContext.java */
/* renamed from: b.f.j.p.x0, reason: use source file name */
/* loaded from: classes3.dex */
public interface ProducerContext {
    /* renamed from: a */
    Map<String, Object> mo1443a();

    /* renamed from: b */
    Object mo1444b();

    /* renamed from: c */
    Priority2 mo1445c();

    /* renamed from: d */
    <E> void mo1446d(String str, E e);

    /* renamed from: e */
    ImageRequest mo1447e();

    /* renamed from: f */
    void mo1448f(ProducerContextCallbacks producerContextCallbacks);

    /* renamed from: g */
    ImagePipelineConfigInterface mo1449g();

    String getId();

    /* renamed from: h */
    void mo1450h(EncodedImageOrigin encodedImageOrigin);

    /* renamed from: i */
    void mo1451i(String str, String str2);

    /* renamed from: j */
    void mo1452j(Map<String, ?> map);

    /* renamed from: k */
    boolean mo1453k();

    /* renamed from: l */
    <E> E mo1454l(String str);

    /* renamed from: m */
    String mo1455m();

    /* renamed from: n */
    void mo1456n(String str);

    /* renamed from: o */
    ProducerListener2 mo1457o();

    /* renamed from: p */
    boolean mo1458p();

    /* renamed from: q */
    ImageRequest.EnumC10667c mo1459q();
}
