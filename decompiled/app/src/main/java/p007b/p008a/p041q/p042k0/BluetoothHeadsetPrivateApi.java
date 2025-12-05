package p007b.p008a.p041q.p042k0;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothHeadset;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Lambda;

/* compiled from: BluetoothHeadsetPrivateApi.kt */
@SuppressLint({"DiscouragedPrivateApi"})
/* renamed from: b.a.q.k0.d, reason: use source file name */
/* loaded from: classes.dex */
public final class BluetoothHeadsetPrivateApi {

    /* renamed from: a */
    public static final Lazy f1653a = LazyJVM.lazy(a.f1656j);

    /* renamed from: b */
    public static final Lazy f1654b = LazyJVM.lazy(b.f1657j);

    /* renamed from: c */
    public static final BluetoothHeadsetPrivateApi f1655c = null;

    /* compiled from: BluetoothHeadsetPrivateApi.kt */
    /* renamed from: b.a.q.k0.d$a */
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: j */
        public static final a f1656j = new a();

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
    /* renamed from: b.a.q.k0.d$b */
    public static final class b extends Lambda implements Function0<Method> {

        /* renamed from: j */
        public static final b f1657j = new b();

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
