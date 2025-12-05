package p007b.p008a.p041q.p044m0.p045c;

import androidx.annotation.NonNull;
import co.discord.media_engine.DeviceDescription4;
import com.hammerandchisel.libdiscord.Discord;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MediaEngineLegacy.kt */
/* renamed from: b.a.q.m0.c.s */
/* loaded from: classes.dex */
public final class C1241s implements Discord.GetVideoInputDevicesCallback {

    /* renamed from: a */
    public final /* synthetic */ Function1 f1755a;

    public C1241s(Function1 function1) {
        this.f1755a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetVideoInputDevicesCallback
    public final /* synthetic */ void onDevices(@NonNull DeviceDescription4[] deviceDescription4Arr) {
        Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p0");
        Intrinsics3.checkNotNullExpressionValue(this.f1755a.invoke(deviceDescription4Arr), "invoke(...)");
    }
}
