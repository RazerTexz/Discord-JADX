package com.discord.utilities.sms;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.j.k0;
import b.i.a.f.e.h.j.p;
import b.i.a.f.h.b.b;
import b.i.a.f.h.b.h;
import b.i.a.f.h.b.j;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.widgets.auth.SmsAuthCodeBroadcastReceiver;
import com.google.android.gms.common.Feature;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SmsListener.kt */
/* loaded from: classes2.dex */
public final class SmsListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BroadcastReceiver broadcastReceiver;

    /* compiled from: SmsListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BroadcastReceiver getBroadcastReceiver() {
            return SmsListener.access$getBroadcastReceiver$cp();
        }

        public final void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
            SmsListener.access$setBroadcastReceiver$cp(broadcastReceiver);
        }

        public final void startSmsListener(Function1<? super String, Unit> onSuccess) {
            Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
            Application application = ApplicationProvider.INSTANCE.get();
            h hVar = new h(application);
            p.a aVar = new p.a(null);
            aVar.a = new j(hVar);
            aVar.f1370b = new Feature[]{b.f1404b};
            AnimatableValueParser.o(true, "execute parameter required");
            hVar.c(new k0(aVar, aVar.f1370b, true));
            setBroadcastReceiver(new SmsAuthCodeBroadcastReceiver(onSuccess));
            application.registerReceiver(getBroadcastReceiver(), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        }

        public final void stopSmsListener() {
            try {
                ApplicationProvider.INSTANCE.get().unregisterReceiver(getBroadcastReceiver());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ BroadcastReceiver access$getBroadcastReceiver$cp() {
        return broadcastReceiver;
    }

    public static final /* synthetic */ void access$setBroadcastReceiver$cp(BroadcastReceiver broadcastReceiver2) {
        broadcastReceiver = broadcastReceiver2;
    }
}
