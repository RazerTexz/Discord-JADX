package p007b.p225i.p361c.p393p.p395h;

import com.google.firebase.encoders.EncodingException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ObjectEncoderContext;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.a, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class JsonDataEncoderBuilder implements ObjectEncoder {

    /* renamed from: a */
    public static final JsonDataEncoderBuilder f12817a = new JsonDataEncoderBuilder();

    @Override // p007b.p225i.p361c.p393p.Encoder
    /* renamed from: a */
    public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) {
        JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.f12821a;
        StringBuilder sbM833U = outline.m833U("Couldn't find encoder for type ");
        sbM833U.append(obj.getClass().getCanonicalName());
        throw new EncodingException(sbM833U.toString());
    }
}
