package p007b.p452o.p453a.p455n.p458q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;
import p007b.p452o.p453a.p454m.Control;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.WhiteBalance;

/* compiled from: Camera2Mapper.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera2Mapper {

    /* renamed from: a */
    public static Camera2Mapper f13961a;

    /* renamed from: b */
    public static final Map<Facing, Integer> f13962b;

    /* renamed from: c */
    public static final Map<WhiteBalance, Integer> f13963c;

    /* renamed from: d */
    public static final Map<Hdr, Integer> f13964d;

    static {
        HashMap map = new HashMap();
        f13962b = map;
        HashMap map2 = new HashMap();
        f13963c = map2;
        HashMap map3 = new HashMap();
        f13964d = map3;
        map.put(Facing.BACK, 1);
        map.put(Facing.FRONT, 0);
        map2.put(WhiteBalance.AUTO, 1);
        map2.put(WhiteBalance.CLOUDY, 6);
        map2.put(WhiteBalance.DAYLIGHT, 5);
        map2.put(WhiteBalance.FLUORESCENT, 3);
        map2.put(WhiteBalance.INCANDESCENT, 2);
        map3.put(Hdr.OFF, 0);
        map3.put(Hdr.ON, 18);
    }

    @Nullable
    /* renamed from: a */
    public final <C extends Control, T> C m7348a(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
