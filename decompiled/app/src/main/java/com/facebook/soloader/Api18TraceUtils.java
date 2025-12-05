package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p190m.DoNotOptimize;

@DoNotOptimize
@TargetApi(18)
/* loaded from: classes3.dex */
public class Api18TraceUtils {
    /* renamed from: a */
    public static void m8727a(String str, String str2, String str3) {
        String strM886y = outline.m886y(str, str2, str3);
        if (strM886y.length() > 127 && str2 != null) {
            int length = (Opcodes.LAND - str.length()) - str3.length();
            StringBuilder sbM833U = outline.m833U(str);
            sbM833U.append(str2.substring(0, length));
            sbM833U.append(str3);
            strM886y = sbM833U.toString();
        }
        Trace.beginSection(strM886y);
    }
}
