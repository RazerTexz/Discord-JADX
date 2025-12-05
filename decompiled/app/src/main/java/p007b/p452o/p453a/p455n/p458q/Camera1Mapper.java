package p007b.p452o.p453a.p455n.p458q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import p007b.p452o.p453a.p454m.Control;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.WhiteBalance;

/* compiled from: Camera1Mapper.java */
/* renamed from: b.o.a.n.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera1Mapper {

    /* renamed from: a */
    public static Camera1Mapper f13956a;

    /* renamed from: b */
    public static final Map<Flash, String> f13957b;

    /* renamed from: c */
    public static final Map<WhiteBalance, String> f13958c;

    /* renamed from: d */
    public static final Map<Facing, Integer> f13959d;

    /* renamed from: e */
    public static final Map<Hdr, String> f13960e;

    static {
        HashMap map = new HashMap();
        f13957b = map;
        HashMap map2 = new HashMap();
        f13958c = map2;
        HashMap map3 = new HashMap();
        f13959d = map3;
        HashMap map4 = new HashMap();
        f13960e = map4;
        map.put(Flash.OFF, "off");
        map.put(Flash.ON, "on");
        map.put(Flash.AUTO, "auto");
        map.put(Flash.TORCH, "torch");
        map3.put(Facing.BACK, 0);
        map3.put(Facing.FRONT, 1);
        map2.put(WhiteBalance.AUTO, "auto");
        map2.put(WhiteBalance.INCANDESCENT, "incandescent");
        map2.put(WhiteBalance.FLUORESCENT, "fluorescent");
        map2.put(WhiteBalance.DAYLIGHT, "daylight");
        map2.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        map4.put(Hdr.OFF, "auto");
        map4.put(Hdr.ON, "hdr");
    }

    @NonNull
    /* renamed from: a */
    public static Camera1Mapper m7346a() {
        if (f13956a == null) {
            f13956a = new Camera1Mapper();
        }
        return f13956a;
    }

    @Nullable
    /* renamed from: b */
    public final <C extends Control, T> C m7347b(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
