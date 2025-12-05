package p007b.p225i.p226a.p242c;

import android.net.Uri;
import android.os.Bundle;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.MediaMetadata;

/* compiled from: lambda */
/* renamed from: b.i.a.c.l0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2818l0 implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2818l0 f7237a = new C2818l0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        MediaMetadata.b bVar = new MediaMetadata.b();
        bVar.f7407a = bundle.getCharSequence(MediaMetadata.m3343b(0));
        bVar.f7408b = bundle.getCharSequence(MediaMetadata.m3343b(1));
        bVar.f7409c = bundle.getCharSequence(MediaMetadata.m3343b(2));
        bVar.f7410d = bundle.getCharSequence(MediaMetadata.m3343b(3));
        bVar.f7411e = bundle.getCharSequence(MediaMetadata.m3343b(4));
        bVar.f7412f = bundle.getCharSequence(MediaMetadata.m3343b(5));
        bVar.f7413g = bundle.getCharSequence(MediaMetadata.m3343b(6));
        bVar.f7414h = (Uri) bundle.getParcelable(MediaMetadata.m3343b(7));
        byte[] byteArray = bundle.getByteArray(MediaMetadata.m3343b(10));
        Integer numValueOf = bundle.containsKey(MediaMetadata.m3343b(29)) ? Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(29))) : null;
        bVar.f7417k = byteArray != null ? (byte[]) byteArray.clone() : null;
        bVar.f7418l = numValueOf;
        bVar.f7419m = (Uri) bundle.getParcelable(MediaMetadata.m3343b(11));
        bVar.f7430x = bundle.getCharSequence(MediaMetadata.m3343b(22));
        bVar.f7431y = bundle.getCharSequence(MediaMetadata.m3343b(23));
        bVar.f7432z = bundle.getCharSequence(MediaMetadata.m3343b(24));
        bVar.f7404C = bundle.getCharSequence(MediaMetadata.m3343b(27));
        bVar.f7405D = bundle.getCharSequence(MediaMetadata.m3343b(28));
        bVar.f7406E = bundle.getBundle(MediaMetadata.m3343b(1000));
        if (bundle.containsKey(MediaMetadata.m3343b(8)) && (bundle3 = bundle.getBundle(MediaMetadata.m3343b(8))) != null) {
            int i = Rating.f6334j;
            bVar.f7415i = (Rating) C2830o0.f7260a.mo2576a(bundle3);
        }
        if (bundle.containsKey(MediaMetadata.m3343b(9)) && (bundle2 = bundle.getBundle(MediaMetadata.m3343b(9))) != null) {
            int i2 = Rating.f6334j;
            bVar.f7416j = (Rating) C2830o0.f7260a.mo2576a(bundle2);
        }
        if (bundle.containsKey(MediaMetadata.m3343b(12))) {
            bVar.f7420n = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(12)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(13))) {
            bVar.f7421o = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(13)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(14))) {
            bVar.f7422p = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(14)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(15))) {
            bVar.f7423q = Boolean.valueOf(bundle.getBoolean(MediaMetadata.m3343b(15)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(16))) {
            bVar.f7424r = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(16)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(17))) {
            bVar.f7425s = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(17)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(18))) {
            bVar.f7426t = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(18)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(19))) {
            bVar.f7427u = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(19)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(20))) {
            bVar.f7428v = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(20)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(21))) {
            bVar.f7429w = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(21)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(25))) {
            bVar.f7402A = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(25)));
        }
        if (bundle.containsKey(MediaMetadata.m3343b(26))) {
            bVar.f7403B = Integer.valueOf(bundle.getInt(MediaMetadata.m3343b(26)));
        }
        return bVar.m3345a();
    }
}
