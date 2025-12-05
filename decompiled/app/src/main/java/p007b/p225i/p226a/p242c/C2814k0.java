package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.MediaItem2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.k0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2814k0 implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2814k0 f7194a = new C2814k0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        String string = bundle.getString(MediaItem2.m3319a(0), "");
        Objects.requireNonNull(string);
        Bundle bundle2 = bundle.getBundle(MediaItem2.m3319a(1));
        MediaItem2.g gVar = bundle2 == null ? MediaItem2.g.f7306j : (MediaItem2.g) MediaItem2.g.f7307k.mo2576a(bundle2);
        Bundle bundle3 = bundle.getBundle(MediaItem2.m3319a(2));
        MediaMetadata mediaMetadata = bundle3 == null ? MediaMetadata.f7368j : (MediaMetadata) MediaMetadata.f7369k.mo2576a(bundle3);
        Bundle bundle4 = bundle.getBundle(MediaItem2.m3319a(3));
        return new MediaItem2(string, bundle4 == null ? MediaItem2.e.f7289p : (MediaItem2.e) MediaItem2.d.f7278j.mo2576a(bundle4), null, gVar, mediaMetadata);
    }
}
