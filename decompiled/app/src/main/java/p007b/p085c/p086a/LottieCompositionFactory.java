package p007b.p085c.p086a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import p007b.p085c.p086a.p087a0.LottieCompositionMoshiParser;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p087a0.p088i0.JsonUtf8Reader;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p095y.LottieCompositionCache;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.JvmOkio;
import p615g0.RealBufferedSource;
import p615g0.Timeout2;

/* JADX INFO: renamed from: b.c.a.e, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory {

    /* JADX INFO: renamed from: a */
    public static final Map<String, LottieTask2<LottieComposition>> f2351a = new HashMap();

    /* JADX INFO: renamed from: b.c.a.e$a */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class a implements LottieListener<LottieComposition> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2352a;

        public a(String str) {
            this.f2352a = str;
        }

        @Override // p007b.p085c.p086a.LottieListener
        /* JADX INFO: renamed from: a */
        public void mo680a(LottieComposition lottieComposition) {
            LottieCompositionFactory.f2351a.remove(this.f2352a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$b */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class b implements LottieListener<Throwable> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2353a;

        public b(String str) {
            this.f2353a = str;
        }

        @Override // p007b.p085c.p086a.LottieListener
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            LottieCompositionFactory.f2351a.remove(this.f2353a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.e$c */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    public class c implements Callable<LottieResult<LottieComposition>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ LottieComposition f2354j;

        public c(LottieComposition lottieComposition) {
            this.f2354j = lottieComposition;
        }

        @Override // java.util.concurrent.Callable
        public LottieResult<LottieComposition> call() throws Exception {
            return new LottieResult<>(this.f2354j);
        }
    }

    /* JADX INFO: renamed from: a */
    public static LottieTask2<LottieComposition> m674a(@Nullable String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            LottieCompositionCache lottieCompositionCache = LottieCompositionCache.f2715a;
            Objects.requireNonNull(lottieCompositionCache);
            lottieComposition = lottieCompositionCache.f2716b.get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask2<>(new c(lottieComposition));
        }
        if (str != null) {
            Map<String, LottieTask2<LottieComposition>> map = f2351a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask2<LottieComposition> lottieTask2 = new LottieTask2<>(callable);
        if (str != null) {
            lottieTask2.m706b(new a(str));
            lottieTask2.m705a(new b(str));
            f2351a.put(str, lottieTask2);
        }
        return lottieTask2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public static LottieResult<LottieComposition> m675b(InputStream inputStream, @Nullable String str) {
        try {
            Intrinsics3.checkParameterIsNotNull(inputStream, "$this$source");
            JvmOkio jvmOkio = new JvmOkio(inputStream, new Timeout2());
            Intrinsics3.checkParameterIsNotNull(jvmOkio, "$this$buffer");
            RealBufferedSource realBufferedSource = new RealBufferedSource(jvmOkio);
            String[] strArr = JsonReader2.f2236j;
            return m676c(new JsonUtf8Reader(realBufferedSource), str, true);
        } finally {
            Utils.m658b(inputStream);
        }
    }

    /* JADX INFO: renamed from: c */
    public static LottieResult<LottieComposition> m676c(JsonReader2 jsonReader2, @Nullable String str, boolean z2) {
        try {
            try {
                LottieComposition lottieCompositionM635a = LottieCompositionMoshiParser.m635a(jsonReader2);
                if (str != null) {
                    LottieCompositionCache lottieCompositionCache = LottieCompositionCache.f2715a;
                    Objects.requireNonNull(lottieCompositionCache);
                    lottieCompositionCache.f2716b.put(str, lottieCompositionM635a);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(lottieCompositionM635a);
                if (z2) {
                    Utils.m658b(jsonReader2);
                }
                return lottieResult;
            } catch (Exception e) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e);
                if (z2) {
                    Utils.m658b(jsonReader2);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z2) {
                Utils.m658b(jsonReader2);
            }
            throw th;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: d */
    public static LottieResult<LottieComposition> m677d(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return m678e(zipInputStream, str);
        } finally {
            Utils.m658b(zipInputStream);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: e */
    public static LottieResult<LottieComposition> m678e(ZipInputStream zipInputStream, @Nullable String str) {
        LottieImageAsset next;
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    Intrinsics3.checkParameterIsNotNull(zipInputStream, "$this$source");
                    JvmOkio jvmOkio = new JvmOkio(zipInputStream, new Timeout2());
                    Intrinsics3.checkParameterIsNotNull(jvmOkio, "$this$buffer");
                    RealBufferedSource realBufferedSource = new RealBufferedSource(jvmOkio);
                    String[] strArr = JsonReader2.f2236j;
                    lottieComposition = m676c(new JsonUtf8Reader(realBufferedSource), null, false).f2449a;
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<LottieImageAsset> it = lottieComposition.f2339d.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.f2417d.equals(str2)) {
                        break;
                    }
                }
                if (next != null) {
                    next.f2418e = Utils.m661e((Bitmap) entry.getValue(), next.f2414a, next.f2415b);
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.f2339d.entrySet()) {
                if (entry2.getValue().f2418e == null) {
                    StringBuilder sbM833U = outline.m833U("There is no image for ");
                    sbM833U.append(entry2.getValue().f2417d);
                    return new LottieResult<>((Throwable) new IllegalStateException(sbM833U.toString()));
                }
            }
            if (str != null) {
                LottieCompositionCache lottieCompositionCache = LottieCompositionCache.f2715a;
                Objects.requireNonNull(lottieCompositionCache);
                lottieCompositionCache.f2716b.put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m679f(Context context, @RawRes int i) {
        StringBuilder sbM833U = outline.m833U("rawRes");
        sbM833U.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sbM833U.append(i);
        return sbM833U.toString();
    }
}
