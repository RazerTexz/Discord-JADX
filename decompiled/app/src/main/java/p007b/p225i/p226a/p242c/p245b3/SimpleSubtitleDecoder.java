package p007b.p225i.p226a.p242c.p245b3;

/* compiled from: SimpleSubtitleDecoder.java */
/* renamed from: b.i.a.c.b3.e, reason: use source file name */
/* loaded from: classes3.dex */
public class SimpleSubtitleDecoder extends SubtitleOutputBuffer {

    /* renamed from: n */
    public final /* synthetic */ SimpleSubtitleDecoder2 f5798n;

    public SimpleSubtitleDecoder(SimpleSubtitleDecoder2 simpleSubtitleDecoder2) {
        this.f5798n = simpleSubtitleDecoder2;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer
    /* renamed from: p */
    public void mo2611p() {
        SimpleSubtitleDecoder2 simpleSubtitleDecoder2 = this.f5798n;
        synchronized (simpleSubtitleDecoder2.f7932b) {
            m2618q();
            O[] oArr = simpleSubtitleDecoder2.f7936f;
            int i = simpleSubtitleDecoder2.f7938h;
            simpleSubtitleDecoder2.f7938h = i + 1;
            oArr[i] = this;
            simpleSubtitleDecoder2.m3558g();
        }
    }
}
