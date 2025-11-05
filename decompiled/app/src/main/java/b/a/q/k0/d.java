package b.a.q.k0;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothHeadset;
import d0.z.d.o;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: BluetoothHeadsetPrivateApi.kt */
@SuppressLint({"DiscouragedPrivateApi"})
/* loaded from: classes.dex */
public final class d {
    public static final Lazy a = d0.g.lazy(a.j);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f263b = d0.g.lazy(b.j);
    public static final d c = null;

    /* compiled from: BluetoothHeadsetPrivateApi.kt */
    public static final class a extends o implements Function0<String> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            try {
                Object obj = BluetoothHeadset.class.getField("ACTION_ACTIVE_DEVICE_CHANGED").get(null);
                if (!(obj instanceof String)) {
                    obj = null;
                }
                return (String) obj;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: BluetoothHeadsetPrivateApi.kt */
    public static final class b extends o implements Function0<Method> {
        public static final b j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Method invoke() {
            try {
                return BluetoothHeadset.class.getDeclaredMethod("getActiveDevice", new Class[0]);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
