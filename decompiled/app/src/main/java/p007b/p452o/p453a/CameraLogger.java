package p007b.p452o.p453a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: CameraLogger.java */
/* renamed from: b.o.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class CameraLogger {

    /* renamed from: a */
    public static int f13678a;

    /* renamed from: b */
    public static Set<b> f13679b;

    /* renamed from: c */
    @VisibleForTesting
    public static b f13680c;

    /* renamed from: d */
    @NonNull
    public String f13681d;

    /* compiled from: CameraLogger.java */
    /* renamed from: b.o.a.b$a */
    public class a implements b {
        @Override // p007b.p452o.p453a.CameraLogger.b
        /* renamed from: a */
        public void mo7160a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
            if (i == 0) {
                Log.v(str, str2, th);
                return;
            }
            if (i == 1) {
                Log.i(str, str2, th);
            } else if (i == 2) {
                Log.w(str, str2, th);
            } else {
                if (i != 3) {
                    return;
                }
                Log.e(str, str2, th);
            }
        }
    }

    /* compiled from: CameraLogger.java */
    /* renamed from: b.o.a.b$b */
    public interface b {
        /* renamed from: a */
        void mo7160a(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f13679b = copyOnWriteArraySet;
        a aVar = new a();
        f13680c = aVar;
        f13678a = 3;
        copyOnWriteArraySet.add(aVar);
    }

    public CameraLogger(@NonNull String str) {
        this.f13681d = str;
    }

    @Nullable
    /* renamed from: a */
    public final String m7159a(int i, @NonNull Object... objArr) {
        Throwable th = null;
        if (!(f13678a <= i && f13679b.size() > 0)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj instanceof Throwable) {
                th = (Throwable) obj;
            }
            sb.append(String.valueOf(obj));
            sb.append(" ");
        }
        String strTrim = sb.toString().trim();
        Iterator<b> it = f13679b.iterator();
        while (it.hasNext()) {
            it.next().mo7160a(i, this.f13681d, strTrim, th);
        }
        return strTrim;
    }
}
