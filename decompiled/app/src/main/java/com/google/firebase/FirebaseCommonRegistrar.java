package com.google.firebase;

import android.content.Context;
import android.os.Build;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseCommonRegistrar2;
import p007b.p225i.p361c.FirebaseCommonRegistrar3;
import p007b.p225i.p361c.FirebaseCommonRegistrar4;
import p007b.p225i.p361c.FirebaseCommonRegistrar5;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p397r.DefaultHeartBeatInfo2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p407x.DefaultUserAgentPublisher;
import p007b.p225i.p361c.p407x.LibraryVersion;
import p007b.p225i.p361c.p407x.UserAgentPublisher;
import p507d0.KotlinVersion;

/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* renamed from: a */
    public static String m9175a(String str) {
        return str.replace(' ', '_').replace(MentionUtils.SLASH_CHAR, '_');
    }

    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        String string;
        ArrayList arrayList = new ArrayList();
        Component4.b bVarM6348a = Component4.m6348a(UserAgentPublisher.class);
        bVarM6348a.m6351a(new Dependency2(LibraryVersion.class, 2, 0));
        bVarM6348a.m6353c(DefaultUserAgentPublisher.f13081a);
        arrayList.add(bVarM6348a.m6352b());
        Component4.b bVarM6348a2 = Component4.m6348a(HeartBeatInfo.class);
        bVarM6348a2.m6351a(new Dependency2(Context.class, 1, 0));
        bVarM6348a2.m6353c(DefaultHeartBeatInfo2.f12834a);
        arrayList.add(bVarM6348a2.m6352b());
        arrayList.add(C3404f.m4228N("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(C3404f.m4228N("fire-core", "19.4.0"));
        arrayList.add(C3404f.m4228N("device-name", m9175a(Build.PRODUCT)));
        arrayList.add(C3404f.m4228N("device-model", m9175a(Build.DEVICE)));
        arrayList.add(C3404f.m4228N("device-brand", m9175a(Build.BRAND)));
        arrayList.add(C3404f.m4272b0("android-target-sdk", FirebaseCommonRegistrar2.f12130a));
        arrayList.add(C3404f.m4272b0("android-min-sdk", FirebaseCommonRegistrar3.f12131a));
        arrayList.add(C3404f.m4272b0("android-platform", FirebaseCommonRegistrar4.f12132a));
        arrayList.add(C3404f.m4272b0("android-installer", FirebaseCommonRegistrar5.f12133a));
        try {
            string = KotlinVersion.f22290j.toString();
        } catch (NoClassDefFoundError unused) {
            string = null;
        }
        if (string != null) {
            arrayList.add(C3404f.m4228N("kotlin", string));
        }
        return arrayList;
    }
}
