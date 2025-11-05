package b.o.a.r;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import com.discord.utilities.voice.ScreenShareManager;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* compiled from: CamcorderProfiles.java */
/* loaded from: classes3.dex */
public class a {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public static Map<b.o.a.x.b, Integer> f1948b;

    /* compiled from: CamcorderProfiles.java */
    /* renamed from: b.o.a.r.a$a, reason: collision with other inner class name */
    public class C0176a implements Comparator<b.o.a.x.b> {
        public final /* synthetic */ long j;

        public C0176a(long j) {
            this.j = j;
        }

        @Override // java.util.Comparator
        public int compare(b.o.a.x.b bVar, b.o.a.x.b bVar2) {
            b.o.a.x.b bVar3 = bVar;
            b.o.a.x.b bVar4 = bVar2;
            long jAbs = Math.abs((bVar3.j * bVar3.k) - this.j);
            long jAbs2 = Math.abs((bVar4.j * bVar4.k) - this.j);
            if (jAbs < jAbs2) {
                return -1;
            }
            return jAbs == jAbs2 ? 0 : 1;
        }
    }

    static {
        HashMap map = new HashMap();
        f1948b = map;
        map.put(new b.o.a.x.b(Opcodes.ARETURN, Opcodes.D2F), 2);
        f1948b.put(new b.o.a.x.b(320, 240), 7);
        f1948b.put(new b.o.a.x.b(352, ScreenShareManager.THUMBNAIL_HEIGHT_PX), 3);
        f1948b.put(new b.o.a.x.b(720, 480), 4);
        f1948b.put(new b.o.a.x.b(1280, 720), 5);
        f1948b.put(new b.o.a.x.b(1920, WidgetEditUserOrGuildMemberProfile.MAX_BANNER_IMAGE_SIZE), 6);
        f1948b.put(new b.o.a.x.b(3840, 2160), 8);
    }

    @NonNull
    public static CamcorderProfile a(int i, @NonNull b.o.a.x.b bVar) {
        long j = bVar.j * bVar.k;
        ArrayList arrayList = new ArrayList(f1948b.keySet());
        Collections.sort(arrayList, new C0176a(j));
        while (arrayList.size() > 0) {
            int iIntValue = f1948b.get((b.o.a.x.b) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                return CamcorderProfile.get(i, iIntValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }

    @NonNull
    public static CamcorderProfile b(@NonNull String str, @NonNull b.o.a.x.b bVar) {
        try {
            return a(Integer.parseInt(str), bVar);
        } catch (NumberFormatException unused) {
            a.a(2, "NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }
}
