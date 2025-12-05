package p007b.p109f.p161j.p181p;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p170e.ImagePipelineConfigInterface;

/* compiled from: SettableProducerContext.java */
/* renamed from: b.f.j.p.d1, reason: use source file name */
/* loaded from: classes3.dex */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ImageRequest imageRequest, ProducerContext producerContext) {
        super(imageRequest, producerContext.getId(), producerContext.mo1455m(), producerContext.mo1457o(), producerContext.mo1444b(), producerContext.mo1459q(), producerContext.mo1453k(), producerContext.mo1458p(), producerContext.mo1445c(), producerContext.mo1449g());
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.EnumC10667c enumC10667c, boolean z2, boolean z3, Priority2 priority2, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, str2, producerListener2, obj, enumC10667c, z2, z3, priority2, imagePipelineConfigInterface);
    }
}
