package p007b.p452o.p453a.p467r;

import android.util.Range;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p452o.p453a.CameraLogger;

/* compiled from: FpsRangeValidator.java */
@RequiresApi(21)
/* renamed from: b.o.a.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FpsRangeValidator {

    /* renamed from: a */
    public static final CameraLogger f14103a = new CameraLogger("FpsRangeValidator");

    /* renamed from: b */
    public static final Map<String, List<Range<Integer>>> f14104b;

    static {
        HashMap map = new HashMap();
        f14104b = map;
        map.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
        map.put("Google Pixel 4a", Arrays.asList(new Range(15, 60)));
    }
}
