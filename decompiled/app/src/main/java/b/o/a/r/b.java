package b.o.a.r;

import android.util.Range;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FpsRangeValidator.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public class b {
    public static final b.o.a.b a = new b.o.a.b("FpsRangeValidator");

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, List<Range<Integer>>> f1949b;

    static {
        HashMap map = new HashMap();
        f1949b = map;
        map.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
        map.put("Google Pixel 4a", Arrays.asList(new Range(15, 60)));
    }
}
