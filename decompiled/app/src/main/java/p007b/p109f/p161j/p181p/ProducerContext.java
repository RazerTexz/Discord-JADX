package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p170e.ImagePipelineConfigInterface;
import p007b.p109f.p161j.p175j.EncodedImageOrigin;

/* JADX INFO: renamed from: b.f.j.p.x0, reason: use source file name */
/* JADX INFO: compiled from: ProducerContext.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ProducerContext {
    /* JADX INFO: renamed from: a */
    Map<String, Object> mo1443a();

    /* JADX INFO: renamed from: b */
    Object mo1444b();

    /* JADX INFO: renamed from: c */
    Priority2 mo1445c();

    /* JADX INFO: renamed from: d */
    <E> void mo1446d(String str, E e);

    /* JADX INFO: renamed from: e */
    ImageRequest mo1447e();

    /* JADX INFO: renamed from: f */
    void mo1448f(ProducerContextCallbacks producerContextCallbacks);

    /* JADX INFO: renamed from: g */
    ImagePipelineConfigInterface mo1449g();

    String getId();

    /* JADX INFO: renamed from: h */
    void mo1450h(EncodedImageOrigin encodedImageOrigin);

    /* JADX INFO: renamed from: i */
    void mo1451i(String str, String str2);

    /* JADX INFO: renamed from: j */
    void mo1452j(Map<String, ?> map);

    /* JADX INFO: renamed from: k */
    boolean mo1453k();

    /* JADX INFO: renamed from: l */
    <E> E mo1454l(String str);

    /* JADX INFO: renamed from: m */
    String mo1455m();

    /* JADX INFO: renamed from: n */
    void mo1456n(String str);

    /* JADX INFO: renamed from: o */
    ProducerListener2 mo1457o();

    /* JADX INFO: renamed from: p */
    boolean mo1458p();

    /* JADX INFO: renamed from: q */
    ImageRequest.EnumC10667c mo1459q();
}
