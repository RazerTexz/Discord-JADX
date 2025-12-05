package com.discord.utilities.buildutils;

import kotlin.text.Regex;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BuildUtils.kt */
/* loaded from: classes2.dex */
public final class BuildUtils {
    public static final BuildUtils INSTANCE = new BuildUtils();

    private BuildUtils() {
    }

    public final boolean isValidBuildVersionName(String versionName) {
        Intrinsics3.checkNotNullParameter(versionName, "versionName");
        return new Regex("^\\d+[.]\\d+ - (Dev|Alpha|Beta|Stable)$").matches(versionName);
    }
}
