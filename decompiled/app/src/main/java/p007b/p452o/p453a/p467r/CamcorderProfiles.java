package p007b.p452o.p453a.p467r;

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
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p473x.Size3;

/* JADX INFO: renamed from: b.o.a.r.a, reason: use source file name */
/* JADX INFO: compiled from: CamcorderProfiles.java */
/* JADX INFO: loaded from: classes3.dex */
public class CamcorderProfiles {

    /* JADX INFO: renamed from: a */
    public static final CameraLogger f14100a = new CameraLogger(CamcorderProfiles.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    @SuppressLint({"UseSparseArrays"})
    public static Map<Size3, Integer> f14101b;

    /* JADX INFO: renamed from: b.o.a.r.a$a */
    /* JADX INFO: compiled from: CamcorderProfiles.java */
    public class a implements Comparator<Size3> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ long f14102j;

        public a(long j) {
            this.f14102j = j;
        }

        @Override // java.util.Comparator
        public int compare(Size3 size3, Size3 size32) {
            Size3 size33 = size3;
            Size3 size34 = size32;
            long jAbs = Math.abs(((long) (size33.f14251j * size33.f14252k)) - this.f14102j);
            long jAbs2 = Math.abs(((long) (size34.f14251j * size34.f14252k)) - this.f14102j);
            if (jAbs < jAbs2) {
                return -1;
            }
            return jAbs == jAbs2 ? 0 : 1;
        }
    }

    static {
        HashMap map = new HashMap();
        f14101b = map;
        map.put(new Size3(Opcodes.ARETURN, Opcodes.D2F), 2);
        f14101b.put(new Size3(320, 240), 7);
        f14101b.put(new Size3(352, ScreenShareManager.THUMBNAIL_HEIGHT_PX), 3);
        f14101b.put(new Size3(720, 480), 4);
        f14101b.put(new Size3(1280, 720), 5);
        f14101b.put(new Size3(1920, WidgetEditUserOrGuildMemberProfile.MAX_BANNER_IMAGE_SIZE), 6);
        f14101b.put(new Size3(3840, 2160), 8);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static CamcorderProfile m7397a(int i, @NonNull Size3 size3) {
        long j = ((long) size3.f14251j) * ((long) size3.f14252k);
        ArrayList arrayList = new ArrayList(f14101b.keySet());
        Collections.sort(arrayList, new a(j));
        while (arrayList.size() > 0) {
            int iIntValue = f14101b.get((Size3) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                return CamcorderProfile.get(i, iIntValue);
            }
        }
        return CamcorderProfile.get(i, 0);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static CamcorderProfile m7398b(@NonNull String str, @NonNull Size3 size3) {
        try {
            return m7397a(Integer.parseInt(str), size3);
        } catch (NumberFormatException unused) {
            f14100a.m7159a(2, "NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }
}
