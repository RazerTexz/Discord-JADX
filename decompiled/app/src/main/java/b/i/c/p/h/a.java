package b.i.c.p.h;

import b.i.c.p.h.e;
import com.google.firebase.encoders.EncodingException;

/* compiled from: JsonDataEncoderBuilder.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements b.i.c.p.c {
    public static final a a = new a();

    @Override // b.i.c.p.b
    public void a(Object obj, b.i.c.p.d dVar) {
        e.a aVar = e.a;
        StringBuilder sbU = b.d.b.a.a.U("Couldn't find encoder for type ");
        sbU.append(obj.getClass().getCanonicalName());
        throw new EncodingException(sbU.toString());
    }
}
