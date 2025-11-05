package b.a.d;

import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.app.AppPermissionsRequests;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppPermissions.kt */
/* loaded from: classes.dex */
public final class h implements AppPermissionsRequests {

    @Deprecated
    public static final HashMap<Integer, String[]> j;
    public static final a k = new a(null);
    public Function0<Unit> l;
    public Function1<? super Map<String, Boolean>, Unit> m;
    public long n;
    public final ActivityResultLauncher<String[]> o;
    public final ComponentActivity p;

    /* compiled from: AppPermissions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class b<O> implements ActivityResultCallback<Map<String, Boolean>> {
        public b() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            if (map2.containsValue(Boolean.FALSE)) {
                Function1<? super Map<String, Boolean>, Unit> function1 = h.this.m;
                if (function1 != null) {
                    d0.z.d.m.checkNotNullExpressionValue(map2, "grantResults");
                    function1.invoke(map2);
                }
            } else {
                Function0<Unit> function0 = h.this.l;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            h hVar = h.this;
            hVar.m = null;
            hVar.l = null;
            hVar.n = 0L;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class c extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            d0.z.d.m.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                h.a(h.this, R.string.permission_qr_scanner_denied);
            }
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class d extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            d0.z.d.m.checkNotNullParameter(map, "it");
            this.$onFailure.invoke();
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class e extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            d0.z.d.m.checkNotNullParameter(map, "it");
            h.a(h.this, R.string.permission_media_denied);
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class f extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            d0.z.d.m.checkNotNullParameter(map, "it");
            h.a(h.this, R.string.permission_media_download_denied);
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class g extends d0.z.d.o implements Function0<Unit> {
        public final /* synthetic */ boolean $hadPermissions;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z2, Function0 function0) {
            super(0);
            this.$hadPermissions = z2;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!this.$hadPermissions) {
                StoreStream.INSTANCE.getMediaEngine().handleMicrophonePermissionGranted();
            }
            StoreStream.INSTANCE.getMediaEngine().setAudioInputEnabled(true);
            this.$onSuccess.invoke();
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    /* renamed from: b.a.d.h$h, reason: collision with other inner class name */
    public static final class C0030h extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0030h(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            d0.z.d.m.checkNotNullParameter(map, "it");
            Function0 function0 = this.$onFailure;
            if (function0 == null || ((Unit) function0.invoke()) == null) {
                h.a(h.this, R.string.permission_microphone_denied);
            }
            return Unit.a;
        }
    }

    /* compiled from: AppPermissions.kt */
    public static final class i extends d0.z.d.o implements Function1<Map<String, ? extends Boolean>, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Map<String, ? extends Boolean> map) {
            Map<String, ? extends Boolean> map2 = map;
            d0.z.d.m.checkNotNullParameter(map2, "grantResults");
            Boolean bool = map2.get("android.permission.RECORD_AUDIO");
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                Boolean bool2 = map2.get("android.permission.CAMERA");
                if (bool2 == null) {
                    bool2 = Boolean.FALSE;
                }
                if (bool2.booleanValue()) {
                    h.a(h.this, R.string.no_camera_access);
                } else {
                    h.a(h.this, R.string.no_camera_access);
                }
            } else {
                h.a(h.this, R.string.permission_microphone_denied);
            }
            return Unit.a;
        }
    }

    static {
        HashMap<Integer, String[]> map = new HashMap<>();
        j = map;
        map.put(211, new String[]{"android.permission.RECORD_AUDIO"});
        map.put(210, new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"});
        map.put(222, new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(213, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        map.put(214, new String[]{"android.permission.CAMERA"});
        map.put(215, new String[]{"android.permission.READ_CONTACTS"});
    }

    public h(ComponentActivity componentActivity) {
        d0.z.d.m.checkNotNullParameter(componentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.p = componentActivity;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = componentActivity.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new b());
        d0.z.d.m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "activity.registerForActi…rtTimeMillis = 0L\n      }");
        this.o = activityResultLauncherRegisterForActivityResult;
    }

    public static final void a(h hVar, int i2) {
        m.g(hVar.p, i2, 0, null, 12);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(int i2) {
        String[] strArr = j.get(Integer.valueOf(i2));
        if (strArr == null) {
            return false;
        }
        d0.z.d.m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return false");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i3 >= length) {
                break;
            }
            String str = strArr[i3];
            if (d0.z.d.m.areEqual(str, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (!(Build.VERSION.SDK_INT < 29)) {
                }
            } else if (ContextCompat.checkSelfPermission(this.p, str) != 0) {
                z2 = false;
            }
            arrayList.add(Boolean.valueOf(z2));
            i3++;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void c(int i2, Function0<Unit> function0, Function1<? super Map<String, Boolean>, Unit> function1) {
        String[] strArr = j.get(Integer.valueOf(i2));
        if (strArr != null) {
            d0.z.d.m.checkNotNullExpressionValue(strArr, "PERMISSION_GROUPS[requestCode] ?: return");
            if (b(i2)) {
                function0.invoke();
                return;
            }
            if (ClockFactory.get().currentTimeMillis() - this.n < 350) {
                return;
            }
            this.l = function0;
            this.m = function1;
            this.n = ClockFactory.get().currentTimeMillis();
            this.o.launch(strArr);
        }
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public boolean hasMedia() {
        return b(222);
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0, Function0<Unit> function02) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(214, function0, new c(function02));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestContacts(Function0<Unit> function0, Function0<Unit> function02) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        d0.z.d.m.checkNotNullParameter(function02, "onFailure");
        c(215, function0, new d(function02));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMedia(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(222, function0, new e());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMediaDownload(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(213, function0, new f());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestMicrophone(Function0<Unit> function0, Function0<Unit> function02) {
        d0.z.d.m.checkNotNullParameter(function02, "onSuccess");
        c(211, new g(b(211), function02), new C0030h(function0));
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestVideoCallPermissions(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        c(210, function0, new i());
    }

    @Override // com.discord.app.AppPermissionsRequests
    @MainThread
    public void requestCameraQRScanner(Function0<Unit> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "onSuccess");
        requestCameraQRScanner(function0, null);
    }
}
