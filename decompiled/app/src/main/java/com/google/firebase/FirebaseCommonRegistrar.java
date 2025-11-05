package com.google.firebase;

import android.content.Context;
import android.os.Build;
import b.i.a.f.e.o.f;
import b.i.c.l.d;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.x.b;
import b.i.c.x.e;
import b.i.c.x.h;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements g {
    public static String a(String str) {
        return str.replace(' ', '_').replace(MentionUtilsKt.SLASH_CHAR, '_');
    }

    @Override // b.i.c.l.g
    public List<d<?>> getComponents() {
        String string;
        ArrayList arrayList = new ArrayList();
        d.b bVarA = d.a(h.class);
        bVarA.a(new o(e.class, 2, 0));
        bVarA.c(b.a);
        arrayList.add(bVarA.b());
        d.b bVarA2 = d.a(b.i.c.r.d.class);
        bVarA2.a(new o(Context.class, 1, 0));
        bVarA2.c(b.i.c.r.b.a);
        arrayList.add(bVarA2.b());
        arrayList.add(f.N("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(f.N("fire-core", "19.4.0"));
        arrayList.add(f.N("device-name", a(Build.PRODUCT)));
        arrayList.add(f.N("device-model", a(Build.DEVICE)));
        arrayList.add(f.N("device-brand", a(Build.BRAND)));
        arrayList.add(f.b0("android-target-sdk", b.i.c.d.a));
        arrayList.add(f.b0("android-min-sdk", b.i.c.e.a));
        arrayList.add(f.b0("android-platform", b.i.c.f.a));
        arrayList.add(f.b0("android-installer", b.i.c.g.a));
        try {
            string = d0.e.j.toString();
        } catch (NoClassDefFoundError unused) {
            string = null;
        }
        if (string != null) {
            arrayList.add(f.N("kotlin", string));
        }
        return arrayList;
    }
}
