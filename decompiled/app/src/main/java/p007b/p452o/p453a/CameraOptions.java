package p007b.p452o.p453a;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p007b.p452o.p453a.p454m.Audio;
import p007b.p452o.p453a.p454m.AudioCodec;
import p007b.p452o.p453a.p454m.Control;
import p007b.p452o.p453a.p454m.Engine;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Grid;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.Mode3;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.Preview;
import p007b.p452o.p453a.p454m.VideoCodec;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* JADX INFO: renamed from: b.o.a.c, reason: use source file name */
/* JADX INFO: compiled from: CameraOptions.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraOptions {

    /* JADX INFO: renamed from: a */
    public Set<WhiteBalance> f13682a = new HashSet(5);

    /* JADX INFO: renamed from: b */
    public Set<Facing> f13683b = new HashSet(2);

    /* JADX INFO: renamed from: c */
    public Set<Flash> f13684c = new HashSet(4);

    /* JADX INFO: renamed from: d */
    public Set<Hdr> f13685d = new HashSet(2);

    /* JADX INFO: renamed from: e */
    public Set<Size3> f13686e = new HashSet(15);

    /* JADX INFO: renamed from: f */
    public Set<Size3> f13687f = new HashSet(5);

    /* JADX INFO: renamed from: g */
    public Set<AspectRatio2> f13688g = new HashSet(4);

    /* JADX INFO: renamed from: h */
    public Set<AspectRatio2> f13689h = new HashSet(3);

    /* JADX INFO: renamed from: i */
    public Set<PictureFormat> f13690i = new HashSet(2);

    /* JADX INFO: renamed from: j */
    public Set<Integer> f13691j = new HashSet(2);

    /* JADX INFO: renamed from: k */
    public boolean f13692k;

    /* JADX INFO: renamed from: l */
    public boolean f13693l;

    /* JADX INFO: renamed from: m */
    public float f13694m;

    /* JADX INFO: renamed from: n */
    public float f13695n;

    /* JADX INFO: renamed from: o */
    public boolean f13696o;

    /* JADX INFO: renamed from: p */
    public float f13697p;

    /* JADX INFO: renamed from: q */
    public float f13698q;

    @NonNull
    /* JADX INFO: renamed from: a */
    public final Collection<Facing> m7161a() {
        return Collections.unmodifiableSet(this.f13683b);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public final Collection<Flash> m7162b() {
        return Collections.unmodifiableSet(this.f13684c);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m7163c(@NonNull Control control) {
        Class<?> cls = control.getClass();
        return (cls.equals(Audio.class) ? Arrays.asList(Audio.values()) : cls.equals(Facing.class) ? m7161a() : cls.equals(Flash.class) ? m7162b() : cls.equals(Grid.class) ? Arrays.asList(Grid.values()) : cls.equals(Hdr.class) ? Collections.unmodifiableSet(this.f13685d) : cls.equals(Mode3.class) ? Arrays.asList(Mode3.values()) : cls.equals(VideoCodec.class) ? Arrays.asList(VideoCodec.values()) : cls.equals(AudioCodec.class) ? Arrays.asList(AudioCodec.values()) : cls.equals(WhiteBalance.class) ? Collections.unmodifiableSet(this.f13682a) : cls.equals(Engine.class) ? Arrays.asList(Engine.values()) : cls.equals(Preview.class) ? Arrays.asList(Preview.values()) : cls.equals(PictureFormat.class) ? Collections.unmodifiableSet(this.f13690i) : Collections.emptyList()).contains(control);
    }
}
