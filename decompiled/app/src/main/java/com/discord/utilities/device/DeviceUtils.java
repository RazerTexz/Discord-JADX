package com.discord.utilities.device;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import java.util.Iterator;
import java.util.Set;
import p507d0.p579g0.Strings4;
import p507d0.p580t.SetsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DeviceUtils.kt */
/* loaded from: classes2.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final int SMALL_SCREEN_WIDTH_DP = 360;

    private DeviceUtils() {
    }

    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return deviceUtils.isDevice(str, num, str2);
    }

    public final boolean canDrawOverlays(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
    }

    public final boolean isDevice(String manufacturer, Integer versionCode, String model) {
        return isDevice(manufacturer != null ? SetsJVM.setOf(manufacturer) : null, versionCode != null ? SetsJVM.setOf(Integer.valueOf(versionCode.intValue())) : null, model != null ? SetsJVM.setOf(model) : null);
    }

    public final boolean isSmallScreen(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return ((float) resources.getDisplayMetrics().widthPixels) <= ((float) SMALL_SCREEN_WIDTH_DP) * resources.getDisplayMetrics().density;
    }

    public final boolean isTablet(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = null;
        }
        if ((i & 2) != 0) {
            set2 = null;
        }
        if ((i & 4) != 0) {
            set3 = null;
        }
        return deviceUtils.isDevice((Set<String>) set, (Set<Integer>) set2, (Set<String>) set3);
    }

    public final boolean isDevice(Set<String> manufacturers, Set<Integer> versionCodes, Set<String> models) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (manufacturers == null) {
            z2 = true;
            break;
        }
        if (!manufacturers.isEmpty()) {
            for (String str : manufacturers) {
                String str2 = Build.MANUFACTURER;
                Intrinsics3.checkNotNullExpressionValue(str2, "Build.MANUFACTURER");
                if (Strings4.contains((CharSequence) str2, (CharSequence) str, true)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (versionCodes == null) {
            z3 = true;
            break;
        }
        if (!versionCodes.isEmpty()) {
            Iterator<T> it = versionCodes.iterator();
            while (it.hasNext()) {
                if (Build.VERSION.SDK_INT == ((Number) it.next()).intValue()) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (models == null) {
            z4 = true;
            break;
        }
        if (!models.isEmpty()) {
            for (String str3 : models) {
                String str4 = Build.MODEL;
                Intrinsics3.checkNotNullExpressionValue(str4, "Build.MODEL");
                if (Strings4.contains((CharSequence) str4, (CharSequence) str3, true)) {
                    z4 = true;
                    break;
                }
            }
        }
        z4 = false;
        return z2 && z3 && z4;
    }
}
